package com.example.e__manager.views.activities;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.e__manager.adapter.TransactionAdapter;
import com.example.e__manager.utils.Constants;
import com.example.e__manager.utils.Helper;
import com.example.e__manager.views.fragments.AddTransactionFragment;
import com.example.e__manager.R;
import com.example.e__manager.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("Transactions");

        Constants.setCategory();

        calendar = Calendar.getInstance();
        updateDate();

        binding.nextDate.setOnClickListener(c -> {
            calendar.add(Calendar.DATE, 1);
            updateDate();
        });

        binding.previousDate.setOnClickListener(c -> {
            calendar.add(Calendar.DATE, -1);
            updateDate();
        });

        binding.floatingActionButton.setOnClickListener(c -> {
            new AddTransactionFragment().show(getSupportFragmentManager(), null);
        });

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(Constants.INCOME, "Business", "Cash", "Some note here", new Date(), 500, 2));
        transactions.add(new Transaction(Constants.EXPENSE, "Investment", "Bank", "Some note here", new Date(), -900, 4));
        transactions.add(new Transaction(Constants.INCOME, "Rent", "Other", "Some note here", new Date(), 500, 5));
        transactions.add(new Transaction(Constants.INCOME, "Business", "Card", "Some note here", new Date(), 500, 6));

        TransactionAdapter transactionAdapter = new TransactionAdapter(this, transactions);
        binding.transactionsList.setLayoutManager(new LinearLayoutManager(this));
        binding.transactionsList.setAdapter(transactionAdapter);
    }

    void updateDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM,yyyy");
        binding.currentdate.setText(Helper.formateDate(calendar.getTime()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
}
}

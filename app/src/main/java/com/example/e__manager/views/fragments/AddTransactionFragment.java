package com.example.e__manager.views.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.e__manager.R;
import com.example.e__manager.adapter.AccountAdapters;
import com.example.e__manager.adapter.CategoryAdapter;
import com.example.e__manager.databinding.FragmentAddTransactionBinding;
import com.example.e__manager.databinding.ListDialogBinding;
import com.example.e__manager.models.Account;
import com.example.e__manager.models.Category;
import com.example.e__manager.utils.Constants;
import com.example.e__manager.utils.Helper;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class AddTransactionFragment extends BottomSheetDialogFragment {


    public AddTransactionFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    FragmentAddTransactionBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentAddTransactionBinding.inflate(inflater);

        binding.incomeBtn.setOnClickListener(c -> {
            binding.incomeBtn.setBackground(getContext().getDrawable(R.drawable.income_selector));
            binding.expenseBtn.setBackground(getContext().getDrawable(R.drawable.default_selector));
            binding.expenseBtn.setTextColor(getContext().getColor(R.color.textcolor));
            binding.incomeBtn.setTextColor(getContext().getColor(R.color.greencolor));

        });
        binding.expenseBtn.setOnClickListener(c -> {
            binding.incomeBtn.setBackground(getContext().getDrawable(R.drawable.default_selector));
            binding.expenseBtn.setBackground(getContext().getDrawable(R.drawable.expense_selector));
            binding.incomeBtn.setTextColor(getContext().getColor(R.color.textcolor));
            binding.expenseBtn.setTextColor(getContext().getColor(R.color.redcolor));

        });
        binding.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(getContext());
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(calendar.DAY_OF_MONTH,datePicker.getDayOfMonth());
                        calendar.set(calendar.MONTH,datePicker.getMonth());
                        calendar.set(calendar.YEAR,datePicker.getYear());

                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
                        String dateToShow = Helper.formateDate(calendar.getTime());
                        binding.date.setText(dateToShow);


                    }
                });
                datePickerDialog.show();
            }
        });

        binding.category.setOnClickListener(c -> {
            ListDialogBinding dialogBinding = ListDialogBinding.inflate(inflater);
            AlertDialog categoryDialog = new AlertDialog.Builder(getContext()).create();
            categoryDialog.setView(dialogBinding.getRoot());

           /* ArrayList<Category> categories = new ArrayList<>();
            categories.add(new Category("salary",R.drawable.ic_salary,R.color.category1));
            categories.add(new Category("Business",R.drawable.ic_business,R.color.category2));
            categories.add(new Category("Investment",R.drawable.ic_investment,R.color.category3));
            categories.add(new Category("Loan",R.drawable.ic_loan,R.color.category4));
            categories.add(new Category("Rent",R.drawable.ic_rent,R.color.category5));
            categories.add(new Category("Other",R.drawable.ic_other,R.color.category6));
          */

            CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(), Constants.categories, new CategoryAdapter.CategoryClicklistener() {
                @Override
                public void onCategoryClicked(Category category) {
                    binding.category.setText(category.getCategoryName());
                    categoryDialog.dismiss();
                }
            });
            dialogBinding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
            dialogBinding.recyclerView.setAdapter(categoryAdapter);

            categoryDialog.show();

        });

        binding.account.setOnClickListener( c-> {

            ListDialogBinding dialogBinding = ListDialogBinding.inflate(inflater);
            AlertDialog accountsDialog = new AlertDialog.Builder(getContext()).create();
            accountsDialog.setView(dialogBinding.getRoot());

            ArrayList<Account> accounts = new ArrayList<>();
            accounts.add(new Account(0,"cash"));
            accounts.add(new Account(0,"Bank"));
            accounts.add(new Account(0,"paytm"));
            accounts.add(new Account(0,"Google Pay"));
            accounts.add(new Account(0,"Other"));

            AccountAdapters accountAdapters = new AccountAdapters(getContext(), accounts, new AccountAdapters.AccountsClickListener() {
                @Override
                public void onAccountSelected(Account account) {
                    binding.account.setText(account.getAccountName());
                    accountsDialog.dismiss();
                }
            });

            dialogBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            dialogBinding.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
            dialogBinding.recyclerView.setAdapter(accountAdapters);

            accountsDialog.show();


        });
        return binding.getRoot();
    }
}
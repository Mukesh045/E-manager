package com.example.e__manager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e__manager.R;
import com.example.e__manager.databinding.RowTransactionBinding;
import com.example.e__manager.models.Category;
import com.example.e__manager.utils.Constants;
import com.example.e__manager.utils.Helper;
import com.example.e__manager.views.activities.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    Context context;

    ArrayList<Transaction> transactions;

    public TransactionAdapter(Context context, ArrayList<Transaction> transactions) {
        this.context = context;
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TransactionViewHolder(LayoutInflater.from(context).inflate(R.layout.row_transaction, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {

        Transaction transaction = transactions.get(position);
        holder.binding.transactionAmount.setText(String.valueOf(transaction.getAmount()));
        holder.binding.accountLbl.setText(transaction.getAccount());

        holder.binding.transaction1.setText(Helper.formateDate(transaction.getDate()));
        holder.binding.transactionCategory.setText(transaction.getCategory());

        Category transactioncategory = Constants.getCategoryDetails(transaction.getCategory());

        //assert transactioncategory != null;
        holder.binding.categoryIcon.setImageResource(transactioncategory.getCategoryImage());
        holder.binding.categoryIcon.setBackgroundTintList(context.getColorStateList(transactioncategory.getCategorycolor()));

        holder.binding.accountLbl.setBackgroundTintList(context.getColorStateList(Constants.getAccountscolor(transaction.getAccount())));

        if(transaction.getType().equals(Constants.INCOME)) {
            holder.binding.transactionAmount.setTextColor(context.getColor(R.color.greencolor));
        } else if (transaction.getType().equals(Constants.EXPENSE)) {
            holder.binding.transactionAmount.setTextColor(context.getColor(R.color.redcolor));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position, @NonNull List<Object> payloads) {

    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public  class TransactionViewHolder extends RecyclerView.ViewHolder {
        RowTransactionBinding binding;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RowTransactionBinding.bind(itemView);
        }
    }
}


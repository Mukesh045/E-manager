package com.example.e__manager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e__manager.R;
import com.example.e__manager.databinding.RowAccountBinding;
import com.example.e__manager.models.Account;

import java.util.ArrayList;

public class AccountAdapters extends RecyclerView.Adapter<AccountAdapters.AccountViewHolder>  {

    Context context;
    ArrayList<Account> accountArrayList;

    public interface AccountsClickListener {
        void onAccountSelected(Account account);
    }

    AccountsClickListener accountsClickListener;

    public AccountAdapters(Context context, ArrayList<Account> accountArrayList,AccountsClickListener accountsClickListener) {
        this.context = context;
        this.accountArrayList = accountArrayList;
        this.accountsClickListener = accountsClickListener;
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AccountViewHolder(LayoutInflater.from(context).inflate(R.layout.row_account,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder holder, int position) {
        Account account = accountArrayList.get(position);
        holder.binding.accountName.setText(account.getAccountName());
        holder.itemView.setOnClickListener( c-> {
            accountsClickListener.onAccountSelected(account);

        });

    }

    @Override
    public int getItemCount() {
        return accountArrayList.size();
    }

    public class AccountViewHolder extends RecyclerView.ViewHolder{

        RowAccountBinding binding;
        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RowAccountBinding.bind(itemView);
        }
    }
}


package com.example.e__manager.views.activities;

import java.util.Date;

public class Transaction {

    private static String type;
    private String category;
    private String account;
    private String note;
    private com.example.e__manager.models.date date;
    private double amount;

    private long id;
    private java.util.Date Date;

    public Transaction(String type, String category, String account, String note, java.util.Date date, int amount, int id) {
    }

    public Transaction(String type, String category, String account, String note, com.example.e__manager.models.date date, double amount, long id) {
        this.type = type;
        this.category = category;
        this.account = account;
        this.note = note;
        this.date = date;
        this.amount = amount;
        this.id = id;
    }

    public static String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public java.util.Date getDate() {
        java.util.Date date1;
        return Date;
    }

    public void setDate(com.example.e__manager.models.date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

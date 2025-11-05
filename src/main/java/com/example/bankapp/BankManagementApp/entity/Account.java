package com.example.bankapp.BankManagementApp.entity;

import jakarta.persistence.*;

@Entity
@Table //if you want to name your table as something else tye-> @Table(name="abc")
public class Account {
    @Id //marked as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //just like auto increment
    private long account_number;
    @Column
    private String account_holder_name;
    @Column
    private Double account_balance;

//    constructor
    public Account(){

    }

//    parameterised constructor

    public Account(String account_holder_name, Double account_balance) {
        super();
        this.account_holder_name = account_holder_name;
        this.account_balance = account_balance;
    }


//    getters and setter

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public String getAccount_holder_name() {
        return account_holder_name;
    }

    public void setAccount_holder_name(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }

    public Double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(Double account_balance) {
        this.account_balance = account_balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_number=" + account_number +
                ", account_holder_name='" + account_holder_name + '\'' +
                ", account_balance=" + account_balance +
                '}';
    }
}

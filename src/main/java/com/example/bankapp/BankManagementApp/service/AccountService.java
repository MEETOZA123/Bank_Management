package com.example.bankapp.BankManagementApp.service;

import com.example.bankapp.BankManagementApp.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public Account createAccount(Account account);
    public Optional<Account> getAccountDetailsByAccountNumber(Long account_number);
    public List<Account> getALLAccountDetails();
    public Account depositAmount(Long accountNumber,Double amount);
    public Account withdrawAmount(Long accountNumber,Double amount);
    public void closeAccount(Long account_number);
}

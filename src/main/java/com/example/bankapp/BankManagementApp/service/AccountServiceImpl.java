package com.example.bankapp.BankManagementApp.service;

import com.example.bankapp.BankManagementApp.entity.Account;
import com.example.bankapp.BankManagementApp.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository repo;

    @Override
    public Account createAccount(Account account) {
        Account saved;
        saved = repo.save(account);
        return saved;
    }

    @Override
    public Account getAccountDetailsByAccountNumber(Long account_number) {
        return null;
    }

    @Override
    public List<Account> getALLAccountDetails() {
        return List.of();
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        return null;
    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) {
        return null;
    }

    @Override
    public void closeAccount(Long account_number) {

    }
}

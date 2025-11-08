package com.example.bankapp.BankManagementApp.service;

import com.example.bankapp.BankManagementApp.entity.Account;
import com.example.bankapp.BankManagementApp.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Account> getAccountDetailsByAccountNumber(Long account_number) {
        Optional<Account> account;
        account=repo.findById(account_number);
        return account;
    }

    @Override
    public List<Account> getALLAccountDetails() {
        List<Account> allDetails;
        allDetails=repo.findAll();
        return allDetails;
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        Account account = repo.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found with number: " + accountNumber));

        Double newBalance=account.getAccount_balance()+amount;
        account.setAccount_balance(newBalance);

        repo.save(account);

        return account;
    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) {
        Account account = repo.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found with number: " + accountNumber));

        Double newValue=account.getAccount_balance()-amount;
        if(newValue<0){
            throw new RuntimeException("Account not found with number: " + accountNumber);
        }

        account.setAccount_balance(newValue);
        repo.save(account);
        return account;

    }

    @Override
    public void closeAccount(Long account_number) {
        repo.deleteById(account_number);
        return;
    }
}

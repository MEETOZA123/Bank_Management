package com.example.bankapp.BankManagementApp.controller;

import com.example.bankapp.BankManagementApp.entity.Account;
import com.example.bankapp.BankManagementApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {
//    all the rest api required
    @Autowired
    AccountService service;

//    1. create the account
    @PostMapping("/create") //post is for create and get for read
    public Account createAccount(@RequestBody Account account){
        Account createdAccount;
        createdAccount = service.createAccount(account);
        return createdAccount;
    }

    @GetMapping("/allAccounts")
    public List<Account> getAllAccounts(){
        List<Account>allDetails;
        allDetails=service.getALLAccountDetails();
        return allDetails;
    }

    @GetMapping("/getAccount/{account_number}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long account_number){
        Optional<Account> account;
        account=service.getAccountDetailsByAccountNumber(account_number);
        return account.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updateBalance/{account_number}")
    public Account depositRepository(@PathVariable Long account_number, @RequestBody Double amount){
        Account account;
        account=service.depositAmount(account_number,amount);
        return account;
    }


    @PutMapping("/withdraw/{account_number}")
    public Account withdrawAmount(@PathVariable Long account_number,@RequestBody Double amount){
        Account account;
        account=service.withdrawAmount(account_number,amount);
        return account;
    }

    @PutMapping("/delete/{account_number}")
    public String closeAccount(@PathVariable Long account_number){
        service.closeAccount(account_number);
        return "Successfully deleted";
    }
}

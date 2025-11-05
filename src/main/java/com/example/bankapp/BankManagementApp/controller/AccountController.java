package com.example.bankapp.BankManagementApp.controller;

import com.example.bankapp.BankManagementApp.entity.Account;
import com.example.bankapp.BankManagementApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

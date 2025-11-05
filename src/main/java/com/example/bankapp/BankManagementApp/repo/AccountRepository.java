package com.example.bankapp.BankManagementApp.repo;

import com.example.bankapp.BankManagementApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // optional, but recommended
public interface AccountRepository extends JpaRepository<Account, Long> {
}

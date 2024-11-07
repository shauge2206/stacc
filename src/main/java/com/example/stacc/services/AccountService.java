package com.example.stacc.services;

import com.example.stacc.model.Account;
import com.example.stacc.repository.AccountRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  private final AccountRepository accountRepository;

  @Autowired
  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public List<Account> getAccounts() {
    return accountRepository.findAll();
  }

  public Account findAccountById(String id) {
    return accountRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Account with ID " + id + " not found"));
  }
}

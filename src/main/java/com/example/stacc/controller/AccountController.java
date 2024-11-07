package com.example.stacc.controller;

import com.example.stacc.model.Account;
import com.example.stacc.DTO.BalanceResponseDTO;
import com.example.stacc.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Accounts", description = "Controller for retrieval of Account entities based on specified criteria.")
@RestController
@RequestMapping("/api")
public class AccountController {

  private final AccountService accountService;

  @Autowired
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @Operation(summary = "Get account by ID", description = "fetches an account entity using ID")
  @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
  public Account getAccountById(@PathVariable String id) {
    return accountService.findAccountById(id);
  }

  @Operation(summary = "Get account balance by ID", description = "fetches account balance by account ID")
  @RequestMapping(value = "/account/balance/{id}", method = RequestMethod.GET)
  public BalanceResponseDTO getAccountBalanceById(@PathVariable String id) {
    Account account = accountService.findAccountById(id);
    return new BalanceResponseDTO(account.getBalance(), account.getCurrency());
  }
}
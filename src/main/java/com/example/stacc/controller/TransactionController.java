package com.example.stacc.controller;

import com.example.stacc.DTO.AccountActivityDTO;
import com.example.stacc.DTO.TransactionRequestDTO;
import com.example.stacc.DTO.TransactionResponseDTO;
import com.example.stacc.model.Transaction;
import com.example.stacc.services.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Transactions", description = "Controller for retrieval of Transaction entities based on specified criteria.")
@RestController
@RequestMapping("/api")
public class TransactionController {

  private final TransactionService transactionService;

  @Autowired
  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @Operation(summary = "Get all account transactions by account ID", description = "fetches all account transactions connected to account")
  @RequestMapping(value = "/account/transactions/{accountId}", method = RequestMethod.GET)
  public List<TransactionResponseDTO> getTransactionsByAccountId(@PathVariable String accountId) {
    return transactionService.getTransactionsByAccountId(accountId);
  }

  @Operation(summary = "Get last transaction by account ID", description = "fetches last transactions for account")
  @RequestMapping(value = "/account/last-transaction/{accountId}", method = RequestMethod.GET)
  public TransactionResponseDTO getLastTransactionsByAccountId(@PathVariable String accountId) {
    return transactionService.getMostRecentTransaction(accountId);
  }

  @Operation(summary = "Get account activity for account", description = "List of withdrawals or expenses in account")
  @RequestMapping(value = "/account/account-activity/{accountId}", method = RequestMethod.GET)
  public List<AccountActivityDTO> getAccountActivity(@PathVariable String accountId,
      @RequestParam(value = "activityType", required = false) String activityType) {
    return transactionService.getAccountActivity(accountId, activityType);
  }

  @Operation(summary = "Create a new transaction", description = "Creates a new transaction for a specified account")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Transaction created successfully"),
      @ApiResponse(responseCode = "404", description = "Account not found")
  })
  @PostMapping(value = "/account/transaction")
  public Transaction createTransaction(@RequestBody TransactionRequestDTO transactionRequest) {
    return transactionService.createTransaction(transactionRequest);
  }
}


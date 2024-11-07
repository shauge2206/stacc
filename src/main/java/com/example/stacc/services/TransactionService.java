package com.example.stacc.services;

import com.example.stacc.DTO.AccountActivityDTO;
import com.example.stacc.DTO.TransactionRequestDTO;
import com.example.stacc.DTO.TransactionResponseDTO;
import com.example.stacc.model.Account;
import com.example.stacc.model.Goal;
import com.example.stacc.model.Transaction;
import com.example.stacc.repository.AccountRepository;
import com.example.stacc.repository.GoalRepository;
import com.example.stacc.repository.TransactionRepository;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

  private final TransactionRepository transactionRepository;
  private final AccountRepository accountRepository;
  private final GoalRepository goalRepository;

  @Autowired
  public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository,
      GoalRepository goalRepository) {
    this.transactionRepository = transactionRepository;
    this.accountRepository = accountRepository;
    this.goalRepository = goalRepository;
  }

  public List<TransactionResponseDTO> getTransactionsByAccountId(String accountId)
      {
    Account account = accountRepository.findById(accountId)
        .orElseThrow(() -> new NoSuchElementException("Account with ID " + accountId + " not found"));
    return transactionRepository.findByAccountId(account.getId())
        .stream()
        .sorted(Comparator.comparing(Transaction::getDate).reversed())
        .map(transaction -> new TransactionResponseDTO(
            transaction.getId(),
            transaction.getDate(),
            transaction.getDescription(),
            transaction.getAmount(),
            transaction.getCurrency()
        ))
        .collect(Collectors.toList());
  }

  public TransactionResponseDTO getMostRecentTransaction(String accountId) {
    List<TransactionResponseDTO> transactionList = getTransactionsByAccountId(accountId);
    return  transactionList.get((0));
  }

  @Transactional
  public Transaction createTransaction(TransactionRequestDTO dto) {
    String accountId = dto.getAccountId();
    Account account = accountRepository.findById(accountId)
        .orElseThrow(() -> new NoSuchElementException("Account with ID " + accountId + " not found"));

    BigDecimal transactionAmount = dto.getAmount();

    BigDecimal updatedBalance;
    updatedBalance = account.getBalance().add(transactionAmount);

    account.setBalance(updatedBalance);

    Transaction transaction = Transaction.fromDTO(dto, account);

    transaction.setAccount(account);
    transactionRepository.save(transaction);

    Goal goal = goalRepository.findByAccountId(accountId).orElseThrow(() -> new NoSuchElementException("Goal with ID " + accountId + " not found"));
    goal.setAmount(updatedBalance);
    goalRepository.save(goal);
    return transaction;
  }

  public List<AccountActivityDTO> getAccountActivity(String id, String type) {
    List<TransactionResponseDTO> transactions = getTransactionsByAccountId(id);

    List<TransactionResponseDTO> accountActivity = List.of();
    if ("withdrawal".equalsIgnoreCase(type)) {
      accountActivity = transactions.stream()
          .filter(TransactionResponseDTO::getIsWithdrawal)
          .toList();
    } else if ("deposit".equalsIgnoreCase(type)) {
      accountActivity = transactions.stream()
          .filter(t -> !t.getIsWithdrawal())
          .toList();
    }
    return accountActivity.stream().map(t -> new AccountActivityDTO(
      t.getDescription(),
      t.getAmount(),
      t.getDate(),
      t.getCurrency()
    )).collect(Collectors.toList());
  }
}
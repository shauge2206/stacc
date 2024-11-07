package com.example.stacc.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionRequestDTO {

  private String id;
  private LocalDate date;
  private String description;
  private BigDecimal amount;
  private String accountId;

  public TransactionRequestDTO(String id, LocalDate date, String description, BigDecimal amount,
      String currency, String accountId) {
    this.id = id;
    this.date = date;
    this.description = description;
    this.amount = amount;
    this.accountId = accountId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }
}

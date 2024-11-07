package com.example.stacc.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionResponseDTO {

  private String id;
  private LocalDate date;
  private String description;
  private BigDecimal amount;
  private String currency;
  private boolean isWithdrawal;

  public TransactionResponseDTO(String id, LocalDate date, String description, BigDecimal amount,
      String currency) {
    this.id = id;
    this.date = date;
    this.description = description;
    this.amount = amount;
    this.currency = currency;
    this.isWithdrawal = determineIsWithdrawal(amount);
  }

  private boolean determineIsWithdrawal(BigDecimal amount) {
    return amount != null && amount.signum() < 0;
  }
  public String getId() {
    return id;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getDescription() {
    return description;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public String getCurrency() {
    return currency;
  }

  public boolean getIsWithdrawal() {
    return isWithdrawal;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public void setIsWithdrawal(boolean isWithdrawal) {
    this.isWithdrawal = isWithdrawal;
  }
}

package com.example.stacc.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountActivityDTO {

  private String description;
  private BigDecimal amount;
  private LocalDate date;
  private String currency;

  public AccountActivityDTO(String description, BigDecimal amount, LocalDate date, String currency)  {
    this.description = description;
    this.amount = amount;
    this.date = date;
    this.currency = currency;
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

  public BigDecimal getAmount() {
    return amount;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}

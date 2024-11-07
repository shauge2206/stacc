package com.example.stacc.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;

public class BalanceResponseDTO {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "#0.00")
  private BigDecimal balance;
  private String currency;

  public BalanceResponseDTO(BigDecimal balance, String currency) {
    this.balance = balance;
    this.currency = currency;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public String getCurrency() {
    return currency;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}

package com.example.stacc.DTO;

import java.math.BigDecimal;

public class GoalResponseDTO {

  private String id;
  private String description;
  private BigDecimal targetAmount;
  private BigDecimal amount;
  private String currency;

  public GoalResponseDTO(String id, String description, BigDecimal targetAmount, BigDecimal amount,
      String currency) {
    this.id = id;
    this.description = description;
    this.targetAmount = targetAmount;
    this.amount = amount;
    this.currency = currency;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getTargetAmount() {
    return targetAmount;
  }

  public void setTargetAmount(BigDecimal targetAmount) {
    this.targetAmount = targetAmount;
  }

  public BigDecimal getAmount() {
    return amount;
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

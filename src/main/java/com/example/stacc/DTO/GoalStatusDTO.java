package com.example.stacc.DTO;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GoalStatusDTO {

  private String description;
  private BigDecimal targetAmount;
  private BigDecimal amount;
  private String currency = "NOK";
  private String status;
  private BigDecimal percentAchieved;

  public GoalStatusDTO(String description, BigDecimal targetAmount, BigDecimal amount,
      String currency, String status) {
    this.description = description;
    this.targetAmount = targetAmount;
    this.amount = amount;
    this.currency = currency;
    this.status = status;
    this.percentAchieved = getPercentageAchieved();
  }

  private BigDecimal getPercentageAchieved() {
    if (targetAmount == null || targetAmount.compareTo(BigDecimal.ZERO) == 0) {
      return BigDecimal.ZERO;
    }
    return amount.divide(targetAmount, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
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
    this.percentAchieved = getPercentageAchieved();
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
    this.percentAchieved = getPercentageAchieved();
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BigDecimal getAchieved() {
    return percentAchieved;
  }
}
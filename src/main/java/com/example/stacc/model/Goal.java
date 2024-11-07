package com.example.stacc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "goals")
public class Goal {

  @Id
  private String id;
  private String description;
  private BigDecimal targetAmount;
  private BigDecimal amount;
  private String currency = "NOK";
  private String status;

  @OneToOne
  @JoinColumn(name = "account_id")
  private Account account;

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

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public BigDecimal getTargetAmount() {
    return targetAmount;
  }

  public void setTargetAmount(BigDecimal targetAmount) {
    this.targetAmount = targetAmount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}

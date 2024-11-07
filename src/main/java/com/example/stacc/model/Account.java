package com.example.stacc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

  @Id
  private String id;
  private String accountNumber;
  private String accountType;
  private BigDecimal balance;
  private String currency = "NOK";
  private String owner;

  public String getId() {
    return id;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public String getAccountType() {
    return accountType;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public String getCurrency() {
    return currency;
  }

  public String getOwner() {
    return owner;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }
}
package com.example.stacc.model;

import com.example.stacc.DTO.TransactionRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "transactions")
public class Transaction {

  @Id
  private String id;
  private LocalDate date;
  private String description;
  private BigDecimal amount;
  private String currency = "NOK";

  @ManyToOne
  @JoinColumn(name = "account_id")
  private Account account;

  public static Transaction fromDTO(TransactionRequestDTO dto, Account account) {
    Transaction transaction = new Transaction();
    transaction.setId(dto.getId());
    transaction.setAccount(account);
    transaction.setAmount(dto.getAmount());
    transaction.setDescription(dto.getDescription());
    transaction.setDate(LocalDate.now());
    return transaction;
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

  public Account getAccount() {
    return account;
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

  public void setAccount(Account account) {
    this.account = account;
  }
}

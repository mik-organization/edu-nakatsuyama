package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

/** アカウントの共通フィールド */
@Entity
@Table(name = "account")
@Data
public class Account {
  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "user_name", nullable = false, length = 255)
  private String userName;

  @Column(name = "password", nullable = false)
  private Integer password;

  @Column(name = "account_type", nullable = false)
  private Integer accountType;
}

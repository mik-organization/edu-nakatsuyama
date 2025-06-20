package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "account", schema = "onlinestore")
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

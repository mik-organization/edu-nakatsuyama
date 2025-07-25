package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** アカウント作成用 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountForPost extends Account {
  @Id
  @Column(name = "id")
  @NotNull(message = "IDは必須です")
  private Integer id;
}

package com.example.demo.model.dto;

import lombok.Data;

/** アカウントの共通フィールド */
@Data
public class AccountDto {
  private Integer id;
  private String userName;
  private String password = "*****";
  private Integer accountType;
}

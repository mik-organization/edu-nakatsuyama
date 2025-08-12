package com.example.demo.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** アカウントの共通フィールド */
@ToString
public class AccountResponseDto {
  @Getter @Setter private Integer id;
  @Getter @Setter private String userName;
  @Getter private String password = "*****";
  @Getter @Setter private Integer accountType;
}

package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

/** アカウント情報を表すエンティティクラス */
@Entity
@Table(name = "account")
@Data
public class Account {
  @Id
  @Column(name = "id")
  @NotNull(message = "IDは必須です")
  private Integer id;

  @Column(name = "user_name", nullable = false, length = 255)
  @NotEmpty(message = "ユーザー名は必須です")
  @Size(max = 255, message = "ユーザー名は255文字以内で入力してください")
  private String userName;

  @Column(name = "password", nullable = false)
  @NotNull(message = "パスワードは必須です")
  @Min(value = 10000, message = "パスワードは最低5桁以上の整数である必要があります")
  private Integer password;

  @Column(name = "account_type", nullable = false)
  @NotNull(message = "アカウント種別は必須です")
  @Min(value = 1, message = "アカウント種別は1か2の値を指定してください")
  @Max(value = 2, message = "アカウント種別は1か2の値を指定してください")
  private Integer accountType;
}

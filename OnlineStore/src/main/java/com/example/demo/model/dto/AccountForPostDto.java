package com.example.demo.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

/** アカウント作成用 */
@Data
public class AccountForPostDto {
  @NotNull(message = "IDは必須です")
  private Integer id;

  @NotEmpty(message = "ユーザー名は必須です")
  @Size(max = 255, message = "ユーザー名は255文字以内で入力してください")
  private String userName;

  @NotNull(message = "パスワードは必須です")
  @Min(value = 10000, message = "パスワードは最低5桁以上の整数である必要があります")
  private Integer password;

  @NotNull(message = "アカウント種別は必須です")
  @Min(value = 1, message = "アカウント種別は1か2の値を指定してください")
  @Max(value = 2, message = "アカウント種別は1か2の値を指定してください")
  private Integer accountType;
}

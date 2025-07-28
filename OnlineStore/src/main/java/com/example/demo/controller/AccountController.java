package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.dto.AccountDto;
import com.example.demo.model.dto.AccountForPostDto;
import com.example.demo.model.dto.AccountForPutDto;
import com.example.demo.model.entity.Account;
import com.example.demo.service.AccountService;

/** アカウント操作用コントローラ */
@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired private AccountService accountService;

  /**
   * アカウント登録API
   *
   * @param account アカウント情報
   * @return 登録した結果
   */
  @PostMapping
  public ResponseEntity<AccountDto> registerAccount(@Valid @RequestBody AccountForPostDto dto) {
    Account registeredAccount = accountService.register(dto);
    AccountDto account = new AccountDto();
    account.setId(registeredAccount.getId());
    account.setUserName(registeredAccount.getUserName());
    account.setAccountType(registeredAccount.getAccountType());

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(registeredAccount.getId())
            .toUri();

    return ResponseEntity.created(location).body(account);
  }

  /**
   * アカウント一覧取得API
   *
   * @return アカウントのリスト
   */
  @GetMapping
  public List<AccountDto> getAllAccounts() {
    return accountService.findAll();
  }

  /**
   * アカウント詳細取得API
   *
   * @param id 取得対象のアカウントID
   * @return 指定IDのアカウント情報
   */
  @GetMapping("/{id}")
  public ResponseEntity<AccountDto> getAccountById(@Valid @PathVariable Integer id) {
    Optional<AccountDto> account = accountService.findById(id);
    return account.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  /**
   * アカウント更新API
   *
   * @param id 更新対象のアカウントID
   * @param updatedAccount 更新内容を含むアカウント情報
   * @return 更新後のアカウント情報
   */
  @PutMapping("/{id}")
  public ResponseEntity<AccountDto> updateAccount(
      @PathVariable Integer id, @Valid @RequestBody AccountForPutDto updatedAccount) {
    Optional<AccountDto> updateAccount = accountService.update(id, updatedAccount);
    return updateAccount
        .map(account -> ResponseEntity.ok(account))
        .orElse(ResponseEntity.notFound().build());
  }

  /**
   * アカウント削除API
   *
   * @param id 削除対象のアカウントID
   * @return 処理結果
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAccount(@Valid @PathVariable Integer id) {
    if (!accountService.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    accountService.delete(id);
    return ResponseEntity.noContent().build();
  }
}

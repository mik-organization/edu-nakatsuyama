package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired private AccountService accountService;

  //登録
  @PostMapping
  public Account registerAccount(@RequestBody Account account) {
    return accountService.register(account);
  }

  // 一覧取得
  @GetMapping
  public List<Account> getAllAccounts() {
    return accountService.getAll();
  }

  // 詳細取得
  @GetMapping("/{id}")
  public ResponseEntity<Account> getAccount(@PathVariable Integer id) {
    Account account = accountService.getById(id);
    if (account == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(account);
  }

  // 更新
  @PutMapping("/{id}")
  public ResponseEntity<Account> updateAccount(
      @PathVariable Integer id, @RequestBody Account updatedAccount) {
    Account account = accountService.update(id, updatedAccount);
    if (account == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(account);
  }

  // 削除
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAccount(@PathVariable Integer id) {
    boolean deleted = accountService.delete(id);
    if (!deleted) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.noContent().build();
  }
}

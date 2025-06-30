package com.example.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Account;
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
  public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
    Account saved = accountService.register(account);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(saved.getId())
            .toUri();

    return ResponseEntity.created(location).body(saved);
  }
}

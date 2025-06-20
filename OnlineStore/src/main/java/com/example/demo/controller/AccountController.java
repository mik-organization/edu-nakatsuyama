package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

  @Autowired private AccountService accountService;

  // 登録API（POST）
  @PostMapping
  public Account registerAccount(@RequestBody Account account) {
    return accountService.register(account);
  }

  // 動作確認用
  @RequestMapping("/")
  public String hello() {
    return "Account API is working!";
  }
}

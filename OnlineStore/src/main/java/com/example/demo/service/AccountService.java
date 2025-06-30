package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

/** アカウントに関するビジネスロジックを提供するサービスクラス */
@Service
public class AccountService {

  @Autowired private AccountRepository accountRepository;

  /**
   * アカウント情報を新規に登録
   *
   * @param account 登録するアカウント情報
   * @return 登録されたアカウント情報
   */
  public Account register(Account account) {
    return accountRepository.save(account);
  }
}

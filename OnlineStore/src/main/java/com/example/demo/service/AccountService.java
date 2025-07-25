package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.model.AccountForPost;
import com.example.demo.model.AccountForPut;
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
  public AccountForPost register(AccountForPost account) {
    AccountForPost accountRequest = new AccountForPost();
    accountRequest.setId(account.getId());
    accountRequest.setUserName(account.getUserName());
    accountRequest.setPassword(account.getPassword());
    accountRequest.setAccountType(account.getAccountType());

    return accountRepository.save(accountRequest);
  }

  /**
   * すべてのアカウント情報を取得
   *
   * @return アカウント情報のリスト
   */
  public List<Account> findAll() {
    return accountRepository.findAll();
  }

  /**
   * 指定されたIDのアカウント情報を取得
   *
   * @param id 取得対象のアカウントID
   * @return 該当するアカウント情報
   */
  public Optional<Account> findById(Integer id) {
    return accountRepository.findById(id);
  }

  /**
   * 指定されたIDのアカウント情報を更新
   *
   * @param id 更新対象のアカウントID
   * @param updatedAccount 更新内容を含むアカウント情報
   * @return 更新後のアカウント情報
   */
  public Optional<Account> update(Integer id, AccountForPut updatedAccount) {
    return accountRepository
        .findById(id)
        .map(
            account -> {
              account.setUserName(updatedAccount.getUserName());
              account.setPassword(updatedAccount.getPassword());
              account.setAccountType(updatedAccount.getAccountType());
              return accountRepository.save(account);
            });
  }

  /**
   * 指定されたIDのアカウントが存在するか確認
   *
   * @param id 存在確認対象のアカウントID
   * @return アカウントが存在すれば true、存在しなければ false
   */
  public boolean existsById(Integer id) {
    return accountRepository.existsById(id);
  }

  /**
   * 指定されたIDのアカウント情報を削除
   *
   * @param id 削除対象のアカウントID
   */
  public void delete(Integer id) {
    accountRepository.deleteById(id);
  }
}

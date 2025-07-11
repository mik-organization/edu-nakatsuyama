package com.example.demo.service;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

=======
>>>>>>> main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

<<<<<<< HEAD
=======
/** アカウントに関するビジネスロジックを提供するサービスクラス */
>>>>>>> main
@Service
public class AccountService {

  @Autowired private AccountRepository accountRepository;

<<<<<<< HEAD
  public Account register(Account account) {
    return accountRepository.save(account);
  }

  public List<Account> getAll() {
    return accountRepository.findAll();
  }

  public Account getById(Integer id) {
    return accountRepository.findById(id).orElse(null);
  }

  public Account update(Integer id, Account updatedAccount) {
    Optional<Account> existing = accountRepository.findById(id);
    if (existing.isPresent()) {
      Account account = existing.get();
      account.setUserName(updatedAccount.getUserName());
      account.setPassword(updatedAccount.getPassword());
      account.setAccountType(updatedAccount.getAccountType());
      return accountRepository.save(account);
    }
    return null;
  }

  public boolean delete(Integer id) {
    if (!accountRepository.existsById(id)) {
      return false;
    }
    accountRepository.deleteById(id);
    return true;
  }
=======
  /**
   * アカウント情報を新規に登録
   *
   * @param account 登録するアカウント情報
   * @return 登録されたアカウント情報
   */
  public Account register(Account account) {
    return accountRepository.save(account);
  }
>>>>>>> main
}

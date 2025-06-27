package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {

  @Autowired private AccountRepository accountRepository;

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
}

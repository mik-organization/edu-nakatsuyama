package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.AccountRequestPostDto;
import com.example.demo.model.dto.AccountRequestPutDto;
import com.example.demo.model.dto.AccountResponseDto;
import com.example.demo.model.entity.AccountEntity;
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
  public AccountEntity register(AccountRequestPostDto dto) {
    AccountEntity accountRequest = new AccountEntity();
    accountRequest.setId(dto.getId());
    accountRequest.setUserName(dto.getUserName());
    accountRequest.setPassword(dto.getPassword());
    accountRequest.setAccountType(dto.getAccountType());

    return accountRepository.save(accountRequest);
  }

  /**
   * すべてのアカウント情報を取得
   *
   * @return アカウント情報のリスト
   */
  public List<AccountResponseDto> findAll() {
    return accountRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
  }

  /**
   * 指定されたIDのアカウント情報を取得
   *
   * @param id 取得対象のアカウントID
   * @return 該当するアカウント情報
   */
  public Optional<AccountResponseDto> findById(Integer id) {
    return accountRepository.findById(id).map(this::toDto);
  }

  /**
   * Entity → DTO への変換メソッド
   *
   * @param account
   * @return DTO
   */
  private AccountResponseDto toDto(AccountEntity account) {
    AccountResponseDto dto = new AccountResponseDto();
    dto.setId(account.getId());
    dto.setUserName(account.getUserName());
    dto.setAccountType(account.getAccountType());
    return dto;
  }

  /**
   * 指定されたIDのアカウント情報を更新
   *
   * @param id 更新対象のアカウントID
   * @param updatedAccount 更新内容を含むアカウント情報
   * @return 更新後のアカウント情報
   */
  public Optional<AccountResponseDto> update(Integer id, AccountRequestPutDto updatedAccount) {
    return accountRepository
        .findById(id)
        .map(
            account -> {
              account.setUserName(updatedAccount.getUserName());
              account.setPassword(updatedAccount.getPassword());
              account.setAccountType(updatedAccount.getAccountType());
              AccountEntity savedAccount = accountRepository.save(account);
              return toDto(savedAccount);
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

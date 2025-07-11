package com.example.demo.repository;

<<<<<<< HEAD
import com.example.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;

/** アカウントリポジトリ */
>>>>>>> main
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {}

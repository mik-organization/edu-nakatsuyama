package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Spring Boot アプリケーションのエントリーポイントクラス */
@SpringBootApplication
public class OnlineStoreApplication {

  /**
   * アプリケーションの起動メソッド
   *
   * @param args コマンドライン引数
   */
  public static void main(String[] args) {
    SpringApplication.run(OnlineStoreApplication.class, args);
  }
}

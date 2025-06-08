# Web API概要
- オンラインストアでの使用を想定した在庫管理
- 商品の登録・削除・追加・購入履歴
- 商品の在庫、ユーザが何をどのくらい購入したか管理する


# PJ運用について
## issue対応について
- 1issueにつき、1branch、1スレッド
- sourceブランチは基本的にmain
- ブランチ名：issue番号-対応内容の概要　例）4-new-pj
  - 英字については全て小文字
  - 全角文字は使用しない
  - 区切りが必要であれば、-（ハイフン）を使用する
- 作業完了時、プルリクを作成する
- プルリクでレビューを実施し、完了後、プルリクをクローズ（マージ）する
  
## コミットについて
- コミットメッセージは下記のようにする  
issue番号 対応内容の概要　例） #4 新規プロジェクトの追加

## レビュー指摘対応について
- 指摘対応について、1指摘対応につき1commitし、指摘のリプライにコミットハッシュを貼り付ける

## その他
- 作業途中でも随時プッシュして、プルリクを作成しておく


# コーディングルール
## コメントについて
- privateを除いた、クラス、メソッド、変数には、javadocを必須とする
- インデントは半角SP2つ

# spring bootプロジェクトのフォルダ構造
* src/main/java/com/example/demo
  * controller
    * MVCのコントローラクラスを配置
  * model
    * データモデル（エンティティ）クラスを配置
    * データベースのテーブルと直接マッピングされるオブジェクト
    * JPA（Java Persistence API）アノテーションを使用
    * データベースの構造を表現
    * ビジネスロジックを含むことがある
  * dto
    * レイヤー間（特にクライアントとサーバー間）でデータを転送するためのオブジェクト
    * データベースの構造に依存しない
    * 必要な情報のみを含む（データの最適化）
    * ビジネスロジックを含まない純粋なデータコンテナ
  * repository
    * データアクセス層（DAO）を配置
  * service
    * ビジネスロジックを含むサービスクラスを格納
  * util
    * ユーティリティクラスを配置
  * exception
    * 業務例外クラスを配置

# クラス間の処理イメージ
1. クライアントからのリクエストがcontrollerに到達します。
1. controllerは必要に応じてserviceを呼び出します。
1. serviceはrepositoryを使用してデータ操作を行います。
1. modelはデータの構造を定義します。

# フォーマッターについて
- github ページ　https://github.com/google/google-java-format
- https://github.com/google/google-java-format/releases  
  ここから "google-java-format-eclipse-plugin-x.xx.x.jar"をダウンロード
  - C:\pleiades\2024-09\eclipse\plugins に格納
  - https://qiita.com/chenglin/items/b442a9ee5a44e274b185 に記載のある手順で設定
  - C:\pleiades\2024-09\eclipse\eclipse.ini に下記を追記後、Eclipseを再起動
  ```
  --add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED
  --add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED
  --add-exports=jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED
  --add-exports=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED
  --add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED
  --add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED
  ```


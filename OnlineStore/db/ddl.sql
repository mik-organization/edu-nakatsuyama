-- 購入履歴管理テーブル
create table purchase_history(
name char(255) not null,
purchase_date DATE not null,
product_name char(255) not null,
quantity int  not null
)

-- 在庫管理テーブル
create table stock(
product_name char(255) not null,
quantity int  not null
)

-- アカウント管理テーブル
create table account(
name char(255) not null,
password int not null,
authority int  not null
)
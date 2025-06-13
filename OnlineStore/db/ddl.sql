-- 購入履歴管理テーブル
create table OnlineStote(
Name char(255) not null,
PurchaseDate DATE not null,
ProductName char(255) not null,
Quantity int  not null
)

-- 在庫管理テーブル
create table Stock(
ProductName char(255) not null,
Quantity int  not null
)

-- アカウント管理テーブル
create table Account(
Name char(255) not null,
Password int not null,
Authority int  not null
)
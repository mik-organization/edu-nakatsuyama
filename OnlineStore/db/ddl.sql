-- スキーマの作成
CREATE SCHEMA IF NOT EXISTS onlinestore;

-- スキーマの削除
DROP SCHEMA IF EXISTS onlinestore;

-- 購入履歴管理テーブル
create table onlinestore.purchase_history(
id int not null primary key comment 'ID',
user_name char(255) not null comment 'ユーザー名',
purchase_date DATE not null comment '購入日',
product_name char(255) not null comment '商品名',
quantity int  not null comment '数量'
) comment '購入履歴管理テーブル'

-- 在庫管理テーブル
create table onliestore.stock(
id int not null primary key comment 'ID',
product_name char(255) not null comment '商品名',
quantity int  not null comment '数量'
) comment '在庫管理テーブル'

-- アカウント管理テーブル
create table onliestore.account(
id int not null primary key comment 'ID',
user_name char(255) not null comment 'ユーザー名',
password int not null comment 'パスワード',
authority int  not null comment '権限'
) comment 'アカウント管理テーブル'
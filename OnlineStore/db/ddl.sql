-- スキーマの削除
DROP SCHEMA IF EXISTS onlinestore;

-- スキーマの作成
CREATE SCHEMA IF NOT EXISTS onlinestore;

-- アカウント管理テーブル
create table onlinestore.account(
id int not null primary key comment 'ID',
user_name char(255) not null comment 'ユーザー名',
password int not null comment 'パスワード',
account_type int  not null comment 'アカウントタイプ'
) comment 'アカウント管理テーブル';

-- 購入履歴管理テーブル
create table onlinestore.purchase_history(
id int not null primary key comment 'ID',
purchase_date DATE not null comment '購入日',
product_name char(255) not null comment '商品名',
quantity int  not null comment '数量',
account_id int  not null comment 'アカウントID',
) comment '購入履歴管理テーブル';

-- 在庫管理テーブル
create table onlinestore.stock(
id int not null primary key comment 'ID',
product_name char(255) not null comment '商品名',
quantity int  not null comment '数量'
) comment '在庫管理テーブル';

ALTER TABLE onlinestore.purchase_history ADD FOREIGN KEY (account_id) REFERENCES onlinestore.account(id) ON DELETE CASCADE;


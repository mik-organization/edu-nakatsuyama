-- 購入履歴管理テーブル
create table purchase_history(
name char(255) not null comment 'ユーザー名',
purchase_date DATE not null comment '購入日',
product_name char(255) not null comment '購入商品',
quantity int  not null comment '数量'
) comment '購入履歴管理テーブル'

-- 在庫管理テーブル
create table stock(
product_name char(255) not null comment '購入商品',
quantity int  not null comment '数量'
) comment '在庫管理テーブル'

-- アカウント管理テーブル
create table account(
name char(255) not null comment 'ユーザー名',
password int not null comment 'パスワード',
authority int  not null comment '権限'
) comment 'アカウント管理テーブル'
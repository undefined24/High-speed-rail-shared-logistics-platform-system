drop table if exists administrator;	#管理员表
drop table if exists user;	#用户表
drop table if exists user_info;	#用户信息表
drop table if exists bill;	#运单表
drop table if exists receiver_info;	#收件人信息表
drop table if exists goods_info; #物件信息表
drop table if exists accept_user_info;	#接单用户信息表
drop table if exists history;	#历史记录表
drop table if exists worker;	#客服人员表
drop table if exists message;	#反馈留言表

create table administrator(
  adminID int(32) primary key auto_increment,
  adminname varchar(20) not null,
  adminpwd char(16) not null
);
create table user(
	userID int(32) primary key auto_increment,
    username varchar(20) not null,
    userphone char(11) not null,
    usernumber char(18) not null,
    usersex char(8) not null
);
create table user_info(
	userID int(32) primary key,
    nickname varchar(32) not null,
    userpwd char(20) not null,
    useraddress varchar(50) not null,
    usersex char(8) not null,
    userbirthday varchar(32),
    note varchar(100)
);
create table bill(
	trackingID int(32) primary key auto_increment,
    giveUserID int(32) not null,
    acceptUserID int(32) not null,
    sendaddress varchar(50) not null,
    arriveaddress varchar(50) not null,
    cost float(10,2) not null
);
create table receiver_info(
	trackingID int(32) primary key,
    name varchar(50) not null,
    sex varchar(10) not null,
    phone varchar(11) not null,
    address varchar(50) not null
);
create table goods_info(
	trackingID int(32) primary key,
    weight float(10,2) not null,
    volume float(10,2) not null,
    name varchar(50) not null,
    note varchar(100)
);
create table accept_user_info(
	userID int(32) primary key,
    startpoint varchar(50) not null,
    endpoint varchar(50) not null,
    trainnumber varchar(32) not null,
    date varchar(32) not null,
    allowweight float(10,2) not null,
    No_allow_goods varchar(100) not null,
    Is_obey_distribution boolean not null
);
create table history(
	historyID int(32) primary key auto_increment,
    giveUserID int(32) not null,
    acceptUserID int(32) not null,
    trackingID int(32) not null
);
create table worker(
	workerID int(32) primary key auto_increment,
    workername varchar(20) not null,
    workerpwd char(16) not null
);
create table message (
    wordID int(32) primary key auto_increment,
    userID int(32) not null,
    content varchar(255) not null
);
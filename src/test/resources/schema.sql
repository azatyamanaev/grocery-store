drop table if exists teachers;
drop table if exists companies;
drop table if exists students;
drop table if exists users;


create table users
(
    id          INT constraint AUTO_INCREMENT PRIMARY KEY,
    email       varchar(255),
    login       varchar(255) not null,
    name        varchar(255),
    password    varchar(255) not null ,
    role        varchar(255),
    state       varchar(255),
    confirmCode varchar(255) default null
);

create table teachers
(
    about      varchar(255),
    lastName   varchar(255),
    patronymic varchar(255),
    position   varchar(255),
    id         bigint primary key references users (id)
);

create table companies
(
    about                 varchar(255),
    additionalInformation varchar(255),
    linkToSite            varchar(255),
    number                varchar(255),
    id                    bigint primary key references users (id)
);
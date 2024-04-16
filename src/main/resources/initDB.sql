create table if not exists user
(
    id       BIGINT auto_increment primary key,
    name     varchar(256) not null,
    age      bigint       not null,
    userName varchar(256) not null
);
drop table if exists comment cascade;
drop table if exists user cascade;

create table user
(
    iduser   int primary key not null auto_increment,
    username varchar(30),
    email    varchar(255) unique,
    password varchar(255),
    avatar   varchar(255)
);

create table comment
(
    idcomment  int primary key not null auto_increment,
    content    varchar(255)    not null,
    createdate timestamp,
    iduser     int,
    foreign key (iduser) references user (iduser)
);

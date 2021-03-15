use mybatis;

create table if not exists user
(
    id       integer     not null auto_increment,
    username varchar(30) not null,
    password varchar(30) not null,
    primary key (id)
)
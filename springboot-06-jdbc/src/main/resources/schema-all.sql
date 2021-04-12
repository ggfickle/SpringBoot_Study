# drop table if exists department;
create table department
(
    department_id   integer     not null auto_increment,
    department_name varchar(50) not null,
    primary key (department_id)
);

# drop table if exists user;
create table user
(
    id       integer     not null primary key,
    username varchar(50) not null,
    password varchar(50) not null
)
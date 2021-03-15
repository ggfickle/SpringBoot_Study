use mybatis;

create table if not exists book
(
    book_id    integer     not null primary key auto_increment,
    book_name  varchar(30) not null,
    book_price double
)
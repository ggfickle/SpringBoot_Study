drop table if exists company;
create table company
(
    company_id   integer not null auto_increment primary key,
    company_name varchar(50)
)
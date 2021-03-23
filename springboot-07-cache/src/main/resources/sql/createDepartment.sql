use cache;

create table if not exists department
(
    department_id   integer     not null auto_increment,
    department_name varchar(20) not null,
    primary key (department_id)
)
use cache;

create table if not exists employee
(
    employee_id     integer     not null auto_increment,
    employee_name   varchar(30) not null,
    employee_email  varchar(30) not null,
    employee_gender integer     not null,
    d_id            integer     not null,
    primary key (employee_id)
)
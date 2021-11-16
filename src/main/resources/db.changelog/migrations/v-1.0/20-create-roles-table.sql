create table roles (
roleId Long not null auto_increment,
name varchar(255) not null,
primary key (roleId)
) engine=InnoDB
GO
alter table roles
add constraint UK_r43af9ap4edm43mmt01odd16 unique (name)
GO
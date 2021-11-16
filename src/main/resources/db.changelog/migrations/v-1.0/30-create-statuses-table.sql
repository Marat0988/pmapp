create table statuses (
statusId Long not null auto_increment,
name varchar(255) not null,
primary key (statusId)
) engine=InnoDB
GO
alter table statuses
add constraint UK_r43af9ap4edm43mmt01odd16 unique (name)
GO
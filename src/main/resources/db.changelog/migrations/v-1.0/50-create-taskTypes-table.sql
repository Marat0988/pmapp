create table taskTypes (
taskTypeId Long not null auto_increment,
name varchar(255) not null,
primary key (taskTypeId)
) engine=InnoDB
GO
alter table taskTypes
add constraint UK_r43af9ap4edm43mmt01odd16 unique (name)
GO
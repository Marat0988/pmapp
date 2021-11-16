create table users (
userId Long not null auto_increment,
name varchar(255) not null,
lastname varchar(255) not null,
password varchar(255) not null,
email varchar(255) not null,
roleId Long,
primary key (userId)
) engine=InnoDB
GO
alter table users
add constraint UK_r43af9ap4edm43mmt01odd16 unique (email)
GO
alter table users
   add constraint FKtpkopyby8qwu1noj4n4t3yuig
   foreign key (roleId)
   references roles (roleId)
GO

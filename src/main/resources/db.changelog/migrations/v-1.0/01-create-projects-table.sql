create table projects (
projectId Long not nul auto_increment,
name varchar(255) not null,
isPaid boolean,
userId Long,
statusId Long,
primary key (project ID)
) engine=InnoDB
GO
alter table projects
add constraint UK_r43af9ap4edm43mmt01odd16 unique (name)
GO
alter table projects
   add constraint FKtpkopyby8qwu1noj4n4t3yuig
   foreign key (userId)
   references users (userId)
GO
alter table projects
   add constraint FKtpkopyby8qwu1noj4n4t3yuig
   foreign key (statusId)
   references statuses (statusId)
GO
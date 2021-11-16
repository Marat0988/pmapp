create table tasks (
taskId Long not null auto_increment,
name varchar(255) not null,
description varchar(255) not null,
startDate datetime not null,
submissionDate datetime not null,
userId Long,
statusId Long,
projectId Long,
releaseId Long,
taskTypeId Long,
primary key (taskId)
) engine=InnoDB
GO
alter table tasks
add constraint UK_r43af9ap4edm43mmt01odd16 unique (name)
GO
alter table tasks
   add constraint FKtpkopyby8qwu1noj4n4t3yuig
   foreign key (userId)
   references users (userId)
GO
alter table tasks
   add constraint FKtpkopyby8qwu1noj4n4t3yuig
   foreign key (statusId)
   references statuses (statusId)
GO
alter table tasks
   add constraint FKtpkopyby8qwu1noj4n4t3yuig
   foreign key (projectId)
   references projects (projectId)
GO
alter table tasks
   add constraint FKtpkopyby8qwu1noj4n4t3yuig
   foreign key (releaseId)
   references releases (releaseId)
GO
alter table tasks
   add constraint FKtpkopyby8qwu1noj4n4t3yuig
   foreign key (taskTypeId)
   references taskTypes (taskTypeId)
GO
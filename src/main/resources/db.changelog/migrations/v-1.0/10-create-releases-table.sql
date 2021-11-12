create table releases (
releaseId Long not null auto_increment,
startDate datetime not null,
endDate datetime not null,
primary key (releaseId)
) engine=InnoDB
GO

create table employee (
id bigint auto_increment primary key,
employeeName varchar(255) not null,
email varchar(255) not null,
address varchar(255) not null,
timeOfArrival TIMESTAMP  NOT NULL ,
scheduledTimeOfArrival TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
);
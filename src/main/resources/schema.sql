create table if not exists Run (
       id int not null ,
       title varchar(255) not null,
       started_on timestamp not null,
       completed_on timestamp not null,
       miles int not null,
       location varchar(255) not null,
       primary key (id)
);
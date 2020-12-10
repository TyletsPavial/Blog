drop database if exists blog;
create database blog;
use blog;

create table if not exists role (
	roleId INT NOT NULL unique AUTO_INCREMENT,
    role varchar(5),
    primary key (roleId)
);

create table if not exists user (
	userId INT NOT NULL unique AUTO_INCREMENT,
	login varchar(30) not null unique,
	firstname varchar(30),
	lastname varchar(30),
	password varchar(255),
	sign varchar(60),
	roleId int not null,
	primary key (userId),
	foreign key (roleId) references role(roleId) on delete cascade
);

create table if not exists post (
	postId INT NOT NULL unique AUTO_INCREMENT,
    title varchar(100),
	text varchar(255),
    userId int not null,
    primary key (postId),
    foreign key (userId) references user(userId) on delete cascade
);

create table if not exists comment(
	comId INT NOT NULL UNIQUE auto_increment,
    text varchar(150),
    postId INT,
    userId INT,
    primary key (comId),
    foreign key (postId) references post(postId),
    foreign key (userId) references user(userId) on delete cascade
    );

insert into role(roleId, role) value(1, "ADMIN");
insert into role(roleId, role) value(2, "USER");


insert into user (userid, login, firstname, lastname, password, sign, roleId) values(2, "user", "user","user", "$2a$10$.9499c8H/Mc8ukTS..l7Y.wG4BvOlx4xCATsjineVsh5B6B2azePy", "user", 2); -- password 123
insert into user (userid, login, firstname, lastname, password, sign, roleId) values(3, "admin", "admin","admin", "$2a$10$.9499c8H/Mc8ukTS..l7Y.wG4BvOlx4xCATsjineVsh5B6B2azePy", "admin", 1); -- password 123

insert into post (title, text, userId) values ("some title","some text",2);
insert into  comment (text, postId, userId) values("some comment", 2, 2);



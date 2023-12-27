CREATE TABLE IF NOT EXISTS APP_USER (
    id INT PRIMARY KEY AUTO_INCREMENT,
    email varchar(255), 
    username varchar(255), 
    primary key (id)
);


INSERT INTO APP_USER (email, username) values('John', 'john@email.com');
INSERT INTO APP_USER (email, username) values('Sam', 'sam@email.com');
INSERT INTO APP_USER (email, username) values('Catherine', 'catherine@email.com');
INSERT INTO APP_USER (email, username) values('Susan', 'susan@email.com');
INSERT INTO APP_USER (email, username) values('Joel', 'joel@email.com');
INSERT INTO APP_USER (email, username) values('Mike', 'mike@email.com');
INSERT INTO APP_USER (email, username) values('Peter', 'peter@email.com');
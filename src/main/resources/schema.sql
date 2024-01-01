CREATE TABLE IF NOT EXISTS APP_USER (
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255), 
    username VARCHAR(255), 
    departmentId INT
);

INSERT INTO APP_USER (email, username, departmentId) values('John', 'john@email.com', 1);
INSERT INTO APP_USER (email, username, departmentId) values('Sam', 'sam@email.com', 1);
INSERT INTO APP_USER (email, username, departmentId) values('Catherine', 'catherine@email.com',2 );
INSERT INTO APP_USER (email, username, departmentId) values('Susan', 'susan@email.com',2 );
INSERT INTO APP_USER (email, username, departmentId) values('Joel', 'joel@email.com', 3);
INSERT INTO APP_USER (email, username, departmentId) values('Mike', 'mike@email.com',3 );
INSERT INTO APP_USER (email, username, departmentId) values('Peter', 'peter@email.com', 4);


CREATE TABLE IF NOT EXISTS DEPARTMENT (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255), 
    manager INT,
    parentId INT,
    useYn VARCHAR(1)
);

INSERT INTO DEPARTMENT (id, name, manager, parentId, useYn) values(0, 'Staff', null, null, 'Y');
INSERT INTO DEPARTMENT (id, name, manager, parentId, useYn) values(1, 'HR', 1, 0, 'Y');
INSERT INTO DEPARTMENT (id, name, manager, parentId, useYn) values(2, 'LnD', 2, 0, 'Y');
INSERT INTO DEPARTMENT (id, name, manager, parentId, useYn) values(3, 'IT', null, null, 'Y');
INSERT INTO DEPARTMENT (id, name, manager, parentId, useYn) values(4, 'SM', 4, 3, 'Y');

ALTER TABLE APP_USER ADD FOREIGN KEY (departmentId) REFERENCES DEPARTMENT(id);
ALTER TABLE DEPARTMENT ADD FOREIGN KEY (manager) REFERENCES APP_USER(id);
ALTER TABLE DEPARTMENT ADD FOREIGN KEY (parentId) REFERENCES DEPARTMENT(id)

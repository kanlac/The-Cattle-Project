CREATE SCHEMA CattleProject;

USE CattleProject;

CREATE TABLE admini (
	id VARCHAR(20) PRIMARY KEY,
	username NVARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	position NVARCHAR(20) NOT NULL,
	phone VARCHAR(20) NOT NULL
);

CREATE TABLE cattle (
	id VARCHAR(20) PRIMARY KEY,
	sex CHAR(1) NOT NULL,
	birthday DATE,
	weight NUMERIC(5,2),
	variety NVARCHAR(20),
	father_id VARCHAR(20),
	mother_id VARCHAR(20),
	children_id VARCHAR(200),
	CHECK (sex LIKE '[mf]')
);

CREATE TABLE post (
	id VARCHAR(20) PRIMARY KEY,
	title VARCHAR(20) NOT NULL,
	author VARCHAR(20) NOT NULL,
	content TEXT NOT NULL
);

-- 

INSERT INTO admini VALUES ('4921', '吴', '655', '经理', '123456789');

INSERT INTO cattle (id, sex, birthday, weight, variety, children_id) VALUES ('001', 'm', '2018-03-07', 23.4, '灰', '002');
INSERT INTO cattle (id, sex, birthday, weight, variety, father_id) VALUES ('002', 'm', '2020-03-07', 10.5, '灰', '001');

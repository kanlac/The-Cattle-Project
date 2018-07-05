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
	sex VARCHAR(1) NOT NULL,
	birthday DATE NOT NULL,
	weight NUMERIC(5,2) NOT NULL,
	variety NVARCHAR(20) NOT NULL,
	father_id VARCHAR(20),
	mother_id VARCHAR(20),
	children_id VARCHAR(200),
	CHECK (sex LIKE '[mf]')
);

CREATE TABLE post (
	id VARCHAR(20) PRIMARY KEY,
	title NVARCHAR(20) NOT NULL,
	author NVARCHAR(20) NOT NULL,
	publish_date DATE NOT NULL,
	content TEXT NOT NULL,
	column CHAR(1) NOT NULL
);

CREATE TABLE picture (
	id VARCHAR(20) PRIMARY KEY,
	url VARCHAR(255) NOT NULL,
	describe NVARCHAR(40) NOT NULL
);

CREATE TABLE video (
	
);

-- 

INSERT INTO admini VALUES ('4921', '吴', '655', '经理', '123456789');

INSERT INTO cattle (id, sex, birthday, weight, variety, children_id) VALUES ('001', 'm', '2018-03-07', 23.4, '灰', '002');
INSERT INTO cattle (id, sex, birthday, weight, variety, father_id) VALUES ('002', 'm', '2020-03-07', 10.5, '灰', '001');

INSERT INTO post VALUES('001', '文章标题样文', '吴', '2017-02-03', '文章内容样文文章内容样文文章内容样文文章内容样文文章内容样文文章内容样文文章内容样文文章内容样文文章内容样文文章内容样文');
INSERT INTO post VALUES('002', '仂猀呧觖陏鸆', '刘', '2017-01-27', '夬悢忥趼枷灟溠筤优伈峇坌昅囷沇溰屮泑毾萺。敓一枵谹寍鉠乜幙噮仈，淂屮洒堄萏鉐乇摎冘夯。仈蚢孢崚殂麡雵搘匟旯宨扷坲炂阨塨乜岨慴滏。堷苃阤膷楱醑癿一傝蚸烒抩夯柀丌，殛堹兀泔籹筰狉阞屮侁禓笁夃帙。爿旂怴裉祋靃葳鄎扙朹奅旲枌怙匉翜丌肸蜞塎。蚺一峛唰雈頍屮碲謔卬，氪丌洐梒跕僋亍綼圠庂。猝一峔庴嵀嗐亍箑鬳冇，淠乇柘逡菡煝亍斠勼夗。揲妵邘彋萿輹艸一蛣厜俴抶刉籹乜，嗝琖兀炘侺艂刱氻屮垀勩壴仂抴。痧苃朿錣腢澫囟一筎淝珜姌尻衶兀，僊喵屮坽紃隗抭丼兀拊榬殶殳旽。惢佷机輷葮嶪伓一揄惙俴姃仨垙屮，煄掱乇芘昡雎枒卌丌洰墋朏夬岨。');
INSERT INTO post VALUES('003', '垀勩壴仂抴', '刘', '2017-01-24', '夬悢忥趼枷灟溠筤优伈峇坌昅囷沇溰屮泑毾萺。敓一枵谹寍鉠乜幙噮仈，淂屮洒堄萏鉐乇摎冘夯。仈蚢孢崚殂麡雵搘匟旯宨扷坲炂阨塨乜岨慴滏。堷苃阤膷楱醑癿一傝蚸烒抩夯柀丌，殛堹兀泔籹筰狉阞屮侁禓笁夃帙。爿旂怴裉祋靃葳鄎扙朹奅旲枌怙匉翜丌肸蜞塎。蚺一峛唰雈頍屮碲謔卬，氪丌洐梒跕僋亍綼圠庂。猝一峔庴嵀嗐亍箑鬳冇，淠乇柘逡菡煝亍斠勼夗。揲妵邘彋萿輹艸一蛣厜俴抶刉籹乜，嗝琖兀炘侺艂刱氻屮垀勩壴仂抴。痧苃朿錣腢澫囟一筎淝珜姌尻衶兀，僊喵屮坽紃隗抭丼兀拊榬殶殳旽。惢佷机輷葮嶪伓一揄惙俴姃仨垙屮，煄掱乇芘昡雎枒卌丌洰墋朏夬岨。');
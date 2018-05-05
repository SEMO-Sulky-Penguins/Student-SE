CREATE TABLE android_metadata (
	locale TEXT DEFAULT 'en_US'
);

INSERT INTO android_metadata
VALUES ('en_US');

CREATE TABLE events(
	_id INTEGER PRIMARY KEY AUTOINCREMENT,
	title TEXT,
	description TEXT,
	place TEXT,
	eventDate TEXT,
	org TEXT
);

INSERT INTO events(title,description,place,eventDate,org)
VALUES('Git Boot Camp','Come learn git and github','DH026','9/3/2018','ACM');

INSERT INTO events(title,description,place,eventDate,org)
VALUES('Web Security','Learn to prevent XSS and SQLi','DH126','9/5/2018','CDC');

INSERT INTO events(title,description,place,eventDate,org)
VALUES('Hackathon','Network with other nerds and work on cool projects','DH023','9/8/2018','CS Club');

INSERT INTO events(title,description,place,eventDate,org)
VALUES('CCDC Red Team','Cybersecurity Competition Practice for Red Team','DH126','9/12/2018','CDC');

INSERT INTO events(title,description,place,eventDate,org)
VALUES('Algorithms','Introduction to various algorithms','DH022','9/19/2018','CS Club');

INSERT INTO events(title,description,place,eventDate,org)
VALUES('MegaminerAI','AI Game Coding Competition','Rolla, MO','10/27/2018','ACM');

CREATE TABLE opportunities(
	_id INTEGER PRIMARY KEY AUTOINCREMENT,
	position TEXT,
	description TEXT,
	postDate TEXT,
	isJob BOOLEAN,
	isInternship BOOLEAN,
	isResearch BOOLEAN
);

INSERT INTO opportunities(position,description,postDate,isJob,isInternship,isResearch)
VALUES('Associate Software Developer','Developer position at Vizient. Bachelor degree in computer science or equivalent experience required.','5/10/2018',1,0,0);

INSERT INTO opportunities(position,description,postDate,isJob,isInternship,isResearch)
VALUES('REU','Research positions open at Mizzou for the summer','4/15/2018',0,0,1);

INSERT INTO opportunities(position,description,postDate,isJob,isInternship,isResearch)
VALUES('Database Migration','Need a student to migrate our 20 year old database to a new server. Must have 5 years experience in server administration.','2/1/2017',0,1,0);

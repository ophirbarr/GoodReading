ALTER TABLE Book__author DROP FOREIGN KEY FKBook__auth833047;
ALTER TABLE Book__keywords DROP FOREIGN KEY FKBook__keyw284853;
ALTER TABLE Book__bookFormat DROP FOREIGN KEY FKBook__book212284;
DROP TABLE IF EXISTS BookReview;
DROP TABLE IF EXISTS Domain;
DROP TABLE IF EXISTS SystemUser;
DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Book__author;
DROP TABLE IF EXISTS Book__keywords;
DROP TABLE IF EXISTS Book__bookFormat;
DROP TABLE IF EXISTS Costumer;
DROP TABLE IF EXISTS Subject;
DROP TABLE IF EXISTS Worker;
DROP TABLE IF EXISTS `Book-Subject`;
CREATE TABLE BookReview (_rid int(10) NOT NULL AUTO_INCREMENT, _bid int(10) NOT NULL, _review varchar(255), _costumerName varchar(255), _approved tinyint(1) NOT NULL, PRIMARY KEY (_rid)) ENGINE=InnoDB;
CREATE TABLE Domain (_did int(10) NOT NULL AUTO_INCREMENT, _name varchar(255), PRIMARY KEY (_did)) ENGINE=InnoDB;
CREATE TABLE SystemUser (_uid int(10) NOT NULL AUTO_INCREMENT, _firstName varchar(255), _lastName varchar(255), _userName varchar(255), _password varchar(255), _userStatus int(10), PRIMARY KEY (_uid)) ENGINE=InnoDB;
CREATE TABLE Book (_bid int(10) NOT NULL AUTO_INCREMENT, _title varchar(255), _language varchar(255), _summary varchar(255), _TableOfContents varchar(255), _viewStatus tinyint(1), _price double NOT NULL, _searchLog varchar(255), _purchaseLog varchar(255), _purchaseCount int(10) NOT NULL, _author varchar(255), _keywords varchar(255), _bookFormat varchar(255), PRIMARY KEY (_bid)) ENGINE=InnoDB;
CREATE TABLE Book__author (Book_bid int(10) NOT NULL, BookIndex int(10) NOT NULL, PRIMARY KEY (Book_bid, BookIndex)) ENGINE=InnoDB;
CREATE TABLE Book__keywords (Book_bid int(10) NOT NULL, BookIndex int(10) NOT NULL, PRIMARY KEY (Book_bid, BookIndex)) ENGINE=InnoDB;
CREATE TABLE Book__bookFormat (Book_bid int(10) NOT NULL, BookIndex int(10) NOT NULL, PRIMARY KEY (Book_bid, BookIndex)) ENGINE=InnoDB;
CREATE TABLE Costumer (_uid int(10) NOT NULL AUTO_INCREMENT, _firstName varchar(255), _lastName varchar(255), _userName varchar(255), _password varchar(255), _userStatus int(10), _accountType int(10), _endDate date, _accountStatus tinyint(1) NOT NULL, _waitingForChangeType int(10), PRIMARY KEY (_uid)) ENGINE=InnoDB;
CREATE TABLE Subject (_sid int(10) NOT NULL AUTO_INCREMENT, _name varchar(255), _did int(10) NOT NULL, PRIMARY KEY (_sid)) ENGINE=InnoDB;
CREATE TABLE Worker (_uid int(10) NOT NULL AUTO_INCREMENT, _firstName varchar(255), _lastName varchar(255), _userName varchar(255), _password varchar(255), _userStatus int(10), _wid int(10) NOT NULL, _role varchar(255), _email varchar(255), _department varchar(255), PRIMARY KEY (_uid)) ENGINE=InnoDB;
CREATE TABLE `Book-Subject` (_bid int(10) NOT NULL AUTO_INCREMENT, _sid int(10) NOT NULL, PRIMARY KEY (_bid)) ENGINE=InnoDB;
ALTER TABLE Book__author ADD INDEX FKBook__auth833047 (Book_bid), ADD CONSTRAINT FKBook__auth833047 FOREIGN KEY (Book_bid) REFERENCES Book (_bid);
ALTER TABLE Book__keywords ADD INDEX FKBook__keyw284853 (Book_bid), ADD CONSTRAINT FKBook__keyw284853 FOREIGN KEY (Book_bid) REFERENCES Book (_bid);
ALTER TABLE Book__bookFormat ADD INDEX FKBook__book212284 (Book_bid), ADD CONSTRAINT FKBook__book212284 FOREIGN KEY (Book_bid) REFERENCES Book (_bid);

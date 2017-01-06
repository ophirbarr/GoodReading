DROP TABLE IF EXISTS BookReview;
DROP TABLE IF EXISTS Domain;
DROP TABLE IF EXISTS SystemUser;
DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Subject;
DROP TABLE IF EXISTS `Customer-Book`;
DROP TABLE IF EXISTS `Book-Author`;
DROP TABLE IF EXISTS `Book-Subject`;
DROP TABLE IF EXISTS `Book-Keywords`;
CREATE TABLE BookReview (_rid int(10) NOT NULL AUTO_INCREMENT, _bid int(10) NOT NULL, _review varchar(255), _costumerName varchar(255), _approved tinyint(1), PRIMARY KEY (_rid)) ENGINE=InnoDB;
CREATE TABLE Domain (_did int(10) NOT NULL AUTO_INCREMENT, _name varchar(255), PRIMARY KEY (_did)) ENGINE=InnoDB;
CREATE TABLE SystemUser (_uid int(10) NOT NULL AUTO_INCREMENT, _firstName varchar(255), _lastName varchar(255), _userName varchar(255), _password varchar(255), _userStatus int(10) NOT NULL, _accountType int(10), _endDate date, _accountStatus tinyint(1), _waitingForChangeType int(10), _wid int(10), _role varchar(255), _email varchar(255), _department varchar(255), Discriminator varchar(255) NOT NULL, _ssn int(11) NOT NULL, PRIMARY KEY (_uid)) ENGINE=InnoDB;
CREATE TABLE Book (_bid int(10) NOT NULL AUTO_INCREMENT, _title varchar(255), _language varchar(255), _summary varchar(255), _TableOfContents varchar(255), _viewStatus tinyint(1), _price float NOT NULL, _searchLog varchar(255), _purchaseLog varchar(255), _purchaseCount int(10) NOT NULL, _bookFormat varchar(255), PRIMARY KEY (_bid)) ENGINE=InnoDB;
CREATE TABLE Subject (_sid int(10) NOT NULL AUTO_INCREMENT, _name varchar(255), _did int(10) NOT NULL, PRIMARY KEY (_sid)) ENGINE=InnoDB;
CREATE TABLE `Customer-Book` (ID int(10) NOT NULL AUTO_INCREMENT, _uid int(10) NOT NULL, _bid int(10) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE `Book-Author` (ID int(10) NOT NULL AUTO_INCREMENT, _bid int(10) NOT NULL, _author varchar(255), PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE `Book-Subject` (ID int(10) NOT NULL AUTO_INCREMENT, _bid int(10) NOT NULL, _sid int(10) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE `Book-Keywords` (ID int(10) NOT NULL AUTO_INCREMENT, _bid int(10) NOT NULL, _keyword varchar(255), PRIMARY KEY (ID)) ENGINE=InnoDB;
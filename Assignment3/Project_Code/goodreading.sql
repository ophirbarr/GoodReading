CREATE DATABASE  IF NOT EXISTS `goodreading` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `goodreading`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: goodreading
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `_bid` int(10) NOT NULL AUTO_INCREMENT,
  `_title` varchar(255) DEFAULT NULL,
  `_language` varchar(255) DEFAULT NULL,
  `_summary` varchar(6500) DEFAULT NULL,
  `_TableOfContents` varchar(255) DEFAULT NULL,
  `_viewStatus` tinyint(1) DEFAULT NULL,
  `_price` float NOT NULL,
  `_searchLog` varchar(6500) DEFAULT NULL,
  `_purchaseLog` varchar(6500) DEFAULT NULL,
  `_purchaseCount` int(10) NOT NULL,
  `_bookFormat` varchar(255) DEFAULT NULL,
  `_picPath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`_bid`)
) ENGINE=InnoDB AUTO_INCREMENT=326 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Harry Potter','English','Lord Voldemort is tightening his grip on both the wizarding and Muggle worlds and has chosen Draco Malfoy to carry out a secret mission. Severus Snape makes an Unbreakable Vow with Draco\'s mother, Narcissa, to protect Draco and fulfill the assignment if he fails.\n16-year-old Harry accompanies Albus Dumbledore to visit former Potions professor Horace Slughorn, who has gone into hiding but agrees to return to teach at Hogwarts. Dumbledore then takes Harry to the Burrow, where Harry reunites with his best friends Ron Weasley and Hermione Granger. Harry believes Voldemort has made Draco a Death Eater, after seeing Draco taking part in a ceremony, but Ron and Hermione are skeptical. At Hogwarts, Harry and Ron are forced to borrow textbooks for Slughorn\'s Potions class, and Harry is stuck with a copy that turns out to be filled with helpful notes, instructions, and spells left by the book\'s previous owner, the \"Half-Blood Prince\". Using the book, Harry excels in the class and impresses Slughorn. Ron becomes Keeper of the Gryffindor Quidditch team and forms a romantic relationship with Lavender Brown, upsetting Hermione. Harry consoles Hermione, revealing that he now has feelings for Ron\'s younger sister, Ginny Weasley.\n','chapter 1 			 page 4\nchapter 2 			 page 32',1,29.99,'12/01/17 12/01/17 15/01/17 15/01/17 16/01/17 18/01/17 25/01/17 25/01/17 25/01/17 25/01/17','25/01/17',1,'C:\\GoodReading\\Files\\HarryPotter.pdf C:\\GoodReading\\Files\\HarryPotter.doc C:\\GoodReading\\Files\\HarryPotter.fb2',NULL),(2,'The DaVinci Code','English','Louvre curator and Priory of Sion grand master Jacques Saunière is fatally shot one night at the museum by an albino Catholic monk named Silas, who is working on behalf of someone he knows only as the Teacher, who wishes to discover the location of the \"keystone,\" an item crucial to the search for the Holy Grail. After Saunière\'s body is discovered in the pose of the Vitruvian Man, the police summon Harvard professor Robert Langdon, who is in town on business. Police captain Bezu Fache tells him that he was summoned to help the police decode the cryptic message Saunière left during the final minutes of his life. The message includes a Fibonacci sequence out of order. Langdon explains to Fache that Saunière was a leading authority on the subject of goddess artwork and that the pentacle Saunière drew on his chest in his own blood represents an allusion to the goddess and not devil worship, as Fache thinks.','chapter 1 			 page 3',1,29.99,NULL,NULL,0,'C:\\GoodReading\\Files\\TheDaVinciCode.pdf C:\\GoodReading\\Files\\TheDaVinciCode.doc C:\\GoodReading\\Files\\TheDaVinciCode.fb2',NULL),(3,'Beaufort','Hebrew','Beaufort. To the handful of Israeli soldiers occupying the ancient crusader fortress, it is a little slice of hell—a forbidding, fear-soaked enclave perched atop two acres of land in southern Lebanon, surrounded by an enemy they cannot see. And to the thirteen young men in his command, Twenty-one-year-old Lieutenant Liraz “Erez” Liberti is a taskmaster, confessor, and the only hope in the face of attacks that come out of nowhere and missions seemingly designed to get them all killed. \n\nAll around them, tension crackles in the air. Long stretches of boredom and black humor are punctuated by flashes of terror. And the threat of death is constant. But in their stony haven, Erez and his soldiers have created their own little world, their own rules, their own language. And here Erez listens to his men build castles out of words, telling stories, telling lies, talking incessantly of women, sex, and dead comrades. Until, in the final days of the occupation, Erez and his squad of fed-up, pissed-off, frightened young soldiers are given one last order: a mission that will shatter all remaining illusions—and stand as a testament to the universal, gut-wrenching futility of war.\n','chapter 1 			 page 2',1,29.99,'26/01/17',NULL,0,'C:\\GoodReading\\Files\\Beaufort.pdf C:\\GoodReading\\Files\\Beaufort.doc C:\\GoodReading\\Files\\Beaufort.fb2',NULL),(4,'Eat Pray Love','English','At 32 years old, Elizabeth Gilbert was educated, had a home, a husband, and a successful career as a writer. She was, however, unhappy in her marriage and initiated a divorce. She then embarked on a rebound relationship that did not work out, leaving her devastated and alone. After finalizing her difficult divorce, she spent the next year traveling the world.\nShe spent four months in Italy, eating and enjoying life (\"Eat\"). She spent three months in India, finding her spirituality (\"Pray\"). She ended the year in Bali, Indonesia, looking for \"balance\" of the two and fell in love with a Brazilian businessman (\"Love\").\n','chapter 1 			 page 2',0,29.99,NULL,NULL,0,'C:\\GoodReading\\Files\\EatPrayLove.pdf C:\\GoodReading\\Files\\EatPrayLove.doc C:\\GoodReading\\Files\\EatPrayLove.fb2',NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book-author`
--

DROP TABLE IF EXISTS `book-author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book-author` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `_bid` int(10) NOT NULL,
  `_author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book-author`
--

LOCK TABLES `book-author` WRITE;
/*!40000 ALTER TABLE `book-author` DISABLE KEYS */;
INSERT INTO `book-author` VALUES (1,1,'J.K Rowling'),(2,2,'Dan Brown'),(3,3,'Ron Leshem'),(4,4,'Elizabeth Gilbert');
/*!40000 ALTER TABLE `book-author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book-keywords`
--

DROP TABLE IF EXISTS `book-keywords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book-keywords` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `_bid` int(10) NOT NULL,
  `_keyword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book-keywords`
--

LOCK TABLES `book-keywords` WRITE;
/*!40000 ALTER TABLE `book-keywords` DISABLE KEYS */;
INSERT INTO `book-keywords` VALUES (1,1,'magic'),(2,1,'wizards'),(3,1,'hogwarts'),(4,1,'harry'),(5,1,'potter'),(6,2,'code'),(7,2,'daVinci'),(8,2,'art'),(9,2,'paris'),(10,4,'eat'),(11,4,'pray'),(12,4,'love'),(13,4,'women'),(14,4,'italy'),(15,3,'war'),(16,3,'israel'),(17,3,'idf'),(18,3,'beaufort');
/*!40000 ALTER TABLE `book-keywords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book-subject`
--

DROP TABLE IF EXISTS `book-subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book-subject` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `_bid` int(10) NOT NULL,
  `_sid` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book-subject`
--

LOCK TABLES `book-subject` WRITE;
/*!40000 ALTER TABLE `book-subject` DISABLE KEYS */;
INSERT INTO `book-subject` VALUES (1,1,1),(2,1,4),(3,1,10),(4,2,4),(5,2,1),(6,4,6),(7,4,7),(8,3,9),(9,3,11);
/*!40000 ALTER TABLE `book-subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookreview`
--

DROP TABLE IF EXISTS `bookreview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookreview` (
  `_rid` int(10) NOT NULL AUTO_INCREMENT,
  `_bid` int(10) NOT NULL,
  `_review` varchar(6500) DEFAULT NULL,
  `_costumerName` varchar(255) DEFAULT NULL,
  `_approved` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`_rid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookreview`
--

LOCK TABLES `bookreview` WRITE;
/*!40000 ALTER TABLE `bookreview` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookreview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer-book`
--

DROP TABLE IF EXISTS `customer-book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer-book` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `_uid` int(10) NOT NULL,
  `_bid` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer-book`
--

LOCK TABLES `customer-book` WRITE;
/*!40000 ALTER TABLE `customer-book` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer-book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domain`
--

DROP TABLE IF EXISTS `domain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domain` (
  `_did` int(10) NOT NULL AUTO_INCREMENT,
  `_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`_did`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domain`
--

LOCK TABLES `domain` WRITE;
/*!40000 ALTER TABLE `domain` DISABLE KEYS */;
INSERT INTO `domain` VALUES (1,'Literature'),(2,'Education'),(3,'Travel'),(4,'Culinary'),(5,'Journalism');
/*!40000 ALTER TABLE `domain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `_sid` int(10) NOT NULL AUTO_INCREMENT,
  `_name` varchar(255) DEFAULT NULL,
  `_did` int(10) NOT NULL,
  PRIMARY KEY (`_sid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Fantasy',1),(2,'Sci-Fi',1),(3,'Romance',1),(4,'Thriller',1),(5,'Cook Books',4),(6,'Way of Life',3),(7,'Tour Guide',3),(8,'Magazine',5),(9,'News',5),(10,'Children',1),(11,'War',1);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemuser`
--

DROP TABLE IF EXISTS `systemuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systemuser` (
  `_uid` int(10) NOT NULL AUTO_INCREMENT,
  `_ssn` int(11) NOT NULL,
  `_firstName` varchar(255) DEFAULT NULL,
  `_lastName` varchar(255) DEFAULT NULL,
  `_userName` varchar(255) DEFAULT NULL,
  `_password` varchar(255) DEFAULT NULL,
  `_userStatus` int(10) NOT NULL,
  `_accountType` int(10) DEFAULT NULL,
  `_endDate` date DEFAULT NULL,
  `_accountStatus` tinyint(1) DEFAULT NULL,
  `_waitingForChangeType` int(10) DEFAULT NULL,
  `_wid` int(10) DEFAULT NULL,
  `_role` varchar(255) DEFAULT NULL,
  `_email` varchar(255) DEFAULT NULL,
  `_department` varchar(255) DEFAULT NULL,
  `Discriminator` varchar(255) NOT NULL,
  PRIMARY KEY (`_uid`),
  UNIQUE KEY `_ssn_UNIQUE` (`_ssn`),
  UNIQUE KEY `_email_UNIQUE` (`_email`),
  UNIQUE KEY `_wid_UNIQUE` (`_wid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemuser`
--

LOCK TABLES `systemuser` WRITE;
/*!40000 ALTER TABLE `systemuser` DISABLE KEYS */;
INSERT INTO `systemuser` VALUES (1,300994783,'Tom','Tuna','t','t',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'SystemUser'),(2,300123647,'Ruth','McRuth','ruthy88','4321',0,0,NULL,1,0,NULL,NULL,NULL,NULL,'Customer'),(3,305649264,'John','Test','john_t','1111',0,NULL,NULL,NULL,NULL,100,'Certified Editor','john_t@goodreading.com','Sales','Worker'),(4,201196813,'Yair','Bellin','yair','9786',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'SystemUser'),(5,297402974,'Short','Entry','q','1',0,1,'2017-01-30',1,0,NULL,NULL,NULL,NULL,'Customer'),(6,123456789,'w','w','w','1',0,NULL,NULL,NULL,NULL,123456789,'Certified Editor',NULL,NULL,'Worker'),(7,12345678,'m','m','m','1',0,NULL,NULL,NULL,NULL,12345678,'Manager',NULL,NULL,'Worker'),(8,123456780,'l','l','l','1',0,NULL,NULL,NULL,NULL,123456780,'Librarian',NULL,NULL,'Worker'),(9,102938475,'admin','admin','a','a',0,NULL,NULL,NULL,NULL,102938476,'Admin',NULL,NULL,'Worker'),(11,200860179,'yaara','bellin','yaara','0546809491',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'SystemUser');
/*!40000 ALTER TABLE `systemuser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-26 17:16:51

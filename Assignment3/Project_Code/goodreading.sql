CREATE DATABASE  IF NOT EXISTS `goodreading` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `goodreading`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: goodreading
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
) ENGINE=InnoDB AUTO_INCREMENT=327 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Harry Potter','English','Lord Voldemort is tightening his grip on both the wizarding and Muggle worlds and has chosen Draco Malfoy to carry out a secret mission. Severus Snape makes an Unbreakable Vow with Draco\'s mother, Narcissa, to protect Draco and fulfill the assignment if he fails.\n16-year-old Harry accompanies Albus Dumbledore to visit former Potions professor Horace Slughorn, who has gone into hiding but agrees to return to teach at Hogwarts. Dumbledore then takes Harry to the Burrow, where Harry reunites with his best friends Ron Weasley and Hermione Granger. Harry believes Voldemort has made Draco a Death Eater, after seeing Draco taking part in a ceremony, but Ron and Hermione are skeptical. At Hogwarts, Harry and Ron are forced to borrow textbooks for Slughorn\'s Potions class, and Harry is stuck with a copy that turns out to be filled with helpful notes, instructions, and spells left by the book\'s previous owner, the \"Half-Blood Prince\". Using the book, Harry excels in the class and impresses Slughorn. Ron becomes Keeper of the Gryffindor Quidditch team and forms a romantic relationship with Lavender Brown, upsetting Hermione. Harry consoles Hermione, revealing that he now has feelings for Ron\'s younger sister, Ginny Weasley.\n','chapter 1 			 page 4\nchapter 2 			 page 32',1,29.99,'12/01/17 12/01/17 15/01/17 15/01/17 16/01/17 18/01/17 25/01/17 25/01/17 25/01/17 25/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 28/01/17 28/01/17 28/01/17','25/01/17 27/01/17 28/01/17',3,'C:\\GoodReading\\Files\\HarryPotter.pdf C:\\GoodReading\\Files\\HarryPotter.doc C:\\GoodReading\\Files\\HarryPotter.fb2','C:\\GoodReading\\Pictures\\HarryPotter.jpg'),(2,'The DaVinci Code','English','Louvre curator and Priory of Sion grand master Jacques Saunière is fatally shot one night at the museum by an albino Catholic monk named Silas, who is working on behalf of someone he knows only as the Teacher, who wishes to discover the location of the \"keystone,\" an item crucial to the search for the Holy Grail. After Saunière\'s body is discovered in the pose of the Vitruvian Man, the police summon Harvard professor Robert Langdon, who is in town on business. Police captain Bezu Fache tells him that he was summoned to help the police decode the cryptic message Saunière left during the final minutes of his life. The message includes a Fibonacci sequence out of order. Langdon explains to Fache that Saunière was a leading authority on the subject of goddess artwork and that the pentacle Saunière drew on his chest in his own blood represents an allusion to the goddess and not devil worship, as Fache thinks.','chapter 1 			 page 3',1,29.99,'27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 28/01/17 28/01/17 28/01/17','27/01/17 28/01/17',2,'C:\\GoodReading\\Files\\TheDaVinciCode.pdf C:\\GoodReading\\Files\\TheDaVinciCode.doc C:\\GoodReading\\Files\\TheDaVinciCode.fb2','C:\\GoodReading\\Pictures\\DaVinciCode.jpg'),(3,'Beaufort','Hebrew','Beaufort. To the handful of Israeli soldiers occupying the ancient crusader fortress, it is a little slice of hell—a forbidding, fear-soaked enclave perched atop two acres of land in southern Lebanon, surrounded by an enemy they cannot see. And to the thirteen young men in his command, Twenty-one-year-old Lieutenant Liraz “Erez” Liberti is a taskmaster, confessor, and the only hope in the face of attacks that come out of nowhere and missions seemingly designed to get them all killed. \n\nAll around them, tension crackles in the air. Long stretches of boredom and black humor are punctuated by flashes of terror. And the threat of death is constant. But in their stony haven, Erez and his soldiers have created their own little world, their own rules, their own language. And here Erez listens to his men build castles out of words, telling stories, telling lies, talking incessantly of women, sex, and dead comrades. Until, in the final days of the occupation, Erez and his squad of fed-up, pissed-off, frightened young soldiers are given one last order: a mission that will shatter all remaining illusions—and stand as a testament to the universal, gut-wrenching futility of war.\n','chapter 1 			 page 2',1,29.99,'26/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 27/01/17 28/01/17 28/01/17 28/01/17 28/01/17 28/01/17 28/01/17 28/01/17','27/01/17 28/01/17 28/01/17',3,'C:\\GoodReading\\Files\\Beaufort.pdf C:\\GoodReading\\Files\\Beaufort.doc C:\\GoodReading\\Files\\Beaufort.fb2','C:\\GoodReading\\Pictures\\Beaufort.jpg'),(4,'Eat Pray Love','English','At 32 years old, Elizabeth Gilbert was educated, had a home, a husband, and a successful career as a writer. She was, however, unhappy in her marriage and initiated a divorce. She then embarked on a rebound relationship that did not work out, leaving her devastated and alone. After finalizing her difficult divorce, she spent the next year traveling the world.\nShe spent four months in Italy, eating and enjoying life (\"Eat\"). She spent three months in India, finding her spirituality (\"Pray\"). She ended the year in Bali, Indonesia, looking for \"balance\" of the two and fell in love with a Brazilian businessman (\"Love\").\n','chapter 1 			 page 2',0,29.99,NULL,NULL,0,'C:\\GoodReading\\Files\\EatPrayLove.pdf C:\\GoodReading\\Files\\EatPrayLove.doc C:\\GoodReading\\Files\\EatPrayLove.fb2','C:\\GoodReading\\Pictures\\EatPrayLove.jpg');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookreview`
--

LOCK TABLES `bookreview` WRITE;
/*!40000 ALTER TABLE `bookreview` DISABLE KEYS */;
INSERT INTO `bookreview` VALUES (3,3,'Leshem creates a powerful story of an Israeli soldier\'s life at Beaufort in Southern Lebanon in 98- 00. Its an intense story, following a young commander in the army as he tries to keep his troops sane and alive while fighting for Israel\'s retention of land in the southern part of its northern neighbor. What emerges is this juxtaposition of a seriously unsettled political and military matter with the life of many young \"kids\" (as leshem refers to the soldiers). Its hard to imagine that this is how life is for these soliders, but as we know this is how life is. Many of the soldiers in the story are \"wasted\" and you see how the soldiers learn to cope or at best learn to try. \r\nThis book received a lot of praise when it first was published in Israel in 2006 (under the title \"If Heavens Exist\") and was popularized when read by many soldiers who were fighting in the 2nd israeli-hezbollah conflict. Somewhat of a foreshadowing of the dangers of hezbollah gaining strength and returning an attack, this book must have hit home for the soldiers who read it in 2006 and their families; especially those who lost a son or daughter in battle.','meryl2017',1),(4,3,'I\'m a huge fan of military non-fiction. Caputo, Herr, and Sajer have always been at the top of my favorite authors list, but Lesham gets a major thumbs up. I think Beaufort is fiction (as opposed to non-fiction) but you wouldn\'t be able to tell from reading it since Lesham does such a fantastic job of breathing life into the main character, who weaves his way through the chaos of a war and winds up on the other side thanks to luck more than anything else. This isn\'t a book about heroes and charging machine gun nests. It\'s about one guy and his friends, his troops, who just want to make it out, and I absolutely loved it.','cameron66',1),(5,3,'One of the best military experience books I have read.','arnold12',1),(6,1,'This was a pretty great book and I loved all the suspense, but I still think that it\'s pretty harsh for one of Harry\'s last protectors, and certainly the most powerful, to just... die. It\'s pretty sad but I would definitely continue reading the series and I would recommend these books for anyone who likes a good read. Overall, this is a pretty amazing book and if I were you, I would definitely download this.','meryl2017',1),(7,1,'When I was young, I was an avid book reader. I loved all kinds of books. In high school, I lost interest in reading. The Harry Potter books were so good that I started reading again! It was so entertaining that I would be working and reading at the same time. It was that good. Harry Potter was an ordinary boy who finds out he\'s actually a wizard. A famous one, at that. He was a baby when he somehow defeated the antagonist, Lord Voldemort. Lord Voldermort had disappeared since Harry defeated him as a baby. But Lord Voldemort had resurfaced in recent years and was looking for trouble. Harry, in his 5th year at school, is learning about Lord Voldemort\'s past. Harry needs to learn Lord Voldemort\'s secrets to defeat him once and for all. With the help of his best friends, Ron and Hermione, Harry navigates through the school year of a typical wizarding high school and the dangers of finding Lord Voldemort\'s secrets.\r\n\r\nIt\'s a good book! A definite must read. I would recommend all of Harry Potter books to all ages.','cameron66',1),(8,1,'I got hooked on these books by accident around when the second movie came out. After that, I had to read them all and I was one of those people who would buy the book at the midnight release.\r\nThe same happened with my mother so I started buying them for her on in large print so she could easily read them without straining her eyes.\r\nThe story is simple without being too over-the-top fantasy (my opinion) like other series I could never really get into.','arnold12',1),(9,2,'I read this book when it first came out several years ago. It was my first Dan Brown title, and I have since read many others, including all of tge books in this series. I love the pace, suspense, and intricate weaving of details from both art and history into the book. The story keeps you guessing until the very end and does not disappoint when it finally does close. It is so well done that even when finished it left me with questions and a desire to further read about the historical & Biblical references from the book. If you have ever studied art history or the history of the church and love suspense novels, this book may be for you. Fun, full of suspense, and hard to put down. It kept me happy 12 years ago while on bed rest during a hot July while pregnant (not an easy task!) and I enjoyed it again when I listened to it on Audible it last year. One of my favorite modern fiction titles!','meryl2017',1),(10,2,'I actually really enjoyed this story and thought the overall conspiracy was somewhat plausible. The author did a great job of describing places that I could form a visual image in my head and it also made me look up some places and pieces of art so that I could see what was going on.\r\n\r\nThe characters are likeable and the intensity of the race to the Holy Grail is very suspenseful and kept me engaged in the book and ultimate conclusion. The bad guys have the problem I don’t like in most books which is always being one step ahead of the good guys but in this book it was explained and made perfect sense.\r\n\r\nThe narrator did a good job and I didn’t really have any issues with their narrations, voices or accents.\r\n\r\nMy only issue with the book was the “out of nowhere” romantic storyline that was thrown in at the end of the book. Off-topic note: The character of Robert Langdon is like the preppy version of Indiana Jones that I have to question the casting of Tom Hanks in the role now.','cameron66',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer-book`
--

LOCK TABLES `customer-book` WRITE;
/*!40000 ALTER TABLE `customer-book` DISABLE KEYS */;
INSERT INTO `customer-book` VALUES (4,6,3),(5,6,2),(6,5,1),(7,4,3),(8,4,1),(9,5,3),(10,5,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemuser`
--

LOCK TABLES `systemuser` WRITE;
/*!40000 ALTER TABLE `systemuser` DISABLE KEYS */;
INSERT INTO `systemuser` VALUES (1,300100,'admin','admin','admin','1234',0,NULL,NULL,NULL,NULL,7,'Admin','admin@goodreading.com','Server','Worker'),(2,300101,'Tommy Lee','Jones','tommy1','1',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'SystemUser'),(3,300102,'Edward','Norton','edward1234','1234',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'SystemUser'),(4,300103,'Meryl','Streep','meryl2017','2017',0,0,NULL,1,0,NULL,NULL,NULL,NULL,'Customer'),(5,300104,'Cameron','Diaz','cameron66','66',0,1,'2017-02-17',1,0,NULL,NULL,NULL,NULL,'Customer'),(6,300105,'Arnold','Schwarzenegger','arnold12','12',0,2,'2018-01-18',1,0,NULL,NULL,NULL,NULL,'Customer'),(7,300106,'Pierce','Brosnan','Pierce007','007',0,NULL,NULL,NULL,NULL,1,'Certified Editor','007@goodreading.com','Maintainance','Worker'),(8,300107,'Julia','Louis-Dreyfus','julia21','21',0,NULL,NULL,NULL,NULL,2,'Librarian','jld@goodreading.com','Customer Service','Worker'),(9,300108,'Ben','Stiller','ben101','101',0,NULL,NULL,NULL,NULL,3,'Manager','bens@goodreading.com','Corporate','Worker'),(13,300123,'temp','temp','t','t',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'SystemUser');
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

-- Dump completed on 2017-01-29  0:59:47

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
  `_summary` varchar(255) DEFAULT NULL,
  `_TableOfContents` varchar(255) DEFAULT NULL,
  `_viewStatus` tinyint(1) DEFAULT NULL,
  `_price` float NOT NULL,
  `_searchLog` varchar(255) DEFAULT NULL,
  `_purchaseLog` varchar(255) DEFAULT NULL,
  `_purchaseCount` int(10) NOT NULL,
  `_bookFormat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`_bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book-author`
--

LOCK TABLES `book-author` WRITE;
/*!40000 ALTER TABLE `book-author` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book-keywords`
--

LOCK TABLES `book-keywords` WRITE;
/*!40000 ALTER TABLE `book-keywords` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book-subject`
--

LOCK TABLES `book-subject` WRITE;
/*!40000 ALTER TABLE `book-subject` DISABLE KEYS */;
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
  `_review` varchar(255) DEFAULT NULL,
  `_costumerName` varchar(255) DEFAULT NULL,
  `_approved` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`_rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domain`
--

LOCK TABLES `domain` WRITE;
/*!40000 ALTER TABLE `domain` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemuser`
--

LOCK TABLES `systemuser` WRITE;
/*!40000 ALTER TABLE `systemuser` DISABLE KEYS */;
INSERT INTO `systemuser` VALUES (1,300994783,'Tom','Tuna','tunatom','1234',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'SystemUser'),(2,300123647,'Ruth','McRuth','ruthy88','4321',0,0,NULL,1,0,NULL,NULL,NULL,NULL,'Customer'),(3,305649264,'John','Test','john_t','1111',0,NULL,NULL,NULL,NULL,100,'Certified Editor','john_t@goodreading.com','Sales','Worker');
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

-- Dump completed on 2017-01-06 11:05:32

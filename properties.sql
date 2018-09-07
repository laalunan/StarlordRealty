CREATE DATABASE  IF NOT EXISTS `properties` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `properties`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: properties
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `property` (
  `propertyID` int(11) NOT NULL AUTO_INCREMENT,
  `typeOfProperty` varchar(45) DEFAULT NULL,
  `sellingPrice` double DEFAULT NULL,
  `propertyClassification` varchar(45) DEFAULT NULL,
  `totalArea` double DEFAULT NULL,
  `bedroomCount` int(11) DEFAULT NULL,
  `bathroomCount` int(11) DEFAULT NULL,
  `amenities` varchar(1000) DEFAULT NULL,
  `noOfGarage` int(11) DEFAULT NULL,
  `garageSize` double DEFAULT NULL,
  `yearBuilt` varchar(4) DEFAULT NULL,
  `basement` int(11) DEFAULT NULL,
  `basementDescription` varchar(500) DEFAULT NULL,
  `roofingDescription` varchar(500) DEFAULT NULL,
  `additionalRemarks` varchar(500) DEFAULT NULL,
  `availabilityStatus` varchar(45) DEFAULT NULL,
  `nameOfDeveloper` varchar(100) DEFAULT NULL,
  `nameOfProject` varchar(100) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `dateTime` datetime DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `zipCode` varchar(45) DEFAULT NULL,
  `clickCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`propertyID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,'Sample12312312',10000,'Sample',13,10,10,'10',10,10,'2018',1,'Sample','Sample','Sample','Not Available','Sample','Sample',1,'2018-07-09 16:00:00','Sample','Sample','1234','1234',100),(2,'COMMERCIAL',200000,'FOR SALE',NULL,1,3,'WINE CELLAR, BALCONY, GYM',5,2,'1982',3,'OLD','WHITE','BLUE','NOT AVAILABLE','RBHG','OLD FISH CORP.',1,'1919-01-21 18:45:24','MARIKINA','LAGUNA','PHILIPPINES','1113',50),(3,'RESIDENTIAL',564784,'FOR LEASE/RENT',NULL,4,6,'OCEAN VIEW, POOL, BASKETBALL COURT',8,33,'1992',6,'MACK','YELLOW','CHECKERED','AVAILABLE','RBHG','OLD FISH CORP.',1,'1939-05-21 09:33:23','MARIKINA','LAGUNA','PHILIPPINES','1113',75),(4,'CONDOMINIUM',12,'FOR SALE',NULL,10,22,'STORAGE, PET POUND, DOORMAN',90,14,'1754',9,'WATER JUG','LENOVO','WIRED','NOT AVAILABLE','RAINBOW','RED NOTEBOOK.',5,'1929-08-22 22:12:56','MAKATI','LAGUNA','AMERICA','1413',25);
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-07 18:22:35

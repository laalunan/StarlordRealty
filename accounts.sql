CREATE DATABASE  IF NOT EXISTS `accounts` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `accounts`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: accounts
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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `accounts` (
  `accountID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` char(128) DEFAULT NULL,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `userType` varchar(100) DEFAULT NULL,
  `accountStatus` int(11) DEFAULT NULL,
  `authenticationStatus` int(11) DEFAULT NULL,
  `profilePhoto` blob,
  PRIMARY KEY (`accountID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'jai','jaifontarum@gmail.com','BD3F131A260C9E6A5089EB46CA7EA1711102540805BF9B6CCDCC6F8C0995AF38','Jai','Fontarum','Broker',1,0,NULL),(2,'coleen','coleendizon@gmail.com','BE906B16FF2ABA0F8E448265D8C7B555D4E52FA262AFCAE4F3B2E13139472250','Coleen','Dizon','Admin',1,0,NULL),(3,'james','james@gmail.com','119C9AE6F9CA741BD0A76F87FBA0B22CAB5413187AFB2906AA2875C38E213603','James','Banaag','Broker',1,0,NULL),(4,'lance','laalunan@gmail.com','929DF7FC8CDF44855C5C13C8F4D7EF67A27E5A24453FD2974C214E2FDE89EB47','Lance','Alunan','SalesAgent',1,0,NULL),(5,'christian','christian@gmail.com','DF59C257785D70706A411E70E123AFF2844D6D57EB19F3A071AFC8E019F5F2D8','Christian','Suarez','SalesAgent',1,0,NULL),(6,'julio','julio@gmail.com','901BE86D450C504E8555FFEEEAB1E06B926C8785FD99EF382C1310B7C66BC167','Julio','Arenas','Broker',1,0,NULL),(7,'rapha','rapha@yahoo.com','8AA9D0FBCBBED516405846CCDE9F2E5E6EE97956A9EB32AD17248BF78594C8D3','Rapha','Relucio','Broker',1,0,NULL),(8,'cindy','cindy@gmail.com','002340B41AEE7DA76F4201BF18776291A812F796E20678C563B77B5B6C47C8A1','Cindy','Sabio','SalesAgent',1,0,NULL),(9,'jhed','jhed@gmail.com','FA1809C44DEB6C022005EC7EE8AECEBBB30128C0B06549AC1BFA9A6110D9A6FC','Jhed','Ranoja','Broker',1,0,NULL),(10,'mikha','mikha@yahoo.com','F3FC6F01169A24E2BF2E324276B8B0E4C73625A8599889DEFD10E0EF0278A68F','Mikha','Uriarte','SalesAgent',1,NULL,NULL),(18,'samp','samp','D2A8BFE64F2C5A3EEE912AF3BA696D4EA2200300A99C83A658355BD40CE49B71','samp','samp','Broker',1,NULL,NULL);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `broker_salesagent`
--

DROP TABLE IF EXISTS `broker_salesagent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `broker_salesagent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brokerID` int(11) DEFAULT NULL,
  `salesAgentID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1_idx` (`brokerID`),
  CONSTRAINT `FK1` FOREIGN KEY (`brokerID`) REFERENCES `accounts` (`accountid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `broker_salesagent`
--

LOCK TABLES `broker_salesagent` WRITE;
/*!40000 ALTER TABLE `broker_salesagent` DISABLE KEYS */;
INSERT INTO `broker_salesagent` VALUES (1,1,4),(2,1,5),(3,1,8),(4,1,10);
/*!40000 ALTER TABLE `broker_salesagent` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-13 14:53:45

-- MySQL dump 10.13  Distrib 5.6.23, for osx10.8 (x86_64)
--
-- Host: localhost    Database: 18_del2
-- ------------------------------------------------------
-- Server version	5.6.23

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
-- Current Database: `18_del2`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `18_del2` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `18_del2`;

--
-- Table structure for table `operatoer`
--

DROP TABLE IF EXISTS `operatoer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operatoer` (
  `opr_id` int(11) NOT NULL,
  `opr_navn` text,
  `ini` text,
  `cpr` text,
  `password` text,
  `aktiv` int(1) DEFAULT NULL,
  PRIMARY KEY (`opr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operatoer`
--

LOCK TABLES `operatoer` WRITE;
/*!40000 ALTER TABLE `operatoer` DISABLE KEYS */;
INSERT INTO `operatoer` VALUES (1,'Hej Med Dig','HMD','234897-2342','hello2u',1),(2,'Thomas Liljegren','TLi','1702921745','1234567',1),(3,'Luigi Cool','LC','090990-9009','naellol',1),(4,'Don Juan','DJu','234567-7891','iloveyou',1),(5,'Kofi Anan','KAn','6969696969','yoloyolo',1),(6,'Anders Fogh','AFo','4817824293','annemett',1),(7,'Britney Spears','BSp','1029402949','balislif',1),(8,'Barack Obama','BOb','1234539834','facebook',1),(9,'Lars Larsen','LLa','0203832233','password',1),(10,'Larsen Lars','LaL','0209231823','password',1);
/*!40000 ALTER TABLE `operatoer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produktbatch`
--

DROP TABLE IF EXISTS `produktbatch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produktbatch` (
  `pb_id` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `recept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pb_id`),
  KEY `recept_id` (`recept_id`),
  CONSTRAINT `produktbatch_ibfk_1` FOREIGN KEY (`recept_id`) REFERENCES `recept` (`recept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produktbatch`
--

LOCK TABLES `produktbatch` WRITE;
/*!40000 ALTER TABLE `produktbatch` DISABLE KEYS */;
INSERT INTO `produktbatch` VALUES (1,2,1),(2,2,1),(3,2,2),(4,1,3),(5,0,3);
/*!40000 ALTER TABLE `produktbatch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produktbatchkomponent`
--

DROP TABLE IF EXISTS `produktbatchkomponent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produktbatchkomponent` (
  `pb_id` int(11) NOT NULL DEFAULT '0',
  `rb_id` int(11) NOT NULL DEFAULT '0',
  `tara` double DEFAULT NULL,
  `netto` double DEFAULT NULL,
  `opr_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pb_id`,`rb_id`),
  KEY `rb_id` (`rb_id`),
  KEY `opr_id` (`opr_id`),
  CONSTRAINT `produktbatchkomponent_ibfk_1` FOREIGN KEY (`pb_id`) REFERENCES `produktbatch` (`pb_id`),
  CONSTRAINT `produktbatchkomponent_ibfk_2` FOREIGN KEY (`rb_id`) REFERENCES `raavarebatch` (`rb_id`),
  CONSTRAINT `produktbatchkomponent_ibfk_3` FOREIGN KEY (`opr_id`) REFERENCES `operatoer` (`opr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produktbatchkomponent`
--

LOCK TABLES `produktbatchkomponent` WRITE;
/*!40000 ALTER TABLE `produktbatchkomponent` DISABLE KEYS */;
INSERT INTO `produktbatchkomponent` VALUES (1,1,0.5,10.05,1),(1,2,0.5,2.03,1),(1,4,0.5,1.98,1),(2,1,0.5,10.01,2),(2,2,0.5,1.99,2),(2,5,0.5,1.47,2),(3,1,0.5,10.07,1),(3,3,0.5,2.06,2),(3,4,0.5,1.55,1),(3,6,0.5,1.53,2),(4,1,0.5,10.02,3),(4,5,0.5,1.57,3),(4,6,0.5,1.03,3),(4,7,0.5,0.99,3);
/*!40000 ALTER TABLE `produktbatchkomponent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raavare`
--

DROP TABLE IF EXISTS `raavare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `raavare` (
  `raavare_id` int(11) NOT NULL,
  `raavare_navn` text,
  `leverandoer` text,
  PRIMARY KEY (`raavare_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raavare`
--

LOCK TABLES `raavare` WRITE;
/*!40000 ALTER TABLE `raavare` DISABLE KEYS */;
INSERT INTO `raavare` VALUES (1,'dej','Wawelka'),(2,'tomat','Knoor'),(3,'tomat','Veaubais'),(4,'tomat','Franz'),(5,'ost','Ost og Skinke A/S'),(6,'skinke','Ost og Skinke A/S'),(7,'champignon','Igloo Frostvarer');
/*!40000 ALTER TABLE `raavare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raavarebatch`
--

DROP TABLE IF EXISTS `raavarebatch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `raavarebatch` (
  `rb_id` int(11) NOT NULL,
  `raavare_id` int(11) DEFAULT NULL,
  `maengde` double DEFAULT NULL,
  PRIMARY KEY (`rb_id`),
  KEY `raavare_id` (`raavare_id`),
  CONSTRAINT `raavarebatch_ibfk_1` FOREIGN KEY (`raavare_id`) REFERENCES `raavare` (`raavare_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raavarebatch`
--

LOCK TABLES `raavarebatch` WRITE;
/*!40000 ALTER TABLE `raavarebatch` DISABLE KEYS */;
INSERT INTO `raavarebatch` VALUES (1,1,1000),(2,2,300),(3,3,300),(4,5,100),(5,5,100),(6,6,100),(7,7,100);
/*!40000 ALTER TABLE `raavarebatch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recept`
--

DROP TABLE IF EXISTS `recept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recept` (
  `recept_id` int(11) NOT NULL,
  `recept_navn` text,
  PRIMARY KEY (`recept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recept`
--

LOCK TABLES `recept` WRITE;
/*!40000 ALTER TABLE `recept` DISABLE KEYS */;
INSERT INTO `recept` VALUES (1,'margherita'),(2,'prosciutto'),(3,'capricciosa');
/*!40000 ALTER TABLE `recept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receptkomponent`
--

DROP TABLE IF EXISTS `receptkomponent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receptkomponent` (
  `recept_id` int(11) NOT NULL DEFAULT '0',
  `raavare_id` int(11) NOT NULL DEFAULT '0',
  `nom_netto` double DEFAULT NULL,
  `tolerance` double DEFAULT NULL,
  PRIMARY KEY (`recept_id`,`raavare_id`),
  KEY `raavare_id` (`raavare_id`),
  CONSTRAINT `receptkomponent_ibfk_1` FOREIGN KEY (`recept_id`) REFERENCES `recept` (`recept_id`),
  CONSTRAINT `receptkomponent_ibfk_2` FOREIGN KEY (`raavare_id`) REFERENCES `raavare` (`raavare_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receptkomponent`
--

LOCK TABLES `receptkomponent` WRITE;
/*!40000 ALTER TABLE `receptkomponent` DISABLE KEYS */;
INSERT INTO `receptkomponent` VALUES (1,1,10,0.1),(1,2,2,0.1),(1,5,2,0.1),(2,1,10,0.1),(2,3,2,0.1),(2,5,1.5,0.1),(2,6,1.5,0.1),(3,1,10,0.1),(3,4,1.5,0.1),(3,5,1.5,0.1),(3,6,1,0.1),(3,7,1,0.1);
/*!40000 ALTER TABLE `receptkomponent` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-10 22:45:54

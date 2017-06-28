-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)

--

-- Host: 127.0.0.1    Database: inventory

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

-- Table structure for table `document`

--



DROP TABLE IF EXISTS `document`;

/*!40101 SET @saved_cs_client     = @@character_set_client */;

/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `document` (

  `document_id` int(11) NOT NULL AUTO_INCREMENT,

  `type_doc_Id` int(11) NOT NULL,

  `consecutive` int(11) NOT NULL,

  `document_date` datetime NOT NULL,

  PRIMARY KEY (`document_id`),

  KEY `fk_document_type_doc1_idx` (`type_doc_Id`),

  CONSTRAINT `fk_document_type_doc1` FOREIGN KEY (`type_doc_Id`) REFERENCES `type_doc` (`type_doc_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*!40101 SET character_set_client = @saved_cs_client */;



--

-- Dumping data for table `document`

--



LOCK TABLES `document` WRITE;

/*!40000 ALTER TABLE `document` DISABLE KEYS */;

INSERT INTO `document` VALUES (1,1,1,'2017-06-26 00:00:00'),(2,1,2,'2017-06-26 00:00:00'),(3,2,3,'2017-06-26 00:00:00'),(4,2,4,'2017-06-26 00:00:00'),(8,1,5,'2017-06-26 23:36:24'),(9,1,6,'2017-06-27 13:29:20');

/*!40000 ALTER TABLE `document` ENABLE KEYS */;

UNLOCK TABLES;



--

-- Table structure for table `document_detail`

--



DROP TABLE IF EXISTS `document_detail`;

/*!40101 SET @saved_cs_client     = @@character_set_client */;

/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `document_detail` (

  `document_datail_Id` int(11) NOT NULL AUTO_INCREMENT,

  `document_id` int(11) NOT NULL,

  `Quantity` int(11) NOT NULL,

  `price` float(12,2) NOT NULL,

  `warehouses_Id` int(11) NOT NULL,

  `itemId` int(11) NOT NULL,

  PRIMARY KEY (`document_datail_Id`),

  KEY `fk_document_datail_document1_idx` (`document_id`),

  KEY `fk_document_detail_warehouses1_idx` (`warehouses_Id`),

  KEY `fk_document_detail_items1_idx` (`itemId`),

  CONSTRAINT `fk_document_datail_document1` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT `fk_document_detail_items1` FOREIGN KEY (`itemId`) REFERENCES `items` (`itemId`) ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT `fk_document_detail_warehouses1` FOREIGN KEY (`warehouses_Id`) REFERENCES `warehouses` (`warehouses_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*!40101 SET character_set_client = @saved_cs_client */;



--

-- Dumping data for table `document_detail`

--



LOCK TABLES `document_detail` WRITE;

/*!40000 ALTER TABLE `document_detail` DISABLE KEYS */;

INSERT INTO `document_detail` VALUES (1,1,2,150000.00,1,1),(2,2,1,150000.00,1,2),(3,3,5,150000.00,1,3),(4,4,3,150000.00,1,4),(5,8,1,400000.00,1,2),(6,8,2,4000000.00,1,3),(7,8,3,7500000.00,1,4),(8,8,4,3200000.00,1,5),(9,9,1,400000.00,1,2),(10,9,2,4000000.00,1,3),(11,9,3,7500000.00,1,4),(12,9,4,3200000.00,1,5),(13,9,5,3000000.00,1,6),(14,9,6,2400000.00,1,2);

/*!40000 ALTER TABLE `document_detail` ENABLE KEYS */;

UNLOCK TABLES;



--

-- Table structure for table `items`

--



DROP TABLE IF EXISTS `items`;

/*!40101 SET @saved_cs_client     = @@character_set_client */;

/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `items` (

  `itemId` int(11) NOT NULL AUTO_INCREMENT,

  `code` varchar(45) NOT NULL,

  `name` varchar(45) NOT NULL,

  `lot` int(11) DEFAULT NULL,

  `color` int(11) DEFAULT NULL,

  `size` int(11) DEFAULT NULL,

  `price` float(10,2) NOT NULL DEFAULT '0.00',

  `isActived` tinyint(1) DEFAULT '0',

  PRIMARY KEY (`itemId`)

) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*!40101 SET character_set_client = @saved_cs_client */;



--

-- Dumping data for table `items`

--



LOCK TABLES `items` WRITE;

/*!40000 ALTER TABLE `items` DISABLE KEYS */;

INSERT INTO `items` VALUES (1,'1','Portatil',0,0,0,1500000.00,1),(2,'2','Tablet',0,0,0,400000.00,1),(3,'3','Computador i5',0,0,0,2000000.00,1),(4,'4','Computador i7',0,0,0,2500000.00,1),(5,'5','Monitor 23\"',0,0,0,800000.00,1),(6,'6','Disco Duro SSD 500gb',0,0,0,600000.00,1);

/*!40000 ALTER TABLE `items` ENABLE KEYS */;

UNLOCK TABLES;



--

-- Table structure for table `type_doc`

--



DROP TABLE IF EXISTS `type_doc`;

/*!40101 SET @saved_cs_client     = @@character_set_client */;

/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `type_doc` (

  `type_doc_Id` int(11) NOT NULL AUTO_INCREMENT,

  `code` varchar(4) DEFAULT NULL,

  `name` varchar(45) DEFAULT NULL,

  PRIMARY KEY (`type_doc_Id`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*!40101 SET character_set_client = @saved_cs_client */;



--

-- Dumping data for table `type_doc`

--



LOCK TABLES `type_doc` WRITE;

/*!40000 ALTER TABLE `type_doc` DISABLE KEYS */;

INSERT INTO `type_doc` VALUES (1,'1','Ingreso'),(2,'2','Salida');

/*!40000 ALTER TABLE `type_doc` ENABLE KEYS */;

UNLOCK TABLES;



--

-- Table structure for table `users`

--



DROP TABLE IF EXISTS `users`;

/*!40101 SET @saved_cs_client     = @@character_set_client */;

/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `users` (

  `users_id` int(11) NOT NULL AUTO_INCREMENT,

  `name` varchar(45) DEFAULT NULL,

  `password_user` varchar(45) DEFAULT NULL,

  `idusers_type` int(11) NOT NULL,

  `isActived` tinyint(1) DEFAULT '0',

  PRIMARY KEY (`users_id`),

  KEY `fk_users_users_type_idx` (`idusers_type`),

  CONSTRAINT `fk_users_users_type` FOREIGN KEY (`idusers_type`) REFERENCES `users_type` (`idusers_type`) ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*!40101 SET character_set_client = @saved_cs_client */;



--

-- Dumping data for table `users`

--



LOCK TABLES `users` WRITE;

/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` VALUES (1,'Javier','123456',1,1),(2,'Ramiro','123456',2,1),(3,'David','123456',1,1),(4,'Dz','123456',2,1);

/*!40000 ALTER TABLE `users` ENABLE KEYS */;

UNLOCK TABLES;



--

-- Table structure for table `users_type`

--



DROP TABLE IF EXISTS `users_type`;

/*!40101 SET @saved_cs_client     = @@character_set_client */;

/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `users_type` (

  `idusers_type` int(11) NOT NULL AUTO_INCREMENT,

  `name_type` varchar(45) DEFAULT NULL,

  `code_type` varchar(2) DEFAULT NULL,

  PRIMARY KEY (`idusers_type`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*!40101 SET character_set_client = @saved_cs_client */;



--

-- Dumping data for table `users_type`

--



LOCK TABLES `users_type` WRITE;

/*!40000 ALTER TABLE `users_type` DISABLE KEYS */;

INSERT INTO `users_type` VALUES (1,'Consultas','C'),(2,'Jefe de Bodega','J');

/*!40000 ALTER TABLE `users_type` ENABLE KEYS */;

UNLOCK TABLES;



--

-- Table structure for table `warehouses`

--



DROP TABLE IF EXISTS `warehouses`;

/*!40101 SET @saved_cs_client     = @@character_set_client */;

/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `warehouses` (

  `warehouses_Id` int(11) NOT NULL AUTO_INCREMENT,

  `code` varchar(45) DEFAULT NULL,

  `name` varchar(45) DEFAULT NULL,

  `isActived` tinyint(1) DEFAULT '0',

  PRIMARY KEY (`warehouses_Id`)

) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*!40101 SET character_set_client = @saved_cs_client */;



--

-- Dumping data for table `warehouses`

--



LOCK TABLES `warehouses` WRITE;

/*!40000 ALTER TABLE `warehouses` DISABLE KEYS */;

INSERT INTO `warehouses` VALUES (1,'1','Principal',1);

/*!40000 ALTER TABLE `warehouses` ENABLE KEYS */;

UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;

/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;

/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



-- Dump completed on 2017-06-27 17:44:45


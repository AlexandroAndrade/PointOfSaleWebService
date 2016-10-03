CREATE DATABASE  IF NOT EXISTS `alexandrade` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `alexandrade`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: alexandrade
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `hoyo`
--

DROP TABLE IF EXISTS `hoyo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hoyo` (
  `idHoyo` int(11) NOT NULL AUTO_INCREMENT,
  `Hoyo` varchar(45) NOT NULL,
  `par` int(5) NOT NULL,
  `longitudMetros` int(11) NOT NULL,
  `idSucursal` int(11) NOT NULL,
  PRIMARY KEY (`idHoyo`),
  UNIQUE KEY `uq_Hoyo` (`Hoyo`),
  KEY `fk_idSucursal_idx` (`idSucursal`),
  CONSTRAINT `fk_idSucursal` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoyo`
--

LOCK TABLES `hoyo` WRITE;
/*!40000 ALTER TABLE `hoyo` DISABLE KEYS */;
INSERT  IGNORE INTO `hoyo` (`idHoyo`, `Hoyo`, `par`, `longitudMetros`, `idSucursal`) VALUES (1,'Hoyo 01',5,120,1),(2,'Hoyo 02',4,90,1),(3,'Hoyo 03',4,101,1),(4,'Hoyo 04',4,85,1),(5,'Hoyo 05',5,105,1),(6,'Hoyo 06',4,83,1),(7,'Hoyo 07',3,76,1),(8,'Hoyo 08',3,53,1),(9,'Hoyo 09',3,68,1),(10,'Hoyo 10',4,75,1),(11,'Hoyo 11',5,110,1),(12,'Hoyo 12',5,88,1),(13,'Hoyo 13',5,99,1),(14,'Hoyo 14',6,116,1),(15,'Hoyo 15',4,70,1),(16,'Hoyo 16',4,81,1),(17,'Hoyo 17',4,73,1),(18,'Hoyo 18',5,100,1);
/*!40000 ALTER TABLE `hoyo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juego`
--

DROP TABLE IF EXISTS `juego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `juego` (
  `idJuego` int(11) NOT NULL AUTO_INCREMENT,
  `idSocioGanador` int(11) NOT NULL,
  `totalGolpes` int(11) NOT NULL,
  `fechaJuego` datetime NOT NULL,
  `idTorneo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idJuego`),
  KEY `fk_idSocioGanador` (`idSocioGanador`),
  CONSTRAINT `fk_idSocioGanador` FOREIGN KEY (`idSocioGanador`) REFERENCES `socio` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juego`
--

LOCK TABLES `juego` WRITE;
/*!40000 ALTER TABLE `juego` DISABLE KEYS */;
INSERT  IGNORE INTO `juego` (`idJuego`, `idSocioGanador`, `totalGolpes`, `fechaJuego`, `idTorneo`) VALUES (1,1,100,'2015-10-20 00:00:00',NULL),(2,1,77,'2015-10-20 21:33:12',NULL);
/*!40000 ALTER TABLE `juego` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juegodetalle`
--

DROP TABLE IF EXISTS `juegodetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `juegodetalle` (
  `idJuegoDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `idJuego` int(11) NOT NULL,
  `idSocio` int(11) NOT NULL,
  `idHoyo` int(11) NOT NULL,
  `golpes` int(11) NOT NULL,
  PRIMARY KEY (`idJuegoDetalle`),
  UNIQUE KEY `uq_idJuego_idSocio_idHoyo` (`idJuego`,`idSocio`,`idHoyo`),
  KEY `fk_idSocio` (`idSocio`),
  KEY `fk_idHoyo` (`idHoyo`),
  CONSTRAINT `fk_idHoyo` FOREIGN KEY (`idHoyo`) REFERENCES `hoyo` (`idHoyo`),
  CONSTRAINT `fk_idJuego` FOREIGN KEY (`idJuego`) REFERENCES `juego` (`idJuego`),
  CONSTRAINT `fk_idSocio` FOREIGN KEY (`idSocio`) REFERENCES `socio` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juegodetalle`
--

LOCK TABLES `juegodetalle` WRITE;
/*!40000 ALTER TABLE `juegodetalle` DISABLE KEYS */;
INSERT  IGNORE INTO `juegodetalle` (`idJuegoDetalle`, `idJuego`, `idSocio`, `idHoyo`, `golpes`) VALUES (1,1,1,1,5),(2,1,1,2,4),(3,1,1,3,4),(4,1,1,4,4),(5,1,1,5,5),(6,1,1,6,4),(7,1,1,7,3),(8,1,1,8,3),(9,1,1,9,3),(10,1,1,10,4),(11,1,1,11,5),(12,1,1,12,5),(13,1,1,13,5),(14,1,1,14,6),(15,1,1,15,4),(16,1,1,16,4),(17,1,1,17,4),(18,1,2,1,7),(19,1,2,2,6),(20,1,2,3,6),(21,1,2,4,6),(22,1,2,5,7),(23,1,2,6,6),(24,1,2,7,5),(25,1,2,8,5),(26,1,2,9,5),(27,1,2,10,6),(28,1,2,11,7),(29,1,2,12,7),(30,1,2,13,7),(31,1,2,14,8),(32,1,2,15,6),(33,1,2,16,6),(34,1,2,17,6),(35,1,3,1,8),(36,1,3,2,7),(37,1,3,3,7),(38,1,3,4,7),(39,1,3,5,8),(40,1,3,6,7),(41,1,3,7,6),(42,1,3,8,6),(43,1,3,9,6),(44,1,3,10,7),(45,1,3,11,8),(46,1,3,12,8),(47,1,3,13,8),(48,1,3,14,9),(49,1,3,15,7),(50,1,3,16,7),(51,1,3,17,7),(52,1,3,18,8);
/*!40000 ALTER TABLE `juegodetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(70) NOT NULL,
  `apellidoPaterno` varchar(45) NOT NULL,
  `apellidoMaterno` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `uq_nombre_apellidoPaterno_apellidoMaterno` (`nombres`,`apellidoPaterno`,`apellidoMaterno`),
  UNIQUE KEY `uq_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT  IGNORE INTO `persona` (`idPersona`, `nombres`, `apellidoPaterno`, `apellidoMaterno`, `direccion`, `telefono`, `email`) VALUES (1,'Alex','Andrade','Mtz','Pedro Ampudia #764','436-5749','yngwie_alex@hotmail.com'),(2,'Yngwie','Malmsteen','LannerBack','Highway #67','+1748-9601','ymjl@gmail.com'),(3,'James Alan','Hetfield','','Lincoln Rd. #494, San Francisco, California','+1-887-5467','james.hetfiel@metallica.com'),(5,'Michael','Willy','Schenker','Flower St. #113, Berlin, Germany','+1-555-6744','michael.schenker@michaelSchenkerHimself.com'),(6,'Rudolph','Willy','Schenker','Gleonaks Blvd. #997, Berlin, Germany','+1-690-1342','rudolph.schenker@scorpions.com'),(11,'Guillermo','Ochoa','Ramirez','Mariano Arista #445','9908-9980-546','memo_ochoa@aol.com');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `idSucursal` int(11) NOT NULL,
  `claveSocio` varchar(10) NOT NULL,
  `handicap` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `uq_claveSocio` (`claveSocio`),
  KEY `fk_sucursal_idx` (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT  IGNORE INTO `socio` (`idPersona`, `idSucursal`, `claveSocio`, `handicap`) VALUES (1,1,'AAMTZ',1),(2,1,'YMLNB',0),(3,1,'JAHET',0),(11,1,'GOCHO',1);
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `idSucursal` int(11) NOT NULL AUTO_INCREMENT,
  `nombreSucursal` varchar(45) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  PRIMARY KEY (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT  IGNORE INTO `sucursal` (`idSucursal`, `nombreSucursal`, `direccion`, `telefono`) VALUES (1,'Lomas de Lourdes','Col. Lomas','415-1515'),(3,'Club Campestre de Saltillo A.C.','Blvd. Ricardo Lopez Zertuche # 8650, Col. Los Cárdenas, Saltillo, Coahuila, México. C.P. 25200','(844) 450-1100 | Fax. (844) 450-1128');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idPersona` int(11) NOT NULL,
  `nickName` varchar(45) NOT NULL,
  `password` varchar(1024) NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `uq_nickName` (`nickName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT  IGNORE INTO `usuario` (`idPersona`, `nickName`, `password`) VALUES (5,'michaelS','schenker123'),(6,'rudolphS','rudolphSchener');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-03 18:13:51

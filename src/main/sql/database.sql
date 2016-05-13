CREATE DATABASE  IF NOT EXISTS `pointofsale` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pointofsale`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: pointofsale
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
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulo` (
  `idArticulo` int(11) NOT NULL AUTO_INCREMENT,
  `nombreArticulo` varchar(100) NOT NULL,
  `costoPromedio` float NOT NULL,
  `precioVenta` float NOT NULL,
  `existencias` float NOT NULL,
  `codigoBarras` varchar(45) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `idMarca` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idArticulo`),
  UNIQUE KEY `uq_nombreArticulo` (`nombreArticulo`),
  UNIQUE KEY `uq_codigoBarras` (`codigoBarras`),
  KEY `fk_idProveedor_idx` (`idProveedor`),
  KEY `fk_idMarca_idx` (`idMarca`),
  KEY `fk_idCategoria_idx` (`idCategoria`),
  CONSTRAINT `fk_idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idMarca` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`idMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idProveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT  IGNORE INTO `articulo` (`idArticulo`, `nombreArticulo`, `costoPromedio`, `precioVenta`, `existencias`, `codigoBarras`, `idProveedor`, `idMarca`, `idCategoria`) VALUES (1,'Cloralex Aromas Menta y Eucalipto 2 Lts.',9.99,15.9,100,'8746109109',1,1,18),(2,'Cloralex Limpiador Regular 2 Lts.',19.9,31.9,100,'8746109110',1,1,18),(3,'Cloralex Limpiador Liquido Regular 3.75 Lts.',34.9,55.9,50,'8746109111',1,1,18),(10,'Pinol Jabón Líquido Lavado Floral 1 Lt.',9.99,16.9,75,'8746209101',1,2,18),(11,'Pinol Limpiador Líquido Multiusos Regular 2 Lts.',15.9,24.5,50,'8746209102',1,2,18),(12,'Pinol Limpiador Aromas Lavandas 2 Lts.',19.9,25.9,90,'8746209103',1,2,18),(13,'Ensueño Suavizante Naturaleza Coco Karite 850 ml.',12.9,15.9,100,'9746509101',1,3,18),(14,'Ensueño Suavizante C Plus Primavera Terapia 1.7 Lts.',19.9,26.9,75,'9746509102',1,3,18),(15,'Ensueño Suavizante Zero Enjuague Natural 850 ml.',9.9,13.9,125,'9746509103',1,3,18);
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCategoria` varchar(255) NOT NULL,
  `idCategoriaPadre` int(11) NOT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE KEY `nombreCategoria_UNIQUE` (`nombreCategoria`),
  KEY `FK_idCategoryFather_idx` (`idCategoriaPadre`),
  CONSTRAINT `FK_idCategoryFather` FOREIGN KEY (`idCategoriaPadre`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT  IGNORE INTO `categoria` (`idCategoria`, `nombreCategoria`, `idCategoriaPadre`) VALUES (1,'Electrónica',1),(2,'Pantallas',1),(3,'Teatro en Casa',1),(4,'Audio',1),(5,'Video Juegos',1),(6,'Cámaras',1),(7,'Drones',1),(8,'Hogar',8),(9,'Muebles',8),(10,'Iluminación',8),(11,'Baño',8),(12,'Blancos',8),(13,'Climatización',8),(14,'Organización del Hogar',8),(15,'Cocina',8),(16,'Línea Blanca y Electrodomésticos',8),(17,'Jardín',8),(18,'Limpieza',8);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `idMarca` int(11) NOT NULL AUTO_INCREMENT,
  `nombreMarca` varchar(45) NOT NULL,
  PRIMARY KEY (`idMarca`),
  UNIQUE KEY `uq_nombreMarca` (`nombreMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT  IGNORE INTO `marca` (`idMarca`, `nombreMarca`) VALUES (1,'Cloralex'),(3,'Ensueño'),(2,'Pinol');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombreProveedor` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `codigoPostal` varchar(20) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `pais` varchar(45) NOT NULL,
  `razonSocial` varchar(255) NOT NULL,
  `rfc` varchar(45) NOT NULL,
  PRIMARY KEY (`idProveedor`),
  UNIQUE KEY `uq_razonSocial` (`razonSocial`),
  UNIQUE KEY `uq_rfc` (`rfc`),
  UNIQUE KEY `uq_nombreProveedor` (`nombreProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT  IGNORE INTO `proveedor` (`idProveedor`, `nombreProveedor`, `direccion`, `telefono`, `codigoPostal`, `ciudad`, `estado`, `pais`, `razonSocial`, `rfc`) VALUES (1,'Alen','Blvd Díaz Ordaz #1000, Col. Los Treviño','01-800-8343-300','66150','Santa Catarina','Nuevo León','México','ALEN DEL NORTE S.A. DE C.V.','ALDN843201FG1');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-12 21:26:37

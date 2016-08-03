CREATE DATABASE  IF NOT EXISTS `pointofsalews` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pointofsalews`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: pointofsalews
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
-- Table structure for table `ajusteinventariodetalle`
--

DROP TABLE IF EXISTS `ajusteinventariodetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ajusteinventariodetalle` (
  `idAjusteInventarioDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `idAjusteInventarioTotal` int(11) NOT NULL,
  `idArticulo` int(11) NOT NULL,
  `existenciaAnterior` float NOT NULL,
  `existenciaNueva` float NOT NULL,
  `costoAjuste` float NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idAjusteInventarioDetalle`),
  UNIQUE KEY `idAjusteInventarioDetalle_UNIQUE` (`idAjusteInventarioDetalle`),
  UNIQUE KEY `uq_ajusteInvDetalle_idArticulo_idAjusteInvTotal` (`idArticulo`,`idAjusteInventarioTotal`),
  KEY `fk_AjusteInvDetalle_idAjusteInvTotal_idx` (`idAjusteInventarioTotal`),
  KEY `fk_AjusteInvDetalle_idArticulo_idx` (`idArticulo`),
  CONSTRAINT `fk_AjusteInvDetalle_idAjusteInvTotal` FOREIGN KEY (`idAjusteInventarioTotal`) REFERENCES `ajusteinventariototal` (`idAjusteInventarioTotal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_AjusteInvDetalle_idArticulo` FOREIGN KEY (`idArticulo`) REFERENCES `articulo` (`idArticulo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ajusteinventariodetalle`
--

LOCK TABLES `ajusteinventariodetalle` WRITE;
/*!40000 ALTER TABLE `ajusteinventariodetalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `ajusteinventariodetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ajusteinventariototal`
--

DROP TABLE IF EXISTS `ajusteinventariototal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ajusteinventariototal` (
  `idAjusteInventarioTotal` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `idSucursal` int(11) NOT NULL,
  `fechaAjuste` date NOT NULL,
  `totalExcedentes` float NOT NULL,
  `totalPerdidas` float NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idAjusteInventarioTotal`),
  UNIQUE KEY `idAjusteInventarioTotal_UNIQUE` (`idAjusteInventarioTotal`),
  KEY `fk_AjusteInvTotal_idUsuario_idx` (`idUsuario`),
  KEY `fk_AjusteInvTotal_idSucursal_idx` (`idSucursal`),
  CONSTRAINT `fk_AjusteInvTotal_idSucursal` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_AjusteInvTotal_idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ajusteinventariototal`
--

LOCK TABLES `ajusteinventariototal` WRITE;
/*!40000 ALTER TABLE `ajusteinventariototal` DISABLE KEYS */;
/*!40000 ALTER TABLE `ajusteinventariototal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulo` (
  `idArticulo` int(11) NOT NULL AUTO_INCREMENT,
  `claveArticulo` varchar(255) NOT NULL,
  `nombreArticulo` varchar(255) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `idDepartamento` int(11) NOT NULL,
  `marca` varchar(255) NOT NULL,
  `codigoBarras` varchar(255) NOT NULL,
  `costoPromedio` float NOT NULL,
  `precioVenta` float NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idArticulo`),
  UNIQUE KEY `idArticulo_UNIQUE` (`idArticulo`),
  UNIQUE KEY `claveArticulo_UNIQUE` (`claveArticulo`),
  UNIQUE KEY `nombreArticulo_UNIQUE` (`nombreArticulo`),
  UNIQUE KEY `codigoBarras_UNIQUE` (`codigoBarras`),
  KEY `fk_articulo_idProveedor_idx` (`idProveedor`),
  KEY `fk_articulo_idDepartamento_idx` (`idDepartamento`),
  CONSTRAINT `fk_articulo_idDepartamento` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`idDepartamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_articulo_idProveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT  IGNORE INTO `articulo` (`idArticulo`, `claveArticulo`, `nombreArticulo`, `idProveedor`, `idDepartamento`, `marca`, `codigoBarras`, `costoPromedio`, `precioVenta`, `borradoLogico`) VALUES (1,'cve_01','nombre_01',1,1,'marca_01','0123456789',0,10,'N'),(2,'cve_02','nombre_02',1,1,'marca_02','0123456790',0,11.5,'N'),(3,'cve_03','nombre_03',1,1,'marca_01','0123456791',0,11.6,'N');
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caja` (
  `idCaja` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCaja` varchar(255) NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idCaja`),
  UNIQUE KEY `idCaja_UNIQUE` (`idCaja`),
  UNIQUE KEY `nombreCaja_UNIQUE` (`nombreCaja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
/*!40000 ALTER TABLE `caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `idDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombreDepartamento` varchar(255) NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idDepartamento`),
  UNIQUE KEY `idDepartamento_UNIQUE` (`idDepartamento`),
  UNIQUE KEY `nombreDepartamento_UNIQUE` (`nombreDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT  IGNORE INTO `departamento` (`idDepartamento`, `nombreDepartamento`, `borradoLogico`) VALUES (1,'Abarrotes','N'),(2,'Bebes y Maternidad','N'),(3,'Cigarros','N'),(4,'Cuidado Personal y Belleza','N'),(5,'Desechables','N'),(6,'Detergentes y Limpiadores','N'),(7,'Dulceria y Confiteria','N'),(8,'Farmacia','N'),(9,'Ferreria y Automotriz','N'),(10,'Frutas y Verduras','N'),(11,'Insecticidas y Repelentes','N'),(12,'Lacteos y Huevo','N'),(13,'Mascotas','N'),(14,'Papeleria','N'),(15,'Refrigerados y Congelados','N'),(16,'Reposteria','N'),(17,'Salchichoneria y Quesos','N'),(18,'Vinos, Licores y Cervezas','N');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventario` (
  `idInventario` int(11) NOT NULL AUTO_INCREMENT,
  `idArticulo` int(11) NOT NULL,
  `idSucursal` int(11) NOT NULL,
  `existencias` float NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idInventario`),
  UNIQUE KEY `idInventario_UNIQUE` (`idInventario`),
  UNIQUE KEY `uq_idArticulo_idSucursal` (`idArticulo`,`idSucursal`),
  KEY `fk_idArticulo_idx` (`idArticulo`),
  KEY `fk_idSucursal_idx` (`idSucursal`),
  CONSTRAINT `fk_inventario_idArticulo` FOREIGN KEY (`idArticulo`) REFERENCES `articulo` (`idArticulo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_inventario_idSucursal` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
INSERT  IGNORE INTO `inventario` (`idInventario`, `idArticulo`, `idSucursal`, `existencias`, `borradoLogico`) VALUES (1,1,7,0,'N'),(2,1,2,0,'N'),(3,1,6,0,'N'),(4,1,9,0,'N'),(5,1,3,0,'N'),(6,1,10,0,'N'),(7,1,8,0,'N'),(8,1,4,0,'N'),(9,1,5,0,'N'),(10,1,1,0,'N'),(11,2,3,0,'N'),(12,2,1,0,'N'),(13,2,7,0,'N'),(14,2,2,0,'N'),(15,2,5,0,'N'),(16,2,4,0,'N'),(17,2,6,0,'N'),(18,2,10,0,'N'),(19,2,9,0,'N'),(20,2,8,0,'N'),(21,3,7,0,'N'),(22,3,3,0,'N'),(23,3,10,0,'N'),(24,3,8,0,'N'),(25,3,5,0,'N'),(26,3,2,0,'N'),(27,3,9,0,'N'),(28,3,4,0,'N'),(29,3,6,0,'N'),(30,3,1,0,'N');
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientomercanciadetalle`
--

DROP TABLE IF EXISTS `movimientomercanciadetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimientomercanciadetalle` (
  `idMovimientoMercanciaDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `idMovimientoMercanciaTotal` int(11) NOT NULL,
  `idArticulo` int(11) NOT NULL,
  `cantidad` float NOT NULL,
  `costoPromedio` float NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idMovimientoMercanciaDetalle`),
  UNIQUE KEY `idMovimientoMercanciaDetalle_UNIQUE` (`idMovimientoMercanciaDetalle`),
  UNIQUE KEY `uq_MovMercDetalle_idArticulo_idMovMercTotal` (`idArticulo`,`idMovimientoMercanciaTotal`),
  KEY `fk_MovimientoMercanciaDetalle_idMovimientoMercanciaTotal_idx` (`idMovimientoMercanciaTotal`),
  KEY `fk_MovimientoMercanciaDetalle_idArticulo_idx` (`idArticulo`),
  CONSTRAINT `fk_MovimientoMercanciaDetalle_idArticulo` FOREIGN KEY (`idArticulo`) REFERENCES `articulo` (`idArticulo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_MovimientoMercanciaDetalle_idMovimientoMercanciaTotal` FOREIGN KEY (`idMovimientoMercanciaTotal`) REFERENCES `movimientomercanciatotal` (`idMovimientoMercanciaTotal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientomercanciadetalle`
--

LOCK TABLES `movimientomercanciadetalle` WRITE;
/*!40000 ALTER TABLE `movimientomercanciadetalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimientomercanciadetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientomercanciatotal`
--

DROP TABLE IF EXISTS `movimientomercanciatotal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimientomercanciatotal` (
  `idMovimientoMercanciaTotal` int(11) NOT NULL AUTO_INCREMENT,
  `idSucursal` int(11) NOT NULL,
  `claveTipoMovimiento` varchar(10) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `fechaMovimientoMercancia` date NOT NULL,
  `totalCostoMovimiento` float NOT NULL,
  `numeroRemision` varchar(255) NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idMovimientoMercanciaTotal`),
  UNIQUE KEY `idMovimientoMercanciaTotal_UNIQUE` (`idMovimientoMercanciaTotal`),
  KEY `fk_MovimientoMercanciaTotal_idSucursal_idx` (`idSucursal`),
  KEY `fk_MovimientoMercanciaTotal_claveTipoMovimiento_idx` (`claveTipoMovimiento`),
  KEY `fk_MovimientoMercanciaTotal_idUsuario_idx` (`idUsuario`),
  CONSTRAINT `fk_MovimientoMercanciaTotal_claveTipoMovimiento` FOREIGN KEY (`claveTipoMovimiento`) REFERENCES `tipomovimiento` (`claveTipoMovimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_MovimientoMercanciaTotal_idSucursal` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_MovimientoMercanciaTotal_idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientomercanciatotal`
--

LOCK TABLES `movimientomercanciatotal` WRITE;
/*!40000 ALTER TABLE `movimientomercanciatotal` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimientomercanciatotal` ENABLE KEYS */;
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
  `telefono` varchar(20) NOT NULL,
  `codigoPostal` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `pais` varchar(45) NOT NULL,
  `razonSocial` varchar(255) NOT NULL,
  `rfc` varchar(45) NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idProveedor`),
  UNIQUE KEY `idProveedor_UNIQUE` (`idProveedor`),
  UNIQUE KEY `nombreProveedor_UNIQUE` (`nombreProveedor`),
  UNIQUE KEY `razonSocial_UNIQUE` (`razonSocial`),
  UNIQUE KEY `rfc_UNIQUE` (`rfc`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT  IGNORE INTO `proveedor` (`idProveedor`, `nombreProveedor`, `direccion`, `telefono`, `codigoPostal`, `ciudad`, `estado`, `pais`, `razonSocial`, `rfc`, `borradoLogico`) VALUES (1,'Alimentos Practicos y Selectos, S.A. de C.V.','direccion_01','telefono_01','codigoPostal_01','ciudad_01','estado_01','Mexico','razonSocial_01','rfc_01','N'),(2,'Casa Guerrero Hermanos, S.A. de C.V.','direccion_02','telefono_02','codigoPostal_02','ciudad_02','estado_02','Mexico','razonSocial_02','rfc_02','N'),(3,'Especialidades Comerciales Reyes S.A de C.V','direccion_03','telefono_03','codigoPostal_03','ciudad_03','estado_03','Mexico','razonSocial_03','rfc_03','N'),(4,'Hanan Distribuciones','direccion_04','telefono_04','codigoPostal_04','ciudad_04','estado_04','Mexico','razonSocial_04','rfc_04','N'),(5,'Italy Italy, S.A. de C.V.','direccion_05','telefono_05','codigoPostal_05','ciudad_05','estado_05','Mexico','razonSocial_05','rfc_05','N'),(6,'Mexicana de Abarrotes, S.A. de C.V.','direccion_06','telefono_06','codigoPostal_06','ciudad_06','estado_06','Mexico','razonSocial_06','rfc_06','N'),(7,'Abastecedora de Comercio','direccion_07','telefono_07','codigoPostal_07','ciudad_07','estado_07','Mexico','razonSocial_07','rfc_07','N'),(8,'Diarco, S.A','direccion_08','telefono_08','codigoPostal_08','ciudad_08','estado_08','Mexico','razonSocial_08','rfc_08','N'),(9,'Elafos, S.L.','direccion_09','telefono_09','codigoPostal_09','ciudad_09','estado_09','Mexico','razonSocial_09','rfc_09','N'),(10,'Granja Escalada, S.R.L.','direccion_10','telefono_10','codigoPostal_10','ciudad_10','estado_10','Mexico','razonSocial_10','rfc_10','N'),(11,'Mercado Central de Buenos Aires','direccion_11','telefono_11','codigoPostal_11','ciudad_11','estado_11','Mexico','razonSocial_11','rfc_11','N'),(12,'Miemis Mercados y Servicios','direccion_12','telefono_12','codigoPostal_12','ciudad_12','estado_12','Mexico','razonSocial_12','rfc_12','N'),(13,'Northwestern Selecta, Inc.','direccion_13','telefono_13','codigoPostal_13','ciudad_13','estado_13','Mexico','razonSocial_13','rfc_13','N'),(14,'Portal de Reyes, S.A.','direccion_14','telefono_14','codigoPostal_14','ciudad_14','estado_14','Mexico','razonSocial_14','rfc_14','N'),(15,'Precocinados Angel Bosch, S.L.','direccion_15','telefono_15','codigoPostal_15','ciudad_15','estado_15','Mexico','razonSocial_15','rfc_15','N'),(16,'Productos Lombardi, S.L.','direccion_16','telefono_16','codigoPostal_16','ciudad_16','estado_16','Mexico','razonSocial_16','rfc_16','N'),(17,'Provibuques Rontegui, S.L.','direccion_17','telefono_17','codigoPostal_17','ciudad_17','estado_17','Mexico','razonSocial_17','rfc_17','N');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `idSucursal` int(11) NOT NULL AUTO_INCREMENT,
  `claveSucursal` varchar(45) NOT NULL,
  `nombreSucursal` varchar(255) NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idSucursal`),
  UNIQUE KEY `idSucursal_UNIQUE` (`idSucursal`),
  UNIQUE KEY `claveSucursal_UNIQUE` (`claveSucursal`),
  UNIQUE KEY `nombreSucursal_UNIQUE` (`nombreSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT  IGNORE INTO `sucursal` (`idSucursal`, `claveSucursal`, `nombreSucursal`, `borradoLogico`) VALUES (1,'CEDIS','Centro de Distribución','N'),(2,'CTS','Comercial Treviño de Saltillo','N'),(3,'Bod47','Bodega 47','N'),(4,'Bod50','Bodega 50','N'),(5,'Bod65','Bodega 65','N'),(6,'Bod71','Bodega 71','N'),(7,'Bod75','Bodega 75','N'),(8,'Bod80','Bodega 80','N'),(9,'Bod89','Bodega 89','N'),(10,'Bod90','Bodega 90','N');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipomovimiento`
--

DROP TABLE IF EXISTS `tipomovimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipomovimiento` (
  `claveTipoMovimiento` varchar(10) NOT NULL,
  `tipoMovimiento` varchar(255) NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`claveTipoMovimiento`),
  UNIQUE KEY `claveTipoMovimiento_UNIQUE` (`claveTipoMovimiento`),
  UNIQUE KEY `tipoMovimiento_UNIQUE` (`tipoMovimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipomovimiento`
--

LOCK TABLES `tipomovimiento` WRITE;
/*!40000 ALTER TABLE `tipomovimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipomovimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `idUsuario_UNIQUE` (`idUsuario`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventadetalle`
--

DROP TABLE IF EXISTS `ventadetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventadetalle` (
  `idVentaDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `idVentaTotal` int(11) NOT NULL,
  `idArticulo` int(11) NOT NULL,
  `cantidad` float NOT NULL,
  `costoPromedio` float NOT NULL,
  `previoVenta` float NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idVentaDetalle`),
  UNIQUE KEY `idVentaDetalle_UNIQUE` (`idVentaDetalle`),
  UNIQUE KEY `uq_idVentaTotal_idArticulo` (`idVentaTotal`,`idArticulo`),
  KEY `fk_VentaDetalle_idArticulo_idx` (`idArticulo`),
  KEY `fk_VentaDetalle_idVentaTotal_idx` (`idVentaTotal`),
  CONSTRAINT `fk_VentaDetalle_idArticulo` FOREIGN KEY (`idArticulo`) REFERENCES `articulo` (`idArticulo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_VentaDetalle_idVentaTotal` FOREIGN KEY (`idVentaTotal`) REFERENCES `ventatotal` (`idVentaTotal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventadetalle`
--

LOCK TABLES `ventadetalle` WRITE;
/*!40000 ALTER TABLE `ventadetalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventadetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventatotal`
--

DROP TABLE IF EXISTS `ventatotal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventatotal` (
  `idVentaTotal` int(11) NOT NULL AUTO_INCREMENT,
  `idSucursal` int(11) NOT NULL,
  `idCaja` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `fechaVenta` date NOT NULL,
  `totalVenta` float NOT NULL,
  `cambio` float NOT NULL,
  `numeroTicket` varchar(255) NOT NULL,
  `borradoLogico` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idVentaTotal`),
  UNIQUE KEY `idVentaTotal_UNIQUE` (`idVentaTotal`),
  KEY `fk_VentaTotal_idSucursal_idx` (`idSucursal`),
  KEY `fk_VentaTotal_idCaja_idx` (`idCaja`),
  KEY `fk_VentaTotal_idUsuario_idx` (`idUsuario`),
  CONSTRAINT `fk_VentaTotal_idCaja` FOREIGN KEY (`idCaja`) REFERENCES `caja` (`idCaja`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_VentaTotal_idSucursal` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_VentaTotal_idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventatotal`
--

LOCK TABLES `ventatotal` WRITE;
/*!40000 ALTER TABLE `ventatotal` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventatotal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-03 16:23:02

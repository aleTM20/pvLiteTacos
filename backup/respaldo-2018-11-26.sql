-- MySQL dump 10.16  Distrib 10.1.31-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: taquitos
-- ------------------------------------------------------
-- Server version       10.1.31-MariaDB

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
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `idCompra` int(11) DEFAULT NULL,
  `idgasto` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,1,'activo'),(1,2,'activo'),(1,3,'activo'),(1,4,'activo'),(1,5,'activo'),(1,6,'activo'),(1,7,'activo'),(1,8,'activo'),(1,9,'activo'),(1,10,'activo'),(1,11,'activo'),(1,12,'activo'),(1,13,'activo'),(1,14,'activo'),(1,15,'activo'),(1,16,'activo'),(1,17,'activo'),(1,18,'activo'),(1,19,'activo'),(1,20,'activo'),(1,21,'activo'),(1,22,'activo'),(1,23,'activo'),(1,24,'activo'),(1,25,'activo'),(1,26,'activo'),(1,27,'activo'),(1,28,'activo'),(1,29,'activo'),(1,30,'activo'),(1,31,'activo'),(1,32,'activo'),(1,33,'activo'),(2,34,'activo'),(3,35,'activo'),(4,36,'activo'),(5,37,'activo'),(6,38,'activo');
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gastos`
--

DROP TABLE IF EXISTS `gastos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gastos` (
  `idgasto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` text NOT NULL,
  `gastado` double(10,2) NOT NULL,
  `fecha_gasto` varchar(50) NOT NULL,
  `cantidad` float DEFAULT NULL,
  `idInsumo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idgasto`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gastos`
--

LOCK TABLES `gastos` WRITE;
/*!40000 ALTER TABLE `gastos` DISABLE KEYS */;
INSERT INTO `gastos` VALUES (1,'AGUA ',200.00,'2018-11-21',40,33),(2,'BISTECK',480.00,'2018-11-21',4,2),(3,'BOING GUAYABA ',360.00,'2018-11-21',40,25),(4,'BOING MANGO ',520.00,'2018-11-21',40,24),(5,'CEBOLLA',100.00,'2018-11-21',10,15),(6,'CEBOLLITAS DE CAMBRAY ',100.00,'2018-11-21',10,19),(7,'CERVEZA BOHEMIA ',300.00,'2018-11-21',20,37),(8,'CERVEZA CARTA BLANCA ',300.00,'2018-11-21',20,30),(9,'CERVEZA CORONA ',300.00,'2018-11-21',20,27),(10,'CERVEZA HEINEKEN',300.00,'2018-11-21',20,34),(11,'CERVEZA INDIO',300.00,'2018-11-21',20,26),(12,'CERVEZA TECATE ',300.00,'2018-11-21',20,29),(13,'CERVEZA TECATE LIGHT',300.00,'2018-11-21',20,36),(14,'CERVEZA XX AMBAR',300.00,'2018-11-21',20,35),(15,'CERVEZA XX LAGER AMBAR',300.00,'2018-11-21',20,28),(16,'CHORIZO',240.00,'2018-11-21',3,4),(17,'CHULETA',620.00,'2018-11-21',10,3),(18,'COCA COLA ',360.00,'2018-11-21',40,20),(19,'COSTILLA',1200.00,'2018-11-21',10,6),(20,'FANTA',260.00,'2018-11-21',20,23),(21,'JAMON',1000.00,'2018-11-21',10,7),(22,'PIMIENTO',300.00,'2018-11-21',10,11),(23,'JITOMATE',100.00,'2018-11-21',10,14),(24,'MANZANA ',180.00,'2018-11-21',20,21),(25,'PI+ÊA ',300.00,'2018-11-21',10,13),(26,'POLLO',600.00,'2018-11-21',10,5),(27,'QUESO AMARILLO ',600.00,'2018-11-21',10,17),(28,'QUESO MANCHEGO',1800.00,'2018-11-21',10,10),(29,'QUESO OAXACA',900.00,'2018-11-21',15,9),(30,'SPRITE ',260.00,'2018-11-21',20,22),(31,'TOCINO',1100.00,'2018-11-21',10,8),(32,'TORTILLA',600.00,'2018-11-21',40,12),(33,'TORTILLA DE HARINA',1000.00,'2018-11-21',50,16),(34,'BISTECK',600.00,'2018-11-21',5,2),(35,'QUESO MANCHEGO',1800.00,'2018-11-21',10,10),(36,'COCA COLA ',1512.00,'2018-11-22',168,20),(37,'BOING MANGO ',1560.00,'2018-11-24',120,24),(38,'BOING GUAYABA ',432.00,'2018-11-24',48,25);
/*!40000 ALTER TABLE `gastos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insumos`
--

DROP TABLE IF EXISTS `insumos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insumos` (
  `idInsumo` int(11) NOT NULL AUTO_INCREMENT,
  `insumo` varchar(100) NOT NULL,
  `existencias` float NOT NULL,
  `unidad_medida` varchar(10) NOT NULL,
  `precio_compra` float NOT NULL,
  PRIMARY KEY (`idInsumo`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumos`
--

LOCK TABLES `insumos` WRITE;
/*!40000 ALTER TABLE `insumos` DISABLE KEYS */;
INSERT INTO `insumos` VALUES (1,'PASTOR',63.25,'KG',62),(2,'BISTECK',8.42,'KG',120),(3,'CHULETA',4.2,'KG',62),(4,'CHORIZO',7.36,'KG',80),(5,'POLLO',8.22,'KG',60),(6,'COSTILLA',6.69,'KG',120),(7,'JAMON',8.775,'KG',100),(8,'TOCINO',2.66,'KG',110),(9,'QUESO OAXACA',9.92,'KG',60),(10,'QUESO MANCHEGO',19.825,'KG',180),(11,'PIMIENTO',2.5,'KG',30),(12,'TORTILLA',0.495,'KG',15),(13,'PI+ÊA ',9.7,'KG',30),(14,'JITOMATE',9.825,'KG',10),(15,'CEBOLLA',9.75,'KG',10),(16,'TORTILLA DE HARINA',900.04,'PZA',20),(17,'QUESO AMARILLO ',6.555,'KG',60),(18,'BOLILLO',47,'KG',1.25),(19,'CEBOLLITAS DE CAMBRAY ',10,'KG',10),(20,'COCA COLA ',143,'PZA',9),(21,'MANZANA ',3,'PZA',9),(22,'SPRITE ',6,'PZA',13),(23,'FANTA',8,'PZA',13),(24,'BOING MANGO ',134,'PZA',13),(25,'BOING GUAYABA ',68,'PZA',9),(26,'CERVEZA INDIO',13,'PZA',15),(27,'CERVEZA CORONA ',20,'PZA',15),(28,'CERVEZA XX LAGER AMBAR',13,'PZA',15),(29,'CERVEZA TECATE ',20,'PZA',15),(30,'CERVEZA CARTA BLANCA ',19,'PZA',15),(33,'AGUA ',35,'PZA',5),(34,'CERVEZA HEINEKEN',20,'PZA',15),(35,'CERVEZA XX AMBAR',20,'PZA',15),(36,'CERVEZA TECATE LIGHT',20,'PZA',15),(37,'CERVEZA BOHEMIA ',20,'PZA',15),(38,'TORTILLA MAIZ',19,'KG',13);
/*!40000 ALTER TABLE `insumos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insumovencido`
--

DROP TABLE IF EXISTS `insumovencido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insumovencido` (
  `idInsumo` int(11) DEFAULT NULL,
  `insumo` varchar(20) DEFAULT NULL,
  `cantidad` float DEFAULT NULL,
  `fechaDev` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumovencido`
--

LOCK TABLES `insumovencido` WRITE;
/*!40000 ALTER TABLE `insumovencido` DISABLE KEYS */;
/*!40000 ALTER TABLE `insumovencido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventario` (
  `idProducto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text NOT NULL,
  `tipoproducto` varchar(100) NOT NULL,
  `precio` float NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'TACO','BISTECK','COMIDA',14,1),(2,'TACO','CHORIZO','COMIDA',14,1),(3,'TACO BISTEC','TORTILLA DE HARINA','COMIDA',18,1),(4,'TACO CHORIZO','TORTILLA DE HARINA','COMIDA',18,1),(5,'TACO ','AL PASTOR ','COMIDA',7,1),(6,'TACO PASTOR','TORTILLA DE HARINA','COMIDA',12,1),(7,'TACO ','CHULETA ','COMIDA',14,1),(8,'TACO CHULETA ','TORTILLA DE HARINA','COMIDA',18,1),(9,'TACO ','POLLO ','COMIDA',14,1),(10,'TACO POLLO ','TORTILLA DE HARINA','COMIDA',18,1),(11,'TACO ','COSTILLA ','COMIDA',14,1),(12,'TACO COSTILLA ','TORTILLA DE HARINA ','COMIDA',18,1),(13,'TACO ','CAMPECHANO ','COMIDA',14,1),(14,'TACO CAMPECHANO ','TORTILLA DE HARINA ','COMIDA',18,1),(15,'COSTILLA','ROAST BEEF','COMIDA',50,1),(16,'COSTILLA ROAST',' CON QUESO','COMIDA',55,1),(17,'COSTILLA ROAST ','CON ENSALADA','COMIDA',65,1),(18,'BISTEC CON QUESO','ORDEN ','COMIDA',65,1),(19,'COMBINADO','ORDEN ','COMIDA',65,1),(20,'ALAMBRE','ORDEN ','COMIDA',70,1),(21,'CEBOLLITAS DE CAMBRAY ','ORDEN ','COMIDA',15,1),(22,'GRINGA ','AL PASTOR ','COMIDA',25,2),(23,'GRINGA  ','BISTECK ','COMIDA',30,1),(24,'SINCRONIZADA','SENCILLA ','COMIDA',20,1),(25,'SINCRONIZADA  ESP',' BISTECK','COMIDA',35,1),(26,'NORTE+ÊA','NORTE+ÊA','COMIDA',12,1),(27,'QUESO FUNDIDO','TOLUQUE+ÊO ','COMIDA',65,1),(28,'QUESO FUNDIDO ','MEXICANO ','COMIDA',65,1),(29,'ENCEBOLLADO ','ENCEBOLLADO ','COMIDA',55,1),(30,'QUESO FUNDIDO ','MANCHEGO ','COMIDA',50,1),(31,'QUESO FUNDIDO ','SUIZO ','COMIDA',50,1),(32,'HUARACHE','SENCILLO ','COMIDA',25,1),(33,'HUARACHE ','CON POLLO ','COMIDA',50,1),(34,'HUARCHE ','CON BISTECK ','COMIDA',50,1),(35,'HUARACHE ','DE COSTILLA','COMIDA',50,1),(36,'HUARACHE ','CAMPECHANO ','COMIDA',50,1),(37,'COCA COLA ','VIDRIO','BEBIDA',13,2),(38,'MANZANA ','VIDRIO ','BEBIDA',13,2),(39,'SPRITE','VIDRIO','BEBIDA',13,2),(40,'FANTA','VIDRIO ','BEBIDA',13,2),(41,'BOING ','GUAYABA ','BEBIDA',13,2),(42,'BOING ','MANGO ','BEBIDA',13,2),(43,'CERVEZA INDIO','CERVEZA','COMIDA',22,1),(44,'GRINGA ','CAMPECHANA ','COMIDA',30,1),(45,'COCA COLA','VIDRIO ','COMIDA',13,1),(46,'MANZANITA','VIDRIO','COMIDA',13,1),(47,'SPRITE','VIDRIO','COMIDA',13,1),(48,'FANTA','VIDRIO','COMIDA',13,1),(49,'BOING ','MANGO','COMIDA',13,1),(50,'BOING','GUAYABA','COMIDA',13,1),(51,'GRINGA','AL PASTOR','COMIDA',25,1),(52,'CERVEZA CORONA ','CERVEZA','COMIDA',22,1),(53,'CERVEZA XX LAGER ','CERVEZA','COMIDA',22,1),(54,'CERVEZA TECATE ','TECATE ROJA','COMIDA',22,1),(55,'CERVEZA TECATE','LIGHT','COMIDA',22,1),(56,'CERVEZA HEINE','HEINEKEN ','COMIDA',22,1),(57,'CERVEZA XX','AMBAR','COMIDA',22,1),(58,'CERVEZA CARTA','BLANCA ','COMIDA',50,1),(59,'ESCARCHADO MED','CORONA ','COMIDA',26,1),(60,'ESCARCHADO MED ','XX LAGER','COMIDA',26,1),(61,'ESCARCHADO MED ','HEINECKEN ','COMIDA',26,1),(62,'ESCARCHADOS MED','TECATE ','COMIDA',26,1),(63,'ESCARCHADO MED','TECATE LIGHT','COMIDA',26,1),(64,'ESCARCHADO MED ','XX AMBAR ','COMIDA',26,1),(65,'ESCARCHADO LITRO ','CARTA BLANCA ','COMIDA',50,1),(66,'ESCARCHADO MED ','BOHEMIA','COMIDA',26,1),(67,'AGUA','NATURAL','COMIDA',13,1),(68,'TORTA','PASTOR','COMIDA',20,1),(69,'TORTA','BISTCK','COMIDA',30,1),(70,'TORTA','CHORIZO','COMIDA',30,1),(71,'TORTA','CHULETA','COMIDA',30,1),(72,'TORTA','POLLO','COMIDA',30,1),(73,'TORTA','CAMPECHANO','COMIDA',30,1),(74,'TORTA','COSTILLA','COMIDA',30,1),(75,'HUARACHE','CHORIZO','COMIDA',50,1),(76,'HUARACHE','CHULETA','COMIDA',50,1),(77,'HUARACHE','PASTOR','COMIDA',50,1),(78,'GRINGA ','CHORIZO','COMIDA',30,1),(79,'GRINGA','POLLO','COMIDA',30,1),(80,'GRINGA','COSTILLA','COMIDA',30,1),(81,'GRINGA','CHULETA','COMIDA',30,1),(82,'SINCRONIZADA ','ENCHILADA','COMIDA',22,2),(83,'SINCRONIZADA SENC','ENCHILADA','COMIDA',22,1),(84,'TACO BISTEC','TORT.MAIZ QUESO','COMIDA',16,1),(85,'TACO PASTOR','TORT.MAIZ QUESO','COMIDA',10,1),(86,'TACO CHORIZO','TORT.MAIZ QUESO','COMIDA',16,1),(87,'TACO CHULETA','TORT.MAIZ QUESO','COMIDA',16,1),(88,'TACO POLLO','TORT.MAIZ QUESO','COMIDA',16,1),(89,'TACO CAMPECHANO','TORT.MAIZ QUESO','COMIDA',16,1),(90,'TACO COSTILLA','TORT.MAIZ QUESO','COMIDA',16,1),(91,'SINCRONIZADA ESPECIAL','CHORIZO','COMIDA',35,1),(92,'SINCRONIZADA ESPECIAL','CHULETA','COMIDA',35,1),(93,'SINCRONIZADA ESPECIAL','POLLO','COMIDA',35,1),(94,'SINCRONIZADA ESPECIAL','PASTOR','COMIDA',35,2),(95,'SINCRONIZADA ESPECIAL','PASTOR','COMIDA',35,1),(96,'SINCRONIZADA ESPECIAL','CAMPECHANA','COMIDA',35,1),(97,'SINCRONIZADA ESPECIAL ','COSTILLA','COMIDA',35,1),(98,'SINCRO ESPE ENCHI','BISTECK','COMIDA',37,1),(99,'SINCRO ESP ENCH','CHORIZO','COMIDA',37,1),(100,'SINCRO ESP ENCH','CHULETA','COMIDA',37,1),(101,'SINCRO ESP ENCH','POLLO','COMIDA',37,1),(102,'SINCRO ESP ENCH','PASTOR','COMIDA',37,1),(103,'SINCRO ESP ENCH','CAMPECHANA','COMIDA',37,1),(104,'SINCRO ESP ENCH','COSTILLA','COMIDA',37,1),(105,'KILO','PASTOR','COMIDA',260,1),(106,'MEDIO KILO','PASTOR','COMIDA',130,1),(107,'CUARTO DE KILO','PASTOR','COMIDA',65,1),(108,'KILO','BISTEK','COMIDA',280,1),(109,'MEDIO KILO','BISTEK','COMIDA',140,1),(110,'CUARTO DE KILO','BISTEK','COMIDA',70,1),(111,'KILO','CHORIZO','COMIDA',280,1),(112,'MEDIO KILO','CHORIZO','COMIDA',140,1),(113,'CUARTO DE KILO','CHORIZO','COMIDA',70,1),(114,'KILO','POLLO','COMIDA',280,1),(115,'MEDIO KILO','POLLO','COMIDA',140,1),(116,'CUARTO DE KILO','POLLO','COMIDA',70,1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reseta`
--

DROP TABLE IF EXISTS `reseta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reseta` (
  `idproducto` int(11) DEFAULT NULL,
  `idInsumo` int(11) DEFAULT NULL,
  `cantidadInsumo` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reseta`
--

LOCK TABLES `reseta` WRITE;
/*!40000 ALTER TABLE `reseta` DISABLE KEYS */;
INSERT INTO `reseta` VALUES (1,2,0.05),(1,12,0.07),(2,4,0.05),(2,12,0.07),(3,2,0.07),(3,16,1),(3,9,0.02),(4,4,0.07),(4,16,1),(4,9,0.02),(5,1,0.04),(5,12,0.07),(6,1,0.04),(6,16,1),(6,9,0.02),(7,3,0.05),(7,12,0.07),(8,3,0.07),(8,16,1),(8,9,0.02),(9,5,0.05),(9,12,0.07),(10,5,0.07),(10,16,1),(10,9,0.02),(11,6,0.05),(11,16,0.07),(12,6,0.07),(12,16,1),(12,9,0.02),(13,2,0.025),(13,4,0.025),(13,12,0.07),(14,16,1),(14,2,0.035),(14,4,0.035),(14,9,0.02),(15,6,0.165),(16,6,0.165),(16,9,0.05),(17,6,0.165),(18,2,0.165),(18,9,0.05),(19,2,0.05),(19,4,0.05),(19,9,0.05),(20,2,0.05),(20,8,0.05),(20,11,0.05),(20,15,0.025),(20,9,0.05),(20,3,0.05),(21,4,0.5),(22,11,0.1),(22,12,2),(22,8,0.1),(23,2,0.1),(23,12,2),(23,8,0.1),(24,14,0.025),(24,10,0.025),(24,8,0.02),(24,12,2),(25,2,0.06),(25,14,0.025),(25,10,0.025),(25,8,0.02),(25,12,2),(26,8,0.15),(26,12,1),(27,9,0.2),(27,3,0.15),(28,9,0.2),(28,2,0.15),(29,9,0.2),(29,15,0.15),(30,9,0.4),(31,13,0.15),(31,12,0.095),(31,8,0.1),(32,12,0.13),(32,8,0.1),(33,17,0.11),(33,16,0.13),(33,8,0.1),(34,2,0.1),(34,16,0.13),(34,8,0.1),(35,16,0.13),(35,7,0.11),(35,8,0.1),(36,3,0.055),(36,2,0.055),(36,16,0.1),(36,8,0.1),(43,11,1),(44,2,0.05),(44,4,0.05),(44,16,2),(45,20,1),(46,21,1),(47,22,1),(48,23,1),(49,24,1),(50,25,1),(51,1,0.05),(51,16,2),(52,27,1),(53,28,1),(54,29,1),(55,4,1),(56,26,1),(57,3,1),(58,30,1),(59,27,1),(60,20,1),(61,26,1),(62,28,1),(63,4,1),(64,3,1),(65,30,1),(66,30,1),(67,33,1),(68,17,0.12),(68,18,1),(68,16,0.15),(69,2,0.12),(69,18,1),(69,16,0.15),(70,18,1),(70,32,0.12),(70,16,0.15),(71,18,1),(71,31,0.12),(71,16,0.15),(72,18,1),(72,16,0.15),(72,22,0.12),(73,18,1),(73,2,0.06),(73,32,0.06),(73,16,0.15),(74,18,1),(74,7,0.12),(74,16,0.15),(75,32,0.11),(75,16,0.1),(75,2,0.13),(76,31,0.11),(76,16,0.1),(76,2,0.13),(77,17,0.11),(77,16,0.1),(77,2,0.13),(78,4,0.1),(78,16,2),(78,9,0.1),(79,5,0.1),(79,16,2),(79,9,0.1),(80,6,0.1),(80,16,2),(80,9,0.1),(81,3,0.1),(81,16,2),(81,9,0.1),(82,7,0.025),(82,17,0.025),(82,9,0.02),(82,16,2),(83,7,0.025),(83,17,0.025),(83,9,0.02),(83,16,2),(84,38,1),(84,2,0.07),(84,9,0.02),(85,38,1),(85,1,0.07),(85,9,0.02),(86,4,0.07),(86,38,1),(86,9,0.02),(87,3,0.07),(87,9,0.02),(87,38,1),(88,38,1),(88,5,0.07),(88,9,0.02),(89,2,0.035),(89,4,0.035),(89,38,1),(89,9,0.02),(90,6,0.07),(90,38,1),(90,9,0.02),(91,7,0.025),(91,17,0.025),(91,9,0.02),(91,16,2),(91,4,0.06),(92,7,0.025),(92,17,0.025),(92,9,0.02),(92,16,2),(92,3,0.06),(93,7,0.025),(93,17,0.025),(93,9,0.02),(93,16,2),(93,5,0.06),(94,7,0.025),(94,17,0.025),(95,7,0.025),(95,17,0.025),(95,9,0.02),(95,16,2),(95,1,0.06),(96,7,0.025),(96,17,0.025),(96,9,0.02),(96,16,2),(96,2,0.06),(96,4,0.06),(97,7,0.025),(97,17,0.025),(97,9,0.02),(97,16,2),(97,6,0.06),(98,7,0.025),(98,17,0.025),(98,9,0.02),(98,16,2),(98,2,0.06),(99,7,0.025),(99,17,0.025),(99,9,0.02),(99,16,2),(99,4,0.06),(100,7,0.025),(100,17,0.025),(100,9,0.02),(100,16,2),(100,3,0.06),(101,7,0.025),(101,17,0.025),(101,9,0.02),(101,16,2),(101,5,0.06),(102,7,0.025),(102,17,0.025),(102,9,0.02),(102,16,2),(102,1,0.06),(103,7,0.025),(103,17,0.025),(103,9,0.02),(103,16,2),(103,4,0.03),(103,2,0.03),(104,7,0.025),(104,17,0.025),(104,9,0.02),(104,16,2),(104,6,0.06),(105,1,1),(106,1,0.5),(107,1,0.25),(108,2,1),(109,2,0.5),(110,2,0.25),(111,4,1),(112,4,0.5),(113,4,0.25),(114,5,0.1),(115,5,0.5),(116,5,0.25);
/*!40000 ALTER TABLE `reseta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `idTicket` int(20) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `total` float DEFAULT NULL,
  `vendedor` varchar(50) DEFAULT NULL,
  `mesa` varchar(20) DEFAULT NULL,
  `STATUS` varchar(20) DEFAULT NULL,
  `hora` varchar(20) DEFAULT NULL,
  `efectivo` float DEFAULT NULL,
  PRIMARY KEY (`idTicket`)
) ENGINE=InnoDB AUTO_INCREMENT=207 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,'2018-11-21',83,'Juan Claudio','M19','1','04:58:22',200),(2,'2018-11-21',410,'German','M5','1','05:15:56',0),(3,'2018-11-21',35,'German','P3','1','05:25:23',0),(4,'2018-11-21',144,'Lola Martinez','M10','1','05:30:45',0),(5,'2018-11-21',65,'German','P4','1','05:38:09',200),(6,'2018-11-21',60,'Laura Hern+Ìndez','M12','1','05:41:52',0),(7,'2018-11-21',109,'Alejandra Galindo','M14','1','05:45:00',0),(8,'2018-11-21',193,'Alejandra Galindo','M3','1','06:23:36',200),(9,'2018-11-21',155,'Alejandra Galindo','M4','2','06:27:38',200),(10,'2018-11-21',263,'Juan Claudio','M2','1','06:29:36',500),(11,'2018-11-21',189,'German','M13','1','06:34:14',0),(12,'2018-11-21',150,'Alejandra Galindo','M4','1','06:34:23',200),(13,'2018-11-21',35,'German','M12','1','06:38:36',50),(14,'2018-11-21',103,'MARCO ANTONIO ROCHA MARTINEZ','M15','1','07:04:51',0),(15,'2018-11-21',183,'juan claudio','M10','1','07:04:57',0),(16,'2018-11-22',30,'juan claudio','M19','1','10:58:22',0),(17,'2018-11-22',103,'alejandra galindo','M12','1','11:08:27',0),(18,'2018-11-22',83,'alejandra galindo','M11','1','11:13:41',100),(19,'2018-11-22',159,'alejandra galindo','M16','1','11:14:17',200),(20,'2018-11-22',154,'alejandra galindo','P4','1','11:23:39',156),(21,'2018-11-22',96,'juan claudio','M15','1','11:32:09',100),(22,'2018-11-22',120,'alejandra galindo','P4','1','11:50:35',200),(23,'2018-11-22',68,'Laura Hern+Ìndez','M1','1','11:51:26',70),(24,'2018-11-22',121,'juan claudio','M11','1','11:53:00',150),(25,'2018-11-22',60,'alejandra galindo','P5','1','00:03:57',60),(26,'2018-11-22',48,'alejandra galindo','M2','1','00:09:06',50),(27,'2018-11-22',70,'Laura Hern+Ìndez','M19','1','00:10:52',0),(28,'2018-11-22',132,'alejandra galindo','M13','1','00:23:03',140),(29,'2018-11-22',76,'juan claudio','M4','1','00:24:49',0),(30,'2018-11-22',74,'alejandra galindo','M10','1','00:55:06',80),(31,'2018-11-22',100,'Laura Hern+Ìndez','M1','1','01:01:27',100),(32,'2018-11-22',148,'juan claudio','M2','1','01:11:39',500),(33,'2018-11-22',76,'alejandra galindo','M10','1','01:20:42',90),(34,'2018-11-22',35,'alejandra galindo','P6','1','01:37:39',0),(35,'2018-11-22',83,'juan claudio','M11','1','01:44:03',100),(36,'2018-11-22',130,'Laura Hern+Ìndez','M3','1','01:47:35',200),(37,'2018-11-22',100,'juan claudio','M1','1','01:50:22',500),(38,'2018-11-22',105,'Laura Hern+Ìndez','M16','1','02:02:23',0),(39,'2018-11-22',118,'alejandra galindo','M9','1','02:06:28',1200),(40,'2018-11-22',41,'alejandra galindo','M1','1','02:06:49',100),(41,'2018-11-22',151,'Laura Hern+Ìndez','M10','1','02:16:47',0),(42,'2018-11-22',55,'alejandra galindo','P6','1','02:18:01',100),(43,'2018-11-22',65,'Laura Hern+Ìndez','M2','1','02:20:43',65),(44,'2018-11-22',48,'alejandra galindo','M15','1','02:38:46',100),(45,'2018-11-22',64,'juan claudio','M14','1','02:52:13',64),(46,'2018-11-22',168,'juan claudio','M2','1','03:34:35',0),(47,'2018-11-22',110,'alejandra galindo','M10','1','03:59:20',0),(48,'2018-11-22',268,'Lola Martinez','P1','1','04:05:19',0),(49,'2018-11-22',73,'alejandra galindo','M3','1','04:17:08',0),(50,'2018-11-22',126,'alejandra galindo','B1','1','04:20:05',0),(51,'2018-11-22',196,'alejandra galindo','M18','1','04:30:28',0),(52,'2018-11-22',131,'alejandra galindo','M11','1','04:31:42',0),(53,'2018-11-22',162,'juan claudio','M15','1','04:32:58',0),(54,'2018-11-22',269,'alejandra galindo','M5','1','04:35:41',0),(55,'2018-11-22',130,'juan claudio','M7','1','04:38:29',0),(56,'2018-11-22',80,'juan claudio','M13','1','04:38:37',0),(57,'2018-11-22',69,'alejandra galindo','M10','1','04:40:58',0),(58,'2018-11-22',48,'Laura Hern+Ìndez','B1','1','04:49:13',0),(59,'2018-11-22',352,'Lola Martinez','M9','1','04:56:31',0),(60,'2018-11-22',200,'juan claudio','M2','1','05:01:36',0),(61,'2018-11-22',131,'alejandra galindo','M13','1','05:09:56',0),(62,'2018-11-22',168,'alejandra galindo','M15','1','05:10:04',0),(63,'2018-11-22',75,'juan claudio','M18','1','05:24:17',0),(64,'2018-11-22',62,'Laura Hern+Ìndez','M16','1','05:24:46',0),(65,'2018-11-22',115,'Lola Martinez','M11','1','05:25:43',0),(66,'2018-11-22',123,'alejandra galindo','M3','1','05:28:30',0),(67,'2018-11-22',89,'Laura Hern+Ìndez','M8','1','05:39:04',0),(68,'2018-11-22',83,'alejandra galindo','B1','1','05:40:55',0),(69,'2018-11-22',84,'Laura Hern+Ìndez','M12','1','05:44:42',0),(70,'2018-11-22',35,'alejandra galindo','M5','1','05:45:18',0),(71,'2018-11-22',64,'alejandra galindo','P6','1','05:47:50',0),(72,'2018-11-22',45,'juan claudio','M1','1','05:50:29',0),(73,'2018-11-22',151,'juan claudio','M7','1','05:50:58',0),(74,'2018-11-22',84,'juan claudio','M3','1','05:52:02',0),(75,'2018-11-22',35,'alejandra galindo','B1','1','05:52:58',0),(76,'2018-11-22',70,'alejandra galindo','M2','1','06:09:51',0),(77,'2018-11-22',82,'juan claudio','M13','1','06:12:05',0),(78,'2018-11-22',86,'Lola Martinez','M17','1','06:15:58',0),(79,'2018-11-23',148,'juan claudio','M7','1','10:35:34',0),(80,'2018-11-23',96,'Pablo Sanabria','M2','1','10:36:14',0),(81,'2018-11-23',123,'juan claudio','M1','1','10:54:28',0),(82,'2018-11-23',40,'alejandra galindo','P3','1','11:14:55',50),(83,'2018-11-23',123,'alejandra galindo','M19','1','11:18:09',0),(84,'2018-11-23',77,'alejandra galindo','M1','1','11:20:00',100),(85,'2018-11-23',50,'juan claudio','M15','1','11:27:37',0),(86,'2018-11-23',66,'alejandra galindo','B1','1','11:31:40',100),(87,'2018-11-23',114,'juan claudio','M1','1','11:49:11',0),(88,'2018-11-23',66,'alejandra galindo','M3','1','00:05:01',0),(89,'2018-11-23',41,'alejandra galindo','M12','1','00:10:23',0),(90,'2018-11-23',191,'juan claudio','M11','1','00:18:16',0),(91,'2018-11-23',295,'juan claudio','M9','1','00:27:29',0),(92,'2018-11-23',53,'alejandra galindo','M10','1','00:28:38',0),(93,'2018-11-23',103,'juan claudio','M7','1','00:31:57',0),(94,'2018-11-23',65,'alejandra galindo','M15','1','00:33:37',0),(95,'2018-11-23',264,'alejandra galindo','M19','1','00:38:52',0),(96,'2018-11-23',68,'Laura Hern+Ìndez','P1','1','00:42:22',0),(97,'2018-11-23',96,'alejandra galindo','M2','1','00:50:58',0),(98,'2018-11-23',149,'Laura Hern+Ìndez','M11','1','00:52:18',0),(99,'2018-11-23',207,'Laura Hern+Ìndez','M12','1','01:00:02',0),(100,'2018-11-23',42,'juan claudio','M15','1','01:10:12',0),(101,'2018-11-23',66,'Laura Hern+Ìndez','M12','1','01:25:21',0),(102,'2018-11-23',120,'alejandra galindo','M1','1','01:27:07',0),(103,'2018-11-23',343,'juan claudio','M5','1','01:29:42',0),(104,'2018-11-23',99,'juan claudio','M3','1','01:33:27',0),(105,'2018-11-23',329,'alejandra galindo','M11','1','01:38:50',0),(106,'2018-11-23',55,'Laura Hern+Ìndez','P4','1','01:40:00',0),(107,'2018-11-23',30,'juan claudio','P8','1','01:40:40',0),(108,'2018-11-23',71,'Laura Hern+Ìndez','M10','1','01:46:38',0),(109,'2018-11-23',91,'Laura Hern+Ìndez','M11','1','01:50:52',0),(110,'2018-11-23',34,'alejandra galindo','M1','1','01:51:05',0),(111,'2018-11-23',65,'Laura Hern+Ìndez','P3','1','01:57:11',0),(112,'2018-11-23',55,'juan claudio','M3','1','02:12:25',0),(113,'2018-11-23',64,'juan claudio','M12','1','02:12:35',0),(114,'2018-11-23',41,'alejandra galindo','M9','1','02:21:07',0),(115,'2018-11-23',21,'alejandra galindo','P2','1','02:21:14',0),(116,'2018-11-23',65,'alejandra galindo','M16','1','02:25:12',0),(117,'2018-11-23',55,'juan claudio','M5','1','02:36:00',0),(118,'2018-11-23',75,'Laura Hern+Ìndez','P4','1','02:46:34',0),(119,'2018-11-23',64,'Laura Hern+Ìndez','M14','1','02:50:01',0),(120,'2018-11-23',51,'alejandra galindo','M2','1','03:02:25',0),(121,'2018-11-23',136,'Laura Hern+Ìndez','M10','1','03:26:35',0),(122,'2018-11-23',95,'alejandra galindo','M13','1','03:26:56',0),(123,'2018-11-23',138,'alejandra galindo','M15','1','04:02:26',0),(124,'2018-11-23',158,'alejandra galindo','M13','1','04:08:02',0),(125,'2018-11-23',110,'Pablo Sanabria','M3','1','04:10:01',0),(126,'2018-11-23',110,'juan claudio','M19','1','04:10:08',0),(127,'2018-11-23',85,'Laura Hern+Ìndez','M7','1','04:15:27',0),(128,'2018-11-23',126,'Lola Martinez','M5','1','04:15:56',0),(129,'2018-11-23',112,'juan claudio','M16','1','04:16:06',0),(130,'2018-11-23',137,'alejandra galindo','M17','1','04:17:04',0),(131,'2018-11-23',156,'juan claudio','M8','1','04:22:19',0),(132,'2018-11-23',151,'alejandra galindo','M8','1','04:23:58',0),(133,'2018-11-23',70,'German','P7','1','04:24:41',0),(134,'2018-11-23',177,'alejandra galindo','M1','1','04:27:12',0),(135,'2018-11-23',98,'juan claudio','P6','1','05:45:37',0),(136,'2018-11-23',161,'alejandra galindo','M4','1','05:45:40',0),(137,'2018-11-23',48,'alejandra galindo','M11','1','05:45:42',0),(138,'2018-11-23',42,'Pablo Sanabria','P1','1','05:45:44',0),(139,'2018-11-23',287,'alejandra galindo','M10','1','05:46:03',0),(140,'2018-11-23',36,'alejandra galindo','M13','1','05:46:10',0),(141,'2018-11-24',84,'alejandra galindo','M10','1','11:30:23',0),(142,'2018-11-24',122,'alejandra galindo','M3','1','11:48:07',0),(143,'2018-11-24',78,'Laura Hern+Ìndez','M15','1','11:48:52',0),(144,'2018-11-24',125,'Laura Hern+Ìndez','M12','1','11:52:43',0),(145,'2018-11-24',75,'alejandra galindo','M19','1','11:54:15',0),(146,'2018-11-24',93,'juan claudio','M1','1','11:56:12',0),(147,'2018-11-24',81,'juan claudio','M16','1','11:57:43',0),(148,'2018-11-24',138,'Laura Hern+Ìndez','M14','1','00:00:15',0),(149,'2018-11-24',88,'alejandra galindo','M2','1','00:03:21',0),(150,'2018-11-24',141,'alejandra galindo','M7','1','00:04:18',0),(151,'2018-11-24',156,'alejandra galindo','M16','1','00:12:09',0),(152,'2018-11-24',429,'juan claudio','M5','1','00:17:52',0),(153,'2018-11-24',126,'juan claudio','M3','1','00:26:57',0),(154,'2018-11-24',63,'Laura Hern+Ìndez','M11','1','00:33:52',0),(155,'2018-11-24',33,'alejandra galindo','M5','1','00:39:13',0),(156,'2018-11-24',59,'alejandra galindo','B1','1','00:42:57',0),(157,'2018-11-24',255,'Laura Hern+Ìndez','M10','1','00:51:38',0),(158,'2018-11-24',176,'Laura Hern+Ìndez','M12','1','00:59:26',0),(159,'2018-11-24',100,'Laura Hern+Ìndez','P1','1','01:02:26',0),(160,'2018-11-24',124,'alejandra galindo','M2','1','01:08:47',0),(161,'2018-11-24',66,'Laura Hern+Ìndez','M1','1','01:08:57',0),(162,'2018-11-24',96,'alejandra galindo','M16','1','01:11:13',0),(163,'2018-11-24',48,'juan claudio','M11','1','01:37:17',0),(164,'2018-11-24',63,'alejandra galindo','M1','1','01:41:36',0),(165,'2018-11-24',118,'Laura Hern+Ìndez','P2','1','01:46:36',0),(166,'2018-11-24',141,'alejandra galindo','M7','1','02:16:20',0),(167,'2018-11-24',131,'juan claudio','M15','1','02:17:40',0),(168,'2018-11-24',65,'juan claudio','M12','1','02:29:26',0),(169,'2018-11-24',79,'alejandra galindo','M2','1','02:33:48',0),(170,'2018-11-24',96,'Laura Hern+Ìndez','M10','1','02:55:04',0),(171,'2018-11-24',127,'Laura Hern+Ìndez','M13','1','02:55:10',0),(172,'2018-11-24',231,'Laura Hern+Ìndez','M19','1','02:59:45',0),(173,'2018-11-24',66,'alejandra galindo','M1','1','03:09:09',0),(174,'2018-11-24',96,'alejandra galindo','M17','1','03:16:07',0),(175,'2018-11-24',146,'juan claudio','M14','1','03:21:13',0),(176,'2018-11-24',148,'alejandra galindo','P1','1','03:23:52',0),(177,'2018-11-24',127,'Tokio Gardu+¶o','M12','1','03:23:56',0),(178,'2018-11-24',83,'Tokio Gardu+¶o','M10','1','03:30:48',0),(179,'2018-11-24',84,'','P1','1','03:31:25',0),(180,'2018-11-24',82,'alejandra galindo','M7','1','03:38:20',0),(181,'2018-11-24',96,'juan claudio','M4','1','03:41:20',0),(182,'2018-11-24',70,'Tokio Gardu+¶o','M1','1','03:43:49',0),(183,'2018-11-24',204,'juan claudio','M11','1','03:51:45',0),(184,'2018-11-24',257,'','M3','1','03:53:39',0),(185,'2018-11-24',154,'alejandra galindo','M19','1','03:56:57',0),(186,'2018-11-24',175,'','P1','1','03:57:54',0),(187,'2018-11-24',124,'alejandra galindo','M5','1','04:00:46',0),(188,'2018-11-24',151,'juan claudio','M16','1','04:05:06',0),(189,'2018-11-24',79,'Tokio Gardu+¶o','M14','1','04:07:04',0),(190,'2018-11-24',95,'','M15','1','04:11:47',0),(191,'2018-11-24',96,'','M1','1','04:14:31',0),(192,'2018-11-24',156,'juan claudio','M9','1','04:16:59',0),(193,'2018-11-24',298,'Tokio Gardu+¶o','M2','1','04:20:37',0),(194,'2018-11-24',192,'German','M10','1','04:23:47',0),(195,'2018-11-24',206,'ALFONSO','P1','1','04:26:34',0),(196,'2018-11-24',68,'alejandra galindo','M18','1','04:27:30',0),(197,'2018-11-24',249,'Tokio Gardu+¶o','M8','1','04:30:19',0),(198,'2018-11-24',69,'juan claudio','M16','1','04:34:12',0),(199,'2018-11-24',208,'Tokio Gardu+¶o','M4','1','04:39:43',0),(200,'2018-11-24',165,'alejandra galindo','M17','1','04:43:58',0),(201,'2018-11-24',204,'juan claudio','M11','1','04:48:11',0),(202,'2018-11-24',83,'','M1','1','04:48:32',0),(203,'2018-11-24',171,'juan claudio','M14','1','04:52:24',0),(204,'2018-11-24',108,'German','M13','1','04:52:34',0),(205,'2018-11-24',249,'','M3','1','05:02:00',0),(206,'2018-11-24',102,'Josve Rocha','M10','1','05:02:05',0);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajadores`
--

DROP TABLE IF EXISTS `trabajadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabajadores` (
  `idtrabajador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idtrabajador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajadores`
--

LOCK TABLES `trabajadores` WRITE;
/*!40000 ALTER TABLE `trabajadores` DISABLE KEYS */;
/*!40000 ALTER TABLE `trabajadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `tipousuario` varchar(50) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Mayela','Martinez','ADMINISTRADOR','Mayela Martinez'),(2,'Laura','Hernandez','MESERO','Laura Hern+Ìndez'),(3,'Brenda','Vazquez','ADMINISTRADOR','Brenda Vazquez'),(4,'Alejandra','juliangalindo','MESERO','alejandra galindo'),(5,'Lola','Monroy','MESERO','Lola Martinez'),(6,'Juan','claudio1','MESERO','juan claudio'),(7,'Pablo','Sanabria','MESERO','Pablo Sanabria'),(8,'Juanito','MONROYJONI','MESERO',''),(9,'PONCHI','MONROYVILLA','MESERO','ALFONSO'),(10,'Antonio','LETRAS12','MESERO','MARCO ANTONIO ROCHA MARTINEZ'),(11,'Josve','Rocha','MESERO','Josve Rocha'),(12,'Tokio','Gardu+¶o','MESERO','Tokio Gardu+¶o'),(13,'German','German','MESERO','German');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `idTicket` int(11) NOT NULL,
  `id_producto` varchar(20) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `total` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,'5',10,70.00),(1,'45',1,13.00),(2,'5',15,105.00),(2,'25',1,35.00),(2,'10',1,18.00),(2,'9',8,112.00),(2,'33',1,50.00),(2,'48',4,52.00),(2,'67',2,26.00),(2,'6',1,12.00),(3,'5',5,35.00),(4,'1',4,56.00),(4,'13',2,28.00),(4,'5',3,21.00),(4,'49',2,26.00),(4,'45',1,13.00),(5,'51',1,30.00),(5,'5',5,35.00),(6,'68',1,20.00),(6,'5',2,14.00),(6,'49',2,26.00),(7,'5',10,70.00),(7,'45',3,39.00),(8,'27',1,65.00),(8,'44',2,60.00),(8,'6',2,24.00),(8,'8',1,18.00),(8,'46',1,13.00),(8,'48',1,13.00),(9,'3',3,54.00),(9,'6',2,24.00),(9,'1',1,14.00),(9,'51',1,30.00),(9,'45',2,26.00),(9,'5',1,7.00),(10,'25',1,35.00),(10,'3',3,54.00),(10,'1',1,14.00),(10,'45',2,26.00),(10,'49',1,13.00),(10,'17',1,65.00),(10,'23',1,30.00),(10,'62',1,26.00),(11,'5',7,49.00),(11,'60',2,52.00),(11,'47',1,13.00),(11,'49',1,13.00),(11,'6',1,12.00),(11,'51',2,50.00),(12,'3',3,54.00),(12,'6',2,24.00),(12,'1',1,14.00),(12,'51',1,25.00),(12,'45',2,26.00),(12,'5',1,7.00),(13,'5',5,35.00),(14,'23',3,90.00),(14,'45',1,13.00),(15,'5',8,56.00),(15,'1',3,42.00),(15,'68',1,20.00),(15,'49',2,52.00),(15,'46',1,13.00),(16,'23',1,30.00),(17,'5',11,77.00),(17,'49',2,26.00),(18,'5',10,70.00),(18,'45',1,13.00),(19,'5',10,70.00),(19,'49',3,39.00),(19,'51',2,50.00),(20,'5',22,154.00),(21,'5',10,70.00),(21,'49',2,26.00),(22,'5',10,70.00),(22,'68',1,20.00),(22,'80',1,30.00),(23,'16',1,55.00),(23,'45',1,13.00),(24,'5',3,21.00),(24,'90',2,32.00),(24,'9',3,42.00),(24,'49',1,13.00),(24,'45',1,13.00),(25,'68',3,60.00),(26,'68',1,20.00),(26,'5',4,28.00),(27,'5',10,70.00),(28,'51',2,50.00),(28,'5',8,56.00),(28,'49',2,26.00),(29,'51',2,50.00),(29,'45',2,26.00),(30,'5',7,49.00),(30,'51',1,25.00),(31,'13',1,14.00),(31,'49',1,13.00),(31,'6',2,24.00),(31,'5',7,49.00),(32,'5',8,56.00),(32,'1',2,28.00),(32,'32',1,25.00),(32,'45',2,26.00),(32,'49',1,13.00),(33,'5',5,35.00),(33,'9',2,28.00),(33,'49',1,13.00),(34,'5',5,35.00),(35,'5',10,70.00),(35,'45',1,13.00),(36,'51',1,25.00),(36,'17',1,65.00),(36,'5',2,14.00),(36,'49',2,26.00),(37,'35',1,50.00),(37,'5',1,7.00),(37,'23',1,30.00),(37,'49',1,13.00),(38,'5',5,35.00),(38,'13',1,14.00),(38,'23',1,30.00),(38,'49',2,26.00),(39,'5',6,42.00),(39,'15',1,50.00),(39,'45',2,26.00),(40,'5',4,28.00),(40,'49',1,13.00),(41,'5',10,70.00),(41,'23',1,30.00),(41,'51',1,25.00),(41,'45',2,26.00),(42,'5',6,42.00),(42,'45',1,13.00),(43,'19',1,65.00),(44,'5',5,35.00),(44,'45',1,13.00),(45,'51',2,50.00),(45,'5',2,14.00),(46,'34',1,50.00),(46,'5',2,14.00),(46,'18',1,65.00),(46,'49',2,26.00),(46,'50',1,13.00),(47,'5',6,42.00),(47,'13',3,42.00),(47,'45',1,13.00),(47,'49',1,13.00),(48,'20',2,140.00),(48,'77',2,100.00),(48,'1',2,28.00),(49,'51',1,25.00),(49,'45',1,13.00),(49,'5',5,35.00),(50,'5',4,28.00),(50,'6',6,72.00),(50,'49',2,26.00),(51,'5',10,70.00),(51,'98',1,37.00),(51,'34',1,50.00),(51,'45',2,26.00),(51,'46',1,13.00),(52,'5',15,105.00),(52,'45',2,26.00),(53,'16',2,110.00),(53,'60',2,52.00),(54,'5',22,154.00),(54,'34',1,50.00),(54,'49',3,39.00),(54,'45',2,26.00),(55,'5',3,21.00),(55,'51',1,25.00),(55,'23',1,30.00),(55,'47',1,13.00),(55,'49',1,13.00),(55,'9',2,28.00),(56,'5',4,28.00),(56,'60',2,52.00),(57,'1',4,56.00),(57,'45',1,13.00),(58,'5',5,35.00),(58,'45',1,13.00),(59,'5',22,154.00),(59,'51',1,25.00),(59,'1',5,70.00),(59,'32',1,25.00),(59,'45',6,78.00),(60,'5',4,28.00),(60,'23',1,30.00),(60,'50',3,39.00),(60,'51',1,25.00),(60,'35',1,50.00),(60,'1',2,28.00),(61,'51',2,50.00),(61,'13',3,42.00),(61,'49',3,39.00),(62,'5',15,105.00),(62,'6',2,24.00),(62,'46',3,39.00),(63,'51',1,25.00),(63,'32',1,25.00),(63,'6',1,12.00),(63,'49',1,13.00),(64,'5',7,49.00),(64,'50',1,13.00),(65,'28',1,65.00),(65,'31',1,50.00),(66,'16',2,110.00),(66,'45',1,13.00),(67,'13',3,42.00),(67,'5',3,21.00),(67,'45',2,26.00),(68,'1',2,28.00),(68,'45',1,13.00),(68,'7',3,42.00),(69,'5',5,35.00),(69,'14',2,36.00),(69,'48',1,13.00),(70,'25',1,35.00),(71,'51',2,50.00),(71,'5',2,14.00),(72,'51',1,25.00),(72,'5',1,7.00),(72,'47',1,13.00),(73,'5',16,112.00),(73,'50',3,39.00),(74,'13',6,84.00),(75,'5',5,35.00),(76,'5',3,21.00),(76,'6',3,36.00),(76,'45',1,13.00),(77,'3',1,18.00),(77,'10',1,18.00),(77,'48',1,13.00),(77,'46',1,13.00),(77,'68',1,20.00),(78,'13',3,42.00),(78,'56',2,44.00),(79,'3',4,72.00),(79,'46',1,13.00),(79,'35',1,50.00),(79,'50',1,13.00),(80,'5',6,42.00),(80,'13',2,28.00),(80,'45',2,26.00),(81,'5',12,84.00),(81,'50',3,39.00),(82,'68',2,40.00),(83,'5',12,84.00),(83,'45',2,26.00),(83,'49',1,13.00),(84,'5',11,77.00),(85,'51',1,25.00),(85,'32',1,25.00),(86,'5',4,28.00),(86,'51',1,25.00),(86,'45',1,13.00),(87,'5',7,49.00),(87,'13',1,14.00),(87,'51',1,25.00),(87,'49',1,13.00),(87,'45',1,13.00),(88,'51',1,25.00),(88,'5',4,28.00),(88,'49',1,13.00),(89,'5',4,28.00),(89,'45',1,13.00),(90,'18',1,65.00),(90,'19',1,65.00),(90,'5',5,35.00),(90,'45',2,26.00),(91,'5',16,112.00),(91,'9',1,14.00),(91,'10',5,90.00),(91,'1',1,14.00),(91,'45',4,52.00),(91,'48',1,13.00),(92,'68',2,40.00),(92,'45',1,13.00),(93,'5',11,77.00),(93,'45',2,26.00),(94,'5',7,49.00),(94,'84',1,16.00),(95,'5',10,70.00),(95,'84',1,16.00),(95,'23',3,90.00),(95,'51',1,25.00),(95,'26',2,24.00),(95,'45',3,39.00),(96,'68',2,40.00),(96,'5',4,28.00),(97,'5',6,42.00),(97,'1',2,28.00),(97,'45',2,26.00),(98,'5',10,70.00),(98,'68',2,40.00),(98,'49',2,26.00),(98,'50',1,13.00),(99,'13',8,112.00),(99,'1',4,56.00),(99,'45',2,26.00),(99,'50',1,13.00),(100,'5',6,42.00),(101,'23',1,30.00),(101,'5',2,14.00),(101,'53',1,22.00),(102,'1',3,42.00),(102,'27',1,65.00),(102,'45',1,13.00),(103,'13',7,98.00),(103,'5',3,21.00),(103,'1',1,14.00),(103,'51',2,50.00),(103,'44',2,60.00),(103,'45',4,52.00),(103,'53',1,22.00),(103,'60',1,26.00),(104,'25',1,35.00),(104,'51',1,25.00),(104,'49',1,13.00),(104,'60',1,26.00),(105,'23',1,30.00),(105,'36',1,50.00),(105,'16',3,165.00),(105,'56',1,22.00),(105,'46',1,13.00),(105,'1',2,28.00),(105,'5',3,21.00),(106,'5',6,42.00),(106,'45',1,13.00),(107,'23',1,30.00),(108,'5',5,35.00),(108,'4',1,18.00),(108,'3',1,18.00),(109,'3',2,36.00),(109,'5',6,42.00),(109,'49',1,13.00),(110,'1',1,14.00),(110,'5',1,7.00),(110,'45',1,13.00),(111,'5',5,35.00),(111,'23',1,30.00),(112,'5',6,42.00),(112,'45',1,13.00),(113,'23',1,30.00),(113,'5',3,21.00),(113,'45',1,13.00),(114,'5',4,28.00),(114,'45',1,13.00),(115,'5',3,21.00),(116,'51',1,25.00),(116,'5',2,14.00),(116,'45',2,26.00),(117,'5',4,28.00),(117,'1',1,14.00),(117,'49',1,13.00),(118,'51',3,75.00),(119,'5',6,42.00),(119,'43',1,22.00),(120,'6',2,24.00),(120,'5',2,14.00),(120,'45',1,13.00),(121,'13',6,84.00),(121,'49',2,52.00),(122,'24',1,20.00),(122,'5',7,49.00),(122,'45',2,26.00),(123,'20',1,70.00),(123,'5',6,42.00),(123,'45',2,26.00),(124,'20',1,70.00),(124,'68',1,20.00),(124,'6',2,24.00),(124,'3',1,18.00),(124,'45',2,26.00),(125,'5',6,42.00),(125,'16',1,55.00),(125,'49',1,13.00),(126,'13',4,56.00),(126,'5',4,28.00),(126,'45',2,26.00),(127,'6',2,24.00),(127,'5',5,35.00),(127,'49',1,13.00),(127,'46',1,13.00),(128,'34',1,50.00),(128,'35',1,50.00),(128,'45',2,26.00),(129,'5',7,49.00),(129,'1',2,28.00),(129,'49',1,13.00),(129,'56',1,22.00),(130,'51',1,25.00),(130,'23',1,30.00),(130,'5',4,28.00),(130,'13',2,28.00),(130,'45',2,26.00),(131,'51',3,75.00),(131,'5',6,42.00),(131,'49',3,39.00),(132,'13',4,56.00),(132,'84',2,32.00),(132,'98',1,37.00),(132,'45',2,26.00),(133,'5',10,70.00),(134,'6',10,120.00),(134,'45',1,13.00),(134,'56',2,44.00),(135,'20',1,70.00),(135,'5',4,28.00),(136,'68',1,20.00),(136,'14',1,18.00),(136,'98',1,37.00),(136,'1',2,28.00),(136,'2',1,14.00),(136,'56',1,22.00),(136,'43',1,22.00),(137,'5',5,35.00),(137,'47',1,13.00),(138,'5',6,42.00),(139,'5',4,28.00),(139,'1',4,56.00),(139,'6',2,24.00),(139,'51',1,25.00),(139,'80',1,30.00),(139,'53',1,22.00),(139,'58',1,50.00),(139,'45',2,26.00),(139,'49',1,13.00),(139,'47',1,13.00),(140,'10',2,36.00),(141,'5',4,28.00),(141,'23',1,30.00),(141,'45',2,26.00),(142,'23',1,30.00),(142,'13',2,28.00),(142,'51',1,25.00),(142,'45',3,39.00),(143,'13',3,42.00),(143,'1',1,14.00),(143,'57',1,22.00),(144,'5',3,21.00),(144,'25',1,35.00),(144,'23',1,30.00),(144,'49',1,13.00),(144,'48',1,13.00),(144,'67',1,13.00),(145,'1',1,14.00),(145,'5',4,28.00),(145,'68',1,20.00),(145,'45',1,13.00),(146,'23',1,30.00),(146,'34',1,50.00),(146,'49',1,13.00),(147,'5',8,56.00),(147,'6',1,12.00),(147,'49',1,13.00),(148,'6',2,24.00),(148,'1',1,14.00),(148,'5',6,42.00),(148,'51',1,25.00),(148,'68',1,20.00),(148,'45',1,13.00),(149,'51',1,25.00),(149,'36',1,50.00),(149,'49',1,13.00),(150,'5',9,63.00),(150,'51',1,25.00),(150,'1',1,14.00),(150,'45',2,26.00),(150,'49',1,13.00),(151,'19',2,130.00),(151,'45',2,26.00),(152,'5',3,21.00),(152,'6',4,48.00),(152,'1',6,84.00),(152,'17',1,65.00),(152,'35',1,50.00),(152,'36',1,50.00),(152,'21',1,15.00),(152,'45',4,52.00),(152,'53',1,22.00),(152,'43',1,22.00),(153,'36',1,50.00),(153,'34',1,50.00),(153,'49',1,13.00),(153,'45',1,13.00),(154,'5',9,63.00),(155,'45',1,13.00),(155,'68',1,20.00),(156,'51',1,25.00),(156,'5',3,21.00),(156,'45',1,13.00),(157,'1',6,84.00),(157,'3',1,18.00),(157,'4',1,18.00),(157,'53',1,22.00),(157,'49',1,13.00),(157,'34',2,100.00),(158,'27',1,65.00),(158,'5',6,42.00),(158,'23',1,30.00),(158,'51',1,25.00),(158,'9',1,14.00),(159,'51',4,100.00),(160,'5',3,21.00),(160,'17',1,65.00),(160,'6',1,12.00),(160,'45',2,26.00),(161,'51',1,25.00),(161,'9',2,28.00),(161,'49',1,13.00),(162,'5',10,70.00),(162,'45',2,26.00),(163,'5',5,35.00),(163,'45',1,13.00),(164,'35',1,50.00),(164,'45',1,13.00),(165,'20',1,70.00),(165,'5',5,35.00),(165,'49',1,13.00),(166,'5',11,77.00),(166,'51',1,25.00),(166,'49',3,39.00),(167,'13',2,28.00),(167,'5',3,21.00),(167,'1',4,56.00),(167,'46',2,26.00),(168,'23',1,30.00),(168,'5',5,35.00),(169,'5',2,14.00),(169,'1',1,14.00),(169,'51',1,25.00),(169,'45',2,26.00),(170,'49',2,26.00),(170,'5',10,70.00),(171,'6',3,36.00),(171,'27',1,65.00),(171,'47',1,13.00),(171,'49',1,13.00),(172,'17',1,65.00),(172,'20',1,70.00),(172,'49',1,13.00),(172,'46',1,13.00),(172,'21',1,15.00),(172,'23',1,30.00),(172,'51',1,25.00),(173,'68',2,40.00),(173,'45',2,26.00),(174,'51',1,25.00),(174,'68',1,20.00),(174,'32',1,25.00),(174,'45',2,26.00),(175,'6',10,120.00),(175,'45',1,13.00),(175,'48',1,13.00),(176,'31',1,50.00),(176,'20',1,70.00),(176,'9',2,28.00),(177,'5',9,63.00),(177,'32',1,25.00),(177,'47',1,13.00),(177,'64',1,26.00),(178,'5',10,70.00),(178,'45',1,13.00),(179,'1',6,84.00),(180,'5',8,56.00),(180,'49',2,26.00),(181,'5',10,70.00),(181,'45',2,26.00),(182,'5',1,7.00),(182,'35',1,50.00),(182,'50',1,13.00),(183,'98',2,74.00),(183,'5',7,49.00),(183,'13',3,42.00),(183,'49',1,13.00),(183,'50',2,26.00),(184,'19',1,65.00),(184,'20',2,140.00),(184,'45',1,13.00),(184,'67',2,26.00),(184,'48',1,13.00),(185,'36',2,100.00),(185,'47',2,26.00),(185,'5',4,28.00),(186,'5',25,175.00),(187,'5',14,98.00),(187,'45',2,26.00),(188,'5',3,21.00),(188,'32',1,25.00),(188,'13',1,14.00),(188,'27',1,65.00),(188,'49',1,13.00),(188,'46',1,13.00),(189,'5',4,28.00),(189,'64',1,26.00),(189,'51',1,25.00),(190,'5',6,42.00),(190,'9',2,28.00),(190,'45',1,13.00),(190,'6',1,12.00),(191,'5',10,70.00),(191,'46',2,26.00),(192,'5',8,56.00),(192,'23',2,60.00),(192,'2',1,14.00),(192,'45',2,26.00),(193,'33',1,50.00),(193,'34',1,50.00),(193,'5',5,35.00),(193,'45',2,26.00),(193,'47',1,13.00),(193,'49',2,26.00),(193,'13',7,98.00),(194,'5',20,140.00),(194,'64',1,26.00),(194,'49',1,13.00),(194,'45',1,13.00),(195,'5',22,154.00),(195,'1',2,28.00),(195,'6',2,24.00),(196,'5',6,42.00),(196,'45',2,26.00),(197,'15',2,100.00),(197,'43',3,66.00),(197,'48',1,13.00),(197,'2',1,14.00),(197,'1',3,42.00),(197,'5',2,14.00),(198,'13',4,56.00),(198,'45',1,13.00),(199,'5',17,119.00),(199,'51',2,50.00),(199,'45',1,13.00),(199,'47',1,13.00),(199,'46',1,13.00),(200,'5',2,14.00),(200,'6',5,60.00),(200,'51',1,25.00),(200,'45',2,26.00),(200,'53',1,22.00),(200,'4',1,18.00),(201,'35',3,150.00),(201,'21',1,15.00),(201,'45',3,39.00),(202,'5',10,70.00),(202,'47',1,13.00),(203,'6',2,24.00),(203,'5',3,63.00),(203,'1',2,28.00),(203,'50',1,13.00),(203,'49',1,13.00),(203,'44',1,30.00),(204,'6',3,36.00),(204,'3',4,72.00),(205,'5',30,210.00),(205,'45',3,39.00),(206,'5',9,63.00),(206,'47',1,13.00),(206,'50',2,26.00);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventasp`
--

DROP TABLE IF EXISTS `ventasp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventasp` (
  `mesa` varchar(20) DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `producto` varchar(50) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `total` float DEFAULT NULL,
  `mesero` int(11) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventasp`
--

LOCK TABLES `ventasp` WRITE;
/*!40000 ALTER TABLE `ventasp` DISABLE KEYS */;
INSERT INTO `ventasp` VALUES ('M5',5,'TACO  AL PASTOR ',25,175,13,'ACTIVO'),('M5',25,'SINCRONIZADA  ESP  BISTECK',1,35,13,'ACTIVO'),('M5',1,'TACO BISTECK',2,28,13,'ACTIVO'),('M5',45,'COCA COLA VIDRIO ',3,39,13,'ACTIVO'),('M5',43,'CERVEZA INDIO CERVEZA',1,22,13,'ACTIVO'),('M5',47,'SPRITE VIDRIO',1,13,13,'ACTIVO'),('M2',5,'TACO  AL PASTOR ',10,70,8,'ACTIVO'),('M2',17,'COSTILLA ROAST  CON ENSALADA',1,65,8,'ACTIVO'),('M10',51,'GRINGA AL PASTOR',2,50,8,'ACTIVO'),('M10',45,'COCA COLA VIDRIO ',1,13,8,'ACTIVO'),('M10',49,'BOING  MANGO',1,13,8,'ACTIVO');
/*!40000 ALTER TABLE `ventasp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-26 16:50:26
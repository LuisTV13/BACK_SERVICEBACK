CREATE DATABASE  IF NOT EXISTS `restaurant` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `restaurant`;
-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: restaurant
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mesa`
--

DROP TABLE IF EXISTS `mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mesa` (
  `codmesa` int NOT NULL AUTO_INCREMENT,
  `capacidad` int DEFAULT NULL,
  `idtipoest` int DEFAULT NULL,
  `descmesa` varchar(300) NOT NULL,
  PRIMARY KEY (`codmesa`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesa`
--

LOCK TABLES `mesa` WRITE;
/*!40000 ALTER TABLE `mesa` DISABLE KEYS */;
INSERT INTO `mesa` VALUES (1,15,1,'Cerca a la puerta'),(2,15,0,'sdfsafdsfdsf'),(3,4545,0,'dfdsfdsfds'),(4,40,1,'sasdsadsadsadsad'),(5,80,1,'Son bastantes');
/*!40000 ALTER TABLE `mesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platillos`
--

DROP TABLE IF EXISTS `platillos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platillos` (
  `codigopro` int NOT NULL AUTO_INCREMENT,
  `detallepro` varchar(45) DEFAULT NULL,
  `stockpro` int DEFAULT NULL,
  `precioxunipro` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`codigopro`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platillos`
--

LOCK TABLES `platillos` WRITE;
/*!40000 ALTER TABLE `platillos` DISABLE KEYS */;
INSERT INTO `platillos` VALUES (1,'AJI DE GALLINA',100,30.00),(2,'PAPA A LA HUANCAINA',100,15.00),(3,'POLLO A LA BRASA',100,28.00),(4,'ARROZ CON POLLLO',100,30.00),(5,'CHANCHO A LA CAJA CHINA',100,30.00),(6,'PACHAMANCA DE 1 SABOR',50,20.00),(7,'PACHAMANCA DE 2 SABORES',50,20.00),(8,'PACHAMANCA DE E SABORES',50,20.00),(11,'Combo Familiar para 6 Oriental',10,115.00),(12,'ARROZ CON LEGO',150,15.00),(13,'PACHAMAMAAUTUCUSI',250,55.00);
/*!40000 ALTER TABLE `platillos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `codreserva` int NOT NULL AUTO_INCREMENT,
  `codmesa` int NOT NULL,
  `codigoso` int NOT NULL,
  `codigopro` int NOT NULL,
  `fechareserva` date NOT NULL,
  `comentario` varchar(300) NOT NULL,
  PRIMARY KEY (`codreserva`),
  KEY `reserva_ibfk_1` (`codigoso`),
  KEY `reserva_ibfk_2` (`codmesa`),
  KEY `reserva_ibfk_3` (`codigopro`),
  CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`codigoso`) REFERENCES `socio` (`codigoso`),
  CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`codmesa`) REFERENCES `mesa` (`codmesa`),
  CONSTRAINT `reserva_ibfk_3` FOREIGN KEY (`codigopro`) REFERENCES `platillos` (`codigopro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (5,5,9,13,'2022-01-07','AMAMAYSCACHA');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rol_nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `socio` (
  `codigoso` int NOT NULL AUTO_INCREMENT,
  `nombreso` varchar(15) NOT NULL,
  `apellidoso` varchar(25) NOT NULL,
  `dniso` varchar(8) NOT NULL,
  `telefonoso` varchar(9) NOT NULL,
  `estadoso` int NOT NULL,
  PRIMARY KEY (`codigoso`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT INTO `socio` VALUES (7,'Sarah','Fortune','76447514','985841541',1),(8,'Pepardo','Conor','74558421','954745841',0),(9,'Pepe','lotardo','74558421','954745841',1);
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `nombre_usuario` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_puhr3k3l7bj71hb7hk7ktpxn0` (`nombre_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (14,'luis@gmail.com','luis','luis','$2a$10$xJk7QK5QsYqtFpp6hymfTu7uRjy8jLwsnBMyzT2.UWIaiKLMX5mpu'),(15,'rag@gmail.com','Ragnar','rag','$2a$10$sUGta1hPC2YVD0Jvo46BWukB3NAdOxkICp9uzSOqQf..u6y6eLorK');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_role`
--

DROP TABLE IF EXISTS `usuario_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_role` (
  `usuario_id` int NOT NULL,
  `rol_id` int NOT NULL,
  PRIMARY KEY (`usuario_id`,`rol_id`),
  KEY `FK5wxqd7u43doy9467aiaebgjuu` (`rol_id`),
  CONSTRAINT `FK5wxqd7u43doy9467aiaebgjuu` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`),
  CONSTRAINT `FKpc2qjts6sqq4hja9f6i3hf0ep` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_role`
--

LOCK TABLES `usuario_role` WRITE;
/*!40000 ALTER TABLE `usuario_role` DISABLE KEYS */;
INSERT INTO `usuario_role` VALUES (14,1),(14,2),(15,2);
/*!40000 ALTER TABLE `usuario_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'restaurant'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-29 18:19:29

-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: citas5
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas` (
  `IDCita` int NOT NULL AUTO_INCREMENT,
  `IDPaciente` int DEFAULT NULL,
  `IDMedico` int DEFAULT NULL,
  `IDHorario` int DEFAULT NULL,
  `IDFecha` int DEFAULT NULL,
  `IDUsuario` int DEFAULT NULL,
  PRIMARY KEY (`IDCita`),
  KEY `IDPaciente` (`IDPaciente`),
  KEY `IDMedico` (`IDMedico`),
  KEY `IDHorario` (`IDHorario`),
  KEY `IDFecha` (`IDFecha`),
  KEY `IDUsuario` (`IDUsuario`),
  CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`IDPaciente`) REFERENCES `pacientes` (`IDPaciente`),
  CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`IDMedico`) REFERENCES `medicos` (`IDMedico`),
  CONSTRAINT `citas_ibfk_3` FOREIGN KEY (`IDHorario`) REFERENCES `horarios` (`IDHorario`),
  CONSTRAINT `citas_ibfk_4` FOREIGN KEY (`IDFecha`) REFERENCES `fechas` (`IDFecha`),
  CONSTRAINT `citas_ibfk_5` FOREIGN KEY (`IDUsuario`) REFERENCES `usuarios` (`IDUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
INSERT INTO `citas` VALUES (1,1,1,1,1,1);
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidades`
--

DROP TABLE IF EXISTS `especialidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidades` (
  `IDEspecialidad` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IDEspecialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidades`
--

LOCK TABLES `especialidades` WRITE;
/*!40000 ALTER TABLE `especialidades` DISABLE KEYS */;
INSERT INTO `especialidades` VALUES (1,'Medicina General'),(2,'Odontologia'),(3,'Otorinologia'),(4,'Fisioterapia'),(5,'Traumatologia'),(6,'Ginecologia'),(7,'Pediatria');
/*!40000 ALTER TABLE `especialidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fechas`
--

DROP TABLE IF EXISTS `fechas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fechas` (
  `IDFecha` int NOT NULL AUTO_INCREMENT,
  `Dia` int DEFAULT NULL,
  `Mes` int DEFAULT NULL,
  `Año` int DEFAULT NULL,
  PRIMARY KEY (`IDFecha`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fechas`
--

LOCK TABLES `fechas` WRITE;
/*!40000 ALTER TABLE `fechas` DISABLE KEYS */;
INSERT INTO `fechas` VALUES (1,12,10,2023);
/*!40000 ALTER TABLE `fechas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horarios` (
  `IDHorario` int NOT NULL AUTO_INCREMENT,
  `HorarioInicio` time DEFAULT NULL,
  `HorarioFin` time DEFAULT NULL,
  PRIMARY KEY (`IDHorario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES (1,'07:00:00','08:00:00'),(2,'08:00:00','09:00:00'),(3,'09:00:00','10:00:00'),(4,'10:00:00','11:00:00'),(5,'11:00:00','12:00:00'),(6,'12:00:00','13:00:00'),(7,'13:00:00','14:00:00'),(8,'14:00:00','15:00:00'),(9,'15:00:00','16:00:00'),(10,'16:00:00','17:00:00'),(11,'17:00:00','18:00:00');
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicos`
--

DROP TABLE IF EXISTS `medicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicos` (
  `IDMedico` int NOT NULL AUTO_INCREMENT,
  `Dni` varchar(15) DEFAULT NULL,
  `Nombre` varchar(40) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `Genero` varchar(10) DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `Nacimiento` date DEFAULT NULL,
  `Correo` varchar(50) DEFAULT NULL,
  `Nacionalidad` varchar(20) DEFAULT NULL,
  `IDEspecialidad` int DEFAULT NULL,
  PRIMARY KEY (`IDMedico`),
  KEY `IDEspecialidad` (`IDEspecialidad`),
  CONSTRAINT `medicos_ibfk_1` FOREIGN KEY (`IDEspecialidad`) REFERENCES `especialidades` (`IDEspecialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicos`
--

LOCK TABLES `medicos` WRITE;
/*!40000 ALTER TABLE `medicos` DISABLE KEYS */;
INSERT INTO `medicos` VALUES (1,'64564684','Jorge','Canchos','masculino','97845512','2002-10-07','jorge@untels.com','peruano',1),(3,'85456214','Hans','Herrera','masculino','955244668','2001-01-01','hans@untels.com','peruano',6);
/*!40000 ALTER TABLE `medicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacientes` (
  `IDPaciente` int NOT NULL AUTO_INCREMENT,
  `Dni` varchar(15) DEFAULT NULL,
  `Nombre` varchar(40) DEFAULT NULL,
  `Apellido` varchar(40) DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `Sexo` varchar(10) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDPaciente`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacientes`
--

LOCK TABLES `pacientes` WRITE;
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
INSERT INTO `pacientes` VALUES (1,'74950763','Jeampier','Barrios','917046314','masculino','jeampier@gmail.com'),(12,'57898987','Paciente x','Paniagua','965357524','femenino','paniagua@gmail.com'),(13,'pasd','pasd','pasd','777776666','m','pasd@asd'),(14,'pasd','pasd','pasd','777776666','m','pasd@asd'),(15,'pzxc','zxc','zxc','923322332','m','pzxc@zxc'),(16,'pzxc','zxc','zxc','923322332','m','pzxc@zxc'),(17,'pzxc','zxc','zxc','923322332','m','pzxc@zxc'),(18,'pzxc','zxc','zxc','923322332','m','pzxc@zxc'),(19,'pzxc','zxc','zxc','923322332','m','pzxc@zxc'),(20,'28558855','pmnb','mnb','962266226','m','mnb@mnb'),(21,'58789644','hjk','hjk','971177117','f','hjk@hjk');
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `IDUsuario` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(40) DEFAULT NULL,
  `Apellido` varchar(40) DEFAULT NULL,
  `Sexo` varchar(10) DEFAULT NULL,
  `Dni` varchar(15) DEFAULT NULL,
  `Gmail` varchar(50) DEFAULT NULL,
  `Contraseña` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`IDUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Jeampier','Barrios','Masculino','74950763','Jeampierbarrios04@gmail.com','123'),(2,'asd','qwe','M','78787877','xyz','123'),(3,'Janpaul','Van','Dam','87878788','jan','123');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-12  0:59:45

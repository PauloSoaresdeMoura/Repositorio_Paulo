CREATE DATABASE  IF NOT EXISTS `db_agregacao` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_agregacao`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_agregacao
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classe` (
  `Cod_clas` int NOT NULL,
  `Nome_clas` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Cod_clas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe`
--

LOCK TABLES `classe` WRITE;
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
INSERT INTO `classe` VALUES (1,'Alimentos e Bebidas'),(2,'Bebê & Cia'),(3,'Construção e Ferramentas'),(4,'Informática'),(5,'Saúde'),(6,'Casa e Decoração'),(7,'Esporte e Lazer'),(8,'Eletrodomésticos'),(9,'Perfumaria e Cosméticos'),(10,'Telefonia');
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `Cod_prod` int NOT NULL,
  `Cod_clas` int NOT NULL,
  `Tipo_prod` varchar(45) NOT NULL,
  `Nome_prod` varchar(45) NOT NULL,
  `Qtd_prod` varchar(45) NOT NULL,
  `Val_prod` varchar(45) NOT NULL,
  PRIMARY KEY (`Cod_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,1,'Alimentos e Bebidas','Carne','3','20,00'),(2,1,'Alimentos e Bebidas','Feijão','3','10,00'),(3,1,'Alimentos e Bebidas','Arroz','3','8,00'),(4,2,'Bebê & Cia','Camisa','5','20,00'),(5,2,'Bebê & Cia','Calça','4','30,00'),(6,2,'Bebê & Cia','Blusa','2','50,00'),(7,3,'Construção e Ferramentas','Cimento','50','50,00'),(8,3,'Construção e Ferramentas','Tijolo','400','30,00'),(9,3,'Construção e Ferramentas','Areia','200','50,00'),(10,4,'Informática','Notbook','5','5.000,00'),(11,4,'Informática','Monitor','40','300,00'),(12,4,'Informática','Teclado','20','50,00'),(13,5,'Saúde','Comprimido','5','5,00'),(14,5,'Saúde','Xarope','40','25,00'),(15,5,'Saúde','Curativo','20','5,00'),(16,6,'Casa e Decoração','Sofá','2','1.000,00'),(17,6,'Casa e Decoração','Mesa','4','255,00'),(18,6,'Casa e Decoração','Poltrona','2','500,00'),(19,7,'Esporte e Lazer','Bicicleta','2','1.500,00'),(20,7,'Esporte e Lazer','Skate','4','500,00'),(21,7,'Esporte e Lazer','Espingarda','2','2.000,00'),(22,8,'Eletrodomésticos','Geladeira','8','3.500,00'),(23,8,'Eletrodomésticos','Batedeira','4','500,00'),(24,8,'Eletrodomésticos','Forno elétrico','5','2.000,00'),(25,9,'Perfumaria e Cosméticos','Desodorante','8','35,00'),(26,9,'Perfumaria e Cosméticos','Protetor solar','4','50,00'),(27,9,'Perfumaria e Cosméticos','Creme facial','25','20,00'),(28,10,'Telefonia','Celular','20','3.500,00'),(29,10,'Telefonia','Carregador','40','50,00'),(30,10,'Telefonia','Chip','25','20,00');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_agregacao'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-21 11:20:53

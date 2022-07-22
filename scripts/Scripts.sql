CREATE DATABASE  IF NOT EXISTS `db_loja` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_loja`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_loja
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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sobrenome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,' Antônio ',' Silva '),(2,' Bruno ',' Dias '),(3,' Alberto ',' Pereira '),(4,' Mariane ',' Santos '),(5,' Renata ',' Souza '),(6,' Diego ',' Carvalho '),(7,'Carlos','Almeida'),(8,'Fernando','Fagundes'),(9,'Rita','Lima'),(10,'Mateus','Lima'),(11,'Roberto','Arruda'),(12,' Alberto \' Vera ',' Pereira Oliveira'),(13,'Jovenal','Chavier'),(14,'Edite','Campos'),(15,'Eliane','Feijo'),(16,'Carlos','Almeida'),(17,'Fernando','Fagundes'),(18,'Rita','Lima'),(19,'Mateus','Lima');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `categoria` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Comédia Romantica'),(2,'Fantasia'),(3,'Animação'),(4,'Biografia'),(5,'Esporte'),(6,'Faroeste'),(7,'Documentário'),(8,'Policial'),(9,'Terror'),(10,'Romance'),(11,'Musical');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contato`
--

DROP TABLE IF EXISTS `contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contato` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sobrenome` varchar(45) NOT NULL,
  `ddd` varchar(3) DEFAULT NULL,
  `telefone` varchar(10) DEFAULT NULL,
  `data_nascimento` varchar(10) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contato`
--

LOCK TABLES `contato` WRITE;
/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
INSERT INTO `contato` VALUES (1,'Wilson','Vaz','49','999999999','12/12/2012','wilson@email'),(2,'Manoel','Figueiro','049','123412345','12/12/2010','manoel@email'),(3,'Tais','Dias','049','43219999','12/01/2012','tais@email'),(4,'Fabio','Cruz','049','43219999','12/02/2012','fabio@email'),(5,'Nair','Roma','049','43219999','12/12/2000','nair@email'),(6,'Luiz','Luz','049','43219999','12/12/2015','luiz@email'),(7,'Adriano','Colto','049','43219999','12/03/2000','adriano@email.com'),(8,'Claudio','Rosa','049','43219999','11/06/2000','claudio@email.com'),(9,'Tiago','Ferreira','049','43219999','12/03/2000','tiago@email.com'),(10,'Daniel','Ruas','049','43219999','12/03/2000','daniel@email.com');
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `nivel` varchar(45) DEFAULT NULL,
  `data_inicio` varchar(10) DEFAULT NULL,
  `data_fim` varchar(10) DEFAULT NULL,
  `valor` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Matemática Aplicada','Superior','20032022','15122022','900'),(2,'Matemática Financeira','Superior','02/02/2020','20/05/2022','900'),(3,'Lingua Inglesa','Superior','02/02/2020','20/05/2022','900'),(4,'Contabilidade','Superior','02/02/2020','20/05/2022','900'),(5,'Desenvolvedor de Sistemas','Superior','02/02/2020','20/05/2022','900'),(6,'Segurança da Informação','Superior','02/02/2020','20/05/2022','900'),(7,'Geografia','Ensino Médio','02/02/2020','20/05/2022','500,00'),(8,'Química','Ensino Médio','02/02/2020','20/05/2022','500,00'),(9,'Artes','Ensino Médio','02/02/2020','20/05/2022','500,00'),(10,'Informática','Ensino Médio','02/02/2020','20/05/2022','500,00');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editora`
--

DROP TABLE IF EXISTS `editora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editora` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editora`
--

LOCK TABLES `editora` WRITE;
/*!40000 ALTER TABLE `editora` DISABLE KEYS */;
INSERT INTO `editora` VALUES (1,'Corifeu'),(2,'Cedro'),(3,'Aleph'),(4,'Callis'),(5,'Alfa'),(6,'Record'),(7,'Loyola'),(8,'Escala'),(9,'Moderna'),(10,'Melhoramentos');
/*!40000 ALTER TABLE `editora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
INSERT INTO `email` VALUES (1,'alfa@email'),(2,'omega@email'),(3,'delta@email'),(4,'outro@email'),(5,'fim@email'),(6,'record@email.com'),(7,'loyola@email.com'),(8,'escala@email.com'),(9,'moderna@email.com'),(10,'melhoramentos@email.com');
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filial`
--

DROP TABLE IF EXISTS `filial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `filial` (
  `id` int NOT NULL AUTO_INCREMENT,
  `razaoSocial` varchar(30) NOT NULL,
  `nomeFantasia` varchar(30) NOT NULL,
  `endereco` varchar(30) NOT NULL,
  `cidade` varchar(25) NOT NULL,
  `cep` int NOT NULL,
  `estado` varchar(30) NOT NULL,
  `pais` varchar(25) NOT NULL,
  `cnpj` int NOT NULL,
  `inscricaoEstadual` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filial`
--

LOCK TABLES `filial` WRITE;
/*!40000 ALTER TABLE `filial` DISABLE KEYS */;
INSERT INTO `filial` VALUES (1,'Universidade Comunitária UNO','UNOCHAPECO','Rua Uruguai','Xaxim',89900111,'SC','Brasil',1234567890,'098765'),(2,'Aurora Alimentos','Aurora','Avenida Brasil','Xaxim',89900222,'SC','Brasil',12345678,'9876543'),(3,'Seara Alimentos','Seara','Rua Bahia','Xaxim',89900333,'SC','Brasil',12345678,'9876543'),(4,'Vinhos Veritá','Veritá','Rua Paris','Xaxim',89900444,'SC','Brasil',12345678,'9876543'),(5,'Comercial Celeiro','Celeiro','Rua Paraguai','Xaxim',89900555,'SC','Brasil',12345678,'9876543'),(6,'Brasão Supermercado','Brasão','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(7,'Açougue Abatedouro Anzolin','Anzolin','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(8,'Posto Catarina','Catarina','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(9,'Banco do Brasil','BB','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(10,'Seara Alimentos','Seara','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(11,'Vinhos Veritá','Veritá','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(12,'Comercial Celeiro','Celeiro','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(13,'Brasão Supermercado','Brasão','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(14,'Açougue Abatedouro Anzolin','Anzolin','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(15,'Posto Catarina','Catarina','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(16,'Banco do Brasil','BB','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(17,'Seara Alimentos','Seara','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(18,'Vinhos Veritá','Veritá','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(19,'Comercial Celeiro','Celeiro','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(20,'Brasão Supermercado','Brasão','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(21,'Açougue Abatedouro Anzolin','Anzolin','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(22,'Posto Catarina','Catarina','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543'),(23,'Banco do Brasil','BB','Rua dos fundos','Chapecó',89800000,'SC','Brasil',12345678,'9876543');
/*!40000 ALTER TABLE `filial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `razaoSocial` varchar(45) NOT NULL,
  `nomeFantasia` varchar(45) NOT NULL,
  `inscricaoEstadual` varchar(45) DEFAULT NULL,
  `cnpj` int DEFAULT NULL,
  `produtoServico` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `cep` int DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `estado` varchar(30) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `website` varchar(45) DEFAULT NULL,
  `observacoes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'Mecanica Pointer','Pointer','098765',12345690,'Consertos','Rua Principal',89800001,'Chapecó','SC','pointer@email.com','pointer.com.br','Nenhum conserto'),(2,'Bar do Boca','Bokas','098765',12345690,'Alimentação','Rua Principal',89800001,'Chapecó','SC','boca@email.com','boca.com.br','Faça seu Pedido'),(3,'Padaria Dona Ana','Donaana','098765',12345690,'Alimentação','Rua Principal',89800001,'Chapecó','SC','donana@email.com','donana.com.br','Pão na Hora'),(4,'Atacadão Atacadista','Atacadão','098765',12345690,'Atacadista','Rua Principal',89800001,'Chapecó','SC','atacadao@email.com','atacadao.com.br','Tudo que Precisa'),(5,'Hospital Unimed','Unimed','098765',12345690,'Serviços de Saúde','Rua Principal',89800001,'Chapecó','SC','unimed@email.com','unimed.com.br','Cuide da Sua Saúde'),(6,'Auto posto Mega','Mega','098765',12345690,'Consertos','Rua Principal',89800001,'Chapecó','SC','pointer@email.com','pointer.com.br','Nenhum conserto'),(7,'Lotérica Ki Sorte','Ki Sorte','098765',12345690,'Consertos','Rua Principal',89800001,'Chapecó','SC','pointer@email.com','pointer.com.br','Nenhum conserto'),(8,'Banco Besc','Besc','098765',12345690,'Consertos','Rua Principal',89800001,'Chapecó','SC','pointer@email.com','pointer.com.br','Nenhum conserto'),(9,'Contabilidade Agil','Agil','098765',12345690,'Consertos','Rua Principal',89800001,'Chapecó','SC','pointer@email.com','pointer.com.br','Nenhum conserto');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livro`
--

DROP TABLE IF EXISTS `livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `isbn13` varchar(3) DEFAULT NULL,
  `isbn10` varchar(3) DEFAULT NULL,
  `data_publicacao` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livro`
--

LOCK TABLES `livro` WRITE;
/*!40000 ALTER TABLE `livro` DISABLE KEYS */;
INSERT INTO `livro` VALUES (1,'Manual Banco de Dados','aaa','bbb','13072022'),(2,'Esperto que o Diabo','ccc','ddd','30/02/2009'),(3,'Quem Pensa Enriquece','eee','fff','30/02/2005'),(4,'O Andar do Bêbado','ggg','hhh','30/02/2004'),(5,'Um Lugar Bem Longe Daqui','iii','jjj','03/02/2009'),(6,'O Senhor dos Anéis','kkk','lll','30/02/2019'),(7,'Mulheres Que Correm Com Lobos','mmm','nnn','30/08/2009'),(8,'Homo Deus','ooo','ppp','30/02/2010'),(9,'Hábitos Atômicos','qqq','rrr','30/02/2009'),(10,'Mais Que Amigos','sss','ttt','30/02/2009');
/*!40000 ALTER TABLE `livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'Uniforme'),(2,'Capacete'),(3,'Luvas'),(4,'Botas'),(5,'Protetor Auricular'),(6,'Mascara'),(7,'Canetão'),(8,'Caderno');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensagem`
--

DROP TABLE IF EXISTS `mensagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensagem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mensagem` varchar(45) NOT NULL,
  `remetente` varchar(45) NOT NULL,
  `destinatario` varchar(45) NOT NULL,
  `data` varchar(10) DEFAULT NULL,
  `hora` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensagem`
--

LOCK TABLES `mensagem` WRITE;
/*!40000 ALTER TABLE `mensagem` DISABLE KEYS */;
INSERT INTO `mensagem` VALUES (1,'','','','13072022','1000'),(2,'Cada vez mais','Aluno','Professor','14/07/2022','14:30'),(3,'Estou até','Aluno','Professor','14/06/2022','14:30'),(4,'Mandando','Aluno','Professor','14/05/2022','14:30'),(5,'Mensagem','Aluno','Professor','14/04/2022','14:30'),(6,'kkkkkkk','Aluno','Professor','14/03/2022','14:20'),(7,'Pare','Professor','Aluno','14/02/2022','14:34'),(8,'Beba','Professor','Aluno','14/01/2022','14:45');
/*!40000 ALTER TABLE `mensagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prioridade`
--

DROP TABLE IF EXISTS `prioridade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prioridade` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prioridade`
--

LOCK TABLES `prioridade` WRITE;
/*!40000 ALTER TABLE `prioridade` DISABLE KEYS */;
INSERT INTO `prioridade` VALUES (1,'Urgente'),(2,'Super Alta'),(3,'Alta'),(4,'Média'),(5,'Baixa'),(6,'Super Baixa'),(7,'Menos Urgente');
/*!40000 ALTER TABLE `prioridade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sobrenome` varchar(45) NOT NULL,
  `discipliina` varchar(45) DEFAULT NULL,
  `data_admissao` varchar(15) DEFAULT NULL,
  `data_nascimento` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (1,'Alexandre','Santos','Banco de Dados','01/02/2022','10/01/1970'),(2,'Roberto','Farias','Matemática','01/03/2022','10/02/1975'),(3,'Tiago','Barbosa','Física','01/04/2022','10/03/1977'),(4,'Silvane','Alves','Química','01/03/2022','10/04/1976'),(5,'Carlos','Almeida','Português','01/04/2022','10/05/1977'),(6,'Fabio','Silva','Artes','01/03/2022','10/06/1970'),(7,'Pablo','Oliveira','História','01/04/2022','10/07/1970'),(8,'Ricardo','Ruas','Geografia','01/05/2022','10/08/1978'),(9,'Ana','vargas','Informática','01/09/2022','10/09/1970'),(10,'Mari','Martins','Administração','04/04/2004','10/08/1980');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setor`
--

DROP TABLE IF EXISTS `setor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setor` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sigla` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setor`
--

LOCK TABLES `setor` WRITE;
/*!40000 ALTER TABLE `setor` DISABLE KEYS */;
INSERT INTO `setor` VALUES (1,'Vestuário','VES'),(2,'Serviços','SER'),(3,'Construção','CON'),(4,'Entretenimento','ENT'),(5,'Publicidade','PUB'),(6,'Bebidas','BEB'),(7,'Manutenção','MAN'),(8,'Programação','PRO'),(9,'Codificação','COD');
/*!40000 ALTER TABLE `setor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `celular` varchar(12) NOT NULL,
  `setor` varchar(45) NOT NULL,
  `filial` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Mário','mario@email.com','99999 1111','Educação','Chapecó','USUARIO','usuario'),(2,'Maria','maria@email.com','99999 2222','Limpeza','Xaxim','LIMPEZA','limpeza'),(3,'André','andre@email.com','99999 3333','Segurança','Xaxim','SEGURANCA','seguranca'),(4,'Raul','raul@email.com','99999 4444','Saúde','Xaxim','SAUDE','saude'),(5,'Felipe','felipe@email.com','99999 5555','Manutenção','Xanxerê','MANUTENCAO','manutencao'),(6,'Pedro','pedro@email.com','99999 6666','Programação','Xaxim','PROGRAMACAO','programacao'),(7,'Marcos','marcos@email.com','99999 7777','Alimentação','Xanxerê','ALIMENTACAO','alimentacao'),(8,'Nelsa','nelsa@email.com','99999 8888','Codificação','Xaxim','CODIFICACAO','codificacao'),(9,'Régis','regis@email.com','99999 9999','Saúde','Xanxerê','SAUDE','saude'),(10,'João','joao@email.com','99999 1010','limpeza','Xanxerê','LIMPEZA','limpeza');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_loja'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-14 19:55:18

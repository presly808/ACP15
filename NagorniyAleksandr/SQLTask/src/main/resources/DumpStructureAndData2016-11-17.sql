CREATE DATABASE  IF NOT EXISTS `university` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `university`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: university
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_id_uindex` (`id`),
  UNIQUE KEY `groups_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'ACB17'),(2,'ACO16'),(4,'ACP14'),(3,'ACP15'),(5,'Math-1'),(6,'Math-2'),(7,'PY-314');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `students_id_uindex` (`id`),
  KEY `students_group_id_fk` (`group_id`),
  CONSTRAINT `students_group_id_fk` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Sasha Nagorniy',3),(2,'Sasha Petrov',2),(3,'Sasha Ivanov',1),(4,'Serhii Tesla',3),(5,'Antonio Ka',2),(6,'Pablo Escape',1),(7,'Stanіslavchuk Oleksandr',1),(8,'Nagornij Oleksandr',2),(9,'Olefіrenko Andrіj',3),(10,'Pilip Andrіj',4),(11,'Djachenko Іnna',5),(12,'Tkachuk Vіtalіj',6),(13,'Pіgovich Andrіj',7),(14,'Procenko Volodimir',1),(15,'Zakordonskij Sergіj',2),(16,'Komarov Oleksandr',3),(17,'Smoljar Mihajlo',4),(18,'Chegrinec Galina',5),(19,'Magerovskij Bogdan',6),(20,'Vasilev Oleksіj',7),(21,'Zhir Oleksandr',1),(22,'Ljaska Sergіj',2),(23,'Dragun Gennadіj',3),(24,'Pіdvіrnij Іvan',4),(25,'Tkachenko Oleksandr',5),(26,'Cvetkova Olga',6),(27,'Radchenko Andrіj',7),(28,'Grin Oleksandr',1),(29,'Ermolenko evgenіj',2),(30,'Celovalnіkov Maksim',3),(31,'Konovalov Oleksіj',1),(32,'Shelepun Oleksandr',1),(33,'Salovskij Taras',1),(34,'Buhanevich Kostjantin',1),(35,'Martinjuk Ljudmila',1),(36,'Vojcenko Vasil',1),(37,'Kobrіn Kostjantin',3),(38,'Jakuba Stepan',4),(39,'Borisenko Oleksandr',5),(40,'Georgіca Andrіj',6),(41,'Gudim Sergіj',7),(42,'Davidenko Jurіj',1),(43,'Іshinov Anatolіj',2),(44,'Kunchenko Oleg',3),(45,'Pіcur Olena',4),(46,'Globa Oleksіj',5),(47,'Sitnіk Іgor',6),(48,'Bіlokon Oleksіj',7),(49,'Sich Ruslan',1),(50,'Shajda Nazar',2),(51,'Vіhrovskij Sergіj',3),(52,'Gnіdij Volodimir',2),(53,'Kravchenko Volodimir',2),(54,'Glotov Dmitro',2),(55,'Globa Oleksandr',2),(56,'Lozan Іgor',2),(57,'Mic Jurіj',2),(58,'Zіnenko Vіtalіj',3),(59,'Vorobjov Dmitro',4),(60,'Brusov Vadim',5),(61,'Reshetnіkov Andrіj',6),(62,'Pahaljuk Vasil',7),(63,'Kushnіruk Mikola',1),(64,'Melashenko Vіktor',2),(65,'Shturheckij Іgor',3),(66,'Volovodjuk Oleksandr',4),(67,'Tereshhenko Anatolіj',5),(68,'Bondar Vadim',6),(69,'Fedіn Oleksіj',7),(70,'Melnichuk Ruslan',3),(71,'Kas`janov Artem',3),(72,'Kachkalda Oleksandr',3),(73,'Gannoshin Volodimir',3),(74,'Nazarov Oleksandr',3),(75,'Sopenko Sergіj',3);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study`
--

DROP TABLE IF EXISTS `study`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `study` (
  `group_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  KEY `study_group_id_fk` (`group_id`),
  KEY `study_subject_id_fk` (`subject_id`),
  KEY `study_teacher_id_fk` (`teacher_id`),
  CONSTRAINT `study_group_id_fk` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `study_subject_id_fk` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`),
  CONSTRAINT `study_teacher_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study`
--

LOCK TABLES `study` WRITE;
/*!40000 ALTER TABLE `study` DISABLE KEYS */;
INSERT INTO `study` VALUES (1,1,4),(2,1,4),(3,1,4),(4,1,4),(5,1,4),(6,1,4),(7,1,1),(1,2,1),(2,2,4),(3,2,8),(4,2,8),(5,2,9),(6,2,6),(1,3,1),(2,3,3),(7,3,4),(1,4,5),(2,4,6),(3,4,7),(4,4,1),(5,4,5),(6,4,6),(7,4,7),(1,5,1),(2,5,1),(3,5,1),(4,5,1),(5,5,1),(6,5,1),(7,5,1),(1,6,7),(2,6,1),(3,6,9),(4,6,10),(5,6,11),(6,6,12),(7,7,1);
/*!40000 ALTER TABLE `study` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_categorys`
--

DROP TABLE IF EXISTS `subject_categorys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_categorys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subject_category_id_uindex` (`id`),
  UNIQUE KEY `subject_category_title_uindex` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_categorys`
--

LOCK TABLES `subject_categorys` WRITE;
/*!40000 ALTER TABLE `subject_categorys` DISABLE KEYS */;
INSERT INTO `subject_categorys` VALUES (1,'Exact'),(2,'Humanities');
/*!40000 ALTER TABLE `subject_categorys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subject_id_uindex` (`id`),
  UNIQUE KEY `subjects_name_uindex` (`name`),
  KEY `subject_subject_category_id_fk` (`category_id`),
  CONSTRAINT `subject_subject_category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `subject_categorys` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'Mathematics',1,'Queen of Sciences'),(2,'Physics',1,'Foundation of the world'),(3,'Biology',2,'Something not important'),(4,'English',2,'Most important international language'),(5,'JAVA',1,'Strongly typed object-oriented programming language'),(6,'Python',1,'High-level general purpose programming language'),(7,'Philosophy',2,'Special form of knowledge of the world that produces a system of knowledge about the most common characteristics of maximum generalizing concepts and fundamental principles of reality (being) and cognition, human being, the relation of man and the world');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `experience` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Teacher_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (1,'Serhii Bilobrov',3),(2,'Ivan Petrov\n',2),(3,'Ivan Abdulin',5),(4,'Dow Jones',20),(5,'Ocheretjanij Volodimir',5),(6,'Matvіev Іgor',6),(7,'Prikidev Oleg',4),(8,'Lіshhuk Sergіj',10),(9,'Bіrjuk Volodimir',15),(10,'Kuharchuk Marina',20),(11,'Sergeev Oleksandr',13),(12,'Horіshman evgen',12);
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-17 18:15:02

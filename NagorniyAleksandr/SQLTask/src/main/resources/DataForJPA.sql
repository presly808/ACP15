LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'ACB17'),(2,'ACO16'),(4,'ACP14'),(3,'ACP15'),(5,'Math-1'),(6,'Math-2'),(7,'PY-314');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students`(id, name, group_id) VALUES (1,'Sasha Nagorniy',3),(2,'Sasha Petrov',2),(3,'Sasha Ivanov',1),(4,'Serhii Tesla',3),(5,'Antonio Ka',2),(6,'Pablo Escape',1),(7,'Slavchuk Oleksandr',1),(8,'Nagornij Oleksandr',2),(9,'Olefrenko Andrey',3),(10,'Pilip Andrij',4),(11,'Djachenko Inna',5),(12,'Tkachuk Vitalij',6),(13,'Pigovich Andrij',7),(14,'Procenko Volodimir',1),(15,'Zakordonskij Sergij',2),(16,'Komarov Oleksandr',3),(17,'Smoljar Mihajlo',4),(18,'Chegrinec Galina',5),(19,'Magerovskij Bogdan',6),(20,'Vasilev Oleksij',7),(21,'Zhir Oleksandr',1),(22,'Ljaska Sergij',2),(23,'Dragun Gennadij',3),(24,'Pidvirnij Ivan',4),(25,'Tkachenko Oleksandr',5),(26,'Cvetkova Olga',6),(27,'Radchenko Andrij',7),(28,'Grin Oleksandr',1),(29,'Ermolenko evgenij',2),(30,'Celovalnikov Maksim',3),(31,'Konovalov Oleksij',1),(32,'Shelepun Oleksandr',1),(33,'Salovskij Taras',1),(34,'Buhanevich Kostjantin',1),(35,'Martinjuk Ljudmila',1),(36,'Vojcenko Vasil',1),(37,'Kobrin Kostjantin',3),(38,'Jakuba Stepan',4),(39,'Borisenko Oleksandr',5),(40,'Georgica Andrij',6),(41,'Gudim Sergij',7),(42,'Davidenko Jurij',1),(43,'Ishinov Anatolij',2),(44,'Kunchenko Oleg',3),(45,'Picur Olena',4),(46,'Globa Oleksij',5),(47,'Sitnik Igor',6),(48,'Bilokon Oleksij',7),(49,'Sich Ruslan',1),(50,'Shajda Nazar',2),(51,'Vihrovskij Sergij',3),(52,'Gnidij Volodimir',2),(53,'Kravchenko Volodimir',2),(54,'Glotov Dmitro',2),(55,'Globa Oleksandr',2),(56,'Lozan Igor',2),(57,'Mic Jurij',2),(58,'Zinenko Vitalij',3),(59,'Vorobjov Dmitro',4),(60,'Brusov Vadim',5),(61,'Reshetnikov Andrij',6),(62,'Pahaljuk Vasil',7),(63,'Kushniruk Mikola',1),(64,'Melashenko Viktor',2),(65,'Shturheckij Igor',3),(66,'Volovodjuk Oleksandr',4),(67,'Tereshhenko Anatolij',5),(68,'Bondar Vadim',6),(69,'Fedin Oleksij',7),(70,'Melnichuk Ruslan',3),(71,'Kas`janov Artem',3),(72,'Kachkalda Oleksandr',3),(73,'Gannoshin Volodimir',3),(74,'Nazarov Oleksandr',3),(75,'Sopenko Sergij',3);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `study`
--

LOCK TABLES `study` WRITE;
/*!40000 ALTER TABLE `study` DISABLE KEYS */;
INSERT INTO `study`(id, group_id, subject_id, teacher_id) VALUES (1,1,1,4),(2,2,1,4),(3,3,1,4),(4,4,1,4),(5,5,1,4),(6,6,1,4),(7,7,1,1),(8,1,2,1),(9,2,2,4),(10,3,2,8),(11,4,2,8),(12,5,2,9),(13,6,2,6),(14,1,3,1),(15,2,3,3),(16,7,3,4),(17,1,4,5),(18,2,4,6),(19,3,4,7),(20,4,4,1),(21,5,4,5),(22,6,4,6),(23,7,4,7),(24,1,5,1),(25,2,5,1),(26,3,5,1),(27,4,5,1),(28,5,5,1),(29,6,5,1),(30,7,5,1),(31,1,6,7),(32,2,6,1),(33,3,6,9),(34,4,6,10),(35,5,6,11),(36,6,6,12),(37,7,7,1);/*!40000 ALTER TABLE `study` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subject_categorys`
--

LOCK TABLES `subject_categorys` WRITE;
/*!40000 ALTER TABLE `subject_categorys` DISABLE KEYS */;
INSERT INTO `subject_categorys` VALUES (1,'Exact'),(2,'Humanities');
/*!40000 ALTER TABLE `subject_categorys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects`(id, name, category_id, description) VALUES (1,'Mathematics',1,'Queen of Sciences'),(2,'Physics',1,'Foundation of the world'),(3,'Biology',2,'Something not important'),(4,'English',2,'Most important international language'),(5,'JAVA',1,'Strongly typed object-oriented programming language'),(6,'Python',1,'High-level general purpose programming language'),(7,'Philosophy',2,'Special form of knowledge of the world that produces a system of knowledge about the most common characteristics of maximum generalizing concepts and fundamental principles of reality (being) and cognition, human being, the relation of man and the world');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers`(id, name, experience) VALUES (1,'Serhii Bilobrov',3),(2,'Ivan Petrov',2),(3,'Ivan Abdulin',5),(4,'Dow Jones',20),(5,'Ocheretjanij Volodimir',5),(6,'Matviev Igor',6),(7,'Prikidev Oleg',4),(8,'Lishhuk Sergij',10),(9,'Birjuk Volodimir',15),(10,'Kuharchuk Marina',20),(11,'Sergeev Oleksandr',13),(12,'Horishman evgen',12);
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;
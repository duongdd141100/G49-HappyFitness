-- MySQL dump 10.13  Distrib 8.0.25, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: happy_fitness_v1
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `about`
--

DROP TABLE IF EXISTS `about`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `about` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `about`
--

LOCK TABLES `about` WRITE;
/*!40000 ALTER TABLE `about` DISABLE KEYS */;
/*!40000 ALTER TABLE `about` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `like_count` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `body`
--

DROP TABLE IF EXISTS `body`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `body` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `chest` int DEFAULT NULL,
  `exercise` varchar(255) DEFAULT NULL,
  `height` int DEFAULT NULL,
  `hip` int DEFAULT NULL,
  `waist` int DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `user_id` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtd6rl42xh6ei5rw6smw5xc0ey` (`user_id`),
  CONSTRAINT `FKtd6rl42xh6ei5rw6smw5xc0ey` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `body`
--

LOCK TABLES `body` WRITE;
/*!40000 ALTER TABLE `body` DISABLE KEYS */;
/*!40000 ALTER TABLE `body` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carts` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `facility_product_id` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1h94geb1hg8rjm3hr5644q57r` (`facility_product_id`),
  CONSTRAINT `FK1h94geb1hg8rjm3hr5644q57r` FOREIGN KEY (`facility_product_id`) REFERENCES `facility_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,NULL,NULL,NULL,NULL,'Thiết bị'),(2,NULL,NULL,NULL,NULL,'Thời trang'),(3,NULL,NULL,NULL,NULL,'Găng tay'),(4,NULL,NULL,NULL,NULL,'Bảo hộ');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `blog_id` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdbueb2umo93l6hbt66d8ueo2l` (`blog_id`),
  CONSTRAINT `FKdbueb2umo93l6hbt66d8ueo2l` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_like`
--

DROP TABLE IF EXISTS `customer_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_like` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `blog_id` float DEFAULT NULL,
  `customer_id` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK60h6hmoe5ih9iljn5mwlo39uj` (`blog_id`),
  KEY `FKk44rgdxxsx5c3vqs7yd4l455c` (`customer_id`),
  CONSTRAINT `FK60h6hmoe5ih9iljn5mwlo39uj` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`),
  CONSTRAINT `FKk44rgdxxsx5c3vqs7yd4l455c` FOREIGN KEY (`customer_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_like`
--

LOCK TABLES `customer_like` WRITE;
/*!40000 ALTER TABLE `customer_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_pt`
--

DROP TABLE IF EXISTS `customer_pt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_pt` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `slots_remaining` int DEFAULT NULL,
  `slots_total` int DEFAULT NULL,
  `customer_id` float DEFAULT NULL,
  `pt_id` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbw7qubictg79jv7guwek63lu3` (`customer_id`),
  KEY `FK69io8jvs0t2ex5w3cgugv2lfp` (`pt_id`),
  CONSTRAINT `FK69io8jvs0t2ex5w3cgugv2lfp` FOREIGN KEY (`pt_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKbw7qubictg79jv7guwek63lu3` FOREIGN KEY (`customer_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_pt`
--

LOCK TABLES `customer_pt` WRITE;
/*!40000 ALTER TABLE `customer_pt` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_pt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_pt_history`
--

DROP TABLE IF EXISTS `customer_pt_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_pt_history` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `end_time` datetime(6) DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `customer_pt_id` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKil6sm77gbnwg920bxluykvc3j` (`customer_pt_id`),
  CONSTRAINT `FKil6sm77gbnwg920bxluykvc3j` FOREIGN KEY (`customer_pt_id`) REFERENCES `customer_pt` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_pt_history`
--

LOCK TABLES `customer_pt_history` WRITE;
/*!40000 ALTER TABLE `customer_pt_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_pt_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_ticket`
--

DROP TABLE IF EXISTS `customer_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_ticket` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `customer_id` float DEFAULT NULL,
  `ticket_id` float DEFAULT NULL,
  `voucher_id` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8yos6r0d1xy47i05wsgisa7y2` (`customer_id`),
  KEY `FKr7fkm604421xpfksky5dysxhs` (`ticket_id`),
  KEY `FK3tjrwn7sjoishiff9q1pwp4am` (`voucher_id`),
  CONSTRAINT `FK3tjrwn7sjoishiff9q1pwp4am` FOREIGN KEY (`voucher_id`) REFERENCES `vouchers` (`id`),
  CONSTRAINT `FK8yos6r0d1xy47i05wsgisa7y2` FOREIGN KEY (`customer_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKr7fkm604421xpfksky5dysxhs` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_ticket`
--

LOCK TABLES `customer_ticket` WRITE;
/*!40000 ALTER TABLE `customer_ticket` DISABLE KEYS */;
INSERT INTO `customer_ticket` VALUES (1,'customer','2024-03-25 14:41:38.691000','customer','2024-03-25 14:41:38.691000','BUY_NEW','2024-04-25 00:00:00.000000',300000,'2024-03-25 14:41:38.659000',_binary '\0',6,1,NULL),(2,'customer','2024-03-25 15:07:54.776000','customer','2024-03-25 15:07:54.776000','BUY_NEW','2024-06-25 00:00:00.000000',500000,'2024-03-25 15:07:54.746000',_binary '\0',6,2,1),(3,'customer','2024-03-25 15:10:16.871000','customer','2024-03-25 15:10:16.871000','EXTEND','2024-04-25 00:00:00.000000',240000,'2024-03-25 15:10:16.871000',_binary '',6,1,1);
/*!40000 ALTER TABLE `customer_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facilities`
--

DROP TABLE IF EXISTS `facilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facilities` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `hotline` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `work_end_time` datetime(6) DEFAULT NULL,
  `work_start_time` datetime(6) DEFAULT NULL,
  `manager_id` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iaubb6ycs66q30o47xnmofpp` (`manager_id`),
  CONSTRAINT `FKaw0cotng6ld66odgwahggid4l` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilities`
--

LOCK TABLES `facilities` WRITE;
/*!40000 ALTER TABLE `facilities` DISABLE KEYS */;
INSERT INTO `facilities` VALUES (1,NULL,NULL,NULL,NULL,'30 Cầu Giấy','0253688688','Happy Fitness Cầu Giấy','2024-04-03 22:00:00.000000','2024-04-03 08:00:00.000000',1),(2,NULL,NULL,NULL,NULL,'25 Giải Phóng','0253678678','Happy Fitness Giải Phóng','2024-04-03 22:00:00.000000','2024-04-03 08:00:00.000000',2),(3,NULL,NULL,NULL,NULL,'Hòa Lạc','0253678678','Happy Fitness Hòa Lạc','2024-04-03 22:00:00.000000','2024-04-03 08:00:00.000000',7);
/*!40000 ALTER TABLE `facilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility_product`
--

DROP TABLE IF EXISTS `facility_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facility_product` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `stock_quantity` int DEFAULT NULL,
  `facility_id` float DEFAULT NULL,
  `product_id` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsrx26olfppkbx9wy3pwmseywc` (`facility_id`),
  KEY `FKa1yh6mf2ydv3bq97qxhslxdx0` (`product_id`),
  CONSTRAINT `FKa1yh6mf2ydv3bq97qxhslxdx0` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `FKsrx26olfppkbx9wy3pwmseywc` FOREIGN KEY (`facility_id`) REFERENCES `facilities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility_product`
--

LOCK TABLES `facility_product` WRITE;
/*!40000 ALTER TABLE `facility_product` DISABLE KEYS */;
INSERT INTO `facility_product` VALUES (22,'admin','2024-04-07 20:05:04.572000','admin','2024-04-07 20:05:04.572000',0,'COMING_SOON',0,1,13),(23,'admin','2024-04-07 20:05:04.598000','admin','2024-04-07 20:05:04.598000',0,'COMING_SOON',0,2,13),(24,'admin','2024-04-07 20:05:04.600000','admin','2024-04-07 20:05:04.600000',0,'COMING_SOON',0,3,13),(25,'admin','2024-04-07 20:15:36.001000','admin','2024-04-07 20:15:36.001000',0,'COMING_SOON',0,1,14),(26,'admin','2024-04-07 20:15:36.003000','admin','2024-04-07 20:15:36.003000',0,'COMING_SOON',0,2,14),(27,'admin','2024-04-07 20:15:36.005000','admin','2024-04-07 20:15:36.005000',0,'COMING_SOON',0,3,14),(28,'admin','2024-04-07 20:16:53.148000','admin','2024-04-07 20:16:53.148000',0,'COMING_SOON',0,1,15),(29,'admin','2024-04-07 20:16:53.150000','admin','2024-04-07 20:16:53.150000',0,'COMING_SOON',0,2,15),(30,'admin','2024-04-07 20:16:53.151000','admin','2024-04-07 20:16:53.151000',0,'COMING_SOON',0,3,15),(31,'admin','2024-04-07 20:17:22.655000','admin','2024-04-07 20:17:22.655000',0,'COMING_SOON',0,1,16),(32,'admin','2024-04-07 20:17:22.656000','admin','2024-04-07 20:17:22.656000',0,'COMING_SOON',0,2,16),(33,'admin','2024-04-07 20:17:22.658000','admin','2024-04-07 20:17:22.658000',0,'COMING_SOON',0,3,16),(34,'admin','2024-04-07 20:20:17.470000','admin','2024-04-07 20:20:17.470000',0,'COMING_SOON',0,1,17),(35,'admin','2024-04-07 20:20:17.471000','admin','2024-04-07 20:20:17.471000',0,'COMING_SOON',0,2,17),(36,'admin','2024-04-07 20:20:17.472000','admin','2024-04-07 20:20:17.472000',0,'COMING_SOON',0,3,17),(37,'admin','2024-04-07 20:22:49.366000','admin','2024-04-07 20:22:49.366000',0,'COMING_SOON',0,1,18),(38,'admin','2024-04-07 20:22:49.368000','admin','2024-04-07 20:22:49.368000',0,'COMING_SOON',0,2,18),(39,'admin','2024-04-07 20:22:49.369000','admin','2024-04-07 20:22:49.369000',0,'COMING_SOON',0,3,18),(40,'admin','2024-04-07 20:23:49.687000','admin','2024-04-07 20:23:49.687000',0,'COMING_SOON',0,1,19),(41,'admin','2024-04-07 20:23:49.689000','admin','2024-04-07 20:23:49.689000',0,'COMING_SOON',0,2,19),(42,'admin','2024-04-07 20:23:49.690000','admin','2024-04-07 20:23:49.690000',0,'COMING_SOON',0,3,19),(43,'admin','2024-04-07 20:24:22.199000','admin','2024-04-07 20:24:22.199000',0,'COMING_SOON',0,1,20),(44,'admin','2024-04-07 20:24:22.200000','admin','2024-04-07 20:24:22.200000',0,'COMING_SOON',0,2,20),(45,'admin','2024-04-07 20:24:22.202000','admin','2024-04-07 20:24:22.202000',0,'COMING_SOON',0,3,20),(46,'admin','2024-04-07 20:24:31.495000','admin','2024-04-07 20:24:31.495000',0,'COMING_SOON',0,1,21),(47,'admin','2024-04-07 20:24:31.497000','admin','2024-04-07 20:24:31.497000',0,'COMING_SOON',0,2,21),(48,'admin','2024-04-07 20:24:31.498000','admin','2024-04-07 20:24:31.498000',0,'COMING_SOON',0,3,21),(49,'admin','2024-04-07 20:24:38.763000','admin','2024-04-07 20:24:38.763000',0,'COMING_SOON',0,1,22),(50,'admin','2024-04-07 20:24:38.765000','admin','2024-04-07 20:24:38.765000',0,'COMING_SOON',0,2,22),(51,'admin','2024-04-07 20:24:38.766000','admin','2024-04-07 20:24:38.766000',0,'COMING_SOON',0,3,22),(52,'admin','2024-04-07 20:24:46.282000','admin','2024-04-07 20:24:46.282000',0,'COMING_SOON',0,1,23),(53,'admin','2024-04-07 20:24:46.283000','admin','2024-04-07 20:24:46.283000',0,'COMING_SOON',0,2,23),(54,'admin','2024-04-07 20:24:46.285000','admin','2024-04-07 20:24:46.285000',0,'COMING_SOON',0,3,23),(55,'admin','2024-04-07 20:24:55.511000','admin','2024-04-07 20:24:55.511000',0,'COMING_SOON',0,1,24),(56,'admin','2024-04-07 20:24:55.513000','admin','2024-04-07 20:24:55.513000',0,'COMING_SOON',0,2,24),(57,'admin','2024-04-07 20:24:55.515000','admin','2024-04-07 20:24:55.515000',0,'COMING_SOON',0,3,24),(58,'admin','2024-04-07 20:25:02.148000','admin','2024-04-07 20:25:02.148000',0,'COMING_SOON',0,1,25),(59,'admin','2024-04-07 20:25:02.150000','admin','2024-04-07 20:25:02.150000',0,'COMING_SOON',0,2,25),(60,'admin','2024-04-07 20:25:02.151000','admin','2024-04-07 20:25:02.151000',0,'COMING_SOON',0,3,25),(61,'admin','2024-04-07 20:25:09.868000','admin','2024-04-07 20:25:09.868000',0,'COMING_SOON',0,1,26),(62,'admin','2024-04-07 20:25:09.871000','admin','2024-04-07 20:25:09.871000',0,'COMING_SOON',0,2,26),(63,'admin','2024-04-07 20:25:09.874000','admin','2024-04-07 20:25:09.874000',0,'COMING_SOON',0,3,26),(64,'admin','2024-04-07 20:25:16.810000','admin','2024-04-07 20:25:16.810000',0,'COMING_SOON',0,1,27),(65,'admin','2024-04-07 20:25:16.812000','admin','2024-04-07 20:25:16.812000',0,'COMING_SOON',0,2,27),(66,'admin','2024-04-07 20:25:16.813000','admin','2024-04-07 20:25:16.813000',0,'COMING_SOON',0,3,27),(67,'admin','2024-04-07 20:25:25.367000','admin','2024-04-07 20:25:25.367000',0,'COMING_SOON',0,1,28),(68,'admin','2024-04-07 20:25:25.368000','admin','2024-04-07 20:25:25.368000',0,'COMING_SOON',0,2,28),(69,'admin','2024-04-07 20:25:25.370000','admin','2024-04-07 20:25:25.370000',0,'COMING_SOON',0,3,28),(70,'admin','2024-04-07 20:25:32.931000','admin','2024-04-07 20:25:32.931000',0,'COMING_SOON',0,1,29),(71,'admin','2024-04-07 20:25:32.933000','admin','2024-04-07 20:25:32.933000',0,'COMING_SOON',0,2,29),(72,'admin','2024-04-07 20:25:32.934000','admin','2024-04-07 20:25:32.934000',0,'COMING_SOON',0,3,29),(73,'admin','2024-04-07 20:25:40.325000','admin','2024-04-07 20:25:40.325000',0,'COMING_SOON',0,1,30),(74,'admin','2024-04-07 20:25:40.327000','admin','2024-04-07 20:25:40.327000',0,'COMING_SOON',0,2,30),(75,'admin','2024-04-07 20:25:40.328000','admin','2024-04-07 20:25:40.328000',0,'COMING_SOON',0,3,30),(76,'admin','2024-04-07 20:25:49.848000','admin','2024-04-07 20:25:49.848000',0,'COMING_SOON',0,1,31),(77,'admin','2024-04-07 20:25:49.850000','admin','2024-04-07 20:25:49.850000',0,'COMING_SOON',0,2,31),(78,'admin','2024-04-07 20:25:49.851000','admin','2024-04-07 20:25:49.851000',0,'COMING_SOON',0,3,31),(79,'admin','2024-04-07 20:26:37.878000','admin','2024-04-07 20:26:37.878000',0,'COMING_SOON',0,1,32),(80,'admin','2024-04-07 20:26:37.881000','admin','2024-04-07 20:26:37.881000',0,'COMING_SOON',0,2,32),(81,'admin','2024-04-07 20:26:37.882000','admin','2024-04-07 20:26:37.882000',0,'COMING_SOON',0,3,32),(82,'admin','2024-04-07 20:26:44.942000','admin','2024-04-07 20:26:44.942000',0,'COMING_SOON',0,1,33),(83,'admin','2024-04-07 20:26:44.944000','admin','2024-04-07 20:26:44.944000',0,'COMING_SOON',0,2,33),(84,'admin','2024-04-07 20:26:44.946000','admin','2024-04-07 20:26:44.946000',0,'COMING_SOON',0,3,33),(85,'admin','2024-04-07 20:27:00.536000','admin','2024-04-07 20:27:00.536000',0,'COMING_SOON',0,1,34),(86,'admin','2024-04-07 20:27:00.538000','admin','2024-04-07 20:27:00.538000',0,'COMING_SOON',0,2,34),(87,'admin','2024-04-07 20:27:00.540000','admin','2024-04-07 20:27:00.540000',0,'COMING_SOON',0,3,34),(88,'admin','2024-04-07 20:27:12.810000','admin','2024-04-07 20:27:12.810000',0,'COMING_SOON',0,1,35),(89,'admin','2024-04-07 20:27:12.811000','admin','2024-04-07 20:27:12.811000',0,'COMING_SOON',0,2,35),(90,'admin','2024-04-07 20:27:12.812000','admin','2024-04-07 20:27:12.812000',0,'COMING_SOON',0,3,35),(91,'admin','2024-04-07 20:27:21.720000','admin','2024-04-07 20:27:21.720000',0,'COMING_SOON',0,1,36),(92,'admin','2024-04-07 20:27:21.721000','admin','2024-04-07 20:27:21.721000',0,'COMING_SOON',0,2,36),(93,'admin','2024-04-07 20:27:21.722000','admin','2024-04-07 20:27:21.722000',0,'COMING_SOON',0,3,36),(94,'admin','2024-04-07 20:27:35.665000','admin','2024-04-07 20:27:35.665000',0,'COMING_SOON',0,1,37),(95,'admin','2024-04-07 20:27:35.667000','admin','2024-04-07 20:27:35.667000',0,'COMING_SOON',0,2,37),(96,'admin','2024-04-07 20:27:35.669000','admin','2024-04-07 20:27:35.669000',0,'COMING_SOON',0,3,37),(97,'admin','2024-04-07 20:27:57.306000','admin','2024-04-07 20:27:57.306000',0,'COMING_SOON',0,1,38),(98,'admin','2024-04-07 20:27:57.308000','admin','2024-04-07 20:27:57.308000',0,'COMING_SOON',0,2,38),(99,'admin','2024-04-07 20:27:57.309000','admin','2024-04-07 20:27:57.309000',0,'COMING_SOON',0,3,38),(100,'admin','2024-04-07 20:28:03.681000','admin','2024-04-07 20:28:03.681000',0,'COMING_SOON',0,1,39),(101,'admin','2024-04-07 20:28:03.682000','admin','2024-04-07 20:28:03.682000',0,'COMING_SOON',0,2,39),(102,'admin','2024-04-07 20:28:03.683000','admin','2024-04-07 20:28:03.683000',0,'COMING_SOON',0,3,39),(103,'admin','2024-04-07 20:28:12.669000','admin','2024-04-07 20:28:12.669000',0,'COMING_SOON',0,1,40),(104,'admin','2024-04-07 20:28:12.671000','admin','2024-04-07 20:28:12.671000',0,'COMING_SOON',0,2,40),(105,'admin','2024-04-07 20:28:12.675000','admin','2024-04-07 20:28:12.675000',0,'COMING_SOON',0,3,40),(106,'admin','2024-04-07 20:28:19.487000','admin','2024-04-07 20:28:19.487000',0,'COMING_SOON',0,1,41),(107,'admin','2024-04-07 20:28:19.489000','admin','2024-04-07 20:28:19.489000',0,'COMING_SOON',0,2,41),(108,'admin','2024-04-07 20:28:19.490000','admin','2024-04-07 20:28:19.490000',0,'COMING_SOON',0,3,41),(109,'admin','2024-04-07 20:28:26.506000','admin','2024-04-07 20:28:26.506000',0,'COMING_SOON',0,1,42),(110,'admin','2024-04-07 20:28:26.509000','admin','2024-04-07 20:28:26.509000',0,'COMING_SOON',0,2,42),(111,'admin','2024-04-07 20:28:26.510000','admin','2024-04-07 20:28:26.510000',0,'COMING_SOON',0,3,42),(112,'admin','2024-04-07 20:28:33.436000','admin','2024-04-07 20:28:33.436000',0,'COMING_SOON',0,1,43),(113,'admin','2024-04-07 20:28:33.437000','admin','2024-04-07 20:28:33.437000',0,'COMING_SOON',0,2,43),(114,'admin','2024-04-07 20:28:33.438000','admin','2024-04-07 20:28:33.438000',0,'COMING_SOON',0,3,43),(115,'admin','2024-04-07 20:28:39.556000','admin','2024-04-07 20:28:39.556000',0,'COMING_SOON',0,1,44),(116,'admin','2024-04-07 20:28:39.558000','admin','2024-04-07 20:28:39.558000',0,'COMING_SOON',0,2,44),(117,'admin','2024-04-07 20:28:39.559000','admin','2024-04-07 20:28:39.559000',0,'COMING_SOON',0,3,44),(118,'admin','2024-04-07 20:28:46.411000','admin','2024-04-07 20:28:46.411000',0,'COMING_SOON',0,1,45),(119,'admin','2024-04-07 20:28:46.412000','admin','2024-04-07 20:28:46.412000',0,'COMING_SOON',0,2,45),(120,'admin','2024-04-07 20:28:46.413000','admin','2024-04-07 20:28:46.413000',0,'COMING_SOON',0,3,45),(121,'admin','2024-04-07 20:28:53.525000','admin','2024-04-07 20:28:53.525000',0,'COMING_SOON',0,1,46),(122,'admin','2024-04-07 20:28:53.527000','admin','2024-04-07 20:28:53.527000',0,'COMING_SOON',0,2,46),(123,'admin','2024-04-07 20:28:53.527000','admin','2024-04-07 20:28:53.527000',0,'COMING_SOON',0,3,46);
/*!40000 ALTER TABLE `facility_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mail_template`
--

DROP TABLE IF EXISTS `mail_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mail_template` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `content` varchar(999) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1q9b666yu5untucaatw6xtsh4` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mail_template`
--

LOCK TABLES `mail_template` WRITE;
/*!40000 ALTER TABLE `mail_template` DISABLE KEYS */;
INSERT INTO `mail_template` VALUES (1,NULL,NULL,NULL,NULL,'FORGET_PASSWORD_TEMPLATE','Xin chào %s,\n\n** Đây là tin nhắn tự động -- vui lòng không trả lời vì bạn sẽ không nhận được phản hồi. **\n\nChúng tôi nhận được yêu cầu về vấn đề quên mật khẩu của bạn. Hãy nhập mã code này để có thể cài đặt lại mật khẩu: %s\n\n\nCảm ơn,\n\nĐội ngũ hỗ trợ Happy Fitness','Happy Fitness - Xác Minh Quên Mật Khẩu'),(2,NULL,NULL,NULL,NULL,'RESET_PASSWORD_TEMPLATE','Xin chào %s,\n\n** Đây là tin nhắn tự động -- vui lòng không trả lời vì bạn sẽ không nhận được phản hồi. **\n\nThông báo này nhằm đáp lại yêu cầu đặt lại mật khẩu tài khoản của bạn. Vui lòng truy cập trang web và làm theo hướng dẫn để thay đổi mật khẩu của bạn.\n\nMật khẩu của bạn là: %s\n\n\n\nCảm ơn,\n\nĐội ngũ hỗ trợ Happy Fitness','Happly Fitness - Đặt lại mật khẩu');
/*!40000 ALTER TABLE `mail_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_product` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `facility_product_id` float DEFAULT NULL,
  `order_id` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgpyn8rv0t2ylkd15b5uub0xqq` (`facility_product_id`),
  KEY `FKl5mnj9n0di7k1v90yxnthkc73` (`order_id`),
  CONSTRAINT `FKgpyn8rv0t2ylkd15b5uub0xqq` FOREIGN KEY (`facility_product_id`) REFERENCES `facility_product` (`id`),
  CONSTRAINT `FKl5mnj9n0di7k1v90yxnthkc73` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `voucher_id` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdimvsocblb17f45ikjr6xn1wj` (`voucher_id`),
  CONSTRAINT `FKdimvsocblb17f45ikjr6xn1wj` FOREIGN KEY (`voucher_id`) REFERENCES `vouchers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `category_id` float DEFAULT NULL,
  `supplier_id` float DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_57ivhy5aj3qfmdvl6vxdfjs4p` (`code`),
  KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`),
  KEY `FK6i174ixi9087gcvvut45em7fd` (`supplier_id`),
  CONSTRAINT `FK6i174ixi9087gcvvut45em7fd` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`),
  CONSTRAINT `FKog2rp4qthbtt2lfyhfo32lsw9` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (13,'admin','2024-04-07 20:05:04.386000','admin','2024-04-07 20:05:04.604000','P_20240407080504350',NULL,'https://product.hstatic.net/1000024707/product/bang-keo-title-classic-1-inch-boxing-tape-2.0-boxing-saigon__2__36e7fd484aaf404797fdc141c52a9e0a_master.jpg','Băng Keo TITLE Classic 1-Inch Boxing Tape 2.0',1,1,_binary ''),(14,'admin','2024-04-07 20:15:35.967000','admin','2024-04-07 20:15:36.006000','P_20240407081535965',NULL,'https://product.hstatic.net/1000024707/product/dsc03309_edit_d6cf875c2cc34d379b6140e9391161dc_master.jpg','Dây Nhảy Boxing Saigon Pvc Speed Rope',1,1,_binary ''),(15,'admin','2024-04-07 20:16:53.096000','admin','2024-04-07 20:16:53.153000','P_20240407081653095',NULL,'https://product.hstatic.net/1000024707/product/meister_elastic_hand_wrap_gauze_mexican_10pack_600x_dcb043bf4eaa401ea771be1a186f6edd_master.jpg','Băng Gạc Meister Traditional Elastic Gauze Hand Wraps - White',1,1,_binary ''),(16,'admin','2024-04-07 20:17:22.599000','admin','2024-04-07 20:17:22.659000','P_20240407081722598',NULL,'https://product.hstatic.net/1000024707/product/f0096422af104cf1a24f41f7b5d6d9fa_37445044e9284d81ac2ecfa87f0f3a55_master.jpg','Băng Gạc Meister Traditional Elastic Gauze Hand Wraps - Black',1,1,_binary ''),(17,'admin','2024-04-07 20:20:17.437000','admin','2024-04-07 20:20:17.473000','P_20240407082017435',NULL,'https://product.hstatic.net/1000024707/product/9210_2_1_ed4ebd7e61f740659c31b603a3ec492c_master.jpg','Băng Gạc Everlast',1,1,_binary ''),(18,'admin','2024-04-07 20:22:49.314000','admin','2024-04-07 20:22:49.370000','P_20240407082249312',NULL,'https://product.hstatic.net/1000024707/product/6_f7cf51b8e65041d7986985ebfff914d2_master.jpg','Dây Boxing Saigon Lanyard',1,1,_binary ''),(19,'admin','2024-04-07 20:23:49.639000','admin','2024-04-07 20:23:49.692000','P_20240407082349638',NULL,'https://product.hstatic.net/1000024707/product/xit_khu_mui_efd28a6eed474fc48df1bb1390008614_master.jpg','Xịt Khử Mùi Găng Tay Nano Refresh 50ml',1,1,_binary ''),(20,'admin','2024-04-07 20:24:22.147000','admin','2024-04-07 20:24:22.203000','P_20240407082422147',NULL,'https://product.hstatic.net/1000024707/product/o1cn012j2k2q2ltu6txgapo___3391779694_84df9048a3b34aa7b8230296f5cb280c_master.jpg','Móc Khóa Twins MBG3 Keyring Gloves',1,1,_binary ''),(21,'admin','2024-04-07 20:24:31.401000','admin','2024-04-07 20:24:31.499000','P_20240407082431400',NULL,'https://product.hstatic.net/1000024707/product/3a801288b0864740864e8bbcb04465b8_6bfaafe48f4b4353a217e3dbc3966bc6_master.png','Dây Nhảy Rival RJR2 Econo Jump Rope',1,1,_binary ''),(22,'admin','2024-04-07 20:24:38.726000','admin','2024-04-07 20:24:38.767000','P_20240407082438725',NULL,'https://product.hstatic.net/1000024707/product/55fbdf5ed36914ca0dd68022a187993b_logo_8a94ce535cde4828ae548fb3bb4adcf7_master.jpg','Móc Khóa Leone Mini Glove Keyring',1,1,_binary ''),(23,'admin','2024-04-07 20:24:46.207000','admin','2024-04-07 20:24:46.286000','P_20240407082446207',NULL,'https://product.hstatic.net/1000024707/product/tb2eqnrlq8lpufjy0fpxxagrpxa___1898695144_master.jpg','Dây Nhảy Cáp Tốc Độ Ver 2',1,1,_binary ''),(24,'admin','2024-04-07 20:24:55.475000','admin','2024-04-07 20:24:55.517000','P_20240407082455474',NULL,'https://product.hstatic.net/1000024707/product/twins-heavy-bag-mhb1-key-ring-white-red-2-logo_65aab59fb97841a7ae7c564f2428e164_master.jpg','Móc Khóa Twins MHB1 Heavy Bags Keyring',1,1,_binary ''),(25,'admin','2024-04-07 20:25:02.106000','admin','2024-04-07 20:25:02.153000','P_20240407082502105',NULL,'https://product.hstatic.net/1000024707/product/dsc08782_logo_766daf91f69849ce85cd57413bd19d07_master.jpg','Móc Khóa Twins MBG3 Thai Flag Keyring Gloves',1,1,_binary ''),(26,'admin','2024-04-07 20:25:09.832000','admin','2024-04-07 20:25:09.877000','P_20240407082509831',NULL,'https://product.hstatic.net/1000024707/product/form_chuan_black_logo_20e85b4a05494dfea6c13368df23245c_master.jpg','Dây Nhảy Boxing Saigon Deluxe Steel Wire Standard Speed Rope',1,1,_binary ''),(27,'admin','2024-04-07 20:25:16.756000','admin','2024-04-07 20:25:16.815000','P_20240407082516755',NULL,'https://product.hstatic.net/1000024707/product/da_chinh_sau_450af1f2bce24d968a02a7f01314e8e4_master.jpg','Khử Mùi Boxing Saigon Glove Deodorizer',1,1,_binary ''),(28,'admin','2024-04-07 20:25:25.314000','admin','2024-04-07 20:25:25.371000','P_20240407082525313',NULL,'https://hstatic.net/707/1000024707/1/2016/4-11/p00000383_master.jpg','Dây Nhảy Everlast Speed Rope',1,1,_binary ''),(29,'admin','2024-04-07 20:25:32.900000','admin','2024-04-07 20:25:32.935000','P_20240407082532900',NULL,'https://product.hstatic.net/1000024707/product/cleto-reyes-keycham-usa_f0da8aa018414bfd8015157286c7890f_master.jpg','Móc Khóa Cleto Reyes Mini Glove Keyring',1,1,_binary ''),(30,'admin','2024-04-07 20:25:40.286000','admin','2024-04-07 20:25:40.329000','P_20240407082540285',NULL,'https://product.hstatic.net/1000024707/product/red_cap_logo_f954c7768614489c90f237e53f2c8a4e_master.jpg','Dây Nhảy Boxing Saigon Deluxe Steel Wire Slim Speed Rope',1,1,_binary ''),(31,'admin','2024-04-07 20:25:49.795000','admin','2024-04-07 20:25:49.852000','P_20240407082549794',NULL,'https://product.hstatic.net/1000024707/product/vgc_6_6c78004c93f04fecb3ff440d50e279f0_master.jpg','Dây Cố Định Cổ Tay TITLE Hook & Loop Glove Converter',1,1,_binary ''),(32,'admin','2024-04-07 20:26:37.824000','admin','2024-04-07 20:26:37.884000','P_20240407082637823',NULL,'https://product.hstatic.net/1000024707/product/frontsideofmouthguardcase_2000x_91664f1850cf47279d380212ea1be289_master.jpg','Hộp Đựng Ngậm Răng Damage Control Antimicrobial Mouthguard Case',1,1,_binary ''),(33,'admin','2024-04-07 20:26:44.888000','admin','2024-04-07 20:26:44.948000','P_20240407082644888',NULL,'https://product.hstatic.net/1000024707/product/002002002-7922_ff3d66e287044f528e825f326d8827bb_master.jpg','Khử Mùi Machomai Glove Deodorizer',1,1,_binary ''),(34,'admin','2024-04-07 20:27:00.496000','admin','2024-04-07 20:27:00.542000','P_20240407082700493',NULL,'https://product.hstatic.net/1000024707/product/o1cn01qwadw41fu6vwlruee___987430546-0-cib_91ca545c4ec44133ae39c11a0014f95c_master.jpg','Dây Nhảy Bn Deluxe Jump Rope',1,1,_binary ''),(35,'admin','2024-04-07 20:27:12.759000','admin','2024-04-07 20:27:12.813000','P_20240407082712758',NULL,'https://product.hstatic.net/1000024707/product/day-nhay-twins-sr2-bred-boxing-saigon__3__logo_609f7c3fcbdc4cbcbe396840731f0ca3_master.jpg','Xịt Khử Mùi TITLE Odor-Aid Disinfectant Spray',1,1,_binary ''),(36,'admin','2024-04-07 20:27:21.645000','admin','2024-04-07 20:27:21.723000','P_20240407082721645',NULL,'https://product.hstatic.net/1000024707/product/66aafd3970084b279902d1836530f014_711bd283f7e042d794da2f84f9893cca_master.jpg','Đích Đấm Bn Punch Mitts',1,1,_binary ''),(37,'admin','2024-04-07 20:27:35.609000','admin','2024-04-07 20:27:35.671000','P_20240407082735608',NULL,'https://product.hstatic.net/1000024707/product/tb2n8ssdjhvoufjszfbxxczgfxa_1864949801_47a2c2d832de4b6499491f809d883da6_master.jpg','MongKol Set',1,1,_binary ''),(38,'admin','2024-04-07 20:27:57.275000','admin','2024-04-07 20:27:57.311000','P_20240407082757274',NULL,'https://product.hstatic.net/1000024707/product/mongkol-handmade-sitmonchai_1_3dee8017cba341b19153378d1885f421_master.jpg','Đích Đấm Boxing Saigon Speed Mitts - White',1,1,_binary ''),(39,'admin','2024-04-07 20:28:03.592000','admin','2024-04-07 20:28:03.684000','P_20240407082803592',NULL,'https://product.hstatic.net/1000024707/product/dsc00268_combo_0f17149e12974ec4ac188a8f87b980f0_master.jpg','Đích Đấm BN C-01 Focus Pad',1,1,_binary ''),(40,'admin','2024-04-07 20:28:12.602000','admin','2024-04-07 20:28:12.678000','P_20240407082812602',NULL,'https://product.hstatic.net/1000024707/product/o1cn01w04mlo1f9qv7sknwj___2200539690445-0-cib_e6994ba1cf2b401390f2ac7fbecec9d2_master.jpg','Đồng Hồ Interval Training Round Timer Everlast',1,1,_binary ''),(41,'admin','2024-04-07 20:28:19.438000','admin','2024-04-07 20:28:19.491000','P_20240407082819437',NULL,'https://product.hstatic.net/1000024707/product/everlast_interval_training_round_timer_ee1d1843a22c48099f33690174b304fe_master.jpg','Đích Đấm Tốc Độ BN Mike\'S Land Focus Pad Mini',1,1,_binary ''),(42,'admin','2024-04-07 20:28:26.424000','admin','2024-04-07 20:28:26.511000','P_20240407082826415',NULL,'https://product.hstatic.net/1000024707/product/0fc43675a4cb403fb39cbf070ea6a066_187ea0bd1f90465584de2d6be90bac44_master.jpg','Dây Nhảy Venum Competitor Weighted Jump Rope',1,1,_binary ''),(43,'admin','2024-04-07 20:28:33.387000','admin','2024-04-07 20:28:33.440000','P_20240407082833387',NULL,'https://hstatic.net/707/1000024707/1/2016/8-26/corde_a_sauter_competitor_red_620_01_1_3_master.jpg','Đích Đấm Tròn Bn Big Size 2020',1,1,_binary ''),(44,'admin','2024-04-07 20:28:39.500000','admin','2024-04-07 20:28:39.561000','P_20240407082839500',NULL,'https://product.hstatic.net/1000024707/product/11752932643_478717145_08f90c702aa546ed9ff3fb06fb002e88_master.jpg','Đích Đấm Đá BN Focus Mitts',1,1,_binary ''),(45,'admin','2024-04-07 20:28:46.381000','admin','2024-04-07 20:28:46.414000','P_20240407082846380',NULL,'https://product.hstatic.net/1000024707/product/1-logo_937cb4515cf14b13b8e8c83e69b0affa_master.jpg','Đích Đấm Everlast Elite 2 Punch Mitts - Black/Gold',1,1,_binary ''),(46,'admin','2024-04-07 20:28:53.477000','admin','2024-04-07 20:28:53.528000','P_20240407082853476',NULL,'https://product.hstatic.net/1000024707/product/eliteminimitts_black_pdp_370ad19fe320456b9b775b14513516ed_master.jpg','Đích Đấm Đùi Gà Windy WBP Boxing Paddles',1,1,_binary '');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,NULL,NULL,NULL,NULL,'Admin'),(2,NULL,NULL,NULL,NULL,'Manager'),(3,NULL,NULL,NULL,NULL,'Customer'),(4,NULL,NULL,NULL,NULL,'Receptionist'),(5,NULL,NULL,NULL,NULL,'Personal Trainer');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suppliers` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,NULL,NULL,NULL,NULL,'Supplier 1'),(2,NULL,NULL,NULL,NULL,'Supplier 2'),(3,NULL,NULL,NULL,NULL,'Supplier 3');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `month_duration` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `facility_id` float DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjt9q8juybq5f2c56m4e7joxy4` (`facility_id`),
  CONSTRAINT `FKjt9q8juybq5f2c56m4e7joxy4` FOREIGN KEY (`facility_id`) REFERENCES `facilities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (1,'admin','2024-02-29 16:06:45.272000','admin','2024-02-29 16:06:45.272000','T_1M','',1,'Vé 1 tháng',300000,1,NULL),(2,'manager_caugiay','2024-02-29 16:08:23.610000','manager_caugiay','2024-02-29 16:08:23.610000','T_3M','',3,'Vé 3 tháng',600000,1,NULL);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `facility_id` float DEFAULT NULL,
  `role_id` float DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpl5qpsn7qmnvp22slbem3lvu6` (`facility_id`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`),
  CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKpl5qpsn7qmnvp22slbem3lvu6` FOREIGN KEY (`facility_id`) REFERENCES `facilities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,'managercaugiay@gmail.com','Quản lý chi nhánh Cầu Giấy',NULL,'$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,NULL,'manager_caugiay',1,2,_binary ''),(2,NULL,NULL,NULL,NULL,NULL,NULL,'managergiaiphong@gmail.com','Quản lý chi nhánh Giải Phóng',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','manager_giaiphong',2,2,_binary ''),(3,NULL,NULL,NULL,NULL,NULL,'2000-11-14 07:00:00.000000','letancaugiay@gmail.com','Lễ tân Cầu Giấy',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','user_caugiay',1,4,_binary ''),(4,NULL,NULL,NULL,NULL,NULL,'2000-11-14 07:00:00.000000','letangiaiphong@gmail.com','Lễ tân Giải Phóng',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','user_giaiphong',2,4,_binary ''),(5,NULL,NULL,NULL,NULL,NULL,'2000-11-14 07:00:00.000000','admin@gmail.com','Admin',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','admin',NULL,1,_binary ''),(6,NULL,NULL,NULL,NULL,NULL,NULL,'customer@gmail.com','Customer',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','customer',NULL,3,_binary ''),(7,NULL,NULL,NULL,NULL,NULL,NULL,'managerhoalac@gmail.com','Quản lý chi nhánh Hòa Lạc',_binary '\0','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','manager_hoalac',3,2,_binary ''),(8,'System','2024-04-04 15:31:49.546000','System','2024-04-04 15:31:49.546000','HN','2000-11-14 07:00:00.000000','giangdd@gmail.com','Đỗ Đức Dương',_binary '','$2a$10$JQuquWRvqdVfDMmjl.Cy6exphZfDOTDNA0p1cue/Nie0rfK.wDKai',NULL,'0979719735','duongdd',NULL,3,NULL),(9,'System','2024-04-04 22:26:32.085000','System','2024-04-04 22:26:32.085000','HN','2000-11-14 07:00:00.000000','duongdd141100@gmail.com','Đỗ Đức Dương',_binary '\0','$2a$10$yWLTr1OzqBE/OfwWGe3VD.tbziNVUVE3.ulAVRM3d8uM8E5vLrNni',NULL,'0979719735','duongdd1',NULL,3,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vouchers`
--

DROP TABLE IF EXISTS `vouchers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vouchers` (
  `id` float NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `percent_amount` int DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `max_money_amount` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vouchers`
--

LOCK TABLES `vouchers` WRITE;
/*!40000 ALTER TABLE `vouchers` DISABLE KEYS */;
INSERT INTO `vouchers` VALUES (1,NULL,NULL,NULL,NULL,'VOUCHER_1',NULL,'2024-04-28 00:00:00.000000','Voucher 1',20,'2024-02-26 00:00:00.000000',100000),(2,'admin','2024-03-07 14:51:31.884000','admin','2024-03-07 14:53:26.553000','VOUCHER_20240307025131863','Voucher 2','2024-05-01 07:00:00.000000','Voucher 2',20,'2024-02-01 07:00:00.000000',70000);
/*!40000 ALTER TABLE `vouchers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-07 20:42:04

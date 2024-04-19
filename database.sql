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
  `id` bigint NOT NULL AUTO_INCREMENT,
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
  `id` bigint NOT NULL AUTO_INCREMENT,
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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `facility_product_id` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1h94geb1hg8rjm3hr5644q57r` (`facility_product_id`),
  CONSTRAINT `FK1h94geb1hg8rjm3hr5644q57r` FOREIGN KEY (`facility_product_id`) REFERENCES `facility_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
INSERT INTO `carts` VALUES (13,'customer','2024-04-19 13:28:08.495000','customer','2024-04-19 13:28:08.495000',2,424),(14,'duongdd','2024-04-19 13:39:28.188000','duongdd','2024-04-19 13:39:52.175000',5,391);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,NULL,NULL,NULL,NULL,'Khử mùi'),(2,NULL,NULL,NULL,NULL,'Thời trang'),(3,NULL,NULL,NULL,NULL,'Găng tay'),(4,NULL,NULL,NULL,NULL,'Bảo hộ'),(6,NULL,NULL,NULL,NULL,'Thực phẩm chức năng tăng hiệu suất tập luyện'),(7,NULL,NULL,NULL,NULL,'Thực phẩm chức năng hỗ trợ giảm mỡ'),(8,NULL,NULL,NULL,NULL,'Sữa tăng cân'),(9,NULL,NULL,NULL,NULL,'Thực phẩm chức năng sức khỏe toàn diện'),(10,NULL,NULL,NULL,NULL,'Thực phẩm chức năng tăng hormone'),(11,NULL,NULL,NULL,NULL,'Whey protein'),(12,NULL,NULL,NULL,NULL,'Đích đấm'),(13,NULL,NULL,NULL,NULL,'Băng gạc'),(14,NULL,NULL,NULL,NULL,'Dây nhảy');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
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
  `id` bigint NOT NULL AUTO_INCREMENT,
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
  `id` bigint NOT NULL AUTO_INCREMENT,
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
  `id` bigint NOT NULL AUTO_INCREMENT,
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
  `work_end_time` time(6) DEFAULT NULL,
  `work_start_time` time(6) DEFAULT NULL,
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
INSERT INTO `facilities` VALUES (1,NULL,NULL,NULL,NULL,'30 Cầu Giấy','0253688688','Happy Fitness Cầu Giấy','22:00:00.000000','08:00:00.000000',1),(2,NULL,NULL,NULL,NULL,'25 Giải Phóng','0253678678','Happy Fitness Giải Phóng','22:00:00.000000','08:00:00.000000',2),(3,NULL,NULL,NULL,NULL,'Hòa Lạc','0253678678','Happy Fitness Hòa Lạc','22:00:00.000000','08:00:00.000000',7);
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
) ENGINE=InnoDB AUTO_INCREMENT=448 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility_product`
--

LOCK TABLES `facility_product` WRITE;
/*!40000 ALTER TABLE `facility_product` DISABLE KEYS */;
INSERT INTO `facility_product` VALUES (22,'admin','2024-04-07 20:05:04.572000','admin','2024-04-16 16:26:29.078000',1050000,'ACTIVE',100,1,13),(23,'admin','2024-04-07 20:05:04.598000','admin','2024-04-16 16:26:29.082000',1200000,'ACTIVE',100,2,13),(24,'admin','2024-04-07 20:05:04.600000','customer','2024-04-17 15:05:42.281000',350000,'ACTIVE',97,3,13),(25,'admin','2024-04-07 20:15:36.001000','admin','2024-04-16 16:26:29.083000',350000,'ACTIVE',100,1,14),(26,'admin','2024-04-07 20:15:36.003000','admin','2024-04-16 16:26:29.083000',450000,'ACTIVE',100,2,14),(27,'admin','2024-04-07 20:15:36.005000','customer','2024-04-17 15:05:42.283000',450000,'ACTIVE',98,3,14),(28,'admin','2024-04-07 20:16:53.148000','admin','2024-04-16 16:26:29.083000',600000,'ACTIVE',100,1,15),(29,'admin','2024-04-07 20:16:53.150000','admin','2024-04-16 16:26:29.084000',550000,'ACTIVE',100,2,15),(30,'admin','2024-04-07 20:16:53.151000','customer','2024-04-17 15:05:42.283000',200000,'ACTIVE',98,3,15),(31,'admin','2024-04-07 20:17:22.655000','admin','2024-04-16 16:26:29.084000',950000,'ACTIVE',100,1,16),(32,'admin','2024-04-07 20:17:22.656000','admin','2024-04-16 16:26:29.084000',700000,'ACTIVE',100,2,16),(33,'admin','2024-04-07 20:17:22.658000','admin','2024-04-16 16:26:29.084000',550000,'ACTIVE',100,3,16),(34,'admin','2024-04-07 20:20:17.470000','admin','2024-04-16 16:26:29.085000',900000,'ACTIVE',100,1,17),(35,'admin','2024-04-07 20:20:17.471000','admin','2024-04-16 16:26:29.085000',1000000,'ACTIVE',100,2,17),(36,'admin','2024-04-07 20:20:17.472000','admin','2024-04-16 16:26:29.085000',1200000,'ACTIVE',100,3,17),(40,'admin','2024-04-07 20:23:49.687000','admin','2024-04-16 16:26:29.086000',800000,'ACTIVE',100,1,19),(41,'admin','2024-04-07 20:23:49.689000','admin','2024-04-16 16:26:29.086000',600000,'ACTIVE',100,2,19),(42,'admin','2024-04-07 20:23:49.690000','admin','2024-04-16 16:26:29.086000',450000,'ACTIVE',100,3,19),(46,'admin','2024-04-07 20:24:31.495000','admin','2024-04-16 16:26:29.086000',950000,'ACTIVE',100,1,21),(47,'admin','2024-04-07 20:24:31.497000','admin','2024-04-16 16:26:29.086000',300000,'ACTIVE',100,2,21),(48,'admin','2024-04-07 20:24:31.498000','admin','2024-04-16 16:26:29.086000',400000,'ACTIVE',100,3,21),(52,'admin','2024-04-07 20:24:46.282000','admin','2024-04-16 16:26:29.087000',100000,'ACTIVE',100,1,23),(53,'admin','2024-04-07 20:24:46.283000','admin','2024-04-16 16:26:29.087000',400000,'ACTIVE',100,2,23),(54,'admin','2024-04-07 20:24:46.285000','admin','2024-04-16 16:26:29.087000',700000,'ACTIVE',100,3,23),(61,'admin','2024-04-07 20:25:09.868000','admin','2024-04-16 16:26:29.087000',1150000,'ACTIVE',100,1,26),(62,'admin','2024-04-07 20:25:09.871000','admin','2024-04-16 16:26:29.087000',100000,'ACTIVE',100,2,26),(63,'admin','2024-04-07 20:25:09.874000','admin','2024-04-16 16:26:29.087000',1200000,'ACTIVE',100,3,26),(64,'admin','2024-04-07 20:25:16.810000','admin','2024-04-16 16:26:29.087000',400000,'ACTIVE',100,1,27),(65,'admin','2024-04-07 20:25:16.812000','admin','2024-04-16 16:26:29.087000',200000,'ACTIVE',100,2,27),(66,'admin','2024-04-07 20:25:16.813000','admin','2024-04-16 16:26:29.088000',950000,'ACTIVE',100,3,27),(67,'admin','2024-04-07 20:25:25.367000','admin','2024-04-16 16:26:29.088000',400000,'ACTIVE',100,1,28),(68,'admin','2024-04-07 20:25:25.368000','admin','2024-04-16 16:26:29.088000',400000,'ACTIVE',100,2,28),(69,'admin','2024-04-07 20:25:25.370000','admin','2024-04-16 16:26:29.088000',650000,'ACTIVE',100,3,28),(73,'admin','2024-04-07 20:25:40.325000','admin','2024-04-16 16:26:29.088000',800000,'ACTIVE',100,1,30),(74,'admin','2024-04-07 20:25:40.327000','admin','2024-04-16 16:26:29.088000',300000,'ACTIVE',100,2,30),(75,'admin','2024-04-07 20:25:40.328000','admin','2024-04-16 16:26:29.088000',1000000,'ACTIVE',100,3,30),(82,'admin','2024-04-07 20:26:44.942000','admin','2024-04-16 16:26:29.088000',500000,'ACTIVE',100,1,33),(83,'admin','2024-04-07 20:26:44.944000','admin','2024-04-16 16:26:29.089000',650000,'ACTIVE',100,2,33),(84,'admin','2024-04-07 20:26:44.946000','admin','2024-04-16 16:26:29.089000',950000,'ACTIVE',100,3,33),(85,'admin','2024-04-07 20:27:00.536000','admin','2024-04-16 16:26:29.089000',900000,'ACTIVE',100,1,34),(86,'admin','2024-04-07 20:27:00.538000','admin','2024-04-16 16:26:29.089000',1150000,'ACTIVE',100,2,34),(87,'admin','2024-04-07 20:27:00.540000','admin','2024-04-16 16:26:29.089000',650000,'ACTIVE',100,3,34),(88,'admin','2024-04-07 20:27:12.810000','admin','2024-04-16 16:26:29.089000',600000,'ACTIVE',100,1,35),(89,'admin','2024-04-07 20:27:12.811000','admin','2024-04-16 16:26:29.089000',150000,'ACTIVE',100,2,35),(90,'admin','2024-04-07 20:27:12.812000','admin','2024-04-16 16:26:29.089000',850000,'ACTIVE',100,3,35),(91,'admin','2024-04-07 20:27:21.720000','admin','2024-04-16 16:26:29.090000',700000,'ACTIVE',100,1,36),(92,'admin','2024-04-07 20:27:21.721000','admin','2024-04-16 16:26:29.090000',950000,'ACTIVE',100,2,36),(93,'admin','2024-04-07 20:27:21.722000','admin','2024-04-16 16:26:29.090000',500000,'ACTIVE',100,3,36),(97,'admin','2024-04-07 20:27:57.306000','admin','2024-04-16 16:26:29.090000',1150000,'ACTIVE',100,1,38),(98,'admin','2024-04-07 20:27:57.308000','admin','2024-04-16 16:26:29.090000',250000,'ACTIVE',100,2,38),(99,'admin','2024-04-07 20:27:57.309000','admin','2024-04-16 16:26:29.090000',1100000,'ACTIVE',100,3,38),(100,'admin','2024-04-07 20:28:03.681000','admin','2024-04-16 16:26:29.090000',300000,'ACTIVE',100,1,39),(101,'admin','2024-04-07 20:28:03.682000','admin','2024-04-16 16:26:29.090000',100000,'ACTIVE',100,2,39),(102,'admin','2024-04-07 20:28:03.683000','admin','2024-04-16 16:26:29.091000',950000,'ACTIVE',100,3,39),(106,'admin','2024-04-07 20:28:19.487000','admin','2024-04-16 16:26:29.091000',300000,'ACTIVE',100,1,41),(107,'admin','2024-04-07 20:28:19.489000','admin','2024-04-16 16:26:29.091000',950000,'ACTIVE',100,2,41),(108,'admin','2024-04-07 20:28:19.490000','admin','2024-04-16 16:26:29.091000',350000,'ACTIVE',100,3,41),(109,'admin','2024-04-07 20:28:26.506000','admin','2024-04-16 16:26:29.091000',900000,'ACTIVE',100,1,42),(110,'admin','2024-04-07 20:28:26.509000','admin','2024-04-16 16:26:29.091000',1150000,'ACTIVE',100,2,42),(111,'admin','2024-04-07 20:28:26.510000','admin','2024-04-16 16:26:29.091000',400000,'ACTIVE',100,3,42),(112,'admin','2024-04-07 20:28:33.436000','admin','2024-04-16 16:26:29.091000',1200000,'ACTIVE',100,1,43),(113,'admin','2024-04-07 20:28:33.437000','admin','2024-04-16 16:26:29.091000',750000,'ACTIVE',100,2,43),(114,'admin','2024-04-07 20:28:33.438000','admin','2024-04-16 16:26:29.092000',500000,'ACTIVE',100,3,43),(115,'admin','2024-04-07 20:28:39.556000','admin','2024-04-16 16:26:29.092000',500000,'ACTIVE',100,1,44),(116,'admin','2024-04-07 20:28:39.558000','admin','2024-04-16 16:26:29.092000',400000,'ACTIVE',100,2,44),(117,'admin','2024-04-07 20:28:39.559000','admin','2024-04-16 16:26:29.092000',100000,'ACTIVE',100,3,44),(118,'admin','2024-04-07 20:28:46.411000','admin','2024-04-16 16:26:29.092000',250000,'ACTIVE',100,1,45),(119,'admin','2024-04-07 20:28:46.412000','admin','2024-04-16 16:26:29.093000',400000,'ACTIVE',100,2,45),(120,'admin','2024-04-07 20:28:46.413000','admin','2024-04-16 16:26:29.093000',450000,'ACTIVE',100,3,45),(121,'admin','2024-04-07 20:28:53.525000','admin','2024-04-16 16:26:29.093000',650000,'ACTIVE',100,1,46),(122,'admin','2024-04-07 20:28:53.527000','admin','2024-04-16 16:26:29.093000',850000,'ACTIVE',100,2,46),(123,'admin','2024-04-07 20:28:53.527000','admin','2024-04-16 16:26:29.093000',550000,'ACTIVE',100,3,46),(124,'admin','2024-04-16 11:53:59.754000','admin','2024-04-16 16:26:29.094000',1000000,'ACTIVE',100,1,47),(125,'admin','2024-04-16 11:53:59.797000','admin','2024-04-16 16:26:29.094000',350000,'ACTIVE',100,2,47),(126,'admin','2024-04-16 11:53:59.799000','admin','2024-04-16 16:26:29.094000',600000,'ACTIVE',100,3,47),(127,'admin','2024-04-16 11:54:09.325000','admin','2024-04-16 16:26:29.094000',750000,'ACTIVE',100,1,48),(128,'admin','2024-04-16 11:54:09.330000','admin','2024-04-16 16:26:29.094000',150000,'ACTIVE',100,2,48),(129,'admin','2024-04-16 11:54:09.332000','admin','2024-04-16 16:26:29.095000',850000,'ACTIVE',100,3,48),(130,'admin','2024-04-16 11:54:18.546000','admin','2024-04-16 16:26:29.095000',1000000,'ACTIVE',100,1,49),(131,'admin','2024-04-16 11:54:18.548000','admin','2024-04-16 16:26:29.095000',800000,'ACTIVE',100,2,49),(132,'admin','2024-04-16 11:54:18.554000','admin','2024-04-16 16:26:29.095000',1200000,'ACTIVE',100,3,49),(133,'admin','2024-04-16 11:54:30.141000','admin','2024-04-16 16:26:29.095000',500000,'ACTIVE',100,1,50),(134,'admin','2024-04-16 11:54:30.171000','admin','2024-04-16 16:26:29.095000',1000000,'ACTIVE',100,2,50),(135,'admin','2024-04-16 11:54:30.174000','admin','2024-04-16 16:26:29.095000',1100000,'ACTIVE',100,3,50),(136,'admin','2024-04-16 11:54:40.085000','admin','2024-04-16 16:26:29.096000',500000,'ACTIVE',100,1,51),(137,'admin','2024-04-16 11:54:40.088000','admin','2024-04-16 16:26:29.096000',1150000,'ACTIVE',100,2,51),(138,'admin','2024-04-16 11:54:40.089000','admin','2024-04-16 16:26:29.096000',900000,'ACTIVE',100,3,51),(139,'admin','2024-04-16 11:54:49.292000','admin','2024-04-16 16:26:29.096000',900000,'ACTIVE',100,1,52),(140,'admin','2024-04-16 11:54:49.297000','admin','2024-04-16 16:26:29.096000',300000,'ACTIVE',100,2,52),(141,'admin','2024-04-16 11:54:49.299000','admin','2024-04-16 16:26:29.096000',450000,'ACTIVE',100,3,52),(142,'admin','2024-04-16 11:55:00.472000','admin','2024-04-16 16:26:29.096000',1100000,'ACTIVE',100,1,53),(143,'admin','2024-04-16 11:55:00.473000','admin','2024-04-16 16:26:29.096000',250000,'ACTIVE',100,2,53),(144,'admin','2024-04-16 11:55:00.474000','admin','2024-04-16 16:26:29.096000',850000,'ACTIVE',100,3,53),(145,'admin','2024-04-16 11:55:08.722000','admin','2024-04-16 16:26:29.097000',850000,'ACTIVE',100,1,54),(146,'admin','2024-04-16 11:55:08.724000','admin','2024-04-16 16:26:29.097000',1050000,'ACTIVE',100,2,54),(147,'admin','2024-04-16 11:55:08.725000','admin','2024-04-16 16:26:29.097000',450000,'ACTIVE',100,3,54),(148,'admin','2024-04-16 11:55:19.097000','admin','2024-04-16 16:26:29.097000',1050000,'ACTIVE',100,1,55),(149,'admin','2024-04-16 11:55:19.101000','admin','2024-04-16 16:26:29.097000',550000,'ACTIVE',100,2,55),(150,'admin','2024-04-16 11:55:19.103000','admin','2024-04-16 16:26:29.097000',650000,'ACTIVE',100,3,55),(151,'admin','2024-04-16 11:55:26.099000','admin','2024-04-16 16:26:29.097000',800000,'ACTIVE',100,1,56),(152,'admin','2024-04-16 11:55:26.101000','admin','2024-04-16 16:26:29.097000',1000000,'ACTIVE',100,2,56),(153,'admin','2024-04-16 11:55:26.103000','admin','2024-04-16 16:26:29.098000',750000,'ACTIVE',100,3,56),(154,'admin','2024-04-16 12:16:35.150000','admin','2024-04-16 16:26:29.098000',700000,'ACTIVE',100,1,57),(155,'admin','2024-04-16 12:16:35.153000','admin','2024-04-16 16:26:29.098000',950000,'ACTIVE',100,2,57),(156,'admin','2024-04-16 12:16:35.155000','admin','2024-04-16 16:26:29.098000',600000,'ACTIVE',100,3,57),(157,'admin','2024-04-16 12:18:14.967000','admin','2024-04-16 16:26:29.098000',1200000,'ACTIVE',100,1,58),(158,'admin','2024-04-16 12:18:14.969000','admin','2024-04-16 16:26:29.099000',600000,'ACTIVE',100,2,58),(159,'admin','2024-04-16 12:18:14.971000','admin','2024-04-16 16:26:29.099000',950000,'ACTIVE',100,3,58),(160,'admin','2024-04-16 12:22:42.091000','admin','2024-04-16 16:26:29.099000',950000,'ACTIVE',100,1,59),(161,'admin','2024-04-16 12:22:42.092000','admin','2024-04-16 16:26:29.099000',550000,'ACTIVE',100,2,59),(162,'admin','2024-04-16 12:22:42.095000','admin','2024-04-16 16:26:29.099000',950000,'ACTIVE',100,3,59),(163,'admin','2024-04-16 12:23:00.490000','admin','2024-04-16 16:26:29.099000',1000000,'ACTIVE',100,1,60),(164,'admin','2024-04-16 12:23:00.494000','admin','2024-04-16 16:26:29.099000',450000,'ACTIVE',100,2,60),(165,'admin','2024-04-16 12:23:00.497000','admin','2024-04-16 16:26:29.099000',600000,'ACTIVE',100,3,60),(166,'admin','2024-04-16 12:23:11.065000','admin','2024-04-16 16:26:29.100000',1200000,'ACTIVE',100,1,61),(167,'admin','2024-04-16 12:23:11.067000','admin','2024-04-16 16:26:29.100000',600000,'ACTIVE',100,2,61),(168,'admin','2024-04-16 12:23:11.068000','admin','2024-04-16 16:26:29.100000',500000,'ACTIVE',100,3,61),(169,'admin','2024-04-16 12:23:16.630000','admin','2024-04-16 16:26:29.100000',950000,'ACTIVE',100,1,62),(170,'admin','2024-04-16 12:23:16.632000','admin','2024-04-16 16:26:29.101000',550000,'ACTIVE',100,2,62),(171,'admin','2024-04-16 12:23:16.634000','admin','2024-04-16 16:26:29.101000',150000,'ACTIVE',100,3,62),(172,'admin','2024-04-16 12:23:22.942000','admin','2024-04-16 16:26:29.101000',1200000,'ACTIVE',100,1,63),(173,'admin','2024-04-16 12:23:22.944000','admin','2024-04-16 16:26:29.101000',550000,'ACTIVE',100,2,63),(174,'admin','2024-04-16 12:23:22.945000','admin','2024-04-16 16:26:29.101000',1200000,'ACTIVE',100,3,63),(175,'admin','2024-04-16 12:23:33.367000','admin','2024-04-16 16:26:29.101000',100000,'ACTIVE',100,1,64),(176,'admin','2024-04-16 12:23:33.368000','admin','2024-04-16 16:26:29.102000',450000,'ACTIVE',100,2,64),(177,'admin','2024-04-16 12:23:33.369000','admin','2024-04-16 16:26:29.102000',500000,'ACTIVE',100,3,64),(178,'admin','2024-04-16 12:23:42.018000','admin','2024-04-16 16:26:29.103000',450000,'ACTIVE',100,1,65),(179,'admin','2024-04-16 12:23:42.020000','admin','2024-04-16 16:26:29.103000',1000000,'ACTIVE',100,2,65),(180,'admin','2024-04-16 12:23:42.022000','admin','2024-04-16 16:26:29.103000',900000,'ACTIVE',100,3,65),(181,'admin','2024-04-16 12:23:47.792000','admin','2024-04-16 16:26:29.104000',1000000,'ACTIVE',100,1,66),(182,'admin','2024-04-16 12:23:47.794000','admin','2024-04-16 16:26:29.104000',700000,'ACTIVE',100,2,66),(183,'admin','2024-04-16 12:23:47.796000','admin','2024-04-16 16:26:29.104000',450000,'ACTIVE',100,3,66),(184,'admin','2024-04-16 12:33:09.524000','admin','2024-04-16 16:26:29.104000',250000,'ACTIVE',100,1,67),(185,'admin','2024-04-16 12:33:09.525000','admin','2024-04-16 16:26:29.104000',150000,'ACTIVE',100,2,67),(186,'admin','2024-04-16 12:33:09.526000','admin','2024-04-16 16:26:29.104000',500000,'ACTIVE',100,3,67),(187,'admin','2024-04-16 12:33:16.073000','admin','2024-04-16 16:26:29.104000',1200000,'ACTIVE',100,1,68),(188,'admin','2024-04-16 12:33:16.075000','admin','2024-04-16 16:26:29.104000',900000,'ACTIVE',100,2,68),(189,'admin','2024-04-16 12:33:16.077000','admin','2024-04-16 16:26:29.104000',1150000,'ACTIVE',100,3,68),(190,'admin','2024-04-16 12:33:21.346000','admin','2024-04-16 16:26:29.105000',750000,'ACTIVE',100,1,69),(191,'admin','2024-04-16 12:33:21.348000','admin','2024-04-16 16:26:29.105000',850000,'ACTIVE',100,2,69),(192,'admin','2024-04-16 12:33:21.349000','admin','2024-04-16 16:26:29.105000',750000,'ACTIVE',100,3,69),(193,'admin','2024-04-16 12:33:26.596000','admin','2024-04-16 16:26:29.105000',1050000,'ACTIVE',100,1,70),(194,'admin','2024-04-16 12:33:26.599000','admin','2024-04-16 16:26:29.105000',650000,'ACTIVE',100,2,70),(195,'admin','2024-04-16 12:33:26.601000','admin','2024-04-16 16:26:29.105000',300000,'ACTIVE',100,3,70),(196,'admin','2024-04-16 12:33:32.576000','admin','2024-04-16 16:26:29.105000',800000,'ACTIVE',100,1,71),(197,'admin','2024-04-16 12:33:32.577000','admin','2024-04-16 16:26:29.105000',1000000,'ACTIVE',100,2,71),(198,'admin','2024-04-16 12:33:32.579000','admin','2024-04-16 16:26:29.105000',1200000,'ACTIVE',100,3,71),(199,'admin','2024-04-16 12:33:38.018000','admin','2024-04-16 16:26:29.105000',350000,'ACTIVE',100,1,72),(200,'admin','2024-04-16 12:33:38.020000','admin','2024-04-16 16:26:29.106000',300000,'ACTIVE',100,2,72),(201,'admin','2024-04-16 12:33:38.022000','admin','2024-04-16 16:26:29.106000',500000,'ACTIVE',100,3,72),(202,'admin','2024-04-16 12:33:43.533000','admin','2024-04-16 16:26:29.106000',650000,'ACTIVE',100,1,73),(203,'admin','2024-04-16 12:33:43.534000','admin','2024-04-16 16:26:29.106000',1000000,'ACTIVE',100,2,73),(204,'admin','2024-04-16 12:33:43.535000','admin','2024-04-16 16:26:29.106000',950000,'ACTIVE',100,3,73),(205,'admin','2024-04-16 12:33:49.296000','admin','2024-04-16 16:26:29.106000',100000,'ACTIVE',100,1,74),(206,'admin','2024-04-16 12:33:49.297000','admin','2024-04-16 16:26:29.106000',600000,'ACTIVE',100,2,74),(207,'admin','2024-04-16 12:33:49.298000','admin','2024-04-16 16:26:29.106000',400000,'ACTIVE',100,3,74),(208,'admin','2024-04-16 12:33:53.964000','admin','2024-04-16 16:26:29.106000',650000,'ACTIVE',100,1,75),(209,'admin','2024-04-16 12:33:53.966000','admin','2024-04-16 16:26:29.106000',1200000,'ACTIVE',100,2,75),(210,'admin','2024-04-16 12:33:53.968000','admin','2024-04-16 16:26:29.106000',250000,'ACTIVE',100,3,75),(211,'admin','2024-04-16 12:33:59.162000','admin','2024-04-16 16:26:29.107000',1100000,'ACTIVE',100,1,76),(212,'admin','2024-04-16 12:33:59.165000','admin','2024-04-16 16:26:29.107000',900000,'ACTIVE',100,2,76),(213,'admin','2024-04-16 12:33:59.166000','admin','2024-04-16 16:26:29.107000',400000,'ACTIVE',100,3,76),(214,'admin','2024-04-16 12:40:30.785000','admin','2024-04-16 16:26:29.107000',550000,'ACTIVE',100,1,77),(215,'admin','2024-04-16 12:40:30.787000','admin','2024-04-16 16:26:29.107000',750000,'ACTIVE',100,2,77),(216,'admin','2024-04-16 12:40:30.789000','admin','2024-04-16 16:26:29.107000',700000,'ACTIVE',100,3,77),(217,'admin','2024-04-16 12:40:35.796000','admin','2024-04-16 16:26:29.107000',1100000,'ACTIVE',100,1,78),(218,'admin','2024-04-16 12:40:35.797000','admin','2024-04-16 16:26:29.107000',400000,'ACTIVE',100,2,78),(219,'admin','2024-04-16 12:40:35.799000','admin','2024-04-16 16:26:29.107000',900000,'ACTIVE',100,3,78),(220,'admin','2024-04-16 12:40:38.598000','admin','2024-04-16 16:26:29.107000',550000,'ACTIVE',100,1,79),(221,'admin','2024-04-16 12:40:38.599000','admin','2024-04-16 16:26:29.108000',1000000,'ACTIVE',100,2,79),(222,'admin','2024-04-16 12:40:38.600000','admin','2024-04-16 16:26:29.108000',650000,'ACTIVE',100,3,79),(223,'admin','2024-04-16 12:40:45.001000','admin','2024-04-16 16:26:29.108000',650000,'ACTIVE',100,1,80),(224,'admin','2024-04-16 12:40:45.002000','admin','2024-04-16 16:26:29.108000',500000,'ACTIVE',100,2,80),(225,'admin','2024-04-16 12:40:45.003000','admin','2024-04-16 16:26:29.108000',650000,'ACTIVE',100,3,80),(226,'admin','2024-04-16 12:40:49.865000','admin','2024-04-16 16:26:29.108000',1200000,'ACTIVE',100,1,81),(227,'admin','2024-04-16 12:40:49.867000','admin','2024-04-16 16:26:29.108000',850000,'ACTIVE',100,2,81),(228,'admin','2024-04-16 12:40:49.868000','admin','2024-04-16 16:26:29.108000',900000,'ACTIVE',100,3,81),(229,'admin','2024-04-16 12:40:54.854000','admin','2024-04-16 16:26:29.108000',800000,'ACTIVE',100,1,82),(230,'admin','2024-04-16 12:40:54.855000','admin','2024-04-16 16:26:29.109000',350000,'ACTIVE',100,2,82),(231,'admin','2024-04-16 12:40:54.856000','admin','2024-04-16 16:26:29.109000',1150000,'ACTIVE',100,3,82),(232,'admin','2024-04-16 12:40:58.958000','admin','2024-04-16 16:26:29.109000',600000,'ACTIVE',100,1,83),(233,'admin','2024-04-16 12:40:58.960000','admin','2024-04-16 16:26:29.109000',100000,'ACTIVE',100,2,83),(234,'admin','2024-04-16 12:40:58.962000','admin','2024-04-16 16:26:29.109000',1000000,'ACTIVE',100,3,83),(235,'admin','2024-04-16 12:41:03.700000','admin','2024-04-16 16:26:29.110000',650000,'ACTIVE',100,1,84),(236,'admin','2024-04-16 12:41:03.703000','admin','2024-04-16 16:26:29.110000',850000,'ACTIVE',100,2,84),(237,'admin','2024-04-16 12:41:03.705000','admin','2024-04-16 16:26:29.110000',900000,'ACTIVE',100,3,84),(238,'admin','2024-04-16 12:41:11.288000','admin','2024-04-16 16:26:29.110000',400000,'ACTIVE',100,1,85),(239,'admin','2024-04-16 12:41:11.290000','admin','2024-04-16 16:26:29.110000',250000,'ACTIVE',100,2,85),(240,'admin','2024-04-16 12:41:11.291000','admin','2024-04-16 16:26:29.110000',850000,'ACTIVE',100,3,85),(241,'admin','2024-04-16 12:41:15.886000','admin','2024-04-16 16:26:29.110000',100000,'ACTIVE',100,1,86),(242,'admin','2024-04-16 12:41:15.888000','admin','2024-04-16 16:26:29.110000',500000,'ACTIVE',100,2,86),(243,'admin','2024-04-16 12:41:15.890000','admin','2024-04-16 16:26:29.110000',1100000,'ACTIVE',100,3,86),(244,'admin','2024-04-16 12:41:21.972000','admin','2024-04-16 16:26:29.111000',950000,'ACTIVE',100,1,87),(245,'admin','2024-04-16 12:41:21.974000','admin','2024-04-16 16:26:29.111000',150000,'ACTIVE',100,2,87),(246,'admin','2024-04-16 12:41:21.976000','admin','2024-04-16 16:26:29.111000',400000,'ACTIVE',100,3,87),(247,'admin','2024-04-16 12:41:26.328000','admin','2024-04-16 16:26:29.111000',700000,'ACTIVE',100,1,88),(248,'admin','2024-04-16 12:41:26.334000','admin','2024-04-16 16:26:29.111000',800000,'ACTIVE',100,2,88),(249,'admin','2024-04-16 12:41:26.337000','admin','2024-04-16 16:26:29.111000',700000,'ACTIVE',100,3,88),(250,'admin','2024-04-16 12:41:30.327000','admin','2024-04-16 16:26:29.111000',750000,'ACTIVE',100,1,89),(251,'admin','2024-04-16 12:41:30.328000','admin','2024-04-16 16:26:29.111000',700000,'ACTIVE',100,2,89),(252,'admin','2024-04-16 12:41:30.329000','admin','2024-04-16 16:26:29.111000',950000,'ACTIVE',100,3,89),(253,'admin','2024-04-16 12:59:09.830000','admin','2024-04-16 16:26:29.111000',650000,'ACTIVE',100,1,90),(254,'admin','2024-04-16 12:59:09.832000','admin','2024-04-16 16:26:29.111000',950000,'ACTIVE',100,2,90),(255,'admin','2024-04-16 12:59:09.834000','admin','2024-04-16 16:26:29.111000',900000,'ACTIVE',100,3,90),(256,'admin','2024-04-16 12:59:15.413000','admin','2024-04-16 16:26:29.112000',1000000,'ACTIVE',100,1,91),(257,'admin','2024-04-16 12:59:15.416000','admin','2024-04-16 16:26:29.112000',1200000,'ACTIVE',100,2,91),(258,'admin','2024-04-16 12:59:15.417000','admin','2024-04-16 16:26:29.112000',600000,'ACTIVE',100,3,91),(259,'admin','2024-04-16 12:59:23.048000','admin','2024-04-16 16:26:29.112000',100000,'ACTIVE',100,1,92),(260,'admin','2024-04-16 12:59:23.050000','admin','2024-04-16 16:26:29.112000',550000,'ACTIVE',100,2,92),(261,'admin','2024-04-16 12:59:23.051000','admin','2024-04-16 16:26:29.112000',1000000,'ACTIVE',100,3,92),(262,'admin','2024-04-16 12:59:58.856000','admin','2024-04-16 16:26:29.112000',250000,'ACTIVE',100,1,93),(263,'admin','2024-04-16 12:59:58.859000','admin','2024-04-16 16:26:29.112000',750000,'ACTIVE',100,2,93),(264,'admin','2024-04-16 12:59:58.860000','admin','2024-04-16 16:26:29.112000',150000,'ACTIVE',100,3,93),(265,'admin','2024-04-16 13:00:06.296000','admin','2024-04-16 16:26:29.112000',600000,'ACTIVE',100,1,94),(266,'admin','2024-04-16 13:00:06.298000','admin','2024-04-16 16:26:29.112000',1100000,'ACTIVE',100,2,94),(267,'admin','2024-04-16 13:00:06.300000','admin','2024-04-16 16:26:29.112000',300000,'ACTIVE',100,3,94),(268,'admin','2024-04-16 13:00:16.856000','admin','2024-04-16 16:26:29.113000',250000,'ACTIVE',100,1,95),(269,'admin','2024-04-16 13:00:16.861000','admin','2024-04-16 16:26:29.113000',200000,'ACTIVE',100,2,95),(270,'admin','2024-04-16 13:00:16.864000','admin','2024-04-16 16:26:29.113000',750000,'ACTIVE',100,3,95),(271,'admin','2024-04-16 13:00:21.611000','admin','2024-04-16 16:26:29.113000',200000,'ACTIVE',100,1,96),(272,'admin','2024-04-16 13:00:21.613000','admin','2024-04-16 16:26:29.113000',950000,'ACTIVE',100,2,96),(273,'admin','2024-04-16 13:00:21.614000','admin','2024-04-16 16:26:29.113000',1050000,'ACTIVE',100,3,96),(274,'admin','2024-04-16 13:00:28.350000','admin','2024-04-16 16:26:29.113000',200000,'ACTIVE',100,1,97),(275,'admin','2024-04-16 13:00:28.351000','admin','2024-04-16 16:26:29.113000',250000,'ACTIVE',100,2,97),(276,'admin','2024-04-16 13:00:28.352000','admin','2024-04-16 16:26:29.113000',1200000,'ACTIVE',100,3,97),(277,'admin','2024-04-16 13:00:33.725000','admin','2024-04-16 16:26:29.113000',100000,'ACTIVE',100,1,98),(278,'admin','2024-04-16 13:00:33.729000','admin','2024-04-16 16:26:29.113000',400000,'ACTIVE',100,2,98),(279,'admin','2024-04-16 13:00:33.731000','admin','2024-04-16 16:26:29.113000',1050000,'ACTIVE',100,3,98),(280,'admin','2024-04-16 13:00:39.478000','admin','2024-04-16 16:26:29.114000',400000,'ACTIVE',100,1,99),(281,'admin','2024-04-16 13:00:39.482000','admin','2024-04-16 16:26:29.114000',250000,'ACTIVE',100,2,99),(282,'admin','2024-04-16 13:00:39.483000','admin','2024-04-16 16:26:29.114000',200000,'ACTIVE',100,3,99),(283,'admin','2024-04-16 13:00:44.942000','admin','2024-04-16 16:26:29.114000',750000,'ACTIVE',100,1,100),(284,'admin','2024-04-16 13:00:44.943000','admin','2024-04-16 16:26:29.114000',350000,'ACTIVE',100,2,100),(285,'admin','2024-04-16 13:00:44.944000','admin','2024-04-16 16:26:29.114000',300000,'ACTIVE',100,3,100),(286,'admin','2024-04-16 13:00:49.607000','admin','2024-04-16 16:26:29.114000',850000,'ACTIVE',100,1,101),(287,'admin','2024-04-16 13:00:49.610000','admin','2024-04-16 16:26:29.114000',400000,'ACTIVE',100,2,101),(288,'admin','2024-04-16 13:00:49.611000','admin','2024-04-16 16:26:29.114000',1150000,'ACTIVE',100,3,101),(289,'admin','2024-04-16 13:13:24.078000','admin','2024-04-16 16:26:29.114000',500000,'ACTIVE',100,1,102),(290,'admin','2024-04-16 13:13:24.079000','admin','2024-04-16 16:26:29.115000',650000,'ACTIVE',100,2,102),(291,'admin','2024-04-16 13:13:24.081000','admin','2024-04-16 16:26:29.115000',250000,'ACTIVE',100,3,102),(292,'admin','2024-04-16 13:13:28.259000','admin','2024-04-16 16:26:29.115000',1150000,'ACTIVE',100,1,103),(293,'admin','2024-04-16 13:13:28.260000','admin','2024-04-16 16:26:29.115000',650000,'ACTIVE',100,2,103),(294,'admin','2024-04-16 13:13:28.261000','admin','2024-04-16 16:26:29.115000',1100000,'ACTIVE',100,3,103),(295,'admin','2024-04-16 13:13:32.528000','admin','2024-04-16 16:26:29.115000',400000,'ACTIVE',100,1,104),(296,'admin','2024-04-16 13:13:32.530000','admin','2024-04-16 16:26:29.115000',950000,'ACTIVE',100,2,104),(297,'admin','2024-04-16 13:13:32.532000','admin','2024-04-16 16:26:29.115000',1200000,'ACTIVE',100,3,104),(298,'admin','2024-04-16 13:13:36.705000','admin','2024-04-16 16:26:29.115000',500000,'ACTIVE',100,1,105),(299,'admin','2024-04-16 13:13:36.707000','admin','2024-04-16 16:26:29.116000',600000,'ACTIVE',100,2,105),(300,'admin','2024-04-16 13:13:36.708000','admin','2024-04-16 16:26:29.116000',100000,'ACTIVE',100,3,105),(301,'admin','2024-04-16 13:13:40.872000','admin','2024-04-16 16:26:29.116000',450000,'ACTIVE',100,1,106),(302,'admin','2024-04-16 13:13:40.874000','admin','2024-04-16 16:26:29.116000',800000,'ACTIVE',100,2,106),(303,'admin','2024-04-16 13:13:40.875000','admin','2024-04-16 16:26:29.116000',250000,'ACTIVE',100,3,106),(304,'admin','2024-04-16 13:13:46.601000','admin','2024-04-16 16:26:29.116000',250000,'ACTIVE',100,1,107),(305,'admin','2024-04-16 13:13:46.603000','admin','2024-04-16 16:26:29.117000',100000,'ACTIVE',100,2,107),(306,'admin','2024-04-16 13:13:46.604000','admin','2024-04-16 16:26:29.117000',550000,'ACTIVE',100,3,107),(307,'admin','2024-04-16 13:13:50.777000','admin','2024-04-16 16:26:29.117000',300000,'ACTIVE',100,1,108),(308,'admin','2024-04-16 13:13:50.778000','admin','2024-04-16 16:26:29.118000',1000000,'ACTIVE',100,2,108),(309,'admin','2024-04-16 13:13:50.779000','admin','2024-04-16 16:26:29.118000',800000,'ACTIVE',100,3,108),(310,'admin','2024-04-16 13:13:55.022000','admin','2024-04-16 16:26:29.118000',500000,'ACTIVE',100,1,109),(311,'admin','2024-04-16 13:13:55.024000','admin','2024-04-16 16:26:29.118000',650000,'ACTIVE',100,2,109),(312,'admin','2024-04-16 13:13:55.026000','admin','2024-04-16 16:26:29.118000',500000,'ACTIVE',100,3,109),(313,'admin','2024-04-16 13:13:59.109000','admin','2024-04-16 16:26:29.118000',1100000,'ACTIVE',100,1,110),(314,'admin','2024-04-16 13:13:59.111000','admin','2024-04-16 16:26:29.118000',1100000,'ACTIVE',100,2,110),(315,'admin','2024-04-16 13:13:59.111000','admin','2024-04-16 16:26:29.118000',900000,'ACTIVE',100,3,110),(316,'admin','2024-04-16 13:14:04.712000','admin','2024-04-16 16:26:29.119000',800000,'ACTIVE',100,1,111),(317,'admin','2024-04-16 13:14:04.713000','admin','2024-04-16 16:26:29.119000',400000,'ACTIVE',100,2,111),(318,'admin','2024-04-16 13:14:04.714000','admin','2024-04-16 16:26:29.119000',650000,'ACTIVE',100,3,111),(319,'admin','2024-04-16 13:14:11.633000','admin','2024-04-16 16:26:29.119000',950000,'ACTIVE',100,1,112),(320,'admin','2024-04-16 13:14:11.637000','admin','2024-04-16 16:26:29.119000',100000,'ACTIVE',100,2,112),(321,'admin','2024-04-16 13:14:11.638000','admin','2024-04-16 16:26:29.119000',800000,'ACTIVE',100,3,112),(322,'admin','2024-04-16 13:14:16.477000','admin','2024-04-16 16:26:29.119000',900000,'ACTIVE',100,1,113),(323,'admin','2024-04-16 13:14:16.479000','admin','2024-04-16 16:26:29.119000',1200000,'ACTIVE',100,2,113),(324,'admin','2024-04-16 13:14:16.480000','admin','2024-04-16 16:26:29.119000',1200000,'ACTIVE',100,3,113),(325,'admin','2024-04-16 13:14:28.977000','admin','2024-04-16 16:26:29.119000',750000,'ACTIVE',100,1,114),(326,'admin','2024-04-16 13:14:28.978000','admin','2024-04-16 16:26:29.119000',500000,'ACTIVE',100,2,114),(327,'admin','2024-04-16 13:14:28.979000','admin','2024-04-16 16:26:29.120000',800000,'ACTIVE',100,3,114),(328,'admin','2024-04-16 13:14:33.064000','admin','2024-04-16 16:26:29.120000',350000,'ACTIVE',100,1,115),(329,'admin','2024-04-16 13:14:33.065000','admin','2024-04-16 16:26:29.120000',300000,'ACTIVE',100,2,115),(330,'admin','2024-04-16 13:14:33.068000','admin','2024-04-16 16:26:29.120000',650000,'ACTIVE',100,3,115),(331,'admin','2024-04-16 13:14:37.630000','admin','2024-04-16 16:26:29.120000',200000,'ACTIVE',100,1,116),(332,'admin','2024-04-16 13:14:37.632000','admin','2024-04-16 16:26:29.120000',1000000,'ACTIVE',100,2,116),(333,'admin','2024-04-16 13:14:37.632000','admin','2024-04-16 16:26:29.120000',100000,'ACTIVE',100,3,116),(334,'admin','2024-04-16 13:14:42.147000','admin','2024-04-16 16:26:29.120000',1000000,'ACTIVE',100,1,117),(335,'admin','2024-04-16 13:14:42.148000','admin','2024-04-16 16:26:29.120000',1150000,'ACTIVE',100,2,117),(336,'admin','2024-04-16 13:14:42.149000','admin','2024-04-16 16:26:29.120000',500000,'ACTIVE',100,3,117),(337,'admin','2024-04-16 13:14:46.477000','admin','2024-04-16 16:26:29.120000',700000,'ACTIVE',100,1,118),(338,'admin','2024-04-16 13:14:46.478000','admin','2024-04-16 16:26:29.120000',600000,'ACTIVE',100,2,118),(339,'admin','2024-04-16 13:14:46.479000','admin','2024-04-16 16:26:29.120000',800000,'ACTIVE',100,3,118),(340,'admin','2024-04-16 13:14:50.305000','admin','2024-04-16 16:26:29.121000',1050000,'ACTIVE',100,1,119),(341,'admin','2024-04-16 13:14:50.308000','admin','2024-04-16 16:26:29.121000',800000,'ACTIVE',100,2,119),(342,'admin','2024-04-16 13:14:50.309000','admin','2024-04-16 16:26:29.121000',1000000,'ACTIVE',100,3,119),(343,'admin','2024-04-16 13:14:54.363000','admin','2024-04-16 16:26:29.121000',550000,'ACTIVE',100,1,120),(344,'admin','2024-04-16 13:14:54.364000','admin','2024-04-16 16:26:29.121000',1050000,'ACTIVE',100,2,120),(345,'admin','2024-04-16 13:14:54.365000','admin','2024-04-16 16:26:29.121000',250000,'ACTIVE',100,3,120),(346,'admin','2024-04-16 13:14:58.233000','admin','2024-04-16 16:26:29.121000',600000,'ACTIVE',100,1,121),(347,'admin','2024-04-16 13:14:58.236000','admin','2024-04-16 16:26:29.121000',650000,'ACTIVE',100,2,121),(348,'admin','2024-04-16 13:14:58.237000','admin','2024-04-16 16:26:29.121000',1100000,'ACTIVE',100,3,121),(349,'admin','2024-04-16 13:15:02.032000','admin','2024-04-16 16:26:29.122000',950000,'ACTIVE',100,1,122),(350,'admin','2024-04-16 13:15:02.034000','admin','2024-04-16 16:26:29.122000',1000000,'ACTIVE',100,2,122),(351,'admin','2024-04-16 13:15:02.035000','admin','2024-04-16 16:26:29.122000',500000,'ACTIVE',100,3,122),(352,'admin','2024-04-16 13:15:06.256000','admin','2024-04-16 16:26:29.122000',850000,'ACTIVE',100,1,123),(353,'admin','2024-04-16 13:15:06.257000','admin','2024-04-16 16:26:29.122000',850000,'ACTIVE',100,2,123),(354,'admin','2024-04-16 13:15:06.259000','admin','2024-04-16 16:26:29.122000',1150000,'ACTIVE',100,3,123),(355,'admin','2024-04-16 13:15:10.034000','admin','2024-04-16 16:26:29.122000',500000,'ACTIVE',100,1,124),(356,'admin','2024-04-16 13:15:10.035000','admin','2024-04-16 16:26:29.122000',900000,'ACTIVE',100,2,124),(357,'admin','2024-04-16 13:15:10.036000','admin','2024-04-16 16:26:29.122000',400000,'ACTIVE',100,3,124),(358,'admin','2024-04-16 13:15:13.927000','admin','2024-04-16 16:26:29.122000',100000,'ACTIVE',100,1,125),(359,'admin','2024-04-16 13:15:13.928000','admin','2024-04-16 16:26:29.122000',1150000,'ACTIVE',100,2,125),(360,'admin','2024-04-16 13:15:13.929000','admin','2024-04-16 16:26:29.122000',650000,'ACTIVE',100,3,125),(361,'admin','2024-04-16 13:18:54.477000','admin','2024-04-16 16:26:29.122000',150000,'ACTIVE',100,1,126),(362,'admin','2024-04-16 13:18:54.478000','admin','2024-04-16 16:26:29.122000',650000,'ACTIVE',100,2,126),(363,'admin','2024-04-16 13:18:54.478000','admin','2024-04-16 16:26:29.123000',850000,'ACTIVE',100,3,126),(364,'admin','2024-04-16 13:18:59.303000','admin','2024-04-16 16:26:29.123000',1150000,'ACTIVE',100,1,127),(365,'admin','2024-04-16 13:18:59.305000','admin','2024-04-16 16:26:29.123000',650000,'ACTIVE',100,2,127),(366,'admin','2024-04-16 13:18:59.307000','admin','2024-04-16 16:26:29.123000',650000,'ACTIVE',100,3,127),(367,'admin','2024-04-16 13:19:06.803000','admin','2024-04-16 16:26:29.123000',700000,'ACTIVE',100,1,128),(368,'admin','2024-04-16 13:19:06.804000','admin','2024-04-16 16:26:29.123000',250000,'ACTIVE',100,2,128),(369,'admin','2024-04-16 13:19:06.806000','admin','2024-04-16 16:26:29.123000',500000,'ACTIVE',100,3,128),(370,'admin','2024-04-16 13:19:11.597000','admin','2024-04-16 16:26:29.123000',850000,'ACTIVE',100,1,129),(371,'admin','2024-04-16 13:19:11.599000','admin','2024-04-16 16:26:29.123000',1050000,'ACTIVE',100,2,129),(372,'admin','2024-04-16 13:19:11.599000','admin','2024-04-16 16:26:29.123000',1150000,'ACTIVE',100,3,129),(373,'admin','2024-04-16 13:19:15.755000','admin','2024-04-16 16:26:29.123000',350000,'ACTIVE',100,1,130),(374,'admin','2024-04-16 13:19:15.756000','admin','2024-04-16 16:26:29.123000',900000,'ACTIVE',100,2,130),(375,'admin','2024-04-16 13:19:15.758000','admin','2024-04-16 16:26:29.123000',950000,'ACTIVE',100,3,130),(376,'admin','2024-04-16 13:19:19.717000','admin','2024-04-16 16:26:29.124000',850000,'ACTIVE',100,1,131),(377,'admin','2024-04-16 13:19:19.718000','admin','2024-04-16 16:26:29.124000',850000,'ACTIVE',100,2,131),(378,'admin','2024-04-16 13:19:19.719000','admin','2024-04-16 16:26:29.124000',1050000,'ACTIVE',100,3,131),(379,'admin','2024-04-16 13:19:23.857000','admin','2024-04-16 16:26:29.124000',300000,'ACTIVE',100,1,132),(380,'admin','2024-04-16 13:19:23.859000','admin','2024-04-16 16:26:29.124000',900000,'ACTIVE',100,2,132),(381,'admin','2024-04-16 13:19:23.860000','admin','2024-04-16 16:26:29.124000',1150000,'ACTIVE',100,3,132),(382,'admin','2024-04-16 13:19:28.253000','admin','2024-04-16 16:26:29.124000',1200000,'ACTIVE',100,1,133),(383,'admin','2024-04-16 13:19:28.254000','admin','2024-04-16 16:26:29.124000',1100000,'ACTIVE',100,2,133),(384,'admin','2024-04-16 13:19:28.255000','admin','2024-04-16 16:26:29.124000',1000000,'ACTIVE',100,3,133),(385,'admin','2024-04-16 13:19:33.048000','admin','2024-04-16 16:26:29.124000',450000,'ACTIVE',100,1,134),(386,'admin','2024-04-16 13:19:33.051000','admin','2024-04-16 16:26:29.124000',1050000,'ACTIVE',100,2,134),(387,'admin','2024-04-16 13:19:33.053000','admin','2024-04-16 16:26:29.125000',600000,'ACTIVE',100,3,134),(388,'admin','2024-04-16 13:19:38.223000','admin','2024-04-16 16:26:29.125000',1000000,'ACTIVE',100,1,135),(389,'admin','2024-04-16 13:19:38.225000','admin','2024-04-16 16:26:29.125000',250000,'ACTIVE',100,2,135),(390,'admin','2024-04-16 13:19:38.226000','admin','2024-04-16 16:26:29.125000',350000,'ACTIVE',100,3,135),(391,'admin','2024-04-16 13:19:43.909000','admin','2024-04-16 16:26:29.125000',1150000,'ACTIVE',100,1,136),(392,'admin','2024-04-16 13:19:43.911000','admin','2024-04-16 16:26:29.125000',300000,'ACTIVE',100,2,136),(393,'admin','2024-04-16 13:19:43.913000','admin','2024-04-16 16:26:29.125000',850000,'ACTIVE',100,3,136),(394,'admin','2024-04-16 13:19:49.465000','admin','2024-04-16 16:26:29.125000',900000,'ACTIVE',100,1,137),(395,'admin','2024-04-16 13:19:49.477000','admin','2024-04-16 16:26:29.125000',800000,'ACTIVE',100,2,137),(396,'admin','2024-04-16 13:19:49.485000','admin','2024-04-16 16:26:29.126000',1200000,'ACTIVE',100,3,137),(397,'admin','2024-04-16 13:23:07.410000','admin','2024-04-16 16:26:29.126000',950000,'ACTIVE',100,1,138),(398,'admin','2024-04-16 13:23:07.412000','admin','2024-04-16 16:26:29.126000',600000,'ACTIVE',100,2,138),(399,'admin','2024-04-16 13:23:07.413000','admin','2024-04-16 16:26:29.126000',800000,'ACTIVE',100,3,138),(400,'admin','2024-04-16 13:23:11.941000','admin','2024-04-16 16:26:29.126000',850000,'ACTIVE',100,1,139),(401,'admin','2024-04-16 13:23:11.942000','admin','2024-04-16 16:26:29.126000',100000,'ACTIVE',100,2,139),(402,'admin','2024-04-16 13:23:11.942000','admin','2024-04-16 16:26:29.126000',150000,'ACTIVE',100,3,139),(403,'admin','2024-04-16 13:23:15.573000','admin','2024-04-16 16:26:29.126000',450000,'ACTIVE',100,1,140),(404,'admin','2024-04-16 13:23:15.575000','admin','2024-04-16 16:26:29.126000',350000,'ACTIVE',100,2,140),(405,'admin','2024-04-16 13:23:15.576000','admin','2024-04-16 16:26:29.126000',1100000,'ACTIVE',100,3,140),(406,'admin','2024-04-16 13:23:19.644000','admin','2024-04-16 16:26:29.126000',700000,'ACTIVE',100,1,141),(407,'admin','2024-04-16 13:23:19.672000','admin','2024-04-16 16:26:29.126000',1100000,'ACTIVE',100,2,141),(408,'admin','2024-04-16 13:23:19.673000','admin','2024-04-16 16:26:29.126000',750000,'ACTIVE',100,3,141),(409,'admin','2024-04-16 13:23:24.743000','admin','2024-04-16 16:26:29.127000',100000,'ACTIVE',100,1,142),(410,'admin','2024-04-16 13:23:24.744000','admin','2024-04-16 16:26:29.127000',600000,'ACTIVE',100,2,142),(411,'admin','2024-04-16 13:23:24.744000','admin','2024-04-16 16:26:29.127000',1200000,'ACTIVE',100,3,142),(412,'admin','2024-04-16 13:23:29.623000','admin','2024-04-16 16:26:29.127000',350000,'ACTIVE',100,1,143),(413,'admin','2024-04-16 13:23:29.625000','admin','2024-04-16 16:26:29.127000',450000,'ACTIVE',100,2,143),(414,'admin','2024-04-16 13:23:29.627000','admin','2024-04-16 16:26:29.127000',500000,'ACTIVE',100,3,143),(415,'admin','2024-04-16 13:23:33.382000','admin','2024-04-16 16:26:29.127000',1050000,'ACTIVE',100,1,144),(416,'admin','2024-04-16 13:23:33.383000','admin','2024-04-16 16:26:29.127000',1100000,'ACTIVE',100,2,144),(417,'admin','2024-04-16 13:23:33.385000','admin','2024-04-16 16:26:29.127000',250000,'ACTIVE',100,3,144),(418,'admin','2024-04-16 13:23:37.404000','admin','2024-04-16 16:26:29.127000',950000,'ACTIVE',100,1,145),(419,'admin','2024-04-16 13:23:37.405000','admin','2024-04-16 16:26:29.127000',1100000,'ACTIVE',100,2,145),(420,'admin','2024-04-16 13:23:37.406000','admin','2024-04-16 16:26:29.127000',250000,'ACTIVE',100,3,145),(421,'admin','2024-04-16 13:23:41.650000','admin','2024-04-16 16:26:29.127000',900000,'ACTIVE',100,1,146),(422,'admin','2024-04-16 13:23:41.651000','admin','2024-04-16 16:26:29.127000',500000,'ACTIVE',100,2,146),(423,'admin','2024-04-16 13:23:41.652000','admin','2024-04-16 16:26:29.127000',650000,'ACTIVE',100,3,146),(424,'admin','2024-04-16 13:23:45.417000','admin','2024-04-16 16:26:29.128000',900000,'ACTIVE',100,1,147),(425,'admin','2024-04-16 13:23:45.419000','admin','2024-04-16 16:26:29.128000',1100000,'ACTIVE',100,2,147),(426,'admin','2024-04-16 13:23:45.420000','admin','2024-04-16 16:26:29.128000',950000,'ACTIVE',100,3,147),(427,'admin','2024-04-16 13:23:49.278000','admin','2024-04-18 22:35:57.867000',1200000,'COMING_SOON',100,1,148),(428,'admin','2024-04-16 13:23:49.279000','admin','2024-04-18 22:35:57.867000',400000,'COMING_SOON',100,2,148),(429,'admin','2024-04-16 13:23:49.280000','admin','2024-04-18 22:35:57.867000',900000,'COMING_SOON',100,3,148),(430,'admin','2024-04-16 13:23:53.145000','admin','2024-04-19 11:46:27.450000',2000000,'OUT_OF_STOCK',1019,1,149),(431,'admin','2024-04-16 13:23:53.146000','admin','2024-04-19 16:30:22.660000',95000,'ACTIVE',101,2,149),(432,'admin','2024-04-16 13:23:53.146000','admin','2024-04-18 22:35:56.582000',1150000,'COMING_SOON',100,3,149);
/*!40000 ALTER TABLE `facility_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mail_template`
--

DROP TABLE IF EXISTS `mail_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mail_template` (
  `id` bigint NOT NULL AUTO_INCREMENT,
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
  `id` bigint NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
INSERT INTO `order_product` VALUES (15,'customer','2024-04-17 15:05:42.232000','customer','2024-04-17 15:05:42.232000',NULL,3,350000,24,21),(16,'customer','2024-04-17 15:05:42.262000','customer','2024-04-17 15:05:42.262000',NULL,2,450000,27,21),(17,'customer','2024-04-17 15:05:42.264000','customer','2024-04-17 15:05:42.264000',NULL,2,200000,30,21);
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
  `paid` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdimvsocblb17f45ikjr6xn1wj` (`voucher_id`),
  CONSTRAINT `FKdimvsocblb17f45ikjr6xn1wj` FOREIGN KEY (`voucher_id`) REFERENCES `vouchers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (21,'customer','2024-04-17 15:05:42.177000','customer','2024-04-17 15:05:42.177000','PROCESSING',1,2250000,_binary '\0');
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
  `description` varchar(1000) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (13,'admin','2024-04-07 20:05:04.386000','admin','2024-04-19 10:57:32.532000','P_20240407080504350',NULL,'https://product.hstatic.net/1000024707/product/bang-keo-title-classic-1-inch-boxing-tape-2.0-boxing-saigon__2__36e7fd484aaf404797fdc141c52a9e0a_master.jpg','Băng Gạc TITLE Classic 1-Inch Boxing Tape 2.0',13,14,_binary ''),(14,'admin','2024-04-07 20:15:35.967000','admin','2024-04-19 10:57:32.538000','P_20240407081535965',NULL,'https://product.hstatic.net/1000024707/product/dsc03309_edit_d6cf875c2cc34d379b6140e9391161dc_master.jpg','Dây Nhảy Boxing Saigon Pvc Speed Rope',14,2,_binary ''),(15,'admin','2024-04-07 20:16:53.096000','admin','2024-04-19 10:57:32.538000','P_20240407081653095',NULL,'https://product.hstatic.net/1000024707/product/meister_elastic_hand_wrap_gauze_mexican_10pack_600x_dcb043bf4eaa401ea771be1a186f6edd_master.jpg','Băng Gạc Meister Traditional Elastic Gauze Hand Wraps - White',13,6,_binary ''),(16,'admin','2024-04-07 20:17:22.599000','admin','2024-04-19 10:57:32.538000','P_20240407081722598','abc','https://product.hstatic.net/1000024707/product/f0096422af104cf1a24f41f7b5d6d9fa_37445044e9284d81ac2ecfa87f0f3a55_master.jpg','Băng Gạc Meister Traditional Elastic Gauze Hand Wraps - Black',13,5,_binary ''),(17,'admin','2024-04-07 20:20:17.437000','admin','2024-04-19 10:57:32.539000','P_20240407082017435',NULL,'https://product.hstatic.net/1000024707/product/9210_2_1_ed4ebd7e61f740659c31b603a3ec492c_master.jpg','Băng Gạc Everlast',13,9,_binary ''),(19,'admin','2024-04-07 20:23:49.639000','admin','2024-04-19 10:57:32.539000','P_20240407082349638',NULL,'https://product.hstatic.net/1000024707/product/xit_khu_mui_efd28a6eed474fc48df1bb1390008614_master.jpg','Xịt Khử Mùi Găng Tay Nano Refresh 50ml',1,4,_binary ''),(21,'admin','2024-04-07 20:24:31.401000','admin','2024-04-07 20:24:31.499000','P_20240407082431400',NULL,'https://product.hstatic.net/1000024707/product/3a801288b0864740864e8bbcb04465b8_6bfaafe48f4b4353a217e3dbc3966bc6_master.png','Dây Nhảy Rival RJR2 Econo Jump Rope',14,1,_binary ''),(23,'admin','2024-04-07 20:24:46.207000','admin','2024-04-19 10:57:32.539000','P_20240407082446207',NULL,'https://product.hstatic.net/1000024707/product/tb2eqnrlq8lpufjy0fpxxagrpxa___1898695144_master.jpg','Dây Nhảy Cáp Tốc Độ Ver 2',14,9,_binary ''),(26,'admin','2024-04-07 20:25:09.832000','admin','2024-04-19 10:57:32.539000','P_20240407082509831',NULL,'https://product.hstatic.net/1000024707/product/form_chuan_black_logo_20e85b4a05494dfea6c13368df23245c_master.jpg','Dây Nhảy Boxing Saigon Deluxe Steel Wire Standard Speed Rope',14,7,_binary ''),(27,'admin','2024-04-07 20:25:16.756000','admin','2024-04-19 10:57:32.539000','P_20240407082516755',NULL,'https://product.hstatic.net/1000024707/product/da_chinh_sau_450af1f2bce24d968a02a7f01314e8e4_master.jpg','Khử Mùi Boxing Saigon Glove Deodorizer',1,3,_binary ''),(28,'admin','2024-04-07 20:25:25.314000','admin','2024-04-19 10:57:32.540000','P_20240407082525313',NULL,'https://hstatic.net/707/1000024707/1/2016/4-11/p00000383_master.jpg','Dây Nhảy Everlast Speed Rope',14,14,_binary ''),(30,'admin','2024-04-07 20:25:40.286000','admin','2024-04-19 10:57:32.540000','P_20240407082540285',NULL,'https://product.hstatic.net/1000024707/product/red_cap_logo_f954c7768614489c90f237e53f2c8a4e_master.jpg','Dây Nhảy Boxing Saigon Deluxe Steel Wire Slim Speed Rope',14,10,_binary ''),(33,'admin','2024-04-07 20:26:44.888000','admin','2024-04-19 10:57:32.540000','P_20240407082644888',NULL,'https://product.hstatic.net/1000024707/product/002002002-7922_ff3d66e287044f528e825f326d8827bb_master.jpg','Khử Mùi Machomai Glove Deodorizer',1,8,_binary ''),(34,'admin','2024-04-07 20:27:00.496000','admin','2024-04-19 10:57:32.540000','P_20240407082700493',NULL,'https://product.hstatic.net/1000024707/product/o1cn01qwadw41fu6vwlruee___987430546-0-cib_91ca545c4ec44133ae39c11a0014f95c_master.jpg','Dây Nhảy Bn Deluxe Jump Rope',14,10,_binary ''),(35,'admin','2024-04-07 20:27:12.759000','admin','2024-04-07 20:27:12.813000','P_20240407082712758',NULL,'https://product.hstatic.net/1000024707/product/day-nhay-twins-sr2-bred-boxing-saigon__3__logo_609f7c3fcbdc4cbcbe396840731f0ca3_master.jpg','Xịt Khử Mùi TITLE Odor-Aid Disinfectant Spray',1,1,_binary ''),(36,'admin','2024-04-07 20:27:21.645000','admin','2024-04-19 10:57:32.541000','P_20240407082721645',NULL,'https://product.hstatic.net/1000024707/product/66aafd3970084b279902d1836530f014_711bd283f7e042d794da2f84f9893cca_master.jpg','Đích Đấm Bn Punch Mitts',12,10,_binary ''),(38,'admin','2024-04-07 20:27:57.275000','admin','2024-04-19 10:57:32.541000','P_20240407082757274',NULL,'https://product.hstatic.net/1000024707/product/mongkol-handmade-sitmonchai_1_3dee8017cba341b19153378d1885f421_master.jpg','Đích Đấm Boxing Saigon Speed Mitts - White',12,12,_binary ''),(39,'admin','2024-04-07 20:28:03.592000','admin','2024-04-19 10:57:32.541000','P_20240407082803592',NULL,'https://product.hstatic.net/1000024707/product/dsc00268_combo_0f17149e12974ec4ac188a8f87b980f0_master.jpg','Đích Đấm BN C-01 Focus Pad',12,4,_binary ''),(41,'admin','2024-04-07 20:28:19.438000','admin','2024-04-19 10:57:32.541000','P_20240407082819437',NULL,'https://product.hstatic.net/1000024707/product/everlast_interval_training_round_timer_ee1d1843a22c48099f33690174b304fe_master.jpg','Đích Đấm Tốc Độ BN Mike\'S Land Focus Pad Mini',12,11,_binary ''),(42,'admin','2024-04-07 20:28:26.424000','admin','2024-04-19 10:57:32.541000','P_20240407082826415',NULL,'https://product.hstatic.net/1000024707/product/0fc43675a4cb403fb39cbf070ea6a066_187ea0bd1f90465584de2d6be90bac44_master.jpg','Dây Nhảy Venum Competitor Weighted Jump Rope',14,3,_binary ''),(43,'admin','2024-04-07 20:28:33.387000','admin','2024-04-19 10:57:32.542000','P_20240407082833387',NULL,'https://hstatic.net/707/1000024707/1/2016/8-26/corde_a_sauter_competitor_red_620_01_1_3_master.jpg','Đích Đấm Tròn Bn Big Size 2020',12,12,_binary ''),(44,'admin','2024-04-07 20:28:39.500000','admin','2024-04-19 10:57:32.542000','P_20240407082839500',NULL,'https://product.hstatic.net/1000024707/product/11752932643_478717145_08f90c702aa546ed9ff3fb06fb002e88_master.jpg','Đích Đấm Đá BN Focus Mitts',12,9,_binary ''),(45,'admin','2024-04-07 20:28:46.381000','admin','2024-04-19 10:57:32.542000','P_20240407082846380','','https://product.hstatic.net/1000024707/product/1-logo_937cb4515cf14b13b8e8c83e69b0affa_master.jpg','Đích Đấm Everlast Elite 2 Punch Mitts - Black/Gold',12,9,_binary ''),(46,'admin','2024-04-07 20:28:53.477000','admin','2024-04-19 10:57:32.542000','P_20240407082853476','a','https://product.hstatic.net/1000024707/product/eliteminimitts_black_pdp_370ad19fe320456b9b775b14513516ed_master.jpg','Đích Đấm Đùi Gà Windy WBP Boxing Paddles',12,13,_binary ''),(47,'admin','2024-04-16 11:53:59.557000','admin','2024-04-19 10:57:32.543000','P_20240416115359535',NULL,'https://product.hstatic.net/1000024707/product/dsc06898_grey_daf809fe01db4813a2399f982e39337a_master.jpg','Túi Rút Boxing Saigon 2022 New Logo',2,7,_binary ''),(48,'admin','2024-04-16 11:54:09.179000','admin','2024-04-19 10:57:32.543000','P_20240416115409178','\"Nhẹ và cực kỳ tiện lợi để mạng theo khi đi tập - Vải polyester bền và chống thấm nước nhẹ - Kích thước : 45cm x 37cm - Phần dây đeo chắc chắn và bền - Với khoang bên trong rộng, có thể đựng vừa găng tới size 16oz mà không lo tới việc bị chật túi\n  - \"','https://product.hstatic.net/1000024707/product/dsc06898_ngang_7656d96b7f3245698bb34020b100c434_master.jpg','Túi Rút Đựng Găng Boxing Saigon 2.0',2,9,_binary ''),(49,'admin','2024-04-16 11:54:18.499000','admin','2024-04-19 10:57:32.543000','P_20240416115418498','\"Chất liệu vải dày, có khả năng chống nước nhẹ. - Dây đeo vai được làm bằng chất liệu dây dù chắc chắn và siêu bền, khó hư hỏng - Khoang túi bên trong rộng rãi có thể đựng được những vật dụng cá nhân, tư trang khi đi tập gym. - Kích thước : 47cm - Thiết kế đẹp mắt chắc chắn sẽ đem lại độ \"\" ngầu \"\" và \"\" tự tin \"\" dành cho bạn khi bước vào phòng tập.\n  - \"','https://product.hstatic.net/1000024707/product/tui-boxing-saigon-duffle-bag-black__7_edit_fcd2d74615874284b937954cef6c9ed8_master.jpg','Túi Trống Boxing Saigon - Black',2,9,_binary ''),(50,'admin','2024-04-16 11:54:30.080000','admin','2024-04-19 10:57:32.544000','P_20240416115430043','\"95% Cotton, 5% Elastane. - Được in 3 lớp. - Chất lượng tốt. - Khuyến nghị giặt ở 30 °. - Sản xuất tại Việt Nam\n. - \"','https://product.hstatic.net/1000024707/product/1_ed066f3ecabe4dad891e98f412e6fdf6_master.jpg','Áo Boxing NBD T-Shirt',2,12,_binary ''),(51,'admin','2024-04-16 11:54:39.989000','admin','2024-04-19 10:57:32.544000','P_20240416115439988','Chất liệu: Vải mè 4 chiều (95% polyester - 5% spandex). - Áo được sản xuất theo phong cách quốc tế với vai áo rộng hơn giúp giữ an toàn và không bị xê dịch khi vận động. - Quần short với đai thun có kích thước tiêu chuẩn 7cm. - Logo Boxing Saigon được in decal bền bỉ. - Hai dải bên với biểu tượng Boxing Saigon chính là điểm nhấn. - Bộ quần áo này linh hoạt với mọi môn thể thao nhờ chất liệu vải nhẹ và thoáng khí. - ','https://product.hstatic.net/1000024707/product/z3829984097193_e8b77237f1910c1bcef7410207b5116f_editv2_88446089bf70476cbb614fdf5f4600aa_master.jpg','Đồ Tập Luyện Boxing Saigon Elite - White',2,8,_binary ''),(52,'admin','2024-04-16 11:54:49.134000','admin','2024-04-19 10:57:32.544000','P_20240416115449132','Chất liệu: Vải mè 4 chiều (95% polyester - 5% spandex). - Áo được sản xuất theo phong cách quốc tế với vai áo rộng hơn giúp giữ an toàn và không bị xê dịch khi vận động. - Quần short với đai thun có kích thước tiêu chuẩn 7cm. - Logo Boxing Saigon được in decal bền bỉ. - Hai dải bên với biểu tượng Boxing Saigon chính là điểm nhấn. - Bộ quần áo này linh hoạt với mọi môn thể thao nhờ chất liệu vải nhẹ và thoáng khí. - ','https://product.hstatic.net/1000024707/product/green_ad38da72036340adb10e7ed133292c5b_master.jpg','Đồ Tập Luyện Boxing Saigon Elite - Olive',2,7,_binary ''),(53,'admin','2024-04-16 11:55:00.415000','admin','2024-04-19 10:57:32.545000','P_20240416115500414','\"Chất liệu: Vải mè 4 chiều (95% polyester - 5% spandex). - Áo được sản xuất theo phong cách quốc tế với vai áo rộng hơn giúp giữ an toàn và không bị xê dịch khi vận động. - Quần short với đai thun có kích thước tiêu chuẩn 7cm. - Logo Boxing Saigon được in decal bền bỉ. - Hai dải bên với biểu tượng Boxing Saigon chính là điểm nhấn. - Bộ quần áo này linh hoạt với mọi môn thể thao nhờ chất liệu vải nhẹ và thoáng khí.\n  - \"','https://product.hstatic.net/1000024707/product/grey_color_8f04f1dd75754221b241f07540e86d0f_master.jpg','Đồ Tập Luyện Boxing Saigon Elite - Grey',2,14,_binary ''),(54,'admin','2024-04-16 11:55:08.665000','admin','2024-04-19 10:57:32.545000','P_20240416115508664','Chất liệu: Vải mè 4 chiều (95% polyester - 5% spandex). - Áo được sản xuất theo phong cách quốc tế với vai áo rộng hơn giúp giữ an toàn và không bị xê dịch khi vận động. - Quần short với đai thun có kích thước tiêu chuẩn 7cm. - Logo Boxing Saigon được in decal bền bỉ. - Hai dải bên với biểu tượng Boxing Saigon chính là điểm nhấn. - Bộ quần áo này linh hoạt với mọi môn thể thao nhờ chất liệu vải nhẹ và thoáng khí. - ','https://product.hstatic.net/1000024707/product/blue_d71fae19a4d8462885f200c5ddcf31d6_master.jpg','Đồ Tập Luyện Boxing Saigon Elite - Navy',2,6,_binary ''),(55,'admin','2024-04-16 11:55:18.944000','admin','2024-04-19 10:57:32.545000','P_20240416115518943','Chất liệu: Vải mè 4 chiều (95% polyester - 5% spandex). - Áo được sản xuất theo phong cách quốc tế với vai áo rộng hơn giúp giữ an toàn và không bị xê dịch khi vận động. - Quần short với đai thun có kích thước tiêu chuẩn 7cm. - Logo Boxing Saigon được in decal bền bỉ. - Hai dải bên với biểu tượng Boxing Saigon chính là điểm nhấn. - Bộ quần áo này linh hoạt với mọi môn thể thao nhờ chất liệu vải nhẹ và thoáng khí. - ','https://product.hstatic.net/1000024707/product/e537fdcdda301f6e4621_update_colo_aa9f63c40cbd4f91ac287617d4b85507_master.jpg','Đồ Tập Luyện Boxing Saigon Elite - Red',2,7,_binary ''),(56,'admin','2024-04-16 11:55:26.017000','admin','2024-04-19 10:57:32.545000','P_20240416115526016','\"Chất liệu: Vải mè 4 chiều (95% polyester - 5% spandex). - Áo được sản xuất theo phong cách quốc tế với vai áo rộng hơn giúp giữ an toàn và không bị xê dịch khi vận động. - Quần short với đai thun có kích thước tiêu chuẩn 7cm. - Logo Boxing Saigon được in decal bền bỉ. - Hai dải bên với biểu tượng Boxing Saigon chính là điểm nhấn. - Bộ quần áo này linh hoạt với mọi môn thể thao nhờ chất liệu vải nhẹ và thoáng khí.\n  - \"','https://product.hstatic.net/1000024707/product/black_1_mau999_update_color1-1_5fba39594c77434799957ea5bef812bc_master.jpg','Đồ Tập Luyện Boxing Saigon Elite - Black',2,13,_binary ''),(57,'admin','2024-04-16 12:16:34.868000','admin','2024-04-19 10:57:32.545000','P_20240416121634784','','https://product.hstatic.net/1000024707/product/buffalo_kids_silver_4a9fb0df003c4a47a1955db467886282_master.jpg','Găng Tay Trẻ Em Buffalo',3,13,_binary ''),(58,'admin','2024-04-16 12:18:14.927000','admin','2024-04-19 10:57:32.545000','P_20240416121814926','Loại sản phẩm: Găng tay tập boxing. - Chất liệu da tổng hợp - Bảo vệ khớp ngón tay trong quá trình luyện tập. - Công nghệ lưới thông gió sử dụng để giữ bàn tay mát mẻ và khô thoáng. - Cung cấp độ ẩm thấm hút cũng như bảo vệ kháng khuẩn để găng tay khô thoáng và có độ bền cao hơn.','https://product.hstatic.net/1000024707/product/boxing_sg2391_edit_820c38186ccb4bd9bbcad002ce5b5dfe_master.jpg','Găng Tay Boxing Saigon Inspire - White/Red',3,4,_binary ''),(59,'admin','2024-04-16 12:22:42.034000','admin','2024-04-19 10:57:32.546000','P_20240416122242033','Loại sản phẩm: Găng tay tập boxing. - Chất liệu da tổng hợp - Bảo vệ khớp ngón tay trong quá trình luyện tập. - Công nghệ lưới thông gió sử dụng để giữ bàn tay mát mẻ và khô thoáng. - Cung cấp độ ẩm thấm hút cũng như bảo vệ kháng khuẩn để găng tay khô thoáng và có độ bền cao hơn.','https://product.hstatic.net/1000024707/product/dsc00233_noel_7f915d1aa40d47f5a333a50d547e86d1_master.jpg','Găng Tay Boxing Saigon Inspire - Flag Of Mexico',3,14,_binary ''),(60,'admin','2024-04-16 12:23:00.430000','admin','2024-04-19 10:57:32.546000','P_20240416122300429','Loại sản phẩm: Găng tay tập boxing. - Chất liệu da tổng hợp - Bảo vệ khớp ngón tay trong quá trình luyện tập. - Công nghệ lưới thông gió sử dụng để giữ bàn tay mát mẻ và khô thoáng. - Cung cấp độ ẩm thấm hút cũng như bảo vệ kháng khuẩn để găng tay khô thoáng và có độ bền cao hơn','https://product.hstatic.net/1000024707/product/boxing_sg2388_edit_6752a04804ab413398e3c8b96fc24146_master.jpg','Găng Tay Boxing Saigon Inspire - Blue',3,14,_binary ''),(61,'admin','2024-04-16 12:23:11.016000','admin','2024-04-19 10:57:32.546000','P_20240416122311015','Loại sản phẩm: Găng tay tập boxing. - Chất liệu da tổng hợp - Bảo vệ khớp ngón tay trong quá trình luyện tập. - Công nghệ lưới thông gió sử dụng để giữ bàn tay mát mẻ và khô thoáng. - Cung cấp độ ẩm thấm hút cũng như bảo vệ kháng khuẩn để găng tay khô thoáng và có độ bền cao hơn','https://product.hstatic.net/1000024707/product/boxing_sg1359_edit_98e112e276f04f2692253a486187b173_master.jpg','Găng Tay Boxing Saigon Inspire - Red',3,7,_binary ''),(62,'admin','2024-04-16 12:23:16.570000','admin','2024-04-19 10:57:32.546000','P_20240416122316569','Loại sản phẩm: Găng tay tập boxing. - Chất liệu da tổng hợp - Bảo vệ khớp ngón tay trong quá trình luyện tập. - Công nghệ lưới thông gió sử dụng để giữ bàn tay mát mẻ và khô thoáng. - Cung cấp độ ẩm thấm hút cũng như bảo vệ kháng khuẩn để găng tay khô thoáng và có độ bền cao hơn','https://product.hstatic.net/1000024707/product/dsc08704_edit2_704f635a825a408e9b1c0a9738a0f24b_master.jpg','Găng Tay Boxing Saigon Inspire - Pink',3,3,_binary ''),(63,'admin','2024-04-16 12:23:22.851000','admin','2024-04-19 10:57:32.546000','P_20240416122322850','Loại sản phẩm: Găng tay tập boxing. - Chất liệu da tổng hợp - Bảo vệ khớp ngón tay trong quá trình luyện tập. - Công nghệ lưới thông gió sử dụng để giữ bàn tay mát mẻ và khô thoáng. - Cung cấp độ ẩm thấm hút cũng như bảo vệ kháng khuẩn để găng tay khô thoáng và có độ bền cao hơn','https://product.hstatic.net/1000024707/product/boxing_sg0318_edit_15d4e9e5f7e14c52b87761c48c911a1d_master.jpg','Găng Tay Boxing Saigon Inspire - Yellow',3,13,_binary ''),(64,'admin','2024-04-16 12:23:33.271000','admin','2024-04-19 10:57:32.546000','P_20240416122333271','Loại sản phẩm: Găng tay tập boxing. - Chất liệu da tổng hợp - Bảo vệ khớp ngón tay trong quá trình luyện tập. - Công nghệ lưới thông gió sử dụng để giữ bàn tay mát mẻ và khô thoáng. - Cung cấp độ ẩm thấm hút cũng như bảo vệ kháng khuẩn để găng tay khô thoáng và có độ bền cao hơn.','https://product.hstatic.net/1000024707/product/boxing_sg1348_edit_482bddeb17a14d3e87e8de4db21608b6_master.jpg','Găng Tay Boxing Saigon Inspire - Khaki',3,3,_binary ''),(65,'admin','2024-04-16 12:23:41.922000','admin','2024-04-19 10:57:32.547000','P_20240416122341921','Loại sản phẩm: Găng tay tập boxing. - Chất liệu da tổng hợp - Bảo vệ khớp ngón tay trong quá trình luyện tập. - Công nghệ lưới thông gió sử dụng để giữ bàn tay mát mẻ và khô thoáng. - Cung cấp độ ẩm thấm hút cũng như bảo vệ kháng khuẩn để găng tay khô thoáng và có độ bền cao hơn.','https://product.hstatic.net/1000024707/product/boxing_sg7187_edit_601657d3494b44f9aeff9c2993a6148b_master.jpg','Găng Tay Boxing Saigon Inspire - Black/Red',3,8,_binary ''),(66,'admin','2024-04-16 12:23:47.699000','admin','2024-04-19 10:57:32.547000','P_20240416122347695','Loại sản phẩm: Găng tay tập boxing. - Chất liệu da tổng hợp - Bảo vệ khớp ngón tay trong quá trình luyện tập. - Công nghệ lưới thông gió sử dụng để giữ bàn tay mát mẻ và khô thoáng. - Cung cấp độ ẩm thấm hút cũng như bảo vệ kháng khuẩn để găng tay khô thoáng và có độ bền cao hơn.','https://product.hstatic.net/1000024707/product/boxing_sg3427_edit_91eef19fb9994ca68117b818c4764fe2_master.jpg','Găng Tay Boxing Saigon Inspire - Black/Gold',3,14,_binary ''),(67,'admin','2024-04-16 12:33:09.474000','admin','2024-04-19 10:57:32.547000','P_20240416123309473','','https://product.hstatic.net/1000024707/product/4dfd0faa470745718f367808f98022cc_00b69e89a7b64cdf8b2bfdb126063dd5_master.jpeg','Bảo Hộ Răng Trong Suốt Double Mouthguard',4,14,_binary ''),(68,'admin','2024-04-16 12:33:15.997000','admin','2024-04-19 10:57:32.547000','P_20240416123315996','','https://hstatic.net/707/1000024707/1/2016/7-27/tb2e.qjspxxxxcoxxxxxxxxxxxx___2800822905__1__master.jpg','Bảo Hộ Răng Răng Dẻo',4,14,_binary ''),(69,'admin','2024-04-16 12:33:21.197000','admin','2024-04-19 10:57:32.547000','P_20240416123321194','','https://product.hstatic.net/1000024707/product/bao_ho_rang_80_6c5dc30b26c74bc18509d04bacda1715_master.jpg','Bảo Hộ Răng Gel 1.0 Có Hộp',4,5,_binary ''),(70,'admin','2024-04-16 12:33:26.546000','admin','2024-04-19 10:57:32.547000','P_20240416123326545','','https://product.hstatic.net/1000024707/product/black_logo_39330112e00a43d6b20b86abb676a008_master.jpg','Băng Tay No-Brand 4m5',4,3,_binary ''),(71,'admin','2024-04-16 12:33:32.522000','admin','2024-04-19 10:57:32.547000','P_20240416123332521','','https://product.hstatic.net/1000024707/product/dracula_01_2b3a69af64cc49288be9448bbe06c414_master.png','Bảo Hộ Răng Dracula',4,8,_binary ''),(72,'admin','2024-04-16 12:33:37.968000','admin','2024-04-19 10:57:32.548000','P_20240416123337967','Chất lượng vải thun co giãn 100% đem lại cảm giác dễ chịu và thoải mái cho người sử dụng - Bảo vệ các khớp tay và cổ tay trong quá trình tập luyện - Chiều dài : 4m5 - Băng dán cổ tay bản lớn được thiết kế theo phong cách Mexican - Thấm hút tốt và hạn chế những mùi hôi ở găng tay sau khi tập luyện và giúp kéo dài tuổi thọ cho găng của bạn','https://product.hstatic.net/1000024707/product/1_edit_50baa5e43ab940e5a2127aeeb249be1c_master.jpg','Băng Quấn Tay Boxing Saigon 1.0',4,8,_binary ''),(73,'admin','2024-04-16 12:33:43.398000','admin','2024-04-19 10:57:32.548000','P_20240416123343397','Vải Tigris: Sự pha trộn hoàn hảo giữa độ co giãn, chắc chắn và thoải mái sẽ đem đến cho người tiêu dùng một sự hài lòng tuyệt đối. - Độ dài tiêu chuẩn 4.5m: Cho một sự bảo vệ tuyệt vời. - Băng dán Tigris chắc chắn theo phong cách Mexican luôn giữ cho dây quấn nằm ở vị trí cố định để hỗ trợ cổ tay và giảm thiểu những chấn thương có thể xảy ra. - Đường may được khâu kỹ lưỡng giúp cho sản phẩm có tuổi thọ lâu hơn.','https://product.hstatic.net/1000024707/product/4_edit_ecc364fc822a406190b8b57b0528a40d_master.jpg','Băng Quấn Tay Tigris - Brown',4,8,_binary ''),(74,'admin','2024-04-16 12:33:49.255000','admin','2024-04-16 12:33:49.255000','P_20240416123349254','Vải Tigris: Sự pha trộn hoàn hảo giữa độ co giãn, chắc chắn và thoải mái sẽ đem đến cho người tiêu dùng một sự hài lòng tuyệt đối. - Độ dài tiêu chuẩn 4.5m: Cho một sự bảo vệ tuyệt vời. - Băng dán Tigris chắc chắn theo phong cách Mexican luôn giữ cho dây quấn nằm ở vị trí cố định để hỗ trợ cổ tay và giảm thiểu những chấn thương có thể xảy ra. - Đường may được khâu kỹ lưỡng giúp cho sản phẩm có tuổi thọ lâu hơn.','https://product.hstatic.net/1000024707/product/1_edit_22a11b0565d84f778af59b119adea03d_master.jpg','Băng Quấn Tay Tigris - Maroon Red',4,1,_binary ''),(75,'admin','2024-04-16 12:33:53.913000','admin','2024-04-19 10:57:32.548000','P_20240416123353913','Vải Tigris: Sự pha trộn hoàn hảo giữa độ co giãn, chắc chắn và thoải mái sẽ đem đến cho người tiêu dùng một sự hài lòng tuyệt đối. - Độ dài tiêu chuẩn 4.5m: Cho một sự bảo vệ tuyệt vời. - Băng dán Tigris chắc chắn theo phong cách Mexican luôn giữ cho dây quấn nằm ở vị trí cố định để hỗ trợ cổ tay và giảm thiểu những chấn thương có thể xảy ra. - Đường may được khâu kỹ lưỡng giúp cho sản phẩm có tuổi thọ lâu hơn.','https://product.hstatic.net/1000024707/product/3_edit_0b8d5218fa1042d1a7afa2fa01560e89_master.jpg','Băng Quấn Tay Tigris - Red',4,8,_binary ''),(76,'admin','2024-04-16 12:33:59.111000','admin','2024-04-19 10:57:32.548000','P_20240416123359110','Vải thun co giãn ít đem lại cảm giác dễ chịu - Bảo vệ các khớp tay và cổ tay trong quá trình tập luyện - Chiều dài : 4m5 - Logo được in nổi (3D) đem lại sự sang trọng và đẹp mắt - Băng dán cổ tay bản lớn được thiết kế theo phong cách Mexican - Thấm hút tốt và hạn chế những mùi hôi ở găng tay sau khi tập luyện và giúp kéo dài tuổi thọ cho găng của bạn','https://product.hstatic.net/1000024707/product/full_boxing_saigon_809537b4afce41b4a936ca67facfbdde_master.jpg','Băng Quấn Tay Boxing Saigon 2.0',4,8,_binary ''),(77,'admin','2024-04-16 12:40:30.731000','admin','2024-04-19 10:57:32.549000','P_20240416124030720','Amino Acid Capsule or Powder for Muscle Development* - 2:1:1 BCAA Ratio to Reduce Muscle Breakdown and Support Lean Mass* - Supported Goal: Build Muscle - Main Ingredient: BCAAs','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/my-protein-bcaa-1kg-200servings-berry-blast-gymstore.jpg?v=1639125275873','MyProtein BCAA, 1000 g (200 servings)',6,8,_binary ''),(78,'admin','2024-04-16 12:40:35.745000','admin','2024-04-19 10:57:32.549000','P_20240416124035744','7G BCAA - Tỷ lệ 2:1:1. Hỗ trợ phục hồi và xây dựng cơ bắp tối ưu - 0 Carbs, 0 Calo, 0 đường - 2.5G L-Glutamine giúp giảm đau nhức - 1G Citrulline Malate giúp bơm phồng cơ - Bổ sung điện giải - Hương vị cực kỳ thơm ngon','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/s9.jpg?v=1695781644183','Scivation Xtend BCAA Original, 30 Servings',6,7,_binary ''),(79,'admin','2024-04-16 12:40:38.553000','admin','2024-04-19 10:57:32.549000','P_20240416124038552','7G BCAA - Tỷ lệ 2:1:1. Hỗ trợ phục hồi và xây dựng cơ bắp tối ưu - 0 Carbs, 0 Calo, 0 đường - 2.5G L-Glutamine giúp giảm đau nhức - 1G Citrulline Malate giúp bơm phồng cơ - Bổ sung điện giải - Hương vị cực kỳ thơm ngon','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/s9.jpg?v=1695781644183','Scivation Xtend BCAA Original, 30 Servings',6,12,_binary ''),(80,'admin','2024-04-16 12:40:44.953000','admin','2024-04-19 10:57:32.549000','P_20240416124044952','7G BCAA - Tỷ lệ 2:1:1. Hỗ trợ phục hồi và xây dựng cơ bắp tối ưu - 0 Carbs, 0 Calo, 0 đường - 2.5G L-Glutamine giúp giảm đau nhức - 1G Citrulline Malate giúp bơm phồng cơ - Bổ sung điện giải - Hương vị cực kỳ thơm ngon','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/t11.jpg?v=1695783018820','Scivation Xtend BCAA Original, 90 Servings',6,9,_binary ''),(81,'admin','2024-04-16 12:40:49.792000','admin','2024-04-19 10:57:32.549000','P_20240416124049791','5G BCAA  - 1G CLA MATRIX  - Phục hồi cơ bắp - Kiểm soát mỡ thừa - Vị ngon dễ uống - Tăng sức bền - Giảm Cholesterol xấu trong máu  - Kết hợp BCAA & CLA đem lại hiệu quả giảm mỡ hiệu quả  - Lưu ý sản phẩm có thể bị vón cục do điều kiện thời tiết nhưng chất lượng sản phẩm vẫn đảm bảo bởi Gymstore.','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/bpi-sports-best-bcaa-30-servings-watermelon-ice-gymstore.jpg?v=1647331120877','BPI Best BCAA, 30 Servings',6,9,_binary ''),(82,'admin','2024-04-16 12:40:54.811000','admin','2024-04-19 10:57:32.549000','P_20240416124054810','Micronized Glutamine siêu tinh khiết  - 5G Glutamine  - Phục hồi cơ bắp - Kích thích tổng hợp protein cơ bắp - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/muscletech-glutamine-gymstore.jpg?v=1680506807833','MuscleTech Platinum 100% Glutamine, 300g Unflavored',6,5,_binary ''),(83,'admin','2024-04-16 12:40:58.916000','admin','2024-04-19 10:57:32.549000','P_20240416124058915','6 công thức nâng cao của Glutamine - Thúc đẩy phục hồi cơ bắp sau tập - Hỗ trợ bổ sung Glycogen - Tăng tổng hợp protein - Phát triển cơ bắp nạc - Nâng cao sức đề kháng của cơ thể - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/bpi-sports-best-glutamine-450g-peach-mango-gymstore.jpg?v=1641198567570','BPI Sports Best Glutamine, 450 gam (50 servings)',6,14,_binary ''),(84,'admin','2024-04-16 12:41:03.644000','admin','2024-04-19 10:57:32.550000','P_20240416124103643','175mg Caffeine - 1.5G Beta-Alanine - 3G Creatine Monohydrate - 1.5G L-Citrulline Malate - Thúc đẩy năng lượng - Tăng sức mạnh, sức bền - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/on-gold-standard-pre-workout-30-serving-blueberry-lemonade-tang-suc-manh-gymstore.jpg?v=1640166048313','ON Gold Standard Pre-Workout, 30 Servings',6,10,_binary ''),(85,'admin','2024-04-16 12:41:11.237000','admin','2024-04-19 10:57:32.550000','P_20240416124111237','Caffeine - Beta-Alanine - Creatine Nitrate (NO3) - Arginine AKG - Methylcobalamin : Là Vitamin B12 ở trạng thái mạnh. Hỗ trợ chuyển hóa tế bào - N-Acetyl-L-Tyrosine - Hương vị thơm ngon và đa dạng cho người sử dụng lựa chọn với mức giá tốt.','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/cellucor-icy-blue-razz-30-serving-pre-workout-tang-suc-manh-gymstore.jpg?v=1640165719397','Cellucor C4 OriginaI, 30 Servings',6,4,_binary ''),(86,'admin','2024-04-16 12:41:15.839000','admin','2024-04-19 10:57:32.550000','P_20240416124115838','3g Creatine Monohydrate  - 1,8g Beta - Alanine  - 275mg Caffeine - Đa dạng các vitamin và khoáng chất điện giải - Hương vị thơm ngon - Bùng nổ năng lượng - Tăng sức mạnh, sức bền - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/bsn-no-xplode-60-servings-green-apple-jpeg.jpg?v=1686725568243','BSN N.O.-Xplode, 60 Servings',6,7,_binary ''),(87,'admin','2024-04-16 12:41:21.834000','admin','2024-04-19 10:57:32.550000','P_20240416124121833','3g Creatine Monohydrate  - 1,8g Beta - Alanine  - 275mg Caffeine - Đa dạng các vitamin và khoáng chất điện giải - Hương vị thơm ngon - Bùng nổ năng lượng - Tăng sức mạnh, sức bền - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/bsn-no-xplode-30-servings-fruit-punch.jpg?v=1685587934780','BSN N.O.-Xplode, 30 Servings',6,6,_binary ''),(88,'admin','2024-04-16 12:41:26.256000','admin','2024-04-19 10:57:32.550000','P_20240416124126255','Tăng sức bền, sức chịu đựng - Giảm mệt mỏi cơ bắp - Thúc đẩy lưu thông máu - Tỉnh táo, hưng phấn hơn khi tập luyện - Không gây chóng mặt, buồn nôn - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/pre-workout-the-curse-50-serving-blue-raspberry-tang-suc-manh-gymstore.jpg?v=1640165893957','Cobra Labs The Curse, 50 Servings',6,12,_binary ''),(89,'admin','2024-04-16 12:41:30.275000','admin','2024-04-19 10:57:32.551000','P_20240416124130274','Pre Workout Amplifier! - With Agmatine Sulfate! - Supported Goal: Improve Workout - Main Ingredient: Beta-Alanine - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/metabolic-nutrition-e-s-p-pre-workout-90-servings-fruit-punch.jpg?v=1640165958687','Metabolic Nutrition E.S.P Pre-Workout, 90 servings',6,10,_binary ''),(90,'admin','2024-04-16 12:59:09.688000','admin','2024-04-19 10:57:32.551000','P_20240416125909681','Chiết xuất từ 6 loại thảo mộc thiên nhiên - Bổ sung enzyme và 2 tỷ lợi khuẩn - Giúp thanh lọc cơ thể, đào thải độc tố hiệu quả - Nhuận tràng, giảm đầy hơi, khó tiêu - Giảm mức cholesterol và lipid máu - Tăng cường trao đổi chất - Giảm tích tụ mỡ thừa - Hiệu quả nhanh, an toàn, lành tính - 0 chất cấm, 0 chất kích thích - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/nutrex-lipo-6-black-cleanse-detox-gymstore-jpeg.jpg?v=1706165351637','Nutrex Lipo 6 Black Cleanse & Detox, 60 Capsules',7,12,_binary ''),(91,'admin','2024-04-16 12:59:15.363000','admin','2024-04-19 10:57:32.551000','P_20240416125915363','Tăng sinh nhiệt, hỗ trợ đốt mỡ liên tục kể cả lúc tập luyện hay nghỉ ngơi - Kích thích chuyển hóa chất béo thành năng lượng - Giảm thèm ăn. Giảm lượng calo hấp thụ từ thức ăn - Tăng trao đổi chất - Không ảnh hưởng đến khối lượng cơ bắp - Không chứa caffeine hay chất cấm - Không gây mệt mỏi, bồn chồn, đau đầu hay ảnh hưởng đến tim mạch, thần kinh - Phù hợp cho cả nam và nữ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/glaxon-thermal-non-stim-thermo-naked-ho-tro-dot-mo-jpeg.jpg?v=1698142763057','Glaxon Thermal Non-Stim Thermo, 21 Serving',7,5,_binary ''),(92,'admin','2024-04-16 12:59:22.997000','admin','2024-04-19 10:57:32.551000','P_20240416125922997','1000mg CLA/viên - Thúc đẩy chuyển hóa mỡ thành năng lượng - Phá vỡ liên kết giữa các axit béo, ngăn tích tụ mỡ thừa - Hỗ trợ giảm mỡ, siết cơ, cắt nét - Không gây mệt mỏi, đau đầu hay chóng mặt.  - Không gây phụ thuộc sản phẩm - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/ostrovit-cla-1000-jpeg.jpg?v=1708490722177','OstroVit CLA 1000mg',7,10,_binary ''),(93,'admin','2024-04-16 12:59:58.739000','admin','2024-04-19 10:57:32.551000','P_20240416125958738','3000mg L-Carnitine Matrix - Không đường, không calo - Tăng cường chuyển hóa chất béo - Tăng sức bền và hiệu suất tập luyện - Hỗ trợ chức năng não bộ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/2023-09-07-02-43-46-mpinp4wxpv-jpeg.jpg?v=1694687435200','Repp Sports Raze L-Carnitine 3000mg Liquid, 31 Serving',7,13,_binary ''),(94,'admin','2024-04-16 13:00:06.159000','admin','2024-04-19 10:57:32.552000','P_20240416010006158','100% Organic chuẩn USDA - 16mg caffeine trong 1g - Chuẩn Matcha Nhật - Gần như không Carb & Calo - Có vị đắng nhẹ và hậu vị ngọt - Pha uống, làm bánh, đắp mặt  - Hỗ trợ giảm cân tốt hơn - Giàu chất chống oxy hóa - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/now-organic-matcha-jpeg.jpg?v=1689657424973','NOW Real Tea, Organic Matcha Green Tea Powder (85g) - 85 Servings',7,13,_binary ''),(95,'admin','2024-04-16 13:00:16.792000','admin','2024-04-19 10:57:32.552000','P_20240416010016791','1250mg CLA  - Tăng sinh nhiệt, tăng tốc độ trao đổi chất - Hỗ trợ chuyển hóa mỡ thừa thành năng lượng - Giảm tích tụ chất béo trong cơ thể - Kích thích phát triển cơ bắp nạc - Ổn định đường huyết trong máu - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/pvl-isolated-cla-1250mg-180-softgels-gymstore.jpg?v=1664860606833','PVL Isolated CLA 1250mg, 180 Softgels',7,2,_binary ''),(96,'admin','2024-04-16 13:00:21.560000','admin','2024-04-19 10:57:32.552000','P_20240416010021559','3mg Yohimbine HCl + Bổ sung Rauwolscine - Hỗ trợ giảm cân, đốt mỡ - Ngăn chặn thèm ăn - Cải thiện lưu thông máu - Tăng mức năng lượng, sức bền - Tăng cường sinh lực cho phái mạnh - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/allmax-yohimbine-rauwolscine-60-capsules-gymstore.jpg?v=1664868734167','AllMax Yohimbine + Rauwolscine, 60 Capsules',7,4,_binary ''),(97,'admin','2024-04-16 13:00:28.299000','admin','2024-04-19 10:57:32.552000','P_20240416010028298','CLA - axit linoleic liên hợp - Chiết xuất lá trà xanh (Green Tea) - L-Carnitine - 18 mg Caffeine - Tăng sinh nhiệt, tăng tốc độ trao đổi chất - Hỗ trợ chuyển hóa mỡ thừa thành năng lượng - Giảm kích thước của các tế bào mỡ - Kích thích phát triển cơ bắp nạc - Ngăn chặn sự tích mỡ của cơ thể - Giảm thèm ăn, giúp kiểm soát calo tốt hơn - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/ostrovit-cla-green-tea-l-carnitine-90-capsules-gymstore.jpg?v=1662705816990','Ostrovit CLA + Greentea + L-carnitine, 90 Capsules',7,13,_binary ''),(98,'admin','2024-04-16 13:00:33.620000','admin','2024-04-19 10:57:32.552000','P_20240416010033619','1000 mg L-Carnitine Tartrate - Tăng sinh nhiệt, tăng tốc độ trao đổi chất - Hỗ trợ chuyển hóa mỡ thừa thành năng lượng - Giảm kích thước của các tế bào mỡ - Kích thích phát triển cơ bắp nạc - Ngăn chặn sự tích mỡ của cơ thể - Giảm thèm ăn, giúp kiểm soát calo tốt hơn - Ổn định đường huyết (glucose) trong máu','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/ostrovit-l-carnitine-1000mg-90-tablets-gymstore.jpg?v=1662709870970','Ostrovit L-Carnitine 1000mg, 90 Tablets',7,6,_binary ''),(99,'admin','2024-04-16 13:00:39.427000','admin','2024-04-19 10:57:32.553000','P_20240416010039426','9mg Yohimbine (từ 450mg chiết xuất vỏ cây Yohimbe) - KHÔNG caffeine - Hỗ trợ giảm béo, giảm mỡ - Tăng mức năng lượng - Tăng sức bền, hiệu suất tập luyện - Tăng lưu thông máu - Cải thiện sinh lực nam giới','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/nutricost-yohimbine-bark-extract-9mg-120-servings-gymstore.png?v=1660277172970','Nutricost Yohimbine Bark Extract 9mg, 120 Capsules',7,6,_binary ''),(100,'admin','2024-04-16 13:00:44.892000','admin','2024-04-19 10:57:32.553000','P_20240416010044892','500mg Acetyl L-Carnitine - Tăng cường chuyển hóa chất béo - Gia tăng lượng calo tiêu thụ - Tăng phục hồi cơ bắp sau tập - Hỗ trợ trí não','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/nutricost-acetyl-l-carnitine-500mg-180-capsules-gymstore.png?v=1659156692200','Nutricost Acetyl L-Carnitine 500mg',7,7,_binary ''),(101,'admin','2024-04-16 13:00:49.559000','admin','2024-04-19 10:57:32.553000','P_20240416010049558','Hỗ trợ đốt mỡ, giảm tích tụ mỡ trong cơ thể - Tăng tỷ lệ cơ bắp - Thúc đẩy trao đổi chất - An toàn, 0 chất kích thích, 0 mất ngủ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/25.jpg?v=1657851131163','USN CLA 800mg, 90 Softgels',7,8,_binary ''),(102,'admin','2024-04-16 13:13:24.061000','admin','2024-04-19 10:57:32.553000','P_20240416011324021','42g Protein - Whey Isolate & Whey Concentrate  - 75g Carb - Nguồn tinh bột chất lượng cao từ yến mạch hữu cơ và Maltodextrin - Creatine, L-leucine, L-glutamine, HMB và HICA - Hỗ trợ xây dựng và phục hồi cơ bắp toàn diện - CLA - Chuyển hóa chất béo thành năng lượng, hạn chế tích mỡ - 5 loại Enzymes - Hỗ trợ tiêu hóa và hấp thu - Phù hợp cho người không dung nạp lactose','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/applied-critical-mass-chocolate-6kg-sua-tang-can-gymtore-jpeg.jpg?v=1691577529900','Sữa Tăng Cân Applied Nutrition Critical Mass, 6KG (40 Servings)',8,5,_binary ''),(103,'admin','2024-04-16 13:13:28.170000','admin','2024-04-19 10:57:32.553000','P_20240416011328170','1000 Calories - 60g Protein xây dựng phát triển cơ nạc - 174G Carb chất lượng cao - 5g Creatine Monohydradate - 5G BCAA - 100 mg Enzyme Lactase','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/elite-labs-usa-mass-muscle-gainer-cookies-cream-20-lbs-sua-tang-can-gymstore-jpeg.jpg?v=1691578717260','Elite Labs USA Mass Muscle Gainer, 20 Lbs (9.07 kg)',8,3,_binary ''),(104,'admin','2024-04-16 13:13:32.437000','admin','2024-04-19 10:57:32.553000','P_20240416011332436','438 kcal - 54g Carbohydrate - 48g Protein  - 3600mg Taurine  - 1872mg DAA - 1800mg HMB  - 1800mg Creatine Monohydrate - 1200mg L-Arginine - 360mg Fenugreek Extract (Chiết xuất cỏ ca ri)','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/anh4-62d11c56-601b-4536-bc6e-ed5198973e90.jpg?v=1638325453150','Kevin Levrone Anabolic Mass, 7.0 Kg (58 Servings)',8,12,_binary ''),(105,'admin','2024-04-16 13:13:36.651000','admin','2024-04-19 10:57:32.554000','P_20240416011336650','1250 calo - 55g protein - 252g carb - Tăng cân nhanh, hỗ trợ tăng cơ nạc - Hương vị thơm ngon','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/usn-anabolic-mass-gymstore-1.jpg?v=1662454724897','USN Anabolic Mass, 12 Lbs (5.44 KG)',8,12,_binary ''),(106,'admin','2024-04-16 13:13:40.823000','admin','2024-04-19 10:57:32.554000','P_20240416011340823','676 calories - 70G Protein - 72G Carb - 10G Creatine - Tribulus terretris - DAA - Chiết xuất Fenugreek (Cỏ cà ri) - Tăng cân, tăng cơ nạc - Tăng cường sức mạnh nam giới','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/kevin-levrone-gold-lean-mass-6kg-sua-tang-can-gymstore-jpeg.jpg?v=1691633193217','Kevin Levrone GOLD Lean Mass, 6 KG (30 Servings)',8,4,_binary ''),(107,'admin','2024-04-16 13:13:46.510000','admin','2024-04-19 10:57:32.554000','P_20240416011346510','438 kcal - 54g Carbohydrate - 48g Protein  - 3600mg Taurine  - 1872mg DAA - 1800mg HMB  - 1800mg Creatine Monohydrate - 1200mg L-Arginine - 360mg Fenugreek Extract (Chiết xuất cỏ cà ri)','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/kevin-levrone-anabolic-mass-3-kg-gymstore.jpg?v=1655522280920','Kevin Levrone Anabolic Mass, 3 Kg (30 Servings)',8,14,_binary ''),(108,'admin','2024-04-16 13:13:50.610000','admin','2024-04-19 10:57:32.554000','P_20240416011350609','1250 calo - 55g protein - 252g carb - Tăng cân nhanh, hỗ trợ tăng cơ nạc - Hương vị thơm ngon','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/usn-anabolic-mass-6lbs.jpg?v=1662454714197','USN Anabolic Mass, 6 Lbs (2.72 KG)',8,11,_binary ''),(109,'admin','2024-04-16 13:13:54.928000','admin','2024-04-19 10:57:32.554000','P_20240416011354928','1000 Calories - 60g Protein xây dựng phát triển cơ nạc - 174G Carb chất lượng cao - 5g Creatine Monohydradate - 5G BCAA - 100 mg Enzyme Lactase','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/elite-lab-usa-mass-muscle-gainer-10lbs-double-rich-chocolate-gymstore.jpg?v=1638758573997','Elite Labs USA Mass Muscle Gainer, 10 Lbs (4.6 KG)',8,11,_binary ''),(110,'admin','2024-04-16 13:13:59.023000','admin','2024-04-19 10:57:32.554000','P_20240416011359022','55g Protein  - 154g Carbohydrate - 8.4g Fat - Bổ sung axit béo thiết yếu (EFA’s), đốt mỡ CLA & MCT - Lượng Calo, protein và carbohydrate cao trong mỗi lần dùng - Tinh bột từ ngô sáp - Bỗ sung L-Glutamine - Sản phẩm được chứng nhận Halal','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/applied-critical-mass-original-chocolate-6kg-sua-tang-can-gymstore-jpeg.jpg?v=1691633547817','Applied Critical Mass Original, 6KG (25 Servings)',8,3,_binary ''),(111,'admin','2024-04-16 13:14:04.624000','admin','2024-04-19 10:57:32.555000','P_20240416011404624','1100 calo  - 56G Protein, 192G Carb chất lượng cao, 12G Fat - 26.1G EAA, 12.2G BCAA - Axit béo thiết yếu (EFAs) - Dầu tự nhiên từ dừa, bơ, hạt lanh, hạt bí ngô và hướng dương  - Tinh bột từ lúa mạch, khoai lang, yến mạch','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/mutant-mass-triple-chocolate-15lbs-sua-tang-can-gymstore-jpeg.jpg?v=1691632024267','Mutant Mass 15 Lbs (6.8 kg)',8,7,_binary ''),(112,'admin','2024-04-16 13:14:11.583000','admin','2024-04-19 10:57:32.555000','P_20240416011411582','1350 calo giúp tăng cân nhanh, hiệu quả - 70g protein hỗ trợ xây dựng cơ nạc - Thành phần đột phá GlycoPush giúp hạn chế tích mỡ  - 20 vitamin và khoáng chất thiết yếu - 6g chất béo tốt CLA, MCT - Bổ sung BCAA, creatine và enzyme tiêu hóa - Có hiệu quả với cả người gầy kinh niên','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/vitaxtrong-mega-mass-pro-chocolate-12lbs-900x900.jpg?v=1692611352193','VitaXtrong Mega Mass Pro 1350, 12 Lbs (5.4 Kg)',8,7,_binary ''),(113,'admin','2024-04-16 13:14:16.389000','admin','2024-04-16 13:14:16.389000','P_20240416011416388','1030 Calories - 60g Protein tăng cơ nạc chất lượng - Tỷ lệ Carb : Protein là 3:1 - Lượng đường cực thấp - Cung cấp chất béo tốt - 10 loại Vitamin & Khoáng chất - Không Lactose và Gluten - ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/b1.jpg?v=1675313728320','Perfect Sport HULK Clean Mass Gainer, 10 Lbs (4.54KG)',8,1,_binary ''),(114,'admin','2024-04-16 13:14:28.888000','admin','2024-04-19 10:57:32.555000','P_20240416011428887','100mg Beta-1,3/1,6-D-Glucan - 160mg Maitake Mushroom - Tăng cường hệ miễn dịch - Chống Oxy hóa - Bảo vệ da - Hỗ trợ sức khỏe tim mạch - Hỗ trợ tiêu hóa - Kiểm soát đường huyết - Hỗ trợ giảm cân','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/now-beta-1-3-1-6-d-glucan-90-veg-capsule-gymstore-jpeg.jpg?v=1712083825273','Now Beta - 1,3/1,6-D-Glucan 100mg, 90 Veg Capsules',9,9,_binary ''),(115,'admin','2024-04-16 13:14:32.970000','admin','2024-04-19 10:57:32.555000','P_20240416011432968','4.5g sụn cá mập đông khô tinh khiết  - 1g canxi  - Bảo vệ và tái tạo sụn khớp  - Hạn chế khô khớp, bào mòn sụn khớp - Phòng ngừa thoái hóa khớp  - Giúp xương khớp linh hoạt hơn','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/now-shark-cartilage-100-capsules-gymstore-jpeg.jpg?v=1710493270000','Now Shark Cartilage 750mg, 100 Capsules',9,6,_binary ''),(116,'admin','2024-04-16 13:14:37.497000','admin','2024-04-19 10:57:32.556000','P_20240416011437496','Tăng cường sức khỏe thận - Hỗ trợ chức năng tiết niệu - Thúc đẩy đào thải độc tố, muối và vi trùng - Duy trì sự cân bằng chất lỏng trong cơ thể - Thân thiện với người ăn chay - Đạt tiêu chuẩn Halal, Kosher, Intertek GMP','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/now-kidney-cleanse-90-veg-capsules-gymstore.jpg?v=1710306543997','Now Kidney Cleanse, 90 Veg Capsules',9,5,_binary ''),(117,'admin','2024-04-16 13:14:42.058000','admin','2024-04-19 10:57:32.556000','P_20240416011442058','600mg EPA, 300mg DHA mỗi viên - Bổ sung 100mg CoQ10 tăng cường sức khỏe tim mạch - Không dư vị, không ợ tanh - Hấp thu tốt hơn  - Hỗ trợ chức năng não - Cải thiện tâm trạng','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/webber-naturals-omega-3-coq10-80-softgel-gymstore.jpg?v=1708600927303','Webber Naturals Triple Strength Omega-3 with CoQ10 900mg',9,12,_binary ''),(118,'admin','2024-04-16 13:14:46.427000','admin','2024-04-19 10:57:32.556000','P_20240416011446427','600mg EPA, 300mg DHA - Đạt tiêu chuẩn IVO về độ tinh khiết, hiệu lực và tính bền vững - Dạng Triglyceride dễ hấp thu - Không gây ợ tanh, không để lại dư vị - Hỗ trợ sức khỏe tim mạch, não bộ và thị lực - Giảm viêm, giảm cholesterol - Hỗ trợ phục hồi nhanh hơn sau tập luyện','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/webber-naturals-triple-strength-omega-3-120-sofgels-gymstore.png?v=1708687014297','Webber Naturals Triple Strength Omega-3 900mg',9,7,_binary ''),(119,'admin','2024-04-16 13:14:50.212000','admin','2024-04-19 10:57:32.556000','P_20240416011450212','500mg dầu nhuyễn thể Nam Cực  - 120mg Omega 3 - 200mg Phospholipid - 150mcg Astaxanthin tự nhiên  - Tăng cường sức khỏe tim mạch  - Giảm mỡ máu - Tốt cho não bộ và đôi mắt  - Chống lão hóa, đẹp da','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/kirkland-krill-oil-500mg-160-softgels-gymstore.jpg?v=1708758909703','Dầu nhuyễn thể Kirkland Signature Krill Oil 500mg, 160 Softgels',9,7,_binary ''),(120,'admin','2024-04-16 13:14:54.271000','admin','2024-04-16 13:14:54.271000','P_20240416011454271','Omega 3 tinh khiết từ dầu tảo - 1 viên chứa 210mg DHA và 105mg EPA - Phù hợp cho người ăn chay hoặc bị dị ứng với cá - Không gây ợ tanh hay để lại dư vị - Hỗ trợ sức khỏe tim mạch, não bộ và thị lực - Giảm viêm, giảm cholesterol - Hỗ trợ phục hồi nhanh hơn sau tập luyện - Vỏ viên nang làm từ bột sắn - Không chứa gluten, non GMO','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/sports-research-vegan-omega-3-gymstore-900x900-jpeg.jpg?v=1709639209663','Dầu tảo Sports Research Vegan Omega-3, 60 Veggie Softgels',9,1,_binary ''),(121,'admin','2024-04-16 13:14:58.182000','admin','2024-04-19 10:57:32.557000','P_20240416011458180','Dầu cá đạt 5 sao IFOS - 690mg EPA, 260mg DHA 1 lần dùng  - Không dư vị, không ợ tanh - Dạng bào chế dễ hấp thu  - Tinh khiết không tạp chất - Tăng cường sức khỏe tim mạch','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/sports-research-omega-3-90-softgels-gymstore-jpeg.jpg?v=1708513072703','Sports Research Omega-3 Fish Oil | Triple Strength',9,8,_binary ''),(122,'admin','2024-04-16 13:15:01.937000','admin','2024-04-19 10:57:32.557000','P_20240416011501937','1200mg lecithin/viên - Chiết xuất từ đậu nành không biến đổi gen - Bổ sung dưỡng chất cho não bộ - Giảm cholesterol máu - Hỗ trợ sức khoẻ tim mạch và đường ruột - Giảm tắc tia sữa ở mẹ - Tăng cường nội tiết tố nữ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/now-lecithin-non-gmo-100-softgels-gymstore-jpeg.jpg?v=1707101487557','Now Lecithin 1200mg Non GMO, 100 Softgels',9,13,_binary ''),(123,'admin','2024-04-16 13:15:06.079000','admin','2024-04-19 10:57:32.557000','P_20240416011506078','Công thức kết hợp 2 chất mạnh mẽ và toàn diện nhất cho gan, thận: 800mg TUDCA + 900mg NAC - Hỗ trợ giải độc, tăng cường chức năng gan và thận - Tăng khả năng chống oxy hóa của cơ thể - Cải thiện sức khỏe túi mật, hệ tiêu hóa, hô hấp, tim mạch và não bộ - Hạn chế nóng trong, nổi mụn - Thúc đẩy mức năng lượng  - Sản xuất trong cơ sở đạt chuẩn GMP, ISO 22000, BRC và Halal','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/applied-nutrition-tudca-nac-90-capsules-bao-ve-gan-than-gymstore-jpeg.jpg?v=1705486774290','Applied Tudca NAC, 90 Capsules',9,5,_binary ''),(124,'admin','2024-04-16 13:15:09.904000','admin','2024-04-19 10:57:32.557000','P_20240416011509904','Bổ sung Glucosamine, MSM, Chondroitin - Dễ hấp thu, hiệu quả cao - Hỗ trợ phát triển mô giữa sụn và xương - Ngăn ngừa thoái hóa sụn, bảo vệ khớp - Giúp xương khớp linh hoạt hơn','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/ostrovit-glucosamine-msm-chondroitin-90-tablet-gymstore-jpeg.jpg?v=1705306129403','Ostrovit Glucosamin + MSM + Chondrotin, 90 Tablets',9,8,_binary ''),(125,'admin','2024-04-16 13:15:13.837000','admin','2024-04-19 10:57:32.557000','P_20240416011513836','Bổ sung Biotin, kích thích mọc tóc - Giảm tình trạng rụng tóc  - Da đẹp, móng chắc khỏe - Không gluten, không biến đổi gen - Thân thiện với người ăn chay','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/now-biotin-10000mcg-gymstore-1704018449371.jpg?v=1704018469983','Viên uống hỗ trợ mọc tóc NOW Biotin',9,9,_binary ''),(126,'admin','2024-04-16 13:18:54.343000','admin','2024-04-19 10:57:32.557000','P_20240416011854341','600 mg Ashwwaggandha extract - 200mg Shilajit Extract - 200mg Boron Citrate - Tăng testos terone tự nhiên - Cải thiện hiệu suất tập luyện','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/muscletech-test-hd-thermo-90-capsules-30-servings-testosterone-gymstore-jpeg.jpg?v=1690277932043','MuscleTech TEST HD Thermo | Thermo Testosterone Booster, 90 Caplets',10,11,_binary ''),(127,'admin','2024-04-16 13:18:59.169000','admin','2024-04-19 10:57:32.557000','P_20240416011859168','A Stack of Herbal Ingredients - Contains Urtica Dioica and Cissus Quadrangularis - Supported Goal: Build Muscle - Main Ingredient: Arachidonic Acid','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/2679f4ea-53cd-4c36-a808-6d54bd7977b0.jpg?v=1678962261620','Universal Nutrition Animal Test, 21 packs',10,7,_binary ''),(128,'admin','2024-04-16 13:19:06.651000','admin','2024-04-19 10:57:32.558000','P_20240416011906651','Tăng khả năng đồng hóa tự nhiên - Thúc đẩy phát triển cơ bắp - Kích thích tổng hợp protein, duy trì cân bằng nitơ - Tăng trao đổi chất và hấp thu dinh dưỡng - Hạn chế sự dị hóa cơ, mất cơ - Hoàn toàn không chứa hormone','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/animal-m-stak.jpg?v=1678962244327','Universal Nutrition Animal M-Stak 21 Packs',10,3,_binary ''),(129,'admin','2024-04-16 13:19:11.464000','admin','2024-04-19 10:57:32.558000','P_20240416011911463','Tăng Testos.terone tự nhiên  - Hỗ trợ tăng cơ bắp  - Hộp 90v  - Dùng được 1 tháng ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/mutant-test-30-serving-90-vien-ho-tro-sinh-ly-nam-gioi-gymstore.jpg?v=1641197518030','Mutant Test 90 Capsules',10,8,_binary ''),(130,'admin','2024-04-16 13:19:15.666000','admin','2024-04-19 10:57:32.558000','P_20240416011915666','Thúc đẩy Testosterone toàn diện - Kết hợp của nhiều amino axit - Bổ sung thêm Kẽm, Magiê và Vitamin B - An toàn, doping-free - Không Carbohydrate - Không Gluten và Lactose - Không chất bảo quản','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/biotech-tst-plus-gh-300-gram.jpg?v=1641198346763','BIOTECH TST+GH (300 Gram)',10,2,_binary ''),(131,'admin','2024-04-16 13:19:19.630000','admin','2024-04-19 10:57:32.558000','P_20240416011919629','Tăng Testosterol tự nhiên lến tới 40% - Thúc đẩy hormone tăng trưởng (GH) - Hỗ trợ tăng cơ nạc, giảm mỡ - Giúp xương khớp chắc khỏe - Chiết xuất thiên nhiên','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/agg-1.jpg?v=1641199016497','Tăng Hormone Nutrabolics AGGRO, 168 V-Capsules',10,6,_binary ''),(132,'admin','2024-04-16 13:19:23.770000','admin','2024-04-19 10:57:32.558000','P_20240416011923769','Kết hợp Kẽm, Magiê và Vitamin B6 - Tăng sản sinh Testosterone  - Cải thiện giấc ngủ - Cải thiện tâm trạng - Tăng cường hệ miễn dịch','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/usn-z-mag.jpg?v=1650877418477','USN ZMA Z-MAG+, 180 Capsules',10,6,_binary ''),(133,'admin','2024-04-16 13:19:28.166000','admin','2024-04-16 13:19:28.166000','P_20240416011928165','1220mg Tribulus Terrestris  - 1318mg L-Arginine  - Bổ sung Acetyl L-carnitine, L-carnitine - 1.5mg Zinc - Tăng testosterone nội sinh  - Hỗ trợ phát triển cơ bắp, tăng sức mạnh - Thúc đẩy đốt mỡ ','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/scitec-1-360-108-capsules-gymstore-jpeg.jpg?v=1706080089083','Scitec T-360 Testosterone Booster, 108 Capsules',10,1,_binary ''),(134,'admin','2024-04-16 13:19:32.946000','admin','2024-04-19 10:57:32.559000','P_20240416011932946','1000mg Tribulus Terrestris - Cải thiện hiệu suất tập luyện ở cường độ cao  - Hỗ trợ lưu thông máu trong cơ bắp  - Thúc đẩy tăng khả năng lưu giữ oxy - Kích thích tổng hợp protein - Hỗ trợ giảm béo  - Tăng cường sức mạnh cơ nạc','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/now-tribulus.jpg?v=1640247422757','Now Tribulus 1000 mg',10,8,_binary ''),(135,'admin','2024-04-16 13:19:38.135000','admin','2024-04-19 10:57:32.559000','P_20240416011938135','Công thức cải thiện Testosterone tự nhiên  - Kiểm soát hàm lượng Estrogen ở mức cho phép - Cải thiện thể chất tổng thể - Hỗ trợ hiệu suất tập luyện - Chứa PrimaVie hỗ trợ tăng Test hiệu quả','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/gat-sport-testrol-gold-es-60-tablets.jpg?v=1641197633850','GAT Sport Testrol Gold ES, 60 Tablets',10,4,_binary ''),(136,'admin','2024-04-16 13:19:43.822000','admin','2024-04-19 10:57:32.559000','P_20240416011943821','1300mg Tribulus Terrestris - Cải thiện mức testosterone tự nhiên - Hỗ trợ đời sống tình dục - Thúc đẩy phát triển cơ bắp','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/nutrex-tribulus-black-1300-120-capsules.jpg?v=1640057815387','Nutrex Tribulus Black 1300, 120 Capsules',10,10,_binary ''),(137,'admin','2024-04-16 13:19:49.364000','admin','2024-04-19 10:57:32.559000','P_20240416011949361','30mg Kẽm - 450mg Magiê - 10,5mg Vitamin B6 - 5mg BioPerine - Tăng cường miễn dịch - Thúc đẩy sức mạnh','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/jym-zma-90-vegetarian-capsules-gymstore-jpeg.jpg?v=1700820250363','JYM Supplement Science ZMA JYM, 90 Vegetarian Capsules',10,2,_binary ''),(138,'admin','2024-04-16 13:23:07.232000','admin','2024-04-19 10:57:32.559000','P_20240416012307231','CTKM đang được giảm giá sâu: KHÔNG QUÀ & KHÔNG FREESHIP - Whey Protein Isolate & Hydrolyzate  - 25G Protein (tỷ lệ đạt 83.3%) - 0 Sugar, 0 Lactose, 0 Gluten, No Amino Spiking. - 76 Servings - Đa dạng mùi vị','https://bizweb.dktcdn.net/100/011/344/themes/857119/assets/frame_1.png?1713210165151','Rule 1 Protein 5 Lbs (2,288 kg)',11,2,_binary ''),(139,'admin','2024-04-16 13:23:11.851000','admin','2024-04-16 13:23:11.851000','P_20240416012311850','27G Protein: Whey Isolate & Hydrolysate - 100% nguồn gốc từ bò ăn cỏ chăn thả tự nhiên - 17G EAA & BCAA & Glutamine  - 1 Tỷ Probiotic lợi khuẩn hỗ trợ tiêu hóa - Phù hợp với người không dung nạp lactose - Đạt Chứng Nhận GMP, Inform-Choice','https://bizweb.dktcdn.net/100/011/344/themes/857119/assets/frame_1.png?1713210165151','PVL ISO Gold - Premium Whey Protein With Probiotic, 5 Lbs (2.27kg)',11,1,_binary ''),(140,'admin','2024-04-16 13:23:15.483000','admin','2024-04-19 10:57:32.559000','P_20240416012315482','100% Hydrolyzed Whey Protein - 28g Protein - 13g EAA, 6.1g BCAA, 5g Glutamine - Không chứa Lactose, Gluten - Đạt chứng chỉ HACCP, GMP, ISO, HALAL','https://bizweb.dktcdn.net/100/011/344/themes/857119/assets/frame_1.png?1713210165151','Nutrabolics Hydropure 4.5 Lbs, 58 Servings',11,10,_binary ''),(141,'admin','2024-04-16 13:23:19.608000','admin','2024-04-19 10:57:32.559000','P_20240416012319607','Whey Isolate và Whey Hydrolyzed - 23g protein/serving (tỷ lệ đạt 90%) - 6g BCAA, 12g EAA - Bổ sung HMB, Axit D-Aspartic và kẽm hỗ trợ hiệu suất tập và testosterone - Bổ sung enzyme lactase hỗ trợ tiêu hóa - 96 calo, 0 carb, 0 fat, 0 đường - Phù hợp với người không dung nạp lactose, gluten','https://bizweb.dktcdn.net/100/011/344/themes/857119/assets/frame_1.png?1713210165151','DY Shadowhey Hydrolysate 2.27Kg (90 Servings)',11,10,_binary ''),(142,'admin','2024-04-16 13:23:24.651000','admin','2024-04-19 10:57:32.560000','P_20240416012324650','Whey Hydrolyzed & Whey Isolate - Nguyên liệu cao cấp từ sữa của những con bò được chăn thả tự nhiên - 18g protein - 3.7g BCAA, 7.5g EAA, 4g Glutamine - Chỉ 85 calo/serving - Phù hợp với người không dung nạp lactose, gluten - Không gây nổi mụn','https://bizweb.dktcdn.net/100/011/344/themes/857119/assets/frame_1.png?1713210165151','BioTechUSA Hydro Whey Zero, 4 Lbs (1,816 Kg)',11,14,_binary ''),(143,'admin','2024-04-16 13:23:29.532000','admin','2024-04-19 10:57:32.560000','P_20240416012329532','CTKM đang được giảm giá sâu: KHÔNG QUÀ & KHÔNG FREESHIP - 100% Whey Protein Isolate  - 25g Protein, 120 Calo - 1G Fat & Sugar  - Hương vị thơm ngon, bột mịn dễ tan','https://bizweb.dktcdn.net/100/011/344/themes/857119/assets/frame_1.png?1713210165151','BPI ISO HD 100% Pure Isolate Protein, 5 Lbs (69 Servings)',11,11,_binary ''),(144,'admin','2024-04-16 13:23:33.284000','admin','2024-04-16 13:23:33.284000','P_20240416012333283','30G Whey Protein siêu tinh khiết  - 15.5G EAAs tổng hợp Protein phát triển cơ bắp  - 8.8G BCAA gia tăng sức bền tập luyện  - Ít đường, ít calo phù hợp với người ăn kiêng - Hương vị thơm ngon, không ngấy','https://bizweb.dktcdn.net/100/011/344/themes/857119/assets/frame_1.png?1713210165151','ON Platinum Hydrowhey, 3.5 Lbs (1.59 kg)',11,1,_binary ''),(145,'admin','2024-04-16 13:23:37.318000','admin','2024-04-19 10:57:32.560000','P_20240416012337318','Whey Protein Isolate & Hydrolysate - 25G Protein phát triển cơ bắp  - 16.3G EAAs tổng hợp Protein  - 5.5G BCAA tăng sức bền tập luyện  - 4,6g Glutamine phục hồi cơ bắp  - Bổ sung enzyme hỗ trợ tiêu hóa - Phù hợp với người không dung nạp lactose','https://bizweb.dktcdn.net/100/011/344/themes/857119/assets/frame_1.png?1713210165151','Mutant ISO Surge 5 Lbs (76 Servings)',11,6,_binary ''),(146,'admin','2024-04-16 13:23:41.562000','admin','2024-04-19 10:57:32.560000','P_20240416012341561','27G Whey Protein Isolate - 6G BCAA và 4.6G Glutamine  - Cung cấp Enzyme hỗ trợ tiêu hóa tốt hơn  - 0G Fat / 0G Sugar / 0G chất xơ  - 0 Gluten, 0 đậu nành','https://bizweb.dktcdn.net/100/011/344/themes/857119/assets/frame_1.png?1713210165151','AllMax IsoFlex 5Lbs (2,27 kg)',11,7,_binary ''),(147,'admin','2024-04-16 13:23:45.365000','admin','2024-04-19 10:57:32.561000','P_20240416012345365','22G Protein Isolate  - 9.5G EAAs - 4.5G BCAA - 4.3G Glutamine - Hương vị dễ uống ','https://bizweb.dktcdn.net/100/011/344/themes/857119/assets/frame_1.png?1713210165151','Biotech USA ISO Whey Zero 5 Lbs (2,270 Kg)',11,7,_binary ''),(148,'admin','2024-04-16 13:23:49.189000','admin','2024-04-19 10:57:32.561000','P_20240416012349188','27G Protein: Whey Protein Isolate & Hydrolysate - 17G EAA & BCAA & Glutamine  - 100% Grass-Fed Whey Protein  - 1 Tỷ Probiotic lợi khuẩn bảo vệ sức khỏe đường ruột - Cung cấp thêm Enzyme hỗ trợ tiêu hóa  - Đạt Chứng Nhận GMP  - Đạt Chứng Nhận Inform-Choice','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/pvl-iso-gold-2lbs-organge.jpg?v=1670036254950','PVL ISO Gold - Premium Whey Protein With Probiotic, 2 Lbs (908 gram)',11,9,_binary ''),(149,'admin','2024-04-16 13:23:53.055000','admin','2024-04-19 10:57:32.561000','P_20240416012353054','Whey Protein Isolate & Concentrate - 100% yến mạch nguyên chất - 40g protein chất lượng cao - Bổ sung Dầu MCT & CLA - Cung cấp BCAA và Glutamine','https://bizweb.dktcdn.net/thumb/grande/100/011/344/products/kevin-levrone-gold-oat-meal-chocolate-3kg-meal-replacements-gymstore-jpeg.jpg?v=1691634679860','Kevin Levrone GOLD Oat Meal',11,3,_binary '');
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,NULL,NULL,NULL,NULL,'Optimum Nutrition'),(2,NULL,NULL,NULL,NULL,'Rule One Proteins'),(3,NULL,NULL,NULL,NULL,'Rule One Proteins'),(4,NULL,NULL,NULL,NULL,'Nutrabolics'),(5,NULL,NULL,NULL,NULL,'Applied Nutrition'),(6,NULL,NULL,NULL,NULL,'Nutricost'),(7,NULL,NULL,NULL,NULL,'Dymatize'),(8,NULL,NULL,NULL,NULL,'Amix Nutrition'),(9,NULL,NULL,NULL,NULL,'Labrada'),(10,NULL,NULL,NULL,NULL,'Now Foods'),(11,NULL,NULL,NULL,NULL,'BPI Sports'),(12,NULL,NULL,NULL,NULL,'VitaXtrong'),(13,NULL,NULL,NULL,NULL,'BiotechUSA'),(14,NULL,NULL,NULL,NULL,'Z Nutrition');
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (13,'admin','2024-04-15 11:12:22.557000','admin','2024-04-15 11:12:22.557000','T_20240415111222539','',1,'Vé 1 tháng',200000,1,_binary ''),(14,'admin','2024-04-15 11:12:40.053000','admin','2024-04-15 11:12:40.053000','T_20240415111240049','',3,'Vé 3 tháng',500000,1,_binary ''),(15,'admin','2024-04-15 11:12:50.625000','admin','2024-04-15 11:12:50.625000','T_20240415111250620','',6,'Vé 6 tháng',800000,1,_binary ''),(16,'admin','2024-04-15 11:13:16.081000','admin','2024-04-15 11:13:16.081000','T_20240415111316078','',12,'Vé 12 tháng',1500000,1,_binary ''),(17,'admin','2024-04-15 11:13:28.382000','admin','2024-04-15 11:13:28.382000','T_20240415111328379','',1,'Vé 1 tháng',150000,2,_binary ''),(18,'admin','2024-04-15 11:13:48.840000','admin','2024-04-15 11:13:48.840000','T_20240415111348837','',3,'Vé 3 tháng',400000,2,_binary ''),(19,'admin','2024-04-15 11:14:00.767000','admin','2024-04-15 11:14:00.767000','T_20240415111400764','',6,'Vé 6 tháng',700000,2,_binary ''),(20,'admin','2024-04-15 11:14:12.086000','admin','2024-04-15 11:14:12.086000','T_20240415111412081','',12,'Vé 12 tháng',1200000,2,_binary ''),(21,'admin','2024-04-15 11:14:30.040000','admin','2024-04-15 11:14:30.040000','T_20240415111430037','',1,'Vé 1 tháng',100000,3,_binary ''),(22,'admin','2024-04-15 11:14:40.554000','admin','2024-04-15 11:14:40.554000','T_20240415111440551','',3,'Vé 3 tháng',300000,3,_binary ''),(23,'admin','2024-04-15 11:14:51.360000','admin','2024-04-15 11:14:51.360000','T_20240415111451357','',6,'Vé 6 tháng',500000,3,_binary ''),(24,'admin','2024-04-15 11:15:02.782000','admin','2024-04-15 11:15:02.782000','T_20240415111502780','',12,'Vé 12 tháng',900000,3,_binary '');
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,NULL,NULL,NULL,'HN','2000-11-14 07:00:00.000000','managercaugiay@gmail.com','Quản lý chi nhánh Cầu Giấy',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','manager_caugiay',1,2,_binary ''),(2,NULL,NULL,NULL,NULL,'HN','2000-11-14 07:00:00.000000','managergiaiphong@gmail.com','Quản lý chi nhánh Giải Phóng',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','manager_giaiphong',2,2,_binary ''),(3,NULL,NULL,NULL,NULL,'HN','2000-11-14 07:00:00.000000','letancaugiay@gmail.com','Lễ tân Cầu Giấy',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','user_caugiay',1,4,_binary ''),(4,NULL,NULL,NULL,NULL,'HN','2000-11-14 07:00:00.000000','letangiaiphong@gmail.com','Lễ tân Giải Phóng',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','user_giaiphong',2,4,_binary ''),(5,NULL,NULL,NULL,NULL,'HN','2000-11-14 07:00:00.000000','admin@gmail.com','Admin',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','admin',NULL,1,_binary ''),(6,NULL,NULL,NULL,NULL,'HN','2000-11-14 07:00:00.000000','customer@gmail.com','Customer',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','customer',NULL,3,_binary ''),(7,NULL,NULL,NULL,NULL,'HN','2000-11-14 07:00:00.000000','managerhoalac@gmail.com','Quản lý chi nhánh Hòa Lạc',_binary '\0','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','manager_hoalac',3,2,_binary ''),(12,'admin','2024-04-19 15:55:32.498000','admin','2024-04-19 15:55:55.374000','HN','2000-11-14 07:00:00.000000','duongddhe140609@fpt.edu.vn','Đỗ Đức Dương',_binary '','$2a$10$8OFzgrpgEWMqux9nyvwTuu5Ucc9XR6pDg73gsXPHvQ05v75YB2soq',NULL,'0979719735','duongdd',1,4,_binary ''),(13,'admin','2024-04-19 16:11:47.336000','admin','2024-04-19 16:12:13.113000','HN','2000-11-14 07:00:00.000000','duongddhe140609@fpt.edu.vn','Đỗ Đức Dương',_binary '','$2a$10$.LfBU83lOeDAvPY2rdiUdu1xVrFXlcovOqRWvyNnY2GPLVbGHjmCe',NULL,'0979719735','duongdd14',2,4,_binary '');
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

-- Dump completed on 2024-04-19 16:44:43

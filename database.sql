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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,NULL,NULL,NULL,NULL,'Category 1'),(2,NULL,NULL,NULL,NULL,'Category 2'),(3,NULL,NULL,NULL,NULL,'Category 3');
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility_product`
--

LOCK TABLES `facility_product` WRITE;
/*!40000 ALTER TABLE `facility_product` DISABLE KEYS */;
INSERT INTO `facility_product` VALUES (17,'admin','2024-02-21 16:51:26.235000','customer','2024-03-05 14:01:40.779000',100000,'ACTIVE',1,1,11),(18,'admin','2024-02-21 16:51:26.238000','admin','2024-02-22 09:30:43.271000',200000,'ACTIVE',3,2,11),(19,'admin','2024-04-04 11:12:32.868000','admin','2024-04-04 11:12:32.868000',0,'COMING_SOON',0,1,12),(20,'admin','2024-04-04 11:12:32.918000','admin','2024-04-04 11:12:32.918000',0,'COMING_SOON',0,2,12),(21,'admin','2024-04-04 11:12:32.920000','admin','2024-04-04 11:12:32.920000',0,'COMING_SOON',0,3,12);
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
INSERT INTO `order_product` VALUES (12,'customer','2024-03-05 14:01:40.736000','customer','2024-03-05 14:01:40.736000',NULL,2,100000,17,18);
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
INSERT INTO `orders` VALUES (18,'customer','2024-03-05 14:01:40.683000','customer','2024-03-05 14:01:40.683000','PROCESSING',NULL,200000);
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (11,'admin','2024-02-21 16:51:26.150000','admin','2024-02-22 08:56:42.290000','P_20240221045126123','máy chạyyyy',NULL,'Máy chạy',2,2,_binary '\0'),(12,'admin','2024-04-04 11:12:32.677000','admin','2024-04-04 11:12:32.922000','P_20240404111232650',NULL,'/image/P_20240404111232650_Screen Shot 2024-01-25 at 16.42.12.png','thuc pham chuc nang',1,1,_binary '');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,'managercaugiay@gmail.com','Quản lý chi nhánh Cầu Giấy',NULL,'$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,NULL,'manager_caugiay',1,2,_binary ''),(2,NULL,NULL,NULL,NULL,NULL,NULL,'managergiaiphong@gmail.com','Quản lý chi nhánh Giải Phóng',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','manager_giaiphong',2,2,_binary ''),(3,NULL,NULL,NULL,NULL,NULL,'2000-11-14 07:00:00.000000','letancaugiay@gmail.com','Lễ tân Cầu Giấy',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','user_caugiay',1,4,_binary ''),(4,NULL,NULL,NULL,NULL,NULL,'2000-11-14 07:00:00.000000','letangiaiphong@gmail.com','Lễ tân Giải Phóng',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','user_giaiphong',2,4,_binary ''),(5,NULL,NULL,NULL,NULL,NULL,'2000-11-14 07:00:00.000000','admin@gmail.com','Admin',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','admin',NULL,1,_binary ''),(6,NULL,NULL,NULL,NULL,NULL,NULL,'customer@gmail.com','Customer',_binary '','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','customer',NULL,3,_binary ''),(7,NULL,NULL,NULL,NULL,NULL,NULL,'managerhoalac@gmail.com','Quản lý chi nhánh Hòa Lạc',_binary '\0','$2a$10$ATGqmunGcMpD5SCnbSKJ1.9M3kMmR2nXPNVJCsFWwtaL62ybAj.2q',NULL,'0912345678','manager_hoalac',3,2,_binary '');
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

-- Dump completed on 2024-04-04 13:37:04

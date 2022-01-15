-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: productws_db
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
INSERT INTO `photo` VALUES (1,NULL,'photo-pant1'),(2,NULL,'photo-pant2'),(3,NULL,'photo-blouse1'),(4,NULL,'photo-blouse2'),(5,NULL,'photo-design1'),(6,NULL,'photo-design2');
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `design_type`
--

LOCK TABLES `design_type` WRITE;
/*!40000 ALTER TABLE `design_type` DISABLE KEYS */;
INSERT INTO `design_type` VALUES ('fabric'),('leather');
/*!40000 ALTER TABLE `design_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `design`
--

LOCK TABLES `design` WRITE;
/*!40000 ALTER TABLE `design` DISABLE KEYS */;
INSERT INTO `design` VALUES (1,'black','striped',4.99,'leather'),(2,'red','square',3.99,'fabric');
/*!40000 ALTER TABLE `design` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `design_photo`
--

LOCK TABLES `design_photo` WRITE;
/*!40000 ALTER TABLE `design_photo` DISABLE KEYS */;
INSERT INTO `design_photo` VALUES (1,5),(2,6);
/*!40000 ALTER TABLE `design_photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES ('left-arm'),('left-leg'),('right-arm'),('right-leg');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_type`
--

LOCK TABLES `product_type` WRITE;
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` VALUES ('blouse'),('pant'),('shirt');
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `location_product_type`
--

LOCK TABLES `location_product_type` WRITE;
/*!40000 ALTER TABLE `location_product_type` DISABLE KEYS */;
INSERT INTO `location_product_type` VALUES ('left-leg','pant'),('right-leg','pant'),('left-arm','blouse'),('right-arm','blouse');
/*!40000 ALTER TABLE `location_product_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cloth`
--

LOCK TABLES `cloth` WRITE;
/*!40000 ALTER TABLE `cloth` DISABLE KEYS */;
INSERT INTO `cloth` VALUES (1,NULL,'blue pant',35.99,'2022-01-15 16:09:41',NULL,'bluePants','pant'),(2,NULL,'green blouse',30.99,'2021-04-23 16:09:41','2022-01-05 04:17:00','greenBlouse','blouse');
/*!40000 ALTER TABLE `cloth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cloth_photo`
--

LOCK TABLES `cloth_photo` WRITE;
/*!40000 ALTER TABLE `cloth_photo` DISABLE KEYS */;
INSERT INTO `cloth_photo` VALUES (1,1),(1,2),(2,3),(2,4);
/*!40000 ALTER TABLE `cloth_photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES ('32'),('34'),('36'),('large'),('medium'),('small');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,12,1,'32'),(2,3,1,'34'),(3,2,1,'36'),(4,22,2,'small'),(5,13,2,'medium'),(6,0,2,'large');
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-15 17:10:45

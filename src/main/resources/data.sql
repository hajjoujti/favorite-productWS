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
INSERT INTO `photo` VALUES (1,'manteau_vue_globale','MANTEAU_CAPUCHE_1.jpg'),(2,'manteau_detail_1','MANTEAU_CAPUCHE_2.jpg'),(3,'manteau_detail_2','MANTEAU_CAPUCHE_3.jpg'),(4,'manteau_detail_3','MANTEAU_CAPUCHE_4.jpg'),(5,'pantalon_vue_globale','PANTALON_1.jpg'),(6,'pantalon_detail_beige','PANTALON_BEIGE_1.jpg'),(7,'col_roule_vue_globale','PULL_COL_ROULE_1.jpg'),(8,'col_roule_detail_1','PULL_COL_ROULE_2.jpg'),(9,'col_rond_vue_globale','PULL_COLROND_1.jpg'),(10,'col_rond_detail','PULL_COLROND_2.jpg'),(11,'surchemise_vue_globale','SURCHEMISE_1.jpg'),(12,'surchemise_detail_1','SURCHEMISE_2.jpg'),(13,'surchemise_detail_2','SURCHEMISE_3.jpg'),(14,'tshirt_vue_globale','T-SHIRT_1.jpg'),(15,'tshirt_detail','T-SHIRT_2.jpg'),(16,'basquiat_dino','BASQUIAT.jpg'),(17,'broderie_fleurs','FLEURS.jpg'),(18,'dubuffet_hourloupe','HOURLOUPE.jpg'),(19,'pantalon_detail','PANTALON_2.jpg');
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `design_type`
--

LOCK TABLES `design_type` WRITE;
/*!40000 ALTER TABLE `design_type` DISABLE KEYS */;
INSERT INTO `design_type` VALUES ('Broderie'),('Autocollant'),('Peinture');
/*!40000 ALTER TABLE `design_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `design`
--

LOCK TABLES `design` WRITE;
/*!40000 ALTER TABLE `design` DISABLE KEYS */;
INSERT INTO `design` VALUES (1,'Noir','Basquiat',4.99,'Peinture'),(2,'Rose','Fleurs',5.99,'Broderie'),(3,'Rouge','Hourloupe',3.99,'Autocollant');
/*!40000 ALTER TABLE `design` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `design_photo`
--

LOCK TABLES `design_photo` WRITE;
/*!40000 ALTER TABLE `design_photo` DISABLE KEYS */;
INSERT INTO `design_photo` VALUES (1,16),(2,17),(3,18);
/*!40000 ALTER TABLE `design_photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES ('Centre avant'),('Centre dos'),('Epaule gauche'),('Epaule droite'),('Poche avant droite'),('Poche avant gauche'),('Poche arriere droite'),('Poche arriere gauche'),('Genou droit'),('Genou gauche');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_type`
--

LOCK TABLES `product_type` WRITE;
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` VALUES ('Manteaux & Vestes'),('Pulls'),('Chemises'),('TShirts'),('Pantalons'),('Jeans'),('Accessoires');
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `location_product_type`
--

LOCK TABLES `location_product_type` WRITE;
/*!40000 ALTER TABLE `location_product_type` DISABLE KEYS */;
INSERT INTO `location_product_type` VALUES ('Centre avant','TShirts'),('Centre dos','TShirts'),('Epaule droite','TShirts'),('Epaule gauche','TShirts'),('Centre avant','Chemises'),('Centre dos','Chemises'),('Epaule droite','Chemises'),('Epaule gauche','Chemises'),('Centre avant','Pulls'),('Centre dos','Pulls'), ('Epaule droite','Pulls'),('Epaule gauche','Pulls'),('Centre avant','Manteaux & Vestes'),('Centre dos','Manteaux & Vestes'),('Epaule droite','Manteaux & Vestes'),('Epaule gauche','Manteaux & Vestes'),('Poche avant droite','Jeans'),('Poche avant gauche','Jeans'),('Poche arriere droite','Jeans'),('Poche arriere gauche','Jeans'),('Poche avant droite','Pantalons'),('Poche avant gauche', 'Pantalons'),('Poche arriere droite','Pantalons'),('Poche arriere gauche','Pantalons');
/*!40000 ALTER TABLE `location_product_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cloth`
--

LOCK TABLES `cloth` WRITE;
/*!40000 ALTER TABLE `cloth` DISABLE KEYS */;
INSERT INTO `cloth` VALUES (1,NULL,'Pull col rond',49.99,'2021-01-01','2021-03-01','SS20Pu001','Pulls'),(2,'Vous protège du vent et de la pluie pour vous garder au sec. Une parka confortable et fonctionnelle qui vous offre une grande liberté de mouvement.','Parka',89.99,'2021-01-01',null,'FW21MV005','Manteaux & Vestes'),(3,'Ce pantalon vous offre un confort et une légèreté exceptionnels. Un modèle idéal pour vous suivre dans vos activités quotidiennes.','Pantalon',44.99,'2021-02-01',null,'SS21Pa021','Pantalons'),(4,'Ce pull est confectionné en laine mérinos, une matière élégante et douce très appréciée à travers le monde.','Pull Col Roulé',34.99,'2021-02-01',null,'FW21Pu006','Pulls'),(5,'Variez vos looks avec cette chemise oversize, en la portant comme une chemise classique ou comme une surchemise.','Chemise Epaisse',49.99,'2021-02-01',null,'SS21C023','Chemises'),(6,'Conçue dans un souci de perfection, cette pièce apparemment simple est aussi exceptionnelle que durable.','T-Shirt',15.99,'2021-02-01',null,'SS21T056','TShirts');
/*!40000 ALTER TABLE `cloth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cloth_photo`
--

LOCK TABLES `cloth_photo` WRITE;
/*!40000 ALTER TABLE `cloth_photo` DISABLE KEYS */;
INSERT INTO `cloth_photo` VALUES (1,9),(1,10),(2,4),(2,3),(2,2),(2,1),(3,5),(3,6),(4,7),(4,8),(5,11),(5,12),(5,13),(6,14),(6,15);
/*!40000 ALTER TABLE `cloth_photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES ('XS'),('S'),('M'),('L'),('XL'),('XXL'),('34'),('36'),('38'),('40'),('42'),('44');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,0,1,'XS'),(2,0,1,'S'),(3,0,1,'M'),(4,0,1,'L'),(5,0,1,'XL'),(6,0,1,'XXL'),(7,1,2,'XS'),(8,0,2,'S'),(9,2,2,'M'),(10,0,2,'L'),(11,1,2,'XL'),(12,0,2,'XXL'),(13,1,3,'34'),(14,4,3,'36'),(15,0,3,'38'),(16,5,3,'40'),(17,5,3,'42'),(18,0,3,'44'),(19,1,4,'XS'),(20,0,4,'S'),(21,0,4,'M'),(22,0,4,'L'),(23,1,4,'XL'),(24,0,4,'XXL'),(25,0,5,'XS'),(26,0,5,'S'),(27,0,5,'M'),(28,0,5,'L'),(29,0,5,'XL'),(30,0,5,'XXL'),(31,5,6,'XS'),(32,5,6,'S'),(33,5,6,'M'),(34,5,6,'L'),(35,5,6,'XL'),(36,5,6,'XXL');
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

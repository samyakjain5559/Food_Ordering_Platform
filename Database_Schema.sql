-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: 4321_lab1
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `burritomenu_tlb`
--

DROP TABLE IF EXISTS `burritomenu_tlb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `burritomenu_tlb` (
  `itemid` int NOT NULL,
  `itemname` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `include` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `burritomenu_tlb`
--

LOCK TABLES `burritomenu_tlb` WRITE;
/*!40000 ALTER TABLE `burritomenu_tlb` DISABLE KEYS */;
/*!40000 ALTER TABLE `burritomenu_tlb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliverytime_tbl`
--

DROP TABLE IF EXISTS `deliverytime_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deliverytime_tbl` (
  `orderno` int NOT NULL,
  `hour` int DEFAULT NULL,
  `minutes` int DEFAULT NULL,
  `month` int DEFAULT NULL,
  `day` int DEFAULT NULL,
  PRIMARY KEY (`orderno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliverytime_tbl`
--

LOCK TABLES `deliverytime_tbl` WRITE;
/*!40000 ALTER TABLE `deliverytime_tbl` DISABLE KEYS */;
INSERT INTO `deliverytime_tbl` VALUES (114,16,13,1,16),(157,17,6,2,15),(263,19,NULL,NULL,NULL),(445,17,10,2,20),(448,19,37,2,20),(599,17,36,2,15),(701,0,9,2,15),(755,17,13,2,20),(814,2,31,2,15),(854,0,3,2,15),(869,3,5,2,21),(921,23,26,2,14);
/*!40000 ALTER TABLE `deliverytime_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_tbl`
--

DROP TABLE IF EXISTS `orders_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_tbl` (
  `orderid` int NOT NULL,
  `itemlist` longtext,
  `totalprice` varchar(45) DEFAULT NULL,
  `pay_status` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phoneno` varchar(45) DEFAULT NULL,
  `delivery_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_tbl`
--

LOCK TABLES `orders_tbl` WRITE;
/*!40000 ALTER TABLE `orders_tbl` DISABLE KEYS */;
INSERT INTO `orders_tbl` VALUES (108,'[Name:tex mex] [Price:$17] [Includes: avacado,bread,olives,corn] [Type:burrito]  [Size Selected:Medium] ','17','paid','bj','78','delivering'),(114,'[Name:kale caesar] [Price:$19] [Includes: wheat,olives,spinach] [Type:wrap]  [Size Selected:Large] [Name:smokehouse] [Price:$18] [Includes: wheat,bread,rice,corn] [Type:burrito]  [Size Selected:Medium] ','37','paid','test thsi loca','7883','Signed for'),(128,'[Name:smokehouse] [Price:$18] [Includes: wheat,bread,rice,corn] [Type:burrito]  [Size Selected:Medium] [Name:market] [Price:$11] [Includes: parsley,wheat,spinach] [Type:wrap]  [Size Selected:Medium] ','29','paid','grg','45','delivering'),(157,'[Name:tex mex] [Price:$17] [Includes: avacado,bread,olives,corn] [Type:burrito]  [Size Selected:Small] [Name:smokehouse] [Price:$18] [Includes: wheat,bread,rice,corn] [Type:burrito]  [Size Selected:Small] ','35','paid','test this locat','4344','delivering'),(445,'[Name:tex mex] [Price:$17] [Includes: avacado,bread,olives,corn] [Type:burrito]  [Size Selected:Medium] ','17','paid','myplace','546','delivering'),(448,'[Name:cobb] [Price:$17] [Includes: onions,gram,olives] [Type:wrap]  [Size Selected:Medium] [Name:fiesta] [Price:$18] [Includes: wheat,flour,cucumber] [Type:wrap]  [Size Selected:Medium] ','35','paid','chech this','584','delivering'),(592,'[Name:smokehouse] [Price:$18] [Includes: wheat,bread,rice,corn] [Type:burrito]  [Size Selected:Medium] [Name:tex mex] [Price:$17] [Includes: avacado,bread,olives,corn] [Type:burrito]  [Size Selected:Medium] ','35','paid','myplace','454','delivering'),(599,'[Name:kale caesar] [Price:$19] [Includes: wheat,olives,spinach] [Type:wrap]  [Size Selected:Medium] [Name:market] [Price:$11] [Includes: parsley,wheat,spinach] [Type:wrap]  [Size Selected:Medium] ','30','Unpaid','my address','my number','Delivering'),(634,'[Name:market] [Price:$11] [Includes: parsley,wheat,spinach] [Type:wrap]  [Size Selected:Large] [Name:pangoa] [Price:$15] [Includes: onions,gram,sauce,corn] [Type:salad]  [Size Selected:Medium] [Name:texmex] [Price:$17] [Includes: wheat,ranch,yogurt] [Type:salad]  [Size Selected:Small] ','43','paid','york univeristy','1234567','delivering'),(701,'[Name:pangoa] [Price:$15] [Includes: onions,gram,sauce,corn] [Type:salad]  [Size Selected:Large] [Name:mango] [Price:$10] [Includes: mango,milk,sugar] [Type:drinks]  [Size Selected:Medium] [Name:market] [Price:$11] [Includes: parsley,wheat,spinach] [Type:wrap]  [Size Selected:Small] [Name:strawberry] [Price:$7] [Includes: strawberry,banana,yogurt,milk] [Type:drinks]  [Size Selected:Large] ','43','Unpaid','canada','3453','Signed for'),(755,'[Name:tex mex] [Price:$17] [Includes: avacado,bread,olives,corn] [Type:burrito]  [Size Selected:Medium] [Name:bamboo] [Price:$10] [Includes: cabbage,wheat,carrot] [Type:salad]  [Size Selected:Medium] ','27','paid','gjgh','67','delivering'),(854,'[Name:market] [Price:$11] [Includes: parsley,wheat,spinach] [Type:wrap]  [Size Selected:Small] [Name:smokehouse] [Price:$18] [Includes: wheat,bread,rice,corn] [Type:burrito]  [Size Selected:Medium] ','29','paid','bjnj','7878','delivering'),(869,'[Name:smokehouse] [Price:$18] [Includes: wheat,bread,rice,corn] [Type:burrito]  [Size Selected:Medium] ','18','paid','','','delivering'),(921,'[Name:smokehouse] [Price:$18] [Includes: wheat,bread,rice,corn] [Type:burrito]  [Size Selected:Large] [Name:tex mex] [Price:$17] [Includes: avacado,bread,olives,corn] [Type:burrito]  [Size Selected:Small] ','35','Unpaid','jkjk','hhiu','Signed for');
/*!40000 ALTER TABLE `orders_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signup` (
  `email` varchar(100) NOT NULL,
  `password` longtext,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup`
--

LOCK TABLES `signup` WRITE;
/*!40000 ALTER TABLE `signup` DISABLE KEYS */;
INSERT INTO `signup` VALUES ('junitemail4@gmail.com','anypass','manager'),('myadmin@gmail.com','rfe','admin'),('mymanger@gmail.com','rgrr','manager'),('samay','edw','client'),('samayak','sammy','manager'),('samayak@gmail.com','efew','manager'),('samayhffj','edw','client'),('sas','eewd','manager'),('sasffjff','eewd','client');
/*!40000 ALTER TABLE `signup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wrapmenu_tbl`
--

DROP TABLE IF EXISTS `wrapmenu_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wrapmenu_tbl` (
  `itemid` int NOT NULL,
  `itemname` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `include` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wrapmenu_tbl`
--

LOCK TABLES `wrapmenu_tbl` WRITE;
/*!40000 ALTER TABLE `wrapmenu_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `wrapmenu_tbl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-03  1:49:07

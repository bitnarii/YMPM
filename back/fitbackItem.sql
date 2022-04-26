-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: fitback
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime(6) NOT NULL,
  `edited_date` datetime(6) NOT NULL,
  `item_brand` varchar(255) DEFAULT NULL,
  `item_category` varchar(255) DEFAULT NULL,
  `item_img_name` varchar(255) DEFAULT NULL,
  `item_img_origin` varchar(255) DEFAULT NULL,
  `item_img_path` varchar(255) DEFAULT NULL,
  `item_memo` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'2022-04-22 02:13:19.504788','2022-04-22 02:13:19.504788','LENGAGEMENT','top','ef23a14a-fa23-4e99-b8fb-0451c88de6de.jpg','2329723_1_500.jpg','C:\\Users\\admin\\Documents\\FinalProject\\YMPM\\back\\ympm\\src\\main\\resources\\static\\files\\ef23a14a-fa23-4e99-b8fb-0451c88de6de.jpg','품번 - LA21SSNSS002','에코 버튼 뱀부 오버사이즈 하프 셔츠 [바이올렛]'),(2,'2022-04-22 02:16:48.987075','2022-04-22 02:16:48.987075','WHATITISNT','top','773f0455-83b7-407b-a410-c605844c0720.jpg','detail_1005680_8_500.jpg','C:\\Users\\admin\\Documents\\FinalProject\\YMPM\\back\\ympm\\src\\main\\resources\\static\\files\\773f0455-83b7-407b-a410-c605844c0720.jpg','품번 - MG2200ST01WH','사인로고 반팔 티셔츠 화이트'),(3,'2022-04-22 02:18:02.863520','2022-04-22 02:18:02.863520','WHATITISNT','etc','ee1efbe5-6121-41a1-8f4d-d665930ecf8e.jpg','2436978_1_500.jpg','C:\\Users\\admin\\Documents\\FinalProject\\YMPM\\back\\ympm\\src\\main\\resources\\static\\files\\ee1efbe5-6121-41a1-8f4d-d665930ecf8e.jpg','품번 - MG2200CA03IV','사인로고 볼캡 아이보리'),(7,'2022-04-22 02:22:36.469372','2022-04-22 02:22:36.469372','ORDERPLEASE','bottom','300db3c0-6800-48ec-87eb-6a9e18861a4f.jpg','2473109_1_500.jpg','C:\\Users\\admin\\Documents\\FinalProject\\YMPM\\back\\ympm\\src\\main\\resources\\static\\files\\300db3c0-6800-48ec-87eb-6a9e18861a4f.jpg','품번 - OP00ACDP200LB','ODPL 005 바시티 와이드 데님 팬츠 라이트블루[HEAVY WIDE]'),(8,'2022-04-22 02:24:12.949406','2022-04-22 02:24:12.949406','LOLYLOVELOLY','etc','9d663b34-f689-4606-b08a-fbca2feebb3e.jpg','2460425_2_500.jpg','C:\\Users\\admin\\Documents\\FinalProject\\YMPM\\back\\ympm\\src\\main\\resources\\static\\files\\9d663b34-f689-4606-b08a-fbca2feebb3e.jpg','품번 - LL02SA003-BR','팁시 로고 캡 브라운'),(9,'2022-04-22 02:25:18.236222','2022-04-22 02:25:18.236222','STRETCH ANGELS','bottom','87445b49-ce1a-4441-8c77-5e620fc6f968.jpg','2452268_1_500.jpg','C:\\Users\\admin\\Documents\\FinalProject\\YMPM\\back\\ympm\\src\\main\\resources\\static\\files\\87445b49-ce1a-4441-8c77-5e620fc6f968.jpg','품번 - A-22S-SWTB75022-CRS','레터링 숏팬츠_크림'),(11,'2022-04-22 02:27:41.415499','2022-04-22 02:27:41.415499','DIBS','top','8c501184-4b7e-4e0f-b6d4-e39631555b0f.jpg','2322047_1_500.jpg','C:\\Users\\admin\\Documents\\FinalProject\\YMPM\\back\\ympm\\src\\main\\resources\\static\\files\\8c501184-4b7e-4e0f-b6d4-e39631555b0f.jpg','품번 - 21MT003-GRAY','시그니처로고 하프 집업 스웻셔츠 그레이'),(12,'2022-04-22 02:28:33.936218','2022-04-22 02:28:33.936218','LARTIGENT','top','ea4a0e0f-492c-42ab-a579-e1ac2d41a2e1.jpg','2364823_2_500.jpg','C:\\Users\\admin\\Documents\\FinalProject\\YMPM\\back\\ympm\\src\\main\\resources\\static\\files\\ea4a0e0f-492c-42ab-a579-e1ac2d41a2e1.jpg','품번 - L22SPTS01BK','LY DAMAGE T-SHIRT (BLACK)'),(13,'2022-04-22 02:29:43.436517','2022-04-22 02:29:43.436517','BRANDED','bottom','b86d7577-68ef-4004-9189-5d756a913137.jpg','1555407_1_500.jpg','C:\\Users\\admin\\Documents\\FinalProject\\YMPM\\back\\ympm\\src\\main\\resources\\static\\files\\b86d7577-68ef-4004-9189-5d756a913137.jpg','품번 - LOT1968','1968 HIMALAYA JEANS [WIDE STRAIGHT]'),(25,'2022-04-22 09:38:14.767990','2022-04-22 09:38:14.767990','RECLOW','etc','66eee5fc-6a26-4b6d-9daa-8f5191ce5b40.jpg','detail_1005680_8_500.jpg','C:\\Users\\admin\\Documents\\FinalProject\\YMPM\\back\\ympm\\src\\main\\resources\\static\\files\\66eee5fc-6a26-4b6d-9daa-8f5191ce5b40.jpg','품번 - RC B019 BLACK GLASS','RC B019 BLACK GLASS');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-26 16:57:08

/*
SQLyog Community v13.1.4  (64 bit)
MySQL - 8.0.20 : Database - medical_inventory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`medical_inventory` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `medical_inventory`;

/*Table structure for table `box` */

DROP TABLE IF EXISTS `box`;

CREATE TABLE `box` (
  `id` int DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `quantity` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `box` */

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int DEFAULT NULL,
  `fullname` varchar(100) NOT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `address` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

/*Table structure for table `dosage_form` */

DROP TABLE IF EXISTS `dosage_form`;

CREATE TABLE `dosage_form` (
  `id` int DEFAULT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dosage_form` */

/*Table structure for table `indication_generic` */

DROP TABLE IF EXISTS `indication_generic`;

CREATE TABLE `indication_generic` (
  `id` int DEFAULT NULL,
  `indication_id` int NOT NULL,
  `generic_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `indication_generic` */

/*Table structure for table `location` */

DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
  `id` int DEFAULT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `location` */

/*Table structure for table `manufacturer` */

DROP TABLE IF EXISTS `manufacturer`;

CREATE TABLE `manufacturer` (
  `id` int DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `address` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manufacturer` */

/*Table structure for table `returned` */

DROP TABLE IF EXISTS `returned`;

CREATE TABLE `returned` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sale_id` int DEFAULT NULL,
  `purchase_id` int DEFAULT NULL,
  `quantity` int NOT NULL,
  `unit_price` double NOT NULL,
  `deduction` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `wastage` bit(1) NOT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `sale_id` (`sale_id`),
  KEY `purchase_id` (`purchase_id`),
  CONSTRAINT `returned_fk_purchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`id`),
  CONSTRAINT `returned_fk_sale` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `returned` */

insert  into `returned`(`id`,`sale_id`,`purchase_id`,`quantity`,`unit_price`,`deduction`,`total`,`wastage`,`datetime`) values 
(1,1,NULL,5,5,5,555,'','2021-04-24 14:41:14'),
(2,NULL,1,5,5,5,555,'','2021-04-24 14:48:30'),
(3,NULL,7,5,10,1,49,'\0','2021-05-30 14:01:59'),
(4,NULL,1,5,9,2.25,43,'\0','2021-05-30 14:07:08'),
(5,NULL,2,4,100,20,380,'','2021-05-30 14:07:08'),
(6,2,NULL,5,100,0,500,'\0','2021-06-13 22:44:02'),
(7,NULL,7,2,10,0.4,20,'','2021-07-11 11:17:36');

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id` int DEFAULT NULL,
  `name` varchar(500) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `supplier` */

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int DEFAULT NULL,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

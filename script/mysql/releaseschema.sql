/*
SQLyog Community v13.1.4  (64 bit)
MySQL - 8.0.20 : Database - medical_inventory_release
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`medical_inventory_release` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `medical_inventory_release`;

/*Table structure for table `box` */

DROP TABLE IF EXISTS `box`;

CREATE TABLE `box` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `strength` varchar(100) NOT NULL,
  `dosage_form_id` int NOT NULL,
  `generic_id` int NOT NULL,
  `manufacturer_id` int NOT NULL,
  `purchase_price` double NOT NULL,
  `sale_price` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dosage_form_id` (`dosage_form_id`),
  KEY `generic_id` (`generic_id`),
  KEY `manufacturer_id` (`manufacturer_id`),
  CONSTRAINT `brand_fk_dosage_form` FOREIGN KEY (`dosage_form_id`) REFERENCES `dosage_form` (`id`),
  CONSTRAINT `brand_fk_generic` FOREIGN KEY (`generic_id`) REFERENCES `generic` (`id`),
  CONSTRAINT `brand_fk_manufacturer` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int DEFAULT NULL,
  `fullname` varchar(100) NOT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `address` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `dosage_form` */

DROP TABLE IF EXISTS `dosage_form`;

CREATE TABLE `dosage_form` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8;

/*Table structure for table `generic` */

DROP TABLE IF EXISTS `generic`;

CREATE TABLE `generic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1499 DEFAULT CHARSET=utf8;

/*Table structure for table `indication` */

DROP TABLE IF EXISTS `indication`;

CREATE TABLE `indication` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2030 DEFAULT CHARSET=utf8;

/*Table structure for table `indication_generic` */

DROP TABLE IF EXISTS `indication_generic`;

CREATE TABLE `indication_generic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `indication_id` int NOT NULL,
  `generic_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `indication_id` (`indication_id`),
  KEY `generic_id` (`generic_id`),
  CONSTRAINT `indication_generic_fk_generic` FOREIGN KEY (`generic_id`) REFERENCES `generic` (`id`),
  CONSTRAINT `indication_generic_fk_indication` FOREIGN KEY (`indication_id`) REFERENCES `indication` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8987 DEFAULT CHARSET=utf8;

/*Table structure for table `location` */

DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Table structure for table `manufacturer` */

DROP TABLE IF EXISTS `manufacturer`;

CREATE TABLE `manufacturer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=utf8;

/*Table structure for table `purchase` */

DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `brand_id` int NOT NULL,
  `purchase_invoice_id` varchar(15) NOT NULL,
  `batch_no` varchar(15) NOT NULL,
  `box_id` int NOT NULL,
  `quantity` int NOT NULL,
  `unit_price` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `total` double NOT NULL,
  `expiry_datetime` datetime NOT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `brand_id` (`brand_id`),
  KEY `purchase_invoice_id` (`purchase_invoice_id`),
  CONSTRAINT `purchase_fk_brand` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  CONSTRAINT `purchase_fk_purchase_invoice` FOREIGN KEY (`purchase_invoice_id`) REFERENCES `purchase_invoice` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Table structure for table `purchase_invoice` */

DROP TABLE IF EXISTS `purchase_invoice`;

CREATE TABLE `purchase_invoice` (
  `id` varchar(15) NOT NULL,
  `supplier_id` int DEFAULT NULL,
  `total` double NOT NULL,
  `vat` double NOT NULL,
  `discount` double NOT NULL,
  `payable` double NOT NULL,
  `paid` double NOT NULL,
  `returned` double NOT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `purchase_invoice_fk_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `sale` */

DROP TABLE IF EXISTS `sale`;

CREATE TABLE `sale` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sale_invoice_id` varchar(15) NOT NULL,
  `stock_id` int NOT NULL,
  `quantity` int NOT NULL,
  `unit_price` double NOT NULL,
  `discount` double NOT NULL,
  `total` double NOT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `sale_invoice_id` (`sale_invoice_id`),
  KEY `stock_id` (`stock_id`),
  CONSTRAINT `sale_fk_sale_invoice` FOREIGN KEY (`sale_invoice_id`) REFERENCES `sale_invoice` (`id`),
  CONSTRAINT `sale_fk_stock` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `sale_invoice` */

DROP TABLE IF EXISTS `sale_invoice`;

CREATE TABLE `sale_invoice` (
  `id` varchar(15) NOT NULL,
  `user_id` int NOT NULL,
  `total` double NOT NULL,
  `vat` double NOT NULL,
  `discount` double NOT NULL,
  `payable` double NOT NULL,
  `paid` double NOT NULL,
  `returned` double NOT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `sale_invoice_fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `purchase_id` int NOT NULL,
  `location_id` int DEFAULT NULL,
  `quantity` int NOT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `location_id` (`location_id`),
  KEY `purchase_id` (`purchase_id`),
  CONSTRAINT `stock_fk_location` FOREIGN KEY (`location_id`) REFERENCES `purchase` (`id`),
  CONSTRAINT `stock_fk_purchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `username` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(200) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `address` text NOT NULL,
  `active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `user_role_fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

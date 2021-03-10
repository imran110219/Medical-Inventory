/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 5.7.22-log : Database - medical_inventory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`medical_inventory` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `medical_inventory`;

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
    `id` INT(11) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `strength` VARCHAR(100) NOT NULL,
    `dosage_form_id` INT(11) NOT NULL,
    `generic_id` INT(11) NOT NULL,
    `manufacturer_id` INT(11) NOT NULL,
    `purchase_price` DOUBLE NOT NULL,
    `sale_price` DOUBLE NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `dosage_form` */

DROP TABLE IF EXISTS `dosage_form`;

CREATE TABLE `dosage_form` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(200) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `location` */

DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(200) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `manufacturer` */

DROP TABLE IF EXISTS `manufacturer`;

CREATE TABLE `manufacturer` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `address` TEXT DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `generic` */

DROP TABLE IF EXISTS `generic`;

CREATE TABLE `generic` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `indication` */

DROP TABLE IF EXISTS `indication`;

CREATE TABLE `indication` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `indication_generic` */

DROP TABLE IF EXISTS `indication_generic`;

CREATE TABLE `indication_generic` (
  `id` INT(11) NOT NULL,
  `indication_id` INT(11) NOT NULL,
  `generic_id` INT(11) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `id` VARCHAR(13) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `total` DOUBLE NOT NULL,
  `vat` DOUBLE NOT NULL,
  `discount` DOUBLE NOT NULL,
  `payable` DOUBLE NOT NULL,
  `paid` DOUBLE NOT NULL,
  `returned` DOUBLE NOT NULL,
  `datetime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `purchase` */

DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
  `id` INT(11) NOT NULL,
  `brand_id` INT(11) NOT NULL,
  `supplier_id` INT(11) DEFAULT NULL,
  `quantity` INT(11) NOT NULL,
  `total` DOUBLE NOT NULL,
  `unit_price` DOUBLE DEFAULT NULL,
  `datetime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `id` INT(11) NOT NULL,
  `purchase_id` INT(11) NOT NULL,
  `location_id` INT(11) DEFAULT NULL,
  `batch_no` VARCHAR(14) NOT NULL,
  `quantity` INT(11) NOT NULL,
  `expired_datetime` DATETIME NOT NULL,
  `datetime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `sale` */

DROP TABLE IF EXISTS `sale`;

CREATE TABLE `sale` (
  `id` INT(11) NOT NULL,
  `invoice_id` VARCHAR(13) NOT NULL,
  `stock_id` INT(11) NOT NULL,
  `quantity` INT(11) NOT NULL,
  `price` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `datetime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `return` */

DROP TABLE IF EXISTS `return`;

CREATE TABLE `return` (
  `id` INT(11) NOT NULL,
  `invoice_id` VARCHAR(13) DEFAULT NULL,
  `purchase_id` INT(11) DEFAULT NULL,
  `total` DOUBLE NOT NULL,
  `wastage` BIT(1) DEFAULT NULL,
  `datetime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(500) NOT NULL,
  `phone` VARCHAR(15) DEFAULT NULL,
  `address` TEXT DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` INT(11) NOT NULL,
  `firstname` VARCHAR(100) NOT NULL,
  `lastname` VARCHAR(100) NOT NULL,
  `username` VARCHAR(40) NOT NULL,
  `email` VARCHAR(40) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `phone` VARCHAR(100) NOT NULL,
  `address` TEXT NOT NULL,
  `active` BIT(1) DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(50) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `user_role` */

CREATE TABLE `user_role` (
  `id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

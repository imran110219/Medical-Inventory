INSERT  INTO `brand`(`id`,`name`,`strength`,`generic_id`,`company_id`,`price`) VALUES 
(1,'1stCef','500 mg',1,2,12.00),
(2,'3-C','200 mg',2,3,35.00),
(3,'3-C','100 mg/5 ml',4,5,195.00),
(4,'3-C','400 mg',1,5,20.00),
(5,'3-F','500 mg',2,4,14.00);

INSERT  INTO `generic`(`id`,`name`) VALUES 
(1,'5-Fluorouracil [5-FU]'),
(2,'Abacavir + Lamivudine + Zidovudine'),
(3,'Abiraterone Acetate'),
(4,'Acarbose'),
(5,'Aceclofenac');

INSERT  INTO `indication_generic`(`id`,`indication_id`,`generic_id`) VALUES 
(1,'1','1'),
(2,'2','2'),
(3,'1','3'),
(4,'1','4'),
(5,'3','2');


INSERT  INTO `company`(`id`,`name`) VALUES 
(1,'Abbott Laboratories'),
(2,'ACI Limited'),
(3,'ACME Laboratories Ltd.'),
(4,'Ad-din pharmaceuticals Ltd.'),
(5,'Aexim Pharmaceuticals Ltd.');

INSERT  INTO `indication`(`id`,`name`) VALUES 
(1,'Abdominal pain'),
(2,'Abortion'),
(3,'Abrasion'),
(4,'Abscesses'),
(5,'Absence seizures');

INSERT  INTO `user`(`id`,`firstname`,`lastname`,`username`,`email`,`password`,`phone`,`address`,`active`) VALUES
(1,'John','Player','john','john@gmail.com','123456','01912070224','Dhaka',''),
(2,'Sadman','Sobhan','imran','imran@gmail.com','123456','01912070224','Dhaka',''),
(3,'Md','Amin','amin','amin@gmail.com','123456','01912070224','Dhaka','');

INSERT  INTO `user_role`(`id`,`user_id`,`role_id`) VALUES
(1,'1','1'),
(2,'2','1'),
(3,'3','1');

INSERT INTO `invoice` (`id`, `user_id`, `total`, `vat`, `discount`, `payable`, `paid`, `returned`, `datetime`) VALUES
('1491729973342', 2, 760, 19, 5, 774, 800, 26, '2017-01-09 15:26:13'),
('1491730560516', 2, 370, 9.25, 5, 374.25, 375, 0.75, '2017-01-09 15:36:00'),
('1492165305284', 2, 270, 6.75, 5, 271.75, 280, 8.25, '2017-01-14 16:21:45'),
('1492189349464', 2, 490, 12.25, 5, 497.25, 500, 2.75, '2017-02-14 23:02:29'),
('1492189946488', 2, 190, 4.75, 5, 189.75, 200, 10.25, '2017-02-14 23:12:26');

insert  into `supplier`(`id`,`name`,`phone`,`address`) values
(1,'Maruf Hossain','01911202020','Dhaka'),
(2,'Ali Hasan','01711303030','Dhaka'),
(3,'Mohiuddin Jahangir','01811404040','Dhaka'),
(4,'Ali Banat','01611808080','Dhaka');

insert  into `purchase`(`id`,`brand_id`,`supplier_id`,`quantity`,`total`,`unit_price`,`datetime`) values
(1,1,1,10,90,9,'2021-02-02 15:22:02'),
(2,2,2,5,500,100,'2021-02-02 15:22:24'),
(3,3,3,20,2000,100,'2021-02-02 15:23:00'),
(4,4,3,30,3000,100,'2021-02-02 15:23:23'),
(5,1,2,20,100,5,'2021-02-02 15:24:24'),
(6,3,1,55,330,6,'2021-02-02 15:25:30');

insert  into `stock`(`id`,`purchase_id`,`quantity`,`expired_datetime`,`datetime`) values
(1,1,10,'2021-11-24 15:41:30','2021-02-03 15:41:43'),
(2,2,5,'2022-01-02 15:41:59','2021-02-03 15:42:12'),
(3,3,20,'2021-11-25 15:42:36','2021-02-03 15:42:44'),
(4,4,30,'2021-11-25 15:43:05','2021-02-03 15:43:14'),
(5,5,20,'2021-12-15 15:43:34','2021-02-03 15:43:44'),
(6,6,55,'2021-11-24 15:43:59','2021-02-03 15:44:08');

insert  into `sale`(`id`,`invoice_id`,`brand_id`,`quantity`,`price`,`total`,`datetime`) values
(1,'1491729973342',1,1,10,10,'2021-02-02 15:28:26'),
(2,'1491729973342',2,2,40,80,'2021-02-02 15:30:07'),
(3,'1492165305284',1,1,10,10,'2021-02-02 15:28:26'),
(4,'1492165305284',2,2,40,80,'2021-02-02 15:30:07'),
(5,'1492189349464',1,1,10,10,'2021-02-02 15:28:26'),
(6,'1492189349464',2,2,40,80,'2021-02-02 15:30:07'),
(7,'1492189946488',1,1,10,10,'2021-02-02 15:28:26'),
(8,'1492189946488',2,2,40,80,'2021-02-02 15:30:07'),
(9,'1491730560516',2,2,40,80,'2021-02-02 15:30:07'),
(10,'1491730560516',3,2,5,10,'2021-02-02 15:31:14');
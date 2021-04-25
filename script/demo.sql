INSERT  INTO `brand`(`id`,`name`,`strength`,dosage_form_id,`generic_id`,`manufacturer_id`,`purchase_price`,`sale_price`) VALUES
(1,'1stCef','500 mg',1,1,2,12.00,20.00),
(2,'3-C','200 mg',2,2,3,35.00,50.00),
(3,'3-C','100 mg/5 ml',3,4,5,195.00,300.00),
(4,'3-C','400 mg',1,1,5,20.00,30.00),
(5,'3-F','500 mg',2,2,4,14.00,30.00);

INSERT  INTO `dosage_form`(`id`,`name`) VALUES
(1,'Capsule'),
(2,'Gel'),
(3,'IM Injection'),
(4,'IV Infusion'),
(5,'IV Injection'),
(6,'Ophthalmic Ointment');

INSERT  INTO `location`(`id`,`name`) VALUES
(1,'Shelf A'),
(2,'Shelf B'),
(3,'Shelf C'),
(4,'Shelf D'),
(5,'Shelf E');

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

INSERT  INTO `manufacturer`(`id`,`name`) VALUES
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
(1,'John','Player','john','john@gmail.com','$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG','01912070224','Dhaka',''),
(2,'Sadman','Sobhan','imran','imran@gmail.com','$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG','01912070224','Dhaka',''),
(3,'Md','Amin','amin','amin@gmail.com','$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG','01912070224','Dhaka',''),
(4,'Md','Masud','masud','masud@gmail.com','$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG','01912070224','Dhaka',''),
(5,'Md','Atik','atik','atik@gmail.com','$2a$10$pGv5BjUq367eFin.vgvPeugs3ugRywvlveGVZAdZidkXF2WBa0sHG','013258965','Test',''),
(6,'Md','Rahim','rahim','rahim@gmail.com','$2a$10$WtZSoxojxPih9upyYS5teu6jcEwLZJpgIleWZDiuzIW8cdf6jYE2O','01912070224','Test','');

INSERT  INTO `role`(`id`,`name`) VALUES
(1,'SUPER_ADMIN'),
(2,'ADMIN'),
(3,'USER');

INSERT  INTO `user_role`(`id`,`user_id`,`role_id`) VALUES
(1,'1','1'),
(2,'2','2'),
(3,'3','3'),
(4,'4','1'),
(5,'5','2'),
(6,'6','3');

INSERT INTO `sale_invoice` (`id`, `user_id`, `total`, `vat`, `discount`, `payable`, `paid`, `returned`, `datetime`) VALUES
('SI1618989514455', 2, 760, 19, 5, 774, 800, 26, '2017-01-09 15:26:13');

INSERT INTO `purchase_invoice` (`id`, `supplier_id`, `total`, `vat`, `discount`, `payable`, `paid`, `returned`, `datetime`) VALUES
('PI1618989514455', 2, 760, 19, 5, 774, 800, 26, '2017-01-09 15:26:13');

INSERT  INTO `supplier`(`id`,`name`,`phone`,`address`) VALUES
(1,'Maruf Hossain','01911202020','Dhaka'),
(2,'Ali Hasan','01711303030','Dhaka'),
(3,'Mohiuddin Jahangir','01811404040','Dhaka'),
(4,'Ali Banat','01611808080','Dhaka');


INSERT  INTO `purchase`(`id`,`brand_id`,`purchase_invoice_id`,`batch_no`,`box_id`,`quantity`,`total`,`unit_price`,`expiry_datetime`,`datetime`) VALUES
(1,1,'PI1618989514455','B1491729973342',1,10,90,9,'2022-01-02 15:41:59','2021-02-02 15:22:02'),
(2,2,'PI1618989514455','B1491729973342',2,,5,500,100,'2022-01-02 15:41:59','2021-02-02 15:22:02'),
(3,3,'PI1618989514455','B1491729973342',3,,20,2000,100,'2022-02-02 15:23:00','2021-02-02 15:22:02'),
(4,4,'PI1618989514455','B1491729973342',1,,30,3000,100,'2022-02-02 15:23:23','2021-02-02 15:22:02'),
(5,1,'PI1618989514455','B1491729973342',2,20,100,5,'2022-02-02 15:24:24','2021-02-02 15:22:02'),
(6,3,'PI1618989514455','B1491729973342',3,55,330,6,'2022-02-02 15:25:30','2021-02-02 15:22:02');

INSERT  INTO `stock`(`id`,`purchase_id`,`location_id`,`quantity`,`datetime`) VALUES
(1,1,1,10,'2021-02-03 15:41:43'),
(2,2,2,5,'2021-02-03 15:42:12'),
(3,3,3,20,'2021-02-03 15:42:44'),
(4,4,4,30,'2021-02-03 15:43:14'),
(5,5,5,20,'2021-02-03 15:43:44'),
(6,6,5,55,'2021-02-03 15:44:08');

INSERT  INTO `sale`(`id`,`sale_invoice_id`,`stock_id`,`quantity`,`unit_price`,`discount`,`total`,`datetime`) VALUES
(1,'SI1618989514455',1,1,10,0,10,'2021-02-02 15:28:26');


INSERT  INTO `returned`(`id`,`sale_invoice_id`,`purchase_invoice_id`,`quantity`,`unit_price`,`deduction`,`total`,`wastage`,`datetime`) VALUES 
(1,'SI1618989514455',NULL,5,5,5,555,'','2021-04-24 14:41:14'),
(2,NULL,'PI1618989514455',5,5,5,555,'','2021-04-24 14:48:30');












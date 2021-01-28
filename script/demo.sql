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

INSERT INTO `invoice` (`id`, `user_id`, `total`, `vat`, `discount`, `payable`, `paid`, `returned`, `datetime`) VALUES
('1491729973342', 2, 760, 19, 5, 774, 800, 26, '2017-01-09 15:26:13'),
('1491730560516', 2, 370, 9.25, 5, 374.25, 375, 0.75, '2017-01-09 15:36:00'),
('1492165305284', 2, 270, 6.75, 5, 271.75, 280, 8.25, '2017-01-14 16:21:45'),
('1492189349464', 2, 490, 12.25, 5, 497.25, 500, 2.75, '2017-02-14 23:02:29'),
('1492189946488', 2, 190, 4.75, 5, 189.75, 200, 10.25, '2017-02-14 23:12:26');



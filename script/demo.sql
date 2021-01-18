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



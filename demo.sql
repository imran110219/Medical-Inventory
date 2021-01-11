INSERT  INTO `brand`(`id`,`name`,`strength`,`generic`,`company`,`price`) VALUES 
(1,'1stCef','500 mg','259','92','Unit Price : ? 12.00'),
(2,'3-C','200 mg','265','48','Unit Price : ? 35.00'),
(3,'3-C','100 mg/5 ml','265','48','100 ml bottle : ? 195.00'),
(4,'3-C','400 mg','265','48','Unit Price : ? 48.00'),
(5,'3-F','500 mg','834','48','Unit Price : ? 14.00');

INSERT  INTO `generic`(`id`,`name`) VALUES 
(1,'5-Fluorouracil [5-FU]'),
(2,'Abacavir + Lamivudine + Zidovudine'),
(3,'Abiraterone Acetate'),
(4,'Acarbose'),
(5,'Aceclofenac');

INSERT  INTO `indication_generic`(`id`,`indication`,`generic`) VALUES 
(1,'1','1'),
(2,'2','2'),
(3,'1','3'),
(4,'1','4');


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

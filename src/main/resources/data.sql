
INSERT INTO `design_type` VALUES ('Broderie'),('Autocollant'),('Peinture');

INSERT INTO `design` VALUES (1,'Noir','Basquiat',4.99,'Peinture');
INSERT INTO `design` VALUES (2,'Rose','Fleurs',5.99,'Broderie');
INSERT INTO `design` VALUES (3,'Rouge','Hourloupe',3.99,'Autocollant');
INSERT INTO `design` VALUES (4,'Marron','Petit Ours Brun',3.99,'Broderie');
INSERT INTO `design` VALUES (5,'Vert','Joconde',6.99,'Peinture');
INSERT INTO `design` VALUES (6,'Blanc','Will Smith',5.99,'Broderie');
INSERT INTO `design` VALUES (7,'Blanc','Daniel Craig',5.99,'Broderie');

INSERT INTO `location` VALUES ('Centre avant'),('Centre dos'),('Epaule gauche'),('Epaule droite'),('Poche avant droite'),('Poche avant gauche'),('Poche arrière droite'),('Poche arrière gauche'),('Genou droit'),('Genou gauche');
INSERT INTO `product_type` VALUES ('Manteaux & Vestes'),('Pulls'),('Chemises'),('T-Shirts'),('Pantalons'),('Jeans'),('Accessoires');
INSERT INTO `location_product_type` VALUES ('Centre avant','T-Shirts'),('Centre dos','T-Shirts'),('Epaule droite','T-Shirts'),('Epaule gauche','T-Shirts'),('Centre avant','Chemises'),('Centre dos','Chemises'),('Epaule droite','Chemises'),('Epaule gauche','Chemises'),('Centre avant','Pulls'),('Centre dos','Pulls'), ('Epaule droite','Pulls'),('Epaule gauche','Pulls'),('Centre avant','Manteaux & Vestes'),('Centre dos','Manteaux & Vestes'),('Epaule droite','Manteaux & Vestes'),('Epaule gauche','Manteaux & Vestes'),('Poche avant droite','Jeans'),('Poche avant gauche','Jeans'),('Poche arriere droite','Jeans'),('Poche arriere gauche','Jeans'),('Poche avant droite','Pantalons'),('Poche avant gauche', 'Pantalons'),('Poche arriere droite','Pantalons'),('Poche arriere gauche','Pantalons');

INSERT INTO `size` VALUES ('XS'),('S'),('M'),('L'),('XL'),('XXL'),('34'),('36'),('38'),('40'),('42'),('44'),('Taille unique');

INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (1,NULL,'Pull col rond',49.99,'2021-01-01','2021-03-01','SS20Pu001','Pulls');
INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (2,'Vous protège du vent et de la pluie pour vous garder au sec. Une parka confortable et fonctionnelle qui vous offre une grande liberté de mouvement.','Parka',89.99,'2021-01-01',null,'FW21MV005','Manteaux & Vestes');
INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (3,'Ce pantalon vous offre un confort et une légèreté exceptionnels. Un modèle idéal pour vous suivre dans vos activités quotidiennes.','Pantalon',44.99,'2021-02-01',null,'SS21Pa021','Pantalons');
INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (4,'Ce pull est confectionné en laine mérinos, une matière élégante et douce très appréciée à travers le monde.','Pull Col Roulé',34.99,'2021-02-01',null,'FW21Pu006','Pulls');
INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (5,'Variez vos looks avec cette chemise oversize, en la portant comme une chemise classique ou comme une surchemise.','Chemise Epaisse',49.99,'2021-02-01',null,'SS21C023','Chemises');
INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (6,'Conçue dans un souci de perfection, cette pièce apparemment simple est aussi exceptionnelle que durable.','T-Shirt',15.99,'2021-02-01',null,'SS21T056','T-Shirts');

INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (7,'Optez pour un look délicieusement décadent avec ce jean denim overwear, mais surtout overpriced.','Jean overwear "Top Notch"',189.99,'2021-02-03',null,'PQ11UN37','Jeans');
INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (8,'Seuls des doigts enfantins arrivent à un niveau de finesse de couture aussi exigeant.','Pull "Sweat$hop Boys"',124.99,'2021-03-21',null,'SW37CN22','Pulls');
INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (9,'Ce pantalon fera de vous la star de tous vos déplacements en métro, Uber, tuk-tuk et autres voitures de sport écoresponsables.','Pantalon "On the move"',229.99,'2021-03-27',null,'SH12IT34','Pantalons');
INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (10,'Ne portez plus rien lors de vos sorties emplettes & co à part ce manteau qui sent bon la toile cirée et le désert médical.','Manteau "Made for marché"',459.99,'2021-04-02',null,'FU45CK90','Manteaux & Vestes');
INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (11,'Cette saison, les riches se déguisent en pauvres ! Votez rigolo, votez prolo avec ce t-shirt cousu, pour plus de réalisme, par de vrais pauvres.','T-shirt "Spare Change"',119.99,'2021-04-11',null,'SC77UI01','T-Shirts');
INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (12,'Avec cette chemise, vous n''êtes pas prêts de manger votre goûter à la récré ! Son matériau anti-transpirant vous garantit un confort sur la durée lors de vos accélérations, esquives et autres pratiques physiques récréatives.','Chemise "Fric & geeks"',149.99,'2021-04-16',null,'LE80LO55','Chemises');
INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (13,'Telle une DeLorean, ce Fedora overwear vous ramène à la douce époque des L5 et de Benoit Tourne-Toi ! Un look à consommer sans modération.','Fedora "Back To The Futile"',399.99,'2021-05-02',null,'OU74TIM3','Accessoires');
INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (14,'Gardez le contrôle en milieu urbain avec cet attrape-rêves portatif en mode necklace feel the mood.','Collier "Dreamcatcheur"',119.99,'2021-05-07',null,'EX7AZ33','Accessoires');
INSERT INTO `productWS_db`.`cloth` (`id`,`description`,`name`,`price`,`ref_creation_date`,`ref_deletion_date`,`reference`,`product_type_name`) VALUES (15,'Qui pensait qu''un carton de déménagement collé à un skateboard susciterait tant de convoitises ? Ce cabas DIY en mode purse new-age vous suivra dans vos shopping sprees ou brunches gazon overcrowd au Champ-de-Mars.','Planche à roulettes "Rock the cabas"',279.99,'2021-05-12',null,'GE741D5','Accessoires');

INSERT INTO `stock` VALUES (1,0,1,'XS'),(2,0,1,'S'),(3,0,1,'M'),(4,0,1,'L'),(5,0,1,'XL'),(6,0,1,'XXL');
INSERT INTO `stock` VALUES (7,1,2,'XS'),(8,0,2,'S'),(9,2,2,'M'),(10,0,2,'L'),(11,1,2,'XL'),(12,0,2,'XXL');
INSERT INTO `stock` VALUES (13,1,3,'34'),(14,4,3,'36'),(15,0,3,'38'),(16,5,3,'40'),(17,5,3,'42'),(18,0,3,'44');
INSERT INTO `stock` VALUES (19,1,4,'XS'),(20,0,4,'S'),(21,0,4,'M'),(22,0,4,'L'),(23,1,4,'XL'),(24,0,4,'XXL');
INSERT INTO `stock` VALUES (25,0,5,'XS'),(26,0,5,'S'),(27,0,5,'M'),(28,0,5,'L'),(29,0,5,'XL'),(30,0,5,'XXL');
INSERT INTO `stock` VALUES (31,5,6,'XS'),(32,5,6,'S'),(33,5,6,'M'),(34,5,6,'L'),(35,5,6,'XL'),(36,5,6,'XXL');
INSERT INTO `stock` VALUES (37,10,7,'XS'),(38,8,7,'S'),(39,7,7,'M'),(40,8,7,'L'),(41,9,7,'XL'),(42,10,7,'XXL');
INSERT INTO `stock` VALUES (43,9,8,'XS'),(44,8,8,'S'),(45,7,8,'M'),(46,8,8,'L'),(47,8,8,'XL'),(48,9,8,'XXL');
INSERT INTO `stock` VALUES (49,10,9,'XS'),(50,8,9,'S'),(51,7,9,'M'),(52,8,9,'L'),(53,9,9,'XL'),(54,9,9,'XXL');
INSERT INTO `stock` VALUES (55,6,10,'XS'),(56,7,10,'S'),(57,5,10,'M'),(58,7,10,'L'),(59,8,10,'XL'),(60,8,10,'XXL');
INSERT INTO `stock` VALUES (61,8,11,'XS'),(62,7,11,'S'),(63,7,11,'M'),(64,7,11,'L'),(65,8,11,'XL'),(66,9,11,'XXL');
INSERT INTO `stock` VALUES (67,10,12,'XS'),(68,6,12,'S'),(69,5,12,'M'),(70,6,12,'L'),(71,7,12,'XL'),(72,7,12,'XXL');
INSERT INTO `stock` VALUES (75,7,13,'Taille unique');
INSERT INTO `stock` VALUES (81,9,14,'Taille unique');
INSERT INTO `stock` VALUES (87,8,15,'Taille unique');

INSERT INTO `photo` VALUES (1,'manteau_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/MANTEAU_CAPUCHE_1.jpg');
INSERT INTO `photo` VALUES (2,'manteau_detail_1','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/MANTEAU_CAPUCHE_2.jpg');
INSERT INTO `photo` VALUES (3,'manteau_detail_2','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/MANTEAU_CAPUCHE_3.jpg');
INSERT INTO `photo` VALUES (4,'manteau_detail_3','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/MANTEAU_CAPUCHE_4.jpg');
INSERT INTO `photo` VALUES (5,'pantalon_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/PANTALON_1.jpg');
INSERT INTO `photo` VALUES (6,'pantalon_detail_beige','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/PANTALON_BEIGE_1.jpg');
INSERT INTO `photo` VALUES (7,'col_roule_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/PULL_COL_ROULE_1.jpg');
INSERT INTO `photo` VALUES (8,'col_roule_detail_1','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/PULL_COL_ROULE_2.jpg');
INSERT INTO `photo` VALUES (9,'col_rond_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/PULL_COLROND_1.jpg');
INSERT INTO `photo` VALUES (10,'col_rond_detail','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/PULL_COLROND_2.jpg');
INSERT INTO `photo` VALUES (11,'surchemise_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/SURCHEMISE_1.jpg');
INSERT INTO `photo` VALUES (12,'surchemise_detail_1','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/SURCHEMISE_2.jpg');
INSERT INTO `photo` VALUES (13,'surchemise_detail_2','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/SURCHEMISE_3.jpg');
INSERT INTO `photo` VALUES (14,'tshirt_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/T-SHIRT_1.jpg');
INSERT INTO `photo` VALUES (15,'tshirt_detail','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/T-SHIRT_2.jpg');
INSERT INTO `photo` VALUES (16,'basquiat_dino','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/design/BASQUIAT.jpg');
INSERT INTO `photo` VALUES (17,'broderie_fleurs','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/design/FLEURS.jpg');
INSERT INTO `photo` VALUES (18,'dubuffet_hourloupe','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/design/HOURLOUPE.jpg');
INSERT INTO `photo` VALUES (19,'pantalon_detail','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/PANTALON_2.jpg');
INSERT INTO `photo` VALUES (20,'top_notch_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/TOP_NOTCH_1.jpg');
INSERT INTO `photo` VALUES (21,'sweat_shop_boys_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/SWEAT$HOP_BOYS_1.jpg');
INSERT INTO `photo` VALUES (22,'on_the_move_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/ON_THE_MOVE_1.jpg');
INSERT INTO `photo` VALUES (23,'on_the_move_profil','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/ON_THE_MOVE_2.jpg');
INSERT INTO `photo` VALUES (24,'made_for_marche_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/MADE_FOR_MARCHE_1.jpg');
INSERT INTO `photo` VALUES (25,'spare_change_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/SPARE_CHANGE_1.jpg');
INSERT INTO `photo` VALUES (26,'fric_and_geeks_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/FRIC_AND_GEEKS_1.jpg');
INSERT INTO `photo` VALUES (27,'fric_and_geeks_details','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/FRIC_AND_GEEKS_2.jpg');
INSERT INTO `photo` VALUES (28,'back_to_the_futile_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/BACK_TO_THE_FUTILE_1.jpg');
INSERT INTO `photo` VALUES (29,'back_to_the_futile_arriere','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/BACK_TO_THE_FUTILE_2.jpg');
INSERT INTO `photo` VALUES (30,'dreamcatcheur_face','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/DREAMCATCHEUR_1.jpg');
INSERT INTO `photo` VALUES (31,'rock_the_cabas_vue_globale','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/product/ROCK_THE_CABAS_1.jpg');
INSERT INTO `photo` VALUES (32,'joconde_fail','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/design/JOCONDE.jpg');
INSERT INTO `photo` VALUES (33,'petit_ours_brun','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/design/PETIT_OURS_BRUN.jpg');
INSERT INTO `photo` VALUES (34,'will_smith','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/design/WILL_SMITH.jpg');
INSERT INTO `photo` VALUES (35,'daniel_craig','https://eql-favorite.s3.eu-west-3.amazonaws.com/static/photos/design/DANIEL_CRAIG.jpg');

INSERT INTO `design_photo` VALUES (1,16),(2,17),(3,18),(4,33),(5,32),(6,34),(7,35);

INSERT INTO `cloth_photo` VALUES (1,9),(1,10),(2,1),(2,2),(2,3),(2,4),(3,5),(3,6),(4,7),(4,8),(5,11),(5,12),(5,13),(6,14),(6,15),(7,20),(8,21),(9,22),(9,23),(10,24),(11,25),(12,26),(12,27),(13,28),(13,29),(14,30),(15,31);
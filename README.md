Canteen Spring Boot project.

A projekt célja, hogy ügyfelek rendeléseit tudja kezelni és tárolni adatbázisban.

Az ügyfelek a frontenden termék-rendeléseket adhatnak le - egyszerre több terméket rendelhetnek és megadhatják a rendelt termékek mennyiségét.

Ennek megfelelően ügyfél (Client) és termék (Product) adatokat kell elsősorban kezelnünk. Ezen kívül rendeléseket (Purchase) és a hozzájuk tartozó rendelési tételeket (PurchaseItems) kezeljük és tároljuk. Egy rendelés során rögzítjük, hogy mely ügyfél a megrendelő, mely termékek kerülnek be a rendelésbe és milyen mennyiségben - a PurchaseItems objektumokban kezeljük azt, hogy egy adott termékből mekkora mennyiséget rendelt meg a vásárló egy adott vásárlás keretében.   


SQL Scripts: 

CREATE DATABASE `canteen` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci */;

CREATE TABLE `canteen`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;

CREATE TABLE `canteen`.`product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;

CREATE TABLE `purchase` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `purchase_date` date DEFAULT NULL,
  `client_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_purchase_client` (`client_id`),
  CONSTRAINT `fk_purchase_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

CREATE TABLE `purchase_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `qty` int(11) DEFAULT NULL,
  `product_id` bigint(20) NOT NULL,
  `purchase_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_purchaseitem_purchase` (`purchase_id`),
  KEY `fk_purchaseitem_product_idx` (`product_id`),
  CONSTRAINT `fk_purchaseitem_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_purchaseitem_purchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

INSERT INTO `canteen`.`client` VALUES (1,'Ede'),(2,'Aba'),(3,'Huba');

INSERT INTO `canteen`.`product` VALUES (1,'zsemle',35),(2,'kifli',40),(3,'vaj',300),(4,'tejföl',150);




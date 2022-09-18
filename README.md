# canteen
Canteen Spring Boot project 
A projekt része ügyfelek és termékek tárolása.
Az ügyfelek a frontenden termék-rendeléseket adhatnak le - egyszerre több terméket rendelhetnek és megadhatják a rendelt termékek mennyiségét.
A rendeléseket adatbázisban tároljuk - és havi szintű riportokat kell tudnunk generálni a termékek fogyásáról és az ügyfelek fogyasztásáról.

SQL Scripts: 

CREATE TABLE `canteen`.`client` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;

CREATE TABLE `canteen`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `productname` VARCHAR(45) NULL,
  `productprice` INT NULL,
  PRIMARY KEY (`id`))
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


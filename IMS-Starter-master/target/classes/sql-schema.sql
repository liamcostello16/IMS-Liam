drop schema ims;


CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);



CREATE TABLE IF NOT EXISTS `ims`.`item` (
`item_id` int(11) NOT NULL AUTO_INCREMENT,
 `item_name` char(50) NOT NULL,
`total` int(11) NOT NULL,
PRIMARY KEY (`item_id`)
);


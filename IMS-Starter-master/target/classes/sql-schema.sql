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

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
`Order_ID` int(11) NOT NULL AUTO_INCREMENT,
`Customer_ID` int(50) NOT NULL,
PRIMARY KEY (`Order_ID`)
);

CREATE TABLE IF NOT EXISTS `ims`.`ordersI` (
`OrderI_ID` int(11) NOT NULL AUTO_INCREMENT,
 `Item_key` int(50) NOT NULL,
 `OrderID` int(50) NOT NULL,
PRIMARY KEY (`OrderI_ID`)
);

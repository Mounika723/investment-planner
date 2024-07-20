CREATE TABLE customer
(
 customerName varchar(100) NOT NULL,
 customerId varchar(11) NOT NULL ,
 customerAddress varchar(100) DEFAULT NULL,
 customerEmail varchar(100) DEFAULT NULL,
 PRIMARY KEY (customerId)
);
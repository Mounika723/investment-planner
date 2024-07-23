CREATE TABLE customer
(
 customerName varchar(100) NOT NULL,
 customerId varchar(11) NOT NULL ,
 customerAddress varchar(100) DEFAULT NULL,
 customerEmail varchar(100) DEFAULT NULL,
 PRIMARY KEY (customerId)
);

select * from  customerTransactionLogging;

insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','10000','Shopping','inorbit','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','15000','Shopping','panthaloons','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','20000','Shopping','mobilestore','2023-10-10','2023-10-10');


insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','1000','food','kfc','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','1000','food','pizzahut','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','2000','food','restaurent','2023-10-10','2023-10-10');


insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','1000','entertinement','theatre','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','500','entertinement','concert','2023-10-10','2023-10-10');

insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','4500','other','goibibo','2023-10-10','2023-10-10');


CREATE TABLE customerTransactionLogging
(
 customerId varchar(11) NOT NULL ,
 expenseAmount numeric(13),
 typeOfExpense varchar(20),
 expenseSubType varchar(255),
 createdDate date,
 updatedDate date
);

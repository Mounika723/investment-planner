insert into customer(customerId, customerName , customerAddress,customerEmail) values('1','Jack','USA','jack@gmail.com');

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

select typeOfExpense, sum(expenseAmount) expenseAmount from customerTransactionLogging where customerId='1' group by typeOfExpense;



insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','10000','Mutual Funds','Mutual Funds1','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','20000','Mutual Funds','Mutual Funds2','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','25000','Mutual Funds','Mutual Funds3','2023-10-10','2023-10-10');


insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','1000','Equity','Equity1','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','1000','Equity','Equity2','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','2000','Equity','Equity3','2023-10-10','2023-10-10');

insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','10000','SIP','SIP1','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','15000','SIP','SIP2','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','20000','SIP','SIP3','2023-10-10','2023-10-10');


insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','1000','Retirement Plan','Retirement Plan1','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','1000','Retirement Plan','Retirement Plan2','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','2000','Retirement Plan','Retirement Plan3','2023-10-10','2023-10-10');

insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','10000','Health','Health','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','15000','Health','Health','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','20000','Health','Health','2023-10-10','2023-10-10');

insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','10000','Term','Term','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','15000','Term','Term','2023-10-10','2023-10-10');
insert into customerTransactionLogging (customerid,expenseamount,typeofexpense,expensesubtype,createddate,updateddate) values ('1','20000','Term','Term','2023-10-10','2023-10-10');


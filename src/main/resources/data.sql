insert into users (customerid,username,email,password) values ('123456789','Mounika','maddineni.mouni@gmail.com','cGFzc3dvcmQ=');

insert into users (customerid,username,email,password) values ('987654321','Mounika1','Mounika1','cGFzc3dvcmQ=');

===============================

insert into customer_transaction_logging (ID,Customer_ID,Category,Category_Sub_Type,Category_Vendor,spend_percentage,Amount,created_date,	updated_date,	createdBy,	updatedBy)
values ('1','	123456789','	Expense','	Shopping','	Myntra','	2','	200','	24-07-2024','	24-07-2024','	user','	user'),
('2','123456789','Expense','Shopping','Amazon','3','300','24-07-2024','24-07-2024','user','user'),
('3','123456789','Expense','Shopping','Flipkart','5','500','24-07-2024','24-07-2024','user','user'),
('4','123456789','Expense','Entertainment','PVR','20','2000','24-07-2024','24-07-2024','user','user'),
('5','123456789','Expense','Entertainment','INOX','10','1000','24-07-2024','24-07-2024','user','user'),
('6','123456789','Expense','Entertainment','NETFLIX','10','1000','24-07-2024','24-07-2024','user','user'),
('7','123456789','Expense','Food','Zomato','10','1000','24-07-2024','24-07-2024','user','user'),
('8','123456789','Expense','Food','Swiggy','10','1000','24-07-2024','24-07-2024','user','user'),
('9','123456789','Expense','Food','Restaurent','10','1000','24-07-2024','24-07-2024','user','user'),
('10','123456789','Expense','Holiday','MakeMyTrip','20','2000','24-07-2024','24-07-2024','user','user'),
('11','987654321','Expense','Shopping','Amazon','20','2000','24-07-2024','24-07-2024','user','user'),
('12','987654321','Expense','Entertainment','Movies','30','3000','24-07-2024','24-07-2024','user','user'),
('13','987654321','Expense','Food','KFC','20','2000','24-07-2024','24-07-2024','user','user'),
('14','987654321','Expense','Holiday','Bali','30','3000','24-07-2024','24-07-2024','user','user'),
('15','123456789','Income','Salary','''','100','20000','24-07-2024','24-07-2024','user','user'),
('16','987654321','Income','Salary','''','100','40000','24-07-2024','24-07-2024','user','user'),
('17','123456789','Investment','Mutual Funds','''','10','1000','24-07-2024','24-07-2024','user','user'),
('18','123456789','Investment','Equity','''','40','4000','24-07-2024','24-07-2024','user','user'),
('19','123456789','Investment','SIP','''','20','2000','24-07-2024','24-07-2024','user','user'),
('20','123456789','Investment','Retirement Plan','''','10','1000','24-07-2024','24-07-2024','user','user'),
('21','123456789','Investment','Health','''','10','1000','24-07-2024','24-07-2024','user','user'),
('22','123456789','Investment','Term','''','10','1000','24-07-2024','24-07-2024','user','user'),
('23','987654321','Investment','Mutual Funds','''','10','3000','24-07-2024','24-07-2024','user','user'),
('24','987654321','Investment','Equity','''','20','6000','24-07-2024','24-07-2024','user','user'),
('25','987654321','Investment','SIP','''','20','6000','24-07-2024','24-07-2024','user','user'),
('26','987654321','Investment','Retirement Plan','''','20','6000','24-07-2024','24-07-2024','user','user'),
('27','987654321','Investment','Health','''','20','6000','24-07-2024','24-07-2024','user','user'),
('28','987654321','Investment','Term','''','10','3000','24-07-2024','24-07-2024','user','user')

=================================

insert into customer_trends (ID,	Customer_ID,	Category,	Category_Sub_Type,	Spend_Percentage,	Spend_Amount,	created_date,	updated_date,	createdBy,	updatedBy) values
('1','123456789','Expense','Shopping','10','0','24-07-2024','24-07-2024','user','user'),
('2','123456789','Expense','Entertainment','40','0','24-07-2024','24-07-2024','user','user'),
('3','123456789','Expense','Food','30','0','24-07-2024','24-07-2024','user','user'),
('4','123456789','Expense','Holiday','20','0','24-07-2024','24-07-2024','user','user'),
('5','123456789','Expenditure','TotalIncome','100','0','24-07-2024','24-07-2024','user','user'),
('6','123456789','Expenditure','Expenses','30','0','24-07-2024','24-07-2024','user','user'),
('7','123456789','Expenditure','Investment','70','0','24-07-2024','24-07-2024','user','user'),
('8','123456789','Investment','Mutual Funds','10','0','24-07-2024','24-07-2024','user','user'),
('9','123456789','Investment','Equity','40','0','24-07-2024','24-07-2024','user','user'),
('10','123456789','Investment','SIP','20','0','24-07-2024','24-07-2024','user','user'),
('11','123456789','Investment','Retirement Plan','10','0','24-07-2024','24-07-2024','user','user'),
('12','123456789','Investment','Health','10','0','24-07-2024','24-07-2024','user','user'),
('13','123456789','Investment','Term','10','0','24-07-2024','24-07-2024','user','user'),
('14','987654321','Expense','Shopping','20','0','24-07-2024','24-07-2024','user','user'),
('15','987654321','Expense','Entertainment','30','0','24-07-2024','24-07-2024','user','user'),
('16','987654321','Expense','Food','20','0','24-07-2024','24-07-2024','user','user'),
('17','987654321','Expense','Holiday','20','0','24-07-2024','24-07-2024','user','user'),
('18','987654321','Expenditure','TotalIncome','100','0','24-07-2024','24-07-2024','user','user'),
('19','987654321','Expenditure','Expenses','50','0','24-07-2024','24-07-2024','user','user'),
('20','987654321','Expenditure','Investment','50','0','24-07-2024','24-07-2024','user','user'),
('21','987654321','Investment','Mutual Funds','10','0','24-07-2024','24-07-2024','user','user'),
('22','987654321','Investment','Equity','20','0','24-07-2024','24-07-2024','user','user'),
('23','987654321','Investment','SIP','20','0','24-07-2024','24-07-2024','user','user'),
('24','987654321','Investment','Retirement Plan','20','0','24-07-2024','24-07-2024','user','user'),
('25','987654321','Investment','Health','20','0','24-07-2024','24-07-2024','user','user'),
('26','987654321','Investment','Term','10','0','24-07-2024','24-07-2024','user','user')

============================
insert into overall_trends (ID,	age_range_from,	age_range_to,	income_range_from,	income_range_to,	category,	category_sub_type,	spend_percentage) values

('1','18','25','10000','20000','Expense','Shopping','25'),
('2','18','25','10000','20000','Expense','Entertainment','25'),
('3','18','25','10000','20000','Expense','Food','40'),
('4','18','25','10000','20000','Expense','Holiday','10'),
('5','18','25','10000','20000','Investment','Mutual Funds','25'),
('6','18','25','10000','20000','Investment','Equity','40'),
('7','18','25','10000','20000','Investment','SIP','20'),
('8','18','25','10000','20000','Investment','Retirement Plan','5'),
('9','18','25','10000','20000','Investment','Health','5'),
('10','18','25','10000','20000','Investment','Term','5');

insert into overall_trends (ID,	age_range_from,	age_range_to,	income_range_from,	income_range_to,	category,	category_sub_type,	spend_percentage) values

('11','18','25','10000','20000','Expenditure','Total Income','100'),
('12','18','25','10000','20000','Expenditure','Expenses','30'),
('13','18','25','10000','20000','Expenditure','Investment','70');

=========================================================
insert into invest_guide (id , grow_percentage_from,
 grow_percentage_to ,
 risk_category  ,
 investment_suggestion)values ('1',	'0',	'5'	,'Low',	'100% Fixed Deposit'),
('2',	'6',	'8'	,'Low',	'70% Fixed Deposit and 30 %  Government Bond')

===============================================

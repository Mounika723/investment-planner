CREATE TABLE customer
(
 customerName varchar(100) NOT NULL,
 customerId varchar(11) NOT NULL ,
 customerAddress varchar(100) DEFAULT NULL,
 customerEmail varchar(100) DEFAULT NULL,
 PRIMARY KEY (customerId)
);

CREATE TABLE customerTransactionLogging
(
 customerId varchar(11) NOT NULL ,
 expenseAmount numeric(13),
 typeOfExpense varchar(20),
 expenseSubType varchar(255),
 createdDate date,
 updatedDate date
);

CREATE TABLE IF NOT EXISTS public.expenses_savings
(
    customerid character varying(11) COLLATE pg_catalog."default" NOT NULL,
    expenses character varying(11) COLLATE pg_catalog."default",
    savings character varying(11) COLLATE pg_catalog."default",
    age character varying(3) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT expenses_savings_pkey PRIMARY KEY (customerid)
);

CREATE TABLE IF NOT EXISTS public.expensessavings
(
    customerid character varying(11) COLLATE pg_catalog."default" NOT NULL,
    expenses character varying(11) COLLATE pg_catalog."default",
    savings character varying(11) COLLATE pg_catalog."default",
    age character varying(3) COLLATE pg_catalog."default" NOT NULL,
    income character varying(11) COLLATE pg_catalog."default",
    CONSTRAINT expensessavings_pkey PRIMARY KEY (customerid)
);

CREATE TABLE IF NOT EXISTS public.goal
(
    minincome numeric(13,2),
    maxincome numeric(13,2),
    goalname character varying(100) COLLATE pg_catalog."default",
    suggestions character varying(255) COLLATE pg_catalog."default"
);


CREATE TABLE users
(
 customerid varchar(11) NOT NULL ,
 username varchar(255),
 email varchar(255),
 password varchar(255)
);

CREATE TABLE customer_details
(
 id numeric(15) NOT NULL,
 customer_id varchar(11) NOT NULL ,
 customer_name varchar(100) NOT NULL,
 customer_income numeric(25) NOT NULL,
 customer_age numeric(3) NOT NULL,
 customer_address varchar(100) DEFAULT NULL,
 customer_email varchar(100) DEFAULT NULL,
 created_date date,
 updated_date date,
 PRIMARY KEY (customer_id)
);

CREATE TABLE customer_transaction_logging
(
 id numeric(15) NOT NULL,
 customer_id varchar(11) NOT NULL ,
 category varchar(100) NOT NULL,
 category_sub_type varchar(100) NOT NULL,
 category_Vendor varchar(100) NOT NULL,
 spend_percentage varchar(13),
 amount numeric(25),
 created_date date,
 updated_date date,
 createdBy varchar(50),
 updatedBy varchar(50),
 PRIMARY KEY (id)
);



CREATE TABLE customer_trends
(
 id numeric(15) NOT NULL,
 customer_id varchar(11) NOT NULL ,
 category varchar(100) NOT NULL,
 category_sub_type varchar(100) NOT NULL,
 spend_percentage varchar(13),
 spend_amount numeric(25),
 created_date date,
 updated_date date,
 createdBy varchar(50),
 updatedBy varchar(50),
 PRIMARY KEY (id)
);



CREATE TABLE overall_trends
(
 id numeric(15) NOT NULL,
 age_range_from numeric(3) NOT NULL,
 age_range_to numeric(3) NOT NULL,
 income_range_from numeric(25) NOT NULL,
 income_range_to numeric(25) NOT NULL,
  category varchar(100) NOT NULL,
 category_sub_type varchar(100) NOT NULL,
 spend_percentage varchar(13),
 created_date date,
 updated_date date,
 createdBy varchar(50),
 updatedBy varchar(50),
 PRIMARY KEY (id)
);


CREATE TABLE invest_guide
(
 id numeric(15) NOT NULL,
 grow_percentage_from numeric(3) NOT NULL,
 grow_percentage_to numeric(3) NOT NULL,
 risk_category varchar(25) NOT NULL ,
 investment_suggestion varchar(255) NOT NULL,
 created_date date,
 updated_date date,
 createdBy varchar(25),
 updatedBy varchar(25)
);
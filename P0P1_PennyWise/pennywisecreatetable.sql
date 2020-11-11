--drop table transactions
--drop table card
--drop table account


================================================================
Table create 
================================================================
CREATE TABLE account (
  "account_id" serial,
  "username" varchar(50) NOT NULL,
  "password" varchar(50) NOT NULL,
  "email" varchar(100) NOT NULL,
  "phone_number" varchar(30),
  "first_name" varchar(50),
  "last_name" varchar(50),
  PRIMARY KEY (account_id)
);

CREATE TABLE card (
  "card_id" serial,
  "account_id" int,
  "card_type" varchar(30) NOT NULL,
  "card_holder_name" varchar(50) NOT NULL,
  "card_number" varchar(16) NOT NULL,
  "cvc_code" varchar(3) NOT NULL,
  "card_expiration_date" timestamp NOT NULL,
  PRIMARY KEY (card_id)
);
	ALTER TABLE card ADD CONSTRAINT FK_account_id
	    FOREIGN KEY (account_id)
	   REFERENCES account (account_id) ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE TABLE transaction (
  "transaction_id" serial,
  "card_id" int,
  "transaction_type" varchar(30),
  "name_money_reciever" varchar(50),
  "transaction_time_stamp" timestamp,
  "phone_number" varchar(30) NOT NULL,
  "withdraws" numeric(9, 2),
  PRIMARY KEY (transaction_id)
);
	ALTER TABLE transaction ADD CONSTRAINT FK_card_id
	    FOREIGN KEY (card_id)
	   REFERENCES card (card_id) ON DELETE NO ACTION ON UPDATE NO ACTION;

================================================================
Table inserts 
================================================================


insert into account(account_id, username, password, email, phone_number, first_name, last_name)
values (default, 'jan', 'rodz', 'jandroz@gmail.com', '7851231547', 'Jan', 'Rodrz');

insert into account(account_id, username, password, email, phone_number, first_name, last_name)
values (default, 'emma', 'uls', 'emmanueluls@gmail.com', '2201563695', 'Emmanuel', 'Uls');

insert into account(account_id, username, password, email, phone_number, first_name, last_name)
values (default, 'grab012', 'password', 'gabriella23@gmail.com', '1234567891', 'Gabriella', 'Phillips');

insert into account(account_id, username, password, email, phone_number, first_name, last_name)
values (default, 'vig992', 'dogs', 'vanessagls@gmail.com', '9876543219', 'Gabriella', 'Jimenez');

insert into card(card_id, account_id, card_type, card_holder_name, card_number, cvc_code, card_expiration_date)
values(default, 1, 'Visa', 'Jan Rodrz', '1234567891234567', '123', '2020-02-01');

insert into card(card_id, account_id, card_type, card_holder_name, card_number, cvc_code, card_expiration_date)
values(default, 1, 'Master Card', 'Jan Rodrz', '7894561231596324', '456', '2020-05-01');

insert into card(card_id, account_id, card_type, card_holder_name, card_number, cvc_code, card_expiration_date)
values(default, 2, 'Discover', 'Emmanuel Uls', '1597534568521569', '785', '2022-03-01');

insert into card(card_id, account_id, card_type, card_holder_name, card_number, cvc_code, card_expiration_date)
values(default, 3, 'Master Card', 'Gabriella Phillips', '5556547896852345', '555', '2026-06-01');

insert into card(card_id, account_id, card_type, card_holder_name, card_number, cvc_code, card_expiration_date)
values(default, 3, 'American Express', 'Gabriella Phillips', '7778882223336665', '556', '2028-07-01');

insert into card(card_id, account_id, card_type, card_holder_name, card_number, cvc_code, card_expiration_date)
values(default, 4, 'Discover', 'Vanessa Jimenez', '8523697411547836', '888', '2025-08-01');



insert into transaction(transaction_id,card_id, transaction_type, name_money_reciever, transaction_time_stamp, phone_number, withdraws)
values(default, 1, 'Person', 'Enrique Malave', '2020-05-02', '7872583697', 12.99);

insert into transaction(transaction_id,card_id, transaction_type, name_money_reciever, transaction_time_stamp, phone_number, withdraws)
values(default, 1, 'Person', 'Mara Cruz', '2020-05-02', '1256547895', 100.00);

insert into transaction(transaction_id,card_id, transaction_type, name_money_reciever, transaction_time_stamp, phone_number, withdraws)
values(default, 1, 'Person', 'Sandra Celeste', '2020-05-06', '85246578954', 25.99);

insert into transaction(transaction_id,card_id, transaction_type, name_money_reciever, transaction_time_stamp, phone_number, withdraws)
values(default, 2, 'Person', 'Rosa Herna', '2020-03-05', '', 12.99);

insert into transaction(transaction_id,card_id, transaction_type, name_money_reciever, transaction_time_stamp, phone_number, withdraws)
values(default, 2, 'Donate', 'Dogs House Care', '2020-02-25', '9966541403', 50.00);

insert into transaction(transaction_id,card_id, transaction_type, name_money_reciever, transaction_time_stamp, phone_number, withdraws)
values(default, 2, 'Person', 'Enrique Malave', '2020-06-12', '7872583697', 3.99);

insert into transaction(transaction_id,card_id, transaction_type, name_money_reciever, transaction_time_stamp, phone_number, withdraws)
values(default, 3, 'Person', 'Mike Lavander', '2020-07-11', '5558889546', 15.99);

insert into transaction(transaction_id,card_id, transaction_type, name_money_reciever, transaction_time_stamp, phone_number, withdraws)
values(default, 4, 'Business', 'Carlos Valencia', '2020-11-25', '1002315169', 259.99);

===============================================================
Alter tables to delete with foreign keys
===============================================================
alter table card
drop constraint fk_account_id;

alter table card
add constraint fk_account_id foreign key (account_id) references account(account_id) on delete cascade;

alter table "transaction" 
drop constraint fk_card_id;

alter table "transaction" 
add constraint fk_card_id foreign key (card_id) references card(card_id) on delete cascade;

===============================================================
Service Methods
===============================================================

select *
from account;

select *
from card;

select *
from transaction;

 -- Get account by credit card number 
select *
from account a
join card c 
on a.account_id = c.account_id 
where c.card_number = '1597534568521569';


-- Get account by their phone number 
select *
from account 
where phone_number = '1234567891';


--Get card by account username
select c.*
from account a
join card c 
on a.account_id = c.account_id 
where a.username = 'jan';


-- Get cards by account number 
select c.*
from account a
join card c 
on a.account_id = c.account_id 
where a.phone_number = '9876543219';


-- Get transactions credit card number 
select t.*
from card c 
join "transaction" t 
ON c.card_id = t.card_id 
where c.card_number = '5556547896852345';

-- Get transactions account username 
select t.*
from account a 
inner join card c 
ON a.account_id = c.account_id 
inner join "transaction" t 
on c.card_id = t.card_id 
where a.username = 'jan'


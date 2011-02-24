create database plc_tybscit;

use plc_tybscit;

create table t_customer_master (C_ID varchar(10) primary key, LName varchar(100), FName varchar(100), Address varchar(1000), contact varchar(100), mobile varchar(100), fax varchar(100), email varchar(100), comments varchar (100));

sp_help t_customer_master

select * from t_customer_master
delete from t_customer_master where C_ID='C003',LName='matrix' 

insert into t_customer_master values ('C001','abc','ltd','chembur','022-25295556','9868890567','Not Available','abc123@gmail.com','Testing...');

create table t_employee_master (E_ID varchar(10) primary key, FName varchar(100), LName varchar(100), Address varchar(1000), contact varchar(100), mobile varchar(100), fax varchar(100), email varchar(100),designation varchar(100))
insert into t_employee_master values('E000','Ram','Gupta','chembur','02225275467','9876543215','9+85461235+21','ram@gmail.com','manager')
insert into t_employee_master values('E001','Ramu','gupt','chembur','02225275657','9876547815','9+854612+21','ramu@gmail.com','manager')
insert into t_employee_master values('E002','Rajan','mishra','vashi','02225278967','9876534215','9+8546235+21','rajan@gmail.com','manager')
insert into t_employee_master values('E003','Rahul','verma','dadar','02225275347','9876545615','9+461235+21','rahul123@gmail.com','manager')
select * from t_employee_master
delete from t_employee_master




create table t_supplier_master (S_ID varchar(10) primary key, SName varchar(100),Address varchar(1000), contact varchar(100), mobile varchar(100), fax varchar(100), email varchar(100),comments varchar(100));
insert into t_supplier_master values ('S000','Rajan','Chembur','022-25676356','9868670567','Not Available','raj01gmail.com','---------')
insert into t_supplier_master values ('S001','Raj','Chembur','022-25676566','9868667567','Not Available','raj02gmail.com','---------')
insert into t_supplier_master values ('S003','Rajander','dadar','022-25896356','9845670567','Not Available','raj03gmail.com','---------')
insert into t_supplier_master values ('S004','raju','vashi','022-25676390','9868689567','Not Available','raj04gmail.com','---------')

select * from t_supplier_master
delete from t_supplier_master

create table t_product_master (P_ID varchar(10) primary key, PName varchar(100),Cat_ID varchar(1000), cost varchar(100), describe varchar(100))
insert into t_product_master values('P000','switch','CA000','3000','fhgfgfghf')
insert into t_product_master values('P001','switchgear','CA001','4000','fhgfghf')
insert into t_product_master values('P002','circuit breaker','CA002','500','hgfgfghf')
insert into t_product_master values('P003','switchboard','CA003','8000','fhgfgff')
select * from t_product_master
delete from t_product_master

create table t_currency_master(Curr_CD varchar(10),value varchar(100))
insert into t_currency_master values('CU000','42')
insert into t_currency_master values('CU001','44')
insert into t_currency_master values('CU002','46')
delete from t_currency_master where value=50
select * from t_currency_master
delete from t_currency_master

alter table t_currency_master alter column CURR_CD varchar(10) NOT NULL
alter table t_currency_master add constraint c primary key(Curr_CD)



create table t_tax_master(Tax_CD varchar(10),type varchar(100),value varchar(100))
insert into t_tax_master values('T000','abc','345')
insert into t_tax_master values('T001','xyz','3450')
insert into t_tax_master values('T002','abc','345')
insert into t_tax_master values('T003','pqr','365')
select * from t_tax_master

delete from t_tax_master
alter table t_tax_master alter column Tax_CD varchar(10) NOT NULL
alter table t_tax_master add constraint d primary key(Tax_CD)


create table t_purchase_order(PO_ID varchar(10),date1 datetime,supplier varchar(10),credit_period varchar(10),validity varchar(10),order_num varchar(10),quantity varchar(10),Tax_CD varchar(10) references t_tax_master(Tax_CD),tax_amt varchar(10),taxable_amt varchar(10),additional_tax varchar(10),surcharge varchar(10),cess varchar(10),Curr_CD varchar(10) references t_currency_master(Curr_CD))
select * from t_purchase_order
alter table t_purchase_order alter column PO_ID varchar(10) NOT NULL
alter table t_purchase_order add constraint e primary key(PO_ID)

create table t_po_product_detail(sr varchar(10) primary key,PO_ID varchar(10) references t_purchase_order(PO_ID),P_ID varchar(10) references t_product_master(P_ID),describe varchar(10),quantity varchar(10),unit varchar(10),rate varchar(10),discount_percent varchar(10),discount_amt varchar(10),tax_amt varchar(10),value varchar(10))
select * from t_po_product_detail

select * from t_supplier_master

create table t_invoice(Invoice_ID varchar(10),date1 datetime,supplier varchar(10),credit_period varchar(10),validity varchar(10),order_num varchar(10),quantity varchar(10),Tax_CD varchar(10) references t_tax_master(Tax_CD),tax_amt varchar(10),taxable_amt varchar(10),additional_tax varchar(10),surcharge varchar(10),cess varchar(10),Curr_CD varchar(10) references t_currency_master(Curr_CD))
select * from t_invoice

create table t_invoice_product_detail(sr varchar(10) primary key,PO_ID varchar(10) references t_purchase_order(PO_ID),P_ID varchar(10) references t_product_master(P_ID),describe varchar(10),quantity varchar(10),unit varchar(10),rate varchar(10),discount_percent varchar(10),discount_amt varchar(10),tax_amt varchar(10),value varchar(10))
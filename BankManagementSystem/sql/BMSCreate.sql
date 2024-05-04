drop table Transactions;
drop table Accounts;
drop table Customers;
drop table Users;

create table Users(
    user_id varchar(9) primary key not null,
    username varchar2(60) not null,
    password varchar2(60) not null,
    first_name varchar2(60) not null,
    last_name varchar2(60) not null,
    role varchar2(60) not null,
    last_login timestamp not null,
    constraint username_chk check (length(username) >= 8),
    constraint password_chk check (length(password) >= 8),
    constraint role_chk check (role = 'Executive' or role = 'Teller')
);

create table Customers(
    customer_id varchar2(9) primary key not null,
    ssn varchar2(12) unique not null,
    first_name varchar2(60) not null,
    last_name varchar2(60) not null,
    dob varchar2(15) not null,
    address1 varchar2(100) not null,
    address2 varchar2(100),
    city varchar2(60) not null,
    state varchar2(2) not null,
    zipcode varchar2(10) not null,
    customer_status varchar2(10) not null,
    last_update date not null
);

create table Accounts(
    account_id varchar2(9) primary key not null,
    customer_id varchar2(9) not null,
    account_type varchar2(10) not null,
    status varchar2(10) not null,
    balance number(10,2) not null,
    last_transaction timestamp not null,
    constraint type_chk check (account_type = 'Checking' or account_type = 'Savings'),
    constraint status_chk check (status = 'Closed' or status = 'Open'),
    constraint balance_chk check (balance >=0),
    foreign key (customer_id) references Customers(customer_id)
);
    
create table Transactions(
    transaction_id varchar2(9) primary key not null,
    account_id varchar2(9) not null,
    dat timestamp not null,
    description varchar2(100) not null,
    amount number(10,2) not null,
    balance number(10,2) not null,
    constraint bal_chk check (balance >= 0),
    foreign key (account_id) references Accounts(account_id)
);

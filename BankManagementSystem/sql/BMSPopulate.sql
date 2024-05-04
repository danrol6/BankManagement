insert into Users values ('980000001', 'jmadden123', 'jmadden123', 'James', 'Madden', 'Executive', timestamp'2007-10-01 12:45:23');
insert into Users values ('740000002', 'jmichels5', 'jmichels5', 'Jospeh', 'Michels', 'Executive', current_timestamp);
insert into Users values ('220000003', 'mares12345', 'mares12345', 'Marco', 'Ares', 'Teller', timestamp'2015-07-11 10:45:12');
insert into Users values ('580000004', 'rnavarro72', 'rnavarro72', 'Ron', 'Navarro', 'Teller', current_timestamp);
insert into Customers values ('000000001', '123-45-7890', 'Daniel', 'Roldan', '01-02-1997', '123 TCS Lane', '', 'Edison', 'NJ', '12345-6789', 'active', current_date);
insert into Customers values ('000000002', '987-65-4321', 'Brently', 'Maxwell', '08-05-1988', '567 1st St.', '', 'Santa Clara', 'CA', '95111-6887', 'active', current_date);
insert into Customers values ('000000003', '555-12-2104', 'Dylan', 'Palaia', '02-12-1995', '1771 Electic Ave.', '', 'Waco', 'Tx', '14371-6601', 'closed', current_date);
insert into Customers values ('000000004', '261-65-0051', 'Immanuel', 'Antony', '02-25-1991', '555 Left Lane', '', 'Jersey City', 'NJ', '44611-1087', 'active', current_date);
insert into Customers values ('000000005', '317-15-1509', 'George', 'Tarleton', '09-05-1989', '441 Circle Dr.', '', 'Seattle', 'WA', '33164-5551', 'closed', current_date);
insert into Customers values ('000000006', '101-77-3113', 'Nathaniel', 'Essex', '05-03-1957', '95 East St.', '', 'Chicago', 'Il', '59595-4242', 'active', current_date);
insert into Accounts values ('000000001', '000000001', 'Checking', 'Open', 3456.07, timestamp'2007-10-05 11:14:05');
insert into Accounts values ('000000002', '000000002', 'Checking', 'Closed', 12233344.44, current_timestamp);
insert into Accounts values ('000000003', '000000002', 'Savings', 'Open', 23105.00, current_timestamp);
insert into Accounts values ('000000004', '000000003', 'Checking', 'Open', 55.15, timestamp'2009-02-01 03:25:23');
insert into Accounts values ('000000005', '000000004', 'Savings', 'Closed', 0.00, current_timestamp);
insert into Accounts values ('000000006', '000000005', 'Savings', 'Open', 1500.05, timestamp'2015-07-05 08:22:20');
insert into Accounts values ('000000007', '000000006', 'Checking', 'Open', 2.10, current_timestamp);
insert into Accounts values ('000000008', '000000006', 'Savings', 'Open', 52005.25, timestamp'2019-10-10 06:57:45');
insert into Transactions values ('000000001', '000000001', current_timestamp, 'Deposit into 000000001', 1000.00, 4456.07);
insert into Transactions values ('000000002', '000000008', current_timestamp, 'Deposit into 000000008', 1505.00, 51510.25);
insert into Transactions values ('000000003', '000000006', current_timestamp, 'Withdraw from 000000006', 500.05, 1000.00);
insert into Transactions values ('000000004', '000000004', current_timestamp, 'Transfer from 000000004 to 000000008', 5.15, 50.00);
insert into Transactions values ('000000005', '000000007', current_timestamp, 'Withdraw from 000000007', 2.00, 0.10);
insert into Transactions values ('000000006', '000000003', current_timestamp, 'Deposit into 000000003', 5.00, 23110.00);
insert into Transactions values ('000000007', '000000006', current_timestamp, 'Transfer from 000000006 to 000000004', 25.00, 975.00);
insert into Transactions values ('000000008', '000000001', current_timestamp, 'Withdraw from 000000001', 56.07, 4400.00);
insert into Transactions values ('000000009', '000000008', current_timestamp, 'Deposit into 000000008', 1500.50, 53505.75);
insert into Transactions values ('000000010', '000000004', current_timestamp, 'Withdraw from 000000004', 49.00, 6.15);
commit;
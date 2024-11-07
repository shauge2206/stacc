INSERT INTO accounts (id, account_number, account_type, balance, currency, owner) VALUES
      ('acc123', '********1234', 'Checking', 15000.25, 'NOK', 'Alice'),
      ('acc456', '********5678', 'Savings', 25000.75, 'NOK', 'Bob'),
      ('acc789', '********9876', 'Checking', 2000.5, 'NOK', 'Charlie'),
      ('acc012', '********2109', 'Savings', 8000.0, 'NOK', 'David');

INSERT INTO transactions (id, date, description, amount, currency, account_id) VALUES
       ('txn039', '2023-10-01', 'Salary Deposit', 2500, 'NOK', 'acc123'),
       ('txn040', '2023-09-15', 'Utility Payment', -120, 'NOK', 'acc123'),
       ('txn041', '2023-11-05', 'Bonus Deposit', 3000, 'NOK', 'acc123'),
       ('txn042', '2023-08-20', 'Grocery Shopping', -250, 'NOK', 'acc123'),
       ('txn043', '2023-12-10', 'Rent Payment', -1000, 'NOK', 'acc123'),
       ('txn044', '2023-07-11', 'Savings Deposit', 1200, 'NOK', 'acc123'),
       ('txn045', '2023-06-09', 'Restaurant', -150, 'NOK', 'acc123'),
       ('txn046', '2023-11-01', 'Refund', 300, 'NOK', 'acc123'),
       ('txn047', '2023-08-08', 'Medical Bill', -200, 'NOK', 'acc123'),
       ('txn048', '2023-04-12', 'Interest Earnings', 150, 'NOK', 'acc123'),

       ('txn049', '2023-11-13', 'Salary Deposit', 2600, 'NOK', 'acc456'),
       ('txn050', '2023-09-03', 'Online Shopping', -75, 'NOK', 'acc456'),
       ('txn051', '2023-07-25', 'Savings Deposit', 800, 'NOK', 'acc456'),
       ('txn052', '2023-12-05', 'Gift Purchase', -350, 'NOK', 'acc456'),
       ('txn053', '2023-10-30', 'Refund', 100, 'NOK', 'acc456'),
       ('txn054', '2023-09-14', 'Fuel Purchase', -500, 'NOK', 'acc456'),
       ('txn055', '2023-08-18', 'Interest Earnings', 60, 'NOK', 'acc456'),
       ('txn056', '2023-06-12', 'Utility Payment', -200, 'NOK', 'acc456'),
       ('txn057', '2023-10-20', 'Bonus Deposit', 1200, 'NOK', 'acc456'),
       ('txn058', '2023-03-15', 'Grocery Shopping', -300, 'NOK', 'acc456'),

       ('txn059', '2023-10-01', 'Salary Deposit', 2500, 'NOK', 'acc789'),
       ('txn060', '2023-10-15', 'Charity Donation', -100, 'NOK', 'acc789'),
       ('txn061', '2023-09-25', 'Savings Deposit', 1500, 'NOK', 'acc789'),
       ('txn062', '2023-05-01', 'Gym Membership', -300, 'NOK', 'acc789'),
       ('txn063', '2023-06-10', 'Refund', 120, 'NOK', 'acc789'),
       ('txn064', '2023-08-12', 'Interest Earnings', 75, 'NOK', 'acc789'),
       ('txn065', '2023-09-05', 'Medical Bill', -200, 'NOK', 'acc789'),
       ('txn066', '2023-07-20', 'Gift Purchase', -500, 'NOK', 'acc789'),
       ('txn067', '2023-08-25', 'Salary Bonus', 1000, 'NOK', 'acc789'),
       ('txn068', '2023-09-01', 'Fuel Purchase', -80, 'NOK', 'acc789'),

       ('txn069', '2023-04-20', 'Salary Deposit', 2600, 'NOK', 'acc012'),
       ('txn070', '2023-03-13', 'Grocery Shopping', -180, 'NOK', 'acc012'),
       ('txn071', '2023-11-12', 'Rent Payment', -1200, 'NOK', 'acc012'),
       ('txn072', '2023-10-30', 'Gift Deposit', 900, 'NOK', 'acc012'),
       ('txn073', '2023-02-28', 'Utility Payment', -150, 'NOK', 'acc012'),
       ('txn074', '2023-05-18', 'Bonus Deposit', 1100, 'NOK', 'acc012'),
       ('txn075', '2023-09-14', 'Travel Expense', -800, 'NOK', 'acc012'),
       ('txn076', '2023-06-19', 'Refund', 200, 'NOK', 'acc012'),
       ('txn077', '2023-07-05', 'Medical Bill', -220, 'NOK', 'acc012'),
       ('txn078', '2023-04-11', 'Interest Earnings', 130, 'NOK', 'acc012');

-- Goal for Alice's account
INSERT INTO goals (id, description, target_amount, amount, currency, account_id)
VALUES ('goal001', 'Vacation Fund', 20000.00, 15000.25, 'NOK', 'acc123');

-- Goal for Bob's account
INSERT INTO goals (id, description, target_amount, amount, currency, account_id)
VALUES ('goal003', 'Emergency Fund', 50000.00, 25000.75, 'NOK', 'acc456');

-- Goal for Charlie's account
INSERT INTO goals (id, description, target_amount, amount, currency, account_id)
VALUES ('goal005', 'Education Savings', 30000.00, 2000.50, 'NOK', 'acc789');

-- Goal for David's account
INSERT INTO goals (id, description, target_amount, amount, currency, account_id)
VALUES ('goal007', 'Retirement Fund', 200000.00, 8000.00, 'NOK', 'acc012');
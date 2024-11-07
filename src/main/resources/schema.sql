-- Drop tables if they exist
DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS saving_goals;

CREATE TABLE accounts (
                          id VARCHAR(50) PRIMARY KEY,
                          account_number VARCHAR(50) NOT NULL,
                          account_type VARCHAR(20) NOT NULL,
                          balance NUMERIC NOT NULL,
                          currency VARCHAR(10) NOT NULL DEFAULT 'NOK',
                          owner VARCHAR(50) NOT NULL
);

CREATE TABLE transactions (
                          id VARCHAR(50) PRIMARY KEY,
                          date DATE NOT NULL,
                          description VARCHAR(255),
                          amount NUMERIC NOT NULL,
                          currency VARCHAR(10) NOT NULL DEFAULT 'NOK',
                          account_id VARCHAR(50) NOT NULL,
                          FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE CASCADE
);

CREATE TABLE goals (
                       id VARCHAR(50) PRIMARY KEY,
                       description VARCHAR(255) NOT NULL,
                       target_amount DECIMAL(15, 2) NOT NULL,
                       amount DECIMAL(15, 2) DEFAULT 0.00,
                       currency VARCHAR(10) NOT NULL DEFAULT 'NOK',
                       account_id VARCHAR(50),
                       status VARCHAR(50) NOT NULL DEFAULT 'In progress...',
                       achieved DECIMAL(15, 2) DEFAULT 0.00,
                       FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE CASCADE
);
CREATE TABLE accounts (
    account_id INT PRIMARY KEY,
    account_type VARCHAR(20), 
    balance DECIMAL(10,2)
);
DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE accounts
    SET balance = balance * 1.01
    WHERE account_type = 'savings';
END;
//

DELIMITER ;
CALL ProcessMonthlyInterest();
CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    salary DECIMAL(10,2)
);
INSERT INTO employees VALUES
(1, 'John', 'Sales', 50000),
(2, 'Jane', 'HR', 55000),
(3, 'Mark', 'Sales', 60000);
DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus(IN dept_name VARCHAR(50), IN bonus_percent DECIMAL(5,2))
BEGIN
    UPDATE employees
    SET salary = salary + (salary * bonus_percent / 100)
    WHERE department = dept_name;
END;
//

DELIMITER ;
CALL UpdateEmployeeBonus('Sales', 10);
DELIMITER //

CREATE PROCEDURE TransferFunds(
    IN from_account INT,
    IN to_account INT,
    IN amount DECIMAL(10,2)
)
BEGIN
    DECLARE from_balance DECIMAL(10,2);

    -- Get current balance
    SELECT balance INTO from_balance
    FROM accounts
    WHERE account_id = from_account;

    -- Check sufficient balance
    IF from_balance >= amount THEN
        UPDATE accounts
        SET balance = balance - amount
        WHERE account_id = from_account;

        UPDATE accounts
        SET balance = balance + amount
        WHERE account_id = to_account;
    ELSE
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient balance in source account';
    END IF;
END;
//

DELIMITER ;

CALL TransferFunds(101, 102, 1000.00);

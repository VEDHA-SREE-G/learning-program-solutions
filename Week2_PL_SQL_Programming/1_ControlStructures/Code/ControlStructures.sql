create database fse;
use fse;
CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    name        VARCHAR(50),
    age         INT,
    balance     DECIMAL(10,2),
    IsVIP       BOOLEAN DEFAULT FALSE
);

CREATE TABLE loans (
    loan_id       INT PRIMARY KEY,
    customer_id   INT,
    interest_rate DECIMAL(5,2),
    due_date      DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

INSERT INTO customers VALUES 
(1, 'Alice', 65, 12000.00, FALSE),
(2, 'Bob', 45, 8000.00, FALSE),
(3, 'Carol', 70, 15000.00, FALSE);

INSERT INTO loans VALUES 
(101, 1, 8.5, CURDATE() + INTERVAL 20 DAY),
(102, 2, 7.0, CURDATE() + INTERVAL 45 DAY),
(103, 3, 9.0, CURDATE() + INTERVAL 10 DAY);

UPDATE loans l
JOIN customers c ON l.customer_id = c.customer_id
SET l.interest_rate = l.interest_rate - 1
WHERE c.age > 60;

UPDATE customers
SET IsVIP = TRUE
WHERE balance > 10000;

SELECT 
    c.name AS Customer_Name,
    l.due_date AS Due_Date
FROM 
    loans l
JOIN 
    customers c ON l.customer_id = c.customer_id
WHERE 
    l.due_date BETWEEN CURDATE() AND CURDATE() + INTERVAL 30 DAY;

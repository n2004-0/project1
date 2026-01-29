CREATE DATABASE expense_tracker2;
USE expense_tracker2;

CREATE TABLE expenses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    category VARCHAR(50),
    amount DOUBLE,
    expense_date DATE
);

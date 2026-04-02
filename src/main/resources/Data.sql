create  database Zorvyn;
use  Zorvyn;
CREATE TABLE users (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
email VARCHAR(250) UNIQUE,
password VARCHAR(250) NOT NULL,
role VARCHAR(50) NOT NULL,
status VARCHAR(20) NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE financial_records(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
amount DECIMAL(10,2),
type VARCHAR(50) NOT NULL,
category VARCHAR(50) NOT NULL,
date DATE,
notes TEXT,
created_by BIGINT NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT fk_user
		FOREIGN KEY (created_by) REFERENCES users(id)
        ON DELETE CASCADE
);

select * from users;
INSERT INTO users (name, email, password, role, status) VALUES
('Muttu Kagal', 'kagalmutturaj@gmail.com', '1234', 'ADMIN', 'ACTIVE'),
('Anita Sharma', 'anita@gmail.com', '1234', 'ANALYST', 'ACTIVE'),
('Rahul Verma', 'rahul@gmail.com', '1234', 'VIEWER', 'ACTIVE'),
('Priya Reddy', 'priya@gmail.com', '1234', 'ANALYST', 'INACTIVE'),
('Arjun Patel', 'arjun@gmail.com', '1234', 'VIEWER', 'ACTIVE');

INSERT INTO financial_records (amount, type, category, date, notes, created_by) VALUES
(50000.00, 'INCOME', 'Salary', '2026-03-01', 'March salary', 1),
(2000.00, 'EXPENSE', 'Food', '2026-03-02', 'Groceries', 1),
(1500.00, 'EXPENSE', 'Transport', '2026-03-03', 'Bus pass', 2),
(10000.00, 'INCOME', 'Freelance', '2026-03-05', 'Website project', 2),
(3000.00, 'EXPENSE', 'Rent', '2026-03-06', 'Room rent', 3),
(800.00, 'EXPENSE', 'Food', '2026-03-07', 'Restaurant', 3),
(60000.00, 'INCOME', 'Salary', '2026-03-01', 'Monthly salary', 4),
(2500.00, 'EXPENSE', 'Shopping', '2026-03-08', 'Clothes', 5),
(1200.00, 'EXPENSE', 'Electricity', '2026-03-09', 'EB bill', 1),
(7000.00, 'INCOME', 'Bonus', '2026-03-10', 'Performance bonus', 1);
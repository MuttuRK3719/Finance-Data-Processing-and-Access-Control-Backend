# Finance Data Processing & Access Control Backend

Spring Boot backend application for managing financial records (income & expense), users, and dashboard analytics.

---

## 🚀 Features

* User Management (Create, Update, Delete, Fetch)
* Financial Record Management
* Dashboard APIs (Income, Expense, Net Balance, Summary)
* Basic role handling (ADMIN / USER / VIEWER)

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven
* MySQL

---

## ▶️ How to Run

1. Clone the repository

2. Configure database in `application.properties`

3. Initialize DB (recommended):
   `src/test/java/com/Zorvyn/finance_data_service/Data.sql`

4. Run the application

   mvn spring-boot:run

5. Server starts at:
   http://localhost:8080

---

## 📬 Postman Collection

Import this collection:


---

## 📊 Dashboard APIs

* GET /dashboard/v1/totalIncome
* GET /dashboard/v1/totalExpense
* GET /dashboard/v1/getNetBalance
* GET /dashboard/v1/getCategoryWiseTotals
* GET /dashboard/v1/getRecentActivity
* GET /dashboard/v1/getFullSummary

---

## 💰 Financial Record APIs

### Save Record

POST /financial_record/v1?email={email}

Body:
{
"amount": 10000.0,
"type": "INCOME",
"category": "Bonus",
"notes": "Salary creaditec"
}

---

### Update Record

PUT /financial_record/v1?email={email}&id={id}

Body:
{
"amount": 10000.0,
"type": "INCOME",
"category": "Bonus",
"notes": "Salary creaditec"
}

---

### Get Record By ID

GET /financial_record/v1/{id}

---

### Get All Records

GET /financial_record/v1/all

---

### Filter Records

GET /financial_record/v1?transactionType={type}&category={category}&startDate={yyyy-MM-dd}&endDate={yyyy-MM-dd}

Example:
GET /financial_record/v1?transactionType=INCOME&category=Bonus&startDate=2026-03-01&endDate=2026-03-01

---

### Delete Record

DELETE /financial_record/v1?id={id}&email={email}

---

## 👤 User APIs

### Create User

POST /user/v1/16

Body:
{
"name": "Prasanna",
"email": "[prasanna@gmail.com](mailto:prasanna@gmail.com)",
"password": "Prasanna@123",
"role": "VIEWER"
}

---

### Update User

PUT /user/v1/{id}

Body:
{
"name": "Prasanna NH",
"email": "[prasanna@gmail.com](mailto:prasanna@gmail.com)",
"password": "Prasanna@1345",
"role": "VIEWER",
"status": "ACTIVE"
}

---

### Update User Status

PUT /user/v1/update/status?id={id}&status={status}

---

### Get User By ID

GET /user/v1/{id}

---

### Get All Users

GET /user/v1/all

---

### Delete User

DELETE /user/v1/{id}

---

## ⚠️ Notes

* Database used: **MySQL**

* When running first time, DB will be empty
  → You must **add an Admin user manually in DB**

* To create DB schema, use:
  `src/test/java/com/Zorvyn/finance_data_service/Data.sql`

* All API requests must use **Basic Authentication**

  * Username = email
  * Password = same password used during user creation
  * Password is stored as **plain text (not BCrypt)**

* Email is required in financial record APIs

* Save and Update record use different HTTP methods (POST / PUT)

* Filtering API uses query parameters
  
* If u want Postman Collection for testing the API use this json file which is located in path of src/test/java/com/Zorvyn/finance_data_service/FinanceDashBoard.postman_collection (1).json

* If above steps are followed correctly, application should work without issues

# Reward Points Calculator API

## Overview

The Reward Points Calculator API is a Spring Boot REST application that calculates customer reward points based on
transaction amounts.

The application retrieves customer transactions from an H2 in-memory database, calculates reward points according to the
business rules, groups rewards by month and year, and returns both monthly and total reward summaries.

This project follows a layered architecture using Controller, Service, Repository, DTO, and Entity layers.

---

## Technologies Used

* Java 17
* Spring Boot 3
* Spring Data JPA
* H2 Database
* Maven
* JUnit 5
* Mockito
* MockMvc
* Java Stream API

---

## Reward Calculation Rules

Reward points are calculated based on the following rules:

| Transaction Amount | Reward Points                                      |
|--------------------|----------------------------------------------------|
| $50 or less        | 0 Points                                           |
| $51 - $100         | 1 Point for every dollar over $50                  |
| Above $100         | 2 Points for every dollar over $100 plus 50 Points |

### Example

Transaction Amount = $120

Reward Points:

* First $50 = 0 points
* Next $50 = 50 points
* Remaining $20 = 40 points

Total Reward Points = 90

---

## Project Architecture

com.reward_points

controller
service
repository
entity
dto
exception
resources

---

## Database

The application uses an H2 in-memory database.

### Features

* Lightweight
* No installation required
* Automatically initialized during application startup
* Suitable for development and testing

### Database Initialization

The database is populated automatically using:

* schema.sql
* data.sql

---

## Sample Data

The application loads sample customer and transaction data from data.sql.

### Customers

* Hari
* Nari
* Mani
* Tharun
* Haritha
* Thanu
* Kaushik
* Sailu
* Suguna
* Subbu

### Transactions

The project contains 10 sample transaction records distributed across multiple dates and transaction amounts to
validate:

* Monthly reward calculations
* Total reward calculations
* Different reward slabs
* Stream API aggregation

Transaction dates are generated dynamically using DATEADD() and are not hardcoded.

---

## REST API Endpoints

### 1. Get Rewards By Customer

Endpoint:

GET /api/rewards/customer/{customerId}

Example:

GET /api/rewards/customer/1

Description:

Returns monthly and total reward points for a specific customer.

---

### 2. Get Rewards For All Customers

Endpoint:

GET /api/rewards/all

Description:

Returns reward details for all customers.

---

## Sample Response

Output when customer has transactions
{
"customerId": 1,
"customerName": "Hari",
"monthlyRewards": [
{
"monthYear": "2026-04",
"rewardPoints": 250
},
{
"monthYear": "2026-05",
"rewardPoints": 25
},
{
"monthYear": "2026-06",
"rewardPoints": 90
}
],
"totalRewards": 365,
"message": "Rewards calculated successfully"
}
Output when customer has no transactions
{
"customerId": 8,
"customerName": "Sailu",
"monthlyRewards": [],
"totalRewards": 0,
"message": "Customer has no transactions available"
}

---

## Exception Handling

Global exception handling is implemented using @RestControllerAdvice.

Handled Scenarios:

* Customer not found
* Invalid input
* Unexpected server errors

---

## Testing

### Unit Tests

JUnit 5 and Mockito are used to test business logic.

Test Coverage Includes:

* Amount below $50
* Amount equal to $50
* Amount between $50 and $100
* Amount equal to $100
* Amount greater than $100
* Boundary conditions
* Negative values
* Exception scenarios

Total Unit Test Cases: 9+

---

### Integration Tests

MockMvc is used for API integration testing.

Covered Scenarios:

* Valid customer rewards
* Invalid customer
* All customer rewards
* Transaction reward retrieval
* API response validation

---

## Running the Application

Build Project:

mvn clean install

Run Application:

mvn spring-boot:run

Application URL:

http://localhost:8080

---

## H2 Console

URL:

http://localhost:8080/h2-console

Default Configuration:

JDBC URL: jdbc:h2:mem:testdb

---

## Running Tests

Execute all tests:

mvn test

---




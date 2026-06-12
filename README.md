# Reward Points API

## Overview

Spring Boot REST API that calculates customer reward points based on transactions.

## Reward Calculation

- 1 point for every dollar spent between $50 and $100
- 2 points for every dollar spent above $100

Example:

Purchase = $120

50 points for $50-$100

20 * 2 = 40 points above $100

Total = 90 points

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- JUnit 5
- Mockito

## Endpoints

GET /api/rewards/all

Returns rewards for all customers.

GET /api/rewards/{customerId}

Returns monthly and total rewards.

GET /api/rewards/transaction/{transactionId}

Returns reward points for transaction.

## Running

mvn clean install

mvn spring-boot:run

## Testing

mvn test

## H2 Console

http://localhost:8080/h2-console

JDBC URL:
jdbc:h2:mem:rewarddb
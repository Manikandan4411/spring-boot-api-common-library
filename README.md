# Spring Boot API Common Library

A reusable Spring Boot 3 library that provides centralized exception handling, standardized API error responses, validation error handling, and auto-configuration support for Spring Boot applications.

## Project Overview

This project was developed to standardize REST API error handling across multiple Spring Boot applications.

The library can be integrated into any Spring Boot application to provide:

- Consistent API error responses
- Centralized exception handling
- Validation error processing
- Custom exception support
- Spring Boot auto-configuration
- Reduced code duplication

The project also includes a demo application that consumes the library as a dependency.

---

# Technology Stack

- Java 21
- Spring Boot 3
- Spring Web
- Spring Validation
- Maven
- JUnit 5
- Mockito
- Git
- GitHub

---

# Project Structure

```text
spring-boot-api-common-library
│
├── api-common-library
│
│   ├── src/main/java/com/manikandan/apicommon
│   │
│   ├── config
│   ├── exception
│   ├── handler
│   └── response
│
│   └── src/main/resources/META-INF/spring
│
├── demo-application
│
│   ├── controller
│   ├── dto
│   ├── model
│   └── service
│
├── pom.xml
└── README.md
```

---

# Features

## Standard API Error Response

Provides a consistent error response structure.

```json
{
  "timestamp": "2026-11-12T12:06:56.4560669",
  "status": 404,
  "error": "Not Found",
  "message": "Product not found with id: 100",
  "path": null,
  "validationErrors": null
}
```

---

## Custom Exceptions

The library provides reusable exceptions:

- ResourceNotFoundException
- BadRequestException
- UnauthorizedException
- ForbiddenException
- ConflictException

Example:

```java
throw new ResourceNotFoundException(
        "Product not found with id: " + id);
```

---

## Global Exception Handling

Implemented using:

```java
@RestControllerAdvice
```

Supported exceptions:

| Exception | HTTP Status |
|------------|------------|
| ResourceNotFoundException | 404 |
| BadRequestException | 400 |
| UnauthorizedException | 401 |
| ForbiddenException | 403 |
| ConflictException | 409 |
| MethodArgumentNotValidException | 400 |
| ConstraintViolationException | 400 |
| HttpMessageNotReadableException | 400 |
| MissingServletRequestParameterException | 400 |
| Generic Exception | 500 |

---

## Validation Error Handling

Supports:

```java
@NotBlank
@NotNull
@Email
@Size
@Min
@Max
```

Example Response:

```json
{
  "timestamp": "2026-11-12T12:08:51.0626674",
  "status": 400,
  "error": "Validation Failed",
  "message": "Request validation failed",
  "validationErrors": {
    "name": "Product name is required"
  }
}
```

---

## Spring Boot Auto Configuration

Implemented using:

```java
@AutoConfiguration
@ConditionalOnWebApplication
```

Registered through:

```text
META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
```

This allows automatic library loading when included as a dependency.

---

# Library Components

## ApiErrorResponse

Provides a standard response model.

Fields:

```java
timestamp
status
error
message
path
validationErrors
```

---

## GlobalExceptionHandler

Handles application exceptions in a centralized manner.

```java
@RestControllerAdvice
```

Provides consistent error responses across applications.

---

# Demo Application

The project includes a demo Spring Boot application that uses the library as a dependency.

Demo Endpoints:

## Get All Products

```http
GET /api/products
```

Response:

```json
[
  {
    "id": 1,
    "name": "Laptop"
  },
  {
    "id": 2,
    "name": "Mobile"
  }
]
```

---

## Get Product By Id

```http
GET /api/products/{id}
```

Example:

```http
GET /api/products/100
```

Response:

```json
{
  "status": 404,
  "error": "Not Found",
  "message": "Product not found with id: 100"
}
```

---

## Create Product

```http
POST /api/products
```

Request:

```json
{
  "name": "Laptop"
}
```

---

## Validation Example

Request:

```json
{
  "name": ""
}
```

Response:

```json
{
  "status": 400,
  "error": "Validation Failed",
  "message": "Request validation failed",
  "validationErrors": {
    "name": "Product name is required"
  }
}
```

---

# Build Instructions

Clone the repository:

```bash
git clone https://github.com/your-username/spring-boot-api-common-library.git
```

Navigate to project:

```bash
cd spring-boot-api-common-library
```

Compile:

```bash
mvn clean compile
```

Run tests:

```bash
mvn test
```

Package:

```bash
mvn package
```

Install locally:

```bash
mvn install
```

---

# Integrating the Library

Add dependency:

```xml
<dependency>
    <groupId>com.manikandan</groupId>
    <artifactId>api-common-library</artifactId>
    <version>1.0.0</version>
</dependency>
```

No additional configuration is required.

The library will be loaded automatically using Spring Boot auto-configuration.

---

# Unit Testing

The project includes:

- JUnit 5 Tests
- Mockito Tests
- MockMvc Tests

Coverage includes:

- Custom exceptions
- ApiErrorResponse
- GlobalExceptionHandler
- Validation error handling
- HTTP status mappings

---

# Learning Outcomes

This project demonstrates:

- Spring Boot Auto Configuration
- Reusable Framework Development
- Exception Handling Best Practices
- Validation Processing
- Maven Multi-Module Projects
- REST API Standards
- Library Packaging
- Dependency Management
- Unit Testing with JUnit 5
- MockMvc Testing

---

# Author

Manikandan S

Java Backend Developer | Spring Boot Developer | Full Stack Developer

---

# License

This project is licensed under the MIT License.

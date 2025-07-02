# NearbyFix – Backend API

This is the backend server for **NearbyFix**, a location-based emergency service web application that helps users find nearby service providers (bike & car mechanics) and submit service requests in real-time.

Built with **Java**, **Spring Boot**, and **MySQL**, the backend exposes REST APIs to handle user authentication, service provider registration, service request management, and provider assignment workflows.

---

## 🚀 Features

- ✅ JWT-based authentication for users and providers
- ✅ Role-based access for users and service providers
- ✅ Register/login for users and providers
- ✅ Submit and track service requests
- ✅ Providers can accept and complete requests
- ✅ Map-based location saving (latitude/longitude)
- ✅ CORS support for frontend integration
- ✅ Clean API error handling & status responses

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Security + JWT**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **RESTful API**
- **CORS Configuration**

---

## 📂 Project Structure
```
src
├── main
│ ├── java
│ │ └── com.nearbyfix
│ │ ├── controller
│ │ ├── service
│ │ ├── model
│ │ ├── repository
│ │ └── config
│ └── resources
│ ├── application.properties
│ └── ...
└── test
```
 
---

## 🔧 Environment Setup

### ✅ Prerequisites

- Java 17+
- Maven
- MySQL (or change DB config)

### ✅ MySQL Configuration

Create a database in MySQL:

```sql
CREATE DATABASE nearbyfix;
```
### Update your application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/nearbyfix
spring.datasource.username=your_mysql_user
spring.datasource.password=your_mysql_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT secret (example)
jwt.secret=nearbyfixSecretKey
```

---

## ▶️ Running the Application
Using Maven

### Clean & build the project
```
mvn clean install
```

### Run the Spring Boot app
```
mvn spring-boot:run
```

The app will start on:
📍 http://localhost:8080

---

## 🔐 API Endpoints Summary
### 👤 Auth
POST /api/users/register

POST /api/users/login

POST /api/providers/register

POST /api/providers/login

### 🔧 Service Requests
POST /api/requests/register

GET /api/requests/user/{userId}

GET /api/requests/provider/{providerId}

GET /api/requests/type/{serviceType}

PUT /api/requests/{id}/accept?providerId=

PUT /api/requests/{id}/complete

---

## 🌐 CORS Configuration
CORS is enabled globally to allow requests from the frontend (React). You can customize origins inside the WebSecurityConfig.java.

---

## 📦 Deployment Tips
Host backend using Render, Railway, Heroku, VPS, or Docker

Secure .env or application.properties for production

Enable SSL (HTTPS) for better security

Monitor logs and DB

---

## 🤝 Contributions
If you'd like to contribute to NearbyFix backend, feel free to open issues or submit PRs!

---

## 📄 License
MIT License – [2025 © NearbyFix Team]


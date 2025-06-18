# NearbyFix Backend

This is the backend of the NearbyFix application, built using Spring Boot. It handles authentication, service request submission, and user data management.

## 🧩 Features

- RESTful API
- JWT-based authentication
- MySQL database integration
- CORS support for frontend

## 🛠 Technologies Used

- Java 17+
- Spring Boot
- Spring Security
- MySQL
- JPA (Hibernate)

## 📦 Installation

### 1. Clone the repo and open in your IDE

```bash
git clone https://github.com/SuryaMdk/nearbyfix-backend.git

2. Configure application.properties
Update your MySQL settings:
spring.datasource.url=jdbc:mysql://localhost:3306/nearbyfix
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3. Run the project
./mvnw spring-boot:run
🔗 API Base URL
http://localhost:8080

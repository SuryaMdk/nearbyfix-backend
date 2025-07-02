# Use official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the app
RUN ./mvnw package -DskipTests

# Run the JAR
CMD ["java", "-jar", "target/nearbyfix-backend.jar"]

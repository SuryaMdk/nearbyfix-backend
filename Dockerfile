# Use an official Java image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy everything
COPY . .

# ✅ Give executable permission to mvnw
RUN chmod +x mvnw

# ✅ Build the app
RUN ./mvnw package -DskipTests

# ✅ Run the built JAR
CMD ["java", "-jar", "target/nearbyfix-0.0.1-SNAPSHOT.jar"]


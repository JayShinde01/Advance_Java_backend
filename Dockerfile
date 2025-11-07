# Stage 1: Build the JAR using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the built JAR
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy only the final JAR
COPY --from=build /app/target/*.jar app.jar

# Expose the same port as your Spring Boot server
EXPOSE 8080

# Render automatically provides environment variables
# (like DB_URL, DB_USER, DB_PASSWORD, JWT_SECRET)
ENTRYPOINT ["java", "-jar", "app.jar"]

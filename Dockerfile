# ---------- Stage 1: Build ----------
FROM maven:3.9.4-eclipse-temurin-17 AS builder

WORKDIR /build

# Copy the pom and src
COPY pom.xml .
COPY src ./src

# Build the app
RUN mvn clean package -DskipTests

# ---------- Stage 2: Run ----------
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the jar from the build stage
COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

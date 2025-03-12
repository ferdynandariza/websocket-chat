# Use an official Maven image to build the project
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /

COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk
WORKDIR /

COPY --from=build /target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

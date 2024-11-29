FROM maven:3.8.8-eclipse-temurin-21-alpine AS build
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:21-jdk-slim
COPY --from=build /target/chorus-0.0.1-SNAPSHOT.jar chorus.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","chorus.jar"]
# Use the official maven image to build the application
FROM maven:3.8.1-openjdk-17 AS build
# Set the working directory inside the container
WORKDIR /app
# Copy the pom.xml and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
# Package the application
RUN mvn clean package -DskipTests
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/jobeJavaMatawanSolution-0.0.1-SNAPSHOT.jar /app/tester.jar
# Expose the port the application runs on
EXPOSE 8081
# Run the application
ENTRYPOINT ["java", "-jar", "tester.jar"]

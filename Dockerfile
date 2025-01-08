FROM openjdk:18-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY target/Company-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn clean install -DskipTests

FROM openjdk:11-jre-slim
COPY --from=build app/target/blackbird-0.0.1-SNAPSHOT.jar /app/blackbird-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/blackbird-0.0.1.jar"]

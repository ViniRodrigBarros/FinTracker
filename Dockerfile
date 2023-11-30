FROM ubuntu:latest as Build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY /fintracker .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=Build /fintracker/target/*.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
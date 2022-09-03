FROM openjdk:11-jdk-oracle
MAINTAINER AdelAlbediwy
COPY  target/HelloSpring-0.0.1-SNAPSHOT.jar HelloSpring.jar
ENTRYPOINT ["java","-jar","/HelloSpring.jar"]


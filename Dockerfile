FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/inst-score-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} inst-score.jar
ENTRYPOINT ["java","-jar","/inst-score.jar"]
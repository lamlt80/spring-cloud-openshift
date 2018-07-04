FROM openjdk:8-jdk-alpine

VOLUME /tmp

#ADD target/xapi-rate-service.jar xapi-rate-service.jar
COPY target/xapi-rate-service.jar /app/

ENV JAVA_OPTS=""

#WORKDIR /app

#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar xapi-rate-service.jar" ]
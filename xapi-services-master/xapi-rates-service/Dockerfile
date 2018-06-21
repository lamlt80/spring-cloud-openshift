FROM openjdk:8-jdk-alpine

VOLUME /tmp

ADD target/xapi-rate-service.jar xapi-rate-service.jar

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /xapi-rate-service.jar" ]
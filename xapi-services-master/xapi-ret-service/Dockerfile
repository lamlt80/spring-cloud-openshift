FROM openjdk:8-jdk-alpine

VOLUME /tmp

ADD target/xapi-ret-service.jar xapi-ret-service.jar

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /xapi-ret-service.jar" ]
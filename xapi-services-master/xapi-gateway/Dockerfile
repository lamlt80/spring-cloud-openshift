FROM openjdk:8-jdk-alpine

VOLUME /tmp

ADD target/xapi-gateway.jar xapi-gateway.jar

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /xapi-gateway.jar" ]
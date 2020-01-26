FROM gradle:5.2.1-jdk8-alpine as builder

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build

FROM openjdk:8u171-jre-alpine3.8

COPY --from=builder /home/gradle/src/build/libs/customer-api.jar /opt/

EXPOSE 8080

ENTRYPOINT exec java -jar /opt/customer-api.jar

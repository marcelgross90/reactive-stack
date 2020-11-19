FROM openjdk:11-jdk as builder

WORKDIR /src/

RUN export GRADLE_USER_HOME=$(pwd)/.gradle

ADD . .
RUN ./gradlew --build-cache build

FROM openjdk:11-jre

VOLUME /tmp

EXPOSE 8081

COPY --from=builder /src/build/libs/publisher-0.0.1-SNAPSHOT.jar /opt/publisher.jar

ENTRYPOINT ["java", "-jar", "-Done-jar.silent=true", "-Dspring.profiles.active=docker", "/opt/publisher.jar"]
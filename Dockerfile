FROM openjdk:8-jre-alpine3.9

COPY build/libs/challenge-*-SNAPSHOT.jar /challenge.jar

CMD ["java", "-jar", "/challenge.jar"]

EXPOSE 8080
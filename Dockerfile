FROM openjdk:21
WORKDIR /app

COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17
WORKDIR /app
COPY ./demo-0.0.1-SNAPSHOT.jar/ app
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "inventory-tracker.jar"]
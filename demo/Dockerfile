# make sure jdk can be found from docker hub
FROM openjdk:17-jdk-slim
WORKDIR /app
#s make sure have /app backslash at front, otherwise copy can fail
COPY ./app.jar/ /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
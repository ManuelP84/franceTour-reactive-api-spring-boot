FROM openjdk:11
EXPOSE 8081
COPY ./target/dockerize-france-tour-app.jar dockerize-france-tour-app.jar
ENTRYPOINT ["java", "-jar", "/dockerize-france-tour-app.jar"]
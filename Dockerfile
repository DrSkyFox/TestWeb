FROM openjdk:17
EXPOSE 8080
ARG JAR_FILE=target/TestWeb-0.0.1-SNAPSHOT.jar
WORKDIR opt/app
COPY ${JAR_FILE} testWeb.jar
ENTRYPOINT ["java", "-jar", "testWeb.jar"]
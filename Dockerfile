FROM openjdk:17-ea-22-oraclelinux8
RUN useradd -M -U docker
USER docker
EXPOSE 8080
ARG JAR_FILE=target/TestWeb-0.0.1-SNAPSHOT.jar
WORKDIR opt/app
LABEL custom.size=100
LABEL custom.msg="Hello, Mr. Unknow! Tell me.. Why u asking me"
LABEL spring.datasource.url="jdbc:postgresql://10.0.0.10/ptest"
COPY ${JAR_FILE} testWeb.jar
ENTRYPOINT ["java", "-jar", "testWeb.jar"]

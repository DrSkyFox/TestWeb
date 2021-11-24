FROM openjdk:17-alpine
RUN addgroup -S webtest && adduser -S webtest -G webtest
USER webtest
EXPOSE 8080
ARG JAR_FILE=target/TestWeb-0.0.1-SNAPSHOT.jar
WORKDIR opt/app
LABEL custom.size=100
      custom.msg="Hello, Mr. Unknow! Tell me.. Why u asking me"
COPY ${JAR_FILE} testWeb.jar
ENTRYPOINT ["java", "-jar", "testWeb.jar"]
# TestWeb


Test application.
Docker deployment example



docker build -t test-web-simple:1.0.0
docker run -d -p 8080:8080 -t  test-web-simple:1.0.0 .

Main parametrs of app:

server.port=8080
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui-custom.html
custom.size=100
custom.msg="Hello, Mr. Unknown !"

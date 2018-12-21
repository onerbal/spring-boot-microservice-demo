# spring-boot-microservice-demo

Example of a Microservices application written in Java with Spring Boot

### To run this project

```sh
$ docker build --tag=alpine-jdk:base --rm=true .
```

Create volumes:

```sh
docker volume create --name=mysql-data
docker volume create --name=config-repo
```
```sh
mvn clean package -DskipTests
```
```sh
docker-compose up --build
```

To access Eureka Server, go to url:
http://localhost:9091/

In order to access to UI, go to url:
http://localhost:8081/

License
----
MIT


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

* MySQL container:
    * hostname: mysql-machine 
    * Ports : 6603:3306 (<host_port>:<container_port>)
    * Username/Password: root/mypassword
* config-server:
    * container-name: config-server
    * Ports: 9090:9090
    * URL: http://localhost:9090
* service-discovery:
    * container-name: service-discovery
    * Ports: 9091:9091
    * URL: http://localhost:9091

License
----
MIT


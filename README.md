### Tech Stack

* Spring Boot 2.7.14
  * Spring Data
  * Spring Web
  * Spring Security
  * Spring Actuator
  * Spring Scheduler
  * Spring Validation
* JDK 11
* Angular 11
  * Prime NG 11
  * Node JS 16.19.1
* Liquibase
* Postgres 15
* Docker Compose

### Startup

For postgres startup you can run:
```
docker-compose up -d
```
For application startup you can run:
```
./gradlew bootRun
```
For web application you can run:
```
cd webapp \
    ng serve
```

### Improvements

* Do unit tests, integration and setup report;
* Setup cache;
* Setup Identity Server; OAuth 2 and JWT
* Setup management of task categories;
* Setup auditors features;
* Setup email sending;
* Setup Docker file;

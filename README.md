# Project Title

Short description or overview of the project.

## Prerequisites

- Java (version 11)
- Spring Boot (2.4.5)
- Maven build tool
- Docker
   ```bash
    FROM openjdk:11-jdk

    WORKDIR /app
    
    COPY target/car-parking-service-1.0.jar app.jar
    
    ENTRYPOINT ["java", "-jar", "app.jar"]
   ```
  
- Docker Compose (version '3.8')
   ```bash
      version: '3.8'
      services:
        spring-app:
          image: openjdk:11-jdk
          build:
            context: .
            dockerfile: Dockerfile
          ports:
            - "8080:8080" # Map Spring Boot app port to host
          expose:
            - 8080
          depends_on:
            - postgres
      
        postgres:
          image: postgres:latest
          ports:
            - "5432:5432" # Map PostgreSQL port to host
          expose:
            - 5432
          environment:
            POSTGRES_DB: db_car_parking
            POSTGRES_HOST_AUTH_METHOD: "trust"
            POSTGRES_USER: postgres
            POSTGRES_PASSWORD: postgres@123
    ```

## Getting Started

### Installation

1. Clone the repository:

    ```bash
    git clone [https://github.com/<your-username>/car-parking-service.git]
    ```

2. Build the project using Maven:

    ```bash
    cd your-project-directory
    mvn clean install
    ```

### Running the Application with Docker Compose

1. Ensure Docker and Docker Compose are installed.

2. Start the application using Docker Compose:

    ```bash
    docker-compose up --build
     => [spring-app internal] load .dockerignore                                                                                                                                   0.0s
    => => transferring context: 2B                                                                                                                                                0.0s 
    => [spring-app internal] load build definition from Dockerfile                                                                                                                0.0s 
    => => transferring dockerfile: 167B                                                                                                                                           0.0s 
    => [spring-app internal] load metadata for docker.io/library/openjdk:11-jdk                                                                                                   0.0s
    => [spring-app 1/3] FROM docker.io/library/openjdk:11-jdk                                                                                                                     0.3s
    => [spring-app internal] load build context                                                                                                                                   0.0s 
    => => transferring context: 84B                                                                                                                                               0.0s 
    => [spring-app 2/3] WORKDIR /app                                                                                                                                              0.0s 
    => [spring-app 3/3] COPY target/car-parking-service-1.0.jar app.jar                                                                                                           0.1s 
    => [spring-app] exporting to image                                                                                                                                            0.2s 
    => => exporting layers                                                                                                                                                        0.2s 
    => => writing image sha256:3e7c862896ed8911b9bd8f321faa7ec29eed656be174577242304bd053b0fee1                                                                                   0.0s 
    => => naming to docker.io/library/openjdk:11-jdk                                                                                                                              0.0s 
   [+] Running 2/2
    ✔ Container car-parking-service-postgres-1    Created                                                                                                                         0.0s 
    ✔ Container car-parking-service-spring-app-1  Recreated                                                                                                                       0.1s 
   Attaching to car-parking-service-postgres-1, car-parking-service-spring-app-1
   car-parking-service-postgres-1    | 
   car-parking-service-postgres-1    | PostgreSQL Database directory appears to contain a database; Skipping initialization
   car-parking-service-postgres-1    |
   car-parking-service-postgres-1    | 2023-12-09 08:07:42.443 UTC [1] LOG:  starting PostgreSQL 16.1 (Debian 16.1-1.pgdg120+1) on x86_64-pc-linux-gnu, compiled by gcc (Debian 12.2.0-14) 12.2.0, 64-bit
   car-parking-service-postgres-1    | 2023-12-09 08:07:42.443 UTC [1] LOG:  listening on IPv4 address "0.0.0.0", port 5432
   car-parking-service-postgres-1    | 2023-12-09 08:07:42.444 UTC [1] LOG:  listening on IPv6 address "::", port 5432
   car-parking-service-postgres-1    | 2023-12-09 08:07:42.451 UTC [1] LOG:  listening on Unix socket "/var/run/postgresql/.s.PGSQL.5432"
   car-parking-service-postgres-1    | 2023-12-09 08:07:42.462 UTC [29] LOG:  database system was shut down at 2023-12-09 07:44:50 UTC
   car-parking-service-postgres-1    | 2023-12-09 08:07:42.473 UTC [1] LOG:  database system is ready to accept connections
   car-parking-service-spring-app-1  | 
   car-parking-service-spring-app-1  |   .   ____          _            __ _ _
   car-parking-service-spring-app-1  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
   car-parking-service-spring-app-1  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
   car-parking-service-spring-app-1  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
   car-parking-service-spring-app-1  |   '  |____| .__|_| |_|_| |_\__, | / / / /
   car-parking-service-spring-app-1  |  =========|_|==============|___/=/_/_/_/
   car-parking-service-spring-app-1  |  :: Spring Boot ::                (v2.4.5)
   car-parking-service-spring-app-1  |
   car-parking-service-spring-app-1  | 2023-12-09 08:07:43.882  INFO 1 --- [           main] c.t.car.parking.CarParkingApplication    : Starting CarParkingApplication v1.0 using Java 11.0.16 on 71201bacc2fc with PID 1 (/app/app.jar started by root in /app)
   car-parking-service-spring-app-1  | 2023-12-09 08:07:43.889  INFO 1 --- [           main] c.t.car.parking.CarParkingApplication    : No active profile set, falling back to default profiles: default
   car-parking-service-spring-app-1  | 2023-12-09 08:07:44.592  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
   car-parking-service-spring-app-1  | 2023-12-09 08:07:44.647  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 45 ms. Found 1 JPA repository interfaces.
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.223  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.235  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.236  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.45]
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.290  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.290  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1346 ms
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.477  INFO 1 --- [           main] o.f.c.internal.license.VersionPrinter    : Flyway Community Edition 7.1.1 by Redgate
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.488  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.602  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.648  INFO 1 --- [           main] o.f.c.i.database.base.DatabaseType       : Database: jdbc:postgresql://postgres:5432/db_car_parking (PostgreSQL 16.1)
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.657  WARN 1 --- [           main] o.f.c.internal.database.base.Database    : Flyway upgrade recommended: org.flywaydb.core.i
   nternal.database.postgresql.PostgreSQLDatabaseType@40e10ff8 16.1 is newer than this version of Flyway and support has not been tested. The latest supported version of org.flywaydb.core.internal.database.postgresql.PostgreSQLDatabaseType@40e10ff8 is 13.
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.719  INFO 1 --- [           main] o.f.core.internal.command.DbValidate     : Successfully validated 2 migrations (execution time 00:00.047s)
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.730  INFO 1 --- [           main] o.f.core.internal.command.DbMigrate      : Current version of schema "public": 2
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.731  INFO 1 --- [           main] o.f.core.internal.command.DbMigrate      : Schema "public" is up to date. No migration necessary.
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.843  INFO 1 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
   car-parking-service-spring-app-1  | 2023-12-09 08:07:45.904  INFO 1 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.30.Final
   car-parking-service-spring-app-1  | 2023-12-09 08:07:46.050  INFO 1 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
   car-parking-service-spring-app-1  | 2023-12-09 08:07:46.177  INFO 1 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.PostgreSQL10Dialect
   car-parking-service-spring-app-1  | 2023-12-09 08:07:46.774  INFO 1 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
   text path ''
   car-parking-service-spring-app-1  | 2023-12-09 08:07:47.956  INFO 1 --- [           main] c.t.car.parking.CarParkingApplication    : Started CarParkingApplication in 4.55 seconds (JVM running for 5.174)
   car-parking-service-spring-app-1  | 2023-12-09 08:07:47.958  INFO 1 --- [           main] c.t.c.p.thirdparty.ExternalAPIService    : Call external api https://api.data.gov.sg/v1/transport/carpark-availability to get car park availability
   car-parking-service-spring-app-1  | 2023-12-09 08:07:48.817  INFO 1 --- [           main] .p.t.CarParksAvailabilitySynchronization : Loading Car Park Availability total items:1    
   car-parking-service-spring-app-1  | 2023-12-09 08:08:48.922  INFO 1 --- [nio-8080-exec-2] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
   car-parking-service-spring-app-1  | 2023-12-09 08:08:48.923  INFO 1 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
   car-parking-service-spring-app-1  | 2023-12-09 08:08:48.925  INFO 1 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms

 ```


3. Access the application :http://localhost:8080/api/v1/carparks/nearest?latitude=34570.2904&longitude=41861.2936&page=1&per_page=10
  ```bash
      [
       {
           "carpark_number": "SK90",
           "address": "BLK 332 ANCHORVALE LINK",
           "latitude": 34570.2904,
           "longitude": 41861.2936,
           "total_lots": 508,
           "available_lots": 350,
           "distance_kilometers": 0.0
       },
       {
           "carpark_number": "SK33",
           "address": "BLK 201 SENGKANG EAST ROAD",
           "latitude": 34574.9636,
           "longitude": 41140.2415,
           "total_lots": 546,
           "available_lots": 381,
           "distance_kilometers": 532.0202851323155
       },
       {
           "carpark_number": "BRM1",
           "address": "BLK 112A WHAMPOA ROAD",
           "latitude": 30605.3384,
           "longitude": 34301.5549,
           "total_lots": 335,
           "available_lots": 193,
           "distance_kilometers": 551.3886703749938
       },
       {
           "carpark_number": "CK3",
           "address": "BLK 118/124 TECK WHYE LANE",
           "latitude": 18734.6348,
           "longitude": 40064.9164,
           "total_lots": 282,
           "available_lots": 48,
           "distance_kilometers": 622.892075431982
       },
       {
           "carpark_number": "TJ29",
           "address": "BLK 155A YUNG LOH ROAD",
           "latitude": 15645.0192,
           "longitude": 34485.0749,
           "total_lots": 306,
           "available_lots": 290,
           "distance_kilometers": 663.4984025087359
       },
       {
           "carpark_number": "BR5",
           "address": "BLK 74/75 WHAMPOA DRIVE",
           "latitude": 30768.0099,
           "longitude": 34127.2333,
           "total_lots": 152,
           "available_lots": 59,
           "distance_kilometers": 674.9822730095511
       },
       {
           "carpark_number": "PP5",
           "address": "BLK 113 TO 120 POTONG PASIR AVENUE 1",
           "latitude": 31328.03,
           "longitude": 35388.25,
           "total_lots": 346,
           "available_lots": 181,
           "distance_kilometers": 803.8896964292694
       },
       {
           "carpark_number": "SB6",
           "address": "BLK 306A CANBERRA ROAD",
           "latitude": 26802.1975,
           "longitude": 47444.0071,
           "total_lots": 518,
           "available_lots": 376,
           "distance_kilometers": 885.0244161479543
       },
       {
           "carpark_number": "A74",
           "address": "BLK 646/649 ANG MO KIO STREET 61",
           "latitude": 29166.97,
           "longitude": 40069.8164,
           "total_lots": 185,
           "available_lots": 75,
           "distance_kilometers": 1006.9336257518104
       },
       {
           "carpark_number": "J84M",
           "address": "BLK 854A JURONG WEST STREET 81",
           "latitude": 12771.2097,
           "longitude": 36650.4919,
           "total_lots": 285,
           "available_lots": 174,
           "distance_kilometers": 1022.2969974992985
       }
   ]
   ```
4. Access the application: http://localhost:8080/api/v1/carparks/nearest?longitude=41861.2936&page=1&per_page=10
   ```bash
      {
       "timestamp": "2023-12-09T08:08:48.984+00:00",
       "status": 400,
       "error": "Bad Request",
       "message": "",
       "path": "/api/v1/carparks/nearest"
      }
   ```
### Stopping the Application

To stop the application, run:

```bash
docker-compose down


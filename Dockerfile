FROM openjdk:11-jdk

WORKDIR /app

COPY target/car-parking-service-1.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
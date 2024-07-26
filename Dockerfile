FROM openjdk:21-jdk

ENV LANG=C.UTF-8
WORKDIR /var/app
COPY target/wealthvista-service-0.0.1-SNAPSHOT.jar wealthvista-service.jar
ENTRYPOINT ["java", "-jar", "wealthvista-service.jar"]
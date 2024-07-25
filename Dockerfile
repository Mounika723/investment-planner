FROM openjdk:21-jdk

ENV LANG=C.UTF-8
WORKDIR /var/app
COPY target/investment-planner-0.0.1-SNAPSHOT.jar investment.jar
ENTRYPOINT ["java", "-Dserver.port=8080", "-jar", "investment.jar"]
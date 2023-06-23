FROM openjdk:8
EXPOSE 8080
ADD target/car-rental.jar car-rental.jar
ENTRYPOINT ["java","-jar","/car-rental.jar"]
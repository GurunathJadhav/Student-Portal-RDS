FROM openjdk:17
COPY target/Student-portal.jar /usr/app/
WORKDIR /usr/app/
EXPOSE 8080
ENTRYPOINT ["java","-jar","Student-portal.jar"]
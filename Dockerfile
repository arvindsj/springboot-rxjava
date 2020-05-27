FROM java:8-jdk-alpine
COPY ./build/libs/springboot-rxjava-1.0.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springboot-rxjava-1.0.jar"]
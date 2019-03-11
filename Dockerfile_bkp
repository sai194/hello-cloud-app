FROM openjdk:latest
LABEL maintainer="Sai Yeluri <sai194@gmail.com>"
LABEL description="Hello cloud"
RUN mkdir /opt/application/
COPY ./target/hello-cloud-app-1.0.jar /opt/application/
WORKDIR /opt/application/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "hello-cloud-app-1.0.jar"]
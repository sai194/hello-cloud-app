FROM sai194/ubuntuwithjdkandmaven
LABEL maintainer="Sai Yeluri <sai194@gmail.com>"
LABEL description="Hello cloud"
RUN apt-get update && \
    apt-get install -yq --no-install-recommends wget pwgen ca-certificates git && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

RUN mkdir -p /app && mkdir -p /app/jars
WORKDIR /app
RUN git clone https://github.com/sai194/hello-cloud-app.git
WORKDIR hello-cloud-app
RUN mvn clean install
COPY ./target/hello-cloud-app-1.0.jar /app/jars/
WORKDIR /app/jars/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "hello-cloud-app-1.0.jar"]

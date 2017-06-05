FROM maven:3.5.0-jdk-8-alpine

LABEL maintainer "ferrari.marco@gmail.com"

ENV WORKDIR /usr/app
RUN mkdir $WORKDIR
WORKDIR $WORKDIR

COPY target/database-uploader-exec.jar database-uploader-exec.jar

ENTRYPOINT ["java", "-jar", "database-uploader-exec.jar"]

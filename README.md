# Invoices Processor

* Development branch: [![Build Status](https://travis-ci.org/aifa-gov-it/invoices-processor.svg?branch=development)](https://travis-ci.org/aifa-gov-it/invoices-processor) [![Coverage Status](https://coveralls.io/repos/github/aifa-gov-it/invoices-processor/badge.svg?branch=development)](https://coveralls.io/github/aifa-gov-it/invoices-processor?branch=development) [![Quality Gate Status](https://sonarqube.com/api/badges/gate?key=it.gov.aifa%3Adatabase-uploader%3Adevelopment)](https://sonarqube.com/dashboard?id=it.gov.aifa%3Adatabase-uploader%3Adevelopment)
* Master branch: [![Build Status](https://travis-ci.org/aifa-gov-it/invoices-processor.svg?branch=master)](https://travis-ci.org/aifa-gov-it/invoices-processor) [![Coverage Status](https://coveralls.io/repos/github/aifa-gov-it/invoices-processor/badge.svg?branch=master)](https://coveralls.io/github/aifa-gov-it/invoices-processor?branch=master) [![Quality Gate Status](https://sonarqube.com/api/badges/gate?key=it.gov.aifa%3Adatabase-uploader%3A3Amaster)](https://sonarqube.com/dashboard?id=it.gov.aifa%3Adatabase-uploader%3A3Amaster)

## Dependencies

- Docker 1.12+

## How to run

1. Validate XML files using the given XSD: when running the container, mount the directories containing the XML and XSD input:

    ```
    docker run --rm -it \
      -v /path/to/xml/files/directory/:/usr/invoices-xml-validator/xml \
      -v /path/to/xml/files/directory/your-schema.xsd:/usr/invoices-xml-validator/xsd/schema.xsd \
      aifa-gov-it/invoices-xml-validator:latest
    ```

1. Upload data with dabase-uploader:
    1. Build the application (you'll need a properly configured `/.m2/settings-security.xml` containing the master password to decrypt the ones in `settings.xml`):

        ```
        docker run --rm -it \
          -v /path/to/.m2/settings-security.xml:/root/.m2/settings-security.xml \
          -v /path/to/database-uploader/source:/usr/app \
          -w /usr/app \
          -t maven:3.5.0-jdk-8-alpine \
          mvn clean install -s settings.xml
        ```

    1. Run the application with no arguments to show the help text (note that when running the container you may want to mount additional volumes according to the options you specify):

        ```
        docker run --rm -it \
          -v /path/to/database-uploader-exec.jar:/usr/app/database-uploader-exec.jar \
          -w /usr/app \
          -t openjdk:8u121-jdk-alpine \
          java -jar database-uploader-exec.jar
        ```

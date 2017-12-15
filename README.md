# Invoices Processor

* Development branch:
[![Build Status](https://travis-ci.org/aifa-gov-it/database-uploader.svg?branch=development)](https://travis-ci.org/aifa-gov-it/database-uploader) [![Coverage Status](https://sonarcloud.io/api/badges/measure?key=it.gov.aifa%3Adatabase-uploader%3Adevelopment&metric=coverage)](https://sonarcloud.io/dashboard?id=it.gov.aifa%3Adatabase-uploader%3Adevelopment) [![Quality Gate Status](https://sonarcloud.io/api/badges/gate?key=it.gov.aifa%3Adatabase-uploader%3Adevelopment)](https://sonarcloud.io/dashboard?id=it.gov.aifa%3Adatabase-uploader%3Adevelopment) [![BCH compliance](https://bettercodehub.com/edge/badge/aifa-gov-it/database-uploader?branch=development)](https://bettercodehub.com/)
* Master branch: [![Build Status](https://travis-ci.org/aifa-gov-it/database-uploader.svg?branch=master)](https://travis-ci.org/aifa-gov-it/database-uploader) [![Coverage Status](https://sonarcloud.io/api/badges/measure?key=it.gov.aifa%3Adatabase-uploader%3Amaster&metric=coverage)](https://sonarcloud.io/dashboard?id=it.gov.aifa%3Adatabase-uploader%3Amaster) [![Quality Gate Status](https://sonarcloud.io/api/badges/gate?key=it.gov.aifa%3Adatabase-uploader%3Amaster)](https://sonarcloud.io/dashboard?id=it.gov.aifa%3Adatabase-uploader%3Amaster) [![BCH compliance](https://bettercodehub.com/edge/badge/aifa-gov-it/database-uploader?branch=master)](https://bettercodehub.com/)

## Dependencies

- Docker 1.12+

## Supported tags and respective Dockerfile links
- `latest`, `1.0.0`: [Dockerfile](https://github.com/aifa-gov-it/database-uploader/blob/1.0.0/Dockerfile)
- `master-latest`: [Dockerfile](https://github.com/aifa-gov-it/database-uploader/blob/master/Dockerfile)
- `dev-latest`: [Dockerfile](https://github.com/aifa-gov-it/database-uploader/blob/development/Dockerfile)

## How to run

Run the application with no arguments to show the help text (note that when running the container you may want to mount additional volumes according to the options you specify):

```
docker run --rm -it \
  aifagovit/database-uploader:<tag>
```

Here is an example to run the application to upload some XMLs:

```
docker run --rm -it -v /path/to/xmls/on/the/host/:/tmp/invoice-xml aifagovit/database-uploader:<tag> --import-invoices --path=/tmp/invoice-xml/*.xml --spring.datasource.username=USERNAME --spring.datasource.password=PASSWORD --spring.datasource.url="jdbc:oracle:thin:@DB_HOST:DB_PORT/DB_NAME"
```

## Development tips

### How to clone the repository

This repository has some Git submodules so you should clone it using the `--recursive` switch: `$ git clone git://github.com/<user>/<repo>.git --recursive`

### Docker Hub Automated Build

Each commit in the `development` or `master` branches and every git tag is automatically built by Docker Hub.

The configuration is in https://hub.docker.com/r/aifagovit/database-uploader/~/settings/automated-builds/

When tagging a new release the relevant link in the README should be updated.

### Generate a diff changelog

After running the `database-uploader` (it's not necessary to specify any option) against any database (even in-memory ones like H2) you can generate a Liquibase report or a changelog containing the differences between the two databases or even against JPA Entity definitions.

- Generate a changelog from JPA Entities (Oracle example):

    ```
    mvn liquibase:diff \
      -Dliquibase.driver=oracle.jdbc.OracleDriver \
      -Dliquibase.url=jdbc:oracle:thin:@host:1521/DB \ # JDBC URL pointing to the target database
      -Dliquibase.username=USER \ # Username to connect to the target database
      -Dliquibase.password=PASSWORD \ # Password to connect to the target database
      -Dliquibase.referenceUrl="hibernate:spring:it.gov.aifa.invoice_processor.entity?dialect=org.hibernate.dialect.Oracle12cDialect&amp;hibernate.physical_naming_strategy=org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy"
      # -Dliquibase.diffChangeLogFile=target/liquibase/db.changelog-diff.yaml # Uncomment this line to generate a changelog file instead of a report
    ```

- Generate a changelog from reference database: this is useful to compare a target database to a reference database

    ```
    mvn liquibase:diff \
      -Dliquibase.driver=oracle.jdbc.OracleDriver \
      -Dliquibase.url=jdbc:oracle:thin:@host:1521/DB \ # JDBC URL pointing to the target database
      -Dliquibase.username=USER \ # Username to connect to the target database
      -Dliquibase.password=PASSWORD \ # Password to connect to the target database
      -Dliquibase.referenceDriver=org.h2.Driver \
      -Dliquibase.referenceUrl=jdbc:h2:mem:testdb \ # JDBC URL pointing to the reference database
      -Dliquibase.referenceUsername=USER \ # Username to connect to the reference database
      -Dliquibase.referencePassword=PASSWORD \ # Password to connect to the reference database
      # -Dliquibase.diffChangeLogFile=target/liquibase/db.changelog-diff.yaml # Uncomment this line to generate a changelog file instead of a report
    ```

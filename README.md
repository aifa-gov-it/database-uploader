# Database Uploader

* Development branch:
[![Build Status](https://travis-ci.org/aifa-gov-it/database-uploader.svg?branch=development)](https://travis-ci.org/aifa-gov-it/database-uploader) [![Coverage Status](https://sonarcloud.io/api/badges/measure?key=it.gov.aifa%3Adatabase-uploader%3Adevelopment&metric=coverage)](https://sonarcloud.io/dashboard?id=it.gov.aifa%3Adatabase-uploader%3Adevelopment) [![Quality Gate Status](https://sonarcloud.io/api/badges/gate?key=it.gov.aifa%3Adatabase-uploader%3Adevelopment)](https://sonarcloud.io/dashboard?id=it.gov.aifa%3Adatabase-uploader%3Adevelopment) [![BCH compliance](https://bettercodehub.com/edge/badge/aifa-gov-it/database-uploader?branch=development)](https://bettercodehub.com/)
* Master branch: [![Build Status](https://travis-ci.org/aifa-gov-it/database-uploader.svg?branch=master)](https://travis-ci.org/aifa-gov-it/database-uploader) [![Coverage Status](https://sonarcloud.io/api/badges/measure?key=it.gov.aifa%3Adatabase-uploader%3Amaster&metric=coverage)](https://sonarcloud.io/dashboard?id=it.gov.aifa%3Adatabase-uploader%3Amaster) [![Quality Gate Status](https://sonarcloud.io/api/badges/gate?key=it.gov.aifa%3Adatabase-uploader%3Amaster)](https://sonarcloud.io/dashboard?id=it.gov.aifa%3Adatabase-uploader%3Amaster) [![BCH compliance](https://bettercodehub.com/edge/badge/aifa-gov-it/database-uploader?branch=master)](https://bettercodehub.com/)

[![Docker Pulls](https://img.shields.io/docker/pulls/aifagovit/database-uploader.svg)](https://hub.docker.com/r/aifagovit/database-uploader/)

[![Docker Automated build](https://img.shields.io/docker/automated/aifagovit/database-uploader.svg)](https://hub.docker.com/r/aifagovit/database-uploader/)

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
docker run --rm -it -v /path/to/xmls/on/the/host/:/tmp/invoice-xml aifagovit/database-uploader:<tag> --import-invoices --path=/tmp/invoice-xml/**/*.xml --spring.datasource.username=USERNAME --spring.datasource.password=PASSWORD --spring.datasource.url="jdbc:oracle:thin:@DB_HOST:DB_PORT/DB_NAME"
```

### Invalid IBAN codes

Some IBAN codes have been set to a dummy value (`XXXXXXXXXXXXXXX`). Such value is not compatible with the provided XSD. It's therefore necessary to use a valid value, like `XX00XXXXXXXXXXX`. Here is an example command to execute such substitution:

```
find /path/to/xmls -type f -print0 -iname "*.xml" | xargs -0 sed -i 's/XXXXXXXXXXXXXXX/XX00XXXXXXXXXXX/g'
```

## Development tips

### Install Oracle Driver and UCP

To successfully build this project with Maven you need to install two JARs in your local Maven repository because they are not available in Maven Central (but only on the Oracle Maven Repository, for which you need an Oracle account). Just run the following commands from the root of this project:

```
mvn install:install-file -Dfile=lib/ojdbc8/12.2.0.1/ojdbc8-12.2.0.1.jar -DpomFile=lib/ojdbc8/12.2.0.1/ojdbc8-12.2.0.1.pom \
  && mvn install:install-file -Dfile=lib/ucp/12.2.0.1/ucp-12.2.0.1.jar -DpomFile=lib/ucp/12.2.0.1/ucp-12.2.0.1.pom
```

### Build the Docker image

```
docker build -t aifagovit/database-uploader:<tag> .
```

### Travis CI Automated Build

Each commit in any branch or pull request and every git tag is automatically built by [Travis CI](https://travis-ci.org/aifa-gov-it/database-uploader).
Travis CI configuration is in the [`.travis.yml`](.travis.yml) file.

#### Lint Dockerfiles and Shell Scripts

Dockerfiles and shell scripts are analyzed on each Travis build. You can manually run this analysis with the following command:

```
script/test-dockerfiles.sh --docker-context-path=.
```

#### SonarQube Project Analysis

The code is analyzed by SonarQube on each Travis build. Check the relevant badges in this README for the links.

### Docker Hub Automated Build

Each commit in the `development` or `master` branches and every git tag is automatically built by Docker Hub.

The configuration is in https://hub.docker.com/r/aifagovit/database-uploader/~/settings/automated-builds/

When tagging a new release the relevant link in the README should be updated.

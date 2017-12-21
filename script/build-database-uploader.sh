#!/bin/sh

# See https://github.com/travis-ci/travis-ci/issues/1066
# Fail if one of the commands of this script fails
set -e

echo "Building database-uploader in a separate step to invoke SonarQube"
docker run --rm -it \
  -v "$TRAVIS_BUILD_DIR":/usr/app \
  -w /usr/app \
  -t maven:3.5.2-jdk-8-alpine \
  /bin/ash -c "
  mvn install:install-file -Dfile=lib/ojdbc8/12.2.0.1/ojdbc8-12.2.0.1.jar -DpomFile=lib/ojdbc8/12.2.0.1/ojdbc8-12.2.0.1.pom \
  && mvn install:install-file -Dfile=lib/ucp/12.2.0.1/ucp-12.2.0.1.jar -DpomFile=lib/ucp/12.2.0.1/ucp-12.2.0.1.pom \
  && mvn clean install \
    jacoco:report jacoco:report-integration \
    sonar:sonar \
    -Dbranch=$TRAVIS_BRANCH -DpullRequest=$TRAVIS_PULL_REQUEST -DserviceJobId=$TRAVIS_JOB_ID -DserviceName='travis-ci' \
    -Dsonar.host.url=https://sonarqube.com -Dsonar.organization=aifa-gov-it -Dsonar.login=$SONARQUBE_LOGIN_TOKEN -Dsonar.branch=$TRAVIS_BRANCH
  "

echo "Build aifa-gov-it/database-uploader"
docker build --rm -t aifa-gov-it/database-uploader:latest .

echo "Try to run aifagovit/database-uploader to catch basic runtime errors"
docker run --rm -it aifa-gov-it/database-uploader:latest

set +e

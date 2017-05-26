#!/bin/sh

# See https://github.com/travis-ci/travis-ci/issues/1066
# Fail if one of the commands of this script fails
set -e

echo "Building database-uploader"
docker run --rm -it \
  -v $TRAVIS_BUILD_DIR:/usr/app \
  -w /usr/app/database-uploader \
  -t maven:3.5.0-jdk-8-alpine \
  mvn clean install \
    jacoco:report jacoco:report-integration \
    coveralls:report \
    sonar:sonar \
    -Dbranch=$TRAVIS_BRANCH -DpullRequest=$TRAVIS_PULL_REQUEST -DserviceJobId=$TRAVIS_JOB_ID -DserviceName="travis-ci" \
    -Dsonar.host.url=https://sonarqube.com -Dsonar.organization=aifa-gov-it -Dsonar.login=$SONARQUBE_LOGIN_TOKEN -Dsonar.branch=$TRAVIS_BRANCH

cd $TRAVIS_BUILD_DIR/database-uploader

echo "Building aifagovit/database-uploader Docker image"
docker build --rm -t aifagovit/database-uploader:latest .

echo "Try to run aifagovit/database-uploader"
docker run --rm -it aifagovit/database-uploader:latest

set +e

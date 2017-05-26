#!/bin/sh

# See https://github.com/travis-ci/travis-ci/issues/1066
# Fail if one of the commands of this script fails
set -e

echo "Building aifa-gov-it/database-uploader"
docker build --rm -t --file=Dockerfile-build aifa-gov-it/database-uploader-build:latest .

echo "Building database-uploader"
docker run --rm -it \
  -v $TRAVIS_BUILD_DIR:/usr/app \
  -w /usr/app/database-uploader \
  -t aifa-gov-it/database-uploader-build:lates \
  mvn clean install \
    jacoco:report jacoco:report-integration \
    coveralls:report \
    sonar:sonar \
    -Dbranch=$TRAVIS_BRANCH -DpullRequest=$TRAVIS_PULL_REQUEST -DserviceJobId=$TRAVIS_JOB_ID -DserviceName="travis-ci" \
    -Dsonar.host.url=https://sonarqube.com -Dsonar.organization=aifa-gov-it -Dsonar.login=$SONARQUBE_LOGIN_TOKEN -Dsonar.branch=$TRAVIS_BRANCH

cd $TRAVIS_BUILD_DIR/database-uploader

echo "Try to run aifagovit/database-uploader"
docker build --rm -t aifa-gov-it/database-uploader:latest .
docker run --rm -it aifagovit/database-uploader:latest

set +e

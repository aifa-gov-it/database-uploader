#!/bin/sh

# See https://github.com/travis-ci/travis-ci/issues/1066
# Fail if one of the commands of this script fails
set -e

echo "Setting up Maven settings-security.xml"
export MAVEN_SETTINGS_SECURITY_PATH=$HOME/.m2/settings-security.xml
echo "Set MAVEN_SETTINGS_SECURITY_PATH to $MAVEN_SETTINGS_SECURITY_PATH"
mkdir -p $HOME/.m2
echo "$MAVEN_SETTINGS_SECURITY" > $MAVEN_SETTINGS_SECURITY_PATH

echo "Building database-uploader"
docker run --rm -it \
  -v $MAVEN_SETTINGS_SECURITY_PATH:/root/.m2/settings-security.xml \
  -v $TRAVIS_BUILD_DIR:/usr/app \
  -w /usr/app/database-uploader \
  -t maven:3.5.0-jdk-8-alpine \
  mvn clean install \
    jacoco:report jacoco:report-integration \
    coveralls:report \
    sonar:sonar \
    -s settings.xml \
    -Dbranch=$TRAVIS_BRANCH -DpullRequest=$TRAVIS_PULL_REQUEST -DserviceJobId=$TRAVIS_JOB_ID -DserviceName="travis-ci" \
    -Dsonar.host.url=https://sonarqube.com -Dsonar.organization=aifa-gov-it -Dsonar.login=$SONARQUBE_LOGIN_TOKEN

echo "Building aifagovit/database-uploader Docker image"
cd $TRAVIS_BUILD_DIR/database-uploader
docker build --rm -t aifagovit/database-uploader:latest .

set +e

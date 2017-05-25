#!/bin/sh

# See https://github.com/travis-ci/travis-ci/issues/1066
# Fail if one of the commands of this script fails
set -e

echo "Setting up Maven settings-security.xml"
export MAVEN_SETTINGS_SECURITY_PATH=$HOME/.m2/settings-security.xml
echo "Set MAVEN_SETTINGS_SECURITY_PATH to $MAVEN_SETTINGS_SECURITY_PATH"
mkdir -p $HOME/.m2
echo "$MAVEN_SETTINGS_SECURITY" > $MAVEN_SETTINGS_SECURITY_PATH

echo "Setting up DATABASE_UPLOADER_PROJECT_PATH"
export DATABASE_UPLOADER_PROJECT_PATH=$TRAVIS_BUILD_DIR/database-uploader
echo "Set DATABASE_UPLOADER_PROJECT_PATH to $DATABASE_UPLOADER_PROJECT_PATH"
cd $DATABASE_UPLOADER_PROJECT_PATH
echo "Building $DATABASE_UPLOADER_PROJECT_PATH"
docker run --rm -it \
  -v $MAVEN_SETTINGS_SECURITY_PATH:/root/.m2/settings-security.xml \
  -v $DATABASE_UPLOADER_PROJECT_PATH:/usr/app \
  -w /usr/app \
  -t maven:3.5.0-jdk-8-alpine \
  mvn clean install jacoco:report jacoco:report-integration coveralls:report -s settings.xml

echo "Building aifagovit/database-uploader Docker image"
docker build --rm -t aifagovit/database-uploader:latest .

set +e

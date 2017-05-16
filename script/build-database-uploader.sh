#!/bin/sh

export MAVEN_SETTINGS_SECURITY_PATH=$HOME/.m2/settings-security.xml
echo "Setting up $MAVEN_SETTINGS_SECURITY_PATH"
mkdir $HOME/.m2
echo "$MAVEN_SETTINGS_SECURITY" > $MAVEN_SETTINGS_SECURITY_PATH
export $DATABASE_UPLOADER_PROJECT_PATH=$TRAVIS_BUILD_DIR/database-uploader
cd $DATABASE_UPLOADER_PROJECT_PATH
echo "Building $DATABASE_UPLOADER_PROJECT_PATH"
docker run --rm -it \
  -v $(MAVEN_SETTINGS_SECURITY_PATH):/root/.m2/settings-security.xml \
  -v $(DATABASE_UPLOADER_PROJECT_PATH):/usr/app \
  -w /usr/app \
  -t maven:3.5.0-jdk-8-alpine \
  mvn clean install -s settings.xml
docker build --rm -t aifagovit/database-uploader:latest .

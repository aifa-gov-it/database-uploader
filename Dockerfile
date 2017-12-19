FROM maven:3.5.2-jdk-8-alpine

LABEL maintainer "ferrari.marco@gmail.com"

ENV WORKDIR /usr/app
RUN mkdir $WORKDIR
WORKDIR $WORKDIR

COPY pom.xml .
COPY lib/ lib/
COPY src/ src/

RUN mvn install:install-file -Dfile=lib/ojdbc8/12.2.0.1/ojdbc8-12.2.0.1.jar -DpomFile=lib/ojdbc8/12.2.0.1/ojdbc8-12.2.0.1.pom \
  && mvn install:install-file -Dfile=lib/ucp/12.2.0.1/ucp-12.2.0.1.jar -DpomFile=lib/ucp/12.2.0.1/ucp-12.2.0.1.pom \
  && mvn clean install
RUN mv target/database-uploader-exec.jar ./database-uploader-exec.jar \
  && rm -rf target/ \
  && rm -rf pom.xml \
  && rm -rf lib/ \
  && rm -rf logs/ \
  && rm -rf src/

COPY start-database-uploader.sh /usr/local/bin/start-database-uploader.sh
RUN chmod a+x /usr/local/bin/start-database-uploader.sh

ENTRYPOINT ["start-database-uploader.sh"]

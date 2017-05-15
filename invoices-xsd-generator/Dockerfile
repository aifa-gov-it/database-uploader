FROM java:8-jdk-alpine

RUN apk --update add \
  wget \
  unzip

ENV WORKING_DIRECTORY /usr/invoices-xsd-generator
RUN mkdir -p $WORKING_DIRECTORY/xml \
  mkdir -p $WORKING_DIRECTORY/xsd
WORKDIR $WORKING_DIRECTORY
ENV TRANG_FILE_NAME V20151127.zip
RUN wget https://github.com/relaxng/jing-trang/archive/$TRANG_FILE_NAME \
  && unzip $TRANG_FILE_NAME \
  && rm $TRANG_FILE_NAME

ENV TRANG_DIRECTORY jing-trang-20151127
RUN chmod a+x ./$TRANG_DIRECTORY/ant && ./$TRANG_DIRECTORY/ant

RUN mkdir -p $WORKING_DIRECTORY/xml/xsd

CMD ["/bin/sh", "-c", "java -jar jing-trang-20151127/build/trang.jar -I xml -O xsd ./xml/*.xml ./xsd/schema.xsd"]

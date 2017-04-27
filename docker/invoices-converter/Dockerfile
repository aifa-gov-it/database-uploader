FROM python:3.6-alpine

RUN pip install https://github.com/hay/xml2json/zipball/master

ENV WORKING_DIRECTORY /usr/invoices-converter
RUN mkdir -p $WORKING_DIRECTORY/json \
  && mkdir -p $WORKING_DIRECTORY/xml
ADD usr/invoices-converter/ $WORKING_DIRECTORY
WORKDIR $WORKING_DIRECTORY

RUN chmod a+x $WORKING_DIRECTORY/script/convert-all-xml.sh

ENTRYPOINT ["/usr/invoices-converter/script/convert-all-xml.sh"]
CMD ["/usr/invoices-converter/xml", "/usr/invoices-converter/json"]

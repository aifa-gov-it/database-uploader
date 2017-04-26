FROM debian:jessie

# Install xmllint
RUN apt-get update \
  && apt-get install -y \
    libxml2-utils

ENV WORKING_DIRECTORY /usr/invoices-xml-validator
WORKDIR $WORKING_DIRECTORY

CMD ["/bin/sh", "-c", "xmllint --noout --schema ./xsd/schema.xsd ./xml/*"]

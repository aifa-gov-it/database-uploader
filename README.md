# Invoices Processor

## Dependencies

- Docker 1.12+

## How to run

1. Generate a XSD from the XML files:
    Example: `docker run --rm -it -v /path/to/xml/files/directory/:/usr/invoices-xsd-generator/xml  ferrarimarco/xsd-generator:latest`

1. Convert XML to JSON: when running the container, mount the directories where you want to store the JSON output and containing the XML input.

    Example: `docker run --rm -it -v /path/to/json/output:/usr/invoices-converter/json -v /path/to/input:/usr/invoices-converter/xml ferrarimarco/xml-json:latest`

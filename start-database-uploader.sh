#!/bin/sh -e

# some IBAN codes are not valid according to the XSD, let's fix this
find "$WORKDIR" -type f -print0 -iname "*.xml" | xargs -0 sed -i 's/XXXXXXXXXXXXXXX/XX00XXXXXXXXXXX/g'

java -jar database-uploader-exec.jar
#!/bin/sh

prefix="$1/"
suffix=".xml"
for X in $1/*; do
  output=${X#$prefix}
  output=$2/${output%$suffix}.json
  xml2json -t xml2json --pretty -o $output $X
done

#!/bin/sh

prefix="$1/"
suffix=".xml"
for X in $1/*; do
  output_file_name=${X#$prefix}
  output_file_name=$2/${output_file_name%$suffix}
  output_file_name_ext=${output_file_name}.json
  output_file_name_linked_invoice_data_ext=${output_file_name}_DatiFattureCollegate.json
  output_file_name_purchase_lines_data_ext=${output_file_name}_DettaglioLinee.json
  output_file_name_post_processed_ext=${output_file_name}_post_processed.json
  echo "Processing: " $X
  xml2json -t xml2json --pretty -o $output_file_name_ext $X
  if grep -q v1.1 "$output_file_name_ext"; then
    echo "Post-processing Invoice v1.1: " $output_file_name_ext
    if grep -q -e "\"DatiFattureCollegate\":\s*{" "$output_file_name_ext"; then
      echo $output_file_name_ext "has a single element in DatiFattureCollegate. Making it an array"
      jq '."{http://www.fatturapa.gov.it/sdi/fatturapa/v1.1}FatturaElettronica".FatturaElettronicaBody.DatiGenerali.DatiFattureCollegate' $output_file_name_ext | jq -s '.' > $output_file_name_linked_invoice_data_ext
      jq --slurpfile dati_fatture_collegate $output_file_name_linked_invoice_data_ext '."{http://www.fatturapa.gov.it/sdi/fatturapa/v1.1}FatturaElettronica".FatturaElettronicaBody.DatiGenerali.DatiFattureCollegate = $dati_fatture_collegate[0]' $output_file_name_ext >> $output_file_name_post_processed_ext
      rm $output_file_name_ext
      rm $output_file_name_linked_invoice_data_ext
      mv $output_file_name_post_processed_ext $output_file_name_ext
    fi

    if grep -q -e "\"DettaglioLinee\":\s*{" "$output_file_name_ext"; then
      echo $output_file_name_ext "has a single element in DettaglioLinee. Making it an array"
      jq '."{http://www.fatturapa.gov.it/sdi/fatturapa/v1.1}FatturaElettronica".FatturaElettronicaBody.DatiBeniServizi.DettaglioLinee' $output_file_name_ext | jq -s '.' > $output_file_name_purchase_lines_data_ext
      jq --slurpfile dettaglio_linee $output_file_name_purchase_lines_data_ext '."{http://www.fatturapa.gov.it/sdi/fatturapa/v1.1}FatturaElettronica".FatturaElettronicaBody.DatiBeniServizi.DettaglioLinee = $dettaglio_linee[0]' $output_file_name_ext >> $output_file_name_post_processed_ext
      rm $output_file_name_ext
      rm $output_file_name_purchase_lines_data_ext
      mv $output_file_name_post_processed_ext $output_file_name_ext
    fi
  fi
done

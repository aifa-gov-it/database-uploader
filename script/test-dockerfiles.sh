#!/bin/sh -e

if ! TEMP="$(getopt -o vdm: --long docker-context-path: -n 'test-dockerfile' -- "$@")" ; then echo "Terminating..." >&2 ; exit 1 ; fi
eval set -- "$TEMP"

docker_context_path=

while true; do
  case "$1" in
    -c | --docker-context-path ) docker_context_path="$2"; shift 2 ;;
    -- ) shift; break ;;
    * ) break ;;
  esac
done

echo "Linting Dockerfiles from $docker_context_path"
find "$docker_context_path" -type f -iname "Dockerfile" | while read -r line; do
  echo "Linting $line"
  docker run -v "$(pwd)":/mnt --rm -w="/mnt" lukasmartinelli/hadolint hadolint "$line"
  docker run -v "$(pwd)":/mnt --rm -w="/mnt" redcoolbeans/dockerlint "$line"
done

echo "Linting shell scripts from $docker_context_path"
find "$docker_context_path" -type f -iname "*.sh" | while read -r line; do
  echo "Linting $line"
  docker run -v "$(pwd)":/mnt --rm koalaman/shellcheck-alpine "$line"
done

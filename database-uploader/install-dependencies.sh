#!/bin/sh

mvn install:install-file -Dfile=lib/ojdbc8/12.2.0.1/ojdbc8-12.2.0.1.jar -DpomFile=lib/ojdbc8/12.2.0.1/ojdbc8-12.2.0.1.pom
mvn install:install-file -Dfile=lib/ucp/12.2.0.1/ucp-12.2.0.1.jar -DpomFile=lib/ucp/12.2.0.1/ucp-12.2.0.1.pom

#!/bin/bash

if [ -f release.properties ]; then
  rm -rf release.properties
fi

./mvnw clean install
./mvnw deploy -s .mvn/settings.xml
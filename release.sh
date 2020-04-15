#!/bin/bash
## Delete all local tags and get the list of remote tags:
git tag -l | xargs git tag -d
git fetch
## Release Project
./mvnw release:prepare -Prelease -s .mvn/settings.xml
./mvnw release:perform deploy -Prelease -s .mvn/settings.xml
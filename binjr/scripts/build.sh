#!/usr/bin/env bash
cd binjr

if [[ $TRAVIS_COMMIT_MESSAGE == *"=>Release:v"* ]]; then
  echo "Start Maven release"
  mvn --batch-mode release:prepare release:perform -Dresume=false
else
  echo "Start Maven test"
    mvn clean test
fi
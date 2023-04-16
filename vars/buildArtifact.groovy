#!/usr/bin/env groovy

def call(){
    echo "Building Artifact Start ...."
    sh "mvn clean package"
}
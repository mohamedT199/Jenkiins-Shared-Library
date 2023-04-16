package com.example

class Maven implements  Serializable{

    def script
    Maven(script){
        this.script = script
    }


    def buildArtifact(){
        script.echo "Building Artifact Start ...."
        script.sh "mvn clean package"
    }

    def bumpVersion(){
        script.sh "mvn build-helper:parse-version versions:set \
        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
        versions:commit"
        def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
        script.env.version  = matcher[0][1]
        script.env.ImageName = "${script.version}-${script.BUILD_NUMBER}"

    }
}

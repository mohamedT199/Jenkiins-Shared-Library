package com.example

class Maven implements  Serializable{

    def script
    def static Dversion ;
    Maven(script){
        this.script = script
    }


    def buildArtifact(){
        script.echo "Building Artifact Start ...."
        script.sh "mvn clean package"
    }

    def bumpVersion(pomDir){
        if (pomDir != "" || pomDir != null ){
            script.sh "mvn build-helper:parse-version versions:set \
            -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
            versions:commit -f ${pomDir}/pom.xml"
        }
        else {
        script.sh "mvn build-helper:parse-version versions:set \
        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
        versions:commit" }
        def matcher = script.readFile('pom.xml') =~ '<version>(.+)</version>'
        script.echo 'get version'
        script.version  = matcher[0][1]
        script.echo 'have version'
        script.env.ImageName = "${script.version}-${script.BUILD_NUMBER}"
        script.echo "get image name ${script.env.ImageName}"
        Dversion = script.env.ImageName
        script.echo "get Dversion ${this.Dversion}"
    }
}

package com.example

class Maven implements  Serializable , LanguageType {

    def script
    def static Dversion ;
    Maven(script){
        this.script = script
    }


    @Override
    def buildArtifact(Boolean test ){

        script.echo "Building Artifact Start ...."
        if (test){
            script.sh "mvn clean package"
        }else{
            script.sh "mvn clean package -DskipTests "
        }


    }

    @Override
    def bumpVersion( String branch , pomDir  ){
        def matcher
        if (pomDir != "" && pomDir != null ){
            script.sh "mvn build-helper:parse-version versions:set \
            -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
            versions:commit -f ${pomDir}/pom.xml"
             matcher = script.readFile("${pomDir}/pom.xml") =~ '<version>(.+)</version>'
        }
        else {
        script.sh "mvn build-helper:parse-version versions:set \
        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
        versions:commit"
             matcher = script.readFile('pom.xml') =~ '<version>(.+)</version>'
        }

        script.echo 'get version'
        script.version  = matcher[0][1]
        script.echo 'have version'
        script.env.ImageName = "${script.version}-${script.BUILD_NUMBER}"
        script.echo "get image name ${script.env.ImageName}"
        Dversion = script.env.ImageName
        script.echo "get Dversion ${this.Dversion}"
    }
}

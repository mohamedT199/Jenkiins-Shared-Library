#!/usr/bin/env groovy
import com.example.Maven
import com.example.NPM

def call(Boolean test){
    def maven = "pom.xml"
    def npm = "package.json"
    if (fileExists(maven)) {
        sh "echo 'its java '"
        return new Maven(this).buildArtifact(test)
    }else if (fileExists(npm)){
        sh "echo 'its angular '"
        return new NPM(this).buildArtifact(test)
    }
    return new Maven(this).buildArtifact(test)
}
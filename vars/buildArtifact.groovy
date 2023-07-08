#!/usr/bin/env groovy
import com.example.Maven
import com.example.NPM

def call(Boolean test, String branch){
    def maven = "pom.xml"
    def npm = "package.json"
    if (fileExists(maven)) {
        sh "echo 'its java '"
        return new Maven(this).buildArtifact(test,branch)
    }else if (fileExists(npm)){
        sh "echo 'its angular '"
        return new NPM(this).buildArtifact(test,branch)
    }
    return new Maven(this).buildArtifact(test,branch)
}
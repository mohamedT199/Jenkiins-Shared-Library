#!/usr/bin/env groovy
import com.example.Maven
import com.example.NPM

def call(String branch , String pomDir){
    def fileExtensions = ['java', 'python', 'ruby']
    def maven = "pom.xml"
    def npm = "package.json"
    if (fileExists(maven)) {
        sh "echo 'its java '"
        return new Maven(this).bumpVersion(branch , pomDir)
    }else if (fileExists(npm)){
        sh "echo 'its angular '"
        return new NPM(this).bumpVersion(branch , pomDir)
    }

    return new Maven(this).bumpVersion(branch , pomDir)
}

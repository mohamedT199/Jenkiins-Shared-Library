#!/usr/bin/env groovy
import com.example.Maven
def call(String pomDir){
    /*if (!pomDir.isEmpty()){
        sh "echo $pomDir "
        //sh "cd $pomDir"
        sh "cd /var"
        sh "pwd"
    }
    sh "pwd"*/
    return new Maven(this).bumpVersion(pomDir)
}

#!/usr/bin/env groovy
import com.example.Maven
def call(String pomDir){
    if (!pomDir.isEmpty()){
        sh "echo $pomDir "
        sh "cd $pomDir"
        sh "pwd"
    }
    sh "pwd"
    sh "echo $pomDir "
    return new Maven(this).bumpVersion()
}

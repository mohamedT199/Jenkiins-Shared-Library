#!/usr/bin/env groovy
import com.example.Maven
def call(String pomDir){
    if (!pomDir.isEmpty()){
        sh "cd $pomDir"
    }
    return new Maven(this).bumpVersion()
}

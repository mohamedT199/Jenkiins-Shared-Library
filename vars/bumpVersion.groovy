#!/usr/bin/env groovy
import com.example.Maven
def call(String pomDir){
    String pomDirectory = pomDir
    return new Maven(this).bumpVersion()
}

#!/usr/bin/env groovy
import com.example.Maven
def call(String pomDir){
    return new Maven(this).bumpVersion(pomDir)
}

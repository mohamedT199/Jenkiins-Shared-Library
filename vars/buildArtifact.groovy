#!/usr/bin/env groovy
import com.example.Maven
def call(Boolean test){
    return new Maven(this).buildArtifact(test)
}
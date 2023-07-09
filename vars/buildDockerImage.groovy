#!/usr/bin/env groovy
import com.example.Docker
def call(String repoName){
    return new Docker(this).buildDockerImage(repoName)
}
#!/usr/bin/env groovy
import com.example.Docker
def call(String CredentialsId){
    return new Docker(this).buildDockerImage(CredentialsId)
}
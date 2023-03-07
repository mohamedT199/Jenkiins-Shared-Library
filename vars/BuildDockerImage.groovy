#!/usr/bin/env groovy
def call(){
    echo "Build Docker Image Start ...."
    withCredentials([usernamePassword(credentialsId: 'Docker-Hub' , usernameVariable: 'USER' , passwordVariable: 'PASS')]){
        sh "docker login --username=$USER --password=$PASS"
        sh "docker build -t talat345/demo-repo . "
        sh "docker push talat345/demo-repo "
    }
}
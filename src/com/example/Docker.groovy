package com.example


class Docker implements Serializable{
    def script

    Docker(script){
        this.script = script
    }


    def buildDockerImage(String credential){
        script.echo "Build Docker Image Start ...."
        script.withCredentials([script.usernamePassword(credentialsId: "$credential" , usernameVariable: 'USER' , passwordVariable: 'PASS')]){
            script.sh "docker build -t talat345/demo-repo:${script.env.ImageName} . "
            script.sh "docker push talat345/demo-repo:${script.env.ImageName} "
        }
    }

    def dockerLogin(String credential){
        script.withCredentials([script.usernamePassword(credentialsId: "$credential" , usernameVariable: 'USER' , passwordVariable: 'PASS')]){
            script.sh "docker login --username=${script.USER} --password=${script.PASS}"

        }
    }
}

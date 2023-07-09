package com.example


class Docker implements Serializable{
    def script

    Docker(script){
        this.script = script
    }


    def buildDockerImage(String repoName ){
        script.echo "Build Docker Image Start ...."
        script.sh "docker build -t ${repoName}:${script.env.ImageName} . "
        script.sh "docker push ${repoName}:${script.env.ImageName}"

    }

    def dockerLogin(String credential){
        script.withCredentials([script.usernamePassword(credentialsId: "$credential" , usernameVariable: 'USER' , passwordVariable: 'PASS')]){
            script.sh "docker login --username=${script.USER} --password=${script.PASS}"

        }
    }
}

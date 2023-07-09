package com.example

class GIT implements  Serializable {

    def script
    GIT(script) {
        this.script = script
    }
    def pushToGit(){
        script.sh "git status "
        script.sh "git branch "
        script.echo "git url ${script.env.GIT_URL}"
        script.echo "git Branch ${script.env.GIT_BRANCH}"
        script.sh "git add . "
        script.sh "git commit -m ${script.env.ImageName} "
        script.sh "git remote set-url origin  ${script.env.GIT_URL} "
        def branchName = "${script.env.GIT_BRANCH}"
        branchName = branchName.substring(branchName.lastIndexOf('/') + 1)
        script.sh "git push origin HEAD:${branchName}"
    }
}

package com.example

class GIT implements  Serializable {

    def script
    GIT(script) {
        this.script = script
    }
    def pushToGit(){
        script.sh "git status "
        script.echo "git url ${script.env.GIT_URL}"
        script.echo "git Branch ${script.env.GIT_BRANCH}"
        script.sh "git remote origin set-url ${script.env.GIT_URL} "
        script.sh "git add package.json "
        script.sh 'git commit -m "version" '
        script.sh "git push origin HEAD:${script.env.GIT_BRANCH}"
    }
}

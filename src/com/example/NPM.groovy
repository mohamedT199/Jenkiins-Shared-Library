package com.example

class NPM implements  Serializable , LanguageType {
    def script
    def static NPMDversion ;
    NPM(script) {
        this.script = script
    }

    @Override
    def bumpVersion(String branch , pomDir  ) {
        def versionType = 'patch'
        def currentVersion = script.sh(returnStdout: true, script: 'node -p "require(\'./package.json\').version"')
        script.sh "npm version ${versionType} --no-git-tag-version "
        def newVersion = script.sh(returnStdout: true, script: 'node -p "require(\'./package.json\').version"')
        script.echo "Upgraded version from ${currentVersion} to ${newVersion}"
        script.env.NPMImageVersion = newVersion
        NPMDversion = newVersion ;
        script.env.ImageName = "${newVersion}"
        script.echo "neeeeewww Upgraded version from ${script.env.NPMImageVersion} to ${NPMDversion}"
        script.sh "git status "
        script.sh "git branch "
        script.echo "git url ${script.env.GIT_URL}"
        script.echo "git Branch ${script.env.GIT_BRANCH}"
        script.sh "git add . "
        script.sh "git commit -m ${newVersion} "

        script.sh "git remote set-url origin  ${script.env.GIT_URL} "
        script.sh "git push origin HEAD:main"
    }

    @Override
    def buildArtifact(Boolean test) {
        script.sh "which npm "
        script.sh "which node "
        script.sh "npm --version "
        script.sh "node --version"
        script.sh "npm install "
        script.sh "npm run build"
        script.sh "rm -rf hr.tar"
        script.sh "tar cvf hr.tar dist"

    }
}

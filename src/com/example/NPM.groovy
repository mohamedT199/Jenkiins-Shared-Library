package com.example

class NPM implements  Serializable , LanguageType {
    def script
    def static NPMDversion ;
    NPM(script) {
        this.script = script
    }

    @Override
    def bumpVersion(pomDir) {
        def versionType = 'minor'
        def currentVersion = script.sh(returnStdout: true, script: 'node -p "require(\'./package.json\').version"')
        script.sh "npm version ${versionType}"
        def newVersion = script.sh(returnStdout: true, script: 'node -p "require(\'./package.json\').version"')
        script.echo "Upgraded version from ${currentVersion} to ${newVersion}"
        script.env.NPMImageVersion = newVersion
        NPMDversion = newVersion ;
        script.echo "neeeeewww Upgraded version from ${script.env.NPMImageVersion} to ${NPMDversion}"

    }

    @Override
    def buildArtifact(Boolean test , String branchName) {
        script.sh "which npm "
        script.sh "which node "
        script.sh "npm --version "
        script.sh "node --version"
        script.sh "npm install "
        script.sh "npm run build"
        script.sh "rm -rf hr.tar"
        script.sh "tar cvf hr.tar dist"
        script.sh "git checkout ${branchName}"
        script.sh "git pull -r "
        script.sh "git push origin v${NPMDversion}"
    }
}

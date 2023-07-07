package com.example

class NPM implements  Serializable , LanguageType {
    def script

    NPM(script) {
        this.script = script
    }

    @Override
    def bumpVersion(pomDir) {
        def versionType = 'minor'
        def currentVersion = script.sh "node -p \"require('./package.json').version\""
        script.sh "npm version ${versionType}"
        def newVersion = script.sh "node -p \"require('./package.json').version\""
        script.echo "Upgraded version from ${currentVersion} to ${newVersion}"

    }

    @Override
    def buildArtifact(Boolean test) {
        script.sh "which npm "
        script.sh "which node "
        script.sh "npm --version "
        script.sh "node --version"
        script.sh "npm install "
        script.sh "npm run build"
        script.sh "git push HEAD:main"
    }
}

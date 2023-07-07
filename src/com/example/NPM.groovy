package com.example

class NPM implements  Serializable , LanguageType {
    def script

    NPM(script) {
        this.script = script
    }

    @Override
    def bumpVersion(pomDir) {
        def versionType = 'minor'
        def currentVersion = script.sh(returnStdout: true, script: "node -p \"require('./package.json').version\"").trim()
        sh "npm version ${versionType}"
        def newVersion = script.sh(returnStdout: true, script: "node -p \"require('./package.json').version\"").trim()
        echo "Upgraded version from ${currentVersion} to ${newVersion}"

    }

    @Override
    def buildArtifact(Boolean test) {
        script.sh "npm install "
        script.sh "npm run build"
    }
}

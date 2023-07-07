package com.example

class NPM implements  Serializable , LanguageType {
    def script

    NPM(script) {
        this.script = script
    }

    @Override
    def bumpVersion(pomDir) {
        def versionType = 'minor'
        script.sh "node -p \"require('./package.json').version\""
        script.sh "npm version ${versionType}"
        script.sh "node -p \"require('./package.json').version\""
        script.echo "Upgraded version from ${currentVersion} to ${newVersion}"

    }

    @Override
    def buildArtifact(Boolean test) {
        script.sh "npm install "
        script.sh "npm run build"
    }
}

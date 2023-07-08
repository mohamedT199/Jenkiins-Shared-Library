package com.example

interface LanguageType {

    def bumpVersion(pomDir);
    def buildArtifact(Boolean test,String branchName);

}
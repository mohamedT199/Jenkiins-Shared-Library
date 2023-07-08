package com.example

interface LanguageType {

    def bumpVersion(  String branch , pomDir);
    def buildArtifact(Boolean test);

}
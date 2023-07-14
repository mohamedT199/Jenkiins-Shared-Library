package com.example

class MAIL {
    def script
    MAIL(script) {
        this.script = script
    }
    // 1- Should have Mailer Plugin
    // 2- Should Configure Mail Configuration Mail Server and user name and Password and be Tested
    // 3- once done you could use this Plugin using the below syntax
    def sendMail(String recEmail , String ccEmail , String body , String subject){
        script.mail bcc: '', body: "${body}", cc: "${ccEmail}", from: '', replyTo: '', subject: "${subject}", to: "${recEmail}"
    }
}

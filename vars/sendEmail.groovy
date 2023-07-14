#!/usr/bin/env groovy
import com.example.MAIL

def call(String recEmail , String ccEmail ,  String body , String subject){
    return new MAIL(this).sendMail(recEmail,ccEmail,body,subject)
}
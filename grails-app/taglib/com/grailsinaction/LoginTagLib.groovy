package com.grailsinaction

class LoginTagLib {

    static final namespace = 'myTag'
    def loginControl = {
        if(session.user){
            out << "Hello ${session.user.displayName} "
            out << """${link(action:"logout", controller:"user"){"Logout"}}"""
            out << """  ${link(action:"create", controller:"post"){"NewPost"}}"""
        } else {
            out << """${link(action:"login", controller:"user"){"Login"}}"""
            out << """  ${link(action:"create", controller:"user"){"Sign Up"}}"""
        }
    }
}
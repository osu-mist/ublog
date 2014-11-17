package com.grailsinaction

class LoginTagLib {

    static final namespace = 'myTag'
    def loginControl = {
        if(session.user){
            out << "Hello ${session.user.name} "
            out << """[${link(action:"logout", controller:"user"){"Logout"}}]"""
        } else {
            out << """[${link(action:"login", controller:"user"){"Login"}}]"""
        }
    }
}
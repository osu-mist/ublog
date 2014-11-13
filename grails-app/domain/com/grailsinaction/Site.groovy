package com.grailsinaction

class Site {
    static belongsTo = User // Declare that a site belongs to a user
    Integer id
    String url
    String title


    static constraints = {
       //URL needs to be valid
    }
}

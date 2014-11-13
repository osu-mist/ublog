package com.grailsinaction

class Tag {

    Integer id
    String name // The actual text or body of the tag
    User user

    static constraints = {
        name(blank: false)
    }

    //Tags have m:n relationships with Post and User
    static hasMany = [posts: Post]
    static belongsTo = [ User, Post]
}

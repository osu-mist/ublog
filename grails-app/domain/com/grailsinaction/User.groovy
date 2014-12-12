package com.grailsinaction



class User {
    Integer id
    String name  // Username
    String password
    String email
    String displayName
    Date dateCreated
    Date lastUpdated
    Site site // Declare that a User has one Site associated with it
    static hasMany = [ posts : Post, tags: Tag] // Declare that a User has many Posts


    static constraints ={
        //size, applied to String, checks length. Applied to Integer, checks value within range
        name(size: 3..20)

        // make sure that the user doesn't have the same username or email and password
        password(size: 6..20, validator: { password, user ->
            password != user.name
            password != user.email
        })
        email()
        displayName()
        site(nullable:true) // Say that the profile is optional

    }

    // Load site with user
    static mapping = {
        site lazy:false
    }
}

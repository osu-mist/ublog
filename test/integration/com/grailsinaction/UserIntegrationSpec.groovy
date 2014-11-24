package com.grailsinaction



import spock.lang.*

import javax.validation.constraints.Null

/**
 *
 */
class UserIntegrationSpec extends Specification {

    def setup() {


    }

    // Saving User is okay
    void "testFirstSave"() {
        when:
        def user = new User(name: 'joey', password: 'mypasswo', displayName: 'joey1', email: 'e3').save()


        then:
        user != null

       // when:
        def foundUser = User.get(user.id)

        then:
        user.id != null
        'joey' == foundUser.name

        }


    void "test user login"() {
        when:
        def user = new User(name: 'robert', password: 'password2', displayName: 'robert1', email: 'e4').save()


        user.addToPosts(new Post(title: "title1", bodyText: "more text", user: user).save())
      //  user.addToPosts(new Post(title: "title2", bodyText: "more text2", user: user).save())
        def foundUser = User.get(user.id)

        then:
        foundUser.name == 'robert'
        foundUser.posts != null
        println(foundUser.posts)
        def foundPost = Post.get(foundUser.posts.id)
        foundPost.title == 'title1'



    }

    def cleanup() {
    }


}

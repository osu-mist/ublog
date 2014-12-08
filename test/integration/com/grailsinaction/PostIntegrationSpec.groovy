package com.grailsinaction
import spock.lang.Specification






import javax.validation.constraints.Null

class PostIntegrationSpec extends Specification {

    def setup() {

    }


    void "testFirstSave"() {
        when:
        // need to associate a post with a user
        def user = new User(name: 'joey', password: 'mypasswo', displayName: 'joey1', email: 'e3').save()



        def post2 = new Post(bodyText: 'body text', title: 'title2', user: user).save()
        def post3 = new Post(bodyText: 'body text', title: 'title3', user: user).save()

        // The max id stored in the database
        def maxVal = Post.list().id.max()

        def post = new Post(bodyText: 'body text', title: 'title', user: user).save()




        then:
        user != null
        post != null

        when:
        def foundPost = Post.get(post.id)

        then:
        post.id != null
        'title' == foundPost.title
        foundPost.bodyText == 'body text'

        // Make sure that the id is bigger than the previous max id from the db
        post.id > maxVal

        post.user == user

    }


    def cleanup(){

    }
}


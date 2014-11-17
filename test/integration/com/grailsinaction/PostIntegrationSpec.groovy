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
        def post = new Post(bodyText: 'body text', title: 'title', user: user).save()




        then:
        user != null
        post != null

         when:
        def foundPost = Post.get(post.id)

        then:
        post.id != null
        'title' == foundPost.title
        post.bodyText == 'body text'
        post.id == 1
        post.user == user

    }


def cleanup(){
}
}


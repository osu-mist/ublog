package ublog
import com.grailsinaction.User
import com.grailsinaction.Post


import spock.lang.*
import com.grailsinaction.Tag

/**
 *
 */
class QueryIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    // Test finding a user based on their email or password matched to a string literal
    void "test basic dynamic finders"() {
        when:
        new User(name: 'john', password: 'password1', displayName: 'john1', email: 'e1').save()
        new User(name: 'anne', password: 'password2', displayName: 'anne1', email: 'e2').save()
        def user = User.findByPassword('password2')

        then:
        user.name == 'anne'

        when:
        user = User.findByEmail('e1')

        then:
        user.password == 'password1'

    }

    // Test creating a user, 2 tags, two posts, and associating those tags, user and posts together.
    void "testPostWithTags"(){
        when:
        def user = new User(name: 'bill', password: 'secret1', displayName: 'bill1', email: 'eb1').save()
        def tagGroovy = new Tag(name: 'groovy')
        def tagGrails = new Tag(name: 'grails')
        user.addToTags(tagGroovy)
        user.addToTags(tagGrails)

        def tagNames = user.tags*.name

        then:
        // Check that two tags have been associated with the user
        [ 'grails', 'groovy'] == tagNames.sort()
        user.tags.size() == 2

        when:
        def groovyPost = new Post(bodyText: "A groovy post", title: "title1")
        user.addToPosts(groovyPost)
        groovyPost.addToTags(tagGroovy)

        then:
        // Check that a tag has in fact been added to groovyPost
        groovyPost.tags.size() == 1

        // Associating two tags with one post
        when:
        def bothPost = new Post(bodyText: "A groovy and grails post", title: "title2")
        user.addToPosts(bothPost)
        bothPost.addToTags(tagGroovy)
        bothPost.addToTags(tagGrails)

        then:
        // Check that two tags have been added
        bothPost.tags.size() == 2
    }
}

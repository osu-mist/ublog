package com.grailsinaction



import grails.test.mixin.*
import spock.lang.*



@TestFor(PostController)
@Mock([User, Post])
class PostControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        params["title"] = 'someValidName'
        params["bodyText"] = 'bodyText'
        params['dateCreated'] = new Date()
        params['id'] = '1'
        params['user'] = new User(name: 'anne', password: 'mypassword', displayName: 'anne', email: 'e2')
    }

    void "testFirstSave"() {
        when:
        def user = new User(name: 'joey', password: 'mypasswo', displayName: 'joey1', email: 'e3')


        then:
        user.save() != null

        // when:
        def foundUser = User.get(user.id)

        then:
        user.id != null
        'joey' == foundUser.name

    }



  /*  def "Get user's timeline given their id"(){
        given: "A user with posts in the db"
        User bill = new User(name: 'bill', password: 'password2', displayName: 'bill1', email: 'e4')
        def post1 = new Post(bodyText: " A first post", title: "title1")
        def post2 = new Post(bodyText: " A second post", title: "title2")
       // bill.addToPosts(new Post(bodyText: " A first post", title: "title1"))
        //bill.addToPosts(new Post(bodyText: " A second post", title: "title2"))
        bill.addToPosts(post1)
        bill.addToPosts(post2)
        bill.save(failOnError: true)

        and: "a login id"
        params.id = bill.id

        when: "the timeline is invoked"
      //  def model = controller.index()
         model.postInstance = controller.show(post1)

        then: "the user is in the returned model"
       // response.redirectedUrl =

   //     model.postInstance != null


      //  model.user.name == "bill"
       // model.user.posts.size() == 2




    }
*/
    def "Test the show function"(){

        when:"A domain instance is passed to the show action"
        populateValidParams(params)
        def post = new Post(params)
        controller.show(post)

        then:"A model is populated containing the domain instance"

        model.postInstance == post

        println("Post: post instance matches post")

    }




}

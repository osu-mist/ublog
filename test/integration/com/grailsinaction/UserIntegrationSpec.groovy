package com.grailsinaction



import spock.lang.*

import javax.validation.constraints.Null

/**
 *
 */
class UserIntegrationSpec extends Specification {

    def setup() {


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


    void "test user login"() {
   //     when:
    //    def user = new User(name: 'robert', password: 'password2', displayName: 'robert1', email: 'e4')

    //    then:

    }

    def cleanup() {
    }


}

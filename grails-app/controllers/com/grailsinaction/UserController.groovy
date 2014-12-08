package com.grailsinaction



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def scaffold = true

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userInstanceCount: User.count()]
    }

    def show(User userInstance) {
        respond userInstance
    }

    /**
     * Directs to the login.gsp page
     */
    def login = {

    }

    /**
     * Do the work of logging in: check if the email+password combination exists in the
     * database, and if so, set the current session user to be that found user.
     * If successfully logged in, redirect to the list of posts. Otherwise redirect back to login.
     */
    def doLogin = {
        def user = User.findWhere(email: params['email'],
                password: params['password'])
        session.user = user

        if (user) {
            flash.message = message(code: 'user.login.success')

            redirect(controller: 'post', action: 'index')
        } else {
            if (!params['email']) {
                flash.message = message(code: 'user.login.email.blank')

            }
            else if (!params['password']) {
                flash.message = message(code: 'user.login.password.blank')

            }
            else { // Combination not found in database

                flash.message = message(code: 'user.login.error')
            }


            redirect(controller: 'user', action: 'login')

        }
    }

    /**
     * Reset the session user to be null, and redirect the user to the login screen
     */
    def logout = {

        flash.message = message(code: 'user.logout.message')
        session.user = null
        redirect( action:'login')

    }

    def create() {
        respond new User(params)
    }

    // A request to search now falls through to the search.gsp file
    def search = {

    }

    // Search users by their display name
    def results = {
        def users = User.findAllByDisplayName(params.displayName)
        return [users: users, term : params.displayName]

    }


    @Transactional
    def save(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'create'
            return
        }

        userInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*' { respond userInstance, [status: CREATED] }
        }
    }

    def edit(User userInstance) {
        respond userInstance
    }

    @Transactional
    def update(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'edit'
            return
        }



        userInstance.save flush:true
        session.user = userInstance

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*'{ respond userInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(User userInstance) {

        if (userInstance == null) {
            notFound()
            return
        }

        userInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

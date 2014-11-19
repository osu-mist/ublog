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

    def login = {


    }

    def doLogin = {
        def user = User.findWhere(email:params['email'],
                password:params['password'])
        session.user = user

        if(user){
            redirect(controller:'post',action:'index')
        }
        else{
            flash.message = "Please try again"
            redirect(controller:'user',action:'login')
        }
    }

    def logout = {

     //   flash.message = "Goodbye ${session.user.name}. Log in again?"
        session.user = null
        redirect( action:'login')

    }




        def logout() {
            log.info "User agent: " + request.getHeader("User-Agent")
            session.invalidate()
            redirect(action: "login")
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

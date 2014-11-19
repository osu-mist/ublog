package com.grailsinaction



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PostController {

    /**
     * Index, list and show are the only actions that don't require a user to login first
     */
    def beforeInterceptor = [action:this.&checkUser,except:
            ['index','list','show']]

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    /**
     * If there isn't a user logged in, redirect to the login page
     * @return false if no user is logged in
     */
    def checkUser(){
        if(!session.user){
            redirect(controller: 'user', action: 'login')
            return false
        }
    }

    /**
     * Shows a list of posts by all users
     * @param max
     * @return
     */
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
    // redirect(action: 'timeline', params: params)
        respond Post.list(params), model:[postInstanceCount: Post.count()]
    }


    /**
     * Responds with the post instance that show.gsp will display
     * @param postInstance The post to show
     * @return
     */
    def show(Post postInstance) {
        respond postInstance
    }


    /**
     * Responds with a new post created with the parameters that came from the create.gsp page.
     *
     */
    def create() {

        respond(new Post(params))
   //  flash.message =  " Successfully saved post"
    }

/**
 * Saves a post if it doesn't have errors. If there are errors, method directs back to the create
 * page with the original data that was entered, and the errors marked.
 * Sets the post's author to be the currently loggin-in user.
 * @param postInstance      The post to be saved
 * @return
 */

    @Transactional
    def save(Post postInstance) {

      //  println("starting post save\n")
      //  println("Test:\n")


        if (postInstance == null) {
            //    println("not found")
        }
       // println("starting post save\n")

        println("\n\nTest save:\n")

        // Set the post's user to be the currently logged-in user
        postInstance.user = session.user

        //  println("Test:\n")
    //    println( postInstance.user)

        if (postInstance == null) {
        //    println("null post")
            notFound()
            return
        }

        // Need to validate, because we recently stored data (the post's user)
        postInstance.validate()

        if (postInstance.hasErrors()) {

         //   println("Has errors\n")

          //  println("Has errors\n")
          //  println(postInstance.errors)

            respond postInstance.errors, view:'create'
            return
        }


      //  println("Test:\n")
        println( postInstance)



        postInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [
                        message(code: 'post.label', default: 'Post'),
                        postInstance.id])
                redirect postInstance
            }
            '*' { respond postInstance, [status: CREATED] }
        }
    }

    def edit(Post postInstance) {
        respond postInstance
    }

    @Transactional
    def update(Post postInstance) {
        if (postInstance == null) {
            notFound()
            return
        }

        if (postInstance.hasErrors()) {
            respond postInstance.errors, view:'edit'
            return
        }

        postInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Post.label', default: 'Post'), postInstance.id])
                redirect postInstance
            }
            '*'{ respond postInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Post postInstance) {

        if (postInstance == null) {
            notFound()
            return
        }

        postInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Post.label', default: 'Post'), postInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

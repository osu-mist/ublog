package com.grailsinaction



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PostController {

    def beforeInterceptor = [action:this.&checkUser,except:
            ['index','list','show']]

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def checkUser(){
        if(!session.user){
            redirect(controller: 'user', action: 'login')
            return false
        }
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
    // redirect(action: 'timeline', params: params)
        respond Post.list(params), model:[postInstanceCount: Post.count()]
    }

    def show(Post postInstance) {
        respond postInstance
    }

    def create() {
        respond new Post(params)
    }




    @Transactional
    def save(Post postInstance) {
      //  println("starting post save\n")
      //  println("Test:\n")


        if (postInstance == null) {
        //    println("not found")
            notFound()
            return
        }

        if (postInstance.hasErrors()) {
         //   println("Has errors\n")
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

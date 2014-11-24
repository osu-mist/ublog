package com.grailsinaction
import org.apache.commons.lang.StringUtils

class Post {


        // Declare that a post belongs to a user
        static belongsTo = [ user : User ]  // Mapping style means we can get to a User from a post
        static hasMany = [tags: Tag]
        Integer id
     //   String siteId
        String bodyText


        String title
        Date dateCreated



        static constraints = {
            title(blank: false)

            // Make this a text area rather than the default string area
            bodyText(blank: false, widget: 'textarea')

        }


        static mapping = {
            sort dateCreated: "desc"  // Sort the posts by the date created
        }


    /**
     * This method returns the first 10 characters of the post's body text
     * @return text   String: The first 10 characters of the text
     */

        String abbrevText() {
            String text = bodyText[0..10]
            return text
        }





}




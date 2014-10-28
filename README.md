ublog
=====
uBlog is a simple blogging web app created in order to learn Grails with Groovy. 
A user can register for an account using their email address. They can then create, update, and delete posts using a WYSIWYG editor. They can view their posts in a list with links to update or delete posts, or they can view the posts on their blog. This blog is publicly viewable to anyone who has the URL. 

The entities are User, Site, Post, and Tag. A user has many posts, one site, many tags. A site has many posts. A post has many tags, and a tag may be applied to many posts. 

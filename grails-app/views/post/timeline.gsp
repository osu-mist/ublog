
<%@ page import="com.grailsinaction.Post" %>
<%@ page import="com.grailsinaction.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%-- TODO: move text to messages file --%>
  <title>Timeline</title>
    <meta name = "layout" content="main"/>
</head>
<body>
    <h1>Timeline</h1>
    <div class ="allPosts">
        <g:each in="${user.posts}" var="post">
            <div class ="postEntry">
                <div class="postTitle>
                    ${post.title}
                 </div>
                <div class="postText>
                    ${post.bodyText}
                 </div>

                <div class ="postDate">
                    ${post.dateCreated}
                </div>
            </div>
        </g:each>
    <div>

</body>
</html>
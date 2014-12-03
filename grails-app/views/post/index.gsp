
<%@ page import="com.grailsinaction.Post" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">



		<g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>




	</head>
	<body>
		<a href="#list-post" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>



    <g:if test="${session?.user}">
    <%-- If a user is logged in, show a new post link  --%>
        <div class="nav" role="navigation">
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            <ul> <li><a class="create" href="${createLink(uri: '/post/create')}"><g:message code="create.post.message"/></a> </li>

            </ul>
        </div>
    </g:if>

    <%-- If no user is logged in, show a login link and a create user link--%>
    <g:else>
        <div class="nav" role="navigation">
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            <ul> <li><a class="login" href="${createLink(uri: '/user/login')}"><g:message code="default.login.message"/></a> </li>
                <li><a class="create" href="${createLink(uri: '/user/create')}"><g:message code="create.new.user.message"/></a>


            </ul>
        </div>
    </g:else>





		<div id="list-post" class="content scaffold-list" role="main">
			<h1><g:message code="post.timeline.message" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>

                <%-- Display all posts in list form, with title, body text, date, and author --%>
				<g:each in="${postInstanceList}" status="i" var="postInstance">
                    <article>
                        <br>
                        <p>
						<g:link action="show" id="${postInstance.id}">${fieldValue(bean: postInstance, field: "title")}</g:link>
                        </p>
                    <p>

                    <%-- Display only the first 10  characters of the post's body --%>
                        ${postInstance.abbrevText()}


                    </p>

                        <%-- Display the date in a more readable format --%>
						<g:formatDate format="EEE, MMM d, yyyy '  at' hh:mm aaa" date="${postInstance.dateCreated }" />
                    <p>

                        <%-- Pass the user's id as the id param, but display the user's displayName --%>
						<g:link controller = "User" action="show" id="${postInstance.user.id}">${fieldValue(bean: postInstance, field: "user.displayName")}</g:link>
                    </p>
                    <p>
                    ${fieldValue(bean: postInstance, field: "tags")}
                    </p>


                    </article>
				</g:each>

			<div class="pagination">
				<g:paginate total="${postInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>

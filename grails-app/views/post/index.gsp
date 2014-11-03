
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
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-post" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>


				<g:each in="${postInstanceList}" status="i" var="postInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                        <p>
						<td><g:link action="show" id="${postInstance.id}">${fieldValue(bean: postInstance, field: "title")}</g:link></td>
                        </p>
                    <p>
						<td>${fieldValue(bean: postInstance, field: "bodyText")}</td>
                    </p>
						<td><g:formatDate date="${postInstance.dateCreated}" /></td>
                    <p>
						<td><g:link controller = "User" action="show" id="${postInstance.user.id}">${fieldValue(bean: postInstance, field: "user.displayName")}</g:link></td>
                    </p>
                    <p>
                    <td>${fieldValue(bean: postInstance, field: "tags")}</td>
                    </p>

                 </tr>
				</g:each>

			<div class="pagination">
				<g:paginate total="${postInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>

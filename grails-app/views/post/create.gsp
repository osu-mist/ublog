<!DOCTYPE html>
<html>
	<head>

		<meta name="layout" content="main">

        <%-- Declare that the WYSIWYG editor will be used on this page --%>
        <ckeditor:resources/>
		<g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-post" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

		<div id="create-post" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>

			<g:hasErrors bean="${postInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${postInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>

			<g:form url="[resource:postInstance, action:'save']" >
                    <%-- 'name' needs to match the post's fields  --%>
                <label>${message(code: 'post.title.label')}</label>

                <input type = "text"
                        name = "title"
                        maxlength="60"
                        value = "${postInstance?.title}" />

                    <%-- WYSIWYG editor for the body of the post --%>
                    <ckeditor:editor name="bodyText" height="400px" width="80%">
                        ${postInstance?.bodyText}
                    </ckeditor:editor>

				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

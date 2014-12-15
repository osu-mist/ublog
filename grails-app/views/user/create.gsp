<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">

		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>

	</head>
	<body>
		<a href="#create-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

		<div id="create-user" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>

			<g:hasErrors bean="${userInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${userInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>

			<g:form url="[resource:userInstance, action:'save']" >
                <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} required">
                    <label>${message(code: 'user.create.name')}</label>
                    <span class="required-indicator">*</span>
                    <input type = "text"
                           name = "name"
                           maxlength="20"
                           value = "${userInstance?.name}" />
                </div>


                <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
                    <label>${message(code: 'user.create.password')}</label>
                    <span class="required-indicator">*</span>
                    <input type = "password"
                           name = "password"
                           maxlength="20"
                           value = "${userInstance?.password}" />
                </div>

                <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
                    <label>${message(code: 'user.create.email')}</label>
                    <span class="required-indicator">*</span>
                    <input type = "text"
                           name = "email"
                           maxlength="40"
                           value = "${userInstance?.email}" />
                </div>


                <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'displayName', 'error')} required">
                    <label>${message(code: 'user.create.displayname')}</label>
                    <span class="required-indicator">*</span>
                    <input type = "text"
                           name = "displayName"
                           maxlength="25"
                           value = "${userInstance?.displayName}" />

                </div>

				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

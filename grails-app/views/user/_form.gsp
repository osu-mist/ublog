<%@ page import="com.grailsinaction.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
    <input type = "text"
           name = "name"
           maxlength="25"
           value = "${userInstance?.name}" />
</div>


<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>

    <input type = "password"
           name = "password"
           maxlength="25"
           value = "${userInstance?.password}" />
</div>


<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="user.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
    <input type = "text"
           name = "email"
           maxlength="40"
           value = "${userInstance?.email}" />
</div>


<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'displayName', 'error')} required">
	<label for="displayName">
		<g:message code="user.displayName.label" default="Display Name" />
		<span class="required-indicator">*</span>
	</label>
    <input type = "text"
           name = "displayName"
           maxlength="25"
           value = "${userInstance?.displayName}" />
</div>




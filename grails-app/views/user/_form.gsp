<%@ page import="com.grailsinaction.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
    <input type = "text"
           name = "name"
           maxlength="25"
           value = "" />
</div>


<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>

    <input type = "password"
           name = "password"
           maxlength="25"
           value = "" />
</div>


<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="user.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
    <input type = "text"
           name = "email"
           maxlength="40"
           value = "" />
</div>


<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'displayName', 'error')} required">
	<label for="displayName">
		<g:message code="user.displayName.label" default="Display Name" />
		<span class="required-indicator">*</span>
	</label>
    <input type = "text"
           name = "displayName"
           maxlength="25"
           value = "" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'posts', 'error')} ">
	<label for="posts">
		<g:message code="user.posts.label" default="Posts" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.posts?}" var="p">
    <li><g:link controller="post" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>

<li class="add">
<g:link controller="post" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'post.label', default: 'Post')])}</g:link>
</li>
</ul>


</div>


<%@ page import="com.grailsinaction.Post" %>



<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="post.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${postInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'bodyText', 'error')} required">
	<label for="bodyText">
		<g:message code="post.bodyText.label" default="Body Text" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="bodyText" cols="40" rows="5" required="" value="${postInstance?.bodyText}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'tags', 'error')} ">
	<label for="tags">
		<g:message code="post.tags.label" default="Tags" />
		
	</label>
	<g:select name="tags" from="${com.grailsinaction.Tag.list()}" multiple="multiple" optionKey="id" size="5" value="${postInstance?.tags*.id}" class="many-to-many"/>

</div>

<%-- <div class="fieldcontain ${hasErrors(bean: postInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="post.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${com.grailsinaction.User.list()}" optionKey="id" required="" value="${postInstance?.user?.id}" class="many-to-one"/>
--%>
</div>


<%@ page import="com.grailsinaction.Post" %>



<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="post.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${postInstance?.title}"/>
    <input type = "text"
           name = "title"
           maxlength="60"
           value = "" />
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'bodyText', 'error')} required">
	<label for="bodyText">
		<g:message code="post.bodyText.label" default="Body Text" />
		<span class="required-indicator">*</span>
	</label>
    <input type = "textarea"
           name = "bodyText"
           value = "" />
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'tags', 'error')} ">
	<label for="tags">
		<g:message code="post.tags.label" default="Tags" />
		
	</label>
	<g:select name="tags" from="${com.grailsinaction.Tag.list()}" multiple="multiple" optionKey="id" size="5" value="${postInstance?.tags*.id}" class="many-to-many"/>

</div>




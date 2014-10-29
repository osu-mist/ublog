
<%@ page import="com.grailsinaction.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <g:message code="default.ublog.search"/>
    <meta name="layout" content="main"/> </head>
<body>
<formset>
    <g:message code="default.ublog.user.search"/>
    <g:form action="results">
        <label for="displayName">Name</label> <g:textField name="displayName" />

        ￼￼￼￼<g:submitButton name="search" value="Search"/> </g:form>
</formset>
</body>
</html>
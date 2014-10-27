<%--
  Created by IntelliJ IDEA.
  User: carlsbet
  Date: 10/27/14
  Time: 12:49 PM
--%>
<%@ page import="com.grailsinaction.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search uBlog</title>
    <meta name="layout" content="main"/> </head>
<body>
<formset>
    <legend>Search for Friends</legend>
    <g:form action="results">
        <label for="displayName">Name</label> <g:textField name="displayName" />

        ￼￼￼￼<g:submitButton name="search" value="Search"/> </g:form>
</formset>
</body>
</html>
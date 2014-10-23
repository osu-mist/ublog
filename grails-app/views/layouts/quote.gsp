<%--
  Created by IntelliJ IDEA.
  User: carlsbet
  Date: 10/17/14
  Time: 1:41 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html">
    <head>
    <title>QOTD &raquo; <g:layoutTitle/></title>
    <link rel="stylesheet" href=""
        <g:createLinkTo dir='css' file='snazzy.css' />
        " />
        <g:layoutHead/>
</head>
<body>
<ul id="menu"> <li>
    <g:remoteLink action="ajaxRandom" update="quote"> Next Quote
    </g:remoteLink>
</li>
    <li>
        <g:link action="list">
            Admin
        </g:link>
    </li> </ul>
    <div id="header">
        <img src=""
            <g:createLinkTo dir='images' file='logo.png' />
        " alt="logo"/>
    </div>
    <g:layoutBody/>
</body>
</html>
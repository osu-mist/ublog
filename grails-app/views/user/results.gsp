

<html>
<head>
    <title>"default.search.message"</title>

    <meta name="layout" content="main"/> </head>
<body>
<h1><g:message code="default.search.message"/></h1>
<p>Searched ${com.grailsinaction.User.count()} records for items matching <em>${term}</em>.
Found <strong>${users.size()}</strong> hits.
</p>
<ul>
    <g:each var="user" in="${users}"> <li>${user.displayName}</li>
    </g:each>
</ul>
<g:link action='search'>Search Again</g:link>
</body>
</html>

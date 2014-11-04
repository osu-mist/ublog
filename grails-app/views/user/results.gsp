<%--
  Created by IntelliJ IDEA.
  User: carlsbet
  Date: 10/27/14
  Time: 1:49 PM
--%>

<html>
<head>
    <title>Search Results</title>

    <meta name="layout" content="main"/> </head>
<body>
<h1>Results</h1>
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

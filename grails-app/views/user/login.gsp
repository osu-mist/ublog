<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title><g:message code="user.login.title"/></title>
</head>
<body>
<div class="body">
    <g:form action="doLogin" method="post">
        <div class="dialog">
            <p><g:message code="user.login.message"/></p>
            <table  class="userForm">
                <tr class='prop'>
                    <td valign='top' style='text-align:left;' width='20%'>
                        <label for='email'><g:message code="user.login.email"/> </label>
                    </td>
                    <td valign='top' style='text-align:left;' width='80%'>
                        <input id="email" type='text' name='email' value='${user?.email}' />
                        ￼
                    </td> </tr>
                <tr class='prop'>
                    <td valign='top' style='text-align:left;' width='20%'>
                        <label for='password'><g:message code="user.login.password"/> </label>
                    </td>
                    <td valign='top' style='text-align:left;' width='80%'>
                        <input id="password" type='password' name='password' value='${user?.password}' />
                    </td> </tr>
            </table>
        </div>
        <div class="buttons">
            <span class="formButton">
                <input type="submit" value="Login"></input>
            </span>
        </div>
    </g:form>
</div>
</body>
</html>
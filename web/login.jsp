<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <link rel="stylesheet" type="text/css" href="../css/reset.css" />
</head>
<body>

<form action="/LoginServlet" method="post" class="login-prompt">
    <h1 class="login-title">登录</h1>
    <input name="name_field" type="text" class="login-input-area"/><br/><br/><br/>
    <input name="password_field" type="password" class="login-input-area"/><br/><br/>
    <button class="sign-in-button" type="submit">登录</button>
</form>

</body>
</html>

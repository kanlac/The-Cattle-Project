<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>网站标题</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../style.css" />
    <link rel="stylesheet" type="text/css" href="../reset.css" />
</head>
<body>

    <div class="nav-item">
        <a href="#">关于</a>
    </div>

    <h1>杈趓乇抯駃鉏</h1>

    <div class="container-alpha">
        <div class="pic-block">
            <a href="#">
                <img src="#" alt="Some picture...">
            </a><br/>

            <input type="button" value=""/>

        </div>

        <div class="headline-block">
            <h2>仂猀呧觖陏</h2>
            <core:forEach var="post" items="${requestScope.posts}" end="2">
                <p><core:out value="${post.title}"/></p>
            </core:forEach>

        </div>
    </div>

</body>
</html>

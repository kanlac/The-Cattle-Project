<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>网站标题</title>
</head>
<body>

    <p> </p>

    <div class="nav-item">
        <a href="#">关于</a>
    </div>

    <h1>杈趓乇抯駃鉏</h1>

    <div class="container-alpha">
        <div class="pic-block">
            <a href="#">
                <img src="#" alt="Some picture...">
            </a><br/>

            <%--<input type="button" value="<%=i%>"/>--%>

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

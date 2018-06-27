<%--
  Created by IntelliJ IDEA.
  User: serfusE
  Date: 2018/6/27
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int pic_num = 5;
%>
<html>
<head>
    <title>网站标题</title>
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
<%
    for (int i = 1; i <= pic_num; i++) {
%>
            <input type="button" value="<%=i%>"/>
<%
    }
%>
        </div>

        <div class="headline-block">

        </div>
    </div>

</body>
</html>

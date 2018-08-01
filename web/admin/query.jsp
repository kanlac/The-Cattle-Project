<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
    <a href="appendCattle.jsp">添加牛</a>
    <form action="/QueryCattleServlet" method="post">
        编号：<input type="number" name="id"/>
        <input type="submit" value="查询">
    </form>

</body>
</html>

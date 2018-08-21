<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加牛的信息</title>
</head>
<body>
    <p>欢迎你，<core:out value="${sessionScope.account}"/></p><a href="${pageContext.request.contextPath}/LogoutServlet">注销</a><br/>

    <h1>添加</h1>

    <form action="${pageContext.request.contextPath}/AddCattleServlet" method="post">
        性别：<input type="radio" name="sex" value="male"/>公 <input type="radio" name="sex" value="female"/>母 <br/>
        生日：<input type="date" name="birthday"/><br/>
        体重：<input type="text" name="weight"/>kg<br/>
        <p>--- 以下为选填项 ---</p><br/>
        孩子编号：<input type="number" name="children_id"/><br/>

        <input type="reset" value="重置"/>
        <input type="submit" value="添加"/>
    </form>

</body>
</html>

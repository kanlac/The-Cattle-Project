<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加记录</title>
</head>
<body>
<p>欢迎你，<core:out value="${sessionScope.account}"/>。<a href="${pageContext.request.contextPath}/LogoutServlet">注销</a></p><br/>

<h1>添加</h1>

<form action="${pageContext.request.contextPath}/AddCattleServlet" method="post">
    性别：
    <input type="radio" name="sex" id="m-option" value="male"/>
    <label for="m-option">公</label>
    <input type="radio" name="sex" id="f-option" value="female"/>
    <label for="f-option">母</label>
    生日：
    <input type="date" name="birthday"/><br/>
    体重：
    <input type="text" name="weight"/>kg<br/>

    <p>--- 以下为选填项 ---</p><br/>
    孩子编号：
    <input type="text" name="children_id"/>用逗号分隔<br/>
    父母编号：
    <input type="text" name="parents_id"/>用逗号分隔<br/>

    <input type="reset" value="重置"/>
    <input type="submit" value="添加"/>
</form>

</body>
</html>

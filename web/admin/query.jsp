<%--Display right after administrator login.--%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
    <p>欢迎你，<core:out value="${sessionScope.account}"/><a href="${pageContext.request.contextPath}/LogoutServlet">注销</a></p><br/>

    <a href="appendCattle.jsp">录入新信息</a>
    <a href="${pageContext.request.contextPath}/GenTableServlet">查看所有</a>
    <form action="${pageContext.request.contextPath}/QueryCattleServlet" method="post">
        编号：<input type="number" name="id"/>
        <input type="submit" value="查询">
    </form>

</body>
</html>

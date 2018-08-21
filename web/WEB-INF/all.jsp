<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Cattle</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/GenTableServlet?sort=id">按编号排序</a>
    <a href="${pageContext.request.contextPath}/GenTableServlet?sort=birthday">按出生日期来排序</a>
    <a href="${pageContext.request.contextPath}/GenTableServlet?sort=birthday_desc">出生日期倒序</a>
    <a href="${pageContext.request.contextPath}/GenTableServlet?sort=weight">按体重排序</a><br/>

    <core:set var="list" value="${cattleList}"/>

    <core:forEach var="item" items="${list}">
        <core:out value="${item}"/><br/>
    </core:forEach>
</body>
</html>

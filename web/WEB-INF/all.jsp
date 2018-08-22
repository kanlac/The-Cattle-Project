<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<a href="${pageContext.request.contextPath}/GenTableServlet?sort=id">按编号排序</a>
<a href="${pageContext.request.contextPath}/GenTableServlet?sort=birthday">按出生日期来排序</a>
<a href="${pageContext.request.contextPath}/GenTableServlet?sort=birthday_desc">出生日期倒序</a>
<a href="${pageContext.request.contextPath}/GenTableServlet?sort=weight">按体重排序</a><br/>

<core:set var="list" value="${cattleList}"/>

<table>
    <tr>
        <td>编号</td>
        <td>性别</td>
        <td>出生日期</td>
        <td>体重</td>
        <td>父</td>
        <td>母</td>
        <td>子</td>
    </tr>
    <core:forEach var="item" items="${list}">
        <tr>
            <td><core:out value="${item.getId()}"/> </td>
            <td><core:out value="${item.getSex()}"/> </td>
            <td><core:out value="${item.getBirthdayStr()}"/> </td>
            <td><core:out value="${item.getWeight()}"/> </td>
            <td><core:out value="${item.getFatherId()}"/> </td>
            <td><core:out value="${item.getMotherId()}"/> </td>
            <td><core:out value="${item.getChildrenIds()}"/> </td>
        </tr>
    </core:forEach>
</table>

</body>
<head>
    <title>All Cattle</title>
</head>
</html>

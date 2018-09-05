<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<p>欢迎你，<core:out value="${sessionScope.account}"/>。<a href="${pageContext.request.contextPath}/LogoutServlet">注销</a></p><br/>

<a href="${pageContext.request.contextPath}/admin/query.jsp">返回</a><br/><br/>

<a href="${pageContext.request.contextPath}/GenTableServlet?sort=id">按编号排序</a>
<a href="${pageContext.request.contextPath}/GenTableServlet?sort=birthday">按出生日期来排序</a>
<a href="${pageContext.request.contextPath}/GenTableServlet?sort=birthday_desc">出生日期倒序</a>
<a href="${pageContext.request.contextPath}/GenTableServlet?sort=weight">按体重排序</a><br/>


<core:set var="list" value="${cattleList}"/>

<table border="1" cellspacing="0">
    <tr>
        <th>编号</th>
        <th>性别</th>
        <th>出生日期</th>
        <th>体重</th>
        <th>父</th>
        <th>母</th>
        <th>子</th>
    </tr>
    <core:forEach var="item" items="${list}">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${item.getId()}'/>"><core:out value="${item.getId()}"/></a>
            </td>
            <td><core:out value="${item.getSex()}"/> </td>
            <td><core:out value="${item.getBirthdayStr()}"/> </td>
            <td><core:out value="${item.getWeight()}"/> </td>
            <td>
                <core:choose>
                    <core:when test="${item.getFatherId() == ''}">
                        无
                    </core:when>
                    <core:otherwise>
                        <a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${item.getFatherId()}'/>"><core:out value="${item.getFatherId()}"/></a>
                    </core:otherwise>
                </core:choose>
            </td>
            <td>
                <core:choose>
                    <core:when test="${item.getMotherId() == ''}">
                        无
                    </core:when>
                    <core:otherwise>
                        <a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${item.getMotherId()}'/>"><core:out value="${item.getMotherId()}"/></a>
                    </core:otherwise>
                </core:choose>
            </td>
            <td>
                <core:choose>
                    <core:when test="${empty item.getChildrenIds()}">
                        无
                    </core:when>
                    <core:otherwise>
                        <core:forEach var="i" items="${item.getChildrenIds()}">
                            <a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${i}'/>"><core:out value="${i}"/></a>&nbsp;
                        </core:forEach>
                    </core:otherwise>
                </core:choose>
            </td>
        </tr>
    </core:forEach>
</table>

</body>
<head>
    <title>All Cattle</title>
</head>
</html>

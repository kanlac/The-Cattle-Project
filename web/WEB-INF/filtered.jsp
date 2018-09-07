<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>条件查找结果</title>
</head>
<body>

<core:set var="result" value="${result}"/>

<p>欢迎你，<core:out value="${sessionScope.account}"/>。<a href="${pageContext.request.contextPath}/LogoutServlet">注销</a></p><br/>

<a href="${pageContext.request.contextPath}/admin/query.jsp">返回</a><br/><br/>

<div class="filter-items">
    性别：<core:out value="${requestScope['condition-sex']}"/>
    年龄：<core:out value="${requestScope['condition-age']}"/>
    最早出生日期：<core:out value="${requestScope['condition-birth-origin']}"/>
    最晚出生日期：<core:out value="${requestScope['condition-birth-close']}"/>
    体重：<core:out value="${requestScope['condition-weight']}"/>
</div>

<br/><br/>

<div class="result-table">
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
        <core:forEach var="item" items="${result}">
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
</div>

</body>
</html>

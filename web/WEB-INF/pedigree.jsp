<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pedigree</title>
</head>
<body>
<core:set var="center" value="${requestScope.target}"/>
<core:set var="parents" value="${center.getParents()}"/>
<core:set var="size_p" value="${parents.size()}"/>
<core:set var="sc" value="${center.getSpouseAndChildren()}"/>
<core:set var="size_sc" value="${sc.size()}"/>

<p>欢迎你，<core:out value="${sessionScope.account}"/>。<a href="${pageContext.request.contextPath}/LogoutServlet">注销</a></p><br/>

<a href="${pageContext.request.contextPath}/admin/query.jsp">返回</a><br/><br/>

<div class="nav">
    <p>查询</p>
    <a href="#">文字新闻</a>
    <a href="#">图片新闻</a>
</div>

<br/><br/>

<div class="parents_column">
    父母亲：
    <div class="parent_upper">
        <core:choose>
            <core:when test="${size_p < 1}">
                <a href="#">Add parent for this particular cattle.</a>
            </core:when>
            <core:otherwise>
                <core:out value="${parents.get(0)}"/>
            </core:otherwise>
        </core:choose>
    </div>
    <div class="parent_lower">
        <core:choose>
            <core:when test="${size_p < 2}">
                <a href="#">Add parent for this particular cattle.</a>
            </core:when>
            <core:otherwise>
                <core:out value="${parents.get(1)}"/>
            </core:otherwise>
        </core:choose>
    </div>
</div>

<br/><br/>

<div class="center_column">
    当前节点：<br/>
    <core:out value="${center}"/>
</div>

<br/><br/>

<div class="sc_column">
    家庭：
    <core:forEach var="map" items="${sc}">
        <br/> {{{<br/> 配偶： <core:out value="${map.get(Character.valueOf('s'))}"/> <br/>孩子： <core:out value="${map.get(Character.valueOf('c'))}"/> <br/>}}}
    </core:forEach>
</div>

</body>
</html>

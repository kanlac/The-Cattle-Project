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

<div class="admin_info">
    <p>欢迎你，<core:out value="${sessionScope.account}"/>。<a href="#">注销</a></p>
</div>

<div class="nav">
    <p>查询</p>
    <a href="#">文字新闻</a>
    <a href="#">图片新闻</a>
</div>

<div class="parents_column">
    <div class="parent_upper">
        parent_upper
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
        parent_lower
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

<div class="center_column">
    center <core:out value="${center}"/>
</div>

<div class="sc_column">
    <core:forEach var="map" items="${sc}">
        SC {{{ spouse: <core:out value="${map.get(Character.valueOf('s'))}"/> child: <core:out value="${map.get(Character.valueOf('c'))}"/> }}}
    </core:forEach>
    SC {{{ Add spouse or children }}}
</div>

</body>
</html>

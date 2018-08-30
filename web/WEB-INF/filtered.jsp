<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>条件查找结果</title>
</head>
<body>

<core:set var="result" value="${result}"/>

<p>欢迎你，<core:out value="${sessionScope.account}"/>。<a href="${pageContext.request.contextPath}/LogoutServlet">注销</a></p><br/>

<div class="filter-items">
    性别：<core:out value="${requestScope['condition-sex']}"/>
    年龄：<core:out value="${requestScope['condition-age']}"/>
    最早出生日期：<core:out value="${requestScope['condition-birth-origin']}"/>
    最晚出生日期：<core:out value="${requestScope['condition-birth-close']}"/>
    体重：<core:out value="${requestScope['condition-weight']}"/>
</div>

<div class="result-table">
    <core:forEach var="item" items="${result}">
        <core:out value="${item}"/><br/>
    </core:forEach>
</div>

</body>
</html>

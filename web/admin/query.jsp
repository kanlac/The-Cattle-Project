<%--Display right after administrator login.--%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
<p>欢迎你，<core:out value="${sessionScope.account}"/>。<a href="${pageContext.request.contextPath}/LogoutServlet">注销</a></p><br/>

<div class="prefs">
    首选项<br/>
    <a href="appendCattle.jsp">录入新信息</a>
    <a href="${pageContext.request.contextPath}/GenTableServlet">查看所有</a>
</div>

<br/>

<div class="pedigree-lookup">
    谱系查询
    <form action="${pageContext.request.contextPath}/QueryCattleServlet" method="post">
        编号：<input type="number" name="id"/><br/>
        <input type="submit" value="查看谱系图">
    </form>
</div>

<div class="filter-lookup">
    条件查询
    <form action="#" method="post">
        性别：
        <input type="radio" name="selector" id="n-option"/>
        <label for="n-option">不限</label>
        <input type="radio" name="selector" id="m-option"/>
        <label for="m-option">公</label>
        <input type="radio" name="selector" id="f-option"/>
        <label for="f-option">母</label>
        <br/>
        年龄：
        <input type="number" name="a-low"/> - <input type="number" name="a-high"/>
        <br/>
        出生日期：
        <input type="date" name="origin"/> - <input type="date" name="close"/>
        <br/>
        体重：
        <input type="number" name="w-low"/> - <input type="number" name="w-high"/>
        <br/>

        <input type="submit" value="查看表格"/>
    </form>
</div>


<br/><br/>



</body>
</html>

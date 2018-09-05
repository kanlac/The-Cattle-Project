<%--Display right after administrator login.--%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css" />
</head>
<body>

<div class="nav-item">
    <p>欢迎你，<core:out value="${sessionScope.account}"/>。<a href="${pageContext.request.contextPath}/LogoutServlet">注销</a></p><br/>
</div>

<div class="general-section prefs-section">
    首选项<br/><br/>
    <a href="appendCattle.jsp">录入新信息</a>
    <a href="${pageContext.request.contextPath}/GenTableServlet">查看所有</a>
</div>

<br/>

<div class="general-section pedigree-lookup-section">
    谱系查询<br/><br/>
    <form action="${pageContext.request.contextPath}/QueryCattleServlet" method="post">
        编号：<input type="number" name="id"/><br/>
        <input type="submit" value="查看谱系图">
    </form>
</div>

<div class="general-section filter-lookup-section">
    条件查询<br/><br/>
    <form action="${pageContext.request.contextPath}/ScreenCattleServlet" method="post">
        性别：
        <input type="radio" name="filter-sex" id="n-option" value="none"/>
        <label for="n-option">不限</label>
        <input type="radio" name="filter-sex" id="m-option" value="male"/>
        <label for="m-option">公</label>
        <input  type="radio" name="filter-sex" id="f-option" value="female"/>
        <label for="f-option">母</label>
        <br/>
        年龄：
        <input class="input-box" type="number" name="filter-age-low"/> - <input class="input-box" type="number" name="filter-age-high"/>
        <br/>
        出生日期：
        <input class="input-box" type="date" name="filter-birth-origin"/> - <input class="input-box" type="date" name="filter-birth-close"/>
        <br/>
        体重：
        <input class="input-box" type="number" name="filter-weight-low"/> - <input class="input-box" type="number" name="filter-weight-high"/>
        <br/>

        <input type="submit" value="查看表格"/>
    </form>
</div>


<br/><br/>



</body>
</html>

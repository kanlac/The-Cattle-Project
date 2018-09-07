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

<div class="function-menu">
    <a style="float: left; font-family: STSongti-SC-Black">查询</a>
    <a href="${pageContext.request.contextPath}/admin/imageNews.jsp">图片新闻</a>
    <a href="#" style="float: right;">文字新闻</a>
</div>


<div class="general-section prefs-section">
    <div class="section-title">
        首选项
    </div>
    <a href="appendCattle.jsp">录入新信息</a>&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/GenTableServlet">查看所有</a>
</div>

<br/>

<div class="general-section pedigree-lookup-section">
    <div class="section-title">
        谱系查询
    </div>
    <form action="${pageContext.request.contextPath}/QueryCattleServlet" method="post">
        <a class="option-text">编号：</a><input type="number" name="id"/><br/>
        <input type="submit" value="查看谱系图">
    </form>
</div>

<div class="general-section filter-lookup-section">
    <div class="section-title">
        条件查询
    </div>
    <form action="${pageContext.request.contextPath}/ScreenCattleServlet" method="post">
        <a class="option-text">性别：</a>
        <input type="radio" name="filter-sex" id="n-option" value="none"/>
        <label for="n-option" class="option-text">不限</label>
        <input type="radio" name="filter-sex" id="m-option" value="male"/>
        <label for="m-option" class="option-text">公</label>
        <input  type="radio" name="filter-sex" id="f-option" value="female"/>
        <label for="f-option" class="option-text">母</label>
        <br/>
        <a class="option-text">年龄：</a>
        <input class="input-box" type="number" name="filter-age-low"/> - <input class="input-box" type="number" name="filter-age-high"/>
        <br/>
        <a class="option-text">出生日期：</a>
        <input class="input-box" type="date" name="filter-birth-origin"/> - <input class="input-box" type="date" name="filter-birth-close"/>
        <br/>
        <a class="option-text">体重：</a>
        <input class="input-box" type="number" name="filter-weight-low"/> - <input class="input-box" type="number" name="filter-weight-high"/>
        <br/>

        <input type="submit" value="查看表格"/>
    </form>
</div>


<br/><br/>



</body>
</html>

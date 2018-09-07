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

<br/><br/>

<div class="center_column">
    <h1 class="pedigree-group">当前节点：</h1>
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
        <tr>
            <td><a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${center.getId()}'/>"><core:out value="${center.getId()}"/></a></td>
            <td><core:out value="${center.getSex()}"/> </td>
            <td><core:out value="${center.getBirthdayStr()}"/> </td>
            <td><core:out value="${center.getWeight()}"/> </td>
            <td>
                <core:choose>
                    <core:when test="${center.getFatherId() == ''}">
                        无
                    </core:when>
                    <core:otherwise>
                        <a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${center.getFatherId()}'/>"><core:out value="${center.getFatherId()}"/></a>
                    </core:otherwise>
                </core:choose>
            </td>
            <td>
                <core:choose>
                    <core:when test="${center.getMotherId() == ''}">
                        无
                    </core:when>
                    <core:otherwise>
                        <a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${center.getMotherId()}'/>"><core:out value="${center.getMotherId()}"/></a>
                    </core:otherwise>
                </core:choose>
            </td>
            <td>
                <core:choose>
                    <core:when test="${empty center.getChildrenIds()}">
                        无
                    </core:when>
                    <core:otherwise>
                        <core:forEach var="i" items="${center.getChildrenIds()}">
                            <a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${i}'/>"><core:out value="${i}"/></a>&nbsp;
                        </core:forEach>
                    </core:otherwise>
                </core:choose>
            </td>
        </tr>
    </table>
</div>

<br/><br/>

<div class="parents_column">
    <h1 class="pedigree-group">父母亲：</h1>
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
        <core:choose>
            <core:when test="${size_p == 1 || size_p == 2}">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${parents.get(0).getId()}'/>"><core:out value="${parents.get(0).getId()}"/></a></td>
                    <td><core:out value="${parents.get(0).getSex()}"/> </td>
                    <td><core:out value="${parents.get(0).getBirthdayStr()}"/> </td>
                    <td><core:out value="${parents.get(0).getWeight()}"/> </td>
                    <td>
                        <core:choose>
                            <core:when test="${parents.get(0).getFatherId() == ''}">
                                无
                            </core:when>
                            <core:otherwise>
                                <a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${parents.get(0).getFatherId()}'/>"><core:out value="${parents.get(0).getFatherId()}"/></a>
                            </core:otherwise>
                        </core:choose>
                    </td>
                    <td>
                        <core:choose>
                            <core:when test="${parents.get(0).getMotherId() == ''}">
                                无
                            </core:when>
                            <core:otherwise>
                                <a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${parents.get(0).getMotherId()}'/>"><core:out value="${parents.get(0).getMotherId()}"/></a>
                            </core:otherwise>
                        </core:choose>
                    </td>
                    <td>
                        <core:choose>
                            <core:when test="${empty parents.get(0).getChildrenIds()}">
                                无
                            </core:when>
                            <core:otherwise>
                                <core:forEach var="i" items="${parents.get(0).getChildrenIds()}">
                                    <a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${i}'/>"><core:out value="${i}"/></a>&nbsp;
                                </core:forEach>
                            </core:otherwise>
                        </core:choose>
                    </td>
                </tr>
            </core:when>
        </core:choose>

        <core:choose>
            <core:when test="${size_p == 2}">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${parents.get(1).getId()}'/>"><core:out value="${parents.get(1).getId()}"/></a></td>
                    <td><core:out value="${parents.get(1).getSex()}"/> </td>
                    <td><core:out value="${parents.get(1).getBirthdayStr()}"/> </td>
                    <td><core:out value="${parents.get(1).getWeight()}"/> </td>
                    <td>
                        <core:choose>
                            <core:when test="${parents.get(1).getFatherId() == ''}">
                                无
                            </core:when>
                            <core:otherwise>
                                <a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${parents.get(1).getFatherId()}'/>"><core:out value="${parents.get(1).getFatherId()}"/></a>
                            </core:otherwise>
                        </core:choose>
                    </td>
                    <td>
                        <core:choose>
                            <core:when test="${parents.get(1).getMotherId() == ''}">
                                无
                            </core:when>
                            <core:otherwise>
                                <a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${parents.get(1).getMotherId()}'/>"><core:out value="${parents.get(1).getMotherId()}"/></a>
                            </core:otherwise>
                        </core:choose>
                    </td>
                    <td>
                        <core:choose>
                            <core:when test="${empty parents.get(1).getChildrenIds()}">
                                无
                            </core:when>
                            <core:otherwise>
                                <core:forEach var="i" items="${parents.get(1).getChildrenIds()}">
                                    <a href="${pageContext.request.contextPath}/QueryCattleServlet?id=<core:out value='${i}'/>"><core:out value="${i}"/></a>&nbsp;
                                </core:forEach>
                            </core:otherwise>
                        </core:choose>
                    </td>
                </tr>
            </core:when>
        </core:choose>
    </table>
</div>

<br/><br/>

<div class="sc_column">
    <h1 class="pedigree-group">家庭：</h1>
    <core:forEach var="map" items="${sc}">
        <br/> [<br/> 配偶： <core:out value="${map.get(Character.valueOf('s'))}"/> <br/>孩子： <core:out value="${map.get(Character.valueOf('c'))}"/> <br/>]
    </core:forEach>
</div>

</body>
</html>

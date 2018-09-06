<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传图片新闻</title>
</head>
<body>

<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" >
    选择图片：
    <input type="file" name="file" id="file" /> <br/>
    </br>
    <input type="submit" value="Upload" name="upload" id="upload" />
    ${result}
</form>

</body>
</html>

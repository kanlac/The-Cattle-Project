<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加牛的信息</title>
</head>
<body>
    <h1>添加</h1>

    <form action="/AppendCattleServlet" method="post">
        编号：<input type="number" name="id"/><br/>
        性别：<input type="radio" name="sex" value="m"/>公 <input type="radio" name="sex" value="f"/>母 <br/>
        生日：<input type="date" name="birthday"/><br/>
        体重：<input type="number" name="weight"/>kg<br/>
        种类：<input type="text" name="variety"/><br/>
        <p>--- 以下为选填项 ---</p><br/>
        父亲编号：<input type="text" name="father_id"/><br/>
        母亲编号：<input type="text" name="mother_id"/><br/>
        孩子编号：<input type="text" name="children_id"/><br/>

        <input type="reset" value="重置"/>
        <input type="submit" value="添加"/>
    </form>

</body>
</html>

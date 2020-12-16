<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/4 0004
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增数据</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/saveemp" method="post">
    <table>
        <tr>
            <td>员工姓名</td>
            <td><input type="text" name="ename" value="ename1"></td>
        </tr>
        <tr>
            <td>入职日期</td>
            <td><input type="date" name="hiredate" value="2020-10-01"></td>
        </tr>
        <tr>
            <td>员工薪资</td>
            <td><input type="text" name="sal" value="5000"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="撤销"></td>
        </tr>
    </table>
</form>
</body>
</html>

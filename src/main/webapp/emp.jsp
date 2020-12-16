<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>DEMO</title>
    <style type="text/css">
        td{
            width: 120px;
            height: 30px;
            text-align: center;
        }
        td:hover{
            box-shadow: 3px 3px 5px yellowgreen;
        }
        tr:nth-child(even){
            background-color: lightblue;
        }
    </style>
</head>
<body>
<table id="empsInfo">
    <tr>
        <td>empno</td>
        <td>ename</td>
        <td>hiredate</td>
        <td>sal</td>
        <td>operation</td>
    </tr>
    <c:forEach items="${empsFromServer}" var="emp">
        <tr>
            <td>${emp.empno}</td>
            <td>${emp.ename}</td>
            <td>${emp.hiredate}</td>
            <td>${emp.sal}</td>
            <td><a href="${pageContext.request.contextPath}/searchByEmpno?empno=${emp.empno}">修改</a>  <a href="${pageContext.request.contextPath}/delete?empno=${emp.empno}"  onclick="return confirm('是否删除?')">删除</a></td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/newemp.jsp">增加</a>
<hr>
<form action="${pageContext.request.contextPath}/searchByEmpno" method="post">
    EMPNO:<input type="text" name="empno" placeholder="请输入编号">
          <input type="submit" value="精度查询">
</form>
<hr>
<form action="${pageContext.request.contextPath}/searchByName" method="post">
    ENAME:<input type="text" name="ename" placeholder="请输入姓名">
    <input type="submit" value="模糊查询">
</form>

<script src="jquery-3.5.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#deleteBtn").click(function () {


        })

    })
</script>
</body>
</html>

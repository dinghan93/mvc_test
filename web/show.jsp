<%--
  Created by IntelliJ IDEA.
  User: handi
  Date: 2021/7/24
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.11.1.js"></script>
    <script src="js/bootstrap.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="css/bootstrap-theme.css" />
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<div class="container">
    <table class="table table-bordered table-hover">
        <tr>
            <td>id</td>
            <td>用户名</td>
            <td>密码</td>
        </tr>
        <c:forEach items="${requestScope.users}" var="user">
            <tr>
                <td>${user.userid}</td>
                <td>${user.username}</td>
                <td>${user.userpass}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

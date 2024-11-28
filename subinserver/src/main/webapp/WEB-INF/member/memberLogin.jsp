<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24. 11. 28.
  Time: 오전 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login Page</h1>
<form action="/member/login" method="post">
    <input type="text" name="mid">
    <input type="text" name="mpw">
    <button type="submit">로그인</button>
</form>
</body>
</html>

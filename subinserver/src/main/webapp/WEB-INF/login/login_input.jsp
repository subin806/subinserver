<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24. 11. 20.
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN TEST</title>
</head>
<body>
<h1>미니실습 로그인 화면 서블릿으로 접근해보기</h1>
<form action="/login/result" method="post">
    <input type = "text" name="id">
    <input type = "number" name="password">
    <button type="submit">로그인</button>
</form>
</body>
</html>
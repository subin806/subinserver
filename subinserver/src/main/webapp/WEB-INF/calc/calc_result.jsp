<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24. 11. 20.
  Time: 오후 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>넘어온 데이터 확인 num1 : ${param.num1}</h1>
<h1>넘어온 데이터 확인 num2 : ${param.num2}</h1>
<h1>넘어온 데이터 확인 num1 + num2 : ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)}</h1>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24. 11. 27.
  Time: 오후 3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원가입하기</h1>
<form action="/member/register" method="post">
    <div>
        <input type="text" name="id" placeholder="id를 작성해주세요">
    </div>
    <div>
        <input type="password" name="password" placeholder="password를 작성해주세요">
    </div>
    <button type="reset">초기화</button>
    <button type="submit">회원가입</button>
</form>
</body>
</html>


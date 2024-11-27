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
<h1>My Info 상세보기 및 수정 및 삭제</h1>
<div>
    <input type="text" name="mno" value="${dto.mno}" readonly>
</div>
<div>
    <input type="text" name="id" value="${dto.id}" readonly>
</div>
<div>
    <input type="password" name="password" value="${dto.password}" readonly>
</div>
<div>
    <a href="/member/update?mno=${dto.mno}">수정/삭제</a>
    <a href="/member/list">목록가기</a>
</div>
</body>
</html>


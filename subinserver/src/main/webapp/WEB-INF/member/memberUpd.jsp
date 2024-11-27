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
<h1>My info 수정 및 삭제하기 </h1>
<form action="/member/update?mno=${dto.mno}" method="post">
    <div>
        <input type="text" name="mno" value="${dto.mno}" readonly>
    </div>
    <div>
        <input type="text" name="id" value="${dto.id}"  >
    </div>
    <div>
        <input type="password" name="password" value="${dto.password}" >
    </div>
    <div>
        <button type="submit">수정하기</button>


    </div>
</form>

<form action="/member/delete?mno=${dto.mno}" method="post">
    <button type="submit">삭제하기</button>
</form>
<a href="/member/list">목록가기</a>
</body>
</html>

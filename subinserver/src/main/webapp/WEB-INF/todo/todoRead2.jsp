<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 21.
  Time: 오후 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>jdbcex 작업 중. tno 번호로 하나 조회하는 화면, 상세보기와 같은 역할. </h1>
임시 서블릿 컨텍스트의 애플리케이션 공간에 저장된 변수 조회 : ${appTestName}
<div>
    <input type="text" name="tno" value="${dto.tno}" readonly>
</div>
<div>
    <input type="text" name="title" value="${dto.title}" placeholder="제목 입력 해주세요." readonly>
</div>
<div>
    <input type="date" name="dueDate" value="${dto.dueDate}">
</div>
<div>
    <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} readonly>
</div>
<div>
    <a href="/todo/update?tno=${dto.tno}">수정/삭제</a>
    <a href="/todo/list2">목록가기</a>
</div>
</body>
</html>

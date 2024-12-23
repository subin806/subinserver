<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 21.
  Time: 오전 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL 사용하기 준비 단계--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Food 등록하기 </h1>
  <%--  로그인 한 유저 표시--%>
  임시 로그인한 유저 정보: ${loginInfo}
<h1>${loginInfo.mname}님! 환영합니다</h1>

  <form action="/logout" method="post">
    <button type="submit">로그아웃테스트</button>
  </form>
    <a href="/food/register2">글쓰기 폼이동</a>
  <h2>FoodList 하나 조회 </h2>
  <a href="/food/read2?tno=1">하나 조회</a>



  <h1>Food 목록 수정/삭제</h1>
  <ul>
    <c:forEach var="dto" items="${list}">
      <li>
        <span>${dto.fno}</span>
        <span><a href="/food/read2?fno=${dto.fno}">${dto.title}</a></span>
        <span>${dto.dueDate}</span>
        <span>${dto.finished? "완료": "미완료"}</span>
      </li>
    </c:forEach>
  </ul>


</body>
</html>

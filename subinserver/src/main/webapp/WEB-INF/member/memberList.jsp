<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24. 11. 27.
  Time: 오후 3:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>LogIn 목록화면 </h1>
<a href="/member/register">회원가입하러가기</a>
<h2>My Info select </h2>
<a href="/member/read?mno=4">Info 조회하기</a>



<h2>My Info 목록</h2>
<h3>반복문 forEach 이용, var=변수명, items="데이터 목록"</h3>
<ul>
    <c:forEach var="dto" items="${list}">
        <li>
            <span>아이디: <a href="/member/read?mno=${dto.mno}">${dto.id}</a></span>
            <span>비밀번호: <a href="/member/read?mno=${dto.mno}">${dto.password}</a></span>
        </li>
    </c:forEach>
</ul>


</body>
</html>


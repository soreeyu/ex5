<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<c:if test="${member eq null}">
<a href="member/studentJoin">MemberJoin</a> <br>
<a href="member/studentLogin">MemberLogin</a> <br>
</c:if>
<c:if test="${member ne null}">
<a href="member/memberLogout">MemberLogout</a>
<a href="member/MemberPage">MyPage</a>
</c:if>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>

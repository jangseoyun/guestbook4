<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gb4.deleteForm</title>
</head>

<body>

	<form action="/guestbook4/guest/delete" method="get">
		비밀번호 <input type="text" name="password" value="">
		<button type="submit" name="no" value="${param.no}">확인</button> <br>	
	</form>
	
	<a href="/guestbook4/guest/addList">메인으로 돌아가기</a> <br>
	
</body>

</html>
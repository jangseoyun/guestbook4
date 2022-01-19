<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>gb4.addList</title>
</head>

<body>
	<!-- 등록 폼 영역 -->
	<form action = "/guestbook4/guest/add" method="get">
		<table border="1" width="500px">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" value=""></td>
			<tr>
			<tr>
				<td colspan="4"><textarea cols="65" rows="5" name = "content" ></textarea></td>
			</tr>
			<tr>
				<td colspan="4">
					<button type="submit">글작성</button>
				</td>
			</tr>
		</table>
	</form>
	<!-- 등록 폼 영역 -->
	<br>
	
	<!-- 리스트 폼 영역 -->
	<c:forEach items="${requestScope.guestbookList}" var="gbList">
		<form action="/guestbook4/guest/addList" method="get">
			<table border="1" width = "500px">
				<tr>
					<td>${gbList.no}</td>
					<td>${gbList.name}</td>
					<td>${gbList.regDate}</td>
					<td><a href = "/guestbook4/guest/deleteForm?no=${gbList.no}">삭제</a></td>
				</tr>
				<tr>
					<td colspan="4">
						${gbList.content}
					</td>
				</tr>
			</table>
		</form>
		<br>
	</c:forEach>
	<!-- 리스트 폼 영역 -->
	
</body>

</html>
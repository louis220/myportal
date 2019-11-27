<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>My Homepage</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
</head>
<body>
	<table border="1" width="640">
		<tr>
			<td colspan="6"><h3>게시판</h3></td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>작성일</th>
			<th>&nbsp;</th>
		</tr>
		<!-- loop -->
		<c:forEach items="${list }" var="vo">
		<tr>
			<td>${vo.no }</td>
			<td><a href="">${vo.title }</a></td>
			<td>${vo.memberName }</td>
			<td>${vo.hit }</td>
			<td>${vo.regdate }</td>
			<td>
				<c:if test="${not empty authMember }">
				<c:if test="${authMember.no == vo.memberNo }">
					<a href="">삭제</a>
				</c:if>
				</c:if>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<!-- 글쓰기는 로그인 유저만 할 수 있습니다 -->
			<td colspan="6">
				<c:if test="${not empty authMember }">
				
			<a href="<c:url value="/board/write"/>">글쓰기</a>
			</c:if>
			</td>
			
		</tr>
	</table>
</body>
</html>





















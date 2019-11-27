<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Homepage</title>
<!-- TODO: 현재 페이지에 적절한 CSS를 임포트하십시오. -->

</head>
<body>
	<form id="login-form" 
		name="loginform" 
		method="POST" 
		action="<c:url value="/members/login"/>">
		
		<label class="block-label" for="email">이메일</label> 
		<input id="email" name="email" type="text" value=""> 

		<label class="block-label">패스워드</label> 
		<input name="password" type="password" value="">

		<input type="submit" value="로그인">
	</form>
    
</body>
</html>
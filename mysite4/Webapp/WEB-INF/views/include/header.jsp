<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<title>Insert title here</title>


<div id="header">
	<h1>
		<a href="${pageContext.request.contextPath}/main">MySite</a>
	</h1>

		<c:choose>
		<c:when test="${empty authUser }">
		 <ul>
				<li><a href="${pageContext.request.contextPath}/user/lform">로그인</a></li>
				<li><a href="${pageContext.request.contextPath}/user/jform">회원가입</a></li>
			</ul>
		</c:when>
		<c:when test="${!empty authUser}">
		<ul>
				<li>${authUser.name}님 안녕하세요^^</li>
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/user/rform">회원정보수정</a></li>
			</ul>
		</c:when>
		</c:choose>

</div>
<!-- //header -->

<div id="nav">
	<ul>
		<li><a href="${pageContext.request.contextPath}/guest">방명록</a></li>
		<li><a href="">갤러리</a></li>
		<li><a href="${pageContext.request.contextPath}/board">게시판</a></li>
		<li><a href="">입사지원서</a></li>
	</ul>
	<div class="clear"></div>
</div>

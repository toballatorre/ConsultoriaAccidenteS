<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Area Administrador</title>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="contenido">
		<jsp:include page="MenuAdmin.jsp" />
		<br>
		<h1>Vista Administrador</h1>
		<br>
		<br>
		<br>
		<img alt="" src="${pageContext.request.contextPath}/resources/img/casco.png">
		<br>
		<br>
		<br>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
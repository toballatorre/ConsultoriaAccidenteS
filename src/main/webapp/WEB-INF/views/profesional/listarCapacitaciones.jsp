<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> - Vista Profesional</title>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuProfesional.jsp" />
	<br><h1>Vista Profesional</h1>
	<h2>Listar Capacitaciones</h2>
		
		<table class="table table-striped table-hover">
		<thead class="thead-light">
			<tr>
				<th>#</th>
				<th>Tema</th>
				<th>Cliente</th>
				<th>Fecha</th>
				<th>Profesional</th>
				<th></th>
			</tr>
		</thead>
			<c:forEach items="${listaCap}" var="cap">
			<fmt:formatDate value="${cap.getFecha()}" pattern="dd/MM/yyyy" var="fecha"/>
				<tr>
					<td> <c:out value="${cap.getId()}"/> </td>
					<td> <c:out value="${cap.getTema()}"/> </td>
					<td> <c:out value="${cap.getIdCliente()}"/> </td>
					<td> <c:out value="${fecha}"/> </td>
					<td> <c:out value="${cap.getIdUsuarioPro()}"/> </td>
					<td> <a href="${pageContext.request.contextPath}/capacitacion/detalle/${cap.getId()}">Detalle</a> </td>
				</tr>
			</c:forEach>
	</table>
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
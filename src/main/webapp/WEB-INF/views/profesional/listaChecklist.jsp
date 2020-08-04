<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Checklist - Vista Profesional</title>
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
	<h2>Lista Checklist</h2>
	
	
	<table class="table table-striped table-hover">
		<thead class="thead-light">
			<tr>
				<th>ID</th>
				<th>Cliente</th>
				<th>Descripcion</th>
				<th>Status</th>
				<th>Acciones</th>		
			</tr>
		</thead>
			<c:forEach items="${listaCh}" var="ch">
				<tr>
					<td> <c:out value="${ch.getId()}"/> </td>
					<td> <c:out value="${ch.getIdCliente()}"/> </td>
					<td> <c:out value="${ch.getDescripcion()}"/> </td>
					<td> <c:out value="${ch.getStatus()}"/> </td>
					<td> <a href="${pageContext.request.contextPath}/checklist/detalle/${ch.getId()}"><i class="far fa-eye"></i></a> </td>
				</tr>
			</c:forEach>
	</table>
	
	<a href="crear" class="btn btn-primary" role="button"><i class="far fa-plus-square"></i> Crear Checklist</a>
		
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
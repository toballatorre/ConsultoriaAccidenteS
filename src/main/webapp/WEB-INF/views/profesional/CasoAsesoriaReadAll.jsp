<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Casos de Asesoria - Vista Profesional</title>
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
	<h2>Casos de asesoria</h2>
	
		<table class="table table-striped table-hover">
		<thead class="thead-light">
			<tr>
				<th>IdCaso</th>
				<th>Cliente</th>
				<th>Codigo Contrato</th>
				<th>Plan</th>
				<th>Contacto</th>		
				<th>Activo</th>		
				<th>Detalles</th>		
			</tr>
		</thead>
			<c:forEach items="${listaCA}" var="ca">
				<tr>
					<td> <c:out value="${ca.getIdcaso()}"/> </td>
					<td> <c:out value="${ca.getIdcliente()}"/> </td>
					<td> <c:out value="${ca.getCodigocontrato()}"/> </td>
					<td> <c:out value="${ca.getPlan()}"/> </td>
					<td> <c:out value="${ca.getContacto()}"/> </td>
					<td> <c:out value="${ca.getCasoactivo()}"/> </td>
					<td> <a href="${pageContext.request.contextPath}/CasoAsesoria/leer/${ca.getIdcaso()}"><i class="far fa-eye"></i></a> </td>
				</tr>
			</c:forEach>
	</table>
	
	<a href="crear" class="btn btn-primary" role="button"><i class="far fa-plus-square"></i> Caso Asesoria</a>
		
	
	
	
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
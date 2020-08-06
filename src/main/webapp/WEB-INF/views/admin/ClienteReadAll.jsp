<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Clientes</title>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuAdmin.jsp" />
	<br><h1>Vista Administrador</h1>
	<h2>Listado de clientes</h2>
	
	<table class="table table-striped table-hover">
		<thead class="thead-light">
			<tr>
				<th>ID</th>
				<th>Nombre Empresa</th>
				<th>Información</th>
				<th>Accidentabilidad</th>
				<th></th>
				
			</tr>
		</thead>
		<c:forEach items="${listaClientes}" var="cliente">
			<tr>
				<td><c:out value="${cliente.getId()}"/></td>
				<td><c:out value="${cliente.getNombreEmpresa()}"/></td>
				<td><a href="ClienteUpdate/${cliente.getId()}"><i class="fab fa-wpforms"></i></a></td>
				<td><a href="ReportesAccidentes/${cliente.getId()}"><i class="fas fa-user-injured"></i></a></td>
				<td><a class="btn btn-outline-info" href="ReporteCliente/${cliente.getId()}">Generar Reporte</a></td>
			</tr>
		</c:forEach>		
		
			</table>
	
	
	
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
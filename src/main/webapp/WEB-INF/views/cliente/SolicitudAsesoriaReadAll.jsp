<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Reporte Accidente</title>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuCliente.jsp" />
	<br><h1>Vista Cliente</h1>
	<h2>Solicitudes de Asesoria Especial</h2>
	
	<table class="table table-striped table-hover">
			<tr>
				<th>ID</th>
				<th>Fecha solicitud</th>
				<th>Motivo</th>
				<th>Preferencia horario</th>
			</tr>
	
			<c:forEach items="${listaSolicitud}" var="sol">
				<tr>
					<td> <c:out value="${sol.getId()}"/> </td>
					<td> <c:out value="${sol.getFechaHora()}"/> </td>
					<td> <c:out value="${sol.getMotivo()}"/> </td>
					<td> <c:out value="${sol.getPreferenciaHorario()}"/> </td>
				</tr>
			</c:forEach>
	
		</table>
	
	<a href="SolicitudAsesoriaCreate">Crear</a>
	
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
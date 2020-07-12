<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Reporte Accidente</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuCliente.jsp" />
	<br><h1>Vista Cliente</h1>
	<h2>Solicitudes de Asesoria Especial</h2>
	
	<table>
			<tr>
				<th>ID</th>
				<th>Fecha solicitud</th>
				<th>Motivo</th>
				<th>Preferencia horario</th>
			</tr>
	
			<tr>
				<td>1</td>
				<td>2020/07/03</td>
				<td>Preparación para auditoria ISO9001</td>
				<td>Mañana</td>
			</tr>
	
		</table>
	
	<a href="SolicitudAsesoriaCreate">Crear</a>
	
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Revisar Accidentabilidad</title>
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
	<h2>Ver Accidentabilidad</h2>
	
	<table class="table table-striped table-hover">
			<tr>
				<th>ID</th>
				<th>Fecha accidente</th>
				<th>Lugar</th>
				<th>Tipo Accidente</th>
				<th>Dias perdidos</th>
				<th>Descripcion</th>
				<th>Cliente</th>
				
			</tr>
			
			<c:forEach items="${model.listaReporte}" var="reporte">
				<c:if test="${reporte.getIdCliente() == model.idCliente}">
					<tr>
						<td>${reporte.getId()}</td>
						<td>${reporte.getFechaAccidente()}</td>
						<td>${reporte.getLugarAccidente()}</td>
						<td>${reporte.getTipoAccidente()}</td>
						<td>${reporte.getDiasPerdidos()}</td>
						<td>${reporte.getDescripcion()}</td>
						<td>${reporte.getIdCliente()}</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
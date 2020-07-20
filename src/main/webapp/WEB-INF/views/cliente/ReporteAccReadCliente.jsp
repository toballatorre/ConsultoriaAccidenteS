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
	<h2>Reporte Accidente</h2>
	
	<table class="table table-striped table-hover">
		<thead class="thead-light">
			<tr>
				<th>ID</th>
				<th>Fecha accidente</th>
				<th>Lugar</th>
				<th>Tipo Accidente</th>
				<th>Dias perdidos</th>
				<th>Descripcion</th>
			</tr>
			</thead>
	
			<tr>
				<td>1</td>
				<td>2020/07/03</td>
				<td>Av siempreviva 123</td>
				<td>Trayecto</td>
				<td>3</td>
				<td>Caida mismo nivel. Esguince de tobillo</td>
			</tr>
	
		</table>
	
	<a href="ReporteAccidenteCreate">Crear</a>
	
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
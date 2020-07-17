<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Detalle Capacitación <c:out value="${id}"/> </title>
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
		<h2>Detalle Capacitacion <c:out value="${cap.getId()}"/></h2>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th colspan="4">Detalle Capacitacion <c:out value="${cap.getId()}"/></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Cliente</td>
					<td><c:out value="${cap.getIdCliente()}"/></td>
					<td>Fecha</td>
					<td><c:out value="${cap.getFecha()}"/></td>
				</tr>
				<tr>
					<td>Tema</td>
					<td colspan="3"><c:out value="${cap.getTema()}"/></td>
				</tr>
				<tr>
					<td>Objetivos</td>
					<td colspan="3"><c:out value="${cap.getObjetivos()}"/></td>
				</tr>
				<tr>
					<td>Contenidos</td>
					<td colspan="3"><c:out value="${cap.getContenidos()}"/></td>
				</tr>
				<tr>
					<td>Recursos</td>
					<td><c:out value="${cap.getRecursos()}"/></td>
					<td>Encargado</td>
					<td><c:out value="${cap.getIdUsuarioPro()}"/></td>
				</tr>
			</tbody>
		</table>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
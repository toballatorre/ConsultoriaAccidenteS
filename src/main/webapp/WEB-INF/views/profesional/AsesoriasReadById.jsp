<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ver Asesorias del caso - Vista Profesional</title>
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
	<h2>Ver asesorias del caso</h2>
	
	
	<table class="table">
		<tr>
			<td>Caso:</td>
			<td><c:out value="${modelo.caso.getIdcaso()}"/></td>
			<td>Cliente:</td>
			<td><c:out value="${modelo.caso.getIdcliente()}"/></td>
			<td>Codigo contrato:</td>
			<td><c:out value="${modelo.caso.getCodigocontrato()}"/></td>
		</tr>
		<tr>
			<td>Plan:</td>
			<td><c:out value="${modelo.caso.getPlan()}"/></td>
			<td>Contacto Cliente:</td>
			<td><c:out value="${modelo.caso.getContacto()}"/></td>
			<td>Activo:</td>
			<td><c:out value="${modelo.caso.getCasoactivo()}"/></td>
		</tr>
	</table>
	
	<table class="table table-striped table-hover">
		<tr>
			<th colspan="4">Asesorias</th>
			<th><a href="../crearasesoria/${modelo.caso.getIdcaso()}" class="btn btn-primary" role="button"><i class="far fa-plus-square"></i> Ingresar Asesoria</a></th>
		</tr>
		<tr>
			<th>Id</th>
			<th>Fecha:</th>
			<th>Profesional:</th>
			<th>Lugar:</th>
			<th>Comentarios:</th>
		</tr>
	<c:forEach items="${modelo.asesorias}" var="as">
		<tr>
			<td><c:out value="${as.getIdasesoria()}"/></td>
			<td><c:out value="${as.getFechaasesoria()}"/></td>
			<td><c:out value="${as.getProfesional()}"/></td>
			<td><c:out value="${as.getLugar()}"/></td>
			<td><c:out value="${as.getComentarios()}"/></td>
		</tr>
	</c:forEach>
	</table>
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
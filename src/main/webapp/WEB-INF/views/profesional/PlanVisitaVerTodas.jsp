<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Solicitudes Asesoria - Vista Profesional</title>
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
	<h2>Planificación de Asesorias Especiales</h2>
	
	<table class="table table-striped table-hover">
			<tr>
				<th>ID</th>
				<th>Fecha solicitud</th>
				<th>Motivo</th>
				<th>Preferencia horario</th>
				<th>Status</th>
				<th>Fecha agendada</th>
				<th>Lugar</th>
				<th>Contacto cliente</th>
				<th>Detalle</th>
				<th>Agendar</th>
			</tr>
	
			<c:forEach items="${listaS}" var="s">
				<tr>
					<td> <c:out value="${s.getId()}"/> </td>
					<fmt:formatDate value="${s.getFechasolicitud()}" pattern="dd/MM/yyyy" var="fechaS"/>
					<td> <c:out value="${fechaS}"/> </td>
					<td> <c:out value="${s.getMotivo()}"/> </td>
					<td> <c:out value="${s.getPreferenciaHorario()}"/> </td>
					<td> <c:out value="${s.getStatus()}"/> </td>
					<fmt:formatDate value="${s.getFechaagenda()}" pattern="dd/MM/yyyy" var="fechaA"/>
					<td> <c:out value="${fechaA}"/> </td>
					<td> <c:out value="${s.getLugar()}"/> </td>
					<td> <c:out value="${s.getContacto()}"/> </td>
					<td> <c:out value="${s.getDetalle()}"/> </td>
					<td> 
					<a href="${pageContext.request.contextPath}/ProAgendarEdit/${s.getId()}"><i class="fas fa-calendar-check"></i></a>
					
					
					</td>
				</tr>
		</c:forEach>
	
		</table>

	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
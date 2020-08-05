<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agendar Asesoria - Vista Profesional
</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
		<jsp:include page="../MenuProfesional.jsp" />
		<br>
		<h1>Vista Profesional</h1>
		<h2>Planificar visita</h2>
		<form action="../ProAgendarSave" method="post">
			<table class="table">
				<thead class="thead-light">
					<tr>
						<th colspan="4">Solicitud</th>
					</tr>
					<tr>
						<td>IdSolicitud: </td>
						<td><input type="number" name="id" value="${sa.getId()}"/> </td>
						<td>Cliente: </td>
						<td><input type="number" name="idCliente" value="${sa.getIdCliente()}"/> </td>
					</tr>
					<tr>
						<td>Fecha Solicitada: </td>
						<fmt:formatDate value="${sa.getFechasolicitud()}" pattern="dd/MM/yyyy" var="fechaS"/>
						<td><input type="date" name="fechasolicitud" value="${fechaS}" /> </td>
						<td>Preferencia horaria:</td>
						<td><input type="text" name="preferenciaHorario" value="${sa.getPreferenciaHorario()}" /> </td>
					</tr>
					<tr>
						<td>Motivo</td>
						<td colspan="3"><textarea rows = "3" cols = "80" name = "motivo" maxlength="1000" readonly><c:out value="${sa.getMotivo()}"/></textarea></td>
					</tr>
					<tr>
						<th colspan="4">Agenda</th>
					</tr>
					<tr>
						<td>Agenda</td>
						<c:choose>
							<c:when test="${sa.getFechaagenda() == null}">
								<fmt:formatDate value="${date}" pattern="dd/MM/yyyy" var="fechaA"/>
							</c:when>
							<c:otherwise>
								<fmt:formatDate value="${sa.getFechaagenda()}" pattern="dd/MM/yyyy" var="fechaA"/>							
							</c:otherwise>
						</c:choose>
						<td><input type="date" name="fechaagenda" value="${fechaA}"/> </td>
						<td>Contacto cliente</td>
						<td><input type="text" name="contacto" value="${sa.getContacto()}"/> </td>
					</tr>
					<tr>
						<td>Lugar</td>
						<td colspan="3"><textarea rows = "3" cols = "80" name = "lugar" maxlength="1000"><c:out value="${sa.getLugar()}" /></textarea></td>	
					</tr>
					<tr>
						<td>Detalle</td>
						<td colspan="3"><textarea rows = "3" cols = "80" name = "detalle" maxlength="1000"><c:out value="${sa.getDetalle()}"/></textarea></td>	
					</tr>
					<tr>
						<td>Status</td>
						<td><input type="text" name="status" value="${sa.getStatus()}"/> </td>
					</tr>
				</thead>
			</table>
			<input type="submit" value="Guardar" class="btn btn-primary"/>
		</form>	
		
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
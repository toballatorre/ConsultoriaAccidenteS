<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ingresar Actividad - Vista Profesional</title>
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
	<h2>Revisar Actividad Mejora</h2>


	<table class="table table-striped table-hover">
		<tbody>
			<tr>
				<td>ID:</td>
				<td><input type="number" id="idAct" name="idAct"
					readonly="readonly" value="${act.getId()}"></td>
				<td>Titulo:</td>
				<td><input type="text" id="titulo" name="titulo"
						readonly="readonly" value="${act.getTitulo()}"></td>
				<td>Fecha Plazo:</td>
				<td><input type="date" id="fechaP" name="fechaP"
					readonly="readonly" value="${act.getFechaPlazo()}"></td>
			</tr>
			<tr>
				<td>Descripción:</td>
				<td colspan="5"><textarea rows="10" cols="80" id="descripcion"
						name="descripcion" readonly="readonly">${act.getDescripcion()}</textarea></td>
			</tr>
			<tr>
				<td>Comentario:</td>
				<td colspan="5"><textarea rows="10" cols="80" id="comentario"
							name="comentario" readonly="readonly">${act.getComentario()}</textarea></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td colspan="2">${act.getStatus()}</td>
				<td>Cliente:</td>
				<td colspan="2">${act.getIdCliente()}</td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/AreaProfesional">Volver</a></td>
			</tr>
		</tbody>
	</table>

	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
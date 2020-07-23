<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ingresar Actividad - Vista Administrador</title>
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
	<h2>Revisar Actividad Mejora</h2>


	<table class="table table-striped table-hover">
		<tbody>
			<tr>
				<td>ID:</td>
				<td><c:out value="${act.getId()}"/></td>
				<td>Titulo:</td>
				<td><c:out value="${act.getTitulo()}"/></td>
				<td>Fecha Plazo:</td>
				<td><c:out value="${act.getFechaPlazo()}"/></td>
			</tr>
			<tr>
				<td>Descripción:</td>
				<td colspan="5"><c:out value="${act.getDescripcion()}"/></td>
			</tr>
			<tr>
				<td>Comentario:</td>
				<td colspan="5"><c:out value="${act.getComentario()}"/></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td colspan="2"><c:out value="${act.getStatus()}"/></td>
				<td>Cliente:</td>
				<td colspan="2"><c:out value="${act.getIdCliente()}"/></td>
			</tr>
			<tr>
				<td colspan="6"><a href="${pageContext.request.contextPath}/AreaAdmin" class="btn btn-primary" role="button"><i class="fas fa-undo-alt"></i> Volver</a></td>
			</tr>
		</tbody>
	</table>

	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
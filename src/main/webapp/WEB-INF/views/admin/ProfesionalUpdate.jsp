<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar Profesional - Vista Administrador</title>
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
	<h2>Editar infomación del profesional</h2>
	
	
	<form action="ProfesionalUpdateSave" method="POST">
				<input type="hidden" name="id"  value="${p.getId()}" />
				<input type="hidden" name="idusuario"  value="${p.getIdusuario()}" />
				<table class="table table-striped table-hover">
					<tr>   
						<td>Nombre:</td>
						<td><input type="text" name="nombre" value="${p.getNombre()}"/></td>
					</tr>
					<tr>
						<td>Celular:</td>
						<td><input type="text" name="celular" value="${p.getCelular()}"/></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Editar Profesional" class="btn btn-danger"/> <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/Profesionales"><i class="fas fa-undo-alt"></i> Volver a listado de profesionales</a></td>
					</tr>
				</table>
			</form>
	
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
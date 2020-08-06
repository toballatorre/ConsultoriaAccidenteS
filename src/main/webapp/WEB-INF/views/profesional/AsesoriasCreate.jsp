<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ingresar Asesoria - Vista Profesional</title>
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
	<h2>Ingresar Asesoria</h2>
	
	<c:out value=""/>
	
	<form action="../saveAsesoria" method="post">
		<table class="table">
			
			<tr>
				<td>idCaso:</td>
				<td><input type="number" name="idcaso" value="${id}" readonly/></td>
			</tr>
			<tr>
				<td>Fecha:</td>
				<td><input type="datetime" name="fecha" /></td>
			</tr>
			<tr>
				<td>Id Empleado:</td>
				<td><input type="text" name="idempleado" /></td>
			</tr>
			<tr>
				<td>Lugar:</td>
				<td><textarea rows = "3" cols = "70" name = "lugar" maxlength="1000" ></textarea></td>
			</tr>
			<tr>
				<td>Comentarios:</td>
				<td><textarea rows = "3" cols = "70" name = "comentarios" maxlength="1000" ></textarea></td>
			</tr>
		</table>
		<input type="submit" value="Agregar" class="btn btn-danger"/> <a class="btn btn-primary" role="button" href="../leer/${id}"><i class="fas fa-undo-alt"></i> Volver</a>
	</form>
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
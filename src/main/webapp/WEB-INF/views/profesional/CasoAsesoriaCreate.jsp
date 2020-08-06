<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Crear Caso de Asesoria - Vista Profesional</title>
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
	<h2>Crear Caso Asesoria</h2>
	
	
	<form action="saveCaso" method="post">
		<table class="table">
			
			<tr>
				<td>idCliente:</td>
				<td><input type="number" name="idcliente" required/></td>
			</tr>
			<tr>
				<td>Codigo Contrato:</td>
				<td><input type="text" name="codcontrato" /></td>
			</tr>
			<tr>
				<td>Plan:</td>
				<td><input type="text" name="plan" /></td>
			</tr>
			<tr>
				<td>Persona Contacto:</td>
				<td><input type="text" name="contacto" /></td>
			</tr>
			<tr>
				<td>Activo:</td>
				<td><input type="text" name="activo" value="Si"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Agregar" class="btn btn-danger"/> <a class="btn btn-primary" role="button" href="leer"><i class="fas fa-undo-alt"></i> Volver</a></td>
			</tr>
						
		</table>
	</form>
			
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
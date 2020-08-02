<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Crear Checklist - Vista Profesional</title>
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
	<h2>Crear Checklist</h2>
	
	<form action="guardarChecklist" method="post">
			<table class="table">
				<tr>
					<td>Cliente:</td>
					<td><input type="number" name="idcliente" /></td>
				</tr>
				<tr>
					<td>Descripción:</td>
					<td><textarea rows = "3" cols = "70" name = "descripcion" maxlength="1000" ></textarea></td>
				</tr>
				<tr>
					<td>Pregunta 1:</td>
					<td><textarea rows = "2" cols = "70" name = "pregunta1" maxlength="1000"></textarea></td>
				</tr>
				<tr>
					<td>Pregunta 2:</td>
					<td><textarea rows = "2" cols = "70" name = "pregunta2" maxlength="1000"></textarea></td>
				</tr>
				<tr>
					<td>Pregunta 3:</td>
					<td><textarea rows = "2" cols = "70" name = "pregunta3" maxlength="1000"></textarea></td>
				</tr>
				<tr>
					<td>Pregunta 4:</td>
					<td><textarea rows = "2" cols = "70" name = "pregunta4" maxlength="1000"></textarea></td>
				</tr>
				<tr>
					<td>Pregunta 5:</td>
					<td><textarea rows = "2" cols = "70" name = "pregunta5" maxlength="1000"></textarea></td>
				</tr>
				<tr>
					<td>Pregunta 6:</td>
					<td><textarea rows = "2" cols = "70" name = "pregunta6" maxlength="1000"></textarea></td>
				</tr>
				<tr>
					<td>Pregunta 7:</td>
					<td><textarea rows = "2" cols = "70" name = "pregunta7" maxlength="1000"></textarea></td>
				</tr>
				<tr>
					<td>Pregunta 8:</td>
					<td><textarea rows = "2" cols = "70" name = "pregunta8" maxlength="1000"></textarea></td>
				</tr>
				<tr>
					<td>Pregunta 9:</td>
					<td><textarea rows = "2" cols = "70" name = "pregunta9" maxlength="1000"></textarea></td>
				</tr>
				<tr>
					<td>Pregunta 10:</td>
					<td><textarea rows = "2" cols = "70" name = "pregunta10" maxlength="1000"></textarea></td>
				</tr>
				<tr>
					<td>Comentarios:</td>
					<td><textarea rows = "6" cols = "70" name = "comentarioschk" maxlength="1000"></textarea></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="Agregar Checklist" class="btn btn-danger"/> <a class="btn btn-primary" role="button" href="listar"><i class="fas fa-undo-alt"></i> Volver</a></td>
				</tr>
			</table>
	</form>
	
	
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
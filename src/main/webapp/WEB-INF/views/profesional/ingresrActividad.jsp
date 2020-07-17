<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ingresar Actividad - Vista Profesional</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuProfesional.jsp" />
	<br><h1>Vista Profesional</h1>
	<h2>Ingresar Actividad Mejora</h2>
	
	
	<form action="ingresar" method="post">
			<table>
				<tbody>
					<tr>
						<!-- <td>ID: </td><td><input type="number" id="idAct" name="idAct"></td> -->
						<td></td><td></td>
						<td>Titulo: </td><td><input type="text" id="titulo" name="titulo"></td>
						<td>Fecha Plazo: </td><td><input type="date" id="fechaP" name="fechaP"></td>
					</tr>
					<tr>
						<td>Descripción: </td>
						<td colspan="5"><textarea rows="10" cols="80" id="descripcion" name="descripcion"></textarea></td>
					</tr>
					<tr>
						<td>Comentario: </td>
						<td colspan="5"><textarea rows="10" cols="80" id="comentario" name="comentario"></textarea></td>
					</tr>
					<tr>
						<td>Status: </td>
						<td><label for="penediente">Pendiente </label><input type="radio" name="status" value="Pendiente" id="pendiente"></td>
						<td><label for="realizado">Realizado </label><input type="radio" name="status" value="Realizado" id="realizado"></td>
						<td>Cliente: </td>
						<td colspan="2">
							<select name="cliente">
								<option value="1">Cliente 1</option>
								<option value="2">Cliente 2</option>
								<option value="3">Cliente 3</option>
								<option value="4">Cliente 4</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="6"><input type="submit" value="Ingresar"></td>
					</tr>
				</tbody>
			</table>
		</form>

	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
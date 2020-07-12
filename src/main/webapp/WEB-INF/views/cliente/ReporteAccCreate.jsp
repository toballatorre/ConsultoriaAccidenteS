<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Reporte Accidente</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuCliente.jsp" />
	<br><h1>Vista Cliente</h1>
	<h2>Crear Reporte Accidente</h2>
	
	<form action="ReporteAccCreate" method="POST">
			<table>
				<tr>
					<td>Tipo accidente</td>
					<td><input type="radio" id="Laboral" name="tipoAccidente" value="Laboral">
					<label for="tipoAccidente">Laboral</label>
					<input type="radio" id="Trayecto" name="tipoAccidente" value="Trayecto">
					<label for="tipoAccidente">Trayecto</label><br>
					</td>
				</tr>
				<tr>
					<td>Cantidad días perdidos</td>
					<td><input type="number" name="diasPerdidos" min="0" max="365" required></td>
				</tr>
				<tr>
					<td>Fecha del Accidente</td>	
					<td><input type="text" name="fechaAccidente" id="fecha" required ></td>
				</tr>
				<tr>
					<td>Dirección del lugar del accidente</td>
					<td><input type="text" name="lugarAccidente" required></td>
				</tr>
				<tr>
					<td>Descripción de los hechos:</td>
					<td><textarea name="descripcion" rows="10" cols="20"></textarea></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="number" name="idCliente" value="11111" hidden="true" required>
					<input type="submit" value="Registrar"></td>
				</tr>
			</table>
		</form>
		<a class="boton" href="ReporteAccidente"><i class="fas fa-undo-alt"></i> Volver</a>
	
	
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reporte Accidente</title>
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
		<jsp:include page="../MenuCliente.jsp" />
		<br>
		<h1>Vista Cliente</h1>
		<h2>Solicitar Asesoria Especial</h2>

		<form action="ingresarAsesoria" method="POST">
			<table class="table table-striped table-hover">
				<tr>
					<td>Preferencia Horario</td>
					<td><input type="radio" id="Mañana" name="preferenciaHorario"
						value="Mañana"> <label for="tipoAccidente">Mañana</label>
					</td>
					<td><input type="radio" id="Tarde" name="preferenciaHorario"
						value="Tarde"> <label for="tipoAccidente">Tarde</label><br>
					</td>
				</tr>
				<tr>
					<td>Fecha</td>
					<td colspan="2"><input type="text" name="fecha" id="fecha"	required></td>
				</tr>
				<tr>
					<td>Motivo</td>
					<td colspan="2"><input type="text" name="motivo" id="motivo" required></td>
				</tr>
				
				<tr>
					<td colspan="3">
					<input type="number" name="idCliente" value="1" hidden="true" required> 
						<input type="submit" value="Registrar">
					</td>
				</tr>
			</table>
		</form>
		<a class="boton" href="SolicitudAsesoria"><i class="fas fa-undo-alt"></i> Volver</a>



	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
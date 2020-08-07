<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Solicitud Asesoria</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
	<!-- JQuery Styles -->
	<link rel="stylesheet" href="<c:url value="/resources/js/jquery_ui/jquery-ui.css"></c:url>">
	<link rel="stylesheet" href="<c:url value="/resources/js/jquery_ui/jquery-ui.structure.css"></c:url>">
	<link rel="stylesheet" href="<c:url value="/resources/js/jquery_ui/jquery-ui.theme.css"></c:url>">
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
					<fmt:formatDate value="${date}" pattern="dd/MM/yyyy" var="fecha"/>
					<td>Fecha:</td>
					<td colspan="2"><input type="datetime" name="fechasolicitud" id="fecha"	required value="${fecha}"></td>
				</tr>
				<tr>
					<td>Motivo:</td>
					<td colspan="2"><textarea rows = "6" cols = "70" name = "motivo" id="motivo" required maxlength="1000"></textarea>
					<input type="hidden" name="status" value="Pendiente">
					
					</td>
				</tr>
				
				<tr>
					<td colspan="3" align="center">
					<input type="number" name="idCliente" value="${idcliente}" hidden="true"> 
						<input type="submit" value="Registrar">
					</td>
				</tr>
			</table>
		</form>
		<a class="btn btn-primary" role="button" href="SolicitudAsesoria"><i class="fas fa-undo-alt"></i> Volver</a>



	</div>
	<jsp:include page="../footer.jsp" />
	<!-- JQuery Date Picker -->
	<script type="text/javascript" src="<c:url value="/resources/js/jquery_ui/external/jquery/jquery.js"></c:url>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery_ui/jquery-ui.js"></c:url>"></script>
	
	
	<script type="text/javascript">
	$( function() {
	    $( "#fecha" ).datepicker({
	    	dateFormat: 'dd/mm/yy'
	    });
	  } );
	</script>
</body>
</html>
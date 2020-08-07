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
	<!-- JQuery Styles -->
	<link rel="stylesheet" href="<c:url value="/resources/js/jquery_ui/jquery-ui.css"></c:url>">
	<link rel="stylesheet" href="<c:url value="/resources/js/jquery_ui/jquery-ui.structure.css"></c:url>">
	<link rel="stylesheet" href="<c:url value="/resources/js/jquery_ui/jquery-ui.theme.css"></c:url>">
	
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuProfesional.jsp" />
	<br><h1>Vista Profesional</h1>
	<h2>Ingresar Actividad Mejora</h2>
	
	
	<form action="ingresar" method="post">
			<table class="table table-striped table-hover">
				<tbody>
					<tr>
						<!-- <td>ID: </td><td><input type="number" id="idAct" name="idAct"></td> -->
						<td></td><td></td>
						<td>Titulo: </td><td><input type="text" id="titulo" name="titulo"></td>
						<td>Fecha Plazo: </td><td><input type="text" id="fechaP" name="fechaP" readonly="readonly"></td>
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
							<c:forEach items="${listaCliente}" var="cliente">
								<option value="${cliente.getId()}"> <c:out value="${cliente.getNombreEmpresa()}"/> </option>							
							</c:forEach>
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
	
	<!-- JQuery Date Picker -->
	<script type="text/javascript" src="<c:url value="/resources/js/jquery_ui/external/jquery/jquery.js"></c:url>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery_ui/jquery-ui.js"></c:url>"></script>
	
	<script type="text/javascript">
	$( function() {
	    $( "#fechaP" ).datepicker({
	    	dateFormat: 'dd/mm/yy'
	    });
	  } );
	</script>
</body>
</html>
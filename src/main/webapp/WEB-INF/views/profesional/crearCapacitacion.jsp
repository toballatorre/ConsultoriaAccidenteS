<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> - Vista Profesional</title>
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
	<h2>Caso de uso</h2>
		<fmt:formatDate value="${date}" pattern="dd/MM/yyyy" var="fecha"/>
		<form action="ingresar" method="post">
			<table class="table table-striped table-hover">
				<tbody>
					<tr>
<!-- 						<td>ID: </td><td><input type="number" id="idCap" name="idCap"></td> -->
						<td>Fecha: </td><td><input type="text" id="fecha" name="fecha" value="${fecha}" readonly="readonly"></td>						
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>Tema: </td><td><input type="text" id="tema" name="tema"></td>
						<td>Cliente: </td>
						<td>
							<select id="client" name="idCliente">
								<c:forEach items="${model.listaClientes}" var="cliente">
									<option value="${cliente.getId()}"> <c:out value="${cliente.getNombreEmpresa()}"/> </option>									
								</c:forEach>
							</select>
						</td>						
					</tr>
					<tr>
						<td>Objetivos: </td><td colspan="3"><textarea rows="10" cols="80" id="objetivos" name="objetivos"></textarea></td>
					</tr>
					<tr>
						<td>Contenidos: </td><td colspan="3"><textarea rows="10" cols="80" id="contenidos" name="contenidos"></textarea></td>
					</tr>
					<tr>
						<td>Recursos: </td><td colspan="3"><textarea rows="10" cols="80" id="recursos" name="recursos"></textarea></td>
					</tr>
					<tr>
						<td>ID Profesional: </td>
						<td>
							<select id="idProf" name="idUsuarioPro">
								<c:forEach items="${model.listaProf}" var="prof">
									<option value="${prof.getId()}"> <c:out value="${prof.getNombre()}"/> </option>
								</c:forEach>
							</select>
						</td>
<!-- 						<td><input type="number" id="idProf" name="idProf"></td> -->
						<td colspan="2"><input type="submit" value="Ingresar"></td>
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
	    $( "#fecha" ).datepicker({
	    	dateFormat: 'dd/mm/yy'
	    });
	  } );
	</script>
</body>
</html>
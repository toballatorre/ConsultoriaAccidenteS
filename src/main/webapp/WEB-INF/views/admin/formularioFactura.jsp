<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Formulario Factura - Vista Administrador</title>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>"><link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
	<!-- JQuery Styles -->
	<link rel="stylesheet" href="<c:url value="/resources/js/jquery_ui/jquery-ui.css"></c:url>">
	<link rel="stylesheet" href="<c:url value="/resources/js/jquery_ui/jquery-ui.structure.css"></c:url>">
	<link rel="stylesheet" href="<c:url value="/resources/js/jquery_ui/jquery-ui.theme.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuAdmin.jsp" />
	<br><h1>Vista Administrador</h1>
	<h2>Formulario Crear Factura</h2>
	
	<fmt:formatDate value="${date}" pattern="dd/MM/yyyy" var="fecha"/>
	
	<form action="formularioFactura" method="POST">
		<table>
			<tbody>
				<tr>
				
					<td><strong>Fecha Emision</strong><td>
					<td> <input type="text" value="${fecha}" id="fechaEmision" name="fechaEmision" readonly="readonly"> </td>
				</tr>
				<tr>
					<td><strong>Fecha Vencimiento</strong><td>
					<td> <input type="text" value="${fecha}" id="fechaVencimiento" name="fechaVencimiento" readonly="readonly"> </td>
				</tr>
				<tr>
					<td><strong>Cliente</strong><td>
					<td> 
						<select name="idCliente">
							<c:forEach items="${model.listaC}" var="c">
								<option value="<c:out value="${c.getId()}"/>"> <c:out value="${c.getNombreEmpresa()} / ${c.getId()}"/> </option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="ingresar">
	</form>
		
	</div>
	<jsp:include page="../footer.jsp" />
	<!-- JQuery Date Picker -->
	<script type="text/javascript" src="<c:url value="/resources/js/jquery_ui/external/jquery/jquery.js"></c:url>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery_ui/jquery-ui.js"></c:url>"></script>
	
	<script type="text/javascript">
	$( function() {
	    $( "#fechaEmision" ).datepicker({
	    	dateFormat: 'dd/mm/yy'
	    });
	    $( "#fechaVencimiento" ).datepicker({
	    	dateFormat: 'dd/mm/yy'
	    });
	  } );
	</script>
</body>
</html>
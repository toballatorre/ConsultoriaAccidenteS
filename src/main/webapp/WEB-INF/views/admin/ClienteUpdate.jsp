<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar Cliente - Vista Administrador</title>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuAdmin.jsp" />
	<br><h1>Vista Administrador</h1>
	<h2>Editar información del cliente</h2>
	
	
	<form action="ClienteUpdateSave" method="post">
			<input type="hidden" name="idcliente"  value="${cliente.getId()}" />
			<input type="hidden" name="idusuario"  value="${cliente.getIdUsuario()}" />
			<table class="table table-striped table-hover">
					<tr>
					<td>Nombre Empresa:</td>
					<td><input type="text" name="nombreempresa" value="${cliente.getNombreEmpresa()}"/></td>
				</tr>
				<tr>
					<td>RUT:</td>
					<td><input type="text" name="rutempresa" value="${cliente.getRutEmpresa()}"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Editar cliente" /></td>
				</tr>
			</table>
		</form>
	
	
	
	<a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/Clientes"><i class="fas fa-undo-alt"></i> Volver a listado de clientes</a>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
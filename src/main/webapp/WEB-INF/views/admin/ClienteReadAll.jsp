<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Clientes</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuAdmin.jsp" />
	<br><h1>Vista Administrador</h1>
	<h2>Listado de clientes</h2>
	
	<table>
				<tr>
					<th>ID</th>
					<th>Nombre Empresa</th>
					<th>Información</th>
					<th>Accidentabilidad</th>
					
				</tr>
		
					<tr>
						<td>1</td>
						<td>Empresas Calipso</td>
						<td><a href="ClientesEditar?idcliente=11111"><i class="fab fa-wpforms"></i></a></td>
						<td><a href="Accidentabilidad"><i class="fas fa-user-injured"></i></a></td>
					</tr>
				
		
			</table>
	
	
	
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
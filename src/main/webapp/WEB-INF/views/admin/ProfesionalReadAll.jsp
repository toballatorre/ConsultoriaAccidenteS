<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> - Vista Administrador</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuAdmin.jsp" />
	<br><h1>Vista Administrador</h1>
	<h2>Ver Profesionales</h2>
	
	
			<table>
			<tr>
				<th>IdEmpleado</th>
				<th>Nombre</th>
				<th>IdUsuario</th>
				<th>Celular</th>
				<th>Editar</th>
			</tr>
	
			<tr>
				<td>88</td>
				<td>Juanito Falso</td>
				<td>99</td>
				<td>+56962527069</td>
				<td><a href="ProfesionalUpdate"><i class="far fa-edit"></i></a></td>
			</tr>
			<tr>
				<td>33</td>
				<td>Juanita Falsa</td>
				<td>449</td>
				<td>+56962527070</td>
				<td><a href="ProfesionalUpdate"><i class="far fa-edit"></i></a></td>
			</tr>
			
	
		</table>
	
	
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
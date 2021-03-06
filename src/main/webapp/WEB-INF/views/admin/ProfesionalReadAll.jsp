<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ver Profesionales - Vista Administrador</title>
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
	<h2>Ver Profesionales</h2>
	
	<table class="table table-striped table-hover">
		<thead class="thead-light">
			<tr>
				<th>IdEmpleado</th>
				<th>Nombre</th>
				<th>IdUsuario</th>
				<th>Celular</th>
				<th>Editar</th>
			</tr>
		</thead>
		<c:forEach items="${listaProf}" var="prof">
			<tr>
				<td><c:out value="${prof.getId()}"/></td>
				<td><c:out value="${prof.getNombre()}"/></td>
				<td><c:out value="${prof.getIdusuario()}"/></td>
				<td><c:out value="${prof.getCelular()}"/></td>
				<td><a href="ProfesionalUpdate/${prof.getId()}"><i class="far fa-edit"></i></a></td>
			</tr>
		</c:forEach>
				
	
		</table>
	
	
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
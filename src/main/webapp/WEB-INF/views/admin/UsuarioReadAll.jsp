<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Usuarios</title>
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
	<h2>Ver Usuarios</h2>
	
	<table class="table table-striped table-hover">
		<thead class="thead-light">
			<tr>
				<th scope="col">ID</th>
				<th>Usuario</th>
				<th>TipoUsuario</th>
				<th>Clave</th>
				<th>Mail</th>
				<th>Activo</th>
				<th>Editar</th>
			</tr>
		</thead>
		<c:forEach items="${listaUsers}" var="user">
			<tr>
				<td><c:out value="${user.getId()}"/></td>
				<td><c:out value="${user.getUsuario()}"/></td>
				<td><c:out value="${user.getTipousuario()}"/></td>
				<td><c:out value="${user.getClave()}"/></td>
				<td><c:out value="${user.getMail()}"/></td>
				<td><c:out value="${user.getActivo()}"/></td>
				<td>
					<a href="UsuarioUpdate/${user.getId()}"><i class="far fa-edit"></i></a>
				</td>
			</tr>
		</c:forEach>
	
		</table>
	
		<a href="UsuarioCreate" class="btn btn-primary" role="button"><i class="far fa-plus-square"></i> Crear Usuario</a>
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
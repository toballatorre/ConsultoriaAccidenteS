<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Usuarios</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuAdmin.jsp" />
	<br><h1>Vista Administrador</h1>
	<h2>Ver Usuarios</h2>
	
	<table>
			<tr>
				<th>ID</th>
				<th>Usuario</th>
				<th>TipoUsuario</th>
				<th>Clave</th>
				<th>Mail</th>
				<th>Activo</th>
				<th>Editar</th>
			</tr>
	
			<tr>
				<td>1</td>
				<td>admin1</td>
				<td>admin</td>
				<td>123</td>
				<td>admin1@consultoria.cl</td>
				<td>1</td>
				<td>
					<a href="UsuarioUpdate"><i class="far fa-edit"></i></a>
				</td>
			</tr>
			<tr>
				<td>1</td>
				<td>admin1</td>
				<td>admin</td>
				<td>123</td>
				<td>admin1@consultoria.cl</td>
				<td>1</td>
				<td>
					<a href="UsuarioUpdate"><i class="far fa-edit"></i></a>
				</td>
			</tr>
	
		</table>
	
		<a href="UsuarioCreate" class="btn btn-primary" role="button"><i class="far fa-plus-square"></i> Crear Usuario</a>
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Crear Usuario - Vista Administrador</title>
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
	<h2>Crear Usuario</h2>
	
	<form action="UsuarioCreateSave" method="post">
			<table class="table">
				<tr>
					<td>Usuario:</td>
					<td><input type="text" name="txtusuario" /></td>
				</tr>
				<tr>
					<td>Tipo Usuario:</td>
					<td><input type="radio" id="admin" name="txttipouser" value="admin" checked><label for="admin">Admin</label><br>
						<input type="radio" id="pro" name="txttipouser" value="profesional"><label for="pro">Profesional</label><br>
						<input type="radio" id="cliente" name="txttipouser" value="cliente"><label for="cliente">Cliente</label></td>
				</tr>
				<tr>
					<td>Clave:</td>
					<td><input type="password" name="txtclave" /></td>
				</tr>
				<tr>
					<td>Mail:</td>
					<td><input type="email" name="txtmail" /></td>
				</tr>
				<tr>
					<td>Activo:</td>
					<td><input type="radio" id="si" name="txtactivo" value="1" checked><label for="si">Si</label><br>
						<input type="radio" id="no" name="txtactivo" value="0"><label for="no">No</label></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Agregar usuario" class="btn btn-danger"/> <a class="btn btn-primary" role="button" href="Usuarios"><i class="fas fa-undo-alt"></i> Volver</a></td>
				</tr>
			</table>
		</form>
	
	
	
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
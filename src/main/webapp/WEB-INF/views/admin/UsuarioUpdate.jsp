<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar Usuario - Vista Administrador</title>
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
	<h2>Editar Usuario</h2>
	
	<form action="UsuarioUpdateSave" method="post">
				<input type="hidden" name="idusuario"  value="${usuario.getId()}" />
				<table class="table">
					<tr>
						<td>Usuario:</td>
						<td><input type="text" name="txtusuario" value="${usuario.getUsuario()}"/></td>
					</tr>
					<tr>
						<td>Tipo Usuario:</td>
						<td>
							<input type="text" name="txttipousuario" value="${usuario.getTipousuario()}"/>
						</td>
					</tr>
					<tr>
						<td>Clave:</td>
						<td><input type="password" name="txtclave" value="${usuario.getClave()}"/></td>
					</tr>
					<tr>
						<td>Mail:</td>
						<td><input type="email" name="txtmail" value="${usuario.getMail()}"/></td>
					</tr>
					<tr>
						<td>Activo:</td>
						<td>
						<input type="text" name="txtactivo" value="${usuario.getActivo()}"/>
						</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Editar usuario"  class="btn btn-danger"/> <a href="${pageContext.request.contextPath}/Usuarios" class="btn btn-primary" role="button"><i class="fas fa-undo-alt"></i> Volver</a></td>
					</tr>
				</table>
			</form>
	
	
	
	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
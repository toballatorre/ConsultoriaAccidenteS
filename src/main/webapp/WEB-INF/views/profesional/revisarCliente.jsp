<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuProfesional.jsp" />
	<br><h1>Vista Profesional</h1>
	<h2>Caso de uso</h2>
	
	
	<table class="table table-striped table-hover">
		<tr>
			<th>Cliente: </th>
			<td> ${m.c.getId()} ${m.c.getNombreEmpresa()} </td>
		</tr>
		<tr>
			<th>RUT: </th>
			<td> ${m.c.getRutEmpresa()} </td>
		</tr>
	</table>	
	
	<table class="table table-striped table-hover">
		<tr>
			<th> Usuario: </th>
			<td> ${m.u.getUsuario()} </td>
		</tr>
		<tr>
			<th> Mail: </th>
			<td> ${m.u.getMail()} </td>
		</tr>
		<tr>
			<th> Activo: </th>
			<td>  
				<c:choose>
					<c:when test="${m.u.getActivo() == 1}">
						Activo
					</c:when>
					<c:otherwise>
						Inactivo
					</c:otherwise>
				</c:choose>		
			</td>
		</tr>
	</table>
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> - Vista Profesional</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuProfesional.jsp" />
	<br><h1>Vista Profesional</h1>
	<h2>Caso de uso</h2>
	
		<form action="detalle" method="post">
			<table>
				<tbody>
					<tr>
						<td>ID: </td><td><input type="number" id="idCap" name="idCap"></td>
						<td>Fecha: </td><td><input type="date" id="fecha" name="fecha"></td>						
					</tr>
					<tr>
						<td>Tema: </td><td><input type="text" id="tema" name="tema"></td>						
						<td>Cliente: </td><td><input type="text" id="client" name="client"></td>
					</tr>
					<tr>
						<td>Objetivos: </td><td colspan="3"><textarea rows="10" cols="20" id="objetivos" name="objetivos"></textarea></td>
					</tr>
					<tr>
						<td>Contenidos: </td><td colspan="3"><textarea rows="10" cols="20" id="contenidos" name="contenidos"></textarea></td>
					</tr>
					<tr>
						<td>Recursos: </td><td colspan="3"><textarea rows="10" cols="20" id="recursos" name="recursos"></textarea></td>
					</tr>
					<tr>
						<td>ID Profesional: </td><td><input type="number" id="idProf" name="idProf"></td>
						<td colspan="2"><input type="submit" value="Ingresar"></td>
					</tr>
				</tbody>
			</table>
		</form>
		
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
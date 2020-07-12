<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Detalle Capacitacion <c:out value="${id}"/> </title>
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="contenido">
		<h1>Detalle Capacitacion <c:out value="${id}"/></h1>
		<table>
			<thead>
				<tr>
					<th colspan="4">Detalle Capacitacion <c:out value="${id}"/></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Cliente</td>
					<td><c:out value="${idCliente}"/></td>
					<td>Fecha</td>
					<td><c:out value="${fecha}"/></td>
				</tr>
				<tr>
					<td>Tema</td>
					<td colspan="3"><c:out value="${tema}"/></td>
				</tr>
				<tr>
					<td>Objetivos</td>
					<td colspan="3"><c:out value="${objetivos}"/></td>
				</tr>
				<tr>
					<td>Contenidos</td>
					<td colspan="3"><c:out value="${contenidos}"/></td>
				</tr>
				<tr>
					<td>Recursos</td>
					<td><c:out value="${recursos}"/></td>
					<td>Encargado</td>
					<td><c:out value="${idUsuarioPro}"/></td>
				</tr>
			</tbody>
		</table>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
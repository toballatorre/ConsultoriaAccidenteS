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
	<h2>Visualizar Actividades</h2>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Titulo</th>
				<th>Fecha Plazo</th>
				<th>Status</th>
				<th>Cliente</th>
			</tr>
			<c:forEach items="${listaAct}" var="act">
				<tr>
					<td> <c:out value="${act.getId()}"/> </td>
					<td> <c:out value="${act.getTitulo()}"/> </td>
					<td> <c:out value="${act.getFechaPlazo()}"/> </td>
					<td> <c:out value="${act.getStatus()}"/> </td>
					<td> <c:out value="${act.getIdCliente()}"/> </td>
				</tr>
			</c:forEach>
		</thead>
	</table>		
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ver Actividades - Vista Administrador</title>
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
	<h2>Visualizar Actividades</h2>
	
	<table class="table table-striped table-hover">
		<thead class="thead-light">
			<tr>
				<th>ID</th>
				<th>Titulo</th>
				<th>Fecha Plazo</th>
				<th>Status</th>
				<th>Cliente</th>
			</tr>
		</thead>
			<c:forEach items="${listaAct}" var="act">
				<tr>
					<td> <c:out value="${act.getId()}"/> </td>
					<td> <c:out value="${act.getTitulo()}"/> </td>
					<td> <c:out value="${act.getFechaPlazo()}"/> </td>
					<td> <c:out value="${act.getStatus()}"/> </td>
					<td> <c:out value="${act.getIdCliente()}"/> </td>
					<td> <a href="${pageContext.request.contextPath}/actividad/detalle/${act.getId()}">Detalle</a> </td>
				</tr>
			</c:forEach>
	</table>		
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
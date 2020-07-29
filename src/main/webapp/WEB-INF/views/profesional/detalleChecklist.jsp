<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle Checklist <c:out value="${model.ch.getId()}" /> -
	Vista Profesional
</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
		<jsp:include page="../MenuProfesional.jsp" />
		<br>
		<h1>Vista Profesional</h1>
		<h2>
			Detalle Checklist
			<c:out value="${modelo.ch.getId()}" />
		</h2>

		<table class="table table-striped table-hover">
			<thead class="thead-light">
				<tr>
					<th>Id: <c:out value="${modelo.ch.getId()}"/> </th>
					<th>Cliente: <c:out value="${model.ch.getIdCliente()}"/></th>
					<th><c:out value="${modelo.ch.getDescripcion()}" /></th>
					<th><c:out value="${modelo.ch.getStatus()}" /></th>
				</tr>
			</thead>
		</table>
		<table class="table table-striped table-hover">
			
			<thead class="thead-light">
				<tr>
					<th colspan="4">Preguntas</th>
				</tr>
				<tr>
					<th>#</th>
					<th>Pregunta</th>
					<th>Respuesta</th>
					<th>Comentarios</th>
				<tr>
			</thead>
			<tbody>
				<c:forEach items="${model.listaP}" var="p">
					<c:if test="${p.getIdChecklist() == model.ch.getId()}">
						<tr>
							<td> <c:out value="${p.getId()}"/> </td>
							<td> <c:out value="${p.getPregunta()}"/> </td>
							<td> <c:out value="${p.getRespuesta()}"/> </td>
							<td> <c:out value="${p.getComentarios()}"/> </td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
			
		</table>





	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
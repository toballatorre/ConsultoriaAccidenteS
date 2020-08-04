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
			<c:out value="${ch.getId()}" />
		</h2>
		<form action="../updateChecklist" method="post">
			<table class="table table-striped table-hover">
				<thead class="thead-light">
					<tr>
						<th colspan="7">Checklist</th>
					</tr>
					<tr>
						<th>Id: </th>
						<th><input type="number" name="chid" value="${ch.getId()}" readonly/> </th>
						<th>Cliente:</th>
						<th><input type="number" name="chidclinete"  value="${ch.getIdCliente()}"/></th>

					</tr>
					<tr>
						<th>Descripción:</th>
						<th colspan="3"><textarea rows = "3" cols = "70" name = "chdescripcion" maxlength="1000"><c:out value="${ch.getDescripcion()}"/></textarea></th>
					</tr>
					<tr>
						<th>Comentarios:</th>
						<th colspan="3"><textarea rows = "3" cols = "70" name = "chcomentarios" maxlength="1000"><c:out value="${ch.getComentarios()}"/></textarea></th>
					</tr>
					<tr>
						<th>Status:</th>
						<th><input type="text" name="chstatus" value="${ch.getStatus()}"></th>
						<th colspan="2"><input type="submit" value="Actualizar checklist" class="btn btn-danger"/></th>
					</tr>
				
				
				</thead>
			</table>
		</form>	
		
		
				
		<table class="table table-striped table-hover">
			<thead class="thead-light">
				<tr>
					<th colspan="5">Preguntas</th>
				</tr>
				<tr>
					<th>#</th>
					<th>Pregunta</th>
					<th>Respuesta</th>
					<th>Comentarios</th>
					<th>Editar</th>
					
				<tr>
			</thead>
			<tbody>
				<c:forEach items="${ch.getListaP()}" var="p">
						<tr>
							<td> <c:out value="${p.getId()}"/> </td>
							<td> <c:out value="${p.getPregunta()}"/> </td>
							<td> <c:out value="${p.getRespuesta()}"/> </td>
							<td> <c:out value="${p.getComentarios()}"/> </td>
							<td>
							<a href="${pageContext.request.contextPath}/checklist/responderPregunta/${p.getId()}"><i class="far fa-eye"></i></a>
							</td>
						</tr>
				</c:forEach>
			</tbody>
			
		</table>


<a href="${pageContext.request.contextPath}/checklist/crearPregunta/${ch.getId()}" class="btn btn-primary" role="button"><i class="far fa-plus-square"></i> Agregar pregunta</a>
	


	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
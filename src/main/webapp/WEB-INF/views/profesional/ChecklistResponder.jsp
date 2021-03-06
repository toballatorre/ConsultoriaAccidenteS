<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Responder Checklist <c:out value="${model.ch.getId()}" /> -
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
			Responder Pregunta
			<c:out value="${preg.getId()}" />
		</h2>

		<form action="../updatePregunta" method="post">
			<table class="table">
				<tr>
					<td>Checklist:</td>
					<td><input type="text" name="idchecklist" value="${preg.getChecklist().getId()}"/>
						<input type="hidden" name="idpregunta" value="${preg.getId()}">
					</td>
					<td>Pregunta:</td>
					<td><textarea rows = "3" cols = "70" name = "pregunta" maxlength="1000" ><c:out value="${preg.getPregunta()}"/></textarea></td>
				</tr>
				<tr>
					<td>Respuesta:</td>
					<td><input type="text" name="respuesta" value="${preg.getRespuesta()}"/></td>
					<td>Comentario:</td>
					<td><textarea rows = "3" cols = "70" name = "comentario" maxlength="1000" ><c:out value="${preg.getComentarios()}"/></textarea></td>		
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="Guardar" class="btn btn-danger"/> <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/checklist/detalle/${preg.getChecklist().getId()}"><i class="fas fa-undo-alt"></i> Volver</a></td>
				</tr>
			</table>
		</form>


	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
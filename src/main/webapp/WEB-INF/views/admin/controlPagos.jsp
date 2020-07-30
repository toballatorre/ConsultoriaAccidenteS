<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Controlar Pagos - Vista Administrador</title>
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
	<h2>Control de Pagos</h2>
	
	<table class="table table-striped table-hover">
		<thead class="thead-light">
			<tr>
				<th>Nº Factura</th>
				<th>Cliente</th>
				<th>Fecha Emisión</th>
				<th>Fecha Vencimiento</th>
				<th>Fecha Pago</th>
				<th>Estado</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaFacturas}" var="factura">
				<tr>
					<td> <c:out value="${factura.getIdFactura()}"/> </td>
					<td> <c:out value="${factura.getCliente_idCliente()}"/> </td>
					<td> <c:out value="${factura.getFechaEmision()}"/> </td>
					<td> <c:out value="${factura.getFechaVencimiento()}"/> </td>
					<td> <c:out value="${factura.getFechaPago()}"/> </td>
					<c:choose>
						<c:when test="${factura.getFechaPago() == null}">
							<td> SIN PAGAR </td>
						</c:when>
						<c:otherwise>
							<td> PAGADO </td>
						</c:otherwise>
					</c:choose>
					<td> <a href="${pageContext.request.contextPath}/factura/detalle/${factura.getIdFactura()}">Detalle</a> </td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7"> <a href="../AreaAdmin">Volver</a> </td>			
			</tr>
		</tbody>
		
	</table>	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
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
	<h2>Control de Pagos</h2>
	
	<table>
		<thead>
			<tr>
				<th>Nº Factura</th>
				<th>Cliente</th>
				<th>Fecha Emisión</th>
				<th>Fecha Vencimiento</th>
				<th>Fecha Pago</th>
				<th>Estado</th>
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
						<c:when test="${factura.getFechaPago() == ''}">
							<td> SIN PAGAR </td>
						</c:when>
						<c:otherwise>
							<td> PAGADO </td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6"> <a href="../AreaAdmin">Volver</a> </td>			
			</tr>
		</tbody>
		
	</table>	
	
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
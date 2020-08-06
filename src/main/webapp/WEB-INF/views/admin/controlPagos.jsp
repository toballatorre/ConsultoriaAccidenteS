<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<a class="btn btn-outline-info" href="${pageContext.request.contextPath}/factura/formularioFactura">Crear nueva Factura</a>
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
					<td> <c:out value="${factura.getidCliente()}"/> </td>
					<td>
						<fmt:formatDate value="${factura.getFechaEmision()}" pattern="dd/MM/yyyy" var="fechaE"/> 
						<c:out value="${fechaE}"/>
					</td>
					<td>
						<fmt:formatDate value="${factura.getFechaVencimiento()}" pattern="dd/MM/yyyy" var="fechaV"/>
						<c:out value="${fechaV}"/>
					</td>
					<td>
						<fmt:formatDate value="${factura.getFechaPago()}" pattern="dd/MM/yyyy" var="fechaP"/>
						<c:choose>
							<c:when test="${factura.getFechaPago() == null}">
								<form action="fechaPago" method="POST">
									<input type="date" name="fPago"> 
									<input type="submit" value="Actualizar">
									<input type="hidden" value="${factura.getIdFactura()}" name="idFactura">
								</form>
							</c:when>
							<c:otherwise>
								<c:out value="${fechaP}"/>
							</c:otherwise>
						</c:choose>
					</td>
					<c:choose>
						<c:when test="${f.getFechaPago() == null}">
							<c:choose>
								<c:when test="${date.compareTo(f.getFechaVencimiento()) > 0 }">
									<td> Atrasado </td>
								</c:when>
								<c:otherwise>
									<td> Sin Pagar </td>							
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<td> Pagado </td>
						</c:otherwise>
					</c:choose>
					<td> <a href="${pageContext.request.contextPath}/factura/detalle/${factura.getIdFactura()}">Detalle</a> | <a href="${pageContext.request.contextPath}/factura/eliminar/${factura.getIdFactura()}">Eliminar</a> </td>
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
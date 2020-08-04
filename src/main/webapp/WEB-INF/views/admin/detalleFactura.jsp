<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>- Vista Administrador</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<c:url value="/resources/css/estilo.css"></c:url>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
		<jsp:include page="../MenuAdmin.jsp" />
		<br>
		<h1>Vista Administrador</h1>
		<h2>Detalle Factura Nº ${f.getIdFactura()}</h2>
		<table class="table table-striped table-hover">
			<thead class="thead-light">
				<tr>
					<th>Cliente: ${f.getidCliente()}</th>
					<th>Fecha Emision: ${f.getFechaEmision()}</th>
					<th>Fecha Vencimiento: ${f.getFechaVencimiento()}</th>
					<th>Fecha Pago: ${f.getFechaPago()}</th>
				</tr>
			</thead>
		</table>
		<table class="table table-striped table-hover">
			<thead class="thead-light">
				<tr>
					<th colspan="6">Detalle</th>
				</tr>
				<tr>
					<th>#</th>
					<th>Concepto</th>
					<th>Precio Unitario</th>
					<th>Cantidad</th>
					<th>SubTotal</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${f.getListaItem()}" var="i">
					<tr>
						<td> ${i.getIdItem()} </td>
						<td> ${i.getConcepto()} </td>
						<td> ${i.getPrecioUnitario()} </td>
						<td> ${i.getCantidad()} </td>
						<td> ${f.subTotales(i)} </td>
						<td> ${f.Totales(i)} </td>
					</tr>
				</c:forEach>
					<tr>
						<td colspan="4"></td>
						<td> ${f.subTotales()} </td>
						<td> ${f.Totales()} </td>
					</tr>
			</tbody>
		</table>





	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
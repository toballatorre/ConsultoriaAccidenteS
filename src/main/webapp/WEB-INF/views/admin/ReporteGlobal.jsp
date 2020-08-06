<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Reporte Cliente - Vista Administrador</title>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>"><link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="contenido">
	<jsp:include page="../MenuAdmin.jsp" />
	<br><h1>Vista Administrador</h1>
	<h2>Reporte Global</h2>
	
	<c:forEach items="${listaC}" var="c">
			<section>
				<hr>
				<!-- CABECERA CLIENTE -->
				<table class="table table-striped table-hover">
					<thead class="thead-light">
						<tr>
							<th>Cliente: #<c:out value="${c.getId()}" /> <c:out
									value="${c.getNombreEmpresa()}" />
							</th>
							<th>RUT: <c:out value="${c.getRutEmpresa()}" />
							</th>
						</tr>
					</thead>
				</table>
				<!-- Reportes de Accidentes -->
				<table class="table table-striped table-hover">
					<thead class="thead-light">
						<tr>
							<th colspan="6">REPORTES DE ACCIDENTES</th>
						</tr>
						<tr>
							<th>#</th>
							<th>Tipo Accidente</th>
							<th>Días Perdidos</th>
							<th>Fecha Accidente</th>
							<th>Lugar Accidente</th>
							<th>Descripción</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${c.getListaAccidentes()}" var="a">
							<tr>
								<td><c:out value="${a.getId()}" /></td>
								<td><c:out value="${a.getTipoAccidente()}" /></td>
								<td><c:out value="${a.getDiasPerdidos()}" /></td>
								<td><c:out value="${a.getFechaAccidente()}" /></td>
								<td><c:out value="${a.getLugarAccidente()}" /></td>
								<td><c:out value="${a.getDescripcion()}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- ASESORIAS ESPECIALES -->
				<table class="table table-striped table-hover">
					<thead class="thead-light">
						<tr>
							<th colspan="6">REPORTE DE ASESORIAS ESPECIALES</th>
						</tr>
						<tr>
							<th>#</th>
							<th>Fecha Solicitud</th>
							<th>Motivo</th>
							<th>Horario</th>
							<th>Fecha Agendada</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${c.getListaAsesoriaE()}" var="ae">
							<tr>
								<td><c:out value="${ae.getId() }" /></td>
								<fmt:formatDate value="${ae.getFechasolicitud() }"
									pattern="dd/MM/yyyy" var="fechaSol" />
								<td><c:out value="${fechaSol}" /></td>
								<td><c:out value="${ae.getMotivo() }" /></td>
								<td><c:out value="${ae.getPreferenciaHorario() }" /></td>
								<fmt:formatDate value="${ae.getFechaagenda() }"
									pattern="dd/MM/yyyy" var="fechaAg" />
								<td><c:out value="${fechaAg}" /></td>
								<td><c:out value="${ae.getStatus() }" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- FACTURAS -->
				<table class="table table-striped table-hover">
					<thead class="thead-light">
						<tr>
							<th colspan="5">REPORTE FACTURA</th>
						</tr>
						<tr>
							<th>#</th>
							<th>Fecha Emision</th>
							<th>Fecha Vencimiento</th>
							<th>Fecha Pago</th>
							<th>Estado</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${c.getListaFacturas()}" var="f">
							<tr>
								<td><c:out value="${f.getIdFactura()}" /></td>
								<fmt:formatDate value="${f.getFechaEmision()}"
									pattern="dd/MM/yyyy" var="fechaEm" />
								<td><c:out value="${fechaEm}" /></td>
								<fmt:formatDate value="${f.getFechaVencimiento()}"
									pattern="dd/MM/yyyy" var="fechaVe" />
								<td><c:out value="${fechaVe}" /></td>
								<fmt:formatDate value="${f.getFechaPago()}" pattern="dd/MM/yyyy"
									var="fechaPag" />
								<td><c:out value="${fechaPag}" /></td>
								<c:choose>
									<c:when test="${f.getFechaPago() == null}">
										<c:choose>
											<c:when
												test="${date.compareTo(f.getFechaVencimiento()) > 0 }">
												<td><a class="btn btn-outline-info"
													href="/consultoriaaccidente/notificarAtrasos/MailAPI/${f.getIdFactura()}">Notificar Atraso</a></td>
											</c:when>
											<c:otherwise>
												<td>Sin Pagar</td>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<td>Pagado</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- CAPACITACIONES -->
				<table class="table table-striped table-hover">
					<thead class="thead-light">
						<tr>
							<th colspan="6">REPORTE CAPACITACIONES</th>
						</tr>
						<tr>
							<th>#</th>
							<th>Tema</th>
							<th>Objetivos</th>
							<th>Contenidos</th>
							<th>Recursos</th>
							<th>Fecha</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${c.getListaCapacitaciones()}" var="cap">
							<tr>
								<td><c:out value="${cap.getId()}" /></td>
								<td><c:out value="${cap.getTema()}" /></td>
								<td><c:out value="${cap.getObjetivos()}" /></td>
								<td><c:out value="${cap.getContenidos()}" /></td>
								<td><c:out value="${cap.getRecursos()}" /></td>
								<fmt:formatDate value="${cap.getFecha()}" pattern="dd/MM/yyyy"
									var="fechaCap" />
								<td><c:out value="${fechaCap}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
		</c:forEach>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
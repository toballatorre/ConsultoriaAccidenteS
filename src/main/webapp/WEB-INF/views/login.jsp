<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home - Consultoria Accidentes</title>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
<jsp:include page="header.jsp" />

<div class="contenido">
	
	<%
			String error = (String) request.getAttribute("error");
			if (error != null && error.equals("true")) {
				out.println("<h4 style=\"color:red\">Credenciales invalidas. Intente otra vez!!</h4>");
			}
		%>
		
			<form  name='loginForm' action="<c:url value='login' />" method='POST'>
	
			<table class="login">
				<tr>
					<td>Usuario:</td>
					<td><input type='text' name='username' value=''></td>
				</tr>
				<tr>
					<td>Clave:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan="2"><input name="submit" type="submit" value="Ingresar" /> <input name="reset" type="reset" /> <input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
	
				</tr>
			</table>
	
		</form>
		<h1>Bienvenido</h1><br>
		<h3>Use alguno de estos usuarios para ingresar</h3>
			<div class="row">
			<table class="mx-auto">
				
				<tr>
					<th>Usuario </th>
					<th>Clave</th>
				</tr>
				<tr>
					<td>admin1</td>
					<td>123</td>
				</tr>
				<tr>
					<td>admin2</td>
					<td>123</td>
				</tr>
				<tr>
					<td>cliente1</td>
					<td>123</td>
				</tr>
				<tr>
					<td>cliente2</td>
					<td>123</td>
				</tr>
				<tr>
					<td>prev1</td>
					<td>123</td>
				</tr>
				<tr>
					<td>prev2</td>
					<td>123</td>
				</tr>
			</table>
			</div>
			<br>
		<h3>REST endpoints</h3>

		<h4>Ver detalles de una Factura por su id</h4>
			
		<p>GET: <code>http://localhost:8081/consultoriaaccidente/notificarAtrasos/12</code></p>
		
		<p>BODY: <code>{
    "idFactura": 12,
    "idCliente": 4,
    "listaItem": [
        {
            "idItem": 22,
            "concepto": "Mensualidad",
            "precioUnitario": 1000.0,
            "cantidad": 1,
            "factura": 12
        },
        {
            "idItem": 23,
            "concepto": "Modificación checklist",
            "precioUnitario": 500.0,
            "cantidad": 1,
            "factura": 12
        }
    ],
    "fechaVencimiento": 1590897600000,
    "fechaEmision": 1588305600000,
    "fechaPago": null,
    "iva": 19.0
}</code></p>
<hr width="50%">
		<h4>Generar mail de aviso de atraso por id de factura</h4>
		
		<p>GET: <code>http://localhost:8081/consultoriaaccidente/notificarAtrasos/MailAPI/12</code></p>
		
		<p>BODY: <code>{
    "From": "cobranza@consultoria.cl",
    "Subject": "Nos debe plata",
    "To": "cliente4@cliente4.com",
    "Body": "Estimado Cliente Empresa Dorado , le informamos que la factura 12 está pendiente de pago(2020-05-31). Por favor dirigase al portal de pago."
}</code></p>
<hr width="50%">
		<h4>Ver información de una Asesoria por su id</h4>
		
		<p>GET: <code>http://localhost:8081/consultoriaaccidente/CasoAsesoria/leerAsesoriaAPI/50</code></p>
		
		<p>BODY: <code>{
    "idasesoria": 50,
    "idcaso": 2,
    "fechaasesoria": "2020-06-12 00:00:00",
    "profesional": "6",
    "lugar": "Oficina central Calipso",
    "comentarios": "Sin hallazgos"
}</code>
</p>
<hr width="50%">
		<h4>Ingresa una asesoria recibiendo un objeto Asesoria y devuelve el objeto creado con su id</h4>
		
		<p>POST: <code>http://localhost:8081/consultoriaaccidente/CasoAsesoria/saveAsesoriaAPI</code></p>
		
		<p>POST BODY: <code>{
    "comentarios": "Test API",
    "fechaasesoria": "07/08/2020",
    "idcaso": 1,
    "lugar": "Av. costanera 5555 of 987",
    "profesional": "4"
}</code>
</p>
		<p>RESPONSE BODY: <code>{
    "idasesoria": 4450,
    "idcaso": 1,
    "fechaasesoria": "07/08/2020",
    "profesional": "4",
    "lugar": "Av. costanera 5555 of 987",
    "comentarios": "Test API"
}</code>



<hr width="50%">

<h3>GitHub</h3>
		<p>Aplicación: <a target="blank" href="https://github.com/toballatorre/ConsultoriaAccidenteS.git">https://github.com/toballatorre/ConsultoriaAccidenteS.git</a></p>
		<p>BBDD: <a target="blank" href="https://github.com/takeshidev/ConsPrevRiesgSQL.git">https://github.com/takeshidev/ConsPrevRiesgSQL.git</a></p>
	
	
	</div>

<jsp:include page="footer.jsp" />

</body>
</html>
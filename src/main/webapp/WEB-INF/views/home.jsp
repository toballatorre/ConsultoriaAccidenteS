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
	
	<h1>Bienvenido</h1><br>
	<h2>Menú</h2>
	<button onclick="window.location.href='AreaAdmin';" type="button" class="btn btn-outline-primary">Admin</button>
	<button onclick="window.location.href='AreaCliente';" type="button" class="btn btn-outline-primary">Cliente</button>
	<button onclick="window.location.href='AreaProfesional';" type="button" class="btn btn-outline-primary">Profesional</button>
	<p/>
	<h1>Proyecto: No más Accidentabilidad</h1>
	<p/>
	<h3>Integrantes</h3>
		<p>Takeshi Kita - <a target="_blank" href="https://github.com/takeshidev"><i class="fab fa-github"></i>/takeshidev</a></p>
		<p>Cristóbal Latorre - <a target="_blank" href="https://github.com/toballatorre"><i class="fab fa-github"></i>/toballatorre</a></p>
	<h3>GitHub</h3>
		<p>Aplicación: <a target="blank" href="https://github.com/toballatorre/ConsultoriaAccidenteS.git">https://github.com/toballatorre/ConsultoriaAccidenteS.git</a></p>
		<p>BBDD: <a target="blank" href="https://github.com/takeshidev/ConsPrevRiesgSQL.git">https://github.com/takeshidev/ConsPrevRiesgSQL.git</a></p>
	<h3>Tema:</h3>
		<p>Construir aplicaciones web dinámicas utilizando el entorno de desarrollo Java.</p>
	<br>
	<h3>Objetivos del proyecto:</h3>
		<ul>
			<li>Interpretar especificaciones de sistemas utilizando casos de uso para su posterior implementación </li>
			<li>Construir una aplicación web con Spring MVC</li>
			<li>Desarrollar incrementalmente una solución de software</li>
			<li>Manejo de datos con JPA y JdbcTemplate</li>
			<li>Una pieza de software que consume un servicio REST utilizando Spring MVC para solucionar un problema dado de interoperabilidad</li>
			<li>Controlar el acceso al consumo de una API REST implementando seguridad mediante JWT</li>
			<li>Codifica una API REST utilizando Spring MVC para exponer recursos y operaciones que dan solución a una problemática dada</li>
		</ul>
	<br>
	<h3>Preparación del proyecto</h3>
		<h4>1. Iniciamos diseñando el diagrama de casos de uso que se proveyó en la asignación del proyecto.</h4>
		<img src="resources/img/DiagramasModelos/CasosDeUso.jpg">
		<p>
		<h4>2. Creamos el diagrama de casos</h4>
		<img src="resources/img/DiagramasModelos/DiagramaCasodeUso.jpeg" width="90%">
		<p>
		<h4>3. Modelo de Datos</h4>
		<p><a target="_blank" href="https://github.com/takeshidev/ConsPrevRiesgSQL/blob/master/ModeloSQL/ScriptUnico.sql">Ver script base de datos</a></p>
		
		<img src="resources/img/DiagramasModelos/Relational_1.png" width="90%">
		<p>
		<h4>4. Secuencias</h4>
		<img src="resources/img/DiagramasModelos/SecuanciaAdmin.jpg" width="90%">
		<img src="resources/img/DiagramasModelos/SecuenciaCliente.jpg" width="90%">
		<img src="resources/img/DiagramasModelos/SecuenciaProfesional.jpg" width="90%">
	
		
</div>
<jsp:include page="footer.jsp" />

</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home - Consultoria Accidentes</title>

	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"></c:url>">
</head>
<body>
<jsp:include page="header.jsp" />

<div class="contenido">
	
	<p> <c:out value="${nombre}${apellido} Edad: ${edad}"/> </p>
	
	<a href="capacitacion">Detalle Capacitacion</a>

	<h2>Menu provisional</h2>
	<a href="AreaAdmin">Vista Admin</a>
	<a href="AreaCliente">Vista Cliente</a>
	<a href="AreaProfesional">Vista Profesional</a>

		<h1>Bienvenido</h1><br>
		<h3>Use alguno de estos usuarios para ingresar</h3>
			<p>U: admin1 P: 123</p>
			<p>U: admin2 P: 123</p>
			<p>U: cliente1 P: 123</p>
			<p>U: cliente2 P: 123</p>
			<p>U: prev1 P: 123</p>
			<p>U: prev2 P: 123</p>
			<br>
		<h2>No más Accidentabilidad</h2>
		<h3>Integrantes</h3>
			<p>Takeshi Kita - <a target="_blank" href="https://github.com/takeshidev"><i class="fab fa-github"></i>takeshidev</a></p>
			<p>Cristóbal Latorre - <a target="_blank" href="https://github.com/toballatorre"><i class="fab fa-github"></i>toballatorre</a></p>
			<br>
		<h3>Tema:</h3>
		<p>Construir aplicaciones web dinámicas utilizando el entorno de desarrollo Java.</p>
		<br>
		<h3>Objetivos del proyecto:</h3>
		<p>Interpretar especificaciones de sistemas utilizando casos de uso para su posterior implementación
		Construir una aplicación web dinámica utilizando el patrón MVC con vistas JSP y controladores Servlets para el despliegue de información.
		Realizar conexión a una base de datos dinámica de acuerdo a las especificaciones entregadas</p>
		<br>
		<h3>Casos de uso implementados:</h3>
		<ol>
			<li>CU1 - Mantener información Cliente</li>
			<li>CU2 - Mantener información profesionales</li>
			<li>CU3 - Crear capacitacion</li>
			<li>CU6 - Reportar accidente</li>
			<li>CU8 - Ingresar actividad mejora</li>
			<li>CU9 - Revisar actividad mejora</li>
			<li>CU10 - Controlar pagos cliente</li>
			<li>CU12 - Calcular accidentabildiad</li>
			<li>CU14 - Visualizar actividades</li>
			<li>CU16 - Solicitar asesoria especial</li>
		</ol>
		<br>
		<h3>Preparación del proyecto</h3>
		<p>1. Iniciamos diseñando el diagrama de casos de uso que se proveyó en la asignación del proyecto.</p>
		<img src="resources/img/DiagramasModelos/CasosDeUso.jpg">
		
		<p>2. Creamos el diagrama de casos</p>
		<img src="resources/img/DiagramasModelos/DiagramaCasodeUso.jpeg" width="90%">
		
		<p>3. Modelo de Datos</p>
		<p><a target="_blank" href="SQL/ScriptUnico.sql">Ver script base de datos</a></p>
		
		<img src="resources/img/DiagramasModelos/Relational_1.png" width="90%">
		
		<p>4. Secuencias</p>
		<img src="resources/img/DiagramasModelos/SecuanciaAdmin.jpg" width="90%">
		<img src="resources/img/DiagramasModelos/SecuenciaCliente.jpg" width="90%">
		<img src="resources/img/DiagramasModelos/SecuenciaProfesional.jpg" width="90%">
		
		<h3>GitHub</h3>
		<p><a target="blank" href="https://github.com/toballatorre/ConsultoriaAccidenteS.git">https://github.com/toballatorre/ConsultoriaAccidenteS.git</a></p>
		
</div>
<jsp:include page="footer.jsp" />

</body>
</html>

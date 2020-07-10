<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hola ${nombre}!  
</h1>

<P>  la hora del servidor es ${serverTime}. </P>
<p> <c:out value="${nombre}${apellido} Edad: ${edad}"/> </p>

<a href="/capacitacion">Detalle Capacitacion</a>
</body>
</html>

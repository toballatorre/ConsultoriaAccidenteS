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
				out.println("<h4 style=\"color:red\">Invalid login credentials. Please try again!!</h4>");
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
			<p>U: admin1 P: 123</p>
			<p>U: admin2 P: 123</p>
			<p>U: cliente1 P: 123</p>
			<p>U: cliente2 P: 123</p>
			<p>U: prev1 P: 123</p>
			<p>U: prev2 P: 123</p>
			<br>

	
	
</div>
<jsp:include page="footer.jsp" />

</body>
</html>
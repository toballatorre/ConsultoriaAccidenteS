<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/haceLogin" method="post">
			<input type="text" id="Usuario" name="Usuario" placeholder="Usuario">
			<input type="text" id="Password" name="Password" placeholder="Password">
			<input type="submit" value="Login">
		</form>
</body>
</html>
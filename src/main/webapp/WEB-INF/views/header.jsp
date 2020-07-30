<header>
	<script src="https://kit.fontawesome.com/0a0085a95e.js" crossorigin="anonymous"></script>
	
	<div class="cabecera">
		<h1><img alt="" src="${pageContext.request.contextPath}/resources/img/casco.png" id="casco">Consultoria Prev. Riesgos</h1>
	</div>
	
	<div class="areaLogin">
		<!-- jsp:include page="ValidaUsuario.jsp" /> -->
		<a href="/consultoriaaccidente"><i class="fas fa-home"></i></a>
		
		Hola ${username} ${tipoUsuario}! -  Es ${serverTime}
		<!-- 
		<form action="${pageContext.request.contextPath}/haceLogin" method="post">
			<input type="text" id="Usuario" name="Usuario" placeholder="Usuario">
			<input type="text" id="Password" name="Password" placeholder="Password">
			<input type="submit" value="Login">
		</form>
		 -->
		 <button onclick="window.location.href='${pageContext.request.contextPath}/logout';" type="button">Logout</button>
	</div>
</header>
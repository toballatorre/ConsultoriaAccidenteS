<header>
	<script src="https://kit.fontawesome.com/0a0085a95e.js" crossorigin="anonymous"></script>
	
	<div class="cabecera">
		<h1><img alt="" src="resources/img/casco.png" id="casco">Consultoria Prev. Riesgos</h1>
	</div>
	
	<div class="areaLogin">
		<!-- jsp:include page="ValidaUsuario.jsp" /> -->
		<a href="/consultoriaaccidente"><i class="fas fa-home"></i></a>
		
		Hola ${nombre}! - 
		${serverTime}
		<input type="text" placeholder="Usuario"><input type="text" placeholder="Password"><input type="submit" value="Login">
	</div>
</header>
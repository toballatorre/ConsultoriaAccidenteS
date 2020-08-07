<header>
	<script src="https://kit.fontawesome.com/0a0085a95e.js" crossorigin="anonymous"></script>
	
	<div class="cabecera">
		<h1><img alt="" src="${pageContext.request.contextPath}/resources/img/casco.png" id="casco">Consultoria Prev. Riesgos</h1>
	</div>
	
	<div class="areaLogin">
		
		<a href="/consultoriaaccidente"><i class="fas fa-home"></i></a>
		Hola ${username} ${tipoUsuario}! -  ${serverTime}

		 <button onclick="window.location.href='${pageContext.request.contextPath}/logout';" type="button">Logout</button>
	</div>
</header>
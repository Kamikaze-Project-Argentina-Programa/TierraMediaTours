<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<style type="text/css">
body {
background-color: #f7d59c;
}
h1{
font-size: x-large;
}
nav{
background-color: #d99b4a;
font-size: large;
font-style: normal;
font-weight: bold;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	<div class="container">
		<a class="navbar-brand" href="/turismo/index.jsp">Turismo Tierra Media</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav me-auto mb-2 mb-md-0">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="/turismo/attractions/index.do">Atracciones</a></li>
		</ul>
		<ul class="navbar-nav">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
					<c:out value="${user.username}"></c:out>
				</a>
		<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
			<li><a class="dropdown-item disabled" style="color: black;">
				<i title="monedas" style="color: gold;" class="bi bi-coin"></i> <c:out value="${user.coins}"></c:out>
				</a></li>
			<li><a class="dropdown-item disabled" style="color: black;">
				<i title="tiempo" style="color: blue;" class="bi bi-clock-fill"></i> <c:out value="${user.time}h"></c:out>
				</a></li>
			<li><hr class="dropdown-divider"></li>
			<li><a href="/turismo/logout" class="dropdown-item">Salir</a></li>
		</ul>
		</li>
		</ul>
		</div>
	</div>
</nav>

	<main class="container">
		<div class="bg-light p-4 rounded">
			<h1> ¡Bienvenido a Tierra Media <c:out value="${user.username}" />! </h1>
		</div>
	</main>
	
</body>
</html>

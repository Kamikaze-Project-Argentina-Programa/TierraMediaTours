<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<!-- Index de bienvenida -->
<head>

<jsp:include page="partials/head.jsp"></jsp:include>
<jsp:include page="partials/nav.jsp"></jsp:include>
<link href="/TierraMedia3/assets/css/estilosbase.css" rel="stylesheet" />

</head>
<body>
	<main class="container">
		<div class="centrado-slide">
			<div class="p-4 rounded">
				<h2 style="font-size: 50px">
					¡Te damos la bienvenida,
					<c:out value="${user.username}" />
					!
				</h2>

				<div id="carouselExampleIndicators" class="carousel slide"
					data-bs-ride="carousel">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>

					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="/TierraMedia3/assets/img/moria.jpg"
								class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="/TierraMedia3/assets/img/moria.jpg"
								class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="/TierraMedia3/assets/img/moria.jpg"
								class="d-block w-100" alt="...">
						</div>
					</div>

					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>

					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>
		</div>
	</main>
</body>
</html>

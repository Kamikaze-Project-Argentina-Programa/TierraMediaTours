<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
					<c:out value="${fn:toUpperCase(user.username)}" />
					!
				</h2>
				<br>
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
							<a href="/TierraMedia3/promotions/index.do"><img src="/TierraMedia3/assets/img/aventura.png" class="d-block w-100" alt="image1"></a>
						</div>
						<div class="carousel-item">
						<a href="/TierraMedia3/promotions/index.do"><img src="/TierraMedia3/assets/img/paisajes.png" class="d-block w-100" alt="image2"></a>
						</div>
						<div class="carousel-item">
							<a href="/TierraMedia3/promotions/index.do"><img src="/TierraMedia3/assets/img/degustacion.png" class="d-block w-100" alt="image3"></a>
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

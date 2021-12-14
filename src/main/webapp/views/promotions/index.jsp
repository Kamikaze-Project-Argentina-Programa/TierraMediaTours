<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<!-- Index de promotions -->
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<jsp:include page="/partials/nav.jsp"></jsp:include>
<link href="/TierraMedia3/assets/css/estilosbase.css" rel="stylesheet" />
</head>
<body>
	<main class="container">
		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>

		<div class="p-4 mb-3 rounded">
			<h2>¡Estas son las promociones de la Tierra Media que tenemos
				para vos!</h2>
			<br>
			<h3>¡Esperamos que las aproveches!</h3>
		</div>

		<c:if test="${user.isAdmin()}">
			<div class="mb-3">
				<a href="/TierraMedia3/promotions/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Promoción
				</a>
			</div>
		</c:if>


		<div class="container">
			<div class="row justify-content-center">
				<div class="col md-4">
					<div class="card-group row row-cols-1 row-cols-md-2 g-4 p-4">
						<c:forEach items="${promotions}" var="promotion">
							<div class="card shadow" style="width: 18rem;">
								<img src="${promotion.getImage()}" class="card-img-top"
									alt="imagen">
								<div class="card-body text-center">
									<h5 class="card-title">Pack ${promotion.name}</h5>
									<p class="card-text">
										<c:out value="${promotion.attraction1}"></c:out>
										y
										<c:out value="${promotion.attraction2}"></c:out>
										<c:if test="${promotion.tienePromotion()}">-
										<c:out value="${promotion.attraction3}"></c:out> es gratis
									</c:if>
									</p>
								</div>
								<ul class="text-center list-group list-group-flush">
									<li class="list-group-item"><i title="monedas"
										style="color: gold;" class="bi bi-coin"></i> <c:out
											value="${promotion.cost}"></c:out> <i title="tiempo"
										style="color: brown;" class="bi bi-clock-fill"></i> <c:out
											value="${promotion.duration}"></c:out>h</li>

									<li class="list-group-item"><c:if test="${user.admin}">
											<a href="/TierraMedia3/promotions/edit.do?id=${promotion.id}"
												class="btn btn-light rounded-0" role="button"><i
												class="bi bi-pencil-fill"></i></a>
											<a
												href="/TierraMedia3/promotions/delete.do?id=${promotion.id}"
												class="btn btn-danger rounded" role="button"><i
												class="bi bi-x-circle-fill"></i></a>
										</c:if> <c:choose>
											<c:when
												test="${user.canAffordPromotion(promotion) && user.canAttendPromotion(promotion) && promotion.canHost(1)}">
												<a href="/TierraMedia3/promotions/buy.do?id=${promotion.id}"
													class="btn btn-success rounded" role="button">¡Lo quiero!</a>
											</c:when>
											<c:otherwise>
												<a href="#" class="btn btn-secondary rounded disabled"
													role="button">No se puede comprar</a>
											</c:otherwise>
										</c:choose></li>
								</ul>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>

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
			<h2>¡Estas son las promociones de la Tierra Media que tenemos para vos!</h2>
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
		
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Imagen</th>
					<th>Tipo de Pack</th>
					<th>Atracci&oacute;n 1</th>
					<th>Atracci&oacute;n 2</th>
					<th>Atracci&oacute;n 3</th>
					<th>Costo</th>
					<th>Duracion</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${promotions}" var="promotion">
					<tr>
						<td><img alt="imagen" class="img-thumbnail" src="${promotion.getImage()}"></td>
						<td class="name"><c:out value="${promotion.name}"></c:out></td>
						<td><c:out value="${promotion.attraction1}"></c:out></td>
						<td><c:out value="${promotion.attraction2}"></c:out></td>
						<td><c:if test="${promotion.tienePromotion()}"><c:out value="${promotion.attraction3}"></c:out></c:if></td>
						<td><c:out value="${promotion.cost}"></c:out></td>
						<td><c:out value="${promotion.duration}"></c:out>h</td>
						<td><c:if test="${user.admin}">
								<a href="/TierraMedia3/promotions/edit.do?id=${promotion.id}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i></a>
								<a href="/TierraMedia3/promotions/delete.do?id=${promotion.id}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-x-circle-fill"></i></a>
							</c:if> <c:choose>
								<c:when
									test="${user.canAffordPromotion(promotion) && user.canAttendPromotion(promotion) && promotion.canHost(1)}">
									<a href="/TierraMedia3/promotions/buy.do?id=${promotion.id}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>

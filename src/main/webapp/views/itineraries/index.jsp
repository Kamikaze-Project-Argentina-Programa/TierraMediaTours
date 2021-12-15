<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<!-- Index de itineraries -->
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
			<h2>Itinerario</h2>
		</div>

		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Atracción</th>
					<th>Costo</th>
					<th>Duración</th>
					<th>Tipo de compra</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itineraries}" var="itinerary">
					<tr>
						<td class="name"><strong><c:out
									value="${itinerary.getAttraction()}"></c:out></strong></td>
						<td><c:out value="${itinerary.cost}"></c:out></td>
						<td><c:out value="${itinerary.duration}"></c:out></td>
						<td><c:choose>
								<c:when test="${itinerary.promotion == true }">Con promocion</c:when>
								<c:when test="${itinerary.promotion == false }">Sin promocion</c:when>
							</c:choose></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>

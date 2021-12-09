<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<style type="text/css">
h1{
font-size: x-large;
}
h3{
font-size:large;
}
</style>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">
	
 <%--  esto es para el recuadro de error:  (activar despues)
 
		<c:if test="${flash != null}">
			<div class="alert alert-secondary" role="alert">
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
--%>
		<div class="bg-light p-4 mb-3 rounded">
			<h1>En Tierra Media tenemos una gran variedad de atracciones</h1><br> 
			<h3>¡Esperamos que las disfrutes tanto como nosotros!</h3>
		</div>

<%--  para el usuario administrador

	<c:if test="${user.isAdmin()}">
			<div class="mb-3">
				<a href="/turismo/attractions/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nueva Atracción
				</a>
			</div>
		</c:if>
--%>

<table class="table table-striped">
  <thead>
    <<tr>
		<th>Atraccion</th>
		<th>Precio</th>
		<th>Duracion</th>
		<th>Cupo</th>
		<th>Acciones</th>
	</tr>
  </thead>
  <tbody>
    <c:forEach items="${attractions}" var="attraction">
		<tr>
			<td><strong><c:out value="${attraction.name}"></c:out></strong>
				<p>Descripcion de la atraccion.</p></td>
			<td><c:out value="${attraction.cost}"></c:out></td>
			<td><c:out value="${attraction.duration}"></c:out></td>
			<td><c:out value="${attraction.capacity}"></c:out></td>

			<td><c:if test="${user.admin}">
					<a href="/turismo/attractions/edit.do?id=${attraction.id}"
						class="btn btn-light rounded-0" role="button"><i
						class="bi bi-pencil-fill"></i></a>
					<a href="/turismo/attractions/delete.do?id=${attraction.id}"
						class="btn btn-danger rounded" role="button"><i
						class="bi bi-x-circle-fill"></i></a>
				</c:if> 
				<c:choose>
					<c:when
						test="${user.canAfford(attraction) && user.canAttend(attraction) 
						&& attraction.canHost(1)}">
						<a href="/turismo/attractions/buy.do?id=${attraction.id}"
							class="btn btn-success rounded" role="button">Comprar</a>
					</c:when>
					<c:otherwise>
						<a href="#" class="btn btn-secondary rounded disabled"
							role="button">No se puede comprar esta atraccion</a>
					</c:otherwise>
				</c:choose>
				</td>
		</tr>
	</c:forEach>
  </tbody>
</table>

</main>
</body>
</html>
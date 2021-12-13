<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<!-- Index de attraction types -->
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
			<h2>Tipos de Atracciones</h2>
		</div>

		<c:if test="${user.isAdmin()}">
			<div class="mb-3">
				<a href="/TierraMedia3/attraction-types/create.do"
					class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i>
					Tipo de Atracción
				</a>
			</div>
		</c:if>

		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Tipo de Atracci&oacute;n</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${attractionTypes}" var="attractionTypes">
					<tr>
						<td class="name"><c:out value="${attractionTypes.type}"></c:out></td>
						<td><a
							href="/TierraMedia3/attraction-types/edit.do?id=${attractionTypes.id}"
							class="btn btn-light rounded-0" role="button"><i
								class="bi bi-pencil-fill"></i></a> <a
							href="/TierraMedia3/attraction-types/delete.do?id=${attractionTypes.id}"
							class="btn btn-danger rounded" role="button"><i
								class="bi bi-x-circle-fill"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>
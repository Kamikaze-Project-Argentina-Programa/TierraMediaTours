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
					<c:out value="${fn:toUpperCase(user.username)}" />!
				</h2>
				<br>
				<table style="height: auto;" class="centrado-slide">
					<tbody>
						<tr>
							<c:forEach items="${promotions}" var="promotions">
								<td><div class="card border border-3" style="width: auto;">
										<img src="${promotions.getImage()}" class="card-img-top rounded"
											alt="imagen">
										<div class="card-body">
											<h5 class="card-title">
												<c:out value="${promotions.name}"></c:out>
											</h5>
											<p class="card-text"><c:out value="${promotions.attraction1}"></c:out> |
											<c:out value="${promotions.attraction2}"></c:out>
											<c:if test="${promotions.isValidAttraction3()}">
											|<c:out value="${promotions.attraction3}"></c:out></c:if></p>
											<a href="#" class="btn btn-primary">Go somewhere</a>
										</div>
									</div></td>
							</c:forEach>
						</tr>

					</tbody>
				</table>
			</div>
		</div>
	</main>
</body>
</html>

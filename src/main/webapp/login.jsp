<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>

<style type="text/css">
h3 {
	font-size: large;
}
</style>
<link href="assets/css/estilosbase.css" rel="stylesheet" />
</head>
<body>

	<div class="col-lg-5 mx-auto p-3 py-md-5">

		<main>
			<h1 class="mt-3 mb-5 text-center">Turismo en la Tierra Media</h1>

			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>

			<c:if test="${success !=null}">
				<div class="alert alert-info">
					<p>
						<c:out value="${ success }"></c:out>
					</p>
				</div>
			</c:if>

			<h3>Ingresa a la web iniciando tu sesión:</h3>

			<form action="login" method="post">

				<div class="mb-3">
					<label for="username" class="form-label">Usuario</label> <input
						class="form-control" name="username">
				</div>

				<div class="mb-3">
					<label for="password" class="form-label">Contraseña</label> <input
						type="password" class="form-control" name="password">
				</div>

				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-success">Ingresar</button>

				</div>
				<br> <a href="/TierraMedia3/signup.jsp">
					<div class="d-grid gap-2">

						<button type="button" class="btn btn-primary">Registrarse</button>


					</div>
				</a>
			</form>
		</main>
	</div>
</body>
</html>

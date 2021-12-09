<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<style type="text/css">
h1 {
text-transform: uppercase;
font-size: xx-large;
font-weight: bold;
text-shadow: 2px 2px 3px #B5651D;
}
h3{
font-size: large;
}
body {
background-color: #faf6c5;
}
</style>
</head>
<body>

	<div class="col-lg-5 mx-auto p-3 py-md-5">

		<main>
			<h1>Turismo Tierra Media</h1>
<%--  esto es para el recuadro de error:  (activar despues)
	
		<c:if test="${flash != null}">	
			<div class="alert alert-secondary" role="alert">
			<p> <c:out value="${flash}"/> </p>
			</div>
		</c:if>
 --%>
 			<h3>Ingresá a la web iniciando tu sesión:</h3>
 			<br>
 			<br>
			<form action="login" method="post">

				<div class="mb-3">
					<label for="username" class="form-label" style="font-size: large;">Usuario:</label> <input
						class="form-control" name="username" style="background-color: #f2f2f2;">
				</div>

				<div class="mb-3">
					<label for="password" class="form-label" style="font-size: large;">Contraseña:</label> <input
						type="password" class="form-control" name="password" style="background-color: #f2f2f2;">
				</div>

				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-success">Ingresar</button>
				</div>
			</form>

		</main>
	</div>
</body>
</html>
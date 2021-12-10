<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<jsp:include page="partials/head.jsp"></jsp:include>
 <jsp:include page="partials/nav.jsp"></jsp:include> 
</head>
<body>

<div class="col-lg-5 mx-auto p-3 py-md-5">

	<div class="modal-body">
		<div class="mb-3">
			<label for="name" class="col-form-label"> Nombre:</label> <input
				type="text" class="form-control" id="name" name="name" required
				value="${user.username}">
		</div>
		
		<div class="mb-3">
			<label for="cost"
				class='col-form-label ${user.errors.get("cost") != null ? "is-invalid" : "" }'> Presupuesto:</label>
			<input class="form-control" type="number" id="cost" name="cost"
				required value="${user.cost}"></input>
			<div class="invalid-feedback">
				<c:out value='${user.errors.get("cost")}'></c:out>
			</div>
		</div>
		
		<div class="mb-3">
			<label for="duration"
				class='col-form-label ${user.errors.get("duration") != null ? "is-invalid" : "" }'> Tiempo:</label>
			<input class="form-control" type="number" id="duration"
				name="duration" required value="${user.duration}"></input>
			<div class="invalid-feedback">
				<c:out value='${user.errors.get("duration")}'></c:out>
			</div>
		</div>

		<div>
			<button type="submit" class="btn btn-primary">Guardar</button>
			<!--  falta la logica  -->
			
			<a onclick="window.history.back();" class="btn btn-secondary"
				role="button">Cancelar</a>
		</div>

	</div>
	
	</div>

</body>
</html>
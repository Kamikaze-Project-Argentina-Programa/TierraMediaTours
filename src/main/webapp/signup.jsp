<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<link href="/TierraMedia3/assets/css/estilosbase.css" rel="stylesheet" />
</head>
<body>

	<div class="col-lg-5 mx-auto p-3 py-md-5">
		<h2 style="text-align: center;">Ingresa los datos para
			registrarte</h2>
		<main class="container">
			<div class="bg-brown p-4 rounded">
				<div class="modal-body">
					<div class="mb-3">
						<label for="name" class="col-form-label"> Nombre:</label> <input
							type="text" class="form-control" id="name" name="name">
					</div>

					<div class="mb-3">
						<label for="password" class="form-label">Contraseña</label> <input
							type="password" class="form-control" name="password">
					</div>

					<div class="mb-3">
						<label for="cost"
							class='col-form-label ${user.errors.get("cost") != null ? "is-invalid" : "" }'>
							Presupuesto:</label> <input class="form-control" type="number" id="cost"
							name="cost"></input>
						<div class="invalid-feedback">
							<c:out value='${user.errors.get("cost")}'></c:out>
						</div>
					</div>

					<div class="mb-3">
						<label for="duration"
							class='col-form-label ${user.errors.get("duration") != null ? "is-invalid" : "" }'>
							Tiempo:</label> <input class="form-control" type="number" id="duration"
							name="duration"></input>
						<div class="invalid-feedback">
							<c:out value='${user.errors.get("duration")}'></c:out>
						</div>
					</div>

					<div class="mb-3">
						<label for="preferences"
							class='col-form-label ${user.errors.get("preferences") != null ? "is-invalid" : "" }'>
							Preferencia:</label> <input class="form-control" type="text"
							id="preferences" name="preferences"></input>
						<div class="invalid-feedback">
							<c:out value='${user.errors.get("preferences")}'></c:out>
						</div>
					</div>


					<div>
						<button type="submit" class="btn btn-primary">Guardar</button>
						<!--  falta la logica  -->
						<a onclick="window.history.back();" class="btn btn-danger"
							role="button">Cancelar</a>
					</div>

				</div>
			</div>
		</main>
	</div>
</body>
</html>

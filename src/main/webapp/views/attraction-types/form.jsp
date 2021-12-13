<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="name" required
			value="${attraction.name}">
	</div>
	<div class="mb-3">
		<label for="cost"
			class='col-form-label ${attraction.errors.get("cost") != null ? "is-invalid" : "" }'>Costo:</label>
		<input class="form-control" type="number" id="cost" name="cost"
			required value="${attraction.cost}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("cost")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="duration"
			class='col-form-label ${attraction.errors.get("duration") != null ? "is-invalid" : "" }'>Duración:</label>
		<input class="form-control" type="number" id="duration"
			name="duration" required value="${attraction.duration}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("duration")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="capacity"
			class='col-form-label ${attraction.errors.get("capacity") != null ? "is-invalid" : "" }'>Cupo:</label>
		<input class="form-control" type="number" id="capacity"
			name="capacity" required value="${attraction.capacity}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("capacity")}'></c:out>
		</div>
		
		<div class="mb-3">
			<label for="description"
				class='col-form-label'>Descripcion:</label>
			<input class="form-control" type="text" id="description"
				name="description" required value="${attraction.description}"></input>
			<div class="invalid-feedback">
				<c:out value='${attraction.errors.get("description")}'></c:out>
			</div>
			<br>
				<div class="mb-3">
		<label for="type"
			class='col-form-label ${attraction.errors.get("type") != null ? "is-invalid" : "" }'>Tipo:</label>
		<input class="form-control" type="number" id="type"
			name="type" required value="${attraction.type}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("type")}'></c:out>
		</div>
<!-- 			<div class="mb-3"> -->
<!-- 				<label for="formFile" class="form-label">Tipo de atraccion -->
<!-- 					preferida:</label> <select class="form-select" -->
<!-- 					aria-label="Default select example"> -->
<!-- 					<option selected></option> -->
<%-- 					<option value="${attraction.type}" id="type" >1</option> --%>
<%-- 					<option value="${attraction.type}" id="type">2</option> --%>
<%-- 					<option value="${attraction.type}" id="type">3</option> --%>
<!-- 				</select> -->
<!-- 			</div> -->

			<div class="mb-3">
				<label for="formFile" class="form-label">Inserte una imagen</label>
				<input class="form-control" type="file" id="formFile">
			</div>

		</div>
	</div>
	<div>
		<button type="submit" class="btn btn-primary">Guardar</button>
		<a onclick="window.history.back();" class="btn btn-secondary"
			role="button">Cancelar</a>
	</div>
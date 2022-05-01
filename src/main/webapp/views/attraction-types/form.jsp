<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="name" required
			value="${attractionTypes.type}">
	</div>
	<select class="form-select" aria-label="${attractionTypes.isActive}">
		<option value="${attractionTypes.isActive}">true</option>
		<option value="${attractionTypes.isActive != true}">false</option>
	</select>
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<div class="modal-body"> 
 <div class="mb-3"> 
  <label for="name" class="col-form-label">Nombre:</label> <input 
   type="text" class="form-control" id="name" name="name" 
   required value="${attractionTypes.name}"> 
 </div> 
 <div class="mb-3"> 
  <label for="cost" 
   class='col-form-label ${attractionTypes.errors.get("cost") != null ? "is-invalid" : "" }'>Costo:</label> 
  <input class="form-control" type="number" id="cost" name="cost" 
   required value="${attractionTypes.cost}"></input> 
  <div class="invalid-feedback"> 
   <c:out value='${attractionTypes.errors.get("cost")}'></c:out> 
  </div> 
 </div> 
 <div class="mb-3"> 
  <label for="duration" 
   class='col-form-label ${attractionTypes.errors.get("duration") != null ? "is-invalid" : "" }'>Duración:</label> 
  <input class="form-control" type="number" id="duration" name="duration" 
   required value="${attractionTypes.duration}"></input> 
  <div class="invalid-feedback"> 
   <c:out value='${attractionTypes.errors.get("duration")}'></c:out> 
  </div> 
 </div> 
 <div class="mb-3"> 
  <label for="duration" 
   class='col-form-label ${attractionTypes.errors.get("attraction1") != null ? "is-invalid" : "" }'>Atraccion 1:</label> 
  <input class="form-control" type="number" id="duration" name="duration" 
   required value="${attractionTypes.attraction1}"></input> 
  <div class="invalid-feedback"> 
   <c:out value='${attractionTypes.errors.get("attraction1")}'></c:out> 
  </div> 
 </div> 
  <div class="mb-3"> 
  <label for="duration" 
   class='col-form-label ${attractionTypes.errors.get("attraction2") != null ? "is-invalid" : "" }'>Atraccion 2:</label> 
  <input class="form-control" type="number" id="duration" name="duration" 
   required value="${attractionTypes.attraction2}"></input> 
  <div class="invalid-feedback"> 
   <c:out value='${attractionTypes.errors.get("attraction2")}'></c:out> 
  </div> 
 </div> 
  <div class="mb-3"> 
  <label for="duration" 
   class='col-form-label ${attractionTypes.errors.get("attraction3") != null ? "is-invalid" : "" }'>Atraccion 3:</label> 
  <input class="form-control" type="number" id="duration" name="duration" 
   required value="${attractionTypes.attraction3}"></input> 
  <div class="invalid-feedback"> 
   <c:out value='${attractionTypes.errors.get("attraction3")}'></c:out> 
  </div> 
 </div> 

</div> 
<div> 
 <button type="submit" class="btn btn-primary">Guardar</button> 
 <a onclick="window.history.back();" class="btn btn-secondary" 
  role="button">Cancelar</a> 
</div>
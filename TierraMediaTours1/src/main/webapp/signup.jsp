<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<div class="modal-body"> 
 <div class="mb-3"> 
  <label for="name" class="col-form-label">Nombre:</label> <input 
   type="text" class="form-control" id="name" name="name" 
   required value="${user.name}"> 
 </div> 
 <div class="mb-3"> 
  <label for="cost" 
   class='col-form-label ${user.errors.get("cost") != null ? "is-invalid" : "" }'>Costo:</label> 
  <input class="form-control" type="number" id="cost" name="cost" 
   required value="${user.cost}"></input> 
  <div class="invalid-feedback"> 
   <c:out value='${user.errors.get("cost")}'></c:out> 
  </div> 
 </div> 
 <div class="mb-3"> 
  <label for="duration" 
   class='col-form-label ${user.errors.get("duration") != null ? "is-invalid" : "" }'>Duration:</label> 
  <input class="form-control" type="number" id="duration" name="duration" 
   required value="${user.duration}"></input> 
  <div class="invalid-feedback"> 
   <c:out value='${user.errors.get("duration")}'></c:out> 
  </div> 
 </div> 
 <div class="mb-3"> 
  <label for="capacity" 
   class='col-form-label ${user.errors.get("capacity") != null ? "is-invalid" : "" }'>Capacity:</label> 
  <input class="form-control" type="number" id="capacity" name="capacity" 
   required value="${user.capacity}"></input> 
  <div class="invalid-feedback"> 
   <c:out value='${user.errors.get("capacity")}'></c:out> 
  </div> 
 </div> 
</div> 
<div> 
 <button type="submit" class="btn btn-primary">Guardar</button> 
 <a onclick="window.history.back();" class="btn btn-secondary" 
  role="button">Cancelar</a> 
</div>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
<div class="mb-3"> 
 <label for="name" class="col-form-label">Nombre:</label> <input 
  type="text" class="form-control" id="name" name="username" 
  required value="${tmp_user.username}"> 
</div> 

<div class="mb-3"> 
 <label for="password" 
  class='col-form-label ${tmp_user.errors.get("password") != null ? "is-invalid" : "" }'>Contraseña:</label> 
 <input class="form-control" type="password" id="password" name="password" 
  required value="${tmp_user.password}"></input> 
 <div class="invalid-feedback"> 
  <c:out value='${tmp_user.errors.get("password")}'></c:out> 
 </div> 
</div> 

<div class="mb-3"> 
 <label for="money" 
  class='col-form-label ${tmp_user.errors.get("money") != null ? "is-invalid" : "" }'>Monedas:</label> 
 <input class="form-control" type="number" id="money" name="money" 
  required value="${tmp_user.money}"></input> 
 <div class="invalid-feedback"> 
  <c:out value='${tmp_user.errors.get("money")}'></c:out> 
 </div> 
</div> 
 
<div class="mb-3"> 
 <label for="time" 
  class='col-form-label ${tmp_user.errors.get("time") != null ? "is-invalid" : "" }'>Tiempo:</label> 
 <input class="form-control" type="number" id="time" name="time" 
  required value="${tmp_user.time}"></input> 
 <div class="invalid-feedback"> 
  <c:out value='${tmp_user.errors.get("time")}'></c:out> 
 </div> 
</div> 
 
 <div class="mb-3"> 
 <label for="preferences" 
  class='col-form-label ${tmp_user.errors.get("preferences") != null ? "is-invalid" : "" }'>Preferencias:</label> 
 <input class="form-control" type="number" id="preferences" name="preferences" 
  required value="${tmp_user.preferences}"></input> 
 <div class="invalid-feedback"> 
  <c:out value='${tmp_user.errors.get("preferences")}'></c:out> 
 </div> 
</div>

 <div class="mb-3"> 
 <label for="admin" 
  class='col-form-label ${tmp_user.errors.get("admin") != null ? "is-invalid" : "" }'>Tipo de usuario:</label> 
 <input class="form-control" type="text" id="admin" name="admin" 
  required value="${tmp_user.admin}"></input> 
 <div class="invalid-feedback"> 
  <c:out value='${tmp_user.errors.get("admin")}'></c:out> 
 </div> 
</div> 

<div> 
 <button type="submit" class="btn btn-primary">Guardar</button> 
 <a onclick="window.history.back();" class="btn btn-secondary" 
  role="button">Cancelar</a> 
</div>
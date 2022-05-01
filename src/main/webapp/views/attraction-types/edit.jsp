<%@ page language="java" contentType="text/html; charset=UTF-8" 
 pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html> 
<html> 
<!-- Edit de Attraction-Types -->
<head> 
<jsp:include page="/partials/head.jsp"></jsp:include> 
</head> 
<body> 
 <jsp:include page="/partials/nav.jsp"></jsp:include> 
 
 <main class="container"> 
 
  <c:if test="${attractionTypes != null}"> 
   <div class="alert alert-danger"> 
    <p>Se encontraron errores al actualizar el tipo de atracción.</p> 
   </div> 
  </c:if> 
 
  <form action="/TierraMedia3/attraction-types/edit.do" method="post"> 
   <input type="hidden" name="id" value="${attractionTypes.id}"> 
   <jsp:include page="/views/attraction-types/form.jsp"></jsp:include> 
  </form> 
 </main> 
</body> 
</html>
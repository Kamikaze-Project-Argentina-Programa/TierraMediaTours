<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Promos</title>
</head>
<body>

<table class="table table-stripped table-hover"> 
   <thead> 
    <tr> 
     <th>Atracci&oacute;n</th> 
     <th>Costo</th> 
     <th>Duraci&oacute;n</th> 
     <th>Cupo</th> 
     <th>Acciones</th> 
    </tr> 
   </thead> 
   <tbody> 
    <c:forEach items="${attractions}" var="attraction"> 
     <tr> 
      <td><strong><c:out value="${attraction.name}"></c:out></strong> 
       <c:out value="${attraction.description}"></c:out></td> 
      <td><c:out value="${attraction.cost}"></c:out></td> 
      <td><c:out value="${attraction.duration}"></c:out></td> 
      <td><c:out value="${attraction.capacity}"></c:out></td> 
 
      <td><c:if test="${user.admin}"> 
        <a href="/TierraMedia3/attractions/edit.do?id=${attraction.id}" 
         class="btn btn-light rounded-0" role="button"><i 
         class="bi bi-pencil-fill"></i></a> 
        <a href="/TierraMedia3/attractions/delete.do?id=${attraction.id}" 
         class="btn btn-danger rounded" role="button"><i 
         class="bi bi-x-circle-fill"></i></a> 
       </c:if> 
       <c:choose> 
        <c:when 
         test="${user.canAfford(attraction) && user.canAttend(attraction) && attraction.canHost(1)}"> 
         <a href="/TierraMedia3/attractions/buy.do?id=${attraction.id}" 
          class="btn btn-success rounded" role="button">Comprar</a> 
        </c:when> 
        <c:otherwise> 
         <a href="#" class="btn btn-secondary rounded disabled" 
          role="button">No se puede comprar</a> 
        </c:otherwise> 
       </c:choose></td> 
     </tr> 
    </c:forEach> 
   </tbody> 
  </table> 

</body>
</html>
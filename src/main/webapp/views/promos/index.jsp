<%@ page language="java" contentType="text/html; charset=UTF-8" 
 pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html> 
<html> 
<head> 
<jsp:include page="/partials/head.jsp"></jsp:include> 
</head> 
<body> 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <jsp:include page="/partials/nav.jsp"></jsp:include> 
 
 <main class="container"> 
 
  <c:if test="${flash != null}"> 
   <div class="alert alert-danger"> 
    <p> 
     <c:out value="${flash}" /> 
     <c:if test="${errors != null}"> 
      <ul> 
       <c:forEach items="${errors}" var="entry"> 
        <li><c:out value="${entry.getValue()}"></c:out></li> 
       </c:forEach> 
      </ul> 
     </c:if> 
    </p> 
   </div> 
  </c:if> 
 
  <div class="bg-light p-4 mb-3 rounded"> 
   <h1>Estas son las promociones de la Tierra Media</h1> 
  </div> 
 
  <c:if test="${user.isAdmin()}"> 
   <div class="mb-3"> 
    <a href="/TierraMedia3/attractions/create.do" class="btn btn-primary" 
     role="button"> <i class="bi bi-plus-lg"></i> Nueva promo 
    </a> 
   </div> 
  </c:if> 
  
 
 </main> 
 
</body> 
</html>
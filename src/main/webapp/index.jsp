<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html> 
<head> 
<jsp:include page="partials/head.jsp"></jsp:include> 
</head> 
<body> 
 
 <jsp:include page="partials/nav.jsp"></jsp:include> 
 
 <main class="container"> 
  <div class="bg-light p-4 rounded"> 
   <h1> 
    ¡Bienvenido, <c:out value="${user.username}" />!   
   </h1> 
   <img alt="probando" src="assets/img/moria.jpg">
  </div> 
  <div> 
  <h3>Tenemos estas promos para vos!</h3>
  <jsp:include page="views/promos/display.jsp"></jsp:include>
  </div>
 </main> 
</body> 
</html>
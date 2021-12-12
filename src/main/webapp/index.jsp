<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html> 
<head> 

<jsp:include page="partials/head.jsp"></jsp:include> 
<link href="/TierraMedia3/assets/css/estilosbase.css" rel="stylesheet" />
</head> 
<body> 
 
 <jsp:include page="partials/nav.jsp"></jsp:include> 
 
 <main class="container"> 
  <div class="p-4 rounded"> 
   <h2> 
    ¡Te damos la bienvenida, <c:out value="${user.username}" />!
   </h2> 
  </div> 
 </main> 
</body> 
</html>

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<style type="text/css">
body {
background-color: #f7d59c;
}
h1{
font-size: x-large;
}
</style>
</head>
<body>
<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">
		<div class="bg-light p-4 rounded">
			<h1>
				¡Bienvenido a Tierra Media <c:out value="${user.username}" />!
			</h1>
		</div>
	</main>
	
</body>
</html>

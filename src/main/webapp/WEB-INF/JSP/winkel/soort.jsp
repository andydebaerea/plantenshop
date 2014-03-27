<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<link rel='stylesheet' href='styles/default.css' />
<link href="styles/menu_source/styles.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type='text/javascript' src='js/menu_source/menu_jquery.js'></script>
<title>de PlantenShop</title>

</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"></c:import>
<c:forEach items="${soort.planten}" var="plant">
	<spring:url value="/plant/{id}" var="plantUrl">
		<spring:param name="id" value="${plant.plantId}"></spring:param>
	</spring:url>
   <li><a href='${plantUrl}'><span>${plant.naam}</span></a></li>
</c:forEach>   
</ul>
</body>
</html>
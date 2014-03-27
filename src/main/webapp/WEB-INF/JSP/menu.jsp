<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
<base href="${pageContext.servletContext.contextPath}/">

</head>
<header>
<nav>

<h1>de PlantenShop</h1>



<div id='cssmenu'>
<ul>
<c:forEach items="${soorten}" var="soort">
	<spring:url value="/soort/{id}" var="soortUrl">
		<spring:param name="id" value="${soort.soortId}"></spring:param>
	</spring:url>
   <li><a href='${soortUrl}'><span>${soort.naam}</span></a></li>
</c:forEach>   
</ul>
</div>
</nav>
</header>
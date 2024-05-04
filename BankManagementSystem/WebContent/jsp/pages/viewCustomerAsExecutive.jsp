<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en-us">
<head>
	<jsp:include page="../partials/header.jsp"/>
	<jsp:include page="../partials/searchBar.jsp"/>
	<title>Customer Status</title>
</head>
<style>
.viewAll tr{
	background-color:#FFFFFF;
}
</style>
<body class="body-with-nav">
	<jsp:include page="../partials/navExecutives.jsp"/>
	
	<div style="text-align:center">
		<h1>Customer Status</h1>
		<div style="display:inline-block">
			<table class="viewAll">
				<thead>
					<tr style="background-color:#007bff">
						<th>Customer ID</th>
						<th>Name</th>
						<th>SSN</th>
						<th>Status</th>
						<th>Last Updated</th>
						<th>Actions</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<tr>
							<td>
								<c:out value = "${customer.id}"/>
							</td>
							<td>
								<c:out value = "${customer.firstName}  ${customer.lastName}"/>
							</td>
							<td>
								<c:out value = "${customer.ssn}"/>
							</td>
							<td>
								<c:out value = "${customer.customerStatus}"/>
							</td>
							<td>
								<c:out value = "${customer.lastUpdate}"/>
							</td>
							<td>
									<a href="${pageContext.request.contextPath}/customers/view?id=${customer.id}">View</a>
									<a href="${pageContext.request.contextPath}/customers/view?id=${customer.id}">Edit</a>
									<a action="delete" name = "delete" href="${pageContext.request.contextPath}/customers/view?id=delete-${customer.id}">Delete</a>
								
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<jsp:include page="../partials/footer.jsp"/>
	<jsp:include page="../partials/commonScripts.jsp"/>
</body>
</html>
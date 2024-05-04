<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en-us">
<style>
	table, th, rd{
		margin-top: 5%;
		padding: 10px;
		margin-left: auto;
		margin-right: auto;
		border: 1px solid black;
		background-color: white;
	}
</style>
<head>
<meta charset="ISO-8859-1">
<title>BMS</title>
	<jsp:include page="../partials/header.jsp"/>
</head>
<body class="body-no-nav">
	<div id="tablediv">
		<form name="activeCustomerTeller"
			action="${pageContext.request.contextPath}/accounts/view"
			method="POST" onSubmit="">
			<h4 align="center">Active Customers</h4>
			<table>
				<tr>
					<th>Customer ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>SSN</th>
					<th>Actions</th>
				</tr>
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<tr>
							<td><c:out value="${customer.id}" /></td>
							<td><c:out value="${customer.firstName}" /></td>
							<td><c:out value="${customer.lastName}" /></td>
							<td><c:out value="${customer.ssn}" /></td>
							<td><a
								href="${pageContext.request.contextPath}/accounts/view?customerId=${customer.id}">account
									action</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="hidden" name="role" value="Teller">
		</form>
	</div>
	
	<footer class="fixed-bottom container-fluid text-center text-white bg-primary py-2">
		<a>Team Thanos copyright &copy; <script type="text/javascript">document.write(new Date().getFullYear());</script></a>
	</footer>
	
	<jsp:include page="../partials/footer.jsp"/>
	<jsp:include page="../partials/commonScripts.jsp"/>
	
</body>
</html>
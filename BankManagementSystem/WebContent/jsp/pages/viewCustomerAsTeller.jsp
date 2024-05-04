<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../../css/customerTeller.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Title of the document</title>
</head>
<div id="page-container">
<h1>Customer</h1>
<h2>Accounts</h2>
<body>


	<div id="wrapper">
		<div id="customerdiv" style="border: 1px solid black" width=100px;>
			<form>
				<label>Customer ID</label> 
				<input type="text" id="id" name="customerid" value="${customer.id}" readonly> 
				<label>First Name</label> 
				<input type="text" id="firstName" name="firstname" value="${customer.firstName}" readonly> 
				<label>Last Name</label> 
				<input type="text" id="lastName" name="lastname" value="${customer.lastName}" readonly>
				<label>SSN:</label>
				<input type="text" id="ssn" name="ssn"  value="${customer.ssn}" readonly>
				<label>DOB:</label>
				<input type="text" id="dob" name="dob" value="${customer.dob }" readonly>
				<label>Address line 1</label> 
				<input type="text" id="addressLine1" name="addressone" value="${customer.addressLine1 }" readonly>
				<label>Address line 2</label>
				<input type="text" id="addressLine2" name="addresstwo" value="${customer.addressLine2 }" readonly>
				<label>City</label> 
				<input type="text" id="city" name="city" value="${customer.city}" readonly> 
				<label>State</label>
				<input type="text" id="state" name="state" value="${customer.state}" readonly>
				<label>Zipcode</label>
				<input type="text" id="zipcode" name="zipcode" value="${ customer.zipcode}" readonly>
				
				<a href="http://localhost:8080/BankManagementSystem/jsp/pages/homeTellers.jsp">Cancel</a>

			</form>
		</div>
		<form name="accountTeller" action="${pageContext.request.contextPath}/accounts/view" method="POST" onSubmit="">
		<div id="tablediv">
			<table>
				<tr>
					<th>Account ID</th>
					<th>Account Type</th>
					<th>Account Status</th>
					<th>Balance</th>
					<th>Last Transaction</th>
					<th>Action</th>
				</tr>
				<tbody>
					<c:forEach var="account" items="${accounts}">
					<tr>
						<td><c:out value="${account.accountId}" /></td>
						<td><c:out value="${account.accountType}" /></td>
						<td><c:out value="${account.status}" /></td>
						<td><c:out value="${account.balance}" /></td>
						<td><c:out value="${account.lastTransaction}" /></td>
						<td>
						<a href="${pageContext.request.contextPath}/transaction?accountId=${account.accountId}">statement</a>
						<a href="${pageContext.request.contextPath}/transaction?accountId=${account.accountId}">transaction</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="hidden" name="role" value="Teller">
			</form>
		</div>
	</div>
	<footer id=footer>About us Services Contact US</footer>
</body>
</div>
</html>
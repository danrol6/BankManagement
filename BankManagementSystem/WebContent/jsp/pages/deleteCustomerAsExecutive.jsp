<!DOCTYPE HTML>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en-us">
<head>
	<jsp:include page="../partials/header.jsp"/>
</head>

<body class="body-with-nav">
	<jsp:include page="../partials/navExecutives.jsp"/>
	
	<h1 class="text-center text-light">Delete Customer</h1>
	<div class="d-flex flex-row bg-light">
		<div class="p-3 border border-dark" >
			<form onsubmit="return someFunction()" action="" method="post">
				<div>
					<label>Customer ID:</label>
					<span></span>
				</div>
				<div>
					<label>First Name:</label>
					<span></span>
				</div>
				<div>
					<label>Last Name:</label>
					<span></span>
				</div>
				<div>
					<label>SSN:</label>
					<span></span>
				</div>
				<div>
					<label>DOB:</label>
					<span></span>
				</div>
				<div>
					<label>Address Line 1:</label>
					<span></span>
				</div>
				<div>
					<label>Address Line 2:</label>
					<span></span>
				</div>
				<div>
					<label>City:</label>
					<span></span>
				</div>
				<div>
					<label>State:</label>
					<span></span>
				</div>
				<div>
					<label>Zip Code:</label>
					<span></span>
				</div>
				<br><br>	
			</form>
		</div>
		<!--Accounts Table  -->
		<div>
			<h2>Accounts</h2>
			<table style="width:100%">
				<thead>
					<tr>
						<th>Account ID</th>
						<th>Account Type</th> 
						<th>Account Status</th>
						<th>Balance</th>
						<th>Last Transaction</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="obj" items="${accounts}">
						<td><c:out value = "${accounts.accountId}"/></td>
						<td><c:out value = "${accounts.accountType}"/></td>
						<td><c:out value = "${accounts.accountStatus}"/></td>
						<td><c:out value = "${accounts.balance}"/></td>
						<td><c:out value = "${accounts.lastTransaction}"/></td>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<input type="button" value="Back" onclick="someFunction()">
				<input type="button" value="Delete" onclick="someFunction()">
			</div>
		</div>
	</div>
	
	<jsp:include page="../partials/footer.jsp"/>
	<jsp:include page="../partials/commonScripts.jsp"/>
</body>
</html>
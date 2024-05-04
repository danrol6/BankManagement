<!DOCTYPE HTML>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en-us">
<head>
	<jsp:include page="../partials/header.jsp"/>
</head>

<body>
	<jsp:include page="../partials/navExecutives.jsp"/>

	<div class="container">
			<h2>Create Account</h2>
			<form action="${pageContext.request.contextPath}/executiveAccount" method="post">
			<label>Customer ID:</label>
			<input name="customerId" type="text" value = "${account.customerId }" readonly><br>
			<label>Account ID:</label>
			<input name="accountId" type="text" ><br>
			<label>select account type:</label>
			<select name="accountType" >
			<option value="Checking">Checking</option>
			<option value="Savings">Savings</option>
			</select><br>
			<label>Deposit Amount:</label>
			<input name ="balance" type="text">
			<br><br>
			<div>
				<input type="hidden" name ="action" value="save"/>
			 	<input type="button" value="Cancel">
				<input type="submit" value="Save">
			</div>
			</form>
			
		</div>
		
	<jsp:include page="../partials/footer.jsp"/>
	<jsp:include page="../partials/commonScripts.jsp"/>

</body>
</html>
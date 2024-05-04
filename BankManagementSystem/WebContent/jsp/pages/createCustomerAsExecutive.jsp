<!DOCTYPE HTML>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en-us">
<head>
	<jsp:include page="../partials/header.jsp"/>
</head>

<body class="body-with-nav">
	<jsp:include page="../partials/navExecutives.jsp"/>
	<h1 class="text-center text-light">Create Customer</h1>
	<div class="bg-light border border-dark">
		<form name ="createCustomers" action="${pageContext.request.contextPath}/customers/edit" onsubmit=""  method="post">
			<div><label>Customer ID:</label>
				<input name="id" type="text" ></div>
			<div><label>First Name:</label>
				<input name="firstName" type="text"></div>
			<div><label>Last Name:</label>
					<input name="lastName" type="text"></div>
			<div><label>SSN:</label>
				<input name="ssn" type="text" required pattern="^\d{3}-\d{2}-\d{4}$"></div>
			<div><label>DOB:</label>
				<input name="dob" type="text" ></div>
			<div><label>Address Line 1:</label>
				<input name="addressLine1" type="text"></div>
			<div><label>Address Line 2:</label>
				<input name="addressLine2" type="text"></div>
			<div><label>City:</label>
				<input name="city" type="text"></div>
			<div><label>State:</label>
			<select name="state" size="1">
				<option value="AL">Alabama</option>
				<option value="AK">Alaska</option>
				<option value="AZ">Arizona</option>
				<option value="AR">Arkansas</option>
				<option value="CA">California</option>
				<option value="CO">Colorado</option>
				<option value="CT">Connecticut</option>
				<option value="DE">Delaware</option>
				<option value="DC">Dist of Columbia</option>
				<option value="FL">Florida</option>
				<option value="GA">Georgia</option>
				<option value="HI">Hawaii</option>
				<option value="ID">Idaho</option>
				<option value="IL">Illinois</option>
				<option value="IN">Indiana</option>
				<option value="IA">Iowa</option>
				<option value="KS">Kansas</option>
				<option value="KY">Kentucky</option>
				<option value="LA">Louisiana</option>
				<option value="ME">Maine</option>
				<option value="MD">Maryland</option>
				<option value="MA">Massachusetts</option>
				<option value="MI">Michigan</option>
				<option value="MN">Minnesota</option>
				<option value="MS">Mississippi</option>
				<option value="MO">Missouri</option>
				<option value="MT">Montana</option>
				<option value="NE">Nebraska</option>
				<option value="NV">Nevada</option>
				<option value="NH">New Hampshire</option>
				<option value="NJ">New Jersey</option>
				<option value="NM">New Mexico</option>
				<option value="NY">New York</option>
				<option value="NC">North Carolina</option>
				<option value="ND">North Dakota</option>
				<option value="OH">Ohio</option>
				<option value="OK">Oklahoma</option>
				<option value="OR">Oregon</option>
				<option value="PA">Pennsylvania</option>
				<option value="RI">Rhode Island</option>
				<option value="SC">South Carolina</option>
				<option value="SD">South Dakota</option>
				<option value="TN">Tennessee</option>
				<option value="TX">Texas</option>
				<option value="UT">Utah</option>
				<option value="VT">Vermont</option>
				<option value="VA">Virginia</option>
				<option value="WA">Washington</option>
				<option value="WV">West Virginia</option>
				<option value="WI">Wisconsin</option>
				<option value="WY">Wyoming</option>
			</select></div>
			<div>
				<label>Zip Code:</label>
				<input name="zipcode" type="text">
			</div>	
			
				<input type = "hidden" name = "action" value = "add"/>
				<input type="submit" value="Save">
				<input type="button" value="Reset">
			
		</form>
	</div>
		
	<jsp:include page="../partials/footer.jsp"/>
	<jsp:include page="../partials/commonScripts.jsp"/>
</body>
</html>
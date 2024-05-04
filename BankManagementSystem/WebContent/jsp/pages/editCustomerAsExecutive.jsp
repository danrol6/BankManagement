<!DOCTYPE HTML>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en-us">
<head>
	<jsp:include page="../partials/header.jsp"/>
</head>

<body class="body-with-nav">
	<jsp:include page="../partials/navExecutives.jsp"/>
	
	<h1 class="text-center">View/Edit Customer</h1>
	<div class="d-flex flex-row bg-light">
		<div class="p-3 border border-dark" >
			<form name ="createCustomers" onsubmit="" action="${pageContext.request.contextPath}/customers/edit" method="post">
				<div><label>Customer ID:</label>
					<input name="id" type="text" readonly required="required" value="${customer.id}"></div>
				<div><label>First Name:</label>
					<input name="firstName" type="text" required="required" value="${customer.firstName}"></div>
				<div><label>Last Name:</label>
					<input name="lastName" type="text" required="required" value="${customer.lastName}"></div>
				<div><label>SSN:</label>
					<input name="ssn" type="text" readonly value="${customer.ssn}"></div>
				<div><label>DOB:</label>
					<input  name="dob" type="text" readonly value="${customer.dob }"></div>
				<div><label>Address Line 1:</label>
					<input name="addressLine1" type="text" required="required" value="${customer.addressLine1 }"></div>
				<div><label>Address Line 2:</label>
					<input name="addressLine2" type="text" value="${customer.addressLine2 }"></div>
				<div><label>City:</label>
					<input  name="city" type="text" required="required" value="${customer.city}"></div>
				<div><label>State:</label>
				<select name="state" size="1">
				  <option value="AL" ${customer.state == 'AL' ? 'selected' : '' }>Alabama</option>
				  <option value="AK" ${customer.state == 'AK' ? 'selected' : '' }>Alaska</option>
				  <option value="AZ" ${customer.state == 'AZ' ? 'selected' : '' }>Arizona</option>
				  <option value="AR" ${customer.state == 'AR' ? 'selected' : '' }>Arkansas</option>
				  <option value="CA" ${customer.state == 'CA' ? 'selected' : '' }>California</option>
				  <option value="CO" ${customer.state == 'CO' ? 'selected' : '' }>Colorado</option>
				  <option value="CT" ${customer.state == 'CT' ? 'selected' : '' }>Connecticut</option>
				  <option value="DE" ${customer.state == 'DE' ? 'selected' : '' }>Delaware</option>
				  <option value="DC" ${customer.state == 'DC' ? 'selected' : '' }>Dist of Columbia</option>
				  <option value="FL" ${customer.state == 'FL' ? 'selected' : '' }>Florida</option>
				  <option value="GA" ${customer.state == 'GA' ? 'selected' : '' }>Georgia</option>
				  <option value="HI" ${customer.state == 'HI' ? 'selected' : '' }>Hawaii</option>
				  <option value="ID" ${customer.state == 'ID' ? 'selected' : '' }>Idaho</option>
				  <option value="IL" ${customer.state == 'IL' ? 'selected' : '' }>Illinois</option>
				  <option value="IN" ${customer.state == 'IN' ? 'selected' : '' }>Indiana</option>
				  <option value="IA" ${customer.state == 'IA' ? 'selected' : '' }>Iowa</option>
				  <option value="KS" ${customer.state == 'KS' ? 'selected' : '' }>Kansas</option>
				  <option value="KY" ${customer.state == 'KY' ? 'selected' : '' }>Kentucky</option>
				  <option value="LA" ${customer.state == 'LA' ? 'selected' : '' }>Louisiana</option>
				  <option value="ME" ${customer.state == 'ME' ? 'selected' : '' }>Maine</option>
				  <option value="MD" ${customer.state == 'MD' ? 'selected' : '' }>Maryland</option>
				  <option value="MA" ${customer.state == 'MA' ? 'selected' : '' }>Massachusetts</option>
				  <option value="MI" ${customer.state == 'MI' ? 'selected' : '' }>Michigan</option>
				  <option value="MN" ${customer.state == 'MN' ? 'selected' : '' }>Minnesota</option>
				  <option value="MS" ${customer.state == 'MS' ? 'selected' : '' }>Mississippi</option>
				  <option value="MO" ${customer.state == 'MO' ? 'selected' : '' }>Missouri</option>
				  <option value="MT" ${customer.state == 'MT' ? 'selected' : '' }>Montana</option>
				  <option value="NE" ${customer.state == 'NE' ? 'selected' : '' }>Nebraska</option>
				  <option value="NV" ${customer.state == 'NV' ? 'selected' : '' }>Nevada</option>
				  <option value="NH" ${customer.state == 'NH' ? 'selected' : '' }>New Hampshire</option>
				  <option value="NJ" ${customer.state == 'NJ' ? 'selected' : '' }>New Jersey</option>
				  <option value="NM" ${customer.state == 'NM' ? 'selected' : '' }>New Mexico</option>
				  <option value="NY" ${customer.state == 'NY' ? 'selected' : '' }>New York</option>
				  <option value="NC" ${customer.state == 'NC' ? 'selected' : '' }>North Carolina</option>
				  <option value="ND" ${customer.state == 'ND' ? 'selected' : '' }>North Dakota</option>
				  <option value="OH" ${customer.state == 'OH' ? 'selected' : '' }>Ohio</option>
				  <option value="OK" ${customer.state == 'OK' ? 'selected' : '' }>Oklahoma</option>
				  <option value="OR" ${customer.state == 'OR' ? 'selected' : '' }>Oregon</option>
				  <option value="PA" ${customer.state == 'PA' ? 'selected' : '' }>Pennsylvania</option>
				  <option value="RI" ${customer.state == 'RI' ? 'selected' : '' }>Rhode Island</option>
				  <option value="SC" ${customer.state == 'SC' ? 'selected' : '' }>South Carolina</option>
				  <option value="SD" ${customer.state == 'SD' ? 'selected' : '' }>South Dakota</option>
				  <option value="TN" ${customer.state == 'TN' ? 'selected' : '' }>Tennessee</option>
				  <option value="TX" ${customer.state == 'TX' ? 'selected' : '' }>Texas</option>
				  <option value="UT" ${customer.state == 'UT' ? 'selected' : '' }>Utah</option>
				  <option value="VT" ${customer.state == 'VT' ? 'selected' : '' }>Vermont</option>
				  <option value="VA" ${customer.state == 'VA' ? 'selected' : '' }>Virginia</option>
				  <option value="WA" ${customer.state == 'WA' ? 'selected' : '' }>Washington</option>
				  <option value="WV" ${customer.state == 'WV' ? 'selected' : '' }>West Virginia</option>
				  <option value="WI" ${customer.state == 'WI' ? 'selected' : '' }>Wisconsin</option>
				  <option value="WY" ${customer.state == 'WY' ? 'selected' : '' }>Wyoming</option>
				</select></div>
				<div><label>Zip Code:</label>
					<input name="zipcode" type="text" required="required" value="${ customer.zipcode}"></div>
				<br><br>	
				<div>
				<input type="hidden" name ="action" value="update"/>
				<input type="button" value="Cancel">
				<input type="submit" value="Save">
				</div>
			</form>
		</div>
		<div  class="p-5" >
		
		<c:if test="${ accounts != null and accounts.size() != 0 }">
		<!--Accounts Table  -->
		<div >
		<h2>Accounts</h2>
			<table style="width:100%">
			 <thead> <tr>
			    <th>Account ID</th>
			    <th>Account Type</th> 
			    <th>Account Status</th>
			    <th>Balance</th>
			    <th>Last Transaction</th>
			    <th>Action</th>
			  </tr>
			  </thead>
			  <tbody>
		  <c:forEach var="account" items="${accounts}"> 
		  	<tr>
		  	<td><c:out value = "${account.accountId}"/></td>
		  	<td><c:out value = "${account.accountType}"/></td>
		  	<td><c:out value = "${account.status}"/></td>
		  	<td><c:out value = "${account.balance}"/></td>
		  	<td><c:out value = "${account.lastTransaction}"/></td>
		  	<c:choose>
		  	<c:when test ='${account.status == "Closed"}'>
		  	<td><form id="close" method="post" action="${pageContext.request.contextPath}/executiveAccount?accountId=${account.accountId }&action=update&status=Open"><a href="#" onclick="document.getElementById('close').submit();">Re-open</a></form></td>
		  	</c:when>
		  	<c:otherwise>
		  	<td><form id="open" method="post" action="${pageContext.request.contextPath}/executiveAccount?accountId=${account.accountId }&action=update&status=Closed"><a href="#" onclick="document.getElementById('open').submit();">Close</a></form></td>
		  	</c:otherwise>
		  	</c:choose>
		  	</tr>
		  	<%-- <td><c:out value = "${account.action}"/></td> --%>
		  </c:forEach>
		  </tbody>
		</table>
		</div>
		
		</c:if>
		<!-- Create Account -->
		
		<form id="account" action="${pageContext.request.contextPath}/executiveAccount?customerId=${customer.id}&action=show" method="post">
		<a class="btn btn-primary" href="#" onclick="document.getElementById('account').submit();">Create Account</a>	
		</form>	
		</div>
	</div>
	
	
	<jsp:include page="../partials/footer.jsp"/>
	<jsp:include page="../partials/commonScripts.jsp"/>
</body>
</html>
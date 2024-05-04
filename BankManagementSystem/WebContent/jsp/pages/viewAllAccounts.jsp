<!DOCTYPE HTML>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en-us">
<head>
	<jsp:include page="../partials/header.jsp"/>
	<link rel="stylesheet" href="../../css/viewAccExec.css">
</head>

<body class="body-with-nav">
	<jsp:include page="../partials/navTellers.jsp"/>
	
	<!-- Top -->
	<div class="page-title">
		<h1>Customer</h1>
		<h2>Accounts</h2>
	</div>
	
	<!-- idk how to call this below -->
	<script>
	function censorSSN(s) {
		return "XXX-XX-"+s.substring(7);
	}
	</script>
	
	<!-- left side customer div -->
	<div class="left-customer">
		<label>Customer ID</label> 
		<p>${customer.id}</p>
		<label>First Name</label>
		<p>${customer.firstName}</p>
		<label>Last Name</label>
		<p>${customer.lastName}</p>
		
		<!-- i want to censor this with censorSSN(str) but idk how -->
		<label>SSN</label>
		<p>${customer.ssn}</p>
		
		<label>DOB</label>
		<p>${customer.dob}</p>
		<label>Address Line 1</label>
		<p>${customer.addressLine1}</p>
		<label>Address Line 2</label>
		<p>${customer.addressLine2}</p>
		<label>City</label>
		<p>${customer.city}</p>
		<label>State</label>
		<p>${customer.state}</p>
		<label>Zip Code</label>
		<p>${customer.zipcode}</p>
	</div>
	
	
	<div class="right-accounts">
	<table>
	<thead>
	<tr>
		<th>Account ID</th>
		<th>Account Type</th>
		<th>Account Status</th>
		<th>Balance</th>
		<th>Last Transaction</th>
		<!--<th>Actions</th>-->
	</tr>
	</thead>
	<tbody>
	<c:forEach var="acc" items="${accounts}">
		   <tr>
		      <td>
				<c:out value="${acc.accountId}"/>
			  </td>
			  <td>
				<c:out value="${acc.accountType}"/>
			  </td>
			  <td>
				<c:out value="${acc.status}"/>
			  </td>
			  <td>
			  	<c:out value="${acc.balance}"/>
			  </td>
			  <td>
			  	<c:out value="${acc.lastTransaction}"/>
			  </td>
			  <!-- in other file -->
			  <!--
			  <td>
			    <c:if test="${acc.status == 'Open'}">
			  	  <a class="button">Transaction</a>
			  	  <a class="button">Statements</a>
			  	</c:if>
			  </td>
			  -->
		   </tr>
	</c:forEach>
	
	</tbody>
	</table>
	</div>
	
	<div>
		<a href="../jsp/pages/homeExecutives.jsp" class="back-button">Back</a>
	</div>
	
	<jsp:include page="../partials/footer.jsp"/>
	<jsp:include page="../partials/commonScripts.jsp"/>
</body>
</html>
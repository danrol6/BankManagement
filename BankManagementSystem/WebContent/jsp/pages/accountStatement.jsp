<!DOCTYPE HTML>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en-us">
<head>
	<jsp:include page="../partials/header.jsp"/>
</head>

<body class="body-no-nav">
	<!--  Header -->
	<div class="container-fluid text-center text-white bg-primary py-2">
		<a>Banking Management System</a>
	</div>
	
	<!-- Content -->
	<div class="container-fluid text-center bg-white">
		<!-- Content title -->
		<div class="container-fluid text-center bg-white pt-2">
			<h1 class="text-primary">Account Statement</h1>
			<h4>Account ID: <label id="accountLabel" id="accountLable" action=${pageContext.request.contextPath}/accounts/view/></h4>
		</div>
		<!-- Rows for each attribute -->
		<form id="form" name="form" action="${pageContext.request.contextPath}/accounts/view" method="POST" onSubmit="displayTable();">
			<div class="row form group pt-2 pb-2">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<label for="latest">Latest Transactions</label>
					<input type="radio" onclick="javascript:yesnoCheck();" name="searchType" id="latest" value="latest"><br>
					<label for="range">Start->End Date</label>
					<input type="radio" onclick="javascript:yesnoCheck();" name="searchType" id="range" value="range"><br>
				</div>
				<div class="col-sm-3"></div>
			</div>
			<div class="row form group pt-2 pb-2" align="Center">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<label id="transactionLabel" id="transactionLabel">Select number of previous transactions:</label>
					<select name="lastNumber" id="lastNumber">
						<option value="one">1</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
						<option value="five">5</option>				
					</select>
				</div>
				<div class="col-sm-3"></div>
			</div>
			
			<div class="row form group pt-2 pb-2">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<label id="startDate" for="startDate">Start Date: <input type="date" name="startEnd" id="startDate" value="startDate"><br></label>
					<label id="endDate" for="endDate">End Date: <input type="date" name="startEnd" id="endDate" value="endDate"><br></label>
				</div>
				<div class="col-sm-3"></div>
			</div>
			<!-- Row containing the login button -->
			<div class="row">
				<div class="col-sm-12 pt-2 pb-4">
					<input type="hidden" name="role" value="accountStatement"></input>
					<input class="btn btn-primary btn-lg" type="submit" value="Submit"></input>
				</div>
			</div>
		</form>
	</div>
	
	<div id="acctTransactions" class="container-fluid text-center bg-white">
		<h2>Accounts</h2>
			<table style="width:100%">
				<thead> 
					<tr>
						<th>Account ID</th>
					    <th>Account Type</th> 
					    <th>Account Status</th>
					    <th>Balance</th>
					    <th>Last Transaction</th>
					    <th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="obj" items="${accounts}">
						<td><c:out value = "${account.accountId}"/></td>
						<td><c:out value = "${account.accountType}"/></td>
						<td><c:out value = "${account.accountStatus}"/></td>
						<td><c:out value = "${account.balance}"/></td>
						<td><c:out value = "${account.lastTransaction}"/></td>
						<td><c:out value = "${account.action}"/></td>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
	<!-- Footer -->
	<footer class="fixed-bottom container-fluid text-center text-white bg-primary py-2">
		<a>Team Thanos copyright &copy; <script type="text/javascript">document.write(new Date().getFullYear());</script></a>
	</footer>
	
	<jsp:include page="../partials/footer.jsp"/>
	<jsp:include page="../partials/commonScripts.jsp"/>
</body>
<!-- Script sources -->
	<script type="text/javascript">
		window.onload = function() {
		    document.getElementById('lastNumber').style.display = 'none';
		    document.getElementById('startDate').style.display = 'none';
		    document.getElementById('endDate').style.display = 'none';
		    document.getElementById('acctTransactions').style.display = 'none';
		    document.getElementById('transactionLabel').style.display = 'none';
		}
		function yesnoCheck(){
			if(document.getElementById('latest').checked){
				document.getElementById('lastNumber').style.display = 'block';
				document.getElementById('transactionLabel').style.display = 'block';
				document.getElementById('startDate').style.display = 'none';
				document.getElementById('endDate').style.display = 'none';
			} else {
				document.getElementById('transactionLabel').style.display = 'none';
				document.getElementById('lastNumber').style.display = 'none';
				document.getElementById('startDate').style.display = 'block';
				document.getElementById('endDate').style.display = 'block';
			}
		}
		function displayTable(){
			document.getElementById('acctTransactions').style.display = 'block';
		}
	</script>
	<script src="C:/Programming/Workspace/BankManagementSystem/WebContent/js/jquery-3.2.1.slim.min.js"></script>
	<script src="C:/Programming/Workspace/BankManagementSystem/WebContent/js/popper.min.js"></script>
	<script src="C:/Programming/Workspace/BankManagementSystem/WebContent/js/bootstrap.min.js"></script>
</html>
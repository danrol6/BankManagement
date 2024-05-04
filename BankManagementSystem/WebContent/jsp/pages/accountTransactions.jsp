<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en-us">
<head>
	<jsp:include page="../partials/header.jsp"/>
	<title>Customer Status</title>
</head>
<style>
	#transfer{
		display: none;
		text-align:center;
		float:right;
	}
	#transfer2{
		display: none;
		text-align:center;
	}
	#withdraw{
		display:none;
		text-align:center;
	}
	#deposit{
		display:none;
		text-align:center;
	}
	table{
		text-align:center;
	}
	.transactionTable{
		background-color: #FFFF;
	}
	#centerTable{
		display:inline-block; 
		background-color:white;
		width: 50%;
		margin: 0 auto;
	}
	h1{
		text-align:center;
	}
</style>
<body class="body-with-nav">
	<jsp:include page="../partials/navExecutives.jsp"/>
	
	<h1>Account Transactions</h1>
	<div style="text-align:center; background-color:white">
		<div id="centerTable">
			<form name="accountTransaction" action="${pageContext.request.contextPath}/accounts/edit" method="post" onSubmit="">
				<table class="transactionTable">
					<tbody>
						<tr>
							<td>
								<label>Customer Name:</label>
							</td>
							<td>
								<input type="text" name="customerName" readonly value = "${customer.firstName} ${customer.lastName}">
							</td>
						</tr>
						
						<tr>
							<td>
								<label>Customer ID:</label> 
							</td>	
							<td>
								<input type="number" name="customerId" readonly value = "${customer.id}">
							</td>
						</tr>
						<tr>													
							<td>
								<label>Account:</label>
							</td>
							<td>
								<input type="number" name="customerAccountNo" readonly value = "${account.id}"/>
							</td>
						</tr>
						
						<tr>
							<td>
								<label>Account Type:</label>
							</td>
							<td>
								<input type="text" name="customerAccountType" readonly value = "${account.type}">
							</td>
						</tr>
						
						<tr>
							<td>
								<label>Transaction Type:</label>
							</td>
							<td>
								<select id="transactionType" name="transactionType" onload="revealElements()" onchange="revealElements()" required="required">
									<option value="deposit">Deposit</option>
									<option value="withdraw">Withdraw</option>
									<option value="transfer">Transfer</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<td>
								<label>Balance:</label>
							</td>
							<td>
								$<input type="text" name="customerAccountBalance" readonly value="${account.balance}">
							</td>
						</tr>
						
					</tbody>
				</table>
				<table class="transactionTable">
					<tr id="transfer2">
							<td style="text-align:center">
								<label>Transfer Account:</label>
							</td>
							<td style="text-align:center">
								<select name="transferAccount" id="transferAccount">
									<!-- Loops through customer accounts -->
									<c:forEach var="account" items="${accounts}">
										<!-- calls js function that adds an option for each account -->
										<script>transferDropdown(${account.id}, ${account.name})</script>
									</c:forEach>
								</select>								
							</td>
						</tr>
				</table>
				<table class="transactionTable">
						<tr id="deposit">
							<td style="text-align:center">
								<label>Deposit Amount: </label>							
							</td>
							<td style="text-align:center">							
								<input type="number" min="0" name="depositAmount" required="required">
							</td>	
						</tr>
						
						<tr id="withdraw">
							<td style="text-align:center">
								<label>Withdraw Amount:</label>							
							</td>
							<td style="text-align:center">							
								<input type="number" min="0" name="withdrawAmount" required="required">
							</td>	
						</tr>
						
						<tr id="transfer">
							<td style="text-align:center">
								<label>Transfer Amount:</label>								
							</td>
							<td style="text-align:center">							
								<input type="number" min="0" name="transferAmount" required="required">
							</td>	
						</tr>
				</table>
			
			<input type="hidden" name="customerId" value="${customer.id}" >
			
			<button name="action" value="cancel" onClick="${pageContext.request.contextPath}/accounts/view">Cancel</button>
			<button name="action" value="update" onClick="${pageContext.request.contextPath}/accounts/edit">Do Transaction</button>
			
			</form>
		</div>
	</div>
	
	<jsp:include page="../partials/footer.jsp"/>
	<jsp:include page="../partials/commonScripts.jsp"/>
	<script type="text/javascript">
	function revealElements(){
		var checkOption = document.getElementById('transactionType');
		
		if(checkOption.value == 'transfer'){
			document.getElementById('transfer').style.display = "inline-block";
			document.getElementById('transfer2').style.display = "inline-block";
		}
		else{
			document.getElementById('transfer').style.display = "none";
			document.getElementById('transfer2').style.display = "none";
		}
			
		if(checkOption.value == 'withdraw'){
			document.getElementById('withdraw').style.display = "inline-block";
		}
		else{
			document.getElementById('withdraw').style.display = "none";
		}
			
		if(checkOption.value == 'deposit'){
			document.getElementById('deposit').style.display = "inline-block";
		}
		else{
			document.getElementById('deposit').style.display = "none";
		}

	}
	
	// Auto-Populates Dropdown list - First one is for testing
	/* function transferDropdown(list){
		var select, i, option;
		var accountsList = list;
		
		select = document.getElementById('transferAccount');
		for(i = 0; i <= list;  i+= 1){
			option = document.createElement('option');
			option.text =  i;
			option.value = option.text;
			option.innerText = "Hello";
			select.add(option);
		}
	} */
	
	function transferDropdown(account, accountName){
		var select, i, option;
		var accountPrint = account;
		var accountNamePrint = accountName;
		
		select = document.getElementById('transferAccount');
		option = document.createElement('option');
		option.text = accountPrint;
		option.value = option.text;
		option.innerText = accountPrint + " " + accountNamePrint;
		select.add(option);
	} 
	
	window.onload=revealElements;
</script>
</body>
</html>
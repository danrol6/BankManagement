	<!-- Search bar -->
	<div class="search-form">
		<!--
		PUT THIS IN THE FORM TAG BELOW
		action="${pageContext.request.contextPath}/ENTER_PATH_HERE"
		-->
		<form action="${pageContext.request.contextPath}/customers/view" name="viewCustomers" method = "post" onsubmit="">
			<select name="searchBy" required="required">
				<option value="SearchBySSN">SSN</option>
				<option value="SearchByCustomerId">Customer ID</option>
				<option value="SearchByLastName">Last Name</option>
			</select>
			<input type="text" name="searchValue"/>
			<input type="hidden" name="action" value="search"/>
			<input type="submit" value="Search"/>
		</form>
	</div>
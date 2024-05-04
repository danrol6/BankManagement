	<!-- Navbar for Teller view -->
	<nav class="navbar navbar-expand-sm fixed-top navbar-dark bg-primary">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- Navbar inner menu -->
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item">
					<!-- href="${pageContext.request.contextPath}/accounts/view" -->
					<a class="nav-link h6 text-light" href="${pageContext.request.contextPath}/jsp/pages/viewAccounts.jsp">View Accounts</a>
				</li>
				<li class="nav-item">
					<!-- href="${pageContext.request.contextPath}/customers/view" -->
					<a class="nav-link h6 text-light" href="${pageContext.request.contextPath}/jsp/pages/viewCustomers.jsp">View Customers</a>
				</li>
			</ul>
		</div>
	</nav>
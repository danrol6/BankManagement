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
			<h1 class="text-primary">Login</h1>
		</div>
		<!-- Rows for each attribute -->
		<form id="form" name="form" action="${pageContext.request.contextPath}/login" method="POST" onSubmit="">
			<div class="row form group pt-2 pb-2">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<input type="text" class="form-control border border-primary" name="username" placeholder="Username" required="required">
				</div>
				<div class="col-sm-3"></div>
			</div>
			<div class="row form group pt-2 pb-2">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<input type="password" class="form-control border border-primary" name="password" placeholder="Password" required="required">
				</div>
				<div class="col-sm-3"></div>
			</div>
			<!-- Row containing the login button -->
			<div class="row">
				<div class="col-sm-12 pt-2 pb-4">
					<input class="btn btn-primary btn-lg" type="submit" value="Login"></input>
				</div>
			</div>
		</form>
	</div>
	
	<jsp:include page="../partials/footer.jsp"/>
	<jsp:include page="../partials/commonScripts.jsp"/>
</body>
</html>
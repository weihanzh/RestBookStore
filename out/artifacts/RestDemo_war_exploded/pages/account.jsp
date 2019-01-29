<!DOCTYPE html>
<html>
<head>
<title>Account</title>
	<!-- Custom Theme files -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //Custom Theme files -->
	<link href="../css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
	<link href="../css/style.css" type="text/css" rel="stylesheet" media="all">
	<!-- js -->
	<script src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap-3.1.1.min.js"></script>
	<!-- //js -->
</head>
<body>
	<%@ include file="header.jsp" %>
	<!--//single-page-->
		<div class="container">
			<div class="register">
				<div class="col-md-12 single-grid1">
					<h2>Account</h2>
					<ul>
						<li><h4>Name</h4><p>${user.firstname} ${user.lastname}</p></li>
						<li><h4>Email</h4><p>${user.username}</p></li>
						<li><h4>Tel</h4><p>${address.phone}</p></li>
						<li><h4>Country</h4><p>${address.country}</p></li>
						<li><h4>Province</h4><p>${address.province}</p></li>
						<li><h4>Street</h4><p>${address.street}</p></li>
						<li><h4>Zip Code</h4><p>${address.zip}</p></li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>

	<!-- collapse -->

	<!--footer-->
	<%@ include file="../pages/footer.jsp" %>
	<!--footer-->
</body>
</html>
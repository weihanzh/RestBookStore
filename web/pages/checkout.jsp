<!DOCTYPE html>
<html>
<head>
	<title>Check Out</title>
	<!-- Custom Theme files -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //Custom Theme files -->
	<link href="../css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
	<link href="../css/style.css" type="text/css" rel="stylesheet" media="all">
	<link href="../css/cmxform.css" type="text/css" rel="stylesheet" media="all">
	<!-- js -->
	<script src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap-3.1.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.js"></script>
	<script type="text/javascript" src="../js/form-validation.js"></script>
	<script type="text/javascript" src="../js/additional-methods.min.js"></script>
	<!-- //js -->
	<!-- cart -->
	<script src="../js/simpleCart.min.js"> </script>
	<!-- cart -->
</head>
<body>
	<%@ include file="header.jsp" %>
	<!--account-->
	<div class="account">
		<div class="container">
			<div class="register">
			   <form action="/ConfirmOrderServlet" method="post" id="creditForm" name="creditForm">
				   <div class="register-top-grid">
					   <h3>Payment Information</h3>
					   <div class="input col-lg-12">
						   <span>Credit Card Account: </span>
						   <input type="text" name="credit_account" required>
					   </div>
					   <div class="input col-lg-12">
						   <span>Credit Card Name</span>
						   <input type="text" name="credit_name" required>
					   </div>
					   <h3>Shipping information</h3>
					   <div class="input col-lg-12">
						   <p>Name: <span>${user.firstname} ${user.lastname}</span></p>
						   <p>Tel: <span>${address.phone}</span></p>
						   <p>Address: <span>${address.street}, ${address.province}, ${address.zip}, ${address.country}</span></p>
					   </div>
					   <div class="clearfix"> </div>
				   </div>
				   <div class="register-but col-lg-12">
					   <input type="submit" value="Pay" name="pay_submit">
				   </div>
				   <div class="clearfix"> </div>
			   </form>
			</div>
		</div>
	</div>
	<!--//account-->
	<!--footer-->
	<%@ include file="../pages/footer.jsp" %>
	<!--//footer-->
</body>
</html>
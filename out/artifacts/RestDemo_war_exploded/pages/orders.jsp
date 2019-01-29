<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>My Orders</title>
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
		<div class="order">
			<div class="col-lg-12 single-grid1">
				<h2>My Order</h2>
				<c:forEach items = "${orderEntityList}" var = "i">
					<div class="col-lg-12 order-list">
						<div class="col-lg-2">
							<h4>Order ID : </h4>
							<p>${i.orderEntity.id}</p>
						</div>
						<div class="col-lg-2">
							<h4>Order Placed : </h4>
							<p>${i.orderEntity.generationtime}</p>
						</div>
						<div class="col-lg-2">
							<h4>Quantity:</h4>
							<p>${i.orderEntity.amount}</p>
						</div>
						<div class="col-lg-2">
							<h4>Shipping:</h4>
							<p>${i.orderEntity.shipping}</p>
						</div>
						<div class="col-lg-2">
							<h4>Tax:</h4>
							<p>${i.orderEntity.tax}</p>
						</div>
						<div class="col-lg-2">
							<h4>Total Price (Before Tax): </h4>
							<p>${i.orderEntity.totalprice}</p>
						</div>
						<div class="col-lg-2">
							<h4>Total Price (After Tax):</h4>
							<p>${i.orderEntity.aftertaxprice}</p>
						</div>
						<div class="col-lg-2">
							<h4>Products Name : </h4>
							<c:forEach items="${i.bookEntityList}" var="j">
								<p>
									${j.title}
								</p>
							</c:forEach>
						</div>
						<div class="col-lg-2">
							<h4>Status : </h4>
							<p>${i.orderEntity.status}</p>
						</div>
					</div>
				</c:forEach>
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
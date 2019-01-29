<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Product Details</title>
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
	<script src="../js/imagezoom.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.js"></script>
	<script type="text/javascript" src="../js/form-validation.js"></script>
	<!-- //js -->
	<!-- cart -->
	<script src="../js/simpleCart.min.js"> </script>
	<!-- cart -->
	<!-- FlexSlider -->
	<script defer src="../js/jquery.flexslider.js"></script>
	<link rel="stylesheet" href="../css/flexslider.css" type="text/css" media="screen" />
<script>
	// Can also be used with $(document).ready()
	$(window).load(function() {
	  $('.flexslider').flexslider({
		animation: "slide",
		controlNav: "thumbnails"
	  });
	});
</script>
<!--//FlexSlider -->
</head>
<body>
	<%@ include file="header.jsp" %>
	<!--//single-page-->
	<div class="single">
		<div class="container">
			<div class="single-grids">				
				<div class="col-md-4 single-grid">
					<div class="flexslider">
						<ul class="slides">
							<li data-thumb="../images/bk1.png">
								<div class="thumb-image"> <img src="${detailinfo.imgUrl}" data-imagezoom="true" class="img-responsive"> </div>
							</li>
						</ul>
					</div>
				</div>
				<div class="col-md-8 single-grid simpleCart_shelfItem">
					<h3>${detailinfo.title}</h3>
					<div class="tag">
						<p>Author : ${detailinfo.author}</p>
						<p>Publish Year : ${detailinfo.publisherYear} </p>
					</div>
					<div class="galry">
						<div class="prices-left">
							<h5 class="item_price">$${detailinfo.price}</h5>
						</div>
						<div class="clearfix"></div>
					</div>
					<form action="/MyCartServlet" name="myCartForm" method="post" id="myCartForm">
						<p class="qty"> Qty :  </p><input min="1" type="number" id="quantity" name="quantity" class="form-control input-small">
						<div class="clearfix"> </div>
						<div class="btn_form">
							<button type="submit" class="add-cart item_add" name="add_to_cart">ADD TO CART</button>
						</div>
					</form>
					<div class="tag">
						<p>Category : ${detailCategory.category} </p>
					</div>
				</div>

				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!-- collapse -->
	<div class="collpse tabs">
		<div class="container">
			<div class="panel-group collpse" id="accordion" role="tablist" aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
							  Description
							</a>
						</h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							<p> ${detailinfo.description} </p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--//collapse -->

	<!--footer-->
	<%@ include file="../pages/footer.jsp" %>
	<!--footer-->

</html>
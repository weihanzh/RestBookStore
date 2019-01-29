<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
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
            <form method="post" action="/FrontControllerServlet" id="registerForm" name="registerForm">
                <input hidden="hidden" name="useraction" value="register">
                <div class="register-top-grid">
                    <h3>Personal information</h3>
                    <div class="input col-lg-12">
                        <span>First Name<label>*</label></span>
                        <input type="text" name="first_name" required>
                    </div>
                    <div class="input col-lg-12">
                        <span>Last Name<label>*</label></span>
                        <input type="text" name="last_name" required>
                    </div>
                    <div class="input col-lg-12">
                        <span>Email<label>*</label></span>
                        <input type="text" name="email" required>
                    </div>
                    <div class="input col-lg-6">
                        <span>Country<label>*</label></span>
                        <input type="text" name="country" required>
                    </div>
                    <div class="input col-lg-6">
                        <span>Province<label>*</label></span>
                        <input type="text" name="province" required>
                    </div>
                    <div class="input col-lg-12">
                        <span>Street<label>*</label></span>
                        <input type="text" name="street" required>
                    </div>
                    <div class="input col-lg-6">
                        <span>Zip Code<label>*</label></span>
                        <input type="text" name="zip" required>
                    </div>
                    <div class="input col-lg-6">
                        <span>Tel<label>*</label></span>
                        <input type="text" name="tel" required>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="register-top-grid">
                    <h3>Login information</h3>
                    <div class="input col-lg-12">
                        <span>Password<label>*</label></span>
                        <input type="password" name="password" id="password">
                    </div>
                    <div class="input col-lg-12">
                        <span>Confirm Password<label>*</label></span>
                        <input type="password" name="confirm_password" id="confirm_password">
                    </div>
                </div>
                <div class="register-but col-lg-12">
                    <input type="submit" value="Register" name="register">
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
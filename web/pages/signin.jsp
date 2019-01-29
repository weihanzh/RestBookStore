<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>
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
                <form action="/FrontControllerServlet" method="post" id="signInForm" name="signInForm">
                    <input hidden="hidden" name="useraction" value="login">
                    <div class="register-top-grid ">
                        <h3>Sign in</h3>
                        <div class="input col-lg-12">
                            <span>Email </span>
                            <input type="text" name="email" required>
                        </div>
                        <div class="input col-lg-12">
                            <span>Password</span>
                            <input type="password" name="password" required>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <p class="col-lg-12">New User ? <a class="sign" href="register.jsp">Register</a> </p>
                    <div class="register-but col-lg-12">
                        <input type="submit" value="submit" name="credit_submit">
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
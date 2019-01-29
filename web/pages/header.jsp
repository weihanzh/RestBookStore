<%@ page import="com.team404.bookstore.entity.UserEntity" %>
<!--header-->
<html>
    <script>
        <%
            UserEntity userEntity = (UserEntity) session.getAttribute("user");
        %>
    </script>
    <body>
        <div class="header">
            <div class="container">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <h1 class="navbar-brand"><a  href="/pages/index.jsp">Bookstore</a></h1>
                    </div>
                    <!--navbar-header-->
                    <div class=" navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="/pages/index.jsp">Home</a></li>
                            <li><a href="/pages/about.jsp">About Us</a></li>
                            <%
                                if (userEntity == null) {
                            %>
                            <li><a href="/pages/signin.jsp">Sign in</a></li>
                            <%
                                } else {
                            %>
                            <li><a href="/pages/account.jsp">Welcome ${user.firstname}</a></li>
                            <%
                                }
                            %>
                        </ul>
                    </div>
                    <!--//navbar-header-->
                </nav>
                <div class="header-info">
                    <div class="header-right login">
                        <a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
                        <div id="loginBox">
                            <div id="loginForm">
                                <p><a class="sign" href="/pages/account.jsp">My Account</a> </p>
                                <p><a class="sign" href="/DisplayOrdersServlet">My Orders</a> </p>
                                <p><a class="sign" href="/FrontControllerServlet?useraction=logout">Sign Out</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="header-right cart">
                        <a href="/DisplayShoppingCartServlet"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
    </body>
</html>
<!--//header-->
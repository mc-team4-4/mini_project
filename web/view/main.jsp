<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>


</style>



<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Home</title>

    <!-- Favicon  -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="css/core-style.css">
    <link rel="stylesheet" href="style.css">

	<!-- Main sign button CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="css/main_sign_button.css">
</head>

<body>

    <!-- Search Wrapper Area Start -->
    <div class="search-wrapper section-padding-100">
        <div class="search-close">
            <i class="fa fa-close" aria-hidden="true"></i>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="search-content">
                        <form action="#" method="get">
                            <input type="search" name="search" id="search" placeholder="Type your keyword...">
                            <button type="submit"><img src="img/core-img/search.png" alt=""></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Search Wrapper Area End -->

    <!-- ##### Main Content Wrapper Start ##### -->
    <div class="main-content-wrapper d-flex clearfix">


		<c:choose>
			<c:when test="${login_user_email == null }">
		        <!-- Mobile Nav (max width 767px)-->
		        <div class="mobile-nav">
		            <!-- Navbar Brand -->
		            <div class="amado-navbar-brand">
		                <a href="main.mc"><img src="img/core-img/logo.jpg" alt=""></a>
		            </div>
		            
		             <div class="main_sign_button">
			  			<a href="sign_in.mc" data-title="Sign in" id="sign"></a>
					</div>
					
		            <!-- Navbar Toggler -->
		            <div class="amado-navbar-toggler">
		                <span></span><span></span><span></span>
		            </div>
		        </div>
			</c:when>
			<c:otherwise>
		        <!-- Mobile Nav (max width 767px)-->
		        <div class="mobile-nav">
		            <!-- Navbar Brand -->
		            <div class="amado-navbar-brand">
		                <a href="main.mc"><img src="img/core-img/logo.jpg" alt=""></a>
		            </div>
		        
		             <div class="main_sign_button" style="margin-left: 20px">
			  			<a href="sign_out.mc" data-title="Logout" id="sign"></a>			
					</div>
									
		            <!-- Navbar Toggler -->
		            <div class="amado-navbar-toggler" style="margin-left: -20px">
		                <span></span><span></span><span></span>
		            </div>
		        </div>		
			</c:otherwise>
		</c:choose>





        <!-- Header Area Start -->
        <header class="header-area clearfix">
        
        	<c:choose>
				<c:when test="${login_user_email == null }">
   
		            <!-- Close Icon -->
		            <div class="nav-close">
		                <i class="fa fa-close" aria-hidden="true"></i>
		            </div>
		            <!-- Logo -->
		            <div class="logo">
		                <a href="main.mc"><img src="img/core-img/logo.jpg" alt=""></a>
		            </div>
		            
		            
		            <div class="main_sign_button">
			  			<a href="sign_in.mc" data-title="Sign in" id="sign"></a>			
					</div>
		            
		            
		            <!-- Amado Nav -->
		            <nav class="amado-nav" style="margin-bottom: 30px">
		                <ul>
		                    <li><a href="main.mc">Home</a></li>
		                </ul>
		            </nav>
		
		            <!-- Cart Menu -->
		            <div class="cart-fav-search mb-50">
		                <a href="#" class="search-nav"><img src="img/core-img/search.png" alt=""> Search</a>
		            </div>
				</c:when>
				<c:otherwise>
					<!-- Close Icon -->
		            <div class="nav-close">
		                <i class="fa fa-close" aria-hidden="true"></i>
		            </div>
		            <!-- Logo -->
		            <div class="logo">
		                <a href="main.mc"><img src="img/core-img/logo.jpg" alt=""></a>
		            </div>
		            
		            
		            <div class="main_sign_button">
			  			<a href="sign_out.mc" data-title="Logout" id="sign"></a>			
					</div>
					
		            <div>
		            	<br>
			  			 Welcome! ${login_user_email}
			  			<br><br>
					</div>
		            
		            
		            <!-- Amado Nav -->
		            <nav class="amado-nav" style="margin-bottom: 50px" >
		                <ul>
		                    <li><a href="main.mc">Home</a></li>
		                    <li><a href="cart.mc?">Shopping Cart</a></li>
		                    <li><a href="checkout.mc">Checkout</a></li>
		                    <li><a href="user_detail.mc">User Detail</a></li>
		                </ul>
		            </nav>
		
		            <!-- Cart Menu -->
		            <div class="cart-fav-search mb-50">
		                <a href="cart.mc" class="cart-nav"><img src="img/core-img/cart.png" alt=""> Cart</a>
		                <a href="#" class="fav-nav"><img src="img/core-img/favorites.png" alt=""> Favourite</a>
		                <a href="#" class="search-nav"><img src="img/core-img/search.png" alt=""> Search</a>
		            </div>	
				</c:otherwise>
			</c:choose>
        
        
        

            <!-- Social Button -->
            <div class="social-info d-flex justify-content-between">
                <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
            </div>
        </header>
        <!-- Header Area End -->
     
    	<!--Center Start -->
		<c:choose>
			<c:when test="${center != null }">
				<jsp:include page="${center }.jsp"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="main_product.jsp"/>	
			</c:otherwise>
		</c:choose>
		<!--Center End -->
    </div>
    
    <!-- ##### Main Content Wrapper End ##### -->


    <!-- ##### Footer Area Start ##### -->
    <footer class="footer_area clearfix">
        <div class="container">
            <div class="row align-items-center">
                <!-- Single Widget Area -->
                <div class="col-12 col-lg-4">
                    <div class="single_widget_area">
                        <!-- Logo -->
                        <div class="footer-logo mr-50">
                            <a href="main.mc"><img src="img/core-img/logo2.jpg" alt=""></a>
                        </div>
                        <!-- Copywrite Text --> 
                        <p class="copywrite"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made by Jihwan Choi with ACE Team  <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Samsung Multi Campus</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div>
                </div>
                <!-- Single Widget Area -->
                <div class="col-12 col-lg-8">
                    <div class="single_widget_area">
			            <c:choose>
							<c:when test="${login_user_email == null }">
								<!-- Footer Menu -->
		                        <div class="footer_menu">
		                            <nav class="navbar navbar-expand-lg justify-content-end">
		                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#footerNavContent" aria-controls="footerNavContent" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
		                                <div class="collapse navbar-collapse" id="footerNavContent">
		                                    <ul class="navbar-nav ml-auto">
		                                        <li class="nav-item active">
		                                            <a class="nav-link" href="main.mc">Home</a>
		                                        </li>
		                                    </ul>
		                                </div>
		                            </nav>
		                        </div>
							</c:when>
							<c:otherwise>
		                        <!-- Footer Menu -->
		                        <div class="footer_menu">
		                            <nav class="navbar navbar-expand-lg justify-content-end">
		                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#footerNavContent" aria-controls="footerNavContent" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
		                                <div class="collapse navbar-collapse" id="footerNavContent">
		                                    <ul class="navbar-nav ml-auto">
		                                        <li class="nav-item active">
		                                            <a class="nav-link" href="main.mc">Home</a>
		                                        </li>
		                                        <li class="nav-item">
		                                            <a class="nav-link" href="cart.mc">Shopping Cart</a>
		                                        </li>
		                                        <li class="nav-item">
		                                            <a class="nav-link" href="checkout.mc">Checkout</a>
		                                        </li>
		                                         <li class="nav-item">
		                                            <a class="nav-link" href="user_detail.mc">User Detail</a>
		                                        </li>
		                                    </ul>
		                                </div>
		                            </nav>
		                        </div>		
							</c:otherwise>
					</c:choose>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- ##### Footer Area End ##### -->

    <!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="js/plugins.js"></script>
    <!-- Active js -->
    <script src="js/active.js"></script>
    <!-- Main sign button js -->
    <script  src="js/main_sign_button.js"></script>
    

</body>

</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Sign up</title>
	<meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="img/sign_in_up_icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<!-- 	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css"> -->
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/sign_in_up_util.css">
	<link rel="stylesheet" type="text/css" href="css/sign_in_up_main.css">
<!--===============================================================================================-->
</head>
<body>
	 
	<div class="limiter">
		<div class="container-login100" style="background-image: url('img/bg-01.jpg');">
			<div class="wrap-login100">
				<form class="login100-form validate-form" method="POST" action="user_detail_impl.mc">
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
					</span>
					<span class="login100-form-title p-b-34 p-t-27">
						User Detail
					</span>
					
					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" name="email" placeholder="E-mail" readonly="readonly" value="${user_email}">
						<span class="focus-input100" data-placeholder="&#x2709;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter Current Password">
						<input class="input100" type="password" name="password_current" placeholder="Current Password">
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Enter New Password">
						<input class="input100" type="password" name="password" placeholder="New Password">
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Enter Password Confirm">
						<input class="input100" type="password" name="password_confirm" placeholder="Password Confirm">
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Enter Name">
						<input class="input100" type="text" name="name" placeholder="Name" value="${user_name}">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter Phone Number">
						<input class="input100" type="text" name="phone_number" placeholder="Phone Number"  value="${user_phone_number}">
						<span class="focus-input100" data-placeholder="&#x2706;"></span>
					</div>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" name="status" placeholder="Status" readonly="readonly" value="${user_status}">
						<span class="focus-input100" data-placeholder="&#x1f69a;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Enter Address">
						<input class="input100" type="text" name="address" placeholder="Address" value="${user_address}">
						<span class="focus-input100" data-placeholder="&#x1F3E0;"></span>
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">Modify</button>
						
						<button class="login100-form-btn">Withdrawal</button>
					</div>

				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/sign_in_up_main.js"></script>

</body>
</html>

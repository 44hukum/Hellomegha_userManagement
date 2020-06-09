<%@page import="com.hellomegha.databasequeries.DatabaseConnection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="dataAccessLayer.ReadTable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!--important meta tags-->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, inital-scale=1">

	<!--Title-->
	<title>SAD Usermanagement</title>

	<!--Icon-->
	<link rel="shortcut icon" href="img/logo/logo.png">

	<!--Google Fonts-->
	<link href="https://fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&display=swap" rel="stylesheet">

	<!--Font awesome-->
	<link rel="stylesheet" type="text/css" href="css/font-awesome/css/font-awesome.min.css">

	<!--Bootstrap CSS-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.css">

	<!--Owl carousel CSS-->
	<link rel="stylesheet" type="text/css" href="css/owl-carousel/owl.carousel.css">
	<link rel="stylesheet" type="text/css" href="css/owl-carousel/owl.carousel.min.css">
	<link rel="stylesheet" type="text/css" href="css/owl-carousel/owl.theme.default.min.css">

	<!--responsive tabs-->
	<link rel="stylesheet" type="text/css" href="css/responsive-tabs/responsive-tabs.css">

	<!--magnific popup-->
	<link rel="stylesheet" type="text/css" href="css/magnific-popup/magnific-popup.css">

	<!--Custom CSS-->
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/user.css">
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="65">
<%
     if(session.getAttribute("error") !=null){
          String error=(String)session.getAttribute("error");
         
     %>
     <h3>
         <%=error%>
     </h3>
    <%
        session.removeAttribute("error");
         }

if(session.getAttribute("username") == null){
%>
 
<!--code by ishan-->

	<!--Preloader-->
	<div id="preloader">
		<div id="status">
			&nbsp;
		</div>
	</div>

	<!--Header-->
	<header>
		<nav class="navbar navbar-fixed-top">
			<div class="container-fluid">
				<div class="site-nav-wrapper">
					<div class="navbar-header">

						<!--Logo
						<a href="#home" class="navbar-brand smooth-scroll">
							<img src="img/logo/logo.png" alt="Logo">
						</a>-->
					</div>

					<!--Main menu-->
					<div class="container">
						<div class="collapse navbar-collapse"> 
							<ul class="nav navbar-nav pull-right">
								<li><a class="smooth-scroll" href="#home">Home</a></li>
								<li><a class="smooth-scroll" href="#"></a></li>
								<li><a class="smooth-scroll" href="#"></a></li>
								<li><a class="smooth-scroll" href="#about">About</a></li>
								<li><a class="smooth-scroll" href="#"></a></li>
								<li><a class="smooth-scroll" href="#"></a></li>
								<li><a class="smooth-scroll" href="#team">Team</a></li>
								<li><a class="smooth-scroll" href="#"></a></li>
								<li><a class="smooth-scroll" href="#"></a></li>
								<li><a class="smooth-scroll" href="#"></a></li>
								<li><a class="smooth-scroll" href="#"></a></li>
								<li><a class="smooth-scroll" href="#"></a></li>
								<li><a class="smooth-scroll" href="#"></a></li>
								<li><a class="smooth-scroll" href="#"></a></li>
								<li><a class="smooth-scroll" href="#"></a></li>
								<li><a class="smooth-scroll" href="#user_options-forms">Login</a></li>
								<li><a class="smooth-scroll" href="#user">Signup</a></li>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</nav>
	</header>
	<!--Header ends-->

	<!--Home-->
	<section id="home">
		<!--background image-->
		
		<img src="img/background/bg1.jpg" id="home-bg-image">

		<!--Overlay-->
		<div id="home-overlay"></div>

		<!--Home Content-->
		<div id="home-content">
			<div id="home-content-inner" class="text-center">
				<div id="home-heading">
					<h1 id="home-heading-1"><span>User</span> Management</h1><br>
					<h1 id="home-content-2">App For <span>Use</span></h1>
				</div>
				
				<div id="home-btn">
					<a class="btn btn-general btn-home smooth-scroll" href="#about" title="Start Now" role="button">Start Now</a>
				</div>
			</div>
		</div>

		<!--Arrow down-->
		<a href="#about" id="arrow-down" class="smooth-scroll">
			<i class="fa fa-angle-down"></i>
		</a>
	</section>
	<!--Home ends-->

	<!--About-->
	<section id="about">
		<div id="about-01">
			<div class="content-box-lg">
				<div class="container">
					<div class="row">

						<!--About Left side-->
						<div class="col-md-6">
							<div id="about-left">
								<div class="vertical-heading">
									<h5>Who We Are</h5>
									<h2>A <strong>Story</strong> <br> About Us</h2>
								</div>
							</div>
						</div>

						<!--About Right side-->
						<div class="col-md-6">
							<div id="about-right">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
								tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
								quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
								consequat. Duis aute irure dolor in reprehen
								proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
								tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,</p>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>	
	</section>
	<!--About ends-->

	<!--Statement-->
	<section id="statement">
		<div class="content-box-lg">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div id="tech-statement" class="text-center">
							<h3> <i class="fa fa-quote-left"></i> User Management describes the ability for administrators, <br>to manage user access to various IT resources. <i class="fa fa-quote-right"></i></h3>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--Statement ends-->

	<!--Team-->
	<section id="team">
		<div class="content-box-lg">
			<div class="container">
				<!--Team members-->
				<div class="row">
					<!--Team left side-->
					<div class="col-md-6">
						<div id="team-left">
							<div class="vertical-heading">
									<h5>Who We Are</h5>
									<h2>Meet Our <br><strong>Talented</strong> Team </h2>
								</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
								tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
								qmollit anim id est laborum.</p>
							
						</div>
					</div>

					<!--Team right side-->
					<div class="col-md-6">
						<div id="team-members" class="owl-carousel owl-theme">

							<!--Member 01-->
							<div class="team-member">
								<img src="img/team/Ishan.jpg" alt="team member" class="img-responsive">
								<div class="team-member-overlay">
									<div class="team-member-info text-center">
										<h6>Ishan Stha</h6>
										<p> Web Designer</p>
										<ul class="social-list">
											<li><a href="#"><i class="fa fa-facebook"></i></a></li>
											<li><a href="#"><i class="fa fa-twitter"></i></a></li>
											<li><a href="#"><i class="fa fa-google-plus"></i></a></li>	
										</ul>
									</div>
								</div>
							</div>

							<!--Member 02-->
							<div class="team-member">
								<img src="img/team/Hukum.jpg" alt="team member" class="img-responsive">
								<div class="team-member-overlay">
									<div class="team-member-info text-center">
										<h6>Hukum Gosain</h6>
										<p> Web Developer</p>
										<ul class="social-list">
											<li><a href="#"><i class="fa fa-facebook"></i></a></li>
											<li><a href="#"><i class="fa fa-twitter"></i></a></li>
											<li><a href="#"><i class="fa fa-google-plus"></i></a></li>	
										</ul>
									</div>
								</div>
							</div>

							<!--Member 03-->
							<div class="team-member">
								<img src="img/team/team-3.jpg" alt="team member" class="img-responsive">
								<div class="team-member-overlay">
									<div class="team-member-info text-center">
										<h6>Megha Magar</h6>
										<p> Project Manager</p>
										<ul class="social-list">
											<li><a href="#"><i class="fa fa-facebook"></i></a></li>
											<li><a href="#"><i class="fa fa-twitter"></i></a></li>
											<li><a href="#"><i class="fa fa-google-plus"></i></a></li>	
										</ul>
									</div>
								</div>
							</div>

							<!--Member 04-->
							<div class="team-member">
								<img src="img/team/Milan.jpg" alt="team member" class="img-responsive">
								<div class="team-member-overlay">
									<div class="team-member-info text-center">
										<h6>Milan Dangol</h6>
										<p> Database Administrator</p>
										<ul class="social-list">
											<li><a href="#"><i class="fa fa-facebook"></i></a></li>
											<li><a href="#"><i class="fa fa-twitter"></i></a></li>
											<li><a href="#"><i class="fa fa-google-plus"></i></a></li>	
										</ul>
									</div>
								</div>
							</div>

							<!--Member 05-->
							<div class="team-member">
								<img src="img/team/team-2.jpg" alt="team member" class="img-responsive">
								<div class="team-member-overlay">
									<div class="team-member-info text-center">
										<h6>Nikesh Lawat</h6>
										<p> Digital Operations Manger</p>
										<ul class="social-list">
											<li><a href="#"><i class="fa fa-facebook"></i></a></li>
											<li><a href="#"><i class="fa fa-twitter"></i></a></li>
											<li><a href="#"><i class="fa fa-google-plus"></i></a></li>	
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--Team ends-->

<!--end of code by ishan-->

<section class="user">
  <div class="user_options-container">
    <div class="user_options-text">
      <div class="user_options-unregistered">
        <h2 class="user_unregistered-title">Don't have an account?</h2>
        <p class="user_unregistered-text"></p>
        <button class="user_unregistered-signup" id="signup-button">Sign up</button>
      </div>

      <div class="user_options-registered">
        <h2 class="user_registered-title">Have an account?</h2>
        <p class="user_registered-text"></p>
        <button class="user_registered-login" id="login-button">Login</button>
      </div>
    </div>
    
    <div class="user_options-forms" id="user_options-forms" >
      <div class="user_forms-login">
          <h2 class="forms_title">Login</h2>
          <%String loginError="";
          if(session.getAttribute("loginError") !=null){
          loginError=(String)session.getAttribute("loginError");
          
          %>
           <span><%= loginError%></span>
        <% session.removeAttribute("loginError");
            }
        %>
        
        <!--login form-->
        <form class="forms_form" action="login" method="post">
          <fieldset class="forms_fieldset">
            <div class="forms_field">
              <input type="text" placeholder="username" name="username" class="forms_field-input" required autofocus />
            </div>
            <div class="forms_field">
              <input type="password"  name="password" class="forms_field-input" required />
            </div>
          </fieldset>
          <div class="forms_buttons">          
           <a href="resetPassword.jsp"><button type="button" class="forms_buttons-forgot">Forgot password?</button></a> 
            <input type="submit" value="Log In" class="forms_buttons-action">
          </div>
        </form>
      </div>
        
        
      <div class="user_forms-signup" style="top: 10px;" id="user">
        <h2 class="forms_title">Sign Up</h2>
        
        
        <!--signup form -->
        <form class="fo	ms_form" action="signup" method="post">
          <fieldset class="forms_fieldset">
            <div class="forms_field">
              <input type="text" placeholder="username" name="username" class="forms_field-input" required />
            </div>
            <div class="forms_field">
              <input type="email" placeholder="email" name="email" class="forms_field-input" required />
            </div>
            <div class="forms_field">
              <input type="phone" placeholder="phonenumber" name="phonenumber" class="forms_field-input" required />
            </div>
             <div class="forms_field">
              <input type="password" placeholder="conform password" name="password" class="forms_field-input"  />
            </div>           
          </fieldset>
           <input type="checkbox">I agree to accept Terms and condition 
          <div class="forms_buttons">
            <input type="submit" value="Sign up" class="forms_buttons-action">
          </div>
        </form>
      </div>
    </div>
  </div>
</section>
        
        
        
<%} else{
        response.sendRedirect("Dashboard");

}%>   


	<!--Footer-->
	<footer class="text-center">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<p>
						Copyright &copy; 2020 All Rights Reserved By <span>Herald College Kathmandu.</span>
					</p>
				</div>
			</div>
		</div>

		<!--Back to top-->
		<a href="#home" id="back-to-top" class="btn btn-sm btn-yellow btn-back-to-top smooth-scroll" title="home" role="button">
			<i class="fa fa-angle-up"></i>
		</a>
	
	</footer>
	<!--Footer ends-->


<script type="text/javascript">
/**
 * Variables
 */
const signupButton = document.getElementById('signup-button'),
    loginButton = document.getElementById('login-button'),
    userForms = document.getElementById('user_options-forms')

/**
 * Add event listener to the "Sign Up" button
 */
signupButton.addEventListener('click', () =>{
  userForms.classList.remove('bounceRight')
  userForms.classList.add('bounceLeft')
}, false)

/**
 * Add event listener to the "Login" button
 */
loginButton.addEventListener('click', () =>{
  userForms.classList.remove('bounceLeft')
  userForms.classList.add('bounceRight')
}, false)

</script>

	<!--JQuery-->
	<script type="text/javascript" src="js/jquery.js"></script>

	<!--Bootstrap JS-->
	<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>

	<!--Owl carousel JS-->
	<script src="js/owl-carousel/owl.carousel.min.js"></script>
 
	<!--Waypointsx-->
	<script src="js/waypoints/jquery.waypoints.min.js"></script>

	<!--Responsive tabs
	<script src="js/responsive-tabs/jquery.responsiveTabs.min.js"></script> -->

	<!--Isotope-->
	<script src="js/isotope/isotope.pkgd.min.js"></script>

	<!--Magnific popup
	<script src="js/magnific-popup/jquery.magnific-popup.min.js"></script>-->

	<!--Easing-->
	<script src="js/easing/jquery.easing.1.3.js"></script>

	<!--Custom JS-->
	<script src="js/script.js"></script>
	<script src="js/user.js"></script>

</body>
</html>
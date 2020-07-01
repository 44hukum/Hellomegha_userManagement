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
	<title>SAD User Management</title>

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
          
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <style>
    /*--- Extra Bootstrap Column Padding --*/
[class*="col-"] {
  padding: 1rem;
}
body{
    overflow: scroll;
    width: 100%;
    scroll-behavior: smooth;	
}

/*--- Bootstrap Mobile Gutter Fix --*/
.row, .container-fluid {
margin-left: 0px!important;
margin-right: 0px!important;
}

/*--- Fix for Fixed Navbar jumping on scroll --*/
.fixed-top  {
 -webkit-backface-visibility: hidden;
}

/*--- Fixed Landing Page Section --*/
.landing {
  position: relative;
  width: 100%;
  height: 100vh;
  display: table;
  z-index: -1;
}
.for_contact a{
	text-decoration: none;
	}
.for_contact a:hover{
	text-decoration: none;
	color: #1ebba3;
	}

.home-wrap {
  clip: rect(0, auto, auto, 0);
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
.home-inner {
  position: fixed;
  display: table;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-size: cover;
  background-position: center center;
  -webkit-transform: translateZ(0);
          transform: translateZ(0);
  will-change: transform;
}

/*--- iOS Fixed Background Image --*/
.fixed-background {
  position: relative;
  width: 100%;
}
.fixed-wrap {
  clip: rect(0, auto, auto, 0);
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -999!important;
}
.fixed {
  position: fixed;
  display: block;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-size: cover;
  background-position: center center;
  -webkit-transform: translateZ(0);
          transform: translateZ(0);
  will-change: transform;
}
/* Buy Thiss */
.showDetail{
	margin-top: 0.3rem;
}
/* end of Buy Thiss */


/* font-family: 'Lato', sans-serif; */
body{
  overflow-x: hidden;
  font-family: 'Lato', sans-serif;
  color: #505962 ;
  text-align: justify;
}
.offset:before{
  display: block;
  content: "";
  height: 3.79rem;
  margin-top: -4rem;
  margin-bottom: 0;
  padding-bottom: 0px;
}
#developer.offset:before{
	height: 0rem;
}
.navbar{
  text-transform: uppercase;
  font-weight: 700;
  font-size: .9rem; /* 1 rem = 16pixels */ 
  letter-spacing: .1rem;
  background-color: rgba(0,0,0,0.5)!important; /* 40% transparency */

}
.navbar-brand img{
  height: 2rem;
}
.navbar-nav li{
  padding-right: .7rem;
}

.navbar-dark .navbar-nav .nav-link{
  color: white;
  padding-top: .8rem;
}
      .navbar-dark .navbar-nav .nav-link.active,
      .navbar-dark .navbar-nav .nav-link:hover{
         color: #1ebba3;
      }

/* landing page css  */
.home-inner{
  
  background-image: url(img/background/black-computer-keyboard-on-black-table-3815729.jpg);
}

.caption{
  width: 100%;
  max-width: 100%;
  position: absolute;
  top: 38%;
  z-index: 1;
  color: white;
  text-transform: uppercase;
}

.caption h1{
  font-size: 3.8rem;
  font-weight:700;
  letter-spacing: .3rem;
  text-shadow: .1rem .1rem .8rem black;
  padding-bottom: 2rem;
}
.caption h3{
  font-size: 2rem;
  text-shadow: .1rem .1rem .5rem black;
  padding-bottom: 1.6rem;
}
.btn-lg{
  border-width: medium;
  border-radius: 0;
  padding: .6rem 1.3rem;
  font-size: 1.1rem;
}


/* About section */
.narrow{
  width: 75%;
  margin: 1.5rem auto;
   }
#About{
  
}
.narrow h1{
  font-size: 2.4rem;
}
.narrow p{
 
}
.btn-secondary{
  border-width: medium;
  border-radius: 0;
  text-transform: uppercase;
  font-size: 1.2rem;
  padding: .6rem 1.2rem;
  margin: 1rem;
  color: white;
  background-color: #1ebba3;
  border-color: #1ebba3;
}

/* For Category */
.jumbotron{
  margin-bottom: 0;
  padding: 2rem 0 3.5rem;
  border-radius: 0;
}
h3.heading{
font-size: 1.9rem;
font-weight: 700;
 text-transform: uppercase;
 margin-bottom: 1.9rem;
}
.heading-underline{
    width: 3rem;
    height:.2rem;
    background-color: #1ebba3;
    margin: 0 auto 2rem;

}
.features svg.svg-inline--fa.fa-w-16{
  color: #1ebba3;
}
.features svg.svg-inline--fa{
	padding-top: 30px;
  color: #1ebba3;
}
.featiure{}

.features h3{
  font-size: 1.3rem;
  text-transform: uppercase;
  padding-bottom: .4rem;
}
.features p{
  font-size: 1.1rem;
 }

 /* Resources section of css */
 
 .dark{
   background-color: rgba(0,0,0,0.75);
   color: white;
   padding: 7rem 2rem;
 }
 .show_Details{
   
   color: white;
   
   width: 100%;
 }
 .fixed-background h3{
  margin-bottom: 2rem;
 }
 .fixed-background p{
  margin-top: 1.5rem;
 }

 /* CLient section  */
 .contact img{
   width: 100%;
  border-radius: 60%;
 }
 blockquote .svg-inline--fa{
  color: #1ebba3;
  margin: 1rem;
 }
 .Contacts-hr{
  border-top: .05rem solid #1ebba3;
 }
 /* for developer */
 

 .dark{
  padding-top: 2rem;
}
hr.socket{
  width: 100%;
  border-top: .2rem solid #666b71;
  margin-top: 3rem;
}
/* Media Queries */
@media (max-width:767px){
  .caption h1{
    font-size: 2.3rem; 
    letter-spacing: .15rem;  
    padding-bottom: .5rem;
  }
  .caption h3{
    font-size: 1.2rem;
  
    padding-bottom: 1.2rem;
  }
  .btn-lg{
    padding: .5rem 1rem;
    font-size: 1rem;
  }
  .narrow h1{
    font-size: 1.8rem;
  }
  .contact img{
    width: 50%;
   display: block;
   margin: 0 auto; 
}
footer img{
   margin: 1rem auto;
}
}
.modal{	
	padding-top: 5rem;
}
.modal-body{
	background-color: rgba(red, green, blue, 0.3);
	padding: 0.3rem;
}
#form_modal .modal-body{
	background-color: wheat;
}
.for_popularItem{
	box-shadow: 0 0 1px #233f50;
 
}
.for_popularItem:hover{
	box-shadow: 0 0 8px #233f50;
 
}
.priceFor:hover{

}
#detailFirst{
	padding: 10px;
}
.contacts>a{
	text-decoration: none;
}

</style>
	
</head>
<body data-spy="scroll" data-target="#navbarResponsive"">

<!-- start Home -->
<div id="home">
	<!-- starts navigation bar -->
	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
            <a href="#" class="navbar-brand" style="margin-top: 7px;">User Management System</a>
		<!-- logo needed -->
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
			<span class="navbar-toggler-icon">
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				
				<li class="nav-item">
					<a href="#About" class="nav-link">About</a>
				</li>
                                <li class="nav-item">
					<a href="#user" class="nav-link">Sign up</a>
				</li>
                                <li class="nav-item">
					<a href="#user" class="nav-link">Login</a>
				</li>
			</ul>

		</div>

	</nav>  
	<!-- end bavigation bar -->

	<!-- landing page section -->
	<div class="landing">
		<div class="home-wrap">
			<div class="home-inner">

			</div>
		</div>
	</div>
	<div class="caption text-center">
		<h1>Welcome to Hello-Megha</h1>
		<h3>For User Management</h3>
                <a href="#user" class="btn btn-outline-primary btn-lg" style="margin-top: 73px;" >Start Now</a>
	</div>
	<!-- end landing page section -->
</div>

</div>
<!-- STart of the about page -->
<div id="About" class="offset">
	<!-- this is the start of the Jumbotron -->
	<div class="jumbotron">
		<div class="narrow text-center about">
				<div class="col-12">
					<h3 class="heading">
						About
					</h3>
					<div class="heading-underline"></div>
					<p>Add or remove users, modify profile and authorization attributes,
and identify root-cause user login issues in minutes with a simple,
intuitive and powerful web interface provided by Hello-Megha</p>
				</div>
			
		</div> <!-- end narrow -->
	</div>
	<!-- end of jumbotron -->
</div>
<!-- end of the About section --> 

<!-- ends of the products section -->
	<!-- start About -->

</div>

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


<!--end of code by ishan-->

<section class="user"  style="padding-top:187px;">
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
    
      <div class="user_options-forms" id="user_options-forms" style="top:12px;" >
          <div class="user_forms-login" id="user"">
          <h2 class="forms_title">Login</h2>
          <%String login="";
          if(session.getAttribute("loginError") !=null){
          login=(String)session.getAttribute("loginError");
          
          %>
           <span><%= login%></span>
        <% session.removeAttribute("loginError");
            }
        %>
        
        <!--login form-->
        <form class="forms_form" action="login" method="post">
          <fieldset class="forms_fieldset">
            <div class="forms_field">
              <input type="text" placeholder="username" name="username" class="forms_field-input" required />
            </div>
            <div class="forms_field">
              <input type="password"  name="password" placeholder="password" class="forms_field-input" required />
            </div>
          </fieldset>
          <div class="forms_buttons">          
              <a href="resetPassword.jsp" ><button type="button" class="forms_buttons-forgot">Forgot password?</button></a> 
            <input type="submit" value="Log In" class="forms_buttons-action">
          </div>
        </form>
      </div>
        
        
      <div class="user_forms-signup" style="top: 0px;" id="user">
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
              <input type="password" placeholder="password" id="passwordID" name="password" class="forms_field-input" required />
            </div>
             <div class="forms_field">
                 <input type="password" placeholder="confirm password" oninput="check(this);" name="password" class="forms_field-input" required />
            </div>           
          </fieldset>
            <input type="checkbox" required> I agree to accept Terms and condition 
          <div class="forms_buttons" style="margin-top: 0px;">
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
	
        <p style="text-align: center">
						Copyright &copy; 2020 All Rights Reserved By <span>Herald College Kathmandu.</span>
		</p>
			
	
	<!--Footer ends-->
<!--Password and Confir password must match-->
<script language='javascript' type='text/javascript'>
function check(input) {
    if (input.value != document.getElementById('passwordID').value) {
        input.setCustomValidity('Password Must be Matching.');
    } else {
        // input is valid -- reset the error message
        input.setCustomValidity('');
    }
}

</script>


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
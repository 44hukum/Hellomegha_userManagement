<%-- 
    Document   : resetPassword
    Created on : Jun 5, 2020, 7:42:42 PM
    Author     : wanu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Reset Password</title>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
     
    <style type="text/css">
	body{
		color: #fff;
		/*background: #63738a;
		font-family: 'Roboto', sans-serif;*/
	}
    .form-control{
		height: 40px;
		box-shadow: none;
		color: #969fa4;
	}
	.form-control:focus{
		border-color: #5cb85c;
	}
    .form-control, .btn{        
        border-radius: 3px;
    }
	.signup-form{
		width: 400px;
		margin: 0 auto;
		padding: 30px 0;
	}
	.signup-form h2{
		color: #636363;
        margin: 0 0 15px;
		position: relative;
		text-align: center;
    }
	.signup-form h2:before, .signup-form h2:after{
		content: "";
		height: 2px;
		width: 30%;
		background: #d4d4d4;
		position: absolute;
		top: 50%;
		z-index: 2;
	}	
	.signup-form h2:before{
		left: 0;
	}
	.signup-form h2:after{
		right: 0;
	}
    .signup-form .hint-text{
		color: #999;
		margin-bottom: 30px;
		text-align: center;
	}
    .signup-form form{
		color: #999;
		border-radius: 3px;
    	margin-bottom: 15px;
        background: #f2f3f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
	.signup-form .form-group{
		margin-bottom: 20px;
	}
	.signup-form input[type="checkbox"]{
		margin-top: 3px;
	}
	.signup-form .btn{        
        font-size: 16px;
        font-weight: bold;		
		min-width: 140px;
        outline: none !important;
    }
	.signup-form .row div:first-child{
		padding-right: 10px;
	}
	.signup-form .row div:last-child{
		padding-left: 10px;
	}    	
    .signup-form a{
		color: #fff;
		text-decoration: underline;
	}
    .signup-form a:hover{
		text-decoration: none;
	}
	.signup-form form a{
		color: #5cb85c;
		text-decoration: none;
	}	
	.signup-form form a:hover{
		text-decoration: underline;
	}  
</style>
</head>
<body>

    <!--Register-->
    <div class="signup-form">
        <% String error="";
        if(session.getAttribute("ER") !=null)
            error=(String)session.getAttribute("ER");
        
        %>
        
        <form action="ResetPassword" method="post">
            <h2>Account</h2>
            <p class="hint-text">Please Enter your username,phone number and new password</p>
            <h3 style="color:red;">
            <%=error%> 
    
        </h3>
            <div class="form-group">
                <input type="text" class="form-control" name="username" placeholder="Username" required="required">      	
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="phonenumber" placeholder="Phone Number" required="required">
            </div>
            <div class="form-group">
                <!-- use java script to check both the password chosen  are same-->
                <input type="password" class="form-control" name="password" placeholder="New-Password" required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="confirm_password" placeholder="Confirm New-Password" required="required">
            </div>        
           
            <div class="form-group">
                <button type="submit" class="btn btn-success btn-lg btn-block">Reset</button>
            </div>
        </form>
      <%session.removeAttribute("ER");%>
    </div>
</body>
</html>
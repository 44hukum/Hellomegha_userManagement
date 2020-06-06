<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello megha</title>
 <link rel="stylesheet" type="text/css" href="./Resources/style.css">
</head>
<body>

    <% if(session.getAttribute("username") !=null){
            
    %>
<div class="area"></div>
<nav class="main-menu">
            <ul>
                <li>
                    <a href="childwelcome.jsp">
                        <i class="fa fa-home fa-2x"></i>
                        <span class="nav-text">
                            Dashboard
                        </span>
                    </a>
                  
                </li>
                <li class="has-subnav">
                    <a href="profilechoicesecond.jsp">
                        <i class="fa fa-user fa-2x"></i>
                        <span class="nav-text">
                            Profile
                        </span>
                    </a>
                    
                </li>
                <li class="has-subnav">
                    <a href="usertable.jsp">
                     <i class="fa fa-users"></i>
                        <span class="nav-text">
                            users
                        </span>
                    </a>
                    
                </li>
                <li class="has-subnav">
                    <a href="#">
                       <i class="fa fa-folder-open fa-2x"></i>
                        <span class="nav-text">
                            Data
                        </span>
                    </a>
                   
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-bar-chart-o fa-2x"></i>
                        <span class="nav-text">
                            Generate Report
                        </span>
                    </a>
                </li>
               
                <li>
                   <a href="#">
                       <i class="fa fa-table fa-2x"></i>
                        <span class="nav-text">
                           Resources
                        </span>
                    </a>
                </li>
                  <li>
                    <a href="#">
                       <i class="fa fa-info fa-2x"></i>
                        <span class="nav-text">
                            About us
                        </span>
                    </a>
                </li>
            </ul>

            <ul class="logout">
                <li>
                   <a href="logout">
                         <i class="fa fa-power-off fa-2x"></i>
                        <span class="nav-text">
                            Logout
                        </span>
                    </a>
                </li>  
            </ul>
        </nav>
        <section>
  
       <jsp:include page="usertable.jsp"></jsp:include>
      		
        </section>
    <%
        }else{
response.sendRedirect("welcome.jsp");
}
    %>   
</body>
</html>
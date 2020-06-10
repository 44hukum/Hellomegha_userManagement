<%@page import="com.hellomegha.databasequeries.GenerateReport"%>
<%@page import="com.hellomegha.usermanagement.Dashboard"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Level"%>
<%@page import="com.hellomegha.databasequeries.FindUser"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title> User - Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  <link href="css/sb-admin-2.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav sidebar sidebar-dark " id="Sidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="dashboard.html">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
          
          
        <% if(session.getAttribute("role").equals("admin")){ %> 
	<div class="sidebar-brand-text mx-3"> Admin </div>
	<%}else{ %>
        <div class="sidebar-brand-text mx-3"> User </div> 
        <%} %>
                                                        
        <!--<div class="sidebar-brand-text mx-3"> User </div>-->
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item ">
        <a class="nav-link" href="Dashboard">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="profile">
          <i class="fas fa-user"></i>
          <span>Profile</span>
        </a>
      </li>

      <li class="nav-item active">
        <a class="nav-link collapsed" href="user-info">
          <i class="fas fa-list"></i>
          <span>Users</span>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="#">
          <i class="fas fa-file"></i>
          <span>Report</span>
        </a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Navbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Topbar Search -->
          <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
              <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button class="btn btn-dark" type="button">
                  <i class="fas fa-search fa-sm"></i>
                </button>
              </div>
            </div>
          </form>

                  <a href="logout">logout</a>
       
        </nav>
        <!-- End of Navbar -->

        <!-- Begin Page Content -->
        <div class="container bootstrap snippet">
          <div class="row">
              <div class="col-lg-12">
                  <div class="main-box no-header clearfix">
                      <div class="main-box-body clearfix">
                          <div class="table-responsive">
                              <table class="table user-list" >
                               		
			
	<thead class="thead-dark mb-0 ">
		<tr>
                        <th data-field="userid" data-sortable="true">User ID</th>
                        <th data-field="name" data-filter-control="input" data-sortable="true">Blocked Date</th>
                        
			<th data-field="date" data-filter-control="select" data-sortable="true">Blocked Reason</th>
			
		</tr>
	</thead>
	
	
		<tbody>
                    <% //
                       String start=request.getParameter("startDate");
                      String end=request.getParameter("endDate");
                     ResultSet result=(new GenerateReport()).blocked_user_report(start,end);
       //sends user details to jsp
              Sysou 
        %>
                   <tr>
                       <td>%></td>
                       <td><%= start%></td>
                         <td><%=end%></td>
                       
			
		</tr> 
               
                   
			
	</tbody>
	
</table>
                    <!--user selection form-->
                    <form action="profilechoicesecond.jsp" style="display:none;" id="userD">
                        <input type="text" id="textWriter" value="" name="textVal">
                        <input type="submit" id="submitButton">
                    </form>        
                    
                    <!--user deletion form-->
                    <form action="DeleteUser" method="post"style="display:none;" id="deleteD">
                        <input type="text" id="deleteUser" value="" name="deleteUser">
                        <input type="submit" id="submit">
                    </form> 
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
        <!-- /.container-fluid -->
        
      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            Copyright &copy; 2020 All Rights Reserved By <span>Herald College Kathmandu.</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

<!--dont touch me-->
 
<script type="text/javascript">
 var i=document.getElementById("textWriter");
         function a(userID){
            i.setAttribute('value',userID);
            document.getElementById("submitButton").click();
         }
    //delete user
  var user=document.getElementById("deleteUser");
  function deleteUser(userID){
      user.setAttribute('value',userID);
      document.getElementById("submit").click();
      
  }
</script>
 <!--up to here-->


  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/chart-area-demo.js"></script>
  <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>
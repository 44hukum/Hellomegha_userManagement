<%@page import="com.hellomegha.usermanagement.Dashboard"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Level"%>
<%@page import="com.hellomegha.databasequeries.FindUser"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Users</title>

   
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css">
    <link rel="stylesheet" type="text/css" href="./Resources/style.css">
  <style>
  .container {
	width: 100%;
	float:right;
	max-height:10px;
	margin-right: 2em;
	
}

.bold-blue {
	font-weight: bold;
	color: #0277BD;
	
}
.my-custom-scrollbar {
	  overflow-y: scroll;
}

h1{
margin-left: 111px;
margin-top: 41px;
}
  </style>

 <div class="container">	
  
 <div class="table-wrapper-scroll-y my-custom-scrollbar">
		<table class="table table-bordered table-striped mb-0"
			 data-toggle="table"
                         data-search="true"
			  data-filter-control="true" 
			 data-click-to-select="true"			 
			 >
			
			
			
	<thead class="thead-dark mb-0 ">
		<tr>
                        <th data-field="userid" data-sortable="true">User ID</th>
                        <th data-field="name" data-filter-control="input" data-sortable="true">first name</th>
                        
			<th data-field="date" data-filter-control="select" data-sortable="true">last name</th>
			<th data-field="name" data-filter-control="input" data-sortable="true">username</th>
			<th data-field="date" data-filter-control="select" data-sortable="true">E-mail</th>
			<th data-field="status" data-filter-control="select" data-sortable="false">Status</th>
		
			<% if(session.getAttribute("role").equals("admin")){%>
                        <th data-field="profile" data-sortable="false">Show Profile</th>
                        <%}%>
		</tr>
	</thead>
	
	
		<tbody>
                    <%
                       
                        try {
          //sends user details to jsp
        ResultSet users=(new FindUser()).userTableRecord();
        while(users.next()){
           %>
                   <tr>
                       <td><%= users.getInt("userID")%></td>
                       <td><%= users.getString("firstName")%></td>
                       <td><%= users.getString("lastname")%></td>
			<td><%= users.getString("username")%></td>
			<td><%= users.getString("email")%></td>
			<td><%= users.getString("Status")%></td>
			
                        <% if(session.getAttribute("role").equals("admin")){
                       
                        %>
                        
                        <td><a href="#" onclick=a("<%=users.getString("username")%>")>view profile</a></td>
			<%}%>
		</tr> 
               
                    <%
        }

        System.out.println(users);
        session.setAttribute("users", users);
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
                    %>
			
	</tbody>
	
</table>
                    <form action="profilechoicesecond.jsp" style="display:none;" id="userD">
                        <input type="text" id="textWriter" value="" name="textVal">
                        <input type="submit" id="submitButton">
                    </form>        
</div>
</div>
 
 
<script type="text/javascript">
 var i=document.getElementById("textWriter");
 function a(value){
 i.setAttribute('value',value);
 document.getElementById("submitButton").click();
 }
</script>



  </body>
</html>
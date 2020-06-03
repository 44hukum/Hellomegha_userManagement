<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Users</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css">
    <link rel="stylesheet" type="text/css" href="./Resources/style.css">
  <style>
  .container {
	width: 100%;
	float:right;
	
	margin-right: 2em;
	
}

.bold-blue {
	font-weight: bold;
	color: #0277BD;
	overflow-y: scroll;
}
.my-custom-scrollbar {
	scrollbar-width:0px;
	height: 500px;
	overflow-y: scroll;
}

h1{
margin-left: 111px;
margin-top: 41px;
}
  </style>
 <h1>Users</h1>
 <div class="container">	
  
 <div class="table-wrapper-scroll-y my-custom-scrollbar">
		<table class="table table-bordered table-striped mb-0"
			 data-toggle="table"
			  data-filter-control="true" 
			 data-click-to-select="true"			 
			 >
			
			
			
	<thead class="thead-dark mb-0">
		<tr>
			
			<th data-field="name" data-filter-control="input" data-sortable="true">Name</th>
			<th data-field="date" data-filter-control="select" data-sortable="true">Registered date</th>
			<th data-field="status" data-filter-control="select" data-sortable="false">Status</th>
			<th data-field="userid" data-sortable="true">User ID</th>
			<th data-field="profile" data-sortable="false">Show Profile</th>
		</tr>
	</thead>
	
	
		<tbody>
		<tr>
		
			<td>hukum</td>
			<td>01/09/2020</td>
			<td>Active</td>
			<td>10</td>
			<td><a href="profilechoicesecond.jsp">view profile</a></td>
			
		</tr>
		<tr>
			
			<td>ishan</td>
			<td>05/09/2020</td>
			<td>hold</td>
			<td>11</td>
			<td><a href="profilechoicesecond.jsp">view profile</a></td>
		</tr>
		
			<tr>
		
			<td>hukum</td>
			<td>01/09/2020</td>
			<td>Active</td>
			<td>10</td>
			<td><a href="profilechoicesecond.jsp">view profile</a></td>
			
		</tr>
		<tr>
			
			<td>ishan</td>
			<td>05/09/2020</td>
			<td>hold</td>
			<td>11</td>
			<td><a href="profilechoicesecond.jsp">view profile</a></td>
		</tr>
			<tr>
		
			<td>hukum</td>
			<td>01/09/2020</td>
			<td>Active</td>
			<td>10</td>
			<td><a href="profilechoicesecond.jsp">view profile</a></td>
			
		</tr>
		<tr>
			
			<td>ishan</td>
			<td>05/09/2020</td>
			<td>hold</td>
			<td>11</td>
			<td><a href="profilechoicesecond.jsp">view profile</a></td>
		</tr>
			<tr>
		
			<td>hukum</td>
			<td>01/09/2020</td>
			<td>Active</td>
			<td>10</td>
			<td><a href="profilechoicesecond.jsp">view profile</a></td>
			
		</tr>
		<tr>
			
			<td>ishan</td>
			<td>05/09/2020</td>
			<td>hold</td>
			<td>11</td>
			<td><a href="profilechoicesecond.jsp">view profile</a></td>
		</tr>
			<tr>
		
			<td>hukum</td>
			<td>01/09/2020</td>
			<td>Active</td>
			<td>10</td>
			<td><a href="profilechoicesecond.jsp">view profile</a></td>
			
		</tr>
		<tr>
			
			<td>ishan</td>
			<td>05/09/2020</td>
			<td>hold</td>
			<td>11</td>
			<td><a href="profilechoicesecond.jsp">view profile</a></td>
		</tr>
			<tr>
		
			<td>hukum</td>
			<td>01/09/2020</td>
			<td>Active</td>
			<td>10</td>
			<td><a href="profilechoicesecond.jsp">view profile</a></td>
			
		</tr>
		<tr>
			
			<td>ishan</td>
			<td>05/09/2020</td>
			<td>hold</td>
			<td>11</td>
			<td><a href="profilechoicesecond.jsp">view profile</a></td>
		</tr>
	</tbody>
	
</table>
</div>
</div>
 
 
<script type="text/javascript">

</script>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>

  </body>
</html>
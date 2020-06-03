<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="./Resources/css/profile.css">
<link rel="stylesheet" type="text/css" href="./Resources/style.css">
</head>
<body>
<div class="profile-card-wrap">
	<input id="check" type="checkbox" class="check"><label for="check" class="toggle"> + </label>
	<div class="content" data-text="&#2350; &#2344;&#2375;&#2346;&#2366;&#2354;&#2368; &#2357;&#2375;&#2348; &#2337;&#2367;&#2332;&#2366;&#2312;&#2344;&#2352; &#2361;&#2369;&#2305; &#2404;">
		<div class="title">Name</div>
		<p>I am a user 2</p>
	</div>
	<div class="link-info">
		<div class="social">
			<a class="link fb" href="#" target="_blank"><i class="fa fa-facebook"></i></a>
			<a class="link tw" href="#" target="_blank"><i class="fa fa-twitter"></i></a>
			
			<a class="link pi" href="#" target="_blank"><i class="fa fa-pinterest"></i></a>
			<a class="link li" href="#" target="_blank"><i class="fa fa-linkedin"></i></a>
			<a class="link yt" href="#" target="_blank"><i class="fa fa-youtube-play"></i></a>
			<a class="link gp" href="#" target="_blank"><i class="fa fa-google-plus"></i></a>
		</div>
		<div class="photo"></div>
	</div>	
</div>
<script type="text/javascript">
document.getElementById('check').click();
</script>
</body>
</html>
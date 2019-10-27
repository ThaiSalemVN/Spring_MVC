<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<base href="${pageContext.servletContext.contextPath}/">
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Trang chủ</title>
	
	<!-- Bootstrap core CSS -->
	<link href="resources/user/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Custom styles for this template -->
	<link href="resources/user/css/full-width-pics.css" rel="stylesheet">
    
    <!-- Link silde show -->
    <link href="resources/user/css/slideshow.css" rel="stylesheet">
    <!-- CSS của các trang con -->
    <link href="resources/user/css/user.css" rel="stylesheet">
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Tập Đoàn ABC Group</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Services</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	
	<!-- Header - set the background image for the header in the line below -->
	
	<header class="py-5 bg-image-full"
		style="background-image: url('resources/user/images_user/bg2.jpg');">
		<img class="img-fluid d-block mx-auto"
			src="resources/user/images_user/Logo.png" width="250" height="250" alt=""/> 
	</header>
	
	
		
	
	<!-- Content section -->
	<section class="py-5">
		<jsp:include page="${param.view}"/>
	</section>

 
	<!-- Image Section - set the background image for the header in the line below -->
	 <!--
	<section class=" bg-image-full"
		style="background-image: url('resources/user/images_user/bg2.jpg');">
		<div style="height: 500px;"></div>
		
		
	</section>
	   -->

	<!-- Content section -->
 
	<section class="py-5">
		<div class="container">
			<h1>Section Heading</h1>
			<p class="lead">Lorem ipsum dolor sit amet, consectetur
				adipisicing elit.</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
				Aliquid, suscipit, rerum quos facilis repellat architecto commodi
				officia atque nemo facere eum non illo voluptatem quae delectus odit
				vel itaque amet.</p>
		</div>
	</section>
	
	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="resources/user/vendor/jquery/jquery.min.js"></script>
	<script src="resources/user/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<script src="resources/user/js/slide.show.js"></script>
</body>
</html>
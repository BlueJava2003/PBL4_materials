<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
	crossorigin="anonymous"></script>


</head>
<body>

	<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
	<!-- Header - navbar - 2 cách include--> 
	<jsp:include page="header.jsp"></jsp:include>
	<!-- End header -->
	<!-- Page content -->
	<div class="container">
		<div class="row">
			<!-- Menu left -->
			<jsp:include page="left.jsp"></jsp:include>
			<!-- End Menu left -->
			<!-- Menu right -->
			<div class="col-lg-9 bg-warning">
				<!-- Sliders -->
				<div id="carouselExampleIndicators" class="carousel slide">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="img/1.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="img/2.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="img/3.png" class="d-block w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
				<!-- End Sliders -->
				<!-- Products -->
				<div class="row">
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="img/products/1.png" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Áo thun Pro-S1</a>
								</h4>
								<h5>50.000</h5>
								<p class="card-text">Sản phẩm thoáng mát, có độ bền tốt, giữ
									màu sắc tốt.</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="img/products/2.png" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Áo thun Pro-S1</a>
								</h4>
								<h5>50.000</h5>
								<p class="card-text">Sản phẩm thoáng mát, có độ bền tốt, giữ
									màu sắc tốt.</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="img/products/1.png" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Áo thun Pro-S1</a>
								</h4>
								<h5>50.000</h5>
								<p class="card-text">Sản phẩm thoáng mát, có độ bền tốt, giữ
									màu sắc tốt.</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="img/products/2.png" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Áo thun Pro-S1</a>
								</h4>
								<h5>50.000</h5>
								<p class="card-text">Sản phẩm thoáng mát, có độ bền tốt, giữ
									màu sắc tốt.</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
				</div>
				<!-- End Products -->
			</div>
			<!-- End Menu right -->
		</div>
	</div>
	<!-- End page content -->
	<!-- Footer -->
	<%@include file="footer.jsp"%>
	<!-- End Footer -->
</body>
</html>
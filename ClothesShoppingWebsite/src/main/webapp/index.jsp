<%@page import="persistence.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="dao.JdbcProductDao"%>
<%@page import="dao.ProductDao"%>
<%@page import="dao.CustomerDao"%>
<%@page import="persistence.Customer"%>
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
		+ request.getContextPath(); //http://localhost:8080/ClothesShoppingWebsite
		ProductDao productDao = new JdbcProductDao();
	%>
	<!-- Header - navbar - 2 cách include--> 
	<jsp:include page="header.jsp"></jsp:include>
	<!-- End header -->
	<!-- Page content -->
	<div class="container">
		<div class="row">
		<!--  <h1><%=url %></h1> http://localhost:8080/Bai4_Bootstrap -->
			<!-- Menu left -->
			<jsp:include page="left.jsp"></jsp:include>
			<!-- End Menu left -->
			<!-- Menu right -->
			<div class="col-lg-9 bg-warning">
				<!-- Sliders -->
				<div id="carouselExampleIndicators" class="carousel slide mb-4 mt-3">
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
							<img src="ProductImage/1.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="ProductImage/2.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="ProductImage/3.png" class="d-block w-100" alt="...">
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
				<c:forEach items="${listP}" var="o">
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-80">
							<a href="productdetail?pId=${o.id}"><img class="card-img-top"
								src="<%=url %>${o.image}" height="300" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="productdetail?pId=${o.id}">${o.name}</a>
								</h4>
								<h5>${o.salesPrice}đ</h5>
								<p class="card-text">${o.description}</p>
							</div>
							<div class="row container">
								<div class="col">
									<p class="btn btn-danger btn-block">${o.salesPrice}đ</p>
								</div>
								<div class="col mt-10">
									<a href="#" class="btn btn-success btn-block">Add to cart</a>
								</div>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
				</c:forEach>
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
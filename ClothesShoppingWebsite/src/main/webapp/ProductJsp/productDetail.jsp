<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Custom styles for this template -->
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<link href="<%=url%>/css/productDetail.css" rel="stylesheet">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
	integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
	crossorigin="anonymous"></script>


<title>Insert title here</title>
</head>
<body>
	<!-- Header - navbar - 2 cách include-->
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- End header -->
	<div class="container">
		<div class="row">
			<!-- Menu left -->
			<jsp:include page="../left.jsp"></jsp:include>
			<!-- End Menu left -->
			<!-- Product detail -->
			<div class="container mt-5 mb-5 col-lg-9">
				<div class="row d-flex justify-content-center">
					<div class="col-md-10">
						<div class="card">
							<div class="row">
								<div class="col-md-6">
									<div class="images p-3">
										<div class="text-center p-4">
											<img id="main-image" src="<%=url %>${p.image}" width="250" />
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="product p-4">
										<div class="d-flex justify-content-between align-items-center">
											<div class="d-flex align-items-center">
												<i class="fa fa-arrow-left"></i><span class="ml-1">Back</span>
											</div>
											<i class="fa fa-shopping-cart text-muted"></i>
										</div>
										<div class="mt-4 mb-3">
											<span class="text-uppercase text-muted brand">Loại
												hàng: ${p.productGroup.name}</span>
											<h5 class="text-uppercase">${p.name}</h5>
											<div class="price d-flex flex-row align-items-center">
												<span class="act-price">${p.salesPrice} đ</span>
												<div class="ml-2">
													<small class="dis-price">${p.salesPrice + p.purchasePrice}</small>
													<span>40% OFF</span>
												</div>
											</div>
										</div>
										<p class="about">${p.description}</p>
										<div class="sizes mt-5">
											<h6 class="text-uppercase">Size</h6>
											<label class="radio"> <input type="radio" name="size"
												value="S" checked> <span>SM</span>
											</label> <label class="radio"> <input type="radio"
												name="size" value="M"> <span>M</span>
											</label> <label class="radio"> <input type="radio"
												name="size" value="L"> <span>L</span>
											</label> <label class="radio"> <input type="radio"
												name="size" value="XL"> <span>XL</span>
											</label> <label class="radio"> <input type="radio"
												name="size" value="XXL"> <span>XXL</span>
											</label>
										</div>
										<div class="cart mt-4 align-items-center">
											<button class="btn btn-success text-uppercase mr-2 px-4">Add
												to cart</button>
											<i class="fa fa-heart text-muted"></i> <i
												class="fa fa-share-alt text-muted"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- End Product detail -->
		</div>
	</div>
	<!-- Footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	<!-- End Footer -->
</body>
</html>
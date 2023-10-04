<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath(); //http://localhost:8080/ClothesShoppingWebsite
	%>
<div class="col-lg-3">
	<!-- Menu left -->
	<div class="col-lg-12 mb-4">
		<div class="list-group">
			<a href="#" class="list-group-item list-group-item-action active" aria-current="true"> Thời trang nam </a> 
			<c:forEach items = "${listPG}" var="pg">
				<a href="productgroup?pgId=${pg.id }"
				 class="list-group-item list-group-item-action ${tag == pg.id ? "active":""}">${pg.name}</a> <!-- disabled --> 
		</c:forEach>
		</div>
	</div>
	
	<div class="mt-10 col-lg-12">
		<div class="col-lg-12 col-md-12	mb-12">
			<div class="card h-80">
				<a href="productdetail?pId=${newestP.id}"><img class="card-img-top"
					src="<%=url %>${newestP.image}" height="300" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="productdetail?pId=${newestP.id}">${newestP.name}</a>
					</h4>
					<h5>${newestP.salesPrice}đ</h5>
					<p class="card-text">${newestP.description}</p>
				</div>
				<div class="row container">
					<div class="col">
						<p class="btn btn-danger btn-block">${newestP.salesPrice}đ</p>
					</div>
					<div class="col">
						<a href="#" class="btn btn-success btn-block">Add to cart</a>
					</div>
				</div>
				<div class="card-footer">
					<small class="text-muted">&#9733; &#9733; &#9733;
						&#9733; &#9734;</small>
				</div>
			</div>
		</div>
	</div>
</div>
	<!-- End Menu left -->
</body>
</html>
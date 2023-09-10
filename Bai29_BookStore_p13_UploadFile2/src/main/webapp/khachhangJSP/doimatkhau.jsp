<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
	integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
	crossorigin="anonymous"></script>

<style>
	.red{
		color: red;
	}
</style>
</head>


<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<%
		Object obj = session.getAttribute("khachHang");
		KhachHang khachHang = null;
		if(obj != null){
			khachHang = (KhachHang)obj;
		}
		String baoLoi = request.getAttribute("baoLoi")+"";
		baoLoi = baoLoi.equals("null") ? "" : baoLoi;
		
		if(khachHang==null) {
	%>
			<h1>Bạn chưa đăng nhập, vui lòng đăng nhập trước khi đổi mật khẩu</h1>
	<%
		return;
		}
	%>
	
	<%
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
	%>
	<div class="container">
		<h1>Đổi mật khẩu</h1>
		<span class="red"><%=baoLoi %></span>
		<main>
			<form action="<%=url %>/khach-hang" method="POST">
				<input type="hidden" name="hanhDong" value="doi-mat-khau">
				<div class="mb-3">
					<label for="matKhauHienTai" class="form-label">Mật khẩu hiện tại </label> 
					<input type="password" class="form-control" id="matKhauHienTai" name="matKhauHienTai"> 
				</div>
				<div class="mb-3">
					<label for="matKhauMoi" class="form-label">Mật khẩu mới</label>
					<input type="password" class="form-control" id="matKhauMoi" name="matKhauMoi">
				</div>
				<div class="mb-3">
					<label for="matKhauMoiNhapLai" class="form-label">Mật khẩu mới</label>
					<input type="password" class="form-control" id="matKhauMoiNhapLai" name="matKhauMoiNhapLai">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</main>
	</div>
	
	<%@include file="../footer.jsp"%>
</body>
</html>
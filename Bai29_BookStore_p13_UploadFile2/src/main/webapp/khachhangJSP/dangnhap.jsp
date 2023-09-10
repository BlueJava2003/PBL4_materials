<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en" data-bs-theme="auto">
<head>
<script src="/docs/5.3/assets/js/color-modes.js"></script>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.115.4">
<title>Signin Template · Bootstrap v5.3</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/sign-in/">



<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

<link href="/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

<!-- Favicons -->
<link rel="apple-touch-icon"
	href="/docs/5.3/assets/img/favicons/apple-touch-icon.png"
	sizes="180x180">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png"
	sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png"
	sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
<link rel="mask-icon"
	href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg"
	color="#712cf9">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#712cf9">


<style>
</style>


<!-- Custom styles for this template -->
<link href="sign-in.css" rel="stylesheet">

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

<!-- Custom styles for this template -->
<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<link href="<%=url%>/css/signin.css" rel="stylesheet">
<style>
	.red{
		color: red;
	}
</style>
</head>
<main class="form-signin w-100 m-auto">
	<form class="text-center" action="<%=url %>/khach-hang" method="post"> <!-- Đi ra ngoài folder -->
		<input type="hidden" name="hanhDong" value="dang-nhap">
		<img class="mb-4" src="<%=url %>/img/logo/clothesMainLogo.png"
			alt="" width="72">
		<h1 class="h3 mb-3 fw-normal">ĐĂNG NHẬP</h1>
		<%
			String baoLoi = request.getAttribute("baoLoi")+"";
			baoLoi = baoLoi.equals("null") ? "" : baoLoi;	
		%>
		<div class="text-center"><span class="red"><%=baoLoi %></span></div>
		<div class="form-floating">
			<input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap"
				placeholder="tên đăng nhập"> <label for="tenDangNhap">Tên đăng nhập</label>
		</div>
		<div class="form-floating">
			<input type="password" class="form-control" id="matKhau" name="matKhau"
				placeholder="mật khẩu"> <label for="matKhau">Mật khẩu</label>
		</div>

		<div class="form-check text-start my-3">
			<input class="form-check-input" type="checkbox" value="remember-me"
				id="flexCheckDefault"> <label class="form-check-label"
				for="flexCheckDefault"> Nhớ mật khẩu </label>
		</div>
		<button class="btn btn-primary w-100 py-2" type="submit">Đăng nhập</button>
		<a href="<%=url %>/khachhangJSP/dangky.jsp">Đăng ký tài khoản mới</a>
		<p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2025</p>
	</form>
</main>
<script src="/docs/5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
	
	<%@include file="../footer.jsp"%>
</body>
</html>

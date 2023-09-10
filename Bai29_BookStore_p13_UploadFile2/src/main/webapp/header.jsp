<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	%>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="https://static.canva.com/web/images/12487a1e0770d29351bd4ce4f87ec8fe.svg	"
				alt="Bootstrap" height="29">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" ariza-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Trang chủ</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Combo
							giảm giá</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Thể loại </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Quần Jean</a></li>
							<li><a class="dropdown-item" href="#">Áo thun</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Mũ bảo hiểm</a></li>
						</ul></li>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Sản phẩm </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Quần Jean</a></li>
							<li><a class="dropdown-item" href="#">Áo thun</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Mũ bảo hiểm</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled">Hết hàng</a>
					</li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
					<%
					Object obj = session.getAttribute("khachHang");
					//Object obj = request.getAttribute("khachHang");
					KhachHang khachHang = null;
					if (obj != null) {
						khachHang = (KhachHang) obj;
					}
					if (khachHang == null) {
					%>
					<a class="btn btn-primary" style="white-space: nowrap;"
						href="khachhangJSP/dangnhap.jsp">Đăng nhập</a>
					<%
					} else {
					%>
					<p>
						Xin chào <b><%=khachHang.getTenDangNhap()%></b>
					</p>
					<br />
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor ">
						<li class="nav-item dropdown dropstart"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Tài khoản</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
								<li><a class="dropdown-item" href="#">Thông báo</a></li>
								<li><a class="dropdown-item"
									href="<%=url%>/khachhangJSP/thaydoianh.jsp">Thay đổi
										ảnh đại diện</a></li>
								<li><a class="dropdown-item"
									href="<%=url%>/khachhangJSP/thaydoithongtin.jsp">Thay đổi
										thông tin</a></li>
								<li><a class="dropdown-item"
									href="<%=url%>/khachhangJSP/doimatkhau.jsp">Đổi mật khẩu</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item"
									href="<%=url%>/khach-hang?hanhDong=dang-xuat">Thoát tài
										khoản</a></li>
								<!-- parameter=giaTriCuaParaĐó : doGet-->
							</ul></li>
					</ul>

					<!--  <a style="white-space: nowrap;" href="dang-xuat">Đăng xuất</a> -->
					<%
					}
					%>
				</form>
			</div>
		</div>
	</nav>
	<!-- End Navbar -->
</body>
</html>
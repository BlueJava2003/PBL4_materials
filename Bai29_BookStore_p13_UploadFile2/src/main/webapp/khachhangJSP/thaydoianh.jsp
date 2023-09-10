<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Thay đổi ảnh</title>
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
</head>

<style>
.red {
	color: red;
}
</style>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<%
	Object obj = session.getAttribute("khachHang");
	KhachHang khachHang = null;
	if (obj != null) {
		khachHang = (KhachHang) obj;
	}
	if (khachHang == null) {
	%>
	<h1>Bạn chưa đăng nhập, vui lòng đăng nhập trước khi đổi thông tin</h1>
	<%
	return;
	}
	%>

	<%
	String baoLoi = request.getAttribute("baoLoi") + "";
	baoLoi = baoLoi.equals("null") ? "" : baoLoi;

	String duongDanAnh = khachHang.getDuongDanAnh();

	%>

	<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	%>

	<h1 class="text-center">THAY ĐỔI ẢNH ĐẠI DIỆN</h1>
	<div class="red container" id="baoLoi"><%=baoLoi%>
	</div>
	<div class="container">
		<form class="form" action="<%=url%>/khanh-hang-thay-doi-anh" method="post" enctype="multipart/form-data">
			<input type="hidden" name="hanhDong" value="thay-doi-anh">
			<div class="row">
				<div class="col-md-6">
					<h3>Thông tin khách hàng</h3>
					<img src="<%=url %>/avatar/<%=duongDanAnh%>" width="300" alt="Ảnh Avatar"/>
					<div class="mb-3">
						<label for="duongDanAnh" class="form-label">Đường dẫn ảnh</label> <input
							type="file" class="form-control" id="duongDanAnh" name="duongDanAnh">
					</div>
				</div>
				<input class="btn btn-primary form-control" type="submit"
					value="Lưu thông tin" id="submit" name="submit">
			</div>
		</form>
	</div>
	<%@include file="../footer.jsp"%>
</body>
</html>
<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Thông tin khách hàng</title>
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
	.red{
		color: red;
	}
</style>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<%
	
		Object obj = session.getAttribute("khachHang");
		KhachHang khachHang = null;
		if(obj != null){
			khachHang = (KhachHang)obj;
		}
		if(khachHang==null) {
	%>
			<h1>Bạn chưa đăng nhập, vui lòng đăng nhập trước khi đổi thông tin</h1>
	<%
		return;
		}
	%>

	<% 
		String baoLoi = request.getAttribute("baoLoi")+"";
		baoLoi = baoLoi.equals("null") ? "" : baoLoi;
		
		
String hoVaTen= khachHang.getHoVaTen();
		
		String gioiTinh= khachHang.getGioiTinh();
		
		String ngaySinh= khachHang.getNgaySinh().toString();
		
		String diaChiKhachHang= khachHang.getDiaChi();
		
		String diaChiMuaHang= khachHang.getDiaChiMuaHang();
		
		String diaChiNhanHang= khachHang.getDiaChiNhanHang();
		
		String dienThoai= khachHang.getSoDienThoai();
		
		String email= khachHang.getEmail();
		
		boolean dongYNhanMail= khachHang.isDangKyNhanBangTin();
	%>
	
	<%
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
	%>
	
	<h1 class="text-center">THAY ĐỔI THÔNG TIN</h1>
	<div class="red container" id="baoLoi"><%=baoLoi %>
		</div>
	<div class="container">
		<form class="form" action="<%=url %>/khach-hang" method="post">
			<input type="hidden" name="hanhDong" value="thay-doi-thong-tin">
			<div class="row">
				<div class="col-md-6">
					<h3>Thông tin khách hàng</h3>
					<div class="mb-3">
						<label for="hoVaTen" class="form-label">Họ và tên</label> 
						<input type="text" class="form-control" id="hoVaTen" name="hoVaTen"  value="<%=hoVaTen%>">
					</div>
					<div class="mb-3">
						<label for="gioiTinh" class="form-label">Giới tính</label>
						<select class="form-control" id="gioiTinh" name="gioiTinh">
							<option></option>
							<option value="Nam" <%=(gioiTinh.equals("Nam"))?"selected='selected'":"" %> >Nam</option>
							<option value="Nữ" <%=(gioiTinh.equals("Nữ"))?"selected='selected'":"" %> >Nữ</option>
							<option value="Khác" <%=(gioiTinh.equals("Khác"))?"selected='selected'":"" %> >Khác</option>		
						</select>
					</div>
					<div class="mb-3">
						<label for="ngaySinh" class="form-label">Ngày sinh</label> 
						<input type="date" class="form-control" id="ngaySinh" name="ngaySinh"  value="<%=ngaySinh%>">
					</div>
					<hr/>
				</div>
				<div class="col-md-6">
					<h3>Địa chỉ</h3>
					<div class="mb-3">
						<label for="diaChiKhachHang" class="form-label">Địa chỉ khách hàng</label> 
						<input type="text" class="form-control" id="diaChiKhachHang"
						 name="diaChiKhachHang" value="<%=diaChiKhachHang%>">
					</div>
					<div class="mb-3">
						<label for="diaChiMuaHang" class="form-label">Địa chỉ mua hàng</label> 
						<input type="text" class="form-control" id="diaChiMuaHang"
						 name="diaChiMuaHang" value="<%=diaChiMuaHang%>">
					</div>
					<div class="mb-3">
						<label for="diaChiNhanHang" class="form-label">Địa chỉ nhận hàng</label> 
						<input type="text" class="form-control" id="diaChiNhanHang"
						 name="diaChiNhanHang" value="<%=diaChiNhanHang%>">
					</div>
					<div class="mb-3">
						<label for="dienThoai" class="form-label">Điện thoại</label> 
						<input type="tel" class="form-control" id="dienThoai" name="dienThoai" value="<%=dienThoai%>">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> 
						<input type="email" class="form-control" id="email" name="email" value="<%=email%>">
					</div>
					<div class="mb-3">
						<label for="dongYNhanMail" class="form-label">Đồng ý nhận mail<span id="red">*</span></label> 
						<input type="checkbox" class="form-check-input" id="dongYNhanMail" 
								name="dongYNhanMail" <%=(dongYNhanMail?"checked":"")%>>
					</div>
				</div>
				<input class="btn btn-primary form-control" type="submit" value="Lưu thông tin" 
					id="submit" name="submit">
			</div>
		</form>
	</div>
	<%@include file="../footer.jsp"%>
</body>
</html>
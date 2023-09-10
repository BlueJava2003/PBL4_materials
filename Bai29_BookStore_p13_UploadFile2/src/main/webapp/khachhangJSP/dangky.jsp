<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng ký tài khoản</title>
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
		String baoLoi = request.getAttribute("baoLoi")+"";
		baoLoi = baoLoi.equals("null") ? "" : baoLoi;
		
		String tenDangNhap= request.getAttribute("tenDangNhap")+"";	
		tenDangNhap = (tenDangNhap.equals("null"))?"":tenDangNhap;
		
		String hoVaTen= request.getAttribute("hoVaTen")+"";
		hoVaTen = (hoVaTen.equals("null"))?"":hoVaTen;
		
		String gioiTinh= request.getAttribute("gioiTinh")+"";
		gioiTinh = (gioiTinh.equals("null"))?"":gioiTinh;
		
		String ngaySinh= request.getAttribute("ngaySinh")+"";
		ngaySinh = (ngaySinh.equals("null"))?"":ngaySinh;
		
		String diaChiKhachHang= request.getAttribute("diaChiKhachHang")+"";
		diaChiKhachHang = (diaChiKhachHang.equals("null"))?"":diaChiKhachHang;
		
		String diaChiMuaHang= request.getAttribute("diaChiMuaHang")+"";
		diaChiMuaHang = (diaChiMuaHang.equals("null"))?"":diaChiMuaHang;
		
		String diaChiNhanHang= request.getAttribute("diaChiNhanHang")+"";
		diaChiNhanHang = (diaChiNhanHang.equals("null"))?"":diaChiNhanHang;
		
		String dienThoai= request.getAttribute("dienThoai")+"";
		dienThoai = (dienThoai.equals("null"))?"":dienThoai;
		
		String email= request.getAttribute("email")+"";
		email = (email.equals("null"))?"":email;
		
		String dongYNhanMail= request.getAttribute("dongYNhanMail")+"";
		dongYNhanMail = (dongYNhanMail.equals("null"))?"":dongYNhanMail;
	%>
	
	<%
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	%>
	<h1 class="text-center">ĐĂNG KÝ TÀI KHOẢN</h1>
	<div class="red container" id="baoLoi"><%=baoLoi %>
		</div>
	<div class="container">
		<form class="form" action="<%=url %>/khach-hang" method="post">
			<input type="hidden" name="hanhDong" value="dang-ky">
			<div class="row">
				<div class="col-md-6">
					<h3>Tài khoản</h3>
					<div class="mb-3">
						<label for="tenDangNhap" class="form-label">Tên đăng nhập<span class="red">*</span></label>
						<input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap"
						 required="required" value="<%=tenDangNhap%>">
					</div>
					<div class="mb-3">
						<label for="matKhau" class="form-label">Mật khẩu<span class="red">*</span></label> 
						<input type="password" class="form-control" id="matKhau" name="matKhau" required="required"
						onkeyup="kiemTraMatKhau()">
					</div>
					<div class="mb-3">
						<label for="matKhauNhapLai" class="form-label">Nhập lại mật khẩu<span class="red">*</span>
						<span id="msg" class="red"></span></label> 
						<input type="password" class="form-control" id="matKhauNhapLai" name="matKhauNhapLai"
						 required="required" onkeyup="kiemTraMatKhau()">
					</div>
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
						<label for="dongYDieuKhoan" class="form-label">Đồng ý với điều khoản của công ty<span class="red">*</span></label> 
						<input type="checkbox" class="form-check-input" id="dongYDieuKhoan"
						 name="dongYDieuKhoan" required="required" onchange="xuLyChonDongY()">
					</div>
					<div class="mb-3">
						<label for="dongYNhanMail" class="form-label">Đồng ý nhận mail<span id="red">*</span></label> 
						<input type="checkbox" class="form-check-input" id="dongYNhanMail" name="dongYNhanMail">
					</div>
				</div>
				<input class="btn btn-primary form-control" type="submit" value="Đăng ký" 
					id="submit" name="submit" style="visibility: hidden;">
			</div>
		</form>
	</div>
	
	<%@include file="../footer.jsp"%>
</body>

<script>
	function kiemTraMatKhau(){
		matKhau = document.getElementById("matKhau").value;		
		matKhauNhapLai = document.getElementById("matKhauNhapLai").value;

		if(matKhau != matKhauNhapLai){
			document.getElementById("msg").innerHTML = "Mật khẩu không khớp";
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}

	function xuLyChonDongY(){
		dongYDeuKhoan = document.getElementById("dongYDieuKhoan");
		if(dongYDeuKhoan.checked==true){
			document.getElementById("submit").style.visibility="visible";
		} else {
			document.getElementById("submit").style.visibility="hidden";
		}
	}
</script>
</html>
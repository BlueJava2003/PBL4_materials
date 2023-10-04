<%@page import="dao.JdbcAccountDao"%>
<%@page import="dao.AccountDao"%>
<%@page import="persistence.Account"%>
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
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
		
//		AccountDao accountDao = new JdbcAccountDao();
//		Account accCount = (Account)request.getAttribute("ac");
		
//		Account acc = accountDao.getAccountByEmail(accCount.getEmail());
//		request.setAttribute("acc", acc);
	
	%>
	<h1 class="text-center">ĐĂNG KÝ TÀI KHOẢN</h1>
	<div class="container">
		<form class="form" action="<%=url %>/signupinformation" method="post">
			<input type="hidden" name="hanhDong" value="dang-ky">
			<div class="row">
				<div class="col-md-6">
					<h3>Thông tin khách hàng</h3>
					<div class="mb-3">
						<label for="customerEmail" class="form-label">Email</label> 
						<input type="email" class="form-control" id="customerEmail" name="customerEmail" value="${ac.email}" readonly>
					</div>
					<div class="mb-3">
						<label for="customerName" class="form-label">Họ và tên</label> 
						<input type="text" class="form-control" id="customerName" name="customerName">
					</div>
					<div class="mb-3">
						<label for="customerGender" class="form-label">Giới tính</label>
						<select class="form-control" id="customerGender" name="customerGender" required>
							<option></option>
							<option value="Nam">Nam</option>
							<option value="Nữ">Nữ</option>
							<option value="Khác">Khác</option>		
						</select>
					</div>
					<div class="mb-3">
						<label for="customerDateOfBirth" class="form-label">Ngày sinh</label> 
						<input type="date" class="form-control" id="customerDateOfBirth" name="customerDateOfBirth" required>
					</div>
					<hr/>
				</div>
				<div class="col-md-6">
					<h3>Thông tin thêm</h3>
					<div class="mb-3">
						<label for="customerAddress" class="form-label">Địa chỉ</label> 
						<input type="text" class="form-control" id="customerAddress"
						 name="customerAddress" required>
					</div>
					<div class="mb-3">
						<label for="customerPhoneNum" class="form-label">Điện thoại</label> 
						<input type="number" class="form-control" id="customerPhoneNum" name="customerPhoneNum" required>
					</div>
					<div class="mb-3">
						<label for="customerLinkSocial" class="form-label">Link mạng xã hội(Facebook, Twitter,...)</label> 
						<input type="text" class="form-control" id="customerLinkSocial" name="customerLinkSocial">
					</div>
					<div class="mb-3">
						<label for="dongYDieuKhoan" class="form-label">Đồng ý với điều khoản của công ty<span class="red">*</span></label> 
						<input type="checkbox" class="form-check-input" id="dongYDieuKhoan"
						 name="dongYDieuKhoan" required="required" onchange="xuLyChonDongY()">
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
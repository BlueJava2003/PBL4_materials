package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.KhachHangDAO;
import model.KhachHang;
import util.Email;
import util.MaHoa;
import util.SoNgauNhien;

/**
 * Servlet implementation class KhachHang
 */
@WebServlet("/khach-hang")
public class KhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KhachHangServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String hanhDong = request.getParameter("hanhDong");
		System.out.println(hanhDong);
		if (hanhDong.equals("dang-nhap")) {
			dangNhap(request, response);
		} else if (hanhDong.equals("dang-xuat")) {
			dangXuat(request, response);
		} else if (hanhDong.equals("dang-ky")) {
			dangKy(request, response);
		} else if (hanhDong.equals("thay-doi-thong-tin")) {
			thayDoiThongTin(request, response);
		} else if (hanhDong.equals("doi-mat-khau")) {
			doiMatKhau(request, response);
		} else if(hanhDong.equals("xac-thuc")) {
			xacThuc(request, response);
		} else if(hanhDong.equals("thay-doi-anh")) {
			thayDoiAnh(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		doGet(request, response);
	}

	private void dangNhap(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");

			matKhau = MaHoa.toSHA1(matKhau);

			KhachHang kh = new KhachHang();
			kh.setTenDangNhap(tenDangNhap);
			kh.setMatKhau(matKhau);

			KhachHangDAO khD = new KhachHangDAO();
			KhachHang khachHang = khD.selectByUsernameAndPassword(kh);

			String url = "";
			String baoLoi = "";
			System.out.println(tenDangNhap);
			System.out.println(matKhau);
			if (khachHang != null && khachHang.isTrangThaiXacThuc()) {
				HttpSession session = request.getSession();
				// request.setAttribute("khachHang", khachHang);
				session.setAttribute("khachHang", khachHang);
				url = "/index.jsp"; // khachhangJSP/ --> webapp là folder mặc định của JSP
			} else {
				request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng!");
				url = "/khachhangJSP/dangnhap.jsp";
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void dangXuat(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			HttpSession session = request.getSession();

			// Hủy bỏ session
			session.invalidate();

			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
			System.out.println(url);
			response.sendRedirect(url + "/index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void dangKy(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			// Lấy thông tin của khách hàng
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			String matKhauNhapLai = request.getParameter("matKhauNhapLai");
			String hoVaTen = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			String diaChiMuaHang = request.getParameter("diaChiMuaHang");
			String diaChiNhanHang = request.getParameter("diaChiNhanHang");
			String dienThoai = request.getParameter("dienThoai");
			String email = request.getParameter("email");
			String dongYNhanMail = request.getParameter("dongYNhanMail");

			// Giữ lại thông tin
			request.setAttribute("tenDangNhap", tenDangNhap);
			request.setAttribute("hoVaTen", hoVaTen);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("diaChiKhachHang", diaChiKhachHang);
			request.setAttribute("diaChiMuaHang", diaChiMuaHang);
			request.setAttribute("diaChiNhanHang", diaChiNhanHang);
			request.setAttribute("dienThoai", dienThoai);
			request.setAttribute("dongYNhanMail", dongYNhanMail);

			String url = "";
			// Xử lý lỗi
			String baoLoi = "";

			KhachHangDAO khachHangDAO = new KhachHangDAO();
			if (khachHangDAO.selectById(tenDangNhap)) {
				baoLoi = "Tên đăng nhập đã tồn tại";

			}
			if (!matKhau.equals(matKhauNhapLai)) {
				baoLoi = "Mật khẩu không khớp";
			} else {
				matKhau = MaHoa.toSHA1(matKhau);
			}

			if (baoLoi.length() > 0) {
				System.out.println(baoLoi);
				url = "/khachhangJSP/dangky.jsp";
			} else {
				System.out.println(baoLoi);
				String maKhachHang = System.currentTimeMillis() + "";
				KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChiKhachHang,
						diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail != null);
				// khachHangDAO.insert(kh); --> Hàm thêm đồng thời check điều kiện
				if (khachHangDAO.insert(kh) > 0) {
					String soNgauNhien = SoNgauNhien.getSoNgauNhien();
					Calendar c = Calendar.getInstance();
					c.add(Calendar.DATE, 1);
					Date thoiGianHieuLuc = new Date(c.getTimeInMillis());
					boolean trangThaiXacThuc = false;
					kh.setMaXacThuc(soNgauNhien);
					kh.setThoiGianXacThuc(thoiGianHieuLuc);
					kh.setTrangThaiXacThuc(trangThaiXacThuc);

					if (khachHangDAO.updateVerifyInfo(kh) > 0) {
						Email.sendEmail(kh.getEmail(), "Xác thực tài khoản", getNoiDung(kh));
					}
				}
				url = "/khachhangJSP/thanhcong.jsp";
			}
			request.setAttribute("baoLoi", baoLoi);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getNoiDung(KhachHang kh) {
		String link = "http://localhost:8080/Bai4_Bootstrap/khach-hang?hanhDong=xac-thuc&maKhachHang="+kh.getMaKhacHang()+"&maXacThuc="+kh.getMaXacThuc();
		String noiDung = "<!-- ####### HEY, I AM THE SOURCE EDITOR! #########-->\r\n"
				+ "<h1 style=\"color: #5e9ca0;\">X&aacute;c thực t&agrave;i khoản</h1>\r\n"
				+ "<h2 style=\"color: #2e6c80;\">Xin ch&agrave;o bạn" + kh.getHoVaTen() + "</h2>\r\n"
				+ "<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản, m&atilde; của bạn l&agrave; <strong>"
				+ kh.getMaXacThuc() + "</strong>, hoặc click trực tiếp v&agrave;o link sau đ&acirc;y:</p>\r\n"
				+ "<p><a href=\""+link+"\">"+link+"</a></p>\r\n"
				+ "<p>Đ&acirc;y l&agrave; email tự động, vui l&ograve;ng kh&ocirc;ng reply email n&agrave;y.</p>\r\n"
				+ "<p>Tr&acirc;n trọng cảm ơn!</p>\r\n" + "<p><strong>&nbsp;</strong></p>";
		return noiDung;
	}

	private void thayDoiThongTin(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			// Lấy thông tin của khách hàng
			String hoVaTen = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			String diaChiMuaHang = request.getParameter("diaChiMuaHang");
			String diaChiNhanHang = request.getParameter("diaChiNhanHang");
			String dienThoai = request.getParameter("dienThoai");
			String email = request.getParameter("email");
			String dongYNhanMail = request.getParameter("dongYNhanMail");

			// Giữ lại thông tin
			request.setAttribute("hoVaTen", hoVaTen);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("diaChiKhachHang", diaChiKhachHang);
			request.setAttribute("diaChiMuaHang", diaChiMuaHang);
			request.setAttribute("diaChiNhanHang", diaChiNhanHang);
			request.setAttribute("dienThoai", dienThoai);
			request.setAttribute("dongYNhanMail", dongYNhanMail);

			String url = "";
			// Xử lý lỗi
			String baoLoi = "";

			KhachHangDAO khachHangDAO = new KhachHangDAO();

			request.setAttribute("baoLoi", baoLoi);

			if (baoLoi.length() > 0) {
				url = "/khachhangJSP/dangky.jsp";
			} else {
				Object obj = request.getSession().getAttribute("khachHang");
				KhachHang khachHang = null;
				if (obj != null)
					khachHang = (KhachHang) obj;
				if (khachHang != null) {
					String maKhachHang = khachHang.getMaKhacHang();
					KhachHang kh = new KhachHang(maKhachHang, "", "", hoVaTen, gioiTinh, diaChiKhachHang,
							diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email,
							dongYNhanMail != null);
					khachHangDAO.updateInfo(kh);
					KhachHang kh2 = khachHangDAO.selectById(kh);
					request.getSession().setAttribute("khachHang", kh2);
					url = "/khachhangJSP/thanhcong.jsp";
				}

			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doiMatKhau(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			String matKhauHienTai = request.getParameter("matKhauHienTai");
			String matKhauMoi = request.getParameter("matKhauMoi");
			String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");

			String baoLoi = "";
			String url = "/khachhangJSP/doimatkhau.jsp";

			// Kiem tra mat khau cu co giong hay khong
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("khachHang");
			KhachHang khachHang = null;

			String matKhauHienTai_Sha1 = MaHoa.toSHA1(matKhauHienTai);

			if (obj != null)
				khachHang = (KhachHang) obj;
			if (khachHang == null) {
				baoLoi = "Bạn chưa đăng nhập vào hệ thống!";
			} else {
				if (!matKhauHienTai_Sha1.equals(khachHang.getMatKhau())) {
					baoLoi = "Mật khẩu hiện tại không chính xác";
				} else {
					if (!matKhauMoi.equals(matKhauMoiNhapLai)) {
						baoLoi = "Mật khẩu không khớp";
					} else {
						String matKhauMoi_SHA1 = MaHoa.toSHA1(matKhauMoi);
						khachHang.setMatKhau(matKhauMoi_SHA1);
						KhachHangDAO khD = new KhachHangDAO();
						if (khD.changePassword(khachHang)) {
							baoLoi = "Mật khẩu đã thay đổi thành công";
						} else {
							baoLoi = "Quá trình thay đổi mật khẩu đã thay đổi không thành công";

						}
					}
				}
			}
			url = "/khachhangJSP/doimatkhau.jsp";
			request.setAttribute("baoLoi", baoLoi);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void xacThuc(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			// Lấy thông tin của khách hàng
			String maKhachHang = request.getParameter("maKhachHang");
			String maXacThuc = request.getParameter("maXacThuc");
			// Xử lý lỗi
			String baoLoi = "";

			KhachHangDAO khachHangDAO = new KhachHangDAO();

			KhachHang kh = new KhachHang();
			kh.setMaKhacHang(maKhachHang);
			KhachHang khachHang = khachHangDAO.selectById(kh);
			String msg = "";

			if (khachHang != null) {
				if (khachHang.getMaXacThuc().equals(maXacThuc)) {
					khachHang.setTrangThaiXacThuc(true);
					khachHangDAO.updateVerifyInfo(khachHang);
					msg = "Xác thực thành công";
				} else {
					msg = "Xác thực không thành công";
				}
			} else {
				msg = "Tài khoản không tồn tại";
			}
			String url = "/khachhangJSP/thongbao.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void thayDoiAnh(HttpServletRequest request, HttpServletResponse response) {
		Object obj = request.getSession().getAttribute("khachHang");
		KhachHang khachHang = null;
		if (obj != null)
			khachHang = (KhachHang) obj;
		if (khachHang != null) {
			try {
				String folder = getServletContext().getRealPath("avatar");
				System.out.println(folder);
				File file;
				int maxFileSize = 5000 * 1024;
				int maxMemSize = 5000 * 1024;

				String contentType = request.getContentType();

				if (contentType.indexOf(contentType) >= 0) {
					DiskFileItemFactory factory = new DiskFileItemFactory();

					// Quy dinh dung luong toi da cho 1 file
					factory.setSizeThreshold(maxMemSize);

					// Tao file upload
					ServletFileUpload upload = new ServletFileUpload(factory);

					upload.setSizeMax(maxFileSize);

					List<FileItem> files = upload.parseRequest(request);

					for (FileItem fileItem : files) {
						if(!fileItem.isFormField()) {
							String fileName = System.currentTimeMillis() + fileItem.getName();
							String path = folder + "\\" + fileName;
							file = new File(path);
	
							fileItem.write(file);
	
							khachHang.setDuongDanAnh(fileName);
							KhachHangDAO khachHangDAO = new KhachHangDAO();
							khachHangDAO.updateImage(khachHang);
							khachHang = khachHangDAO.selectById(khachHang);
						}else {
							String name = fileItem.getFieldName();
							String value = fileItem.getString();
							System.out.println(name+" : "+value);
						}
					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

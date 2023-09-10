
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonHang;
import model.KhachHang;
import model.TacGia;

public class DonHangDAO implements DAOInterface<DonHang> {

	@Override
	public ArrayList<DonHang> selectAll() {
		ArrayList<DonHang> ketQua = new ArrayList<DonHang>();
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM donhang";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maDH = rs.getString(1);
				String maKH = rs.getString(2);
				String diaChiMuaHang = rs.getString(3);
				String diaChiNhanHang = rs.getString(4);
				String trangThai = rs.getString(5);
				String hinhThucThanhToan = rs.getString(6);
				double soTienDaThanhToan = rs.getDouble(7);
				double soTienConThieu = rs.getDouble(8);
				Date ngayDatHang = rs.getDate(9);
				Date ngayGiaoHang = rs.getDate(10);

				KhachHang khachHang = new KhachHangDAO()
						.selectById(new KhachHang(maKH, "", "", "", "", "", "", "", null, "", "", false));
				DonHang dh = new DonHang(maDH, khachHang, diaChiMuaHang, diaChiNhanHang, trangThai, hinhThucThanhToan,
						trangThai,soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang);

				ketQua.add(dh);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public DonHang selectById(DonHang t) {
		DonHang ketQua = null;
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM donhang WHERE madonhang = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maDH = rs.getString(1);
				String maKH = rs.getString(2);
				String diaChiMuaHang = rs.getString(3);
				String diaChiNhanHang = rs.getString(4);
				String trangThai = rs.getString(5);
				String hinhThucThanhToan = rs.getString(6);
				double soTienDaThanhToan = rs.getDouble(7);
				double soTienConThieu = rs.getDouble(8);
				Date ngayDatHang = rs.getDate(9);
				Date ngayGiaoHang = rs.getDate(10);

				KhachHang khachHang = new KhachHangDAO()
						.selectById(new KhachHang(maKH, "", "", "", "", "", "", "", null, "", "", false));
				DonHang dh = new DonHang(maDH, khachHang, diaChiMuaHang, diaChiNhanHang, trangThai, hinhThucThanhToan,
						trangThai,soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang);

				ketQua = dh;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insert(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "INSERT INTO donhang(madonhang, khachhang, diaChiMuaHang, diachinguoinhan, trangthai, thanhtoan,tienthanhtoan, tienthieu,ngaydathang,ngaygiaohang)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			st.setString(2, t.getKhachHang().getMaKhacHang());
			st.setString(3, t.getDiaChiMuaHang());
			st.setString(4, t.getDiaChiNhanHang());
			st.setString(5, t.getTrangThai());
			st.setDouble(6, t.getSoTienDaThanhToan());
			st.setDouble(8, t.getSoTienConThieu());
			st.setDate(9, t.getNgayDatHang());
			st.setDate(10, t.getNgayGiaoHang());

			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int insertAll(ArrayList<DonHang> arr) {
		int kq = 0;
		for (DonHang donHang : arr) {
			kq += this.insert(donHang);
		}
		return kq;
	}

	@Override
	public int delete(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM donhang WHERE madonhang = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int deleteAll(ArrayList<DonHang> arr) {
		int kq = 0;
		for (DonHang t : arr) {
			kq += this.delete(t);
		}
		return kq;
	}

	@Override
	public int update(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();

		String sql = "UPDATE donhang" + " SET " + "khachhang=?" + ", diaChiMuaHang=?" + ",diachinguoinhan=?"
				+ ",trangthai=?" + ",thanhtoan=?" + ",tienthanhtoan=?" + ",tienthieu=?" + ",ngaydathang=?"
				+ ",ngaygiaohang=?" + " WHERE madonhang=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			st.setString(2, t.getKhachHang().getMaKhacHang());
			st.setString(3, t.getDiaChiMuaHang());
			st.setString(4, t.getDiaChiNhanHang());
			st.setString(5, t.getTrangThai());
			st.setDouble(6, t.getSoTienDaThanhToan());
			st.setDouble(8, t.getSoTienConThieu());
			st.setDate(9, t.getNgayDatHang());
			st.setDate(10, t.getNgayGiaoHang());

			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

}
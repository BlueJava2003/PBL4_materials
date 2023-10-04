package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import connection.DBConnection;
import persistence.Account;
import persistence.Customer;
import utils.SqlUtils;

public class JdbcCustomerDao implements CustomerDao{
	private final Connection connection;
	private Statement st; // Wrapper wrap sql -> run sql in rdbms & full sql without parameter, sql
							// injection
	private ResultSet rs; // temporary table after execute query
	private PreparedStatement pst; // Passing parameter into SQL

	public JdbcCustomerDao() {
		connection = DBConnection.getConnection();
	}
	
	@Override
	public void createNewCustomer(Customer c, Account ac) {
		String sql = "Insert into khachhang (TenKH, GioiTinh, NgaySinh, SDT, DiaChi, MXH, AnhDaiDien, Email)"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setString(2, c.getGender());
			pst.setDate(3, c.getDateOfBirth());
			pst.setString(4, c.getPhoneNumber());
			pst.setString(5, c.getAddress());
			pst.setString(6, c.getMXH());
			pst.setString(7, c.getAvatar());
			pst.setString(8, ac.getEmail());			
			pst.executeUpdate();
			System.out.println("Đăng ký thành công");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
	}
	
	public static void main(String[] args) {
		Account ac = new Account("tphuongnam98@gmail.com", "123", 0, 0, null);
		new JdbcCustomerDao()
		.createNewCustomer(new Customer(null, 
										"Na", 
										"Nam", 
										Date.valueOf(LocalDate.now()), 
										"QN", 
										"0332680025", 
										"FB", 
										null,
										"tphuongnam98@gmail.com"),ac);
		System.out.println("Thafnh coong");
	}
}

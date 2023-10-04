package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DBConnection;
import persistence.Account;
import persistence.ProductGroup;
import utils.SqlUtils;

public class JdbcAccountDao implements AccountDao {

	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public JdbcAccountDao(){
		connection = DBConnection.getConnection();
	}
	
	@Override
	public Account getAccountByEmail(String email) {
		Account result = null;
		String sql = "Select * from taikhoan where email = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			while (rs.next()) {
				result = new Account(email, 
									rs.getString("Password"), 
									rs.getInt("Role"), 
									rs.getInt("Active"), 
									rs.getString("MaXacThuc"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}

	@Override
	public Account getAccountByEmailAndPassword(String email, String password) {
		Account result = null;
		String sql = "Select * from taikhoan where email = ? and password = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			while (rs.next()) {
				result = new Account(email, 
									rs.getString("Password"), 
									rs.getInt("Role"), 
									rs.getInt("Active"), 
									rs.getString("MaXacThuc"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	@Override
	public void createNewAccount(Account t) {
		String sql = "Insert into taikhoan values(?,?,?,?,?)";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, t.getEmail());
			pst.setString(2, t.getPassword());
			pst.setInt(3, 1);
			pst.setInt(4, 0);
			pst.setString(5, t.getVerifyCode());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
	}

	
	public static void main(String[] args) {
		System.out.println(new JdbcAccountDao().getAccountByEmail("tphuongnam98@gmail.com"));
		// new JdbcAccountDao().createNewAccount(new Account("t@gmail.com", "23", 1, 1, null));
	}
}

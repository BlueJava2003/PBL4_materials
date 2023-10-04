package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import persistence.ProductGroup;
import utils.SqlUtils;

public class JdbcProductGroupDao implements ProductGroupDao{

	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public JdbcProductGroupDao(){
		connection = DBConnection.getConnection();
	}
	
	@Override
	public List<ProductGroup> getAll() {
		List<ProductGroup> result = new ArrayList<>();
		String sql = "Select * from loaihang";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				ProductGroup pg = new ProductGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				result.add(pg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	@Override
	public ProductGroup getProductGroupById(int id) {
		ProductGroup result = null;
		String sql = "Select * from loaihang where MaLH = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				result = new ProductGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<ProductGroup> list = new JdbcProductGroupDao().getAll();
		for(ProductGroup productGroup : list) {
			System.out.println(productGroup);
		}
		
		System.out.println(new JdbcProductGroupDao().getProductGroupById(1));
	}
}

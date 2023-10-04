package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import persistence.Product;
import persistence.ProductGroup;
import persistence.ProductSize;
import utils.SqlUtils;

public class JdbcProductDao implements ProductDao {

	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public JdbcProductDao(){
		connection = DBConnection.getConnection();
	}

	@Override
	public List<Product> getAll() {		
		List<Product> result = new ArrayList<>();
		String sql = "Select  * from mathang mh, chitietmathang ctmh, loaihang lh, kichco kc"
				+ " where mh.MaMH = ctmh.MaMH and mh.MaLH = lh.MaLH and ctmh.MaKC = kc.MaKC";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				ProductGroup pg = new ProductGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				ProductSize pz = new ProductSize(rs.getInt("MaKC"), rs.getString("MoTaKichCo"));
				Product p = new Product(rs.getInt("MaMH"), 
										rs.getString("TenMH"), 
										rs.getString("MauSac"),
										rs.getString("HinhAnh"), 
										rs.getDouble("GiaBan"), 
										rs.getDouble("GiaMua"), 
										rs.getInt("SoLuong"),
										rs.getString("MoTaSanPham"), pg, pz);
				result.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	@Override
	public Product getNewestProduct() {
		Product result = null;
		String sql = "Select * from mathang mh, chitietmathang ctmh where mh.MaMH = ctmh.MaMH";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				result = new Product();
				result.setId(rs.getInt("MaMH"));
				result.setName(rs.getString("TenMH"));
				result.setSalesPrice(rs.getDouble("GiaBan"));
				result.setImage(rs.getString("HinhAnh"));
				result.setDescription(rs.getString("MoTaSanPham"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	@Override
	public List<Product> getListProductsByPGId(int id) {
		List<Product> result = new ArrayList<>();
		String sql = "Select  * from mathang mh, chitietmathang ctmh, loaihang lh, kichco kc"
				+ " where mh.MaMH = ctmh.MaMH and mh.MaLH = lh.MaLH and ctmh.MaKC = kc.MaKC and lh.MaLH = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				ProductGroup pg = new ProductGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				ProductSize pz = new ProductSize(rs.getInt("MaKC"), rs.getString("MoTaKichCo"));
				Product p = new Product(rs.getInt("MaMH"), 
										rs.getString("TenMH"), 
										rs.getString("MauSac"),
										rs.getString("HinhAnh"), 
										rs.getDouble("GiaBan"), 
										rs.getDouble("GiaMua"), 
										rs.getInt("SoLuong"),
										rs.getString("MoTaSanPham"), pg, pz);
				result.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	@Override
	public Product getProductById(int id) {
		Product p = null;
		String sql = "Select  * from mathang mh, chitietmathang ctmh, loaihang lh, kichco kc"
				+ " where mh.MaMH = ctmh.MaMH and mh.MaLH = lh.MaLH and ctmh.MaKC = kc.MaKC and mh.MaMH = ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				ProductGroup pg = new ProductGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				ProductSize pz = new ProductSize(rs.getInt("MaKC"), rs.getString("MoTaKichCo"));
				p = new Product(rs.getInt("MaMH"), 
										rs.getString("TenMH"), 
										rs.getString("MauSac"),
										rs.getString("HinhAnh"), 
										rs.getDouble("GiaBan"), 
										rs.getDouble("GiaMua"), 
										rs.getInt("SoLuong"),
										rs.getString("MoTaSanPham"), pg, pz);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return p;
	}
	
	@Override
	public List<Product> getProductByName(String name) {
		String searchString = "%"+name+"%";
		System.out.println(searchString);
		List<Product> result = new ArrayList<>();
		String sql = "Select  * from mathang mh, chitietmathang ctmh, loaihang lh, kichco kc"
				+ " where mh.MaMH = ctmh.MaMH and mh.MaLH = lh.MaLH and ctmh.MaKC = kc.MaKC and mh.TenMH like ?";
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, searchString);
			rs = pst.executeQuery();
			while (rs.next()) {
				ProductGroup pg = new ProductGroup(rs.getInt("MaLH"), rs.getString("TenLH"));
				ProductSize pz = new ProductSize(rs.getInt("MaKC"), rs.getString("MoTaKichCo"));
				Product p = new Product(rs.getInt("MaMH"), 
										rs.getString("TenMH"), 
										rs.getString("MauSac"),
										rs.getString("HinhAnh"), 
										rs.getDouble("GiaBan"), 
										rs.getDouble("GiaMua"), 
										rs.getInt("SoLuong"),
										rs.getString("MoTaSanPham"), pg, pz);
				result.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Product> lists = new JdbcProductDao().getAll();
		for(Product product : lists) {
			System.out.println(product);
		}
		
		System.out.println("Get newest-->" + new JdbcProductDao().getNewestProduct());
		System.out.println("Get product by id 1 --> " + new JdbcProductDao().getProductById(1));
		List<Product> listName = new JdbcProductDao().getProductByName("áo");
		for(Product product : listName) {
			System.out.println(product);
		}
	}
}

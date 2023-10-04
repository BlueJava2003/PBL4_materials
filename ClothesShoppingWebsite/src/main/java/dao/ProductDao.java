package dao;

import java.util.List;

import persistence.Product;

public interface ProductDao {
	List<Product> getAll();
	
	Product getNewestProduct();
	
	List<Product> getListProductsByPGId(int id);
	
	Product getProductById(int id);
	
	List<Product> getProductByName(String name);
}

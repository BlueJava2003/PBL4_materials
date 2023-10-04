package dao;

import java.util.List;

import persistence.ProductGroup;

public interface ProductGroupDao {
	List<ProductGroup> getAll();
	
	ProductGroup getProductGroupById(int id);
	
}

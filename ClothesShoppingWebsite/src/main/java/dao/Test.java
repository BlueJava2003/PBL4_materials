package dao;

import java.util.List;

import persistence.Product;

public class Test {
	public static void main(String[] args) {
		List<Product> lists = new JdbcProductDao().getAll();
		for(Product product : lists) {
			System.out.println(product);
		}
	}
}

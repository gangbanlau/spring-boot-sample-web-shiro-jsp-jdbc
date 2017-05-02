package my.mycompany.myapp.repository;

import my.mycompany.myapp.domain.Product;

public interface IProductDao extends IBaseDao<Product, Long> {
	/**
	 * Find product by its unique name
	 * 
	 * @param name product's name
	 * @return product
	 */
	public Product findOne(String name);
}
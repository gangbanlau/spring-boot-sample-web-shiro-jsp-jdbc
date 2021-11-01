package my.mycompany.myapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import my.mycompany.myapp.domain.Product;
import my.mycompany.myapp.repository.IProductDao;
import my.mycompany.myapp.service.IProductsService;

@Slf4j
@Service
public class ProductsServiceImpl implements IProductsService {
	@Autowired
	IProductDao productDao;

	public List<Product> findAllProducts() {
		return productDao.findAll();
	}

	public Product findOneProduct(Long id) {
		return productDao.findOne(id);
	}

	@Transactional
	public void deleteProduct(Long id) {
		productDao.delete(id);
	}

	@Transactional
	public Product insertProduct(Product prod) {
		return productDao.insert(prod);
	}

	@Transactional
	public void increasePrice(int percentage) {
		List<Product> products = productDao.findAll();
		if (products != null) {
			for (Product product : products) {
				double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100;
				product.setPrice(newPrice);
				productDao.update(product);
			}
		} else {
			log.warn("no product to increase price");
		}
	}
}
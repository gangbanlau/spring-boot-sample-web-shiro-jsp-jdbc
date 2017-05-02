package my.mycompany.myapp.service;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import my.mycompany.myapp.service.IProductsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)	// Don't replace the application default DataSource.
public class ProductsServiceImplTests {

	private static final Logger logger = LoggerFactory.getLogger(ProductsServiceImplTests.class);
	
	@Autowired
	IProductsService productService;
	
	@Test
	@Transactional
	public void testIncreasePrice() {
		double oldPrice = productService.findOneProduct(1L).getPrice().doubleValue();
		
		this.productService.increasePrice(100);
		
		double newPrice = productService.findOneProduct(1L).getPrice().doubleValue();
		
		Assert.assertEquals(oldPrice * 2, newPrice, 0.001);
	}
	
	@Test
	public void testFineOneProduct() {
		Assert.assertEquals("product not exists?", true, 
				null != productService.findOneProduct(1L));		
	}
	
	@Test(expected = EmptyResultDataAccessException.class)
	public void testFindOneProductNotExists() {
		productService.findOneProduct(1000L);
	}
	
	@Ignore("Not Ready to Run")  
	@Test(timeout = 1000)
	public void testdivisionWithException() {
		logger.warn("Not Ready to Run");
	}  
 	
}

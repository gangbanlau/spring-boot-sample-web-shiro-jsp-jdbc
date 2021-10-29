package my.mycompany.myapp.service;

import static java.time.Duration.ofMillis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import my.mycompany.myapp.service.IProductsService;

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
		
		assertEquals(oldPrice * 2, newPrice, 0.001);
	}
	
	@Test
	public void testFineOneProduct() {
		assertEquals(true, 
				null != productService.findOneProduct(1L), "product not exists?");		
	}
	
	@Test
	public void testFindOneProductNotExists() {
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			productService.findOneProduct(1000L);
		  });
	}
	
	@Disabled("Not Ready to Run")  
	@Test
	public void testdivisionWithException() {
		assertTimeout(ofMillis(1000), () -> {
			logger.warn("Not Ready to Run");
		});
	}
}

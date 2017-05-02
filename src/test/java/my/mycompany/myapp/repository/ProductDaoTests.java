package my.mycompany.myapp.repository;

import java.util.List;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

import my.mycompany.myapp.domain.Product;
import my.mycompany.myapp.repository.IProductDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)	// Don't replace the application default DataSource.
public class ProductDaoTests {

	private static final Logger logger = LoggerFactory.getLogger(ProductDaoTests.class);
	
	@Autowired
	IProductDao productDao;

    @BeforeClass
    public static void oneTimeSetUp() {
        // one-time initialization code   
    	logger.info("@BeforeClass - oneTimeSetUp");
    }
 
    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
    	logger.info("@AfterClass - oneTimeTearDown");
    }
    

    @BeforeTransaction
    public void verifyInitialDatabaseState() {
        // logic to verify the initial state before a transaction is started
    	logger.info("@BeforeTransaction verifyInitialDatabaseState");
    }


    @AfterTransaction
    public void verifyFinalDatabaseState() {
        // logic to verify the final state after transaction has rolled back
    	logger.info("@AfterTransaction verifyFinalDatabaseState");
    }
    
	@Before
	public void setUp() {
		logger.info("@Before setUp");
	}

	@After
	public void tearDown() {
		logger.info("@After tearDown");
	}

	@Test
	@Transactional
	public void testDelete() {
		productDao.delete(1L);
		productDao.delete(2L);
		productDao.delete(3L);
	}
	
	@Test
	public void testCount() {
		assertThat(productDao.count()).isEqualTo(3);
	}
	
	@Test
	public void testExists() {
		assertTrue(productDao.exists(1L));
	}
	
	@Test 
	public void testFindOne() {
		assertThat(productDao.findOne(1L).getName()).isEqualTo("Lamp");
		assertThat(productDao.findOne("Lamp").getName()).isEqualTo("Lamp");
	}
	
	@Test
	public void testFindAll() {

		List<Product> products = productDao.findAll();

		assertThat(products.size()).isEqualTo(3);
	}
	
	@Test
	@Transactional
	public void testInsert() {
		Product prod = new Product();
		prod.setName("Train");
		prod.setPrice(2999D);
		prod = productDao.insert(prod);
		/*
		 * failed if using mysql db and we run test case twice after new table
		 */
		//assertThat(prod.getId().longValue()).isEqualTo(4L);
	}
	
	@Test
	@Transactional
	public void testUpdate() {

		List<Product> products = productDao.findAll();

		for (Product p : products) {
			p.setPrice(200.12);
			productDao.update(p);
		}

		List<Product> updatedProducts = productDao.findAll();
		for (Product p : updatedProducts) {
			assertThat(p.getPrice()).isEqualTo(200.12);
		}

	}

}

package my.mycompany.myapp.repository;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import my.mycompany.myapp.domain.Product;
import my.mycompany.myapp.repository.IProductDao;

@Slf4j
@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)	// Don't replace the application default DataSource.
public class ProductDaoTests {
	@Autowired
	IProductDao productDao;

    @BeforeAll
    public static void oneTimeSetUp() {
        // one-time initialization code   
    	log.info("@BeforeClass - oneTimeSetUp");
    }
 
    @AfterAll
    public static void oneTimeTearDown() {
        // one-time cleanup code
    	log.info("@AfterClass - oneTimeTearDown");
    }
    

    @BeforeTransaction
    public void verifyInitialDatabaseState() {
        // logic to verify the initial state before a transaction is started
    	log.info("@BeforeTransaction verifyInitialDatabaseState");
    }


    @AfterTransaction
    public void verifyFinalDatabaseState() {
        // logic to verify the final state after transaction has rolled back
    	log.info("@AfterTransaction verifyFinalDatabaseState");
    }
    
	@BeforeEach
	public void setUp() {
		log.info("@Before setUp");
	}

	@AfterEach
	public void tearDown() {
		log.info("@After tearDown");
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
		assertEquals(productDao.count(), 3);
	}
	
	@Test
	public void testExists() {
		assertTrue(productDao.exists(1L));
	}
	
	@Test 
	public void testFindOne() {
		assertEquals(productDao.findOne(1L).getName(), "Lamp");
		assertEquals(productDao.findOne("Lamp").getName(), "Lamp");
	}
	
	@Test
	public void testFindAll() {

		List<Product> products = productDao.findAll();

		assertEquals(products.size(), 3);
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
			assertEquals(p.getPrice(), 200.12);
		}

	}

}

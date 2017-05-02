package my.mycompany.myapp.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import my.mycompany.myapp.domain.Product;
import my.mycompany.myapp.service.IProductsService;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(InventoryController.class)
public class InventoryControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IProductsService productsService;
	
	@Test
	public void inventory() throws Exception {
		List<Product> list = new ArrayList<Product>();		
		given(productsService.findAllProducts()).willReturn(list);
		
		this.mvc.perform(get("/inventory"))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/inventory/products.jsp"));
	}
}

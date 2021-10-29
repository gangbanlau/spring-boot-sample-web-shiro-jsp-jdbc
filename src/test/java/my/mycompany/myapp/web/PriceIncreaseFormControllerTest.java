package my.mycompany.myapp.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.*;

import my.mycompany.myapp.service.IProductsService;


@WebMvcTest(PriceIncreaseFormController.class)
public class PriceIncreaseFormControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IProductsService productsService;
	
	@Test
	public void test() throws Exception {
		doNothing().when(productsService).increasePrice(anyInt());
		
		this.mvc.perform(post("/inventory/priceincrease").param("percentage", "100"))
			.andExpect(redirectedUrl("/inventory"));		
	}
	
	@Test
	public void percentageRange() throws Exception {
		doNothing().when(productsService).increasePrice(anyInt());
		
		this.mvc.perform(post("/inventory/priceincrease").param("percentage", "10000"))
			.andExpect(redirectedUrl("/error"));		
	}
	
}

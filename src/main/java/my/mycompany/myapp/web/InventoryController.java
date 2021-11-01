package my.mycompany.myapp.web;

import java.util.Locale;

import my.mycompany.myapp.service.IProductsService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InventoryController {
	@Autowired
	private IProductsService productsService;

	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	@RequiresPermissions("product:query")
	public String inventory(Locale locale, Model model) {
		
		String now = (new java.util.Date()).toString();
		
		model.addAttribute("now", now);
		model.addAttribute("products", productsService.findAllProducts());

		return "inventory/products";
	}
}
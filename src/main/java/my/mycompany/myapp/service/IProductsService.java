package my.mycompany.myapp.service;

import java.util.List;

import my.mycompany.myapp.domain.Product;

public interface IProductsService {

    public void increasePrice(int percentage);
    
    public List<Product> findAllProducts();
    
    public Product findOneProduct(Long id);
    
    public Product insertProduct(Product prod);
    
    public void deleteProduct(Long id);
    
}
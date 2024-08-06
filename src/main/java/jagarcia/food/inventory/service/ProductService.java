package jagarcia.food.inventory.service;

import jagarcia.food.inventory.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllPoducts();
    public Product findProductById(Long id);
    public Product saveProduct(Product product);
    public void deleteProduct(Product product);
}

package jagarcia.food.inventory.service.impl;

import jagarcia.food.inventory.entity.Product;
import jagarcia.food.inventory.repository.ProductRepository;
import jagarcia.food.inventory.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService  {
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllPoducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);

        return product;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);

    }
}

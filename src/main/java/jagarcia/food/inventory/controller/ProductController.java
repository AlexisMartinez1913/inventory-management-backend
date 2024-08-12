package jagarcia.food.inventory.controller;

import jagarcia.food.inventory.entity.Product;
import jagarcia.food.inventory.exception.ResourceNotFound;
import jagarcia.food.inventory.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fi-app")
@CrossOrigin(value = "http://localhost:5173")
public class ProductController {
    private static  final Logger logger =
            LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        var products = productService.getAllPoducts();
        products.forEach((product -> logger.info(product.toString())));
        return products;
    }
    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) {
        logger.info("Product to save: " + product);
        return productService.saveProduct(product);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productService.findProductById(id);
        if (product == null) {
            throw new ResourceNotFound("Id not found" + id);
        }
            return ResponseEntity.ok(product);

    }

    @PutMapping("products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        logger.info("Product to update: " + product);
        Product updatedProduct = productService.findProductById(id);
        if (updatedProduct == null) {
            throw new ResourceNotFound("Product with Id not found" + id);
        }
        updatedProduct.setName(product.getName());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setCategory(product.getCategory());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setStock(product.getStock());
        productService.saveProduct(updatedProduct);

        return ResponseEntity.ok(updatedProduct);
    }
}

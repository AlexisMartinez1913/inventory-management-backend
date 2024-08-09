package jagarcia.food.inventory.controller;

import jagarcia.food.inventory.entity.Product;
import jagarcia.food.inventory.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

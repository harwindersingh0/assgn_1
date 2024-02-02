// Controller.java
package com.example.assignment.controller;

import com.example.assignment.entity.Product;
import com.example.assignment.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class Controller {

    @Autowired
    private ProductService productService;

    // Create a new Product
    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Retrieve all Products
    @GetMapping("/all")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    // Retrieve a specific product by ID
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable int productId) {
        return productService.findById(productId);
    }

    // Update an existing product
    @PutMapping("/update/{productId}")
    public Product updateProduct(@PathVariable int productId, @RequestBody Product updatedProduct) {
        return productService.updateProduct(productId, updatedProduct);
    }

    // Delete a product by ID
    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return "Product with id " + productId + " has been deleted.";
    }
}

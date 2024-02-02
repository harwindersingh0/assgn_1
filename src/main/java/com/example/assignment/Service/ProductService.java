// ProductService.java
package com.example.assignment.Service;

import com.example.assignment.Repository.ProductRepository;
import com.example.assignment.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product updateProduct(int productId, Product updatedProduct) {
        Product existingProduct = findById(productId);

        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setDetail(updatedProduct.getDetail());
            // Adjust for the actual fields in your Product class
            return productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found with id: " + productId);
        }
    }

    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }
}

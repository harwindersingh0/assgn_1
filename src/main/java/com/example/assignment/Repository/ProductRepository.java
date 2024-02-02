// ProductRepository.java
package com.example.assignment.Repository;

import com.example.assignment.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> list = new ArrayList<>();

    public List<Product> findAll() {
        return list;
    }

    public Product findById(int id) {
        for (Product p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public Product save(Product product) {
        Product p = new Product();
        p.setId(product.getId());
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setDetail(product.getDetail());
        list.add(p);
        return p;
    }

    public void deleteById(int productId) {
    }
}

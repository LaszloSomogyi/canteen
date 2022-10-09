package com.example.canteen.service;

import com.example.canteen.exceptions.ProductNotFoundException;
import com.example.canteen.model.Product;
import com.example.canteen.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product findById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Non-existent product!"));
    }

}

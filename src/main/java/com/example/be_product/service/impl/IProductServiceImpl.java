package com.example.be_product.service.impl;

import com.example.be_product.model.Category;
import com.example.be_product.model.Product;
import com.example.be_product.repository.ICategoryRepository;
import com.example.be_product.repository.IProductRepository;
import com.example.be_product.service.my_interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Product> showAll() {
        return productRepository.showAllProduct();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void removeById(Long id) {
        productRepository.removeProductById(id);
    }

    @Override
    public List<Category> showAllCategory() {
        return categoryRepository.findAll();
    }
}

package com.rvs.emarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rvs.emarket.entity.Product;
import com.rvs.emarket.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
            this.repository= repository;
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Optional<Product> findById(Long id){
        return repository.findById(id);
    }

    public Product save(Product product){
        return repository.save(product);
    }

    public void deleteById (Long id){
        repository.deleteById(id);
    }    


}

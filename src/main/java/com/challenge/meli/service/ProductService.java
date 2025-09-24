package com.challenge.meli.service;

import com.challenge.meli.converter.ProductConverter;
import com.challenge.meli.model.Product;
import com.challenge.meli.model.ProductEntity;
import com.challenge.meli.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductConverter converter;
    private final ProductRepository repository;

    public List<Product> getAllProducts() {

        List<ProductEntity> productList =  repository.findAll();
        return productList.stream().map(converter::convert).toList();
    }
}

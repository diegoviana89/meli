package com.challenge.meli.infraestructure.adapter.out.persistence;

import com.challenge.meli.domain.model.Product;
import com.challenge.meli.domain.ports.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ProductJpaAdapter implements ProductRepositoryPort {

    private final ProductJpaRepository productJpaRepository;


    @Override
    public List<Product> getAll() {
        List<ProductEntityJpa> result =  productJpaRepository.findAll();
        return result.stream().map(ProductEntityJpa::toProduct).toList();
    }

    @Override
    public List<Product> getAllById(List<UUID> productId) {

        List<ProductEntityJpa> result =  productJpaRepository.findAllById(productId);
        return result.stream().map(ProductEntityJpa::toProduct).toList();
    }
}

package com.challenge.meli.domain.service;

import com.challenge.meli.domain.dto.ProductDomainResponseDto;
import com.challenge.meli.domain.mapper.ProductMapper;
import com.challenge.meli.domain.model.Product;
import com.challenge.meli.domain.ports.in.CompareProducts;
import com.challenge.meli.domain.ports.out.ProductRepositoryPort;
import com.challenge.meli.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompareProductsService implements CompareProducts {

    private final ProductRepositoryPort productRepositoryPort;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDomainResponseDto> compare(List<UUID> productId) {
        List<Product> products = productRepositoryPort.getAllById(productId);
        List<ProductDomainResponseDto> productResponse = new ArrayList<>();

        if(!products.isEmpty()){
            //Mapper to avoid send a Model entity to external layers.
            products.forEach(product -> {
                productResponse.add(productMapper.productToToResponseDto(product));
            });
        }else {
            throw new NotFoundException("No products found");
        }

        return productResponse;
    }
}

package com.challenge.meli.domain.service;

import com.challenge.meli.domain.dto.ProductDomainResponseDto;
import com.challenge.meli.domain.mapper.ProductMapper;
import com.challenge.meli.domain.model.Product;
import com.challenge.meli.domain.ports.in.GetProductPort;
import com.challenge.meli.domain.ports.out.ProductRepositoryPort;
import com.challenge.meli.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class GetProductService implements GetProductPort {

    private final ProductRepositoryPort productRepositoryPort;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDomainResponseDto> getAllProducts() {

        List<ProductDomainResponseDto> productResponse = new ArrayList<>();
        List<Product> products = productRepositoryPort.getAll();

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
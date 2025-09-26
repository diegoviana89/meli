package com.challenge.meli.domain.mapper;

import com.challenge.meli.domain.dto.ProductDomainResponseDto;
import com.challenge.meli.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDomainResponseDto productToToResponseDto(Product source){

        return ProductDomainResponseDto.builder()
                .id(source.getId())
                .name(source.getName())
                .price(source.getPrice())
                .rating(source.getRating())
                .specifications(source.getSpecifications())
                .build();
    }

}

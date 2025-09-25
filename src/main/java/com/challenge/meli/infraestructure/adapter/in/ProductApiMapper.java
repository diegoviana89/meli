package com.challenge.meli.infraestructure.adapter.in;

import com.challenge.meli.domain.dto.ProductDomainResponseDto;
import com.challenge.meli.infraestructure.adapter.in.dto.ApiResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductApiMapper implements Converter<ProductDomainResponseDto, ApiResponseDto> {
    @Override
    public ApiResponseDto convert(ProductDomainResponseDto source) {
        return ApiResponseDto.builder()
                .id(source.getId())
                .name(source.getName())
                .price(source.getPrice())
                .description(source.getDescription())
                .imageUrl(source.getImageUrl())
                .rating(source.getRating())
                .specifications(source.getSpecifications())
                .build();
    }
}

package com.challenge.meli.domain.ports.in;

import com.challenge.meli.domain.dto.ProductDomainResponseDto;

import java.util.List;

public interface GetProductPort {

    List<ProductDomainResponseDto> getAllProducts();

}

package com.challenge.meli.domain.ports.in;

import com.challenge.meli.domain.dto.ProductDomainResponseDto;

import java.util.List;
import java.util.UUID;

public interface CompareProducts {

    List<ProductDomainResponseDto> compare(List<UUID> productId);

}

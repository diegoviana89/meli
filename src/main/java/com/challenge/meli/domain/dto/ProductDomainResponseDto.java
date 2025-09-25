package com.challenge.meli.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class ProductDomainResponseDto {

    private UUID id;
    private String name;
    private String imageUrl;
    private String description;
    private float price;
    private int rating;
    private String specifications;
}

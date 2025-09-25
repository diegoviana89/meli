package com.challenge.meli.infraestructure.adapter.in.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ApiResponseDto {

    private UUID id;
    private String name;
    private String imageUrl;
    private String description;
    private float price;
    private int rating;
    private String specifications;
}

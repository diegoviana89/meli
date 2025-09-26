package com.challenge.meli.infraestructure.adapter.in.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiRequestDto {

    private String name;
    private String imageUrl;
    private String description;
    private float price;
    private int rating;
    private String specifications;
}

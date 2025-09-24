package com.challenge.meli.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class RequestDto {

    private UUID id;
    private String name;
    private String imageUrl;
    private String description;
    private float price;
    private int rating;
    private String specifications;
}

package com.challenge.meli.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    private UUID id;
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    private String description;
    private float price;
    private int rating;
    private String specifications;
}

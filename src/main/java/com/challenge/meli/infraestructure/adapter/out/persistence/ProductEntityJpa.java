package com.challenge.meli.infraestructure.adapter.out.persistence;

import com.challenge.meli.domain.model.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntityJpa {

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

    public Product toProduct() {
        return new Product(
            this.id,
            this.name,
            this.imageUrl,
            this.description,
            this.price,
            this.rating,
            this.specifications
        );
    }
}

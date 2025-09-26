package com.challenge.meli.domain.ports.out;

import com.challenge.meli.domain.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepositoryPort {

    List<Product> getAll();
    List<Product> getAllById(List<UUID> productId);

}

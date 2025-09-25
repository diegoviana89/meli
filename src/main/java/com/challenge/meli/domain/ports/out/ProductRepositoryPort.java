package com.challenge.meli.domain.ports.out;

import com.challenge.meli.domain.model.Product;

import java.util.List;

public interface ProductRepositoryPort {

    List<Product> getAll();
}

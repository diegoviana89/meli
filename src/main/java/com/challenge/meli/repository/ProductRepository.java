package com.challenge.meli.repository;

import com.challenge.meli.infraestructure.adapter.out.persistence.ProductEntityJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntityJpa, UUID> {
}

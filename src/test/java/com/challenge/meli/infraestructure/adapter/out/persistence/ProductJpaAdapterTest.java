package com.challenge.meli.infraestructure.adapter.out.persistence;

import com.challenge.meli.domain.model.Product;
import com.challenge.meli.infraestructure.adapter.out.persistence.ProductJpaAdapter;
import com.challenge.meli.infraestructure.adapter.out.persistence.ProductJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductJpaAdapterTest {

    @Mock
    private ProductJpaRepository productJpaRepository;

    @InjectMocks
    private ProductJpaAdapter productJpaAdapter;

    @Test
    void getAll_ShouldReturnListOfProducts() {
        // Arrange
        UUID productId1 = UUID.randomUUID();
        UUID productId2 = UUID.randomUUID();
        
        // Create mock ProductEntityJpa instances
        ProductEntityJpa entity1 = mock(ProductEntityJpa.class);
        
        ProductEntityJpa entity2 = mock(ProductEntityJpa.class);
        
        // Create expected Product instances
        Product product1 = new Product();
        product1.setId(productId1);
        product1.setName("Test Product 1");
        
        Product product2 = new Product();
        product2.setId(productId2);
        product2.setName("Test Product 2");
        
        // Mock the repository and entity behavior
        when(productJpaRepository.findAll()).thenReturn(Arrays.asList(entity1, entity2));
        when(entity1.toProduct()).thenReturn(product1);
        when(entity2.toProduct()).thenReturn(product2);

        // Act
        List<Product> result = productJpaAdapter.getAll();

        // Assert
        assertNotNull(result, "Result should not be null");
        assertEquals(2, result.size(), "Should return 2 products");
        assertEquals("Test Product 1", result.get(0).getName(), "First product name should match");
        assertEquals("Test Product 2", result.get(1).getName(), "Second product name should match");
        
        // Verify interactions
        verify(productJpaRepository, times(1)).findAll();
        verify(entity1, times(1)).toProduct();
        verify(entity2, times(1)).toProduct();
    }
}

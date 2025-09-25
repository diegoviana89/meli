package com.challenge.meli.domain.service;

import com.challenge.meli.domain.dto.ProductDomainResponseDto;
import com.challenge.meli.domain.mapper.ProductMapper;
import com.challenge.meli.domain.model.Product;
import com.challenge.meli.domain.ports.out.ProductRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetProductServiceTest {

    @Mock
    private ProductRepositoryPort productRepositoryPort;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private GetProductService getProductService;

    @Test
    void getAllProducts_ShouldReturnListOfProducts() {
        // Arrange
        UUID productId1 = UUID.randomUUID();
        UUID productId2 = UUID.randomUUID();
        
        Product product1 = new Product();
        product1.setId(productId1);
        product1.setName("Test Product 1");
        
        Product product2 = new Product();
        product2.setId(productId2);
        product2.setName("Test Product 2");
        
        ProductDomainResponseDto dto1 = ProductDomainResponseDto.builder()
                .id(productId1)
                .name("Test Product 1")
                .build();
                
        ProductDomainResponseDto dto2 = ProductDomainResponseDto.builder()
                .id(productId2)
                .name("Test Product 2")
                .build();

        when(productRepositoryPort.getAll()).thenReturn(Arrays.asList(product1, product2));
        when(productMapper.productToToResponseDto(product1)).thenReturn(dto1);
        when(productMapper.productToToResponseDto(product2)).thenReturn(dto2);

        // Act
        List<ProductDomainResponseDto> result = getProductService.getAllProducts();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Test Product 1", result.get(0).getName());
        assertEquals("Test Product 2", result.get(1).getName());
        
        verify(productRepositoryPort, times(1)).getAll();
        verify(productMapper, times(2)).productToToResponseDto(any(Product.class));
    }
}

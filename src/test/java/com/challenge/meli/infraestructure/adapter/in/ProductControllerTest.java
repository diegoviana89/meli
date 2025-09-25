package com.challenge.meli.infraestructure.adapter.in;

import com.challenge.meli.domain.dto.ProductDomainResponseDto;
import com.challenge.meli.domain.ports.in.GetProductPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GetProductPort productService;

    @Mock
    private ProductApiMapper productApiMapper;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void getAllProducts_ShouldReturnListOfProducts() throws Exception {
        // Arrange
        UUID productId1 = UUID.randomUUID();
        UUID productId2 = UUID.randomUUID();
        
        ProductDomainResponseDto product1 = ProductDomainResponseDto.builder()
                .id(productId1)
                .name("Test Product 1")
                .build();
                
        ProductDomainResponseDto product2 = ProductDomainResponseDto.builder()
                .id(productId2)
                .name("Test Product 2")
                .build();

        when(productService.getAllProducts()).thenReturn(Arrays.asList(product1, product2));

        // Act & Assert
        mockMvc.perform(get("/product")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}

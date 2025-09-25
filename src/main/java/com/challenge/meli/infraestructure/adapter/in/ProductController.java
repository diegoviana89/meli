package com.challenge.meli.infraestructure.adapter.in;


import com.challenge.meli.domain.dto.ProductDomainResponseDto;
import com.challenge.meli.domain.ports.in.GetProductPort;
import com.challenge.meli.infraestructure.adapter.in.dto.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    
    private final GetProductPort productService;
    private final ProductApiMapper productApiMapper;

    @GetMapping
    public ResponseEntity<List<ApiResponseDto>> getAllProducts() {

        List<ProductDomainResponseDto> response = productService.getAllProducts();

        List<ApiResponseDto> apiResponseDto = response.stream().map(productApiMapper::convert).toList();

        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}

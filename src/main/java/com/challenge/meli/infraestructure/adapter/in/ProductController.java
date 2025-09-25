package com.challenge.meli.infraestructure.adapter.in;

import com.challenge.meli.domain.dto.ProductDomainResponseDto;
import com.challenge.meli.domain.ports.in.GetProductPort;
import com.challenge.meli.infraestructure.adapter.in.dto.ApiResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing products.
 */
@RestController
@RequestMapping("/product")
@Tag(name = "Products", description = "APIs for managing products")
@RequiredArgsConstructor
public class ProductController {
    
    private final GetProductPort productService;
    private final ProductApiMapper productApiMapper;


    /**
     * Retrieves all available products.
     *
     * @return List of all products with their details
     */
    @Operation(
        summary = "Get all products",
        description = "Retrieves a list of all available products with their details"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved products",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                array = @ArraySchema(schema = @Schema(implementation = ApiResponseDto.class)),
                examples = @ExampleObject(
                    name = "Success",
                    value = "[{\"id\": 1, \"name\": \"Product 1\"}, {\"id\": 2, \"name\": \"Product 2\"}]"
                )
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(schema = @Schema(hidden = true))
        )
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApiResponseDto>> getAllProducts() {
        List<ProductDomainResponseDto> response = productService.getAllProducts();
        List<ApiResponseDto> apiResponseDto = response.stream()
            .map(productApiMapper::convert)
            .toList();
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}

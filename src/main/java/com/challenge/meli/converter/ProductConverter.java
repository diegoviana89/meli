package com.challenge.meli.converter;

import com.challenge.meli.model.Product;
import com.challenge.meli.model.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter implements Converter<ProductEntity, Product> {

    @Override
    public Product convert(ProductEntity source) {
        Product product = new Product();
        product.setId(source.getId());
        product.setName(source.getName());
        product.setDescription(source.getDescription());
        product.setPrice(source.getPrice());
        product.setRating(source.getRating());
        product.setSpecifications(source.getSpecifications());

        return product;
    }
}

package br.com.vicente.storecatalog.usecase;

import br.com.vicente.storecatalog.domain.ProductEntity;

import java.math.BigDecimal;

public record ProductDto(
        String id,
        String name,
        String description,
        BigDecimal salesPrice
) {

    public static ProductDto from(ProductEntity entity){
        return new ProductDto(entity.getId().getId(),entity.getName(), entity.getDescription(),entity.getSalesPrice());
    }
}

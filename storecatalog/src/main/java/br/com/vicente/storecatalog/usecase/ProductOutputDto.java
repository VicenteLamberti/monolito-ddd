package br.com.vicente.storecatalog.usecase;

import br.com.vicente.storecatalog.domain.ProductEntity;

import java.math.BigDecimal;

public record ProductOutputDto(
        String id,
        String name,
        String description,
        BigDecimal salesPrice
) {

    public static ProductOutputDto from(ProductEntity entity){
        return new ProductOutputDto(entity.getId().getId(),entity.getName(), entity.getDescription(),entity.getSalesPrice());
    }
}

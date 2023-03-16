package br.com.vicente.infrastructure.storecatalog.facade.product;

import br.com.vicente.storecatalog.usecase.ProductOutputDto;

import java.math.BigDecimal;

public record ProductOutputFacadeDto(
        String id,
        String name,
        String description,
        BigDecimal salesPrice
) {
    public static ProductOutputFacadeDto from(ProductOutputDto dto){
        return new ProductOutputFacadeDto(dto.id(),dto.name(), dto.description(),dto.salesPrice());
    }
}

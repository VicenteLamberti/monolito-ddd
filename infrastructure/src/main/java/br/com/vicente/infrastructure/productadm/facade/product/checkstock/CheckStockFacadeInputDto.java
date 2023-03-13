package br.com.vicente.infrastructure.productadm.facade.product.checkstock;

import br.com.vicente.shared.domain.valueobject.IdValueObject;

public record CheckStockFacadeInputDto(
        String productId
) {


    public static CheckStockFacadeInputDto from(IdValueObject id) {
        return new CheckStockFacadeInputDto(id.getId());
    }
}

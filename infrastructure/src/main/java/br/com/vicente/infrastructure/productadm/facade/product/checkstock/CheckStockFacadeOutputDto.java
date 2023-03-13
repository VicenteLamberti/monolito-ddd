package br.com.vicente.infrastructure.productadm.facade.product.checkstock;

import br.com.vicente.productadm.usecase.checkstock.CheckProductStockOutputDto;

public record CheckStockFacadeOutputDto(
        String productId,
        Integer stock
) {
    public static CheckStockFacadeOutputDto from(CheckProductStockOutputDto dto) {
        return new CheckStockFacadeOutputDto(dto.productId(),dto.stock());
    }
}

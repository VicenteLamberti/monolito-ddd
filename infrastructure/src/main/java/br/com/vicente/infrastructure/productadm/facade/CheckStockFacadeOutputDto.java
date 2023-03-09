package br.com.vicente.infrastructure.productadm.facade;

public record CheckStockFacadeOutputDto(
        String productId,
        Integer stock
) {
}

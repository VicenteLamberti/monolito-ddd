package br.com.vicente.productadm.usecase.checkstock;

public record CheckProductStockOutputDto(
        String productId,
        Integer stock
) {
}

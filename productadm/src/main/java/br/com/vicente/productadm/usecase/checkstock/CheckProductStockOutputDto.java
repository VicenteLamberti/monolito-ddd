package br.com.vicente.productadm.usecase.checkstock;

public record CheckProductStockOutputDto(
        String id,
        Integer stock
) {
}

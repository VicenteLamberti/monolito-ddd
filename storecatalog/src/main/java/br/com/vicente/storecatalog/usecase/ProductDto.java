package br.com.vicente.storecatalog.usecase;

import java.math.BigDecimal;

public record ProductDto(
        String id,
        String name,
        String description,
        BigDecimal salesPrice
) {
}

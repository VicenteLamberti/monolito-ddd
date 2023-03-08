package br.com.vicente.productadm.usecase.addproduct;

import java.math.BigDecimal;
import java.time.Instant;

public record AddProductOutputDto(
        String id,
        String name,
        String description,
        BigDecimal purchasePrice,
        Integer stock,
        Instant createdAt,
        Instant updatedAt
){
}

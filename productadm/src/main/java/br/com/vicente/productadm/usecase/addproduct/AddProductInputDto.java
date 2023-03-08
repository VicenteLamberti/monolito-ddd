package br.com.vicente.productadm.usecase.addproduct;

import java.math.BigDecimal;

public record AddProductInputDto (
        String name,
        String description,
        BigDecimal purchasePrice,
        Integer stock
){

}

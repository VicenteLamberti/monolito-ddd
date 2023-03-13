package br.com.vicente.infrastructure.productadm.facade.product.addproduct;

import br.com.vicente.productadm.domain.ProductEntity;

import java.math.BigDecimal;

public record AddProductFacadeInputDto(
        String id,
        String name,
        String description,
        BigDecimal purchasePrice,
        Integer stock

) {

    public static AddProductFacadeInputDto from(ProductEntity product){
        return new AddProductFacadeInputDto(
          product.getId().getId(),
          product.getName(),
          product.getDescription(),
          product.getPurchasePrice(),
          product.getStock()
        );

    }





}

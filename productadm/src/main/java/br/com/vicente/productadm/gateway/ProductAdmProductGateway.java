package br.com.vicente.productadm.gateway;

import br.com.vicente.productadm.domain.ProductEntity;

import java.util.Optional;

public interface ProductAdmProductGateway {
    void add(ProductEntity productEntity);
    Optional<ProductEntity> findById(String id);
}

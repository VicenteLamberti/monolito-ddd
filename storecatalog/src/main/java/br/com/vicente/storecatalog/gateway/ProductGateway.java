package br.com.vicente.storecatalog.gateway;

import br.com.vicente.storecatalog.domain.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductGateway {
    List<ProductEntity> findAll();
    Optional<ProductEntity> find(String id);
}

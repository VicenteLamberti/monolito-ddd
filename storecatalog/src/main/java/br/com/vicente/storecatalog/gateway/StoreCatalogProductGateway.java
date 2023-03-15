package br.com.vicente.storecatalog.gateway;

import br.com.vicente.storecatalog.domain.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface StoreCatalogProductGateway {
    List<ProductEntity> findAll();
    Optional<ProductEntity> find(String id);
}

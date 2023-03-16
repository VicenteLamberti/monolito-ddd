package br.com.vicente.infrastructure.storecatalog.facade.product;

import br.com.vicente.infrastructure.storecatalog.facade.product.ProductOutputFacadeDto;

import java.util.List;
import java.util.Optional;

public interface StoreCatalogFacade {
    Optional<ProductOutputFacadeDto> find(String id);

    List<ProductOutputFacadeDto> findAll();
}

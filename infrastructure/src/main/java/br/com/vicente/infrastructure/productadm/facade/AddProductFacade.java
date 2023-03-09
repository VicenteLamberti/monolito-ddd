package br.com.vicente.infrastructure.productadm.facade;

import java.util.Optional;

public interface AddProductFacade {
    void addProduct(AddProductFacadeInputDto addProductFacadeDto);
    Optional<CheckStockFacadeOutputDto> checkStock(CheckStockFacadeInputDto checkStockFacadeInputDto);
}

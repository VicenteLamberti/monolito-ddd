package br.com.vicente.infrastructure.productadm.facade.product;

import br.com.vicente.infrastructure.productadm.facade.product.addproduct.AddProductFacadeInputDto;
import br.com.vicente.infrastructure.productadm.facade.product.checkstock.CheckStockFacadeInputDto;
import br.com.vicente.infrastructure.productadm.facade.product.checkstock.CheckStockFacadeOutputDto;

import java.util.Optional;

public interface ProductAdmFacade {
    void addProduct(AddProductFacadeInputDto addProductFacadeDto);
    Optional<CheckStockFacadeOutputDto> checkStock(CheckStockFacadeInputDto checkStockFacadeInputDto);
}

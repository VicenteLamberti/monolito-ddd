package br.com.vicente.storecatalog.usecase.findall;

import br.com.vicente.shared.usecase.UseCaseOutInteface;
import br.com.vicente.storecatalog.domain.ProductEntity;
import br.com.vicente.storecatalog.gateway.StoreCatalogProductGateway;

import java.util.List;

public class FindAllProductsUseCase implements UseCaseOutInteface<FindAllProductsOutpurDto> {

    private final StoreCatalogProductGateway gateway;

    public FindAllProductsUseCase(final StoreCatalogProductGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public FindAllProductsOutpurDto execute() {
        List<ProductEntity> products = gateway.findAll();
        return FindAllProductsOutpurDto.from(products);


    }
}

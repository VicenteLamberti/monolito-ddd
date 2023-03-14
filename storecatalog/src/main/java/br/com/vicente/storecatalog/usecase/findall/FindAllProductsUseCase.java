package br.com.vicente.storecatalog.usecase.findall;

import br.com.vicente.shared.usecase.UseCaseOutInteface;
import br.com.vicente.storecatalog.domain.ProductEntity;
import br.com.vicente.storecatalog.gateway.ProductGateway;

import java.util.List;

public class FindAllProductsUseCase implements UseCaseOutInteface<FindAllProductsDto> {

    private final ProductGateway gateway;

    public FindAllProductsUseCase(final ProductGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public FindAllProductsDto execute() {
        List<ProductEntity> products = gateway.findAll();
        return FindAllProductsDto.from(products);


    }
}

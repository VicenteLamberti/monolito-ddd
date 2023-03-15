package br.com.vicente.storecatalog.usecase.find;

import br.com.vicente.shared.usecase.UseCaseInOutInteface;
import br.com.vicente.storecatalog.gateway.StoreCatalogProductGateway;
import br.com.vicente.storecatalog.usecase.ProductDto;

public class FindProductUseCase implements UseCaseInOutInteface<String, ProductDto> {

    private final StoreCatalogProductGateway gateway;

    public FindProductUseCase(final StoreCatalogProductGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public ProductDto execute(String id) {
        return gateway.find(id).map(ProductDto::from).orElseThrow(
                ()->new RuntimeException("Não encontrado"));

    }
}

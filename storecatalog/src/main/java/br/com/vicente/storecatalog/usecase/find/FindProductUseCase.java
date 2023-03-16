package br.com.vicente.storecatalog.usecase.find;

import br.com.vicente.shared.usecase.UseCaseInOutInteface;
import br.com.vicente.storecatalog.gateway.StoreCatalogProductGateway;
import br.com.vicente.storecatalog.usecase.ProductOutputDto;

public class FindProductUseCase implements UseCaseInOutInteface<String, ProductOutputDto> {

    private final StoreCatalogProductGateway gateway;

    public FindProductUseCase(final StoreCatalogProductGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public ProductOutputDto execute(String id) {
        return gateway.find(id).map(ProductOutputDto::from).orElseThrow(
                ()->new RuntimeException("Não encontrado"));

    }
}

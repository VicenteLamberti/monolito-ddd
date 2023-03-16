package br.com.vicente.infrastructure.storecatalog.facade.product;

import br.com.vicente.shared.usecase.UseCaseInOutInteface;
import br.com.vicente.shared.usecase.UseCaseOutInteface;
import br.com.vicente.storecatalog.usecase.ProductOutputDto;

import java.util.List;
import java.util.Optional;

public class StoreCatalogFacadeImpl implements StoreCatalogFacade{

    private final UseCaseInOutInteface findUseCase;
    private final UseCaseOutInteface findAllUseCase;

    public StoreCatalogFacadeImpl(UseCaseInOutInteface findUseCase, UseCaseOutInteface findAllUseCase) {
        this.findUseCase = findUseCase;
        this.findAllUseCase = findAllUseCase;
    }

    @Override
    public Optional<ProductOutputFacadeDto> find(String id) {

        ProductOutputDto outputDto = (ProductOutputDto) this.findUseCase.execute(id);
        ProductOutputFacadeDto facadeDto = ProductOutputFacadeDto.from(outputDto);
        return Optional.of(facadeDto);

    }

    @Override
    public List<ProductOutputFacadeDto> findAll() {
        List<ProductOutputDto> outputDto = (List<ProductOutputDto>) this.findAllUseCase.execute();
        List<ProductOutputFacadeDto> productOutputFacadeDtos = outputDto.stream().map(ProductOutputFacadeDto::from).toList();
        return productOutputFacadeDtos;
    }
}

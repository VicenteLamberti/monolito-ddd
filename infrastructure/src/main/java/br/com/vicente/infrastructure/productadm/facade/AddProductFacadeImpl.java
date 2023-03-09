package br.com.vicente.infrastructure.productadm.facade;

import br.com.vicente.productadm.usecase.addproduct.AddProductInputDto;
import br.com.vicente.shared.usecase.UseCaseInteface;

import java.util.Optional;

public class AddProductFacadeImpl implements AddProductFacade{

    private final UseCaseInteface addUseCase;
    private final  UseCaseInteface checkStockUseCase;

    public AddProductFacadeImpl(UseCaseInteface addUseCase,UseCaseInteface checkStockUseCase) {
        this.addUseCase = addUseCase;
        this.checkStockUseCase = checkStockUseCase;

    }

    @Override
    public void addProduct(AddProductFacadeInputDto input) {
        AddProductInputDto inputCorrect = new AddProductInputDto(
                input.name(),
                input.description(),
                input.purchasePrice(),
                input.stock()
        );
       this.addUseCase.execute(inputCorrect);

    }

    @Override
    public Optional<CheckStockFacadeOutputDto> checkStock(CheckStockFacadeInputDto input) {
        return null;
    }
}

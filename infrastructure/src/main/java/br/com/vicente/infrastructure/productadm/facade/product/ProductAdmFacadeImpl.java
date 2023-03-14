package br.com.vicente.infrastructure.productadm.facade.product;

import br.com.vicente.infrastructure.productadm.facade.product.addproduct.AddProductFacadeInputDto;
import br.com.vicente.infrastructure.productadm.facade.product.checkstock.CheckStockFacadeInputDto;
import br.com.vicente.infrastructure.productadm.facade.product.checkstock.CheckStockFacadeOutputDto;
import br.com.vicente.productadm.usecase.addproduct.AddProductInputDto;
import br.com.vicente.productadm.usecase.checkstock.CheckProductStockInputDto;
import br.com.vicente.productadm.usecase.checkstock.CheckProductStockOutputDto;
import br.com.vicente.shared.usecase.UseCaseInOutInteface;

import java.util.Optional;

public class ProductAdmFacadeImpl implements ProductAdmFacade {

    private final UseCaseInOutInteface addUseCase;
    private final UseCaseInOutInteface checkStockUseCase;

    public ProductAdmFacadeImpl(UseCaseInOutInteface addUseCase, UseCaseInOutInteface checkStockUseCase) {
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
        CheckProductStockInputDto inputDto = new CheckProductStockInputDto(input.productId());

        CheckProductStockOutputDto dto = (CheckProductStockOutputDto) this.checkStockUseCase.execute(inputDto);
        return Optional.of(CheckStockFacadeOutputDto.from(dto));
    }
}

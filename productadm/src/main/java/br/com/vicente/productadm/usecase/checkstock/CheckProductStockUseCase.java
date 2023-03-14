package br.com.vicente.productadm.usecase.checkstock;

import br.com.vicente.productadm.domain.ProductEntity;
import br.com.vicente.productadm.gateway.ProductGateway;
import br.com.vicente.shared.usecase.UseCaseInOutInteface;

import java.util.Objects;

public class CheckProductStockUseCase implements UseCaseInOutInteface<CheckProductStockInputDto,CheckProductStockOutputDto> {
    private final ProductGateway gateway;

    public CheckProductStockUseCase(final ProductGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    @Override
    public CheckProductStockOutputDto execute(CheckProductStockInputDto checkProductStockInputDto) {
        String id = checkProductStockInputDto.id();
        ProductEntity product = this.gateway.findById(id).get();

        CheckProductStockOutputDto output = new CheckProductStockOutputDto(
                product.getId().getId(),
                product.getStock()
        );
        return output;

    }
}

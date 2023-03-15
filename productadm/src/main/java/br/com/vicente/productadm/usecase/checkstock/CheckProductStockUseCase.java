package br.com.vicente.productadm.usecase.checkstock;

import br.com.vicente.productadm.domain.ProductEntity;
import br.com.vicente.productadm.gateway.ProductAdmProductGateway;
import br.com.vicente.shared.usecase.UseCaseInOutInteface;

import java.util.Objects;

public class CheckProductStockUseCase implements UseCaseInOutInteface<CheckProductStockInputDto,CheckProductStockOutputDto> {
    private final ProductAdmProductGateway gateway;

    public CheckProductStockUseCase(final ProductAdmProductGateway gateway) {
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

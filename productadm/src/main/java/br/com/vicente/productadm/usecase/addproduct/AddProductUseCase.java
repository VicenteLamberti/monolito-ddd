package br.com.vicente.productadm.usecase.addproduct;

import br.com.vicente.productadm.domain.ProductEntity;
import br.com.vicente.productadm.gateway.ProductAdmProductGateway;
import br.com.vicente.shared.usecase.UseCaseInOutInteface;

import java.math.BigDecimal;
import java.util.Objects;

public class AddProductUseCase implements UseCaseInOutInteface<AddProductInputDto,AddProductOutputDto> {

    private final ProductAdmProductGateway gateway;

    public AddProductUseCase(final ProductAdmProductGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    public AddProductOutputDto execute(AddProductInputDto dto){
        String name = dto.name();
        String description = dto.description();
        BigDecimal purchasePrice = dto.purchasePrice();
        Integer stock = dto.stock();


        ProductEntity product = ProductEntity.newProductEntity(name,description,purchasePrice,stock);

        this.gateway.add(product);

        AddProductOutputDto output = new AddProductOutputDto(
          product.getId().getId(),
          product.getName(),
          product.getDescription(),
          product.getPurchasePrice(),
          product.getStock(),
          product.getCreatedAt(),
          product.getUpdatedAt()
        );
        return output;



    }
}

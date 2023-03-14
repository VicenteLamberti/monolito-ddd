package br.com.vicente.infrastructure.configuration.usecase;

import br.com.vicente.productadm.gateway.ProductGateway;
import br.com.vicente.productadm.usecase.addproduct.AddProductUseCase;
import br.com.vicente.productadm.usecase.checkstock.CheckProductStockUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductAdmUseCaseConfiguration {

    private final ProductGateway productGateway;

    public ProductAdmUseCaseConfiguration(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Bean
    public AddProductUseCase addProductUseCase(){
        return new AddProductUseCase(productGateway);
    }

    @Bean
    public CheckProductStockUseCase checkProductStockUseCase(){
        return new CheckProductStockUseCase(productGateway);
    }

}

package br.com.vicente.infrastructure.configuration.usecase;

import br.com.vicente.productadm.gateway.ProductGateway;
import br.com.vicente.productadm.usecase.addproduct.AddProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductUseCaseConfiguration {

    private final ProductGateway productGateway;

    public ProductUseCaseConfiguration( ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Bean
    public AddProductUseCase addProductUseCase(){
        return new AddProductUseCase(productGateway);
    }

}

package br.com.vicente.infrastructure.configuration.usecase;

import br.com.vicente.productadm.gateway.ProductAdmProductGateway;
import br.com.vicente.productadm.usecase.addproduct.AddProductUseCase;
import br.com.vicente.productadm.usecase.checkstock.CheckProductStockUseCase;
import br.com.vicente.storecatalog.gateway.StoreCatalogProductGateway;
import br.com.vicente.storecatalog.usecase.find.FindProductUseCase;
import br.com.vicente.storecatalog.usecase.findall.FindAllProductsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class StoreCatalogUseCaseConfiguration {

    private final StoreCatalogProductGateway productGateway;

    public StoreCatalogUseCaseConfiguration( StoreCatalogProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Bean
    public FindAllProductsUseCase findAllProductsUseCase(){
        return new FindAllProductsUseCase(productGateway);
    }

    @Bean
    public FindProductUseCase findProductUseCase(){
        return new FindProductUseCase(productGateway);
    }



}

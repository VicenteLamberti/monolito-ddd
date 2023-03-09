package br.com.vicente.infrastructure.configuration.facede;

import br.com.vicente.infrastructure.productadm.facade.AddProductFacade;
import br.com.vicente.infrastructure.productadm.facade.AddProductFacadeImpl;
import br.com.vicente.productadm.gateway.ProductGateway;
import br.com.vicente.productadm.usecase.addproduct.AddProductUseCase;
import br.com.vicente.shared.usecase.UseCaseInteface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductFacadeConfiguration {

    private final UseCaseInteface addUseCase;
    private final UseCaseInteface checkStockUseCase;

    public ProductFacadeConfiguration(UseCaseInteface addUseCase,UseCaseInteface checkStockUseCase) {
        this.addUseCase = addUseCase;
        this.checkStockUseCase = checkStockUseCase;
    }

    @Bean
    public AddProductFacade addProductFacade(){

        return new AddProductFacadeImpl(addUseCase,checkStockUseCase);
    }

}

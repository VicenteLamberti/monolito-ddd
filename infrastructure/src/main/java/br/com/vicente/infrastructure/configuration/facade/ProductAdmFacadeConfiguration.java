package br.com.vicente.infrastructure.configuration.facade;

import br.com.vicente.infrastructure.productadm.facade.product.ProductAdmFacade;
import br.com.vicente.infrastructure.productadm.facade.product.ProductAdmFacadeImpl;
import br.com.vicente.productadm.usecase.addproduct.AddProductUseCase;
import br.com.vicente.productadm.usecase.checkstock.CheckProductStockUseCase;
import br.com.vicente.shared.usecase.UseCaseInOutInteface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductAdmFacadeConfiguration {

    private final UseCaseInOutInteface addUseCase;
    private final UseCaseInOutInteface checkStockUseCase;

    public ProductAdmFacadeConfiguration(AddProductUseCase addUseCase, CheckProductStockUseCase checkStockUseCase) {
        this.addUseCase = addUseCase;
        this.checkStockUseCase = checkStockUseCase;
    }

    @Bean
    public ProductAdmFacade addProductFacade(){

        return new ProductAdmFacadeImpl(addUseCase,checkStockUseCase);
    }



}

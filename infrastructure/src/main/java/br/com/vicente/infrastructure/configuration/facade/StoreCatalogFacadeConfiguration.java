package br.com.vicente.infrastructure.configuration.facade;

import br.com.vicente.infrastructure.productadm.facade.product.ProductAdmFacade;
import br.com.vicente.infrastructure.productadm.facade.product.ProductAdmFacadeImpl;
import br.com.vicente.infrastructure.storecatalog.facade.product.StoreCatalogFacade;
import br.com.vicente.infrastructure.storecatalog.facade.product.StoreCatalogFacadeImpl;
import br.com.vicente.productadm.usecase.addproduct.AddProductUseCase;
import br.com.vicente.productadm.usecase.checkstock.CheckProductStockUseCase;
import br.com.vicente.shared.usecase.UseCaseInOutInteface;
import br.com.vicente.shared.usecase.UseCaseOutInteface;
import br.com.vicente.storecatalog.usecase.find.FindProductUseCase;
import br.com.vicente.storecatalog.usecase.findall.FindAllProductsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreCatalogFacadeConfiguration {

    private final UseCaseInOutInteface findUseCase;
    private final UseCaseOutInteface findAllUseCase;

    public StoreCatalogFacadeConfiguration(FindProductUseCase findUseCase, FindAllProductsUseCase findAllUseCase) {
        this.findUseCase = findUseCase;
        this.findAllUseCase = findAllUseCase;
    }

    @Bean
    public StoreCatalogFacade storeCatalogFacade(){

        return new StoreCatalogFacadeImpl(findUseCase,findAllUseCase);
    }



}

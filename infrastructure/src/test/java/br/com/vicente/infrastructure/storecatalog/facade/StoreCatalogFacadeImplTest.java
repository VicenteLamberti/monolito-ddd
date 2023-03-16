package br.com.vicente.infrastructure.storecatalog.facade;

import br.com.vicente.infrastructure.CleanUpExtension;
import br.com.vicente.infrastructure.productadm.persistence.ProductAdmProductJPAEntity;
import br.com.vicente.infrastructure.productadm.persistence.ProductAdmProductRepository;
import br.com.vicente.infrastructure.storecatalog.facade.product.ProductOutputFacadeDto;
import br.com.vicente.infrastructure.storecatalog.facade.product.StoreCatalogFacadeImpl;
import br.com.vicente.infrastructure.storecatalog.persistence.StoreCatalogProductRepository;
import br.com.vicente.storecatalog.domain.ProductEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(CleanUpExtension.class)
@ComponentScan(includeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX,pattern = ".[FacadeImpl]")
})
@ActiveProfiles("test-integration")
@SpringBootTest
public class StoreCatalogFacadeImplTest {

    @Autowired
    private StoreCatalogFacadeImpl storeCatalogFacade;

    @Autowired
    private ProductAdmProductRepository repository;

    @Test
    public void givenAValidEntityPersisted_whenCallsFind_shouldReturnDto(){

        String expectedName = "Produto 1";
        String expectedDescription = "Descrição";
        BigDecimal expectedPrice = BigDecimal.TEN;
        Integer expectedStock  = 5;
        br.com.vicente.productadm.domain.ProductEntity product = br.com.vicente.productadm.domain.ProductEntity.newProductEntity(expectedName,expectedDescription,expectedPrice,expectedStock);

        String expectedId = product.getId().getId();

        String expectedName2 = "Produto 2";
        String expectedDescription2 = "Descrição2";
        BigDecimal expectedPrice2 = BigDecimal.valueOf(5);
        Integer expectedStock2  = 6;
        br.com.vicente.productadm.domain.ProductEntity product2 = br.com.vicente.productadm.domain.ProductEntity.newProductEntity(expectedName2,expectedDescription2,expectedPrice2,expectedStock2);



        Assertions.assertEquals(0, repository.count());
        ProductAdmProductJPAEntity entity1 = ProductAdmProductJPAEntity.from(product);
        ProductAdmProductJPAEntity entity2 = ProductAdmProductJPAEntity.from(product2);
        repository.saveAllAndFlush(List.of(entity1,entity2));


        ProductOutputFacadeDto result = storeCatalogFacade.find(expectedId).get();

        Assertions.assertEquals(expectedId,result.id());
    }
}

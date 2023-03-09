package br.com.vicente.infrastructure.productadm.facade;

import br.com.vicente.infrastructure.CleanUpExtension;
import br.com.vicente.infrastructure.productadm.persistence.ProductGatewayImpl;
import br.com.vicente.infrastructure.productadm.persistence.ProductRepository;
import br.com.vicente.productadm.domain.ProductEntity;
import br.com.vicente.shared.usecase.UseCaseInteface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(CleanUpExtension.class)
@ComponentScan(includeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX,pattern = ".[FacadeImpl]")
})
@ActiveProfiles("test-integration")
@SpringBootTest
public class AddProductFacadeImplTest {


    @Autowired
    private AddProductFacadeImpl addProductFacadeImpl;

    @Autowired
    private ProductRepository productRepository;


    @Test
    public void givenAValidEntity_whenCallAddProduct_shouldAddProduct(){
        String expectedName = "Produto 1";
        String expectedDescription = "Descrição";
        BigDecimal expectedPrice = BigDecimal.TEN;
        Integer expectedStock  = 5;
        ProductEntity product = ProductEntity.newProductEntity(expectedName,expectedDescription,expectedPrice,expectedStock);


        Assertions.assertEquals(0, productRepository.count());
        addProductFacadeImpl.addProduct(AddProductFacadeInputDto.from(product));
        Assertions.assertEquals(1,productRepository.count());
    }

}

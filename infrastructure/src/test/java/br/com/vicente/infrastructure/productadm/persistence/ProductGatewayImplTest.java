package br.com.vicente.infrastructure.productadm.persistence;

import br.com.vicente.productadm.domain.ProductEntity;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.*;
import java.math.BigDecimal;

//@ExtendWith(MySQLCleanUpExtension.class)
@ComponentScan(includeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX,pattern = ".[GatewayImpl]")
})
@ActiveProfiles("test-integration")
@DataJpaTest
public class ProductGatewayImplTest {

    @Autowired
    private ProductGatewayImpl productGatewayImpl;

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
        productGatewayImpl.add(product);
        Assertions.assertEquals(1,productRepository.count());
    }
}

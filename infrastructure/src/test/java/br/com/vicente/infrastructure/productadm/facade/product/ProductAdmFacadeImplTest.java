package br.com.vicente.infrastructure.productadm.facade.product;

import br.com.vicente.infrastructure.CleanUpExtension;
import br.com.vicente.infrastructure.productadm.facade.product.addproduct.AddProductFacadeInputDto;
import br.com.vicente.infrastructure.productadm.facade.product.checkstock.CheckStockFacadeInputDto;
import br.com.vicente.infrastructure.productadm.facade.product.checkstock.CheckStockFacadeOutputDto;
import br.com.vicente.infrastructure.productadm.persistence.ProductAdmProductJPAEntity;
import br.com.vicente.infrastructure.productadm.persistence.ProductAdmProductRepository;
import br.com.vicente.productadm.domain.ProductEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@ExtendWith(CleanUpExtension.class)
@ComponentScan(includeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX,pattern = ".[FacadeImpl]")
})
@ActiveProfiles("test-integration")
@SpringBootTest
public class ProductAdmFacadeImplTest {


    @Autowired
    private ProductAdmFacadeImpl productAdmFacadeImpl;

    @Autowired
    private ProductAdmProductRepository productRepository;


    @Test
    public void givenAValidEntity_whenCallAddProduct_shouldAddProduct(){
        String expectedName = "Produto 1";
        String expectedDescription = "Descrição";
        BigDecimal expectedPrice = BigDecimal.TEN;
        Integer expectedStock  = 5;
        ProductEntity product = ProductEntity.newProductEntity(expectedName,expectedDescription,expectedPrice,expectedStock);


        Assertions.assertEquals(0, productRepository.count());
        productAdmFacadeImpl.addProduct(AddProductFacadeInputDto.from(product));
        Assertions.assertEquals(1,productRepository.count());
    }


    @Test
    public void givenAValidAPersistedProduct_whenCallsCheckStock_shouldReturnData(){
        String expectedName = "Produto 1";
        String expectedDescription = "Descrição";
        BigDecimal expectedPrice = BigDecimal.TEN;
        Integer expectedStock  = 5;
        ProductEntity product = ProductEntity.newProductEntity(expectedName,expectedDescription,expectedPrice,expectedStock);

        Assertions.assertEquals(0,productRepository.count());

        productRepository.saveAndFlush(ProductAdmProductJPAEntity.from(product));
        Assertions.assertEquals(1,productRepository.count());
        System.out.println(productRepository.count());


        CheckStockFacadeOutputDto output =  productAdmFacadeImpl.checkStock(CheckStockFacadeInputDto.from(product.getId())).get();

        Assertions.assertNotNull(output);




    }

}

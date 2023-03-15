package br.com.vicente.storecatalog.usecase.findall;

import br.com.vicente.shared.domain.valueobject.IdValueObject;
import br.com.vicente.storecatalog.domain.ProductEntity;
import br.com.vicente.storecatalog.gateway.StoreCatalogProductGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindAllProductsUseCaseTest {

    @InjectMocks
    private FindAllProductsUseCase useCase;

    @Mock
    private StoreCatalogProductGateway gateway;


    @Test
    public void  givenAValidEntitiesPersisted_whenCallsFindAll_shouldReturnAllProducts(){

        ProductEntity product1 = ProductEntity.newProductEntity(IdValueObject.from("123"),"Product 1", "Description 1", BigDecimal.TEN);
        ProductEntity product2 = ProductEntity.newProductEntity(IdValueObject.from("456"),"Product 2", "Description 2", BigDecimal.valueOf(5));

        Mockito.when(gateway.findAll()).thenReturn(List.of(product1,product2));

        FindAllProductsDto products = useCase.execute();
        Assertions.assertEquals(2, products.products().size());


    }


}
